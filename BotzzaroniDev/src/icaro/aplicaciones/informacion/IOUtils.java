package icaro.aplicaciones.informacion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public final class IOUtils {

	private IOUtils() {
		
	}
	
	/**
	 * 
	 * @param path
	 * @return un Mapa vacío si no ha podido leer el archivo o sino el mapa
	 *         leido
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Object, Serializable> Map<String, T> read(String path) {
		File file = new File(path);
		if (!file.exists() || !file.isFile()) {
			return new HashMap<String, T>();
		}
		FileInputStream f = null;
		ObjectInputStream s = null;
		Map<String, T> res = null;
		try {
			f = new FileInputStream(file);
			s = new ObjectInputStream(f);
			res = (Map<String, T>) s.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (s != null) {
				try {
					s.close();
				} catch (IOException ignoredEx) {
					// Ignore the exception
				} finally {
					s = null;
				}
			}
		}
		if (res == null) {
			res = new HashMap<String, T>();
		}
		return res;
	}
	
	/**
	 * Escribe en el archivo el mapa del argumento
	 * 
	 * @param path
	 * @param map
	 */
	public static void write(String path, Object obj) {
		File file = new File(path);
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(obj);
			oos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException ignoredEx) {
					// Ignore the exception
				} finally {
					oos = null;
				}
			}
		}
	}
}
