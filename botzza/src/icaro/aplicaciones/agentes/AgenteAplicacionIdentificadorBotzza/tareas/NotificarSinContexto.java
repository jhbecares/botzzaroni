package icaro.aplicaciones.agentes.AgenteAplicacionIdentificadorBotzza.tareas;

import icaro.aplicaciones.informacion.gestionPizzeria.VocabularioGestionPizzeria;
import icaro.aplicaciones.agentes.AgenteAplicacionIdentificadorBotzza.tools.ConversacionBotzza;
import icaro.aplicaciones.informacion.gestionPizzeria.FocoUsuario;
import icaro.aplicaciones.recursos.comunicacionChat.ItfUsoComunicacionChat;
import icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.CausaTerminacionTarea;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;

// TODO FIXME esto hay que modificarlo
public class NotificarSinContexto extends TareaSincrona {
	private Objetivo contextoEjecucionTarea = null;
	@Override
	public void ejecutar(Object... params) {
		System.out.println("Intentando ejecutar tarea sincrona notificar sin contexto");
		String identDeEstaTarea = this.getIdentTarea();
		String identAgenteOrdenante = this.getIdentAgente();
		FocoUsuario foGrupo = (FocoUsuario) params[0];
		String mensajeAenviar = "";
		try {
			ItfUsoComunicacionChat recComunicacionChat = (ItfUsoComunicacionChat) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ
					.obtenerInterfazUso(VocabularioGestionPizzeria.IdentRecursoComunicacionChat);
			
			if(foGrupo.intentos < 1 || foGrupo.getFoco() == null){
				mensajeAenviar = ConversacionBotzza.msg("sincontexto");
				foGrupo.intentos = foGrupo.intentos+1;
			}
			else{
				if(foGrupo.getFoco().getgoalId().equals("ObtenerIDGrupo")){
					mensajeAenviar = ConversacionBotzza.msg("peticionIDGrupoImperativo");
					foGrupo.intentos = 0;
				}
				else if(foGrupo.getFoco().getgoalId().equals("ObtenerEdad")){
					mensajeAenviar = ConversacionBotzza.msg("peticionEdadImperativo");
					foGrupo.intentos = 0;
				}
				else if(foGrupo.getFoco().getgoalId().equals("ObtenerNumIntegrantes")){
					mensajeAenviar = ConversacionBotzza.msg("peticionNumIntegrantesImperativo");
					foGrupo.intentos = 0;
				}
				else if(foGrupo.getFoco().getgoalId().equals("ObtenerSexo")){
					mensajeAenviar = ConversacionBotzza.msg("peticionSexoImperativo");
					foGrupo.intentos = 0;
				}
				else if(foGrupo.getFoco().getgoalId().equals("ObtenerTelefono")){
					mensajeAenviar = ConversacionBotzza.msg("peticionTelefonoImperativo");
					foGrupo.intentos = 0;
				}
				else if(foGrupo.getFoco().getgoalId().equals("DistribuirMensaje")){
					mensajeAenviar = ConversacionBotzza.msg("solicitarAccionImperativo");
					foGrupo.intentos = 0;
				}
				else if(foGrupo.getFoco() == null){
					mensajeAenviar = ConversacionBotzza.msg("");
					foGrupo.intentos = 0;
				}
				
			}
			
			if (recComunicacionChat != null) {
			
				recComunicacionChat.comenzar(identAgenteOrdenante);
				recComunicacionChat.enviarMensagePrivado(foGrupo.getUsuario(),
						mensajeAenviar);
			} else {
				identAgenteOrdenante = this.getAgente().getIdentAgente();
				this.generarInformeConCausaTerminacion(
						identDeEstaTarea,
						contextoEjecucionTarea,
						identAgenteOrdenante,
						"Error-AlObtener:Interfaz:"
								+ VocabularioGestionPizzeria.IdentRecursoComunicacionChat,
						CausaTerminacionTarea.ERROR);
			}
			
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
