/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package icaro.aplicaciones.agentes.AgenteAplicacionDialogoQuedadas.tareas;

import icaro.aplicaciones.agentes.AgenteAplicacionDialogoQuedadas.objetivos.IdentificarOtroGrupo;
import icaro.aplicaciones.agentes.AgenteAplicacionDialogoQuedadas.objetivos.ObtenerConfirmacion;
import icaro.aplicaciones.agentes.AgenteAplicacionDialogoQuedadas.objetivos.ObtenerDiaQuedada;
import icaro.aplicaciones.agentes.AgenteAplicacionDialogoQuedadas.objetivos.ObtenerDonde;
import icaro.aplicaciones.agentes.AgenteAplicacionDialogoQuedadas.objetivos.ObtenerEdadOtroGrupo;
import icaro.aplicaciones.agentes.AgenteAplicacionDialogoQuedadas.objetivos.ObtenerFechaQuedada;
import icaro.aplicaciones.agentes.AgenteAplicacionDialogoQuedadas.objetivos.ObtenerHoraQuedada;
import icaro.aplicaciones.agentes.AgenteAplicacionDialogoQuedadas.objetivos.ObtenerNumIntegrantesOtroGrupo;
import icaro.aplicaciones.agentes.AgenteAplicacionDialogoQuedadas.objetivos.ObtenerQueHacer;
import icaro.aplicaciones.agentes.AgenteAplicacionDialogoQuedadas.objetivos.ObtenerSexoOtroGrupo;
import icaro.aplicaciones.informacion.gestionQuedadas.FocoGrupo;
import icaro.aplicaciones.informacion.gestionQuedadas.Quedada;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaComunicacion;
import icaro.infraestructura.recursosOrganizacion.recursoTrazas.imp.componentes.InfoTraza;

/**
 *
 * @author SONIAGroup
 */
public class EliminarSesionQuedadaGrupo extends TareaComunicacion{

	@Override
	public void ejecutar(Object... params) {
		String chat = (String) params[0];
		
		try {
			for (Object g : this.getEnvioHechos().getItfMotorDeReglas()
					.getStatefulKnowledgeSession().getObjects()) {

				if (g instanceof Objetivo) {
					
					if ( g instanceof IdentificarOtroGrupo) {
						Objetivo ob = (IdentificarOtroGrupo) g;
						if (ob.getobjectReferenceId().equals(chat)) {
							this.getEnvioHechos().eliminarHechoWithoutFireRules(ob);
						}
					}
					
					else if ( g instanceof ObtenerDiaQuedada) {
						Objetivo ob = (ObtenerDiaQuedada) g;
						if (ob.getobjectReferenceId().equals(chat)) {
							this.getEnvioHechos().eliminarHechoWithoutFireRules(ob);
						}
					}
					
					else if ( g instanceof ObtenerHoraQuedada) {
						Objetivo ob = (ObtenerHoraQuedada) g;
						if (ob.getobjectReferenceId().equals(chat)) {
							this.getEnvioHechos().eliminarHechoWithoutFireRules(ob);
						}
					}
					
					else if ( g instanceof ObtenerFechaQuedada) {
						Objetivo ob = (ObtenerFechaQuedada) g;
						if (ob.getobjectReferenceId().equals(chat)) {
							this.getEnvioHechos().eliminarHechoWithoutFireRules(ob);
						}
					}
					
					else if ( g instanceof ObtenerDonde) {
						Objetivo ob = (ObtenerDonde) g;
						if (ob.getobjectReferenceId().equals(chat)) {
							this.getEnvioHechos().eliminarHechoWithoutFireRules(ob);
						}
					}
					
					else if ( g instanceof ObtenerQueHacer) {
						Objetivo ob = (ObtenerQueHacer) g;
						if (ob.getobjectReferenceId().equals(chat)) {
							this.getEnvioHechos().eliminarHechoWithoutFireRules(ob);
						}
					}
					
					else if ( g instanceof ObtenerEdadOtroGrupo) {
						Objetivo ob = (ObtenerEdadOtroGrupo) g;
						if (ob.getobjectReferenceId().equals(chat)) {
							this.getEnvioHechos().eliminarHechoWithoutFireRules(ob);
						}
					}
					
					else if ( g instanceof ObtenerNumIntegrantesOtroGrupo) {
						Objetivo ob = (ObtenerNumIntegrantesOtroGrupo) g;
						if (ob.getobjectReferenceId().equals(chat)) {
							this.getEnvioHechos().eliminarHechoWithoutFireRules(ob);
						}
					}
					
					else if ( g instanceof ObtenerSexoOtroGrupo) {
						Objetivo ob = (ObtenerSexoOtroGrupo) g;
						if (ob.getobjectReferenceId().equals(chat)) {
							this.getEnvioHechos().eliminarHechoWithoutFireRules(ob);
						}
					}
					
					else if ( g instanceof ObtenerConfirmacion) {
						Objetivo ob = (ObtenerConfirmacion) g;
						if (ob.getobjectReferenceId().equals(chat)) {
							this.getEnvioHechos().eliminarHechoWithoutFireRules(ob);
						}
					}
					
					
				}

				if(g instanceof FocoGrupo ){
					FocoGrupo fc = (FocoGrupo) g;
					if(fc.getGrupo().equals(chat)) {
						this.getEnvioHechos().eliminarHechoWithoutFireRules(fc);
					}
				}
				
				if(g instanceof Quedada ){
					Quedada q = (Quedada) g;
					if(q.idChat.equals(chat)) {
						this.getEnvioHechos().eliminarHechoWithoutFireRules(q);
					}
				}
			
			}

		} catch (Exception e) {
			e.printStackTrace();
			trazas.aceptaNuevaTraza(new InfoTraza(this.getIdentAgente(),
					"Error al ejecutar la tarea : " + this.getIdentTarea() + e,
					InfoTraza.NivelTraza.error));
		}
	}

}
