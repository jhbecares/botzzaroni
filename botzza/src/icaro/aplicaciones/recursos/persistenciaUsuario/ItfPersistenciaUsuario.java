package icaro.aplicaciones.recursos.persistenciaUsuario;

import icaro.aplicaciones.informacion.gestionPizzeria.*;
import icaro.infraestructura.patronRecursoSimple.ItfUsoRecursoSimple;

public interface ItfPersistenciaUsuario extends ItfUsoRecursoSimple {

	void insertarUsuario(Usuario gr) throws Exception;

	Usuario obtenerUsuario(String idUsuario) throws Exception;

}
