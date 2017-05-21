package icaro.aplicaciones.recursos.persistenciaAccesoBD.imp;

import icaro.aplicaciones.informacion.gestionPizzeria.Bebida;
import icaro.aplicaciones.informacion.gestionPizzeria.Direccion;
import icaro.aplicaciones.informacion.gestionPizzeria.Ingrediente;
import icaro.aplicaciones.informacion.gestionPizzeria.Pedido;
import icaro.aplicaciones.informacion.gestionPizzeria.Pizza;
import icaro.aplicaciones.informacion.gestionPizzeria.Usuario;
import icaro.aplicaciones.recursos.persistenciaAccesoBD.imp.util.ScriptRunner;
import icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
import icaro.infraestructura.entidadesBasicas.descEntidadesOrganizacion.DescInstanciaRecursoAplicacion;
import icaro.infraestructura.recursosOrganizacion.configuracion.ItfUsoConfiguracion;
import icaro.infraestructura.recursosOrganizacion.repositorioInterfaces.imp.ClaseGeneradoraRepositorioInterfaces;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

import com.sun.jmx.snmp.Timestamp;

/**
 * Proporciona los servicios de acceso a la bbdd con mysql
 *
 * @author ï¿½lvaro Rodrï¿½guez Pï¿½rez
 *
 */
public class PersistenciaAccesoImp {

	/**
	 * Nombre de la BBDD con la que se trabaja
	 */
	// static public final String nombreBD= "bbddejemplo";
	// static public final String nombreBD;
	static public String nombreBD;
	/**
	 * Nombre de usuario de acceso (con privilegios de root) a la bbdd
	 */
	static private String LOGIN;// =
	// Configuracion.obtenerParametro("MYSQL_USER");
	// static private final String LOGIN="root";
	/**
	 * Clave de acceso correspondiente con el usuario indicado
	 */
	static private String PASSWORD;// =
	// Configuracion.obtenerParametro("MYSQL_PASSWORD");
	// static private final String PASSWORD= "adminwww";
	/**
	 * Url en dï¿½nde se situa la bbdd
	 */
	static private String URL_CONEXION;// =
	// Configuracion.obtenerParametro("MYSQL_URL");
	// static private final String URL_CONEXION="jdbc:mysql://localhost:3306/";
	/**
	 * Objeto resultante de la comunicaciï¿½n establecida con la bbdd
	 */
	private static Connection conn = null;

	/**
	 * Script de creacion de tablas de la bbdd
	 */
	static private String ejecutable;// =
	// Configuracion.obtenerParametro("MYSQL_SCRIPT_ITEMS");
	// static private final String ejecutable="createTablasItems.bat";

	private Statement query;
	/**
	 * Resultado de la consulta a la base de datos
	 */
	private ResultSet resultado;

	/**
	 * Constructor por defecto
	 *
	 */
	public PersistenciaAccesoImp() {
	}

	public static void crearEsquema(String idDescripcionIstanciaRecurso)
			throws Exception {
		try {
			if (obtenerParametrosBDPersistencia(idDescripcionIstanciaRecurso)) {
				conectar();
				crearTablas();
				/*
				 * Statement stmt = null; ResultSet rs; String msg_text = "";
				 * System.out.println(
				 * "--------------Creacion del esquema de bbdditems----------------"
				 * ); stmt = conn.createStatement(); stmt.executeUpdate(
				 * "CREATE DATABASE IF NOT EXISTS "+AccesoBBDD.nombreBD);
				 * 
				 * rs = stmt.executeQuery(
				 * "CHECK TABLE "+AccesoBBDD.nombreBD+".USERS");
				 * while(rs.next()){ msg_text= rs.getString("Msg_text").trim();
				 * }
				 * 
				 * //Solo se crean las tablas del script si no existen if
				 * (!msg_text.equals("OK")){ System.out.println(
				 * "--------------Ejecuta script de creacion de las tablas bbdditems----------------"
				 * ); crearTablas(); //BDUtils BD=new BDUtils();
				 * //BD.precargaRuben2();
				 * 
				 * 
				 * }
				 */
				// Verificar que lo que se ha creado con el script es accesible
				// posteriormente
				// Verificar que la BD que se ha declarado existe y se pueden
				// meter y sacar cosas
				// si no se puede habrÃ­a que eliminar lo creado

				desconectar();
			} else {
				System.out
						.println("--------------Hubo algun Problema al obtener los parametros de la BD----------------");

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	private static boolean obtenerParametrosBDPersistencia(
			String idDescripcionIstanciaRecurso) throws Exception {
		Boolean obtenerParametrosPersistencia = false;
		try {
			ItfUsoConfiguracion config = (ItfUsoConfiguracion) ClaseGeneradoraRepositorioInterfaces
					.instance().obtenerInterfaz(
							NombresPredefinidos.ITF_USO
									+ NombresPredefinidos.CONFIGURACION);
			DescInstanciaRecursoAplicacion descRecurso = config
					.getDescInstanciaRecursoAplicacion(idDescripcionIstanciaRecurso);
			nombreBD = descRecurso.getValorPropiedad("MYSQL_NAME_BD");
			LOGIN = descRecurso.getValorPropiedad("MYSQL_USER");
			PASSWORD = descRecurso.getValorPropiedad("MYSQL_PASSWORD");
			URL_CONEXION = descRecurso.getValorPropiedad("MYSQL_URL");
			// Esto se podrÃ­a quitar pq el npmbre de la BD no se pone en la URL
			URL_CONEXION = URL_CONEXION.replaceAll(nombreBD, "");
			ejecutable = descRecurso.getValorPropiedad("MYSQL_SCRIPT_ITEMS");
			obtenerParametrosPersistencia = true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ErrorEnRecursoException(
					"Ha habido un problema al obtener la configuracion del recurso de persistencia");
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Class.forName("org.apache.derby.jdbc.ClientDriver");
		} catch (ClassNotFoundException e) {
			// TODO Bloque catch generado automï¿½ticamente
			e.printStackTrace();
			throw new ErrorEnRecursoException(
					"Ha habido un problema  con la conexion con la base de datos (instanciando el driver connector com.mysql.jdbc.Driver)");

		}
		return obtenerParametrosPersistencia;
	}

	private static boolean crearTablas() throws Exception {
		ScriptRunner runner = new ScriptRunner(conn, false, true);
		boolean esOK = false;
		try {
			runner.runScript(new FileReader(ejecutable));
			esOK = true;
		} catch (IOException e) {
			throw new Exception("Ha habido un error al leer el fichero "
					+ ejecutable, e);
		} catch (SQLException e1) {
			throw new Exception("Ha habido un error al ejecutar el script SQL "
					+ ejecutable, e1);
		}
		return esOK;

		/*
		 * Runtime r = Runtime.getRuntime(); Process p ; boolean esOK=false; try
		 * { String
		 * cmd="cmd /c  mysql --host="+AccesoBBDD.URL_CONEXION.substring
		 * (AccesoBBDD
		 * .URL_CONEXION.indexOf("://")+3,AccesoBBDD.URL_CONEXION.lastIndexOf
		 * (":"))
		 * +" --port="+AccesoBBDD.URL_CONEXION.substring(AccesoBBDD.URL_CONEXION
		 * .lastIndexOf(":")+1,AccesoBBDD.URL_CONEXION.lastIndexOf(":")+5)
		 * +" --password="
		 * +AccesoBBDD.PASSWORD+" --user="+AccesoBBDD.LOGIN+" "+AccesoBBDD
		 * .nombreBD+" < "+AccesoBBDD.ejecutable;
		 * System.out.print("\n"+cmd+"\n\n"); p = r.exec(cmd); try {
		 * p.waitFor(); esOK=(p.exitValue()==0); if (!esOK){
		 * System.out.println("Ha habido algun problema al crear las tablas ("
		 * +AccesoBBDD.ejecutable+") de la base de datos "+AccesoBBDD.nombreBD);
		 * 
		 * }
		 * 
		 * } catch (InterruptedException e) { e.printStackTrace(); esOK=false; }
		 * 
		 * } catch (IOException e) { esOK=false;
		 * System.err.println("Error al crear las tablas ("
		 * +AccesoBBDD.ejecutable+") de la base de datos "+AccesoBBDD.nombreBD);
		 * e.printStackTrace(); }
		 */

	}

	/**
	 * Realiza una conexion (principio de la comunicaciï¿½n) sobre la bbdd
	 *
	 * @throws ErrorEnRecursoException
	 */

	private static void conectar() throws ErrorEnRecursoException {

		// try {
		// ItfUsoConfiguracion config = (ItfUsoConfiguracion)
		// ClaseGeneradoraRepositorioInterfaces.instance().obtenerInterfaz(NombresPredefinidos.ITF_USO+NombresPredefinidos.CONFIGURACION);
		// DescInstanciaRecursoAplicacion descRecurso =
		// config.getDescInstanciaRecursoAplicacion(id);
		//
		// LOGIN = descRecurso.getValorPropiedad("MYSQL_USER");
		// PASSWORD = descRecurso.getValorPropiedad("MYSQL_PASSWORD") ;
		// URL_CONEXION = descRecurso.getValorPropiedad("MYSQL_URL");
		//
		// URL_CONEXION = URL_CONEXION.replaceAll(nombreBD, "");
		// ejecutable = descRecurso.getValorPropiedad("MYSQL_SCRIPT_ITEMS");
		// } catch (Exception e) {
		// e.printStackTrace();
		// throw new
		// ErrorEnRecursoException("Ha habido un problema al obtener la configuraciï¿½n del recurso de persistencia");
		// }
		// try{
		// Class.forName("com.mysql.jdbc.Driver");
		// // Class.forName("org.apache.derby.jdbc.ClientDriver");
		// } catch (ClassNotFoundException e) {
		// // TODO Bloque catch generado automï¿½ticamente
		// e.printStackTrace();
		// throw new
		// ErrorEnRecursoException("Ha habido un problema con la conexion con la base de datos (instanciando el driver connector)");
		//
		// }
		//
		try {
			// URL_CONEXION = "jdbc:derby://localhost:1527";
			// URL_CONEXION = "jdbc:derby://localhost:1527/bddEjemploAcceso";
			// conn = DriverManager.getConnection(URL_CONEXION,LOGIN,PASSWORD);
			conn = DriverManager.getConnection(URL_CONEXION, LOGIN, PASSWORD);

		} catch (SQLException e) {
			e.printStackTrace();
			/*
			 * //ER_BAD_DB_ERROR: if (e.getSQLState().equals("42000")) { try {
			 * 
			 * String urlname = URL_CONEXION.replaceAll("bbddejemplo", "");
			 * System.out.println(urlname); conn =
			 * DriverManager.getConnection(urlname, LOGIN, PASSWORD); } catch
			 * (SQLException ex) {
			 * Logger.getLogger(AccesoBBDD.class.getName()).log(Level.SEVERE,
			 * null, ex); } }
			 */

			throw new ErrorEnRecursoException(
					"Ha habido un problema con la conexion con la base de datos "
							+ URL_CONEXION + "\nusuario " + LOGIN
							+ "\npassword " + PASSWORD);
			// TODO Bloque catch generado automï¿½ticamente

		}

	}

	/**
	 * Realiza la desconexion (fin de la comunicaciï¿½n) sobre la bbdd
	 *
	 * @throws ErrorEnRecursoException
	 */

	public static void desconectar() {

		try {
			conn.close();
		} catch (SQLException e) {
			System.out
					.println("\nNo se ha podido cerrar la conexiï¿½n con la base de datos: "
							+ e.getMessage());
			e.printStackTrace();
		}
	}

	public boolean compruebaUsuario(String usuario, String password)
			throws ErrorEnRecursoException {

		boolean estado = false;

		try {
			conectar();
			// crearQuery();
			query = conn.createStatement();
			resultado = query.executeQuery("SELECT * FROM "
					+ PersistenciaAccesoImp.nombreBD
					+ ".usuario U where U.alias = '" + usuario
					+ "' and U.password = '" + password + "'");
			if (resultado.next()) {
				estado = true;
			} else {
				estado = false;
			}
			resultado.close();
			desconectar();
			return estado;
		}

		catch (Exception e) {
			throw new ErrorEnRecursoException(e.getMessage());
		}
	}

	public boolean compruebaNombreUsuario(String usuario)
			throws ErrorEnRecursoException {

		boolean estado = false;

		try {
			conectar();
			// crearQuery();
			query = conn.createStatement();
			resultado = query.executeQuery("SELECT * FROM "
					+ PersistenciaAccesoImp.nombreBD
					+ ".usuario U where U.alias = '" + usuario + "'");
			if (resultado.next()) {
				estado = true;
			} else {
				estado = false;
			}
			resultado.close();
			desconectar();
			return estado;
		}

		catch (Exception e) {
			throw new ErrorEnRecursoException(e.getMessage());
		}
	}

	public void insertaUsuario(String usuario, String password)
			throws ErrorEnRecursoException {

		try {
			conectar();
			// crearQuery();
			query = conn.createStatement();
			String consulta = "INSERT INTO " + PersistenciaAccesoImp.nombreBD
					+ ".usuario VALUES ('" + usuario + "','" + password +  "', 'nombre', 'calle', 0, 0, 'puerta', 00000, 000000000)";
			query.executeUpdate(consulta);
			desconectar();
		}

		catch (Exception e) {
			throw new ErrorEnRecursoException(e.getMessage());
		}
	}

	public Usuario obtenerDatosUsuario(String usuario) throws ErrorEnRecursoException {
		Usuario user = null;
		try {
			conectar();
			// crearQuery();
			
			query = conn.createStatement();
			resultado = query.executeQuery("SELECT * FROM "
					+ PersistenciaAccesoImp.nombreBD
					+ ".usuario U where U.alias = '" + usuario+ "'");
			if (resultado.next()) {

		        String nombre = resultado.getString("nombre");
		        String calle = resultado.getString("calle");
				int numero  = resultado.getInt("numero");
		        int piso = resultado.getInt("piso");
		        String puerta = resultado.getString("puerta");
		        int codigoPostal = resultado.getInt("codPostal");
		        int movil = resultado.getInt("movil");

				user = new Usuario();
				user.setUsername(usuario);
				user.setNombre(nombre);
				//user.setApellidos(apellidos);
				user.setMovil(String.valueOf(movil));
				Direccion direccion = new Direccion(calle,  numero, piso, puerta, codigoPostal);
				user.setDireccion(direccion);
			}
			resultado.close();
			desconectar();
			return user;
		}
		catch (Exception e) {
			throw new ErrorEnRecursoException(e.getMessage());
		}
	}

	public ArrayList<SimpleDateFormat> consultaPedidosFecha(SimpleDateFormat sdf)  throws ErrorEnRecursoException {
		try {
			ArrayList<SimpleDateFormat> fechas = new ArrayList<SimpleDateFormat>();
			
			conectar();
			SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ss.setCalendar(sdf.getCalendar());
			GregorianCalendar gc = (GregorianCalendar) ss.getCalendar();
			
			
			System.out.println("fecha comprobar: " + ss.format(gc.getTime()));
			String comprobar = ss.format(gc.getTime());
			
			// SELECT fecha FROM `pedido` WHERE `fecha` > '2017-05-21 11:30:00' and `fecha` BETWEEN '2017-05-21 20:30:00' and '2017-05-21 23:59:00' 
			
			GregorianCalendar gcIni = (GregorianCalendar) gc.clone();
			gcIni.set(Calendar.HOUR_OF_DAY, 20);
		    gcIni.set(Calendar.MINUTE, 30);
		    
		    System.out.println("fecha inicio: " + ss.format(gcIni.getTime()));
		    
		    GregorianCalendar gcFin = (GregorianCalendar) gc.clone();
			gcFin.set(Calendar.HOUR_OF_DAY, 23);
		    gcFin.set(Calendar.MINUTE, 59);
			
		    System.out.println("fecha fin: " + ss.format(gcFin.getTime()));
		    
			query = conn.createStatement();
			String q = "SELECT fecha FROM "
					+ PersistenciaAccesoImp.nombreBD
					+ ".pedido P where P.fecha >= '" + comprobar +
					"' and P.fecha BETWEEN '" + ss.format(gcIni.getTime()) + "' and '" + ss.format(gcFin.getTime()) + "'";

			System.out.println(q);
			resultado = query.executeQuery(q);
			while (resultado.next()) {
				GregorianCalendar cal = new GregorianCalendar();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss");
				java.sql.Timestamp timestamp = resultado.getTimestamp("fecha");
				Date d = new Date(timestamp.getTime());
				cal.setTime(d);
				df.setCalendar(cal);
				fechas.add(df);
			}
			
			System.out.println("Número de pedidos reconocidos:" + fechas.size());
			resultado.close();
			desconectar();
			return fechas;
		}
		catch (Exception e) {
			throw new ErrorEnRecursoException(e.getMessage());
		}
	}

	public void insertaPedido(Pedido pedido) throws ErrorEnRecursoException {
		// TODO Auto-generated method stub
		try {
					
			conectar();
	
			// Primero debemos insertar en la tabla pedido
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
		    String fecha = sdf.format(pedido.getFechaEntrega());
			
			query = conn.createStatement();
			String consulta = "INSERT INTO " + PersistenciaAccesoImp.nombreBD
					+ ".usuario VALUES ('" + pedido.getUsuario().getUsername() + "','" + pedido.getMetodoPago().toString() +  "'," + pedido.getCambioEfectivo()+", '" + fecha +"')";
			query.executeUpdate(consulta);
			
			// Recuperamos el id del pedido
			query = conn.createStatement();
			resultado = query.executeQuery("SELECT id FROM "
					+ PersistenciaAccesoImp.nombreBD
					+ ".pedido P where P.fecha = '" + fecha +
					"' and P.aliasUsuario='" + pedido.getUsuario().getUsername() + "'");
			int idPedido = 0;
			if(resultado.next()){
				idPedido = resultado.getInt("id");
			}
			
			// Recuperar ids de las pizzas de la carta
			HashMap<String, Integer> mapCarta = new HashMap<String, Integer>();
			query = conn.createStatement();
			resultado =  query.executeQuery("SELECT id, nombre FROM "
			+ PersistenciaAccesoImp.nombreBD
			+ ".pizza P WHERE P.aliasUsuario='botzzaroni'");
			
			while(resultado.next()){
				mapCarta.put(resultado.getString("nombre"), resultado.getInt("id"));
			}
			
			
			// Recuperar ids de las salsas
			HashMap<String, Integer> mapSalsa = new HashMap<String, Integer>();
			query = conn.createStatement();
			resultado =  query.executeQuery("SELECT id, nombre FROM "
			+ PersistenciaAccesoImp.nombreBD
			+ ".salsa");
			
			while(resultado.next()){
				mapCarta.put(resultado.getString("nombre"), resultado.getInt("id"));
			}
			
			
			// Para cada pizza, accedo a su ID y lo añado a la tabla tienePizza con el ID de la pizza
			for(Pizza p : pedido.getPizzas()){
				if(!p.isPersonalizada()){
					int idPizza = mapCarta.get(p.getNombrePizza());
					query = conn.createStatement();
					String insercionPizza = "INSERT INTO " + PersistenciaAccesoImp.nombreBD
					+ ".tienepizza VALUES (" + idPedido + "," + idPizza+  ",'" + p.getTamanio().toString()+  "','" + p.getMasa().toString() + "')";
					query.executeUpdate(insercionPizza);
				}
				else{
					
					int idPizzaPersonalizada = 0;
					// Recuperar el id con el que se ha insertado
					query = conn.createStatement();
					resultado =  query.executeQuery("SELECT id FROM "
							+ PersistenciaAccesoImp.nombreBD
							+ ".pizza P where P.aliasUsuario = '" + p.getUsuarioCreador().getUsername() + "' and P.nombre = '" + p.getNombrePizza() + "'");
					if (resultado.next()) {
						idPizzaPersonalizada = resultado.getInt("id");			
					}
					
					query = conn.createStatement();
					String insercionPizza = "INSERT INTO " + PersistenciaAccesoImp.nombreBD
					+ ".tienepizza VALUES (" + idPedido + "," + idPizzaPersonalizada+  ",'" + p.getTamanio().toString()+  "','" + p.getMasa().toString() + "')";
					query.executeUpdate(insercionPizza);
					
					int idSalsa = mapSalsa.get(p.getSalsa());
					
					// Insertar la salsa					
					query = conn.createStatement();
					String insercionSalsa = "INSERT INTO " + PersistenciaAccesoImp.nombreBD
					+ ".tienesalsa VALUES (" + idPizzaPersonalizada + "," + idSalsa + ")";
					query.executeUpdate(insercionPizza);
				}
			}
			
			// Insertar las alergias del pedido si tiene
			if(pedido.tieneAlergia){
				
				// Recuperar ids de los ingredientes
				HashMap<String, Integer> mapIngr = new HashMap<String, Integer>();
				query = conn.createStatement();
				resultado =  query.executeQuery("SELECT * FROM "
						+ PersistenciaAccesoImp.nombreBD
						+ ".ingrediente");
				while(resultado.next()){
					mapIngr.put(resultado.getString("nombre"), resultado.getInt("id"));
				}
				
				for(Ingrediente i: pedido.getAlergias()){
					int idIngr = mapIngr.get(i.toString());
					query = conn.createStatement();
					String insercionAlergia = "INSERT INTO " + PersistenciaAccesoImp.nombreBD
							+ ".tieneingrediente VALUES (" + idPedido + "," + idIngr+  ")";
					query.executeUpdate(insercionAlergia);
				}
			}
			
			// Insertar las bebidas del pedido si tiene
			if(!pedido.getBebidas().isEmpty()){
				
				// Recuperar ids de los ingredientes
				HashMap<String, Integer> mapBebidas = new HashMap<String, Integer>();
				query = conn.createStatement();
				resultado =  query.executeQuery("SELECT * FROM "
						+ PersistenciaAccesoImp.nombreBD
						+ ".bebida");
				while(resultado.next()){
					mapBebidas.put(resultado.getString("nombre"), resultado.getInt("id"));
				}
				
				for(String i: pedido.getBebidas()){
					int idIngr = mapBebidas.get(i);
					query = conn.createStatement();
					String insercionBebida = "INSERT INTO " + PersistenciaAccesoImp.nombreBD
							+ ".tienebebida VALUES (" + idPedido + "," + idIngr+ ", 'mediano')";
					query.executeUpdate(insercionBebida);
				}
			}
			
			
			resultado.close();
			desconectar();
		}
		catch (Exception e) {
			throw new ErrorEnRecursoException(e.getMessage());
		}
		
		
	}
}
