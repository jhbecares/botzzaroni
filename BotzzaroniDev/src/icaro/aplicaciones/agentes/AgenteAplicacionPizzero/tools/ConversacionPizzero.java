package icaro.aplicaciones.agentes.AgenteAplicacionPizzero.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConversacionPizzero {
	
	private static HashMap<String,List<String>> conversacion;
	
	static{
		conversacion = new HashMap<String, List<String>>();
		
		String pizzas = " \n  - Prosciutto\n  - Calzone\n  - Carbonara\n  - Hawaiana\n  - Barbacoa\n  - Bacon crispy\n  - Kitkat nocilla\n  - Delicheese\n  - Diábola\n  - Vegetal\n"
				+ "  - Bolognesa\n  - Cuatro quesos ";
		
		List<String> solicitarPizza = new ArrayList<String>();
		solicitarPizza.add("¿Me dices qué pizza te gustaría tomar hoy? Puedes pedir las siguientes pizzas: "
				+ pizzas);
		solicitarPizza.add("¿Qué pizza quieres tomar hoy? Tenemos estas: " + pizzas);
		
		String ingredientes = "\n  - Bacon\n  - Pollo\n  - Ternera\n  - Bacon crispy\n  - Jamón serrano\n  - Champiñon\n  - Topping a base de mozzarella\n  - Queso cheddar\n  - Queso emmental\n"
				+ "  - Queso edam\n  - Queso provolone\n  - Queso azul\n  - York\n  - Piña\n  - Tomate natural\n  - Tomate confitado\n  - Oregano\n  - Cebolla\n  - Kitkat\n  - Crema de cacao y avellanas ";
		
		
		String tamanio =" \n  - Pequeña\n  - Mediana\n  - Familiar";
		
		String masas =" \n  - Normal\n  - Fina\n  - Bordes rellenos de queso";
		
		List<String> solicitarIngredientes = new ArrayList<String>();
		solicitarIngredientes.add("Estos son nuestros ingredientes: " + ingredientes + "\n¿Cuáles quieres añadir a tu pizza?");
		
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

		List<String> solicitarAlergia = new ArrayList<String>();
		solicitarAlergia.add("Antes de empezar con el pedido ¿Tienes alguna alergia?");
		solicitarAlergia.add("Para no causar ningún disgusto, cuéntanos antes de nada, ¿debemos tener alguna alergia en cuenta a la hora de hacer tu pedido? Eliminaremos los ingredientes en cuestión sin ningún problema.");
		
		List<String> solicitarAlergiaIncorrecta = new ArrayList<String>();
		solicitarAlergiaIncorrecta.add("Perdona no te he entendido, ¿Me puedes decir si tienes alguna alergia?");
		solicitarAlergiaIncorrecta.add("Solo me tienes que decir sí o no, ¿Tienes alguna alergia?");
		
		List<String> obtieneAlergia = new ArrayList<String>();
		obtieneAlergia.add("Perfecto, no tendremos en cuenta ninguna alergia :) De todas formas, si algún ingrediente no te gusta siempre puedes modificar las pizzas de la carta o no añadirlas a tus pizzas personalizadas.");
		
		List<String> solicitarNumeroPizzas = new ArrayList<String>();
		solicitarNumeroPizzas.add("¿Cuántas pizzas vas a querer?");
		solicitarNumeroPizzas.add("Comencemos con el pedido, ¿cuántas pizzas te gustaría pedir?");
		
		List<String> obtenerNumeroPizzasIncorrecto = new ArrayList<String>();
		obtenerNumeroPizzasIncorrecto.add("Necesitamos saber el número de pizzas de tu pedido para poder avanzar, ¿cuántas quieres?");
		
		List<String> obtenerUnaPizza = new ArrayList<String>();
		obtenerUnaPizza.add("¡Genial! Comencemos con tu pizza");
		obtenerUnaPizza.add("Genial");
		
		List<String> obtenerPizzas = new ArrayList<String>();
		obtenerPizzas.add("¡Genial! Comencemos con la primera");
		
		List<String> obtenerTipoPizza1 = new ArrayList<String>();
		obtenerTipoPizza1.add("Vale, para tu pizza número ");
		
		List<String> obtenerTipoPizza2 = new ArrayList<String>();
		obtenerTipoPizza2.add(" ¿Quieres de la carta o una personalizada?");
		
		List<String> solicitarTamanioPizza = new ArrayList<String>();
		solicitarTamanioPizza.add("¿De qué tamaño quieres la pizza? Tenemos: "+ tamanio);
		
		List<String> nombrePizzaIncorrecto = new ArrayList<String>();
		nombrePizzaIncorrecto.add("No he entendido la pizza a la que te refieres, ¿Me lo puedes repetir?");
		
		List<String> tipoPizzaIncorrecto = new ArrayList<String>();
		tipoPizzaIncorrecto.add("No te entiendo, ¿Qué tipo de pizza quieres?");
		
		List<String> tipoTamanioIncorrecto = new ArrayList<String>();
		tipoTamanioIncorrecto.add("Ese tamaño no esta disponible en Botzzaroni, dinos otro por favor.");
		
		List<String> solicitarMasaPizza = new ArrayList<String>();
		solicitarMasaPizza.add("Finalmente, la masa. Tenemos las siguientes masas: " + masas);
		
		List<String> masaIncorrecta = new ArrayList<String>();
		masaIncorrecta.add("Esa masa no la tenemos, dinos otra por favor.");
	
		
		conversacion.put("tengoTuPizza", tengoTuPizza);
		conversacion.put("tengoTuMasa", tengoTuMasa);
		conversacion.put("tengoTuSalsa", tengoTuSalsa);
		conversacion.put("solicitarPizza", solicitarPizza);
		conversacion.put("solicitarAlergia", solicitarAlergia);
		conversacion.put("solicitarNumeroPizzas", solicitarNumeroPizzas);
		conversacion.put("obtieneAlergia", obtieneAlergia);
		conversacion.put("solicitarAlergiaIncorrecta", solicitarAlergiaIncorrecta);
		conversacion.put("obtenerUnaPizza", obtenerUnaPizza);
		conversacion.put("obtenerPizzas", obtenerPizzas);
		conversacion.put("obtenerTipoPizza1", obtenerTipoPizza1);
		conversacion.put("obtenerTipoPizza2", obtenerTipoPizza2);
		conversacion.put("solicitarIngredientes", solicitarIngredientes);
		conversacion.put("solicitarTamanioPizza", solicitarTamanioPizza);
		conversacion.put("nombrePizzaIncorrecto", nombrePizzaIncorrecto);
		conversacion.put("tipoPizzaIncorrecto", tipoPizzaIncorrecto);
		conversacion.put("solicitarMasaPizza", solicitarMasaPizza);
		conversacion.put("tipoTamanioIncorrecto", tipoTamanioIncorrecto);
		conversacion.put("masaIncorrecta", masaIncorrecta);
		conversacion.put("obtenerNumeroPizzasIncorrecto", obtenerNumeroPizzasIncorrecto);
		
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
