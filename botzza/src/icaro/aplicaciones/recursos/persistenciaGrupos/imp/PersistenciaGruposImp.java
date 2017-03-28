package icaro.aplicaciones.recursos.persistenciaGrupos.imp;

import icaro.aplicaciones.informacion.IOUtils;
import icaro.aplicaciones.informacion.gestionQuedadas.Grupo;
import java.io.Serializable;
import java.util.Map;


/**
 * @author: Jorge Casas Hernan
 */
public class PersistenciaGruposImp implements Serializable {

	private static final String GRUPOS_PATH = "grupos";
	private static Map<String, Grupo> tablaGrupos = IOUtils.read(GRUPOS_PATH);
	private static final long serialVersionUID = 3791013440695899189L;

	public static void insertarGrupo(Grupo grupo) {
		tablaGrupos.put(grupo.getId(), grupo);
		IOUtils.write(GRUPOS_PATH, tablaGrupos);
	}

	
	
	public static Grupo obtenerGrupo(String idGrupo) {
		return tablaGrupos.get(idGrupo);
	}
	

}
