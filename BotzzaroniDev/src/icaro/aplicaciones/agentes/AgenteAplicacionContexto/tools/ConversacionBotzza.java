package icaro.aplicaciones.agentes.AgenteAplicacionContexto.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConversacionBotzza {
	
	private static HashMap<String,List<String>> conversacion;
	
	static{
		conversacion = new HashMap<String, List<String>>();
		
		List<String> saludoInicialDesconocido = new ArrayList<String>();
		saludoInicialDesconocido.add("¡Hola! Soy Botzzaroni, gracias por darnos la oportunidad de hacer de su comida un momento único de felicidad.");

		List<String> saludoInicialConocido = new ArrayList<String>();
		saludoInicialConocido.add("¡Hola! Qué alegría verte de nuevo por aquí :)");
		saludoInicialConocido.add("Oh, ¡cuánto tiempo! Me alegro de verte otra vez.");
		saludoInicialConocido.add("¡Buenas! ¡Te he echado de menos! ¿Qué quieres pedir hoy?");

		List<String> saludoInicialNoSaludo = new ArrayList<String>();
		saludoInicialNoSaludo.add("Me gusta que me saluden antes, ¿sabes..? jeje ;)");
		saludoInicialNoSaludo.add("En primer lugar, ¡hola!. Soy un bot educado :(. ¡Es broma! Soy una máquina, pero tengo sentido del humor :)");
		saludoInicialNoSaludo.add("Se te ha olvidado saludarme :(");

		List<String> solicitarNombre = new ArrayList<String>();
		solicitarNombre.add("Todavía no te conocemos, ¿me dices tu nombre?");
		solicitarNombre.add("Para comenzar, ¿me puedes decir tu nombre?");
		solicitarNombre.add("Empecemos... ¿me dices tu nombre?");
		
		List<String> solicitarApellido = new ArrayList<String>();
		solicitarApellido.add("Ahora necesito que me digas tu apellido.");
		solicitarApellido.add("¿Y cuál es tu apellido?");
		
		List<String> solicitarApellidoImperativo = new ArrayList<String>();
		solicitarApellidoImperativo.add("En serio, necesito que me digas tu apellido.");
		solicitarApellidoImperativo.add("No te desvíes del tema... ¿cuál es tu apellido?");

		List<String> solicitarNombreImperativo = new ArrayList<String>();
		solicitarNombreImperativo.add("Para continuar, le recuerdo que necesito su nombre.");
		solicitarNombreImperativo.add("Por favor, coopere, dígame su nombre :)");
		solicitarNombreImperativo.add("Realmente necesito su nombre, por favor.");

		List<String> inactividad = new ArrayList<String>();
		inactividad.add("¡Qué solo estoy! ¡¡Qué solo!! Decidme algo ;(");
		inactividad.add("Soy un robot muy ocupado, ¡¡no puedo esperar eternamente!!");

		List<String> volverASaludar = new ArrayList<String>();
		volverASaludar.add("Jajaja, ¡pero si ya nos hemos saludado antes!");
		volverASaludar.add("¡Ya nos hemos saludado antes! Recuerda que soy una máquina, me acuerdo de todo. Jajaja :)");
			
		List<String> sincontexto = new ArrayList<String>(); 
		sincontexto.add("Disculpa que sea tan cortito, pero no te estoy entendiendo ;(");
		sincontexto.add("No me estarás vacilando, ¿no? Es que no entiendo de que me estás hablando :(");
		sincontexto.add("Lo siento, pero no os entiendo. Estoy preparado especialmente para pedir pizzas ;(");

		
		List<String> peticionTelefono = new ArrayList<String>(); 
		peticionTelefono.add("¿Me puedes indicar tu teléfono móvil? Lo usaremos en caso de que haya algún problema con vuestro pedido.");
			
		List<String> noTelefono = new ArrayList<String>(); 
		noTelefono.add("Lo siento pero para mí eso no es un teléfono, escribidme un teléfono que yo entienda.");
			
		List<String> peticionTelefonoImperativo = new ArrayList<String>(); 
		peticionTelefonoImperativo.add("En serio... necesito tu número de móvil");
		peticionTelefonoImperativo.add("Si no me das tu número de móvil no puedo seguir :(");

		List<String> fechaAnterior = new ArrayList<String>(); 
		fechaAnterior.add("Disculpa, pero la fecha en la que quieres tu pedido es anterior a la fecha actual. Dime una fecha posterior, por favor :)");

		
		// ---------------------------------------------------------------------------
		
		List<String> desconocido = new ArrayList<String>();
		desconocido.add("Perdona, creo que me he perdido...");
		desconocido.add("No sé muy bien de qué me estás hablando...");
		desconocido.add("Todavía no me han enseñado a hablar de eso. Quizás en el futuro... :)");

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
		
		List<String> tengoTuNombre = new ArrayList<String>();
		tengoTuNombre.add("¡Gracias! Apunto tu nombre ;)");
		tengoTuNombre.add("Vale, usaré ese nombre de ahora en adelante :)");
		
		List<String> tengoTuApellido = new ArrayList<String>();
		tengoTuApellido.add("De acuerdo. Apunto también tu apellido.");
		tengoTuApellido.add("Gracias. Ya he apuntado tu apellido");
		
		List<String> despedida = new ArrayList<String>(); 
		despedida.add("Ya está registrado tu pedido. Estamos encantados de que hayas confiado en nosotros, ¡Hasta otra! ");
		despedida.add("Tu pedido a Botzzaroni ha llegado a nuestra central. ¡Disfruta de tu pizza y vuelve pronto!");
		despedida.add("Listo el pedido, intentaremos que esté todo a tu gusto. ¡Hasta pronto!");
		despedida.add("Eso es todo, pedido listo. Esperamos que vuelvas pronto, estamos encantados de atenderte. ¡Hasta la próxima!");

		
		conversacion.put("saludoInicialDesconocido", saludoInicialDesconocido);
		conversacion.put("saludoInicialConocido", saludoInicialConocido);
		conversacion.put("saludoInicial", saludoInicialConocido);

		conversacion.put("saludoInicialNoSaludo", saludoInicialNoSaludo);
		conversacion.put("solicitarNombre", solicitarNombre);
		conversacion.put("inactividad", inactividad);
		conversacion.put("volverASaludar", volverASaludar);
		conversacion.put("sincontexto", sincontexto);
		conversacion.put("despedida", despedida);
		conversacion.put("peticionTelefono", peticionTelefono);
		conversacion.put("noTelefono", noTelefono);
		conversacion.put("solicitarNombreImperativo", solicitarNombreImperativo);
		conversacion.put("peticionTelefonoImperativo", peticionTelefonoImperativo);
		conversacion.put("fechaAnterior", fechaAnterior);		
		conversacion.put("desconocido", desconocido);		

		conversacion.put("tengoTuPizza", tengoTuPizza);
		conversacion.put("tengoTuMasa", tengoTuMasa);
		conversacion.put("tengoTuSalsa", tengoTuSalsa);
		conversacion.put("tengoTuNombre", tengoTuNombre);
		conversacion.put("solicitarApellido", solicitarApellido);
		conversacion.put("tengoTuApellido", tengoTuApellido);
		conversacion.put("solicitarApellidoImperativo", solicitarApellidoImperativo);

		
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
