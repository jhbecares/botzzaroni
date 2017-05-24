
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
	    		System.out.println("fecha recibida" + sdf.format(gc.getTime()));

		    	GregorianCalendar ant = null;
		    	long diferencia = Integer.MAX_VALUE;
		    	boolean continuar = true;
		    	int i = 0;
		    	
		    	if (fechasPedidos.size() == 1){
		    		ant = (GregorianCalendar) fechasPedidos.get(i).getCalendar();
		    		GregorianCalendar masMedia = (GregorianCalendar) gc.clone();
		    		masMedia.add(Calendar.MINUTE, 30);
		    		System.out.println("fecha más media" + sdf.format(masMedia.getTime()));
		    	    long timeDifInMilliSec  = ant.getTimeInMillis() - masMedia.getTimeInMillis();;
		    		System.out.println("fecha pedido" + sdf.format(ant.getTime()));

		    	    // Si puede ser antes del pedido
		    	    if( (timeDifInMilliSec / (60 * 1000)) >= 0){
	    	        	sdf.setCalendar(gc);
	    				continuar = false;
	    				System.out.println("Puede ser antes del pedido" +  sdf.format(gc.getTime()));
	    	        }else{
			    		ant.add(Calendar.MINUTE, 30);
			    		GregorianCalendar gcFin = (GregorianCalendar) gc.clone();
						gcFin.set(Calendar.HOUR_OF_DAY, 23);
					    gcFin.set(Calendar.MINUTE, 59);
			    		System.out.println("fecha fin" + sdf.format(gcFin.getTime()));

	    				ant.add(Calendar.MINUTE, 30);
	    				timeDifInMilliSec = gcFin.getTimeInMillis() - ant.getTimeInMillis();
	    				// Si puede ser después del pedido porque está dentro del horario 
		    	        if( (timeDifInMilliSec / (60 * 1000)) >= 0){
		    	        	sdf.setCalendar(ant);
		    				continuar = false;
		    				System.out.println("Puede ser despues del pedido" + timeDifInMilliSec);
		    	        }
	    	        }
		    		
		    	} else{
		    		
			    	while(continuar && i < fechasPedidos.size()){
			    		GregorianCalendar cal = (GregorianCalendar) fechasPedidos.get(i).getCalendar();
			    		if(ant != null){
			    			long milliSec1 = cal.getTimeInMillis();
			    	        long milliSec2 = ant.getTimeInMillis();
			    	        long timeDifInMilliSec;
			    	        timeDifInMilliSec = milliSec2 - milliSec1;
			    			diferencia = Math.abs(timeDifInMilliSec / (60 * 1000));
			    			if(diferencia >= 60 ){
			    				ant.add(Calendar.MINUTE, 30);
			    				sdf.setCalendar(ant);
			    				continuar = false;
			    			}
			    			else{
			    				ant = (GregorianCalendar) cal.clone();
					    		i++;
			    			}	
			    		}
			    		else{
				    		ant = (GregorianCalendar) cal.clone();
				    		i++;
			    		}
			    	}
			    	
			    	if(continuar){ // Se me acabaron los pedidos, no encontré nada
			    		// Compruebo si cabe después del último pedido si no se podía en un hueco
				    	GregorianCalendar gcFin = (GregorianCalendar) gc.clone();
						gcFin.set(Calendar.HOUR_OF_DAY, 23);
					    gcFin.set(Calendar.MINUTE, 59);
	    				ant.add(Calendar.MINUTE, 30);
					    long milliSec1 = gc.getTimeInMillis();
		    	        long milliSec2 = ant.getTimeInMillis();
		    	        long timeDifInMilliSec;
		    	        timeDifInMilliSec = milliSec1 - milliSec2;
		    	        if( (timeDifInMilliSec / (60 * 1000)) >= 0){
		    	        	sdf.setCalendar(ant);
		    				continuar = false;
		    	        }   
			    	}
		    	}
		    	
		    	if(!continuar){
		    		   mensaje = "Esa hora está ocupada, podríamos entregar tu pedido como pronto a las: " + sdf.format(ant.getTime()) + " ¿Te parece bien?";		    		   
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