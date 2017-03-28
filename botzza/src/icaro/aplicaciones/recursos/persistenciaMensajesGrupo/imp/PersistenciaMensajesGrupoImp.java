package icaro.aplicaciones.recursos.persistenciaMensajesGrupo.imp;

import icaro.aplicaciones.informacion.IOUtils;
import icaro.aplicaciones.informacion.gestionQuedadas.MensajeGrupo;
import icaro.aplicaciones.informacion.gestionQuedadas.Quedada;

import java.io.Serializable;
import java.util.Map;

public class PersistenciaMensajesGrupoImp implements Serializable {

	private static final long serialVersionUID = 6471866360539062076L;
	private static final String MENSAJES_PATH = "mensajes";
	private static Map<String, MensajeGrupo> tablaMensajesGrupo = IOUtils.read(MENSAJES_PATH);

	public static void insertarMensajeGrupo(MensajeGrupo mgr) {
		tablaMensajesGrupo.put(mgr.getIdGrupoDestinatario(), mgr);
		IOUtils.write(MENSAJES_PATH, tablaMensajesGrupo);
	}

	public static MensajeGrupo obtenerMensajeGrupo(String idGrupo) {
		return tablaMensajesGrupo.get(idGrupo);
	}
	
	public static void eliminarMensajeGrupo(String idGrupo) {
		tablaMensajesGrupo.put(idGrupo, null);
		tablaMensajesGrupo.remove(idGrupo);
		IOUtils.write(MENSAJES_PATH, tablaMensajesGrupo);
	}

}
