package icaro.aplicaciones.recursos.persistenciaUsuario.impl;

import icaro.aplicaciones.informacion.IOUtils;
import icaro.aplicaciones.informacion.gestionPizzeria.Usuario;
import icaro.aplicaciones.informacion.gestionQuedadas.Grupo;
import java.io.Serializable;
import java.util.Map;

public class PersistenciaUsuariosImp implements Serializable {

	private static final String USUARIOS_PATH = "usuarios";
	private static Map<String, Usuario> tablaUsuarios = IOUtils.read(USUARIOS_PATH);
	private static final long serialVersionUID = 3791013440695899189L;

	public static void insertarUsuario(Usuario usuario) {
		tablaUsuarios.put(usuario.getUsername(), usuario);
		IOUtils.write(USUARIOS_PATH, tablaUsuarios);
	}

	
	
	public static Usuario obtenerUsuario(String idGrupo) {
		return tablaUsuarios.get(idGrupo);
	}
	

}
