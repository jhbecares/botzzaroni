/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icaro.aplicaciones.recursos.interfazChatUsuario.imp;

/**
 *
 * @author 
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;
import javax.swing.JScrollPane;

import java.awt.Color;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

import java.lang.Math;

public class VisualizadorChatSimple extends JFrame implements KeyListener{

	JPanel p=new JPanel();
	JTextArea dialog=new JTextArea(20,50);
	JTextArea input=new JTextArea(1,50);
	DefaultCaret c = (DefaultCaret) dialog.getCaret();
	
	JScrollPane scroll=new JScrollPane(
                dialog,
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
	);
        String nominacionInterlocutor = "usuario";
	
	String[][] chatBot={
		//standard greetings
		{"hi","hello","hola","ola","howdy"},
		{"hi","hello","hey"},
		//question greetings
		{"how are you","how r you","how r u","how are u"},
		{"good","doing well"},
		//yes
		{"yes"},
		{"no","NO","NO!!!!!!!"},
		//default
		{"shut up","you're bad","noob","stop talking",
		"(michael is unavailable, due to LOL)"}
	};
	
	public static void main(String[] args){
		new VisualizadorChatSimple();
	}
    private InterpreteMsgsPanelChat interpreteTextoUsuario;
	
	public VisualizadorChatSimple(){
		super("Botzzaroni");
                 this.setLocation(850,100);
            
		setSize(600,500);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		dialog.setEditable(false);
		input.addKeyListener(this);
		c.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
	
		p.add(scroll);
		p.add(input);
		p.setBackground(new Color(0,127,255));
		add(p);		
		setVisible(false);
   
	}
        public void setInterpreteTextoUsuario(InterpreteMsgsPanelChat interpreteTexto){
            this.interpreteTextoUsuario = interpreteTexto;
        }
         public void setnominacionInterlocutor(String nominInterlocutor){
            this.nominacionInterlocutor = nominInterlocutor;
        }
	
        @Override
	public void keyPressed(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			String quote=input.getText();
			input.setText(null);
			addText( nominacionInterlocutor + ": "+quote);
			quote.trim();
            this.interpreteTextoUsuario.interpetarTextoUsuario(quote);
            
            this.setVisible(true);
            this.setAlwaysOnTop(true);
            this.toFront();
            /*this.input.requestFocus();
            this.setFocusable(true);
            this.requestFocusInWindow();*/
            
            

		}
	}
	
        @Override
	public void keyReleased(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_ENTER){
			input.setEditable(true);
			this.input.setFocusable(true);
			this.input.requestFocus();
			this.setFocusable(true);
            this.requestFocusInWindow();
			
		}
	}
	
        @Override
	public void keyTyped(KeyEvent e){}
        
	
	public void addText(String str){
		dialog.setText(dialog.getText()+str+"\n");
		
	}
	
	public boolean inArray(String in,String[] str){
		boolean match=false;
		for(int i=0;i<str.length;i++){
			if(str[i].equals(in)){
				match=true;
			}
		}
		return match;
	}
}
