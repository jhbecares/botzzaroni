package icaro.aplicaciones.recursos.persistenciaGrupos;

import java.rmi.RemoteException;
import icaro.aplicaciones.informacion.gestionQuedadas.Grupo;
import icaro.aplicaciones.recursos.persistenciaGrupos.ItfPersistenciaGrupos;
import icaro.aplicaciones.recursos.persistenciaGrupos.imp.PersistenciaGruposImp;
import icaro.infraestructura.patronRecursoSimple.imp.ImplRecursoSimple;

public class ClaseGeneradoraPersistenciaGrupos extends ImplRecursoSimple implements ItfPersistenciaGrupos {

	private static final long serialVersionUID = 6249741041405080757L;

	public ClaseGeneradoraPersistenciaGrupos(String idRecurso) throws RemoteException {
		super(idRecurso);
		System.out.println("SE CREA EL RECURSO QUE QUERIAMOS");
	}

	@Override
	public void insertarGrupo(Grupo gr) throws Exception {
		PersistenciaGruposImp.insertarGrupo(gr);
	}

	@Override
	public Grupo obtenerGrupo(String idGrupo) throws Exception {
		return PersistenciaGruposImp.obtenerGrupo(idGrupo);
	}

}
