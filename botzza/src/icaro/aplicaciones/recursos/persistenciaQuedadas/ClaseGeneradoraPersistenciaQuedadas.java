package icaro.aplicaciones.recursos.persistenciaQuedadas;

import java.rmi.RemoteException;
import java.util.ArrayList;

import icaro.aplicaciones.informacion.gestionQuedadas.Quedada;
import icaro.aplicaciones.recursos.persistenciaQuedadas.ItfPersistenciaQuedadas;
import icaro.aplicaciones.recursos.persistenciaQuedadas.imp.PersistenciaQuedadasImp;
import icaro.infraestructura.patronRecursoSimple.imp.ImplRecursoSimple;

public class ClaseGeneradoraPersistenciaQuedadas extends ImplRecursoSimple implements ItfPersistenciaQuedadas {

	private static final long serialVersionUID = 6249741041405080757L;

	public ClaseGeneradoraPersistenciaQuedadas(String idRecurso) throws RemoteException {
		super(idRecurso);
		System.out.println("SE CREA EL RECURSO QUE QUERIAMOS");
	}

	@Override
	public void insertarQuedada(Quedada que) throws Exception {
		PersistenciaQuedadasImp.insertarQuedada(que);
	}
	
	@Override
	public void eliminarQuedada(Quedada que) throws Exception {
		PersistenciaQuedadasImp.eliminarQuedada(que);
	}

	@Override
	public Quedada obtenerQuedadaDeGrupoEmisor(String idGrupo) throws Exception {
		return PersistenciaQuedadasImp.obtenerQuedadaDeGrupoEmisor(idGrupo);
	}
	
	@Override
	public Quedada obtenerQuedadaDeGrupoQueAcepta(String idGrupo) throws Exception {
		return PersistenciaQuedadasImp.obtenerQuedadaDeGrupoQueAcepta(idGrupo);
	}
	
	@Override
	public Quedada obtenerQuedadaDeGrupo(String idGrupo) throws Exception {
		return PersistenciaQuedadasImp.obtenerQuedadaDeGrupo(idGrupo);
	}

	@Override
	public ArrayList<Quedada> obtenerQuedadasSinGrupoQueAcepta() throws Exception {
		return PersistenciaQuedadasImp.obtenerQuedadasSinGrupoQueAcepta();
	}

}