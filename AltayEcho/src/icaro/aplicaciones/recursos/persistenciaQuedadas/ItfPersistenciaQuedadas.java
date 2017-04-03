package icaro.aplicaciones.recursos.persistenciaQuedadas;

import java.util.ArrayList;

import icaro.aplicaciones.informacion.gestionQuedadas.Quedada;
import icaro.infraestructura.patronRecursoSimple.ItfUsoRecursoSimple;

public interface ItfPersistenciaQuedadas extends ItfUsoRecursoSimple {

	void insertarQuedada(Quedada que) throws Exception;
	void eliminarQuedada(Quedada que) throws Exception;
	Quedada obtenerQuedadaDeGrupoEmisor(String idGrupo) throws Exception;
	Quedada obtenerQuedadaDeGrupoQueAcepta(String idGrupo) throws Exception;
	Quedada obtenerQuedadaDeGrupo(String idGrupo) throws Exception;
	ArrayList<Quedada> obtenerQuedadasSinGrupoQueAcepta() throws Exception;

}
