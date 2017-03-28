/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package icaro.aplicaciones.agentes.AgenteAplicacionIdentificador.tareas;

import icaro.aplicaciones.informacion.gestionQuedadas.FocoGrupo;
import icaro.aplicaciones.informacion.gestionQuedadas.Grupo;
import icaro.aplicaciones.informacion.gestionQuedadas.Quedada;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaComunicacion;
import icaro.infraestructura.recursosOrganizacion.recursoTrazas.imp.componentes.InfoTraza;

/**
 *
 * @author SONIAGroup
 */
public class EliminarSesionGrupo extends TareaComunicacion{

	@Override
	public void ejecutar(Object... params) {
		String grupo = (String) params[0];
		
		try {
			for (Object g : this.getEnvioHechos().getItfMotorDeReglas()
					.getStatefulKnowledgeSession().getObjects()) {

				if (g instanceof Objetivo) {
					Objetivo ob = (Objetivo) g;
					if (ob.getobjectReferenceId().equals(grupo)) {
						this.getEnvioHechos().eliminarHechoWithoutFireRules(ob);
						System.out.println("HE ELIMINADO EL OBJETIVO: " + ob.getgoalId());
					}
				}

				if(g instanceof FocoGrupo ){
					FocoGrupo fc = (FocoGrupo) g;
					if(fc.getGrupo().equals(grupo)) {
						this.getEnvioHechos().eliminarHechoWithoutFireRules(fc);
						System.out.println("HE ELIMINADO EL FOCO");
					}
				}
				
				if(g instanceof Grupo ){
					Grupo gr = (Grupo) g;
					if(gr.grupo.equals(grupo)) {
						this.getEnvioHechos().eliminarHechoWithoutFireRules(gr);
						System.out.println("HE ELIMINADO EL GRUPO: " + gr.getId());
					}
				}
				
				if(g instanceof Quedada ){
					Quedada que = (Quedada) g;
					if(que.idChat.equals(grupo)) {
						this.getEnvioHechos().eliminarHechoWithoutFireRules(que);
						System.out.println("HE ELIMINADO LA QUEDADA: " + que.idChat);
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
