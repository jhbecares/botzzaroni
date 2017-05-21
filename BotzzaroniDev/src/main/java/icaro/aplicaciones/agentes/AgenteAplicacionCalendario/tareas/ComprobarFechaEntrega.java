
package icaro.aplicaciones.agentes.AgenteAplicacionCalendario.tareas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
 * 
 * Llamada a esta tarea: 
 * TareaSincrona tarea = gestorTareas.crearTareaSincrona(ObtenerRecomendaciones.class);  	
 * tarea.ejecutar(fecha);
 * 
 */

public class ComprobarFechaEntrega extends TareaSincrona {
	// private String identAgenteOrdenante ;
	private Objetivo contextoEjecucionTarea = null;

	@Override
	public void ejecutar(Object... params) {
		String identDeEstaTarea = this.getIdentTarea();
		String identAgenteOrdenante = this.getIdentAgente();
		SimpleDateFormat sdf = (SimpleDateFormat) params[0];
		
		try {
			
			String mensaje = null;
			
			String identRecursoPersistencia = "Persistencia1";
			ItfUsoPersistenciaAccesoBD persistencia = (ItfUsoPersistenciaAccesoBD)  NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ.obtenerInterfazUso(
					VocabularioGestionPizzeria.IdentRecursoPersistencia);
			ItfUsoInterfazChatUsuario recComunicacionChat = (ItfUsoInterfazChatUsuario) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ.obtenerInterfazUso(
					VocabularioGestionPizzeria.IdentRecursoComunicacionChat); 
			
			// Obtener los pedidos de ese dia a partir de esa hora 
		    ArrayList<SimpleDateFormat> fechasPedidos = persistencia.consultaPedidos(sdf);
		    
		    if(fechasPedidos.isEmpty()){
			    mensaje = "Genial, ¡apuntamos tu pedido para ese día a esa hora sin problemas!";
			    // Aquí cambiamos el objetivo para que se ejecute directamente la tarea que inserta el pedido y aú
		    }
		    else{ // Hay pedidos, toca comprobar si podemos encajar el nuestro
		    	
		    	GregorianCalendar gc = (GregorianCalendar) sdf.getCalendar();
		    	GregorianCalendar ant = null;
		    	long diferencia = Integer.MAX_VALUE;
		    	boolean continuar = true;
		    	int i = 0;
		    	
		    	if (fechasPedidos.size() == 1){
		    		ant = (GregorianCalendar) fechasPedidos.get(i).getCalendar();
		    		System.out.println("Primer pedido " +sdf.format(ant.getTime()));
		    		ant.add(Calendar.MINUTE, 30);
		    		System.out.println("Más media hora " +sdf.format(ant.getTime()));
    				sdf.setCalendar(ant);
    				continuar = false;
		    	} else{
			    	while(continuar && i < fechasPedidos.size()){
			    		GregorianCalendar cal = (GregorianCalendar) fechasPedidos.get(i).getCalendar();
			    		if(ant != null){
			    			long milliSec1 = cal.getTimeInMillis();
			    	        long milliSec2 = ant.getTimeInMillis();
			    	        long timeDifInMilliSec;
			    	        timeDifInMilliSec = milliSec2 - milliSec1;
			    			diferencia = Math.abs(timeDifInMilliSec / (60 * 1000));
			    			System.out.println(diferencia);
			    			if(diferencia >= 60 ){
			    				ant.add(Calendar.MINUTE, 30);
			    				sdf.setCalendar(ant);
			    				continuar = false;
			    			}else{
			    				ant = (GregorianCalendar) cal.clone();
					    		i++;
			    			}	
			    		}
			    		else{
				    		ant = (GregorianCalendar) cal.clone();
				    		i++;
			    		}
			    	}
		    	}
		    	
		    	if(!continuar){
		    		   mensaje = "Esa hora está ocupada, podríamos entregar tu pedido a las: " + sdf.format(ant.getTime()) + " ¿Te parece bien?";
		    		   System.out.println(sdf.format(ant.getTime()));
		    		   
		    		   // Cambiamos el objetivo a lo que toque...
		    	}
		    	else{
		    		   mensaje = "Lo sentimos, no tenemos hueco disponible para tu pedido ese día :(";
		    		   // Cambiamos el objetivo a lo que toque...

		    	}
		    }
		    
		    // Devuelvo la fecha que he obtenido
		    this.getEnvioHechos().actualizarHecho(sdf);
		    
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