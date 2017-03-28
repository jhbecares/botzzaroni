/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icaro.aplicaciones.recursos.comunicacionChat.imp.util;

import icaro.aplicaciones.recursos.comunicacionChat.imp.InterpreteMsgsIRC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InterruptedIOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.StringTokenizer;

/**
 *
 * @author FGarijo
 */
public class InputThread extends Thread {
	/**
	 * The InputThread reads lines from the IRC server and allows the PircBot to
	 * handle them.
	 *
	 * @param bot
	 *            An instance of the underlying PircBot.
	 * @param breader
	 *            The BufferedReader that reads lines from the server.
	 * @param bwriter
	 */
	private InterpreteMsgsIRC _interpreteMensajes = null;
	private BufferedReader _breader = null;
	private BufferedWriter _bwriter = null;

	public static final int MAX_LINE_LENGTH = 510;

	protected InputThread(InterpreteMsgsIRC intrpmsg, BufferedReader breader,
			BufferedWriter bwriter) {
		_interpreteMensajes = intrpmsg;
		_breader = breader;
		_bwriter = bwriter;
	}

	/**
	 * Sends a raw line to the IRC server as soon as possible, bypassing the
	 * outgoing message queue.
	 *
	 * @param line
	 *            The raw line to send to the IRC server.
	 */
	public void sendRawLine(String line) {
		if (line.length() > (_interpreteMensajes.getMaxLineLength() - 2)) {
			line = line
					.substring(0, _interpreteMensajes.getMaxLineLength() - 2);
		}
		synchronized (_bwriter) {
			try {
				_bwriter.write(line + "\r\n");
				_bwriter.flush();
				_interpreteMensajes.log(">>>" + line);
			} catch (Exception e) {
				// Silent response - just lose the line.
			}
		}
	}

	/**
	 * Called to start this Thread reading lines from the IRC server. When a
	 * line is read, this method calls the handleLine method in the PircBot,
	 * which may subsequently call an 'onXxx' method in the PircBot subclass. If
	 * any subclass of Throwable (i.e. any Exception or Error) is thrown by your
	 * method, then this method will print the stack trace to the standard
	 * output. It is probable that the PircBot may still be functioning normally
	 * after such a problem, but the existance of any uncaught exceptions in
	 * your code is something you should really fix.
	 *
	 */
	@Override
	public void run() {
		boolean running = true;
		try {
			while (running) {
				try {
					String line = null;
					while ((line = _breader.readLine()) != null) {
						try {
							_interpreteMensajes.handleLine(line);
						} catch (Throwable t) {
							// Stick the whole stack trace into a String so we
							// can output it nicely.
							StringWriter sw = new StringWriter();
							PrintWriter pw = new PrintWriter(sw);
							t.printStackTrace(pw);
							pw.flush();
							StringTokenizer tokenizer = new StringTokenizer(
									sw.toString(), "\r\n");
							synchronized (_interpreteMensajes) {
								_interpreteMensajes
										.log("### Your implementation  is faulty and you have");
								_interpreteMensajes
										.log("### allowed an uncaught Exception or Error to propagate in your");
								_interpreteMensajes
										.log("### code. It may be possible for PircBot to continue operating");
								_interpreteMensajes
										.log("### normally. Here is the stack trace that was produced: -");
								_interpreteMensajes.log("### ");
								while (tokenizer.hasMoreTokens()) {
									_interpreteMensajes.log("### "
											+ tokenizer.nextToken());
								}
							}
						}
					}
					if (line == null) {
						// The server must have disconnected us.
						running = false;
					}
				} catch (InterruptedIOException iioe) {
					// This will happen if we haven't received anything from the
					// server for a while.
					// So we shall send it a ping to check that we are still
					// connected.
					this.sendRawLine("PING "
							+ (System.currentTimeMillis() / 1000));
					// Now we go back to listening for stuff from the server...
				}
			}
		} catch (Exception e) {
			// Do nothing.
		}

		// If we reach this point, then we must have disconnected.
		synchronized (_interpreteMensajes) {
			// But only disconnect if something else hasn't caused us to do so
			// already!
			// if (_interpreteMensajes.isConnected()) {
			// _interpreteMensajes.disconnect();
			_interpreteMensajes.intentaDesconectar();
		}

	}

}
