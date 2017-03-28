package icaro.aplicaciones.recursos.persistenciaUsuario;

import java.rmi.RemoteException;

import icaro.aplicaciones.informacion.gestionPizzeria.Usuario;
import icaro.aplicaciones.recursos.persistenciaUsuario.impl.PersistenciaUsuariosImp;
import icaro.infraestructura.patronRecursoSimple.imp.ImplRecursoSimple;

public class ClaseGeneradoraPersistenciaUsuario extends ImplRecursoSimple implements ItfPersistenciaUsuario {

	private static final long serialVersionUID = 6249741041405080757L;

	public ClaseGeneradoraPersistenciaUsuario(String idRecurso) throws RemoteException {
		super(idRecurso);
		System.out.println("SE CREA EL RECURSO QUE QUERIAMOS");
	}

	@Override
	public void insertarUsuario(Usuario usuario) throws Exception {
		PersistenciaUsuariosImp.insertarUsuario(usuario);
	}

	@Override
	public Usuario obtenerUsuario(String username) throws Exception {
		return PersistenciaUsuariosImp.obtenerUsuario(username);
	}

}
