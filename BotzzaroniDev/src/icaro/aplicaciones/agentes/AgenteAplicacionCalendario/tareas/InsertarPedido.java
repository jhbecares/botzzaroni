package icaro.aplicaciones.agentes.AgenteAplicacionCalendario.tareas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import icaro.aplicaciones.informacion.gestionPizzeria.Pedido;
import icaro.aplicaciones.informacion.gestionPizzeria.VocabularioGestionPizzeria;
import icaro.aplicaciones.recursos.interfazChatUsuario.ItfUsoInterfazChatUsuario;
import icaro.aplicaciones.recursos.persistenciaAccesoBD.ItfUsoPersistenciaAccesoBD;
import icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.CausaTerminacionTarea;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;


/*
 *  Par�metros de la tarea
 *  - Pedido a insertar
 *  - Objetivo a cumplir para finalizar el flujo de la aplicaci�n del todo
 */

public class InsertarPedido extends TareaSincrona {
	// private String identAgenteOrdenante ;
	private Objetivo contextoEjecucionTarea = null;

	@Override
	public void ejecutar(Object... params) {
		String identDeEstaTarea = this.getIdentTarea();
		String identAgenteOrdenante = this.getIdentAgente();
		Pedido pedido = (Pedido) params[0];
		//Objetivo obj = (Objetivo) params[1];
		
		try {
			
			String mensaje = null;
			
			String identRecursoPersistencia = "Persistencia1";
			ItfUsoPersistenciaAccesoBD persistencia = (ItfUsoPersistenciaAccesoBD)  NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ.obtenerInterfazUso(
					VocabularioGestionPizzeria.IdentRecursoPersistencia);
			ItfUsoInterfazChatUsuario recComunicacionChat = (ItfUsoInterfazChatUsuario) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ.obtenerInterfazUso(
					VocabularioGestionPizzeria.IdentRecursoComunicacionChat); 
			
			// Insertamos pedido
			persistencia.insertaPedido(pedido);		   
		    
		    // Actualizamos objetivo
			//obj.setSolved();
		    //this.getEnvioHechos().actualizarHecho(obj);
		    
			if (recComunicacionChat != null) {
                //recComunicacionChat.setIdentAgteAreportar(this.identAgente);
				recComunicacionChat.mostrarVisualizadorChatUsuario(identAgenteOrdenante, NombresPredefinidos.TIPO_COGNITIVO);
                //recComunicacionChat.mostrarTexto(VocabularioGestionPizzeria.IdentConexionAgte + ": " +mensaje);
			} 
			else {
				identAgenteOrdenante = this.getAgente().getIdentAgente();
				this.generarInformeConCausaTerminacion(identDeEstaTarea,
						contextoEjecucionTarea, identAgenteOrdenante,
						"Error-AlObtener:Interfaz:"
								+ VocabularioGestionPizzeria.IdentRecursoComunicacionChat,
						CausaTerminacionTarea.ERROR);
			}
			


		} catch (Exception e) {
//			 this.generarInformeConCausaTerminacion(identDeEstaTarea,
//					contextoEjecucionTarea, identAgenteOrdenante,
//					"Error-Acceso:Interfaz:" + identRecursoComunicacionChat,
//					CausaTerminacionTarea.ERROR);
			e.printStackTrace();
		}
	}
}