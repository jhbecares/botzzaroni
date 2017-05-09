/*
 * SolicitarDatos.java
 *
 * Creado 23 de abril de 2007, 12:52
 *
 * Telefonica I+D Copyright 2006-2007
 */
package icaro.aplicaciones.agentes.AgenteAplicacionIdentificadorBotzza.tareas;

import icaro.aplicaciones.agentes.AgenteAplicacionContexto.objetivos.CrearChatUsuario;
import icaro.aplicaciones.agentes.AgenteAplicacionIdentificadorBotzza.objetivos.ConfirmarDireccion;
import icaro.aplicaciones.agentes.AgenteAplicacionIdentificadorBotzza.objetivos.ObtenerInfoUsuario;
import icaro.aplicaciones.agentes.AgenteAplicacionIdentificadorBotzza.objetivos.ObtenerNombreUsuario;
import icaro.aplicaciones.agentes.AgenteAplicacionIdentificadorBotzza.tools.ConversacionBotzza;
import icaro.aplicaciones.informacion.gestionPizzeria.FocoUsuario;
import icaro.aplicaciones.informacion.gestionPizzeria.Usuario;
import icaro.aplicaciones.informacion.gestionPizzeria.VocabularioGestionPizzeria;
import icaro.aplicaciones.recursos.comunicacionChat.ItfUsoComunicacionChat;
import icaro.aplicaciones.recursos.interfazChatUsuario.ItfUsoInterfazChatUsuario;
import icaro.aplicaciones.recursos.persistenciaAccesoBD.ItfUsoPersistenciaAccesoBD;
import icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.CausaTerminacionTarea;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Focus;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;
import icaro.infraestructura.recursosOrganizacion.repositorioInterfaces.ItfUsoRepositorioInterfaces;
import icaro.infraestructura.recursosOrganizacion.repositorioInterfaces.imp.ClaseGeneradoraRepositorioInterfaces;


/**
 *
 * @author F Garijo
 */
public class SaludoInicial extends TareaSincrona {
	// private String identAgenteOrdenante ;
	private Objetivo contextoEjecucionTarea = null;

	@Override
	public void ejecutar(Object... params) {
		String identDeEstaTarea = this.getIdentTarea();
		String identAgenteOrdenante = this.getIdentAgente();
		try {
			// Se comprueba si el usuario es conocido o desconocido y se le saluda en función de ello
			boolean conocido;
			String mensaje = null;
			
			String identRecursoPersistencia = "Persistencia1";
			ItfUsoPersistenciaAccesoBD persistencia = (ItfUsoPersistenciaAccesoBD)  NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ.obtenerInterfazUso(
					VocabularioGestionPizzeria.IdentRecursoPersistencia);
			ItfUsoInterfazChatUsuario recComunicacionChat = (ItfUsoInterfazChatUsuario) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ.obtenerInterfazUso(
					VocabularioGestionPizzeria.IdentRecursoComunicacionChat); 
			String user = recComunicacionChat.getIdentUsuario();
			
			Usuario usuario = persistencia.obtenerUsuario(user);
			Focus f = new Focus();
			if (usuario != null){
				if(usuario.getDireccion().getNombreCalle().equalsIgnoreCase("calle")){
					conocido = false;
					mensaje =   ConversacionBotzza.msg("saludoInicialDesconocido");
					Objetivo ob1 = new ObtenerNombreUsuario();
					f.setFoco(ob1);
		            this.getEnvioHechos().insertarHechoWithoutFireRules(ob1);
				}
				else{
					conocido = true;
					mensaje = ConversacionBotzza.msg("saludoInicialConocido");
					Objetivo ob2 = new ConfirmarDireccion();
					f.setFoco(ob2);
		            this.getEnvioHechos().insertarHechoWithoutFireRules(ob2);

				}
				 this.getEnvioHechos().insertarHechoWithoutFireRules(f);
	             this.getEnvioHechos().insertarHecho(usuario);
			}

			if (recComunicacionChat != null) {
                //recComunicacionChat.setIdentAgteAreportar(this.identAgente);
				recComunicacionChat.mostrarVisualizadorChatUsuario(identAgenteOrdenante, NombresPredefinidos.TIPO_COGNITIVO);
                recComunicacionChat.mostrarTexto(VocabularioGestionPizzeria.IdentConexionAgte + ": " +mensaje);
			} 
			else {
				identAgenteOrdenante = this.getAgente().getIdentAgente();
				this.generarInformeConCausaTerminacion(identDeEstaTarea,
						contextoEjecucionTarea, identAgenteOrdenante,
						"Error-AlObtener:Interfaz:"
								+ VocabularioGestionPizzeria.IdentRecursoComunicacionChat,
						CausaTerminacionTarea.ERROR);
			}
			


		} catch (Exception e) {
//			 this.generarInformeConCausaTerminacion(identDeEstaTarea,
//					contextoEjecucionTarea, identAgenteOrdenante,
//					"Error-Acceso:Interfaz:" + identRecursoComunicacionChat,
//					CausaTerminacionTarea.ERROR);
			e.printStackTrace();
		}
	}
}
