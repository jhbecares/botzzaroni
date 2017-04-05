package icaro.aplicaciones.agentes.AgenteAplicacionPizzero.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConversacionPizzero {
	
	private static HashMap<String,List<String>> conversacion;
	
	static{
		conversacion = new HashMap<String, List<String>>();
		
		String pizzas = "Prosciutto, calzone, carbonara, hawaiana, barbacoa, bacon crispy, kitkat nocilla, delicheese, diábola, vegetal,"
				+ " bolognesa y 4 quesos. ";
		
		List<String> solicitarPizza = new ArrayList<String>();
		solicitarPizza.add("¿Me dices qué pizza te gustaría tomar hoy? Puedes pedir las siguientes pizzas: "
				+ pizzas);
		solicitarPizza.add("¿Qué pizza quieres tomar hoy? Tenemos estas: " + pizzas);
		
		List<String> tengoTuPizza = new ArrayList<String>();
		tengoTuPizza.add("Ok, tengo tu pizza.");
		tengoTuPizza.add("De acuerdo, apunto esa pizza.");
		tengoTuPizza.add("Mmh, ¡esa pizza está deliciosa!");
		
		List<String> tengoTuMasa = new ArrayList<String>();
		tengoTuMasa.add("Apunto esa masa entonces.");
		tengoTuMasa.add("Oh, ¡es mi masa favorita!");
		tengoTuMasa.add("¡Mi masa favorita!");

		List<String> tengoTuSalsa = new ArrayList<String>();
		tengoTuSalsa.add("¡Qué salsa más rica! Buena elección :)");
		tengoTuSalsa.add("¡Esa salsa está muy buena!");
		tengoTuSalsa.add("Salsa anotada.");

		conversacion.put("tengoTuPizza", tengoTuPizza);
		conversacion.put("tengoTuMasa", tengoTuMasa);
		conversacion.put("tengoTuSalsa", tengoTuSalsa);
		conversacion.put("solicitarPizza", solicitarPizza);
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
