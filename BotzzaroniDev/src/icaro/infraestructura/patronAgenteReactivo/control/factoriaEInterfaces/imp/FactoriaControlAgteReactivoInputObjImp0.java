/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package icaro.infraestructura.patronAgenteReactivo.control.factoriaEInterfaces.imp;

import icaro.infraestructura.entidadesBasicas.componentesBasicos.automatas.automataEFconGesAcciones.InterpreteAutomataEFconGestAcciones;
import icaro.infraestructura.entidadesBasicas.excepciones.ExcepcionEnComponente;
import icaro.infraestructura.entidadesBasicas.factorias.FactoriaComponenteIcaro;
import icaro.infraestructura.entidadesBasicas.interfaces.InterfazGestion;
import icaro.infraestructura.patronAgenteReactivo.control.GestorAccionesAgteReactivoImp;
import icaro.infraestructura.patronAgenteReactivo.control.AutomataEFE.imp.EjecutorDeAccionesImp;
import icaro.infraestructura.patronAgenteReactivo.control.acciones.AccionesSemanticasAgenteReactivo;
import icaro.infraestructura.patronAgenteReactivo.control.factoriaEInterfaces.ItfControlAgteReactivo;
import icaro.infraestructura.patronAgenteReactivo.control.factoriaEInterfaces.ProcesadorInfoReactivoAbstracto;
import icaro.infraestructura.patronAgenteReactivo.factoriaEInterfaces.AgenteReactivoAbstracto;
import icaro.infraestructura.patronAgenteReactivo.factoriaEInterfaces.imp.ConfiguracionTrazas;
import icaro.infraestructura.patronAgenteReactivo.percepcion.factoriaEInterfaces.ItfConsumidorPercepcion;
import icaro.infraestructura.patronAgenteReactivo.percepcion.factoriaEInterfaces.ItfProductorPercepcion;
import icaro.infraestructura.recursosOrganizacion.recursoTrazas.imp.componentes.InfoTraza;

import org.apache.log4j.Logger;

/**
 *
 * @author Francisco J Garijo
 */

public class FactoriaControlAgteReactivoInputObjImp0 extends
		FactoriaComponenteIcaro {
	private static final long serialVersionUID = 1L;
	/**
	 * Control del agente
	 *
	 * @uml.property name="control"
	 * @uml.associationEnd
	 */
	protected ProcesadorInfoReactivoAbstracto procesadorEventos;
	/**
	 * @uml.property name="itfGesControl"
	 * @uml.associationEnd
	 */
	protected InterfazGestion itfGesControl; // Control
	/**
	 * Percepcion del agente
	 *
	 * @uml.property name="itfConsumidorPercepcion"
	 * @uml.associationEnd
	 */
	protected ItfConsumidorPercepcion itfConsumidorPercepcion;
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
	protected String nombreAgente;
	protected AgenteReactivoAbstracto agente;
	/**
	 * Estado del agente reactivo
	 *
	 * @uml.property name="estado"
	 */
	protected int estado = InterfazGestion.ESTADO_OTRO;
	/**
	 * Acciones semnticas del agente reactivo
	 *
	 * @uml.property name="accionesSemanticas"
	 * @uml.associationEnd
	 */
	protected EjecutorDeAccionesImp accionesSemanticas;

	protected InterpreteAutomataEFconGestAcciones interpAutomat = null;
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
	protected ItfControlAgteReactivo itfGestionControlAgteCreado;
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
	// protected ItfUsoRecursoTrazas trazas;
	// private static FactoriaControlAgteReactivoInputObjImp0 instance;

	// public static FactoriaControlAgteReactivoInputObjImp0 instance() throws
	// ExcepcionEnComponente, RemoteException {
	// try {
	// if (instance == null)
	// instance = new FactoriaControlAgteReactivoInputObjImp0();
	// return instance;
	// } catch (Exception e) {
	// //
	// logger.fatal("\n\nError al comprobar los comportamientos de los gestores, agentes y recursos descritos en el fichero de descripcion del XML "
	// + "FactoriaAgenteReactivoInputObjImp0 ");
	// return null;
	// // throw new
	// ExcepcionEnComponente("\n\nError al comprobar los comportamientos de los gestores, agentes y recursos descritos en el fichero de descripcion del XML "
	// );
	// }
	// }

	// private ItfProductorPercepcion percepcionProductor;
	public synchronized ProcesadorInfoReactivoAbstracto crearControlAgteReactivo(
			String nombreFicheroTablaEstados, String rutaFicheroAccs,
			AgenteReactivoAbstracto agente) throws ExcepcionEnComponente {

		new ConfiguracionTrazas(logger);

		try {
			nombreAgente = agente.getIdentAgente();
			interpAutomat = FactoriaComponenteIcaro.instanceAtms()
					.crearInterpreteAutomataEFconGestorAcciones(nombreAgente,
							nombreFicheroTablaEstados, rutaFicheroAccs, DEBUG);
			GestorAccionesAgteReactivoImp gestorAcciones = new GestorAccionesAgteReactivoImp();
			gestorAcciones.setPropietario(nombreAgente);

			// ProcesadorInfoReactivoAutInObjImp0 procesadorInfoReactivo = new
			// ProcesadorInfoReactivoAutInObjImp0(interpAutomat, agente);
			// if (procesadorInfoReactivo != null ) return
			// procesadorInfoReactivo;
			// this.generarErrorCreacionAutomata(nombreFicheroTablaEstados);
			// throw new ExcepcionEnComponente ("AutomataEFEImp",
			// "no se pudo crear el Automata EFE","Automta EFE","automataControl = new AutomataEFEImp("
			// );
			// }
			interpAutomat.setGestorAcciones(gestorAcciones);
			ProcesadorInfoReactivoAbstracto controlAgte = new ProcesadorInfoReactivoAutInObjImp0(
					interpAutomat, gestorAcciones, agente);
			// gestorAcciones.inicializarInfoAccionesAgteReactivo(agente.getIdentAgente(),agente.getItfProductorPercepcion(),itfCtrlAgte);
			return controlAgte;
			// return new ProcesadorInfoReactivoAutInObjImp0(interpAutomat,
			// agente);
		} catch (Exception ex) {
			this.generarErrorCreacionAutomata(nombreFicheroTablaEstados);
			throw new ExcepcionEnComponente("AutomataEFEImp",
					"no se pudo crear el Automata EFE", "Automta EFE",
					"automataControl = new AutomataEFEImp(");
		}

		// Crea el procesador de eventos
		// this.procesadorEventos = new ProcesadorEventosImp(percConsumidor,
		// automataControl,percProductor, nombreDelAgente);

		// return itfGestionControlAgteCreado = (ItfGestionControlAgteReactivo)
		// new
		// ProcesadorEventosImp(percConsumidor,automataControl,percProductor,
		// nombreDelAgente);

		// elijo la implementacin adecuada (aunque podra haber ms)
	}

	private void generarErrorCreacionAutomata(String nombreFicheroTablaEstados) {
		logger.error("Error al crear el automata del agente " + nombreAgente
				+ " utilizando el fichero " + nombreFicheroTablaEstados);
		if (this.recursoTrazas == null) {
			this.crearRecursoTrazas();
		}
		recursoTrazas
				.aceptaNuevaTraza(new InfoTraza(nombreAgente,
						"Error al crear el automata del agente " + nombreAgente
								+ " utilizando el fichero "
								+ nombreFicheroTablaEstados,
						InfoTraza.NivelTraza.error));
		// throw new ExcepcionEnComponente ("AutomataEFEImp",
		// "no se pudo crear el Automata EFE","Automta EFE","automataControl = new AutomataEFEImp("
		// );
	}

	// public ProcesadorInfoReactivoImp
	// crearControlAgteReactivo(AccionesSemanticasAgenteReactivo
	// accionesSemanticasEspecificas, String nombreFicheroTablaEstados,
	// AgenteReactivoAbstracto agente)throws ExcepcionEnComponente {
	//
	// new ConfiguracionTrazas(logger);
	//
	// trazas = NombresPredefinidos.RECURSO_TRAZAS_OBJ;
	//
	// accionesSemanticasEspecificas.setLogger(logger);
	//
	// // crea las Acciones semnticas referidas al contenedor de acciones
	//
	// // crea el automata de control
	// // AutomataEFEAbstracto ac = null;
	//
	// try {
	// nombreAgente = agente.getIdentAgente();
	// this.accionesSemanticas = new
	// EjecutorDeAccionesImp(accionesSemanticasEspecificas);
	// automataControl = new AutomataEFEImp(nombreFicheroTablaEstados,
	// accionesSemanticas, AutomataEFEImp.NIVEL_TRAZA_DESACTIVADO,nombreAgente
	// );
	// return new ProcesadorInfoReactivoImp(automataControl,
	// accionesSemanticasEspecificas, agente);
	// }
	// catch (Exception ExcepcionNoSePudoCrearAutomataEFE)
	// {
	// logger.error("Error al crear el automata del agente " + nombreAgente +
	// " utilizando el fichero " + nombreFicheroTablaEstados);
	// trazas.aceptaNuevaTraza(new InfoTraza(nombreAgente,
	// "Error al crear el automata del agente " + nombreAgente +
	// " utilizando el fichero " + nombreFicheroTablaEstados,
	// InfoTraza.NivelTraza.error));
	// throw new ExcepcionEnComponente ("AutomataEFEImp",
	// "no se pudo crear el Automata EFE","Automta EFE","automataControl = new AutomataEFEImp("
	// );
	// }
	// // Crea el procesador de eventos
	// // this.procesadorEventos = new ProcesadorEventosImp(percConsumidor,
	// automataControl,percProductor, nombreDelAgente);
	//
	// // return itfGestionControlAgteCreado = (ItfGestionControlAgteReactivo)
	// new ProcesadorEventosImp(percConsumidor,automataControl,percProductor,
	// nombreDelAgente);
	//
	//
	// //elijo la implementacin adecuada (aunque podra haber ms)
	// }

	public synchronized ProcesadorEventosImp crearControlAgteReactivo(
			AccionesSemanticasAgenteReactivo accionesSemanticasEspecificas,
			String nombreFicheroTablaEstados, String nombreDelAgente,
			ItfConsumidorPercepcion percConsumidor,
			ItfProductorPercepcion percProductor) throws ExcepcionEnComponente {
		return null;
	}

	public ProcesadorInfoReactivoAbstracto crearControlAgteReactivo(
			AccionesSemanticasAgenteReactivo accionesSemanticasEspecificas,
			String nombreFicheroTablaEstados, AgenteReactivoAbstracto agente)
			throws ExcepcionEnComponente {
		return null;
	}
}
