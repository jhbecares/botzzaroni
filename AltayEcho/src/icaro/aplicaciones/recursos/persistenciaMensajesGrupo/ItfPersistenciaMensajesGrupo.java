package icaro.aplicaciones.recursos.persistenciaMensajesGrupo;

import icaro.aplicaciones.informacion.gestionQuedadas.MensajeGrupo;
import icaro.infraestructura.patronRecursoSimple.ItfUsoRecursoSimple;

public interface ItfPersistenciaMensajesGrupo extends ItfUsoRecursoSimple {

	void insertarMensajeGrupo(MensajeGrupo mgr) throws Exception;
	MensajeGrupo obtenerMensajeGrupo(String idGrupo) throws Exception;
	void eliminarMensajeGrupo(String idGrupo) throws Exception;
}
