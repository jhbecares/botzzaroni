package icaro.aplicaciones.recursos.persistenciaMensajesGrupo;

import java.rmi.RemoteException;

import icaro.aplicaciones.informacion.gestionQuedadas.MensajeGrupo;
import icaro.aplicaciones.recursos.persistenciaMensajesGrupo.ItfPersistenciaMensajesGrupo;
import icaro.aplicaciones.recursos.persistenciaMensajesGrupo.imp.PersistenciaMensajesGrupoImp;
import icaro.infraestructura.patronRecursoSimple.imp.ImplRecursoSimple;

public class ClaseGeneradoraPersistenciaMensajesGrupo extends ImplRecursoSimple implements ItfPersistenciaMensajesGrupo {

	private static final long serialVersionUID = -7810297424738958743L;

	public ClaseGeneradoraPersistenciaMensajesGrupo(String idRecurso) throws RemoteException {
		super(idRecurso);
		System.out.println("SE CREA EL RECURSO QUE QUERIAMOS");
	}

	@Override
	public void insertarMensajeGrupo(MensajeGrupo mgr) throws Exception {
		PersistenciaMensajesGrupoImp.insertarMensajeGrupo(mgr);
	}

	@Override
	public MensajeGrupo obtenerMensajeGrupo(String idGrupo) throws Exception {
		return PersistenciaMensajesGrupoImp.obtenerMensajeGrupo(idGrupo);
	}
	
	@Override
	public void eliminarMensajeGrupo(String idGrupo) throws Exception {
		PersistenciaMensajesGrupoImp.eliminarMensajeGrupo(idGrupo);
	}
}