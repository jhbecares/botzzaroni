/*
 * SolicitarDatos.java
 *
 * Creado 23 de abril de 2007, 12:52
 *
 * Telefonica I+D Copyright 2006-2007
 */
package icaro.aplicaciones.agentes.AgenteAplicacionPizzero.tareas;

import java.util.ArrayList;
import java.util.HashMap;

import icaro.aplicaciones.agentes.AgenteAplicacionContexto.objetivos.CrearChatUsuario;
import icaro.aplicaciones.agentes.AgenteAplicacionIdentificadorBotzza.objetivos.ConfirmarDireccion;
import icaro.aplicaciones.agentes.AgenteAplicacionIdentificadorBotzza.objetivos.ObtenerInfoUsuario;
import icaro.aplicaciones.agentes.AgenteAplicacionIdentificadorBotzza.objetivos.ObtenerNombreUsuario;
import icaro.aplicaciones.agentes.AgenteAplicacionIdentificadorBotzza.tools.ConversacionBotzza;
import icaro.aplicaciones.informacion.gestionPizzeria.*;
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



/*
 * Llamada a esta tarea: 
 * TareaSincrona tarea = gestorTareas.crearTareaSincrona(ObtenerRecomendaciones.class);  	
 * tarea.ejecutar();
 * 
 */

public class ObtenerRecomendaciones extends TareaSincrona {
	// private String identAgenteOrdenante ;
	private Objetivo contextoEjecucionTarea = null;

	@Override
	public void ejecutar(Object... params) {
		String identDeEstaTarea = this.getIdentTarea();
		String identAgenteOrdenante = this.getIdentAgente();
		try {
			
			ArrayList<Pizza> recomendaciones;
			String mensaje = null;
			
			String identRecursoPersistencia = "Persistencia1";
			ItfUsoPersistenciaAccesoBD persistencia = (ItfUsoPersistenciaAccesoBD)  NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ.obtenerInterfazUso(
					VocabularioGestionPizzeria.IdentRecursoPersistencia);
			ItfUsoInterfazChatUsuario recComunicacionChat = (ItfUsoInterfazChatUsuario) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ.obtenerInterfazUso(
					VocabularioGestionPizzeria.IdentRecursoComunicacionChat); 
			String user = recComunicacionChat.getIdentUsuario();
			
			
			// Consulta a la base de datos para recuperar las pizzas personalizadas del usuario
		    recomendaciones = persistencia.obtenerPersonalizadasUsuario(user);
		    
			//Focus f = new Focus();
			if (!recomendaciones.isEmpty()){
				 String recomendadas = null;
				    // TODO: Leer el array de pizzas que devuelve la consulta y mostrarlas
				 this.getEnvioHechos().insertarHechoWithoutFireRules(recomendaciones);
	             this.getEnvioHechos().insertarHecho(recomendaciones);
	             
	             for(int i=0; i < recomendaciones.size(); i++){
	            	 recomendadas  = recomendadas + recomendaciones.get(i).toString() + "\n";
	             }
	             
	             mensaje = "Hemos visto que has creado pizzas anteriormente. Te recordamos que tienes las siguientes pizzas guardadas "
	            		 + recomendadas 
	            		 + " ¿Deseas alguna de ellas? Dinos su nombre con un @ delante";
			}
			else{
				// Como no tiene personalizadas, consultamos cuál es la pizza de la carta que más ha pedido
				 recomendaciones = persistencia.obtenerMasPedidaCarta(user);
				 if (!recomendaciones.isEmpty()){
					 String maspedida = null;
					    // TODO: Leer el array de pizzas que devuelve la consulta y mostrarlas
					 
		             maspedida  =  recomendaciones.get(0).toString() + "\n";
		             
					 this.getEnvioHechos().insertarHechoWithoutFireRules(recomendaciones.get(0));
		             this.getEnvioHechos().insertarHecho(recomendaciones);
		             mensaje = "No tienes pizzas guardadas creadas por ti, pero hemos visto que pides mucho la pizza  " + maspedida + "¿Te gustaría repetirla?";
				}
				else{
					// Como no tiene personalizadas, consultamos cuál es la pizza de la carta que más ha pedido
					mensaje = "Lo siento, como todavía no has pedido con nosotros no conocemos tus gustos :( ¡Una vez hayas hecho tu primer pedido te podremos recomendar mejor! ";
					
				}
				
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
