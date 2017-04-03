package icaro.aplicaciones.informacion.gestionQuedadas;

import icaro.aplicaciones.informacion.gestionQuedadas.Notificacion;
import icaro.aplicaciones.informacion.gestionQuedadas.Grupo;

public class NotificacionQuedada {
	public String identNotificador;
	public String mensajeNotificacion;
	public Object contexto;
	public String identObjectRefNotificacion;
	public String tipoNotificacion;
	public Grupo grupo;

	public NotificacionQuedada() {
	}
	
	public NotificacionQuedada(String identNotificador) {
		this.identNotificador = identNotificador;
	}

	public NotificacionQuedada(Notificacion notif) {
		identNotificador = notif.getidentNotificador();
		setMensajeNotificacion(notif.getMensajeNotificacion());
		setcontexto(notif.getcontexto());
		setidentObjectRefNotificacion(notif.getidentObjectRefNotificacion());
		setTipoNotificacion(notif.getTipoNotificacion());
		setGrupo(notif.getGrupo());
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public String getidentObjectRefNotificacion() {
		return identObjectRefNotificacion;
	}

	public void setidentObjectRefNotificacion(String identObjRef) {
		identObjectRefNotificacion = identObjRef;
	}

	public void setMensajeNotificacion(String notificacion) {
		mensajeNotificacion = notificacion;
	}

	public String getMensajeNotificacion() {
		return mensajeNotificacion;
	}

	public void setTipoNotificacion(String notifTipo) {
		tipoNotificacion = notifTipo;
	}

	public String getTipoNotificacion() {
		return tipoNotificacion;
	}

	public String getidentNotificador() {
		return identNotificador;
	}

	public void setcontexto(Object contContexto) {
		contexto = contContexto;
	}

	public Object getcontexto() {
		return contexto;
	}

	@Override
	public String toString() {
		if (contexto == null) {
			return "Ident Notificador :" + identNotificador
					+ " Tipo Notificacion :" + tipoNotificacion
					+ " MensajeNotificacion :+" + mensajeNotificacion
					+ "  Contexto: null " + "\n ";
		} else {
			return "Agente Emisor :" + identNotificador
					+ " MensajePropuesta :+" + mensajeNotificacion
					+ "  Justificacion: " + contexto.toString() + "\n ";
		}
	}

}