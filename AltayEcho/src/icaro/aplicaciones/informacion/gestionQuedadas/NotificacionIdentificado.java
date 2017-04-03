/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icaro.aplicaciones.informacion.gestionQuedadas;

/**
 *
 * @author SONIAGroup
 */
public class NotificacionIdentificado {

	public String identNotificador;
	// mensaje completo del usuario (grupo)
	public String mensajeNotificacion;
	// objeto de ayuda para realizar el analisis que no se utiliza aun.
	public Object contexto;
	// no se usa aun
	public String identObjectRefNotificacion;
	// anotaciones del gazetero de annie
	public String tipoNotificacion;
	// anotaciones del gazetero de annie
	public Quedada quedada;
	public Grupo grupo;

	public Grupo getGrupo() {
		return grupo;
	}
	
	public Quedada getQuedada() {
		return quedada;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public NotificacionIdentificado(String chatName, Grupo gr) {
		identNotificador = chatName;
		grupo = gr;
		tipoNotificacion = mensajeNotificacion = null;
		contexto = null;
		quedada = null;
	}
	
	public NotificacionIdentificado(String chatName, Grupo gr, Quedada que) {
		identNotificador = chatName;
		grupo = gr;
		tipoNotificacion = mensajeNotificacion = null;
		contexto = null;
		quedada = que;
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
