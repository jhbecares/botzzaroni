package icaro.aplicaciones.agentes.AgenteAplicacionCalendario.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConversacionCalendario {
	
	private static HashMap<String,List<String>> conversacion;
	
	static{
		conversacion = new HashMap<String, List<String>>();
		
		List<String> peticionCalendario = new ArrayList<String>();
		peticionCalendario.add("¿Cuándo querrás recibir tu pedido?");
		peticionCalendario.add("¿Cuándo quieres tu pedido?");
		peticionCalendario.add("¿Para cuándo entregamos tu pedido?");
		
		List<String> reconocidaHora = new ArrayList<String>();
		reconocidaHora.add("Se ha reconocido una hora.");

		conversacion.put("peticionCalendario", peticionCalendario);
		conversacion.put("reconocidaHora", reconocidaHora);
	}
	
	
	public static String msg(String tipo){

		String msg = null;
		if(conversacion.get(tipo) != null && conversacion.get(tipo).size() > 0){
			int index = (int)(System.currentTimeMillis() % conversacion.get(tipo).size());
			msg = conversacion.get(tipo).get(index);
		}
		return msg;
	}
	

}
