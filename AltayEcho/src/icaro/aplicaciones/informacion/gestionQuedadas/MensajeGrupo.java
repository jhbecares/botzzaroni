package icaro.aplicaciones.informacion.gestionQuedadas;

import java.io.Serializable;

public class MensajeGrupo implements Serializable {
	
	private static final long serialVersionUID = -4638466049663386395L;
	static public final int CANCELAR = 0;
	static public final int CONFIRMAR = 1;
	static public final int DENEGAR = 2;
	static public final int SOLICITAR = 3;
	
	public String idGrupoEmisor;
	public String idGrupoDestinatario;
	public int mensaje;

	public MensajeGrupo(String idGrupoEmisor, String idGrupoDestinatario, int mensaje) {
		this.idGrupoEmisor = idGrupoEmisor;
		this.idGrupoDestinatario = idGrupoDestinatario;
		this.mensaje = mensaje;
	}

	public String getIdGrupoEmisor() {
		return idGrupoEmisor;
	}
	
	public String getIdGrupoDestinatario() {
		return idGrupoDestinatario;
	}
	
	public int getMensaje() {
		return mensaje;
	}
}