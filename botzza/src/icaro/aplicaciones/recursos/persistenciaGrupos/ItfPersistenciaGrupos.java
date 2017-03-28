package icaro.aplicaciones.recursos.persistenciaGrupos;

import icaro.aplicaciones.informacion.gestionQuedadas.Grupo;
import icaro.infraestructura.patronRecursoSimple.ItfUsoRecursoSimple;

public interface ItfPersistenciaGrupos extends ItfUsoRecursoSimple {

	void insertarGrupo(Grupo gr) throws Exception;

	Grupo obtenerGrupo(String idGrupo) throws Exception;

}
