package icaro.aplicaciones.agentes.AgenteAplicacionDialogoQuedadas.tareas;

import icaro.aplicaciones.informacion.gestionQuedadas.NotificacionQuedada;
import icaro.aplicaciones.informacion.gestionQuedadas.VocabularioGestionQuedadas;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaComunicacion;

/**
 *
 * @author SONIAGroup
 */
public class NotificarQuedadaCompletada extends TareaComunicacion {

	@Override
	public void ejecutar(Object... params) {
		String idChat = (String) params[0];
		this.getIdentTarea();
		this.getIdentAgente();
		try {
			NotificacionQuedada notif = new NotificacionQuedada(idChat);
			this.informaraOtroAgente(notif, VocabularioGestionQuedadas.IdentAgenteIdentificador);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
