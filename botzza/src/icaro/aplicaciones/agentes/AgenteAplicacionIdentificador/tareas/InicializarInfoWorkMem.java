/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package icaro.aplicaciones.agentes.AgenteAplicacionIdentificador.tareas;

import icaro.aplicaciones.agentes.AgenteAplicacionIdentificador.objetivos.DistribuirMensajes;
import icaro.aplicaciones.agentes.AgenteAplicacionIdentificador.objetivos.IdentificarUsuario;
import icaro.aplicaciones.agentes.AgenteAplicacionIdentificador.objetivos.Inactividad;
import icaro.aplicaciones.agentes.AgenteAplicacionIdentificador.objetivos.InactividadProlongada;
import icaro.aplicaciones.agentes.AgenteAplicacionIdentificador.objetivos.ObtenerIDGrupo;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;
import icaro.infraestructura.recursosOrganizacion.recursoTrazas.imp.componentes.InfoTraza;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Francisco J Garijo
 */
public class InicializarInfoWorkMem extends TareaSincrona {

	@Override
	public void ejecutar(Object... params) {
		try {
			this.getIdentTarea();
			this.getIdentAgente();
			this.getItfConfigMotorDeReglas()
					.setDepuracionActivationRulesDebugging(true);
			this.getItfConfigMotorDeReglas()
					.setfactHandlesMonitoring_afterActivationFired_DEBUGGING(
							true);
			
		} catch (Exception e) {
			e.printStackTrace();
			trazas.aceptaNuevaTraza(new InfoTraza(this.getIdentAgente(),
					"Error al ejecutar la tarea : " + this.getIdentTarea() + e,
					InfoTraza.NivelTraza.error));
		}
	}

}
