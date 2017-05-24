package icaro.infraestructura.patronAgenteReactivo.factoriaEInterfaces.imp;

import icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
import icaro.infraestructura.entidadesBasicas.componentesBasicos.automatas.automataEFsinAcciones.ItfUsoAutomataEFsinAcciones;
import icaro.infraestructura.entidadesBasicas.componentesBasicos.automatas.automataEFsinAcciones.imp.ClaseGeneradoraAutomataEFsinAcciones;
import icaro.infraestructura.entidadesBasicas.descEntidadesOrganizacion.DescInstanciaAgente;
import icaro.infraestructura.entidadesBasicas.descEntidadesOrganizacion.jaxb.DescComportamientoAgente;
import icaro.infraestructura.entidadesBasicas.excepciones.ExcepcionEnComponente;
import icaro.infraestructura.entidadesBasicas.factorias.FactoriaComponenteIcaro;
import icaro.infraestructura.entidadesBasicas.interfaces.InterfazGestionPercepcion;
import icaro.infraestructura.patronAgenteReactivo.control.factoriaEInterfaces.ProcesadorInfoReactivoAbstracto;
import icaro.infraestructura.patronAgenteReactivo.factoriaEInterfaces.FactoriaAgenteReactivo;
import icaro.infraestructura.patronAgenteReactivo.factoriaEInterfaces.ItfUsoAgenteReactivo;
import icaro.infraestructura.patronAgenteReactivo.percepcion.factoriaEInterfaces.FactoriaPercepcion;
import icaro.infraestructura.patronAgenteReactivo.percepcion.factoriaEInterfaces.ItfProductorPercepcion;
import icaro.infraestructura.patronAgenteReactivo.percepcion.factoriaEInterfaces.PercepcionAbstracto;
import icaro.infraestructura.recursosOrganizacion.recursoTrazas.imp.componentes.InfoTraza;
import icaro.infraestructura.recursosOrganizacion.recursoTrazas.imp.componentes.InfoTraza.NivelTraza;

import java.io.InputStream;
import java.rmi.RemoteException;
import java.util.logging.Level;

import org.apache.log4j.Logger;

/**
 * Produce instancias del patron
 *
 * @F Garijo
 * @created 20 Mayo 2010
 */

public class FactoriaAgenteReactivoInputObjImp0 extends FactoriaAgenteReactivo {

	/*
	 * Crea una instancia del patron que crea un agente reactivo con el control
	 * del automata Input Objetos del agente.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Control del agente
	 *
	 * @uml.property name="control"
	 * @uml.associationEnd
	 */
	protected ProcesadorInfoReactivoAbstracto controlAgteReactivo;

	// protected ItfUsoRecursoTrazas trazas =
	// NombresPredefinidos.RECURSO_TRAZAS_OBJ;
	private String nombreInstanciaAgente;
	protected AgenteReactivoImp2 agente;
	private NombresPredefinidos.TipoEntidad tipoEntidad = NombresPredefinidos.TipoEntidad.Reactivo;

	// protected ItfUsoRepositorioInterfaces repositorioIntfaces=
	// NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ;

	/**
	 * @uml.property name="itfGesControl"
	 * @uml.associationEnd
	 */
	// protected InterfazGestion itfGesControl; //Control
	/**
	 * Percepcion del agente
	 *
	 * @uml.property name="itfConsumidorPercepcion"
	 * @uml.associationEnd
	 */
	protected InterfazGestionPercepcion itfGestionPercepcion;
	/**
	 * @uml.property name="itfProductorPercepcion"
	 * @uml.associationEnd
	 */
	protected ItfProductorPercepcion itfProductorPercepcion;
	/**
	 * Nombre del agente a efectos de traza
	 *
	 * @uml.property name="nombre"
	 */
	protected String nombre;
	/**
	 * Estado del agente reactivo
	 *
	 * @uml.property name="estado"
	 */
	// protected int estado = InterfazGestion.ESTADO_OTRO;
	/**
	 * Acciones sem�nticas del agente reactivo
	 *
	 * @uml.property name="accionesSemanticas"
	 * @uml.associationEnd
	 */
	// protected AccionesSemanticasImp accionesSemanticas;
	/**
	 * @uml.property name="dEBUG"
	 */
	private boolean DEBUG = false;
	/**
	 * Conocimiento del agente reactivo
	 *
	 * @uml.property name="itfUsoGestorAReportar"
	 * @uml.associationEnd
	 */
	protected ItfUsoAgenteReactivo itfUsoGestorAReportar;
	/**
	 * @uml.property name="logger"
	 * @uml.associationEnd multiplicity="(1 1)"
	 */
	private Logger logger = Logger
			.getLogger(this.getClass().getCanonicalName());
	/**
	 * @uml.property name="trazas"
	 * @uml.associationEnd
	 */

	private static FactoriaAgenteReactivoInputObjImp0 instance;

	public static FactoriaAgenteReactivoInputObjImp0 instance()
			throws ExcepcionEnComponente, RemoteException {
		try {
			if (instance == null) {
				instance = new FactoriaAgenteReactivoInputObjImp0();
			}
			return instance;
		} catch (Exception e) {
			// logger.fatal("\n\nError al comprobar los comportamientos de los gestores, agentes y recursos descritos en el fichero de descripcion del XML "
			// + "FactoriaAgenteReactivoInputObjImp0 ");
			return null;
			// throw new
			// ExcepcionEnComponente("\n\nError al comprobar los comportamientos de los gestores, agentes y recursos descritos en el fichero de descripcion del XML "
			// );
		}
	}

	@Override
	public synchronized void crearAgenteReactivo(
			DescInstanciaAgente descInstanciaAgente)
			throws ExcepcionEnComponente {

		// Paso 1 Se obtienen los objetos de la descripcion

		String nombreInstanciaAgente = descInstanciaAgente.getId();
		DescComportamientoAgente descagente = descInstanciaAgente
				.getDescComportamiento();
		descagente.getNombreComportamiento();
		descagente.getRol();
		this.recursoTrazas = NombresPredefinidos.RECURSO_TRAZAS_OBJ;
		// Paso 2 se obtienen los parametros necesarios para crear los
		// componentes internos
		if (recursoTrazas != null) {
			recursoTrazas.aceptaNuevaTraza(new InfoTraza(nombreInstanciaAgente,
					tipoEntidad, nombreInstanciaAgente
							+ ":Creando  el Agente ...", NivelTraza.debug));
		}
		// AccionesSemanticasAgenteReactivo accionesSemanticasEspecificas =
		// obtenerAcciones(descInstanciaAgente);
		// Obtener la ruta de las acciones dado que la factoria del automata ya
		// lo valida al construir la tabla
		// String rutaTabla = obtenerRutaTablaTransiciones(descInstanciaAgente);
		String rutaTabla = descInstanciaAgente.getDescComportamiento()
				.getLocalizacionFicheroAutomata();
		String rutaAcciones = descInstanciaAgente.getDescComportamiento()
				.getLocalizacionComportamiento();
		if ((rutaTabla != null)) {
			try {
				// Se crea el objeto que implementa las interfaces de uso y de
				// gestion
				this.agente = new AgenteReactivoImp2(nombreInstanciaAgente);
				// Se crea el control del agente por medio de su factoria
				// ProcesadorEventosAbstracto control =
				// FactoriaControlAgteReactivo.instancia().crearControlAgteReactivo(
				// accionesSemanticasEspecificas,rutaTabla ,
				// nombreInstanciaAgente, itfConsumidorPercepcion,
				// itfProductorPercepcion);
				controlAgteReactivo = FactoriaComponenteIcaro
						.instanceControlAgteReactInpObj()
						.crearControlAgteReactivo(rutaTabla, rutaAcciones,
								agente);
				// itfControlAgteReactivo = (ItfControlAgteReactivo) control ;
				// Se crea la percepcion y se le pasa la interfaz del control
				PercepcionAbstracto percepcion = FactoriaPercepcion.instancia()
						.crearPercepcion(agente, controlAgteReactivo);
				itfGestionPercepcion = percepcion;
				itfProductorPercepcion = percepcion;
				controlAgteReactivo.inicializarInfoGestorAcciones(
						nombreInstanciaAgente, itfProductorPercepcion);
				// paso 3.3 se crea la instancia que implementa las interfaces
				// AgenteReactivoAbstracto patron = new
				// AgenteReactivoImp(nombreInstanciaAgente,itfControlAgteReactivo,itfProductorPercepcion,itfConsumidorPercepcion);
				// Se crea el automata del ciclo de vida para implementar la
				// interfaz de Gestion
				ItfUsoAutomataEFsinAcciones itfAutomata = ClaseGeneradoraAutomataEFsinAcciones
						.instance(NombresPredefinidos.FICHERO_AUTOMATA_CICLO_VIDA_COMPONENTE);
				this.agente.setComponentesInternos(nombreInstanciaAgente,
						itfAutomata, controlAgteReactivo,
						itfProductorPercepcion, itfGestionPercepcion);
				// paso 3. 4 Se define la interfaz de uso del agente creado en
				// las acciones semánticas específicas
				// accionesSemanticasEspecificas.setItfUsoAgenteReactivo(agente);
				// accionesSemanticasEspecificas.setCtrlGlobalAgenteReactivo(agente);
				// Quedan definidos todos los objetos necesarios para
				// implementar el ejemplar creado
				logger.debug(nombreInstanciaAgente
						+ ":Creacion del Agente ...ok");
				if (recursoTrazas != null) {
					recursoTrazas.aceptaNuevaTraza(new InfoTraza(
							nombreInstanciaAgente, tipoEntidad,
							nombreInstanciaAgente
									+ ":Creacion del Agente ...ok",
							NivelTraza.debug));
				}
				// Paso 4 Procedemos a registrar las interfaces de la instancia
				// crada en el repositorio
				if (this.repositorioInterfaces == null) {
					crearRepositorioInterfaces();
				}
				repositorioInterfaces
						.registrarInterfaz(NombresPredefinidos.ITF_GESTION
								+ nombreInstanciaAgente, agente);
				repositorioInterfaces.registrarInterfaz(
						NombresPredefinidos.ITF_USO + nombreInstanciaAgente,
						agente);

				// activamos trazas pesadas
				agente.setDebug(false);
			}

			catch (ExcepcionEnComponente exc) {
				logger.error(
						"Error al crear El CONTROL del agente. La factoria no puede crear la instancia o no se pueden obtener la interfaces : "
								+ nombreInstanciaAgente, exc);
				System.err
						.println(" No se puede crear el control del agente. La factoria no puede crear la instancia.");
				exc.putCompDondeEstaContenido("patronAgenteReactivo.contol");
				exc.putParteAfectada("FactoriaControlAgenteReactivoImp");
				throw exc;
			} catch (Exception ex) {
				logger.error(
						"Error AL CREAR LA PERCEPCON. La factoria no puede crear la instancia : "
								+ nombreInstanciaAgente, ex);
				System.err
						.println(" No se puede crear la Percepcion del agente. La factoria no puede crear la instancia.");
				throw new ExcepcionEnComponente("patronAgenteReactivo.contol",
						"posible error al crear l paercepcion", "percepcion",
						"");
			}

		} else {
			recursoTrazas
					.aceptaNuevaTraza(new InfoTraza(
							nombreInstanciaAgente,
							nombreInstanciaAgente
									+ ":No se puede crear el agente. El comportamiento no esta bien definido",
							NivelTraza.error));
			System.err
					.println(" No se puede crear la Instancia del agente . La descripcion del comportamiento no es correcta.");
		}
	}

	public void crearAgenteReactivo(String rutaTabla, String rutaAcciones,
			String agenteId) throws ExcepcionEnComponente {
		nombreInstanciaAgente = agenteId;
		// String rutaTabla =
		// descInstanciaAgente.getDescComportamiento().getLocalizacionFicheroAutomata();
		// String rutaAcciones =
		// descInstanciaAgente.getDescComportamiento().getLocalizacionComportamiento();
		if ((rutaTabla != null)) {
			try {
				// Se crea el objeto que implementa las interfaces de uso y de
				// gestion
				this.agente = new AgenteReactivoImp2(nombreInstanciaAgente);
				// Se crea el control del agente por medio de su factoria
				// ProcesadorEventosAbstracto control =
				// FactoriaControlAgteReactivo.instancia().crearControlAgteReactivo(
				// accionesSemanticasEspecificas,rutaTabla ,
				// nombreInstanciaAgente, itfConsumidorPercepcion,
				// itfProductorPercepcion);
				controlAgteReactivo = FactoriaComponenteIcaro
						.instanceControlAgteReactInpObj()
						.crearControlAgteReactivo(rutaTabla, rutaAcciones,
								agente);
				// itfControlAgteReactivo = (ItfControlAgteReactivo) control ;
				// Se crea la percepcion y se le pasa la interfaz del control
				PercepcionAbstracto percepcion = FactoriaPercepcion.instancia()
						.crearPercepcion(agente, controlAgteReactivo);
				itfGestionPercepcion = percepcion;
				itfProductorPercepcion = percepcion;
				controlAgteReactivo.inicializarInfoGestorAcciones(
						nombreInstanciaAgente, itfProductorPercepcion);
				// paso 3.3 se crea la instancia que implementa las interfaces
				// AgenteReactivoAbstracto patron = new
				// AgenteReactivoImp(nombreInstanciaAgente,itfControlAgteReactivo,itfProductorPercepcion,itfConsumidorPercepcion);
				// Se crea el automata del ciclo de vida para implementar la
				// interfaz de Gestion
				ItfUsoAutomataEFsinAcciones itfAutomata = ClaseGeneradoraAutomataEFsinAcciones
						.instance(NombresPredefinidos.FICHERO_AUTOMATA_CICLO_VIDA_COMPONENTE);
				this.agente.setComponentesInternos(nombreInstanciaAgente,
						itfAutomata, controlAgteReactivo,
						itfProductorPercepcion, itfGestionPercepcion);
				// paso 3. 4 Se define la interfaz de uso del agente creado en
				// las acciones semánticas específicas
				// accionesSemanticasEspecificas.setItfUsoAgenteReactivo(agente);
				// accionesSemanticasEspecificas.setCtrlGlobalAgenteReactivo(agente);
				// Quedan definidos todos los objetos necesarios para
				// implementar el ejemplar creado
				logger.debug(nombreInstanciaAgente
						+ ":Creacion del Agente ...ok");
				if (recursoTrazas != null) {
					recursoTrazas.aceptaNuevaTraza(new InfoTraza(
							nombreInstanciaAgente, tipoEntidad,
							nombreInstanciaAgente
									+ ":Creacion del Agente ...ok",
							NivelTraza.debug));
				}
				// Paso 4 Procedemos a registrar las interfaces de la instancia
				// crada en el repositorio
				if (this.repositorioInterfaces == null) {
					crearRepositorioInterfaces();
				}
				repositorioInterfaces
						.registrarInterfaz(NombresPredefinidos.ITF_GESTION
								+ nombreInstanciaAgente, agente);
				repositorioInterfaces.registrarInterfaz(
						NombresPredefinidos.ITF_USO + nombreInstanciaAgente,
						agente);

				// activamos trazas pesadas
				agente.setDebug(false);
			}

			catch (ExcepcionEnComponente exc) {
				logger.error(
						"Error al crear El CONTROL del agente. La factoria no puede crear la instancia o no se pueden obtener la interfaces : "
								+ nombreInstanciaAgente, exc);
				System.err
						.println(" No se puede crear el control del agente. La factoria no puede crear la instancia.");
				exc.putCompDondeEstaContenido("patronAgenteReactivo.contol");
				exc.putParteAfectada("FactoriaControlAgenteReactivoImp");
				throw exc;
			} catch (Exception ex) {
				logger.error(
						"Error AL CREAR LA PERCEPCON. La factoria no puede crear la instancia : "
								+ nombreInstanciaAgente, ex);
				System.err
						.println(" No se puede crear la Percepcion del agente. La factoria no puede crear la instancia.");
				throw new ExcepcionEnComponente("patronAgenteReactivo.contol",
						"posible error al crear l paercepcion", "percepcion",
						"");
			}

		} else {
			recursoTrazas
					.aceptaNuevaTraza(new InfoTraza(
							nombreInstanciaAgente,
							nombreInstanciaAgente
									+ ":No se puede crear el agente. El comportamiento no esta bien definido",
							NivelTraza.error));
			System.err
					.println(" No se puede crear la Instancia del agente . La descripcion del comportamiento no es correcta.");
		}
	}

	@Override
	public synchronized void crearAgenteReactivo(String agenteId,
			String rutaComportamiento) {
		// DescInstanciaAgente descInsPrueba = new DescInstanciaAgente();
		// descInsPrueba.setId(agenteId);
		// DescComportamientoAgente comprtAgteDesc = new
		// DescComportamientoAgente();
		// comprtAgteDesc.setLocalizacionComportamiento(rutacomportamiento);
		String rutaAutomata = obtenerRutaValidaAutomata(rutaComportamiento);
		if (rutaAutomata != null) {
			try {
				this.crearAgenteReactivo(rutaAutomata, rutaComportamiento,
						agenteId);
			} catch (ExcepcionEnComponente ex) {
				java.util.logging.Logger.getLogger(
						FactoriaAgenteReactivoInputObjImp0.class.getName())
						.log(Level.SEVERE, null, ex);
			}

		} else {
			recursoTrazas
					.aceptaNuevaTraza(new InfoTraza(
							nombreInstanciaAgente,
							nombreInstanciaAgente
									+ ":No se puede crear el agente. No se encuentra fichero de la tabla de estados en la ruta :+"
									+ rutaComportamiento
									+ " Revisar la existencia del fichero en esa ruta",
							NivelTraza.error));
			System.err
					.println(" No se puede crear la Instancia del agente . La descripcion del comportamiento no es correcta.");
		}
	}

	// public void crearAgenteReactivo(String nombreInstanciaAgente, String
	// rutaComportamiento)throws ExcepcionEnComponente {
	//
	// // Se valida la informacion de entrada y si es valida se procede a crear
	// los componentes internos
	//
	// try {
	// // Validamos el comportamiento que nos dan como entrada
	// trazas.aceptaNuevaTraza(new InfoTraza(nombreInstanciaAgente,tipoEntidad,
	// nombreInstanciaAgente + ":Creacion del Agente ...ok", NivelTraza.debug));
	// String rutaAutomata = obtenerRutaValidaAutomata ( rutaComportamiento );
	// if (rutaAutomata != null){
	// // Class AccionesSemanticas = obtenerClaseAccionesSemanticas
	// (rutaComportamiento);
	//
	// // Creamos las acciones semanticas
	// // AccionesSemanticasAgenteReactivo accionesSemanticasEspecificas =
	// (AccionesSemanticasAgenteReactivo)AccionesSemanticas.newInstance();
	//
	// // accionesSemanticasEspecificas.setNombreAgente(nombreInstanciaAgente);
	// //Paso 3 Se intenta la creacion de los componentes internos
	// // Paso 3.1 Creacion de la Percepcion del agente
	// this.agente = (AgenteReactivoAbstracto)new
	// AgenteReactivoImp2(nombreInstanciaAgente);
	// // Se crea el control del agente por medio de su factoria
	// // ProcesadorEventosAbstracto control =
	// FactoriaControlAgteReactivo.instancia().crearControlAgteReactivo(
	// accionesSemanticasEspecificas,rutaTabla , nombreInstanciaAgente,
	// itfConsumidorPercepcion, itfProductorPercepcion);
	// ProcesadorEventosAbstracto control =
	// FactoriaControlAgteReactivoInputObjImp0.instance().crearControlAgteReactivo(
	// rutaAutomata , agente);
	// itfControlAgteReactivo = (ItfControlAgteReactivo) control ;
	// // Se crea la percepcion y se le pasa la interfaz del control
	//
	// PercepcionAbstracto percepcion =
	// FactoriaPercepcion.instancia().crearPercepcion(agente,itfControlAgteReactivo);
	// itfGestionPercepcion = (InterfazGestionPercepcion) percepcion;
	// itfProductorPercepcion = (ItfProductorPercepcion) percepcion;
	//
	// // Se crea el automata del ciclo de vida para implementar la interfaz de
	// Gestion
	// ItfUsoAutomataEFsinAcciones itfAutomata = (ItfUsoAutomataEFsinAcciones)
	// ClaseGeneradoraAutomataEFsinAcciones.instance(NombresPredefinidos.FICHERO_AUTOMATA_CICLO_VIDA_COMPONENTE);
	// this.agente.setComponentesInternos(nombreInstanciaAgente,itfAutomata,itfControlAgteReactivo,itfProductorPercepcion,itfGestionPercepcion);
	// // paso 3. 4 Se define la interfaz de uso del agente creado en las
	// acciones semánticas específicas
	//
	// accionesSemanticasEspecificas.setCtrlGlobalAgenteReactivo(agente);
	// accionesSemanticasEspecificas.setCtrlGlobalAgenteReactivo(agente);
	// // Quedan definidos todos los objetos necesarios para implementar el
	// ejemplar creado
	// logger.debug(nombreInstanciaAgente + ":Creacion del Agente ...ok");
	// trazas.aceptaNuevaTraza(new InfoTraza(nombreInstanciaAgente,tipoEntidad,
	// nombreInstanciaAgente + ":Creacion del Agente ...ok", NivelTraza.debug));
	// // Paso 4 Procedemos a registrar las interfaces de la instancia crada en
	// el repositorio
	//
	// repositorioIntfaces.registrarInterfaz(
	// NombresPredefinidos.ITF_GESTION + nombreInstanciaAgente,
	// (ItfGestionAgenteReactivo)agente);
	// repositorioIntfaces.registrarInterfaz(
	// NombresPredefinidos.ITF_USO + nombreInstanciaAgente,
	// (ItfUsoAgenteReactivo)agente);
	//
	// // activamos trazas pesadas
	// agente.setDebug(false);
	// }else {
	// String msgInfoUsuario =
	// "Error no se encuentra el fichero especificado \n"+
	// "Para el comportamiento:" + rutaComportamiento +
	// "En la ruta: " + rutaAutomata + "\n" +
	// "Verifique la existencia del fichero en el directorio src \n";
	// trazas.trazar(this.getClass().getName(),msgInfoUsuario,NivelTraza.error
	// );
	// InfoTraza traza = new
	// InfoTraza(NombresPredefinidos.CONFIGURACION,tipoEntidad,msgInfoUsuario,
	// NivelTraza.error);
	// // ItfUsoRecTrazas.aceptaNuevaTraza(traza);
	// logger.fatal(msgInfoUsuario);
	// }
	// }
	//
	// catch ( ExcepcionEnComponente exc) {
	// logger.error("Error al crear El CONTROL del agente. La factoria no puede crear la instancia o no se pueden obtener la interfaces : "
	// + nombreInstanciaAgente, exc);
	// System.err
	// .println(" No se puede crear el control del agente. La factoria no puede crear la instancia.");
	// exc.putCompDondeEstaContenido("patronAgenteReactivo.contol");
	// exc.putParteAfectada("FactoriaControlAgenteReactivoImp");
	// throw exc;
	// }
	//
	// catch (Exception ex) {
	// logger.error("Error AL CREAR LA PERCEPCION. La factoria no puede crear la instancia : "
	// + nombreInstanciaAgente + " La ruta del  clase A Semanticas  es "
	// +rutaComportamiento , ex);
	// System.err
	// .println(" No se puede crear la Percepcion del agente. La factoria no puede crear la instancia.");
	// throw new ExcepcionEnComponente("patronAgenteReactivo.contol",
	// "posible error al crear la percepcion","percepcion","" );
	// }
	// }
	private String obtenerRutaValidaAutomata(String rutaComportamiento) {
		// La ruta del comportamiento no incluye la clase
		// Obtenemos la clase de AS en l aruta
		// rutaComportamiento =File.separator+rutaComportamiento.replace(".",
		// File.separator);
		// String rutaBusqueda =
		// NombresPredefinidos.RUTA_SRC+rutaComportamiento;
		String msgInfoUsuario;
		rutaComportamiento = "/" + rutaComportamiento.replace(".", "/");
		String rutaAutomata = rutaComportamiento + "/"
				+ NombresPredefinidos.FICHERO_AUTOMATA;
		InputStream input = this.getClass().getResourceAsStream(rutaAutomata);
		logger.debug(rutaAutomata + "?" + ((input != null) ? "  OK" : "  null"));
		if (input != null) {
			return rutaAutomata;
		} else {
			// intentamos otra política de nombrado
			String nombreEntidad = rutaComportamiento
					.substring(rutaComportamiento.lastIndexOf("/") + 1);
			String primerCaracter = nombreEntidad.substring(0, 1);
			nombreEntidad = nombreEntidad.replaceFirst(primerCaracter,
					primerCaracter.toUpperCase());
			rutaAutomata = rutaComportamiento + "/automata" + nombreEntidad
					+ ".xml";
			input = this.getClass().getResourceAsStream(rutaAutomata);
			if (input != null) {
				return rutaAutomata;
			} else {
				// la entidad no se encuentra o no esta definida
				msgInfoUsuario = "Error no se encuentra el fichero especificado \n"
						+ "Para el comportamiento:"
						+ rutaComportamiento
						+ "En la ruta: "
						+ rutaAutomata
						+ "\n"
						+ "Verifique la existencia del fichero en el directorio src \n";
				logger.fatal(msgInfoUsuario);
				// throw new ExcepcionEnComponente ( "PatronAgenteReactivo",
				// "No se encuentra el fichero del automata  en la ruta :"+rutaAutomata,"Factoria del Agente Reactivo",this.getClass().getName()
				// );
				return null;
			}
		}
	}

	// private Class obtenerClaseAccionesSemanticas(DescInstanciaAgente
	// instAgente)throws ExcepcionEnComponente {
	//
	// DescComportamientoAgente comportamiento =
	// instAgente.getDescComportamiento();
	// String ruta = comportamiento.getLocalizacionComportamiento()+"."+
	// NombresPredefinidos.PREFIJO_CLASE_ACCIONES_SEMANTICAS +
	// comportamiento.getNombreComportamiento();
	// try {
	// Class claseAcciones = Class.forName(ruta);
	// return claseAcciones;
	// } catch (ClassNotFoundException ex) {
	// java.util.logging.Logger.getLogger(FactoriaAgenteReactivoImp.class.getName()).log(Level.SEVERE,
	// null, ex);
	// throw new ExcepcionEnComponente ( "PatronAgenteReactivo",
	// "No se encuentra la clase de acciones semanticas en la ruta :"+ruta,"Factoria del Agente Reactivo","Class obtenerClaseAccionesSemanticas(DescInstanciaAgente instAgente)"
	// );
	// }
	// }

	// private Class obtenerClaseAccionesSemanticas(String
	// rutaComportamiento)throws ExcepcionEnComponente {
	// String msgInfoUsuario;
	// // rutaComportamiento = "/" +rutaComportamiento.replace(".", "/");
	// String nombreEntidad =
	// rutaComportamiento.substring(rutaComportamiento.lastIndexOf(".")+1);
	// String primerCaracter= nombreEntidad.substring(0,1);
	// nombreEntidad = nombreEntidad.replaceFirst(primerCaracter,
	// primerCaracter.toUpperCase());
	// String rutaAccionesSemanticas = rutaComportamiento+
	// "."+NombresPredefinidos.NOMBRE_ACCIONES_SEMANTICAS+nombreEntidad;
	// try {
	// Class claseAcciones = Class.forName(rutaAccionesSemanticas);
	// return claseAcciones;
	// } catch (ClassNotFoundException ex) {
	// java.util.logging.Logger.getLogger(FactoriaAgenteReactivoImp.class.getName()).log(Level.SEVERE,
	// null, ex);
	// throw new ExcepcionEnComponente ( "PatronAgenteReactivo",
	// "No se encuentra la clase de acciones semanticas en la ruta :"+rutaComportamiento,"Factoria del Agente Reactivo","Class obtenerClaseAccionesSemanticas(DescInstanciaAgente instAgente)"
	// );
	// }
	// }
	/*
	 * private Class obtenerClaseAccionesSemanticas(String
	 * rutaComportamiento)throws ExcepcionEnComponente { // La ruta del
	 * comportamiento no incluye la clase // Obtenemos la clase de AS en la ruta
	 * String rutaClases = rutaComportamiento; rutaComportamiento =
	 * NombresPredefinidos
	 * .RUTA_SRC+File.separator+rutaComportamiento.replace(".", File.separator);
	 * // rutaComportamiento = utils.constantes.rutassrc
	 * +File.separator+rutaComportamiento.replace(".", File.separator); String[]
	 * ficherosRuta = (new File (rutaComportamiento)).list() ; // Buscamos la
	 * clase de acciones semanticas en el array con los ficheros Boolean
	 * ClaseASEncontrada=false; String nombreClase= ""; for (int i=0;
	 * (i<ficherosRuta.length)&!ClaseASEncontrada; i++){ nombreClase =
	 * ficherosRuta[ i ]; if
	 * (nombreClase.startsWith(NombresPredefinidos.PREFIJO_CLASE_ACCIONES_SEMANTICAS
	 * )& (nombreClase.lastIndexOf(".java")!= 0) ){ ClaseASEncontrada = true; }
	 * } if (ClaseASEncontrada = true) { try {
	 * 
	 * rutaClases = rutaClases+"."+nombreClase; rutaClases
	 * =rutaClases.replace(".java", ""); int i=1; Class claseAcciones =
	 * Class.forName(rutaClases); return claseAcciones; } catch
	 * (ClassNotFoundException ex) {
	 * java.util.logging.Logger.getLogger(FactoriaAgenteReactivoImp
	 * .class.getName()).log(Level.SEVERE, null, ex); throw new
	 * ExcepcionEnComponente ( "PatronAgenteReactivo",
	 * "No se encuentra la clase de acciones semanticas en la ruta :"
	 * +rutaComportamiento,"Factoria del Agente Reactivo",
	 * "Class obtenerClaseAccionesSemanticas(DescInstanciaAgente instAgente)" );
	 * } } else throw new ExcepcionEnComponente ( "PatronAgenteReactivo",
	 * "No se encuentra la clase de acciones semanticas en la ruta :"
	 * +rutaComportamiento,"Factoria del Agente Reactivo",
	 * "Class obtenerClaseAccionesSemanticas(DescInstanciaAgente instAgente)" );
	 * }
	 */

	// private AccionesSemanticasAgenteReactivo
	// obtenerAcciones(DescInstanciaAgente instAgente) {
	//
	// DescComportamientoAgente comportamiento =
	// instAgente.getDescComportamiento();
	//
	// TipoAgente tipo = comportamiento.getTipo();
	// String nombreCptoAgte = instAgente.getId();
	// String msgUsuario = null;
	// if (!comportamiento.getTipo().equals(TipoAgente.REACTIVO)) {
	// msgUsuario= "El tipo de agente definido es : " +comportamiento.getTipo()
	// +" Debe ser REACTIVO ";
	// trazas.trazar (nombreCptoAgte,msgUsuario,NivelTraza.error );
	// System.err.println(msgUsuario);
	// }
	// // String ruta = comportamiento.getLocalizacionComportamiento()+"."+
	// NombresPredefinidos.PREFIJO_CLASE_ACCIONES_SEMANTICAS +
	// comportamiento.getNombreComportamiento();
	// String rutaAcciones = comportamiento.getLocalizacionClaseAcciones();
	// // String rutaAutomata = comportamiento.getLocalizacionFicheroAutomata();
	// if(rutaAcciones==null){
	// trazas.trazar(nombreCptoAgte,
	// "La ruta de la clase de Acciones semanticas del comportamiento : "
	// +nombreCptoAgte +"  no esta definida \n", NivelTraza.error);
	// return null;
	// }
	//
	// try {
	// Class claseAcciones = Class.forName(rutaAcciones);
	// AccionesSemanticasAgenteReactivo acciones =
	// (AccionesSemanticasAgenteReactivo)claseAcciones.newInstance();
	// acciones.setNombreAgente(nombre);
	// return acciones;
	// } catch (InstantiationException ex) {
	// msgUsuario= "La clase :"+ rutaAcciones +
	// "que debe implementar las acciones del gestor , no puede instanciarse.";
	// trazas.trazar (nombreCptoAgte,msgUsuario,NivelTraza.error );
	// System.err.println(msgUsuario);
	// } catch (IllegalAccessException ex) {
	// msgUsuario= "La clase :"+ rutaAcciones +
	// "que debe implementar las acciones del gestor , no tiene un constructor sin parametros.";
	// trazas.trazar (nombreCptoAgte,msgUsuario,NivelTraza.error );
	// System.err.println(msgUsuario);
	// } catch (ClassNotFoundException ex) {
	// msgUsuario= "La clase :"+ rutaAcciones +
	// "que debe implementar las acciones del gestor , no existe.";
	// trazas.trazar (nombreCptoAgte,msgUsuario,NivelTraza.error );
	// System.err.println(msgUsuario);
	// System.err
	// .println("La clase "
	// + rutaAcciones
	// + "que debe implementar las acciones semanticas, no existe.");
	// }
	// // si falla algo, devuelvo un null
	// return null;
	// }
	//
	// /**
	// * Lee del fichero de config la ruta de la tabla de transiciones
	// *
	// * @param ficheroConfig
	// * @return
	// */
	// private String obtenerRutaTablaTransiciones(DescInstanciaAgente
	// instAgente) {
	// DescComportamientoAgente comportamiento =
	// instAgente.getDescComportamiento();
	// // String ruta = null;
	// if (!comportamiento.getTipo().name().equals(TipoAgente.REACTIVO.name()))
	// {
	// logger.debug(nombreInstanciaAgente +
	// ":La descripcion del comportamiento no es la de un agente reactivo");
	// }
	// String ruta = "/"+comportamiento.getLocalizacionComportamiento();
	// return ruta.replace(".", "/")+"/automata.xml";
	//
	// /*
	// String ruta = "./automatas/TablaEstados"+nombreAgente+".xml";
	// return ruta;
	// */
	// }

	/**
	 * Introduce un nuevo evento en la percepcion
	 *
	 * @param evento
	 *            Evento que llega nuevo
	 */
	public void setParametrosLoggerAgReactivo(String archivoLog, String nivelLog) {
		new ConfiguracionTrazas(logger, archivoLog, nivelLog);
	}
}

/**
 * Lee del fichero de config el nombre del agente
 *
 * @param ficheroConfig
 * @return
 */
// private String obtenerNombre(ConfiguracionGlobal config) {
// String nombre = config.getNombre();
// return nombre;
// }
// public static void main(String args[]) {
// XMLParserTablaEstadosAutomataEFinputObj prueba1 = new
// XMLParserTablaEstadosAutomataEFinputObj("Iniciador");
// prueba1.extraeTablaEstadosDesdeFicheroXML("/icaro/infraestructura/entidadesBasicas/componentesBasicos/automatas/clasesImpAutomatas/automataPrueba.xml",
// null);
// String rutaFichero = prueba1.obtenerRutaValidaAutomata
// (NombresPredefinidos.COMPORTAMIENTO_PORDEFECTO_INICIADOR);
// prueba1.extraeTablaEstadosDesdeFicheroXML("/icaro/gestores/iniciador/automataPrueba.xml",
// null);
// prueba1.extraeTablaEstadosDesdeFicheroXML("/icaro/pruebas/automataPruebas.xml",
// null);
// String rutaFicheroAutomata = "/icaro/gestores/iniciador/automataPrueba.xml";
// // da error
// // String rutaFicheroAutomata = "/icaro/pruebas/automataPruebas.xml";
// // String rutaCarpetaAcciones = "icaro.pruebas";
// // String identPropietario = "Iniciador";
// // String origen = "prueba1";
// // String destino = identPropietario;
// // String estadoActual;
// // Boolean esEstadoFinal;
// // try {
// //// AgenteReactivoAbstracto itfPrueba =
// FactoriaAgenteReactivoInputObjImp0.instance().
// ////
// crearAgenteReactivo(rutaFicheroAutomata,rutaCarpetaAcciones,identPropietario);
// // FactoriaComponenteIcaro.instanceAgteReactInpObj().
// //
// crearAgenteReactivo(rutaFicheroAutomata,rutaCarpetaAcciones,identPropietario);
// // EventoRecAgte eventoPrueba = new EventoRecAgte("comenzar",
// origen,destino);
// // ItfUsoAgenteReactivo itfPrueba =
// NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ
// // itfPrueba.aceptaEvento(eventoPrueba);
// // } catch (Exception ex) {
// //
// java.util.logging.Logger.getLogger(FactoriaAgenteReactivoInputObjImp0.class.getName()).log(Level.SEVERE,
// null, ex);
// // }
// //// interpretePrueba.volverAEstadoInicial(); // Estado inicial dela utomata
// //// estadoActual = interpretePrueba.estadoActual(); // debe dar el estado
// inicial
// //// esEstadoFinal = interpretePrueba.esEstadoFinal(estadoActual); // debe
// dar falso
// //// interpretePrueba.cambiarEstado("creandoRecursosNucleoOrganizacion");
// //// estadoActual = interpretePrueba.estadoActual();
// //// interpretePrueba.cambiarEstado("creandoRecursosNucleoOrganizacio"); //
// deben salir las trazas
// //// interpretePrueba.ejecutarTransicion("existenEntidadesDescripcion",
// (Object) null);
// // }
//
//
// }