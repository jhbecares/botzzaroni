
package icaro.aplicaciones.agentes.AgenteAplicacionContexto.tareas;

import icaro.aplicaciones.informacion.gestionQuedadas.VocabularioGestionQuedadas;
import icaro.aplicaciones.recursos.comunicacionChat.ItfUsoComunicacionChat;
import icaro.aplicaciones.recursos.interfazChatUsuario.ItfUsoInterfazChatUsuario;
import icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.CausaTerminacionTarea;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;

/**
 *
 * @author F Garijo
 */
public class MostrarChatUsuario extends TareaSincrona {
	// private String identAgenteOrdenante ;
	private Objetivo contextoEjecucionTarea = null;

	@Override
	public void ejecutar(Object... params) {
		String identDeEstaTarea = this.getIdentTarea();
		String identAgenteOrdenante = this.getIdentAgente();
		String identRecursoComunicacionChat = (String) params[0];
		String nombre = (String) params[1];
		String botname = "Botzzaroni: ";

		try {
			// // Se busca la interfaz del recurso en el repositorio de
			// interfaces
			ItfUsoInterfazChatUsuario recComunicacionChat = (ItfUsoInterfazChatUsuario) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ.obtenerInterfazUso(
					VocabularioGestionQuedadas.IdentRecursoComunicacionChat); 
			if (recComunicacionChat != null) {
                recComunicacionChat.setIdentAgteAreportar(this.identAgente);
				recComunicacionChat.mostrarVisualizadorChatUsuario(identAgenteOrdenante, NombresPredefinidos.TIPO_COGNITIVO);
                String mensajeAenviar = VocabularioGestionQuedadas.SaludoInicial1;
                recComunicacionChat.mostrarTexto(botname + mensajeAenviar);
                recComunicacionChat.setIdentidadUsuario(nombre);

			} 
			else {
				identAgenteOrdenante = this.getAgente().getIdentAgente();
				this.generarInformeConCausaTerminacion(identDeEstaTarea,
						contextoEjecucionTarea, identAgenteOrdenante,
						"Error-AlObtener:Interfaz:"
								+ identRecursoComunicacionChat,
						CausaTerminacionTarea.ERROR);
			}
		} catch (Exception e) {
			this.generarInformeConCausaTerminacion(identDeEstaTarea,
					contextoEjecucionTarea, identAgenteOrdenante,
					"Error-Acceso:Interfaz:" + identRecursoComunicacionChat,
					CausaTerminacionTarea.ERROR);
			e.printStackTrace();
		}
	}
}
