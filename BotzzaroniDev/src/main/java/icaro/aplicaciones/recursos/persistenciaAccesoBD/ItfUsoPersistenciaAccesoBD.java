package icaro.aplicaciones.recursos.persistenciaAccesoBD;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import icaro.aplicaciones.informacion.gestionPizzeria.Usuario;
import icaro.aplicaciones.recursos.persistenciaAccesoBD.imp.ErrorEnRecursoException;
import icaro.infraestructura.patronRecursoSimple.ItfUsoRecursoSimple;

public interface ItfUsoPersistenciaAccesoBD extends ItfUsoRecursoSimple {
	public boolean compruebaUsuario(String usuario, String password)
			throws Exception;

	public boolean compruebaNombreUsuario(String usuario) throws Exception;

	public void insertaUsuario(String usuario, String password)
			throws Exception;
	
	public Usuario obtenerUsuario(String usuario) throws Exception;

	public ArrayList<SimpleDateFormat> consultaPedidos(SimpleDateFormat sdf)  throws Exception ;

	// Método a hacer, añadiendo los datos del usuario ya identificado
	// public void insertaDatosUsuario(Usuario gr);
}