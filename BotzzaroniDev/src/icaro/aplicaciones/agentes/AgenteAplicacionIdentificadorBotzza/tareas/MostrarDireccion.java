package icaro.aplicaciones.agentes.AgenteAplicacionIdentificadorBotzza.tareas;

import icaro.aplicaciones.informacion.gestionPizzeria.Usuario;
import icaro.aplicaciones.informacion.gestionPizzeria.VocabularioGestionPizzeria;
import icaro.aplicaciones.recursos.interfazChatUsuario.ItfUsoInterfazChatUsuario;
import icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.CausaTerminacionTarea;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;

public class MostrarDireccion extends TareaSincrona {
	
	private Objetivo contextoEjecucionTarea = null;

	@Override
	public void ejecutar(Object... params) {

		String identDeEstaTarea = this.getIdentTarea();
		String identAgenteOrdenante = this.getIdentAgente();
		Usuario user = (Usuario) params[0];
		
		String mensaje = "La dirección que tenemos apuntada es" + user.getDireccion().toString();
		try {
			// // Se busca la interfaz del recurso en el repositorio de
			// interfaces
			ItfUsoInterfazChatUsuario recComunicacionChat = (ItfUsoInterfazChatUsuario) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ.obtenerInterfazUso(
					VocabularioGestionPizzeria.IdentRecursoComunicacionChat); 
			if (recComunicacionChat != null) {
				recComunicacionChat.mostrarVisualizadorChatUsuario(identAgenteOrdenante, NombresPredefinidos.TIPO_COGNITIVO);
                recComunicacionChat.mostrarTexto(VocabularioGestionPizzeria.IdentConexionAgte + " " + mensaje);

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
