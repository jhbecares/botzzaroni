package icaro.aplicaciones.agentes.AgenteAplicacionIdentificador.tareas;

import icaro.aplicaciones.agentes.AgenteAplicacionIdentificador.tools.ConversacionGrupo;
import icaro.aplicaciones.informacion.gestionQuedadas.VocabularioGestionQuedadas;
import icaro.aplicaciones.informacion.gestionQuedadas.FocoGrupo;
import icaro.aplicaciones.recursos.comunicacionChat.ItfUsoComunicacionChat;
import icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.CausaTerminacionTarea;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;

/**
 *
 * @author Jorge Casas Hern�n
 */
public class NotificarAlGrupoSinContexto extends TareaSincrona {
	private Objetivo contextoEjecucionTarea = null;
	@Override
	public void ejecutar(Object... params) {

		String identDeEstaTarea = this.getIdentTarea();
		String identAgenteOrdenante = this.getIdentAgente();
		FocoGrupo foGrupo = (FocoGrupo) params[0];
		String mensajeAenviar = "";
		try {
			ItfUsoComunicacionChat recComunicacionChat = (ItfUsoComunicacionChat) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ
					.obtenerInterfazUso(VocabularioGestionQuedadas.IdentRecursoComunicacionChat);
			
			if(foGrupo.intentos < 1 || foGrupo.getFoco() == null){
				mensajeAenviar = ConversacionGrupo.msg("sincontexto");
				foGrupo.intentos = foGrupo.intentos+1;
			}
			else{
				if(foGrupo.getFoco().getgoalId().equals("ObtenerIDGrupo")){
					mensajeAenviar = ConversacionGrupo.msg("peticionIDGrupoImperativo");
					foGrupo.intentos = 0;
				}
				else if(foGrupo.getFoco().getgoalId().equals("ObtenerEdad")){
					mensajeAenviar = ConversacionGrupo.msg("peticionEdadImperativo");
					foGrupo.intentos = 0;
				}
				else if(foGrupo.getFoco().getgoalId().equals("ObtenerNumIntegrantes")){
					mensajeAenviar = ConversacionGrupo.msg("peticionNumIntegrantesImperativo");
					foGrupo.intentos = 0;
				}
				else if(foGrupo.getFoco().getgoalId().equals("ObtenerSexo")){
					mensajeAenviar = ConversacionGrupo.msg("peticionSexoImperativo");
					foGrupo.intentos = 0;
				}
				else if(foGrupo.getFoco().getgoalId().equals("ObtenerTelefono")){
					mensajeAenviar = ConversacionGrupo.msg("peticionTelefonoImperativo");
					foGrupo.intentos = 0;
				}
				else if(foGrupo.getFoco().getgoalId().equals("DistribuirMensaje")){
					mensajeAenviar = ConversacionGrupo.msg("solicitarAccionImperativo");
					foGrupo.intentos = 0;
				}
				else if(foGrupo.getFoco() == null){
					mensajeAenviar = ConversacionGrupo.msg("");
					foGrupo.intentos = 0;
				}
				
			}
			
			if (recComunicacionChat != null) {
			
				recComunicacionChat.comenzar(identAgenteOrdenante);
				recComunicacionChat.enviarMensagePrivado(foGrupo.getGrupo(),
						mensajeAenviar);
			} else {
				identAgenteOrdenante = this.getAgente().getIdentAgente();
				this.generarInformeConCausaTerminacion(
						identDeEstaTarea,
						contextoEjecucionTarea,
						identAgenteOrdenante,
						"Error-AlObtener:Interfaz:"
								+ VocabularioGestionQuedadas.IdentRecursoComunicacionChat,
						CausaTerminacionTarea.ERROR);
			}
			
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
