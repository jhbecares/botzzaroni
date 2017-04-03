package icaro.aplicaciones.recursos.persistenciaQuedadas.imp;

import icaro.aplicaciones.informacion.IOUtils;
import icaro.aplicaciones.informacion.gestionQuedadas.Quedada;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;


/**
 * @author: Jorge Casas Hernan
 */
public class PersistenciaQuedadasImp implements Serializable {

	private static final long serialVersionUID = -5612569567766313024L;
	private static final String QUEDADAS_PATH = "quedadas";
	private static Map<String, Quedada> tablaQuedadas = IOUtils.read(QUEDADAS_PATH);

	public static void insertarQuedada(Quedada que) {
		tablaQuedadas.put(que.getGrupoEmisor().getId(), que);
		IOUtils.write(QUEDADAS_PATH, tablaQuedadas);
	}
	
	public static void eliminarQuedada(Quedada que) {
		tablaQuedadas.remove(que.getGrupoEmisor().getId());
		IOUtils.write(QUEDADAS_PATH, tablaQuedadas);
	}
	
	public static Quedada obtenerQuedadaDeGrupoEmisor(String idGrupo) {
		return tablaQuedadas.get(idGrupo);
	}
	
	public static Quedada obtenerQuedadaDeGrupoQueAcepta(String idGrupo) {
		for(Quedada que : tablaQuedadas.values()){
			if(que.getGrupoQueAcepta() != null && que.getGrupoQueAcepta().getId().equals(idGrupo)){
				return que;
			}
		}
		return null;
	}
	
	public static Quedada obtenerQuedadaDeGrupo(String idGrupo) {
		Quedada que = obtenerQuedadaDeGrupoEmisor(idGrupo);
		if (que == null)
			que = obtenerQuedadaDeGrupoQueAcepta(idGrupo);
		return que;
	}
	
	public static ArrayList<Quedada> obtenerQuedadasSinGrupoQueAcepta() {
		
		ArrayList<Quedada> q = new ArrayList<Quedada>();
		
		for(Quedada que : tablaQuedadas.values()) {
			if(que.getGrupoQueAcepta() == null)
				q.add(que);
		}
		
		return q;
				
	}

}
