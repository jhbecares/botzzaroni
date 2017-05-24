/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icaro.aplicaciones.informacion.gestionPizzeria;

/**
 *
 * @author FGarijo
 */
// FIXME cambiar grupo por usuario
public class Notificacion {

	public String identNotificador;
	public String mensajeNotificacion;			// mensaje completo del usuario 
	public Object contexto;						// objeto de ayuda para realizar el analisis que no se utiliza aun.
	public String identObjectRefNotificacion;	// no se usa aun
	public String tipoNotificacion;				// anotaciones del gazetero de annie
	public Usuario grupo;							// anotaciones del gazetero de annie

	public Usuario getGrupo() {
		return grupo;
	}

	public void setUsuario(Usuario grupo) {
		this.grupo = grupo;
	}

	public Notificacion() {

	}

	public Notificacion(String grupoId) {
		identNotificador = grupoId;
		tipoNotificacion = mensajeNotificacion = null;
		contexto = null;
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
