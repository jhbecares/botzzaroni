/*package icaro.aplicaciones.recursos.persistenciaAccesoBD;

import java.util.ArrayList;
import java.util.HashMap;

import icaro.aplicaciones.informacion.gestionPizzeria.*;
import java.text.SimpleDateFormat;

import icaro.aplicaciones.informacion.gestionPizzeria.Pedido;
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
	
	
	public ArrayList<Pizza> obtenerPersonalizadasUsuario(String usuario) throws Exception;
	
	public ArrayList<Pizza> obtenerMasPedidaCarta(String usuario) throws Exception;

	public boolean existePizzaPersonalizadaNombre(String username, String nombrePizza) throws Exception;

	public void insertaPizzaPersonalizada(Pizza pizza) throws Exception;

	

	

	public ArrayList<SimpleDateFormat> consultaPedidos(SimpleDateFormat sdf)  throws Exception ;

	public void insertaPedido(Pedido pedido) throws Exception;

	// Método a hacer, añadiendo los datos del usuario ya identificado
	// public void insertaDatosUsuario(Usuario gr);
}*/

package icaro.aplicaciones.recursos.persistenciaAccesoBD;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import icaro.aplicaciones.informacion.gestionPizzeria.Pedido;
import icaro.aplicaciones.informacion.gestionPizzeria.Pizza;
import icaro.aplicaciones.informacion.gestionPizzeria.Usuario;
import icaro.infraestructura.patronRecursoSimple.ItfUsoRecursoSimple;

public interface ItfUsoPersistenciaAccesoBD extends ItfUsoRecursoSimple {
	public boolean compruebaUsuario(String usuario, String password)
			throws Exception;

	public boolean compruebaNombreUsuario(String usuario) throws Exception;

	public void insertaUsuario(String usuario, String password)
			throws Exception;
	
	public Usuario obtenerUsuario(String usuario) throws Exception;

	public ArrayList<SimpleDateFormat> consultaPedidos(SimpleDateFormat sdf)  throws Exception ;

	public void insertaPedido(Pedido pedido) throws Exception;

	
	public ArrayList<Pizza> obtenerPersonalizadasUsuario(String usuario) throws Exception;
	
	public ArrayList<Pizza> obtenerMasPedidaCarta(String usuario) throws Exception;

	public boolean existePizzaPersonalizadaNombre(String username, String nombrePizza) throws Exception;

public void insertaPizzaPersonalizada(Pizza pizza) throws Exception;

	// M�todo a hacer, a�adiendo los datos del usuario ya identificado
	public void insertaDatosUsuario(Usuario gr) throws Exception;
}