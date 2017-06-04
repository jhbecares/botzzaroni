package icaro.aplicaciones.agentes.AgenteAplicacionIdentificadorBotzza.tareas;

import icaro.aplicaciones.informacion.gestionPizzeria.Usuario;
import icaro.aplicaciones.informacion.gestionPizzeria.VocabularioGestionPizzeria;
import icaro.aplicaciones.recursos.interfazChatUsuario.ItfUsoInterfazChatUsuario;
import icaro.aplicaciones.recursos.persistenciaAccesoBD.ItfUsoPersistenciaAccesoBD;
import icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.CausaTerminacionTarea;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;

public class ActualizaDatosUsuario extends TareaSincrona {
	
	private Objetivo contextoEjecucionTarea = null;

	@Override
	public void ejecutar(Object... params) {

		String identDeEstaTarea = this.getIdentTarea();
		String identAgenteOrdenante = this.getIdentAgente();
		Usuario user = (Usuario) params[0];
		
		String identRecursoPersistencia = "Persistencia1";
		try {
			ItfUsoPersistenciaAccesoBD persistencia = (ItfUsoPersistenciaAccesoBD)  NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ.obtenerInterfazUso(
					VocabularioGestionPizzeria.IdentRecursoPersistencia);
			 persistencia.insertaDatosUsuario(user);
			
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