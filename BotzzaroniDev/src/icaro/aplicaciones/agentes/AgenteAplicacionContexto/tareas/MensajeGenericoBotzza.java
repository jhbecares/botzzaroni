/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package icaro.aplicaciones.agentes.AgenteAplicacionContexto.tareas;

import icaro.aplicaciones.informacion.gestionPizzeria.VocabularioGestionPizzeria;
import icaro.aplicaciones.recursos.comunicacionChat.ItfUsoComunicacionChat;
import icaro.aplicaciones.recursos.interfazChatUsuario.ItfUsoInterfazChatUsuario;
import icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.CausaTerminacionTarea;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;

/**
 *
 * @author SONIAGroup
 */
public class MensajeGenericoBotzza extends TareaSincrona {
	private Objetivo contextoEjecucionTarea = null;

	@Override
	public void ejecutar(Object... params) {

		String identDeEstaTarea = this.getIdentTarea();
		String identAgenteOrdenante = this.getIdentAgente();
		String identInterlocutor = (String) params[0];
		String mensaje = (String) params[1];
		try {
			// // Se busca la interfaz del recurso en el repositorio de
			// interfaces
			ItfUsoInterfazChatUsuario recComunicacionChat = (ItfUsoInterfazChatUsuario) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ
					.obtenerInterfazUso(VocabularioGestionPizzeria.IdentRecursoComunicacionChat);
						
			if (recComunicacionChat != null) {
                recComunicacionChat.setIdentAgteAreportar(this.identAgente);
				recComunicacionChat.mostrarVisualizadorChatUsuario(identAgenteOrdenante, NombresPredefinidos.TIPO_COGNITIVO);
                recComunicacionChat.mostrarTexto(VocabularioGestionPizzeria.IdentConexionAgte + " " + mensaje);

			} 
			else {
				identAgenteOrdenante = this.getAgente().getIdentAgente();
				this.generarInformeConCausaTerminacion(
						identDeEstaTarea,
						contextoEjecucionTarea,
						identAgenteOrdenante,
						"Error-AlObtener:Interfaz:"
								+ VocabularioGestionPizzeria.IdentRecursoComunicacionChat,
						CausaTerminacionTarea.ERROR);
			}
		} catch (Exception e) {
			this.generarInformeConCausaTerminacion(
					identDeEstaTarea,
					contextoEjecucionTarea,
					identAgenteOrdenante,
					"Error-Acceso:Interfaz:"
							+ VocabularioGestionPizzeria.IdentRecursoComunicacionChat,
					CausaTerminacionTarea.ERROR);
			e.printStackTrace();
		}
	}

}
