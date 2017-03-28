package icaro.aplicaciones.agentes.AgenteAplicacionIdentificador.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConversacionGrupo {
	
	private static HashMap<String,List<String>> conversacion;
	
	static{
		conversacion = new HashMap<String, List<String>>();
		
		List<String> saludoInicial = new ArrayList<String>();
		saludoInicial.add("¡Hola! Soy SONIA, una chica bot creada para organizar quedadas entre grupos de amigos que no se conocen.");
		saludoInicial.add("¡Buenas tardes!, ¿Estáis preparados para quedar con un magnífico grupo de amig@s y pasarlo genial?");
		
		List<String> solicitarNuevamenteIDGrupo = new ArrayList<String>();
		solicitarNuevamenteIDGrupo.add("Ahora sí que sí necesito vuestro identificador de grupo.");
		solicitarNuevamenteIDGrupo.add("Decídme ahora sí o sí vuestro identificador de grupo, please.");
		
		List<String> saludoInicialNoSaludo = new ArrayList<String>();
		saludoInicialNoSaludo.add("Me gusta que me saluden antes, ¿sabes..? jeje ;)");
		saludoInicialNoSaludo.add("En primer lugar hola. Soy una chica educada, no como vosotros que ni saludáis. ¡Es broma! Soy una maquina pero tengo sentido del humor :)");
		saludoInicialNoSaludo.add("Se os ha olvidado el hola xD");
		saludoInicialNoSaludo.add("¿Os parece bonito no saludarme tan siquiera? :P");
		
		// SE PUEDE QUITAR
		List<String> solicitarNombre = new ArrayList<String>();
		solicitarNombre.add("Msg SolicitarNombre");
		solicitarNombre.add("Mensaje de SolicitarNombre.");
		
		
		List<String> solicitarNombreImperativo = new ArrayList<String>();
		solicitarNombreImperativo.add("Para continuar le recuerdo que necesito su nombre");
		solicitarNombreImperativo.add("por favor coopere, digame su nombre");
		solicitarNombreImperativo.add("realmente necesito su nombre, por favor");
	
		List<String> solicitarAccionImperativo = new ArrayList<String>();
		solicitarAccionImperativo.add("Me gustaria saber si me piensa decir que quiere hacer");
		solicitarAccionImperativo.add("Por favor sea concreto, digame que quiere");
		solicitarAccionImperativo.add("Le recuerdo que solo puedo ayudarlo con asuntos de citas medicas");
		//
		
		List<String> prePersistenciaGrupo = new ArrayList<String>();
		prePersistenciaGrupo.add("¡Perfecto! Dejádme un segundo para que apunte vuestros datos y enseguida estoy con vosotros.");
		prePersistenciaGrupo.add("¡Genial! Ya tengo todo lo que necesito, dadme un segundo para que lo apunte.");
		prePersistenciaGrupo.add("¡Bien! Voy a apuntar vuestros datos y ahora os sigo contando.");
		
		List<String> persistenciaGrupoCompletada = new ArrayList<String>();
		persistenciaGrupoCompletada.add("¡Listo! La proxima vez que entréis me acordaré de vosotros ;)");
		
		List<String> inactividad = new ArrayList<String>();
		inactividad.add("¡Que sola estoy! ¡¡Que sola!! Decídme algo ;(");
		inactividad.add("¡¡Contestádme ya pesaos!!");
		inactividad.add("Soy una chica muy ocupada, ¡¡No puedo estar esperandoos eternamente!!");
		inactividad.add("¡Como no me contestéis ya mismo os apago el PC! Que a parte de organizar quedadas también soy una chica hacker :P");
		
		List<String> solicitarPass = new ArrayList<String>();
		solicitarPass.add("Ya os tengo identificados, pero por seguridad decídme el número de teléfono con el que os registrásteis.");
		solicitarPass.add("¡Genial, os tengo por aquí apuntados! Para asegurarme que sois vosotros decídme, please, el número de teléfono con el que os registrásteis.");
		
		List<String> passIncorrecta = new ArrayList<String>();
		passIncorrecta.add("Lo siento pero no habéis puesto el número correcto. Volvedme a decir vuestro identificador de grupo. O si no teneis ninguno inventaróslo, ¡no pasa nada!");
		passIncorrecta.add("Ups, el número que habéis puesto no es el que tengo apuntado. Volvedme a decir de nuevo vuestro identificador de grupo o, si no, inventaros uno ahora mismo!");
		
		List<String> passCorrecta = new ArrayList<String>();
		passCorrecta.add("¡Genial! Ahora sí que estoy segura de que sois vosotros");
		passCorrecta.add("¡Ya os tengo localizados! Me alegro de que hayáis vuelto. Aunque no os he echado de menos... :p");
		passCorrecta.add("¡Me alegro de veros de nuevo! :)");
		
		List<String> grupoNoRegistrado = new ArrayList<String>();
		grupoNoRegistrado.add("¡Me encanta que entren a utilizarme grupos nuevos! Necesito saber más sobre vosotros, veamos...");
		grupoNoRegistrado.add("¡Encantada de conoceros! Al ser la primera vez que hablo con vosotros necesito saber algunas cosas. A ver...");
		grupoNoRegistrado.add("¡Encantada de conoceros! Tengo que preguntaros algunas cosas, no es que sea cotilla, es que lo necesito para encontraros grupos afines ;)");
		
		List<String> volverASaludar = new ArrayList<String>();
		volverASaludar.add("Jajaja, ¡pero si ya nos hemos saludado antes!");
		volverASaludar.add("¡Ya nos hemos saludado antes! Recuerda que soy una máquina, me acuerdo de todo. Jajaja :)");
		
		List<String> ultimaPreguntaIdentificacion = new ArrayList<String>();
		ultimaPreguntaIdentificacion.add("Y la última pregunta para terminar de identificaros es...");
		ultimaPreguntaIdentificacion.add("Vale, solo me queda ya una pregunta por haceros.");
		ultimaPreguntaIdentificacion.add("Bueno pues ya casi he terminado de identificaros. Sólo me queda por haceros una pregunta.");
		
		List<String> sincontexto = new ArrayList<String>(); 
		sincontexto.add("Disculpa que sea tan cortita, pero no te estoy entendiendo ;(");
		sincontexto.add("¿No me estaréis vacilando no? Es que no entiendo de que me estáis hablando :(");
		sincontexto.add("Lo siento, pero os entiendo. Mis creadores sólo me han enseñado a organizar quedadas entre grupos ;(");
		sincontexto.add("¿¿Sabéis que mi nombre viene de Sistema Organizador de eNcuentros basado en Inteligencia Artificial?? Os digo esto porque no os estoy entendiendo, así que por decir yo algo. Jejeje.");
		
		List<String> despedida = new ArrayList<String>(); 
		despedida.add("Espero que volváis pronto. ¡¡Chaooo!! ");
		despedida.add("¡¡Hasta pronto!!");
		despedida.add("¡¡Adiós!! Espero que os hayáis llevado una buena impresión de mí :)");
		despedida.add("¡¡Hasta la proxima!! :)");
		
		List<String> peticionIDGrupo = new ArrayList<String>(); 
		peticionIDGrupo.add("Lo primero que necesito es vuestro identificador de grupo. Si no tenéis ninguno no os preocupéis, ¡inventaróslo ahora mismo!. Importante, tiene que empezar por @ seguido de una serie de letras.");
		peticionIDGrupo.add("¿Cuál es vuestro identificador de grupo?. Si no sabéis de qué hablo, necesito un @nick que os identifique como grupo");
		peticionIDGrupo.add("Decidme, please, vuestro identificador de grupo. Si no tenéis ninguno es buen momento para pensar uno. Tiene que empezar por @ y luego el nombre que queráis (sólo letras, no números). Por ejemplo, el mio es @soniabot :)");
		
		List<String> peticionEdad = new ArrayList<String>(); 
		peticionEdad.add("¿Cuál es la edad media aproximada de vuestro grupo?");
		peticionEdad.add("¿Me podeis decir cuál es vuestra edad media aproximada?");
		peticionEdad.add("¿Aproximadamente cuál es la edad media que tenéis?");
		
		List<String> peticionNumIntegrantes = new ArrayList<String>(); 
		peticionNumIntegrantes.add("¿De cuántas personas esta constituido vuestro grupo?");
		peticionNumIntegrantes.add("¿Cuántos sois en el grupo?");
		peticionNumIntegrantes.add("¿Cuántas personas sois en vuestro grupo?");
		
		List<String> peticionSexo = new ArrayList<String>(); 
		peticionSexo.add("¿Vuestro grupo es de hombres, de mujeres o mixto?");
		peticionSexo.add("¿Qué sois en vuestro grupo: hombres, mujeres o sois un grupo mixto?");
		peticionSexo.add("¿Sois todos hombres, mujeres o vuestro grupo es mixto?");
		
		List<String> peticionTelefono = new ArrayList<String>(); 
		peticionTelefono.add("¿Podéis darme un número de móvil? Sólo lo usaré para que el grupo con el que quedéis pueda ponerse en contacto con vosotros.");
		peticionTelefono.add("¿Me decís un número de móvil? Es para poneros en contacto con el grupo con el que quedéis.");
		peticionTelefono.add("¿Me dais un número de móvil? Lo necesito para que un grupo afín pueda ponerse en contacto con vosotros.");
		
		List<String> noIDGrupo = new ArrayList<String>(); 
		noIDGrupo.add("Eso no me vale como identificador de grupo, lo siento. Un identificador de grupo debe empezar con @ y a continuación una serie de letras.");
		
		List<String> noEdad = new ArrayList<String>(); 
		noEdad.add("¡Eso no es una edad!");
		
		List<String> noNumIntegrantes = new ArrayList<String>(); 
		noNumIntegrantes.add("¡No me habéis entendido! Necesito saber cuántas personas sois. Quizás 3 personas, 4...");
		
		List<String> noSexo = new ArrayList<String>(); 
		noSexo.add("Jajaja ¿Por qué me decís eso? Lo que me tenéis que decir ahora es si sois hombres, mujeres o si vuestro grupo es mixto.");
		
		List<String> noTelefono = new ArrayList<String>(); 
		noTelefono.add("Lo siento pero para mí eso no es un teléfono, escribídme un teléfono que yo entienda.");
		
		List<String> noPass = new ArrayList<String>(); 
		noPass.add("Eso no me vale, necesito que me digáis el teléfono tal cual lo escribísteis la vez que nos conocimos. Entender que si no no puedo fiarme de vosotros :(");
		
		
		List<String> peticionIDGrupoImperativo = new ArrayList<String>(); 
		peticionIDGrupoImperativo.add("Si no me decis vuestro identificador de grupo no puedo seguir :(");
		peticionIDGrupoImperativo.add("¡Vengaaa!, dadme vuestro identificador de grupo o inventaros uno");
		peticionIDGrupoImperativo.add("¡¡Que pesaos!! Quereis darme ya vuestro identificador de grupo?");
		
		List<String> peticionEdadImperativo = new ArrayList<String>(); 
		peticionEdadImperativo.add("Si no me decis la edad media de vuestro grupo no puedo seguir :(");
		peticionEdadImperativo.add("¡Vengaaaaaaa!, decidme vuestra edad media");
		peticionEdadImperativo.add("¡Qué pesaos sois!! Queréis decirme ya cuál es la edad media de vuestro grupo?");
		
		List<String> peticionNumIntegrantesImperativo = new ArrayList<String>(); 
		peticionNumIntegrantesImperativo.add("¡Decídme cuántos sois en el grupo ya! ¡Que sois unos pesaos!");
		peticionNumIntegrantesImperativo.add("En serio... necesito saber cuántos sois en el grupo.");
		peticionNumIntegrantesImperativo.add("No os vayáis por las ramas, ¿Cuántos sois en el grupo ya?");
		
		List<String> peticionSexoImperativo = new ArrayList<String>(); 
		peticionSexoImperativo.add("¿Queréis decirme ya si sois hombres, mujeres o si sois un grupo mixto?");
		peticionSexoImperativo.add("Dejaos de tonterias y decirme si sois hombres, mujeres o un grupo mixto.");
		
		List<String> peticionTelefonoImperativo = new ArrayList<String>(); 
		peticionTelefonoImperativo.add("En serio... necesito un número de móvil");
		peticionTelefonoImperativo.add("Si no me dais un número de móvil no puedo seguir :(");
		
		//
		List<String> fechaAnterior = new ArrayList<String>(); 
		fechaAnterior.add("Disculpadme, pero la fecha en la que queréis quedar es anterior a la fecha actual. Decídme una fecha posterior al pasado.");
		
		conversacion.put("saludoInicial", saludoInicial);
		conversacion.put("saludoInicialNoSaludo", saludoInicialNoSaludo);
		conversacion.put("solicitarNombre", solicitarNombre);
		conversacion.put("prePersistenciaGrupo", prePersistenciaGrupo);
		conversacion.put("persistenciaGrupoCompletada", persistenciaGrupoCompletada);
		conversacion.put("inactividad", inactividad);
		conversacion.put("solicitarPass", solicitarPass);
		conversacion.put("passIncorrecta", passIncorrecta);
		conversacion.put("passCorrecta", passCorrecta);
		conversacion.put("grupoNoRegistrado", grupoNoRegistrado);
		conversacion.put("volverASaludar", volverASaludar);
		conversacion.put("ultimaPreguntaIdentificacion", ultimaPreguntaIdentificacion);
		conversacion.put("sincontexto", sincontexto);
		conversacion.put("despedida", despedida);
		conversacion.put("peticionIDGrupo", peticionIDGrupo);
		conversacion.put("peticionEdad", peticionEdad);
		conversacion.put("peticionNumIntegrantes", peticionNumIntegrantes);
		conversacion.put("peticionSexo", peticionSexo);
		conversacion.put("peticionTelefono", peticionTelefono);
		conversacion.put("noIDGrupo", noIDGrupo);
		conversacion.put("noEdad", noEdad);
		conversacion.put("noNumIntegrantes", noNumIntegrantes);
		conversacion.put("noSexo", noSexo);
		conversacion.put("noTelefono", noTelefono);
		conversacion.put("noPass", noPass);
		conversacion.put("solicitarNombreImperativo", solicitarNombreImperativo);
		conversacion.put("peticionIDGrupoImperativo", peticionIDGrupoImperativo);
		conversacion.put("peticionEdadImperativo", peticionEdadImperativo);
		conversacion.put("peticionNumIntegrantesImperativo", peticionNumIntegrantesImperativo);
		conversacion.put("peticionSexoImperativo", peticionSexoImperativo);
		conversacion.put("peticionTelefonoImperativo", peticionTelefonoImperativo);
		conversacion.put("solicitarAccionImperativo", solicitarAccionImperativo);
		conversacion.put("fechaAnterior", fechaAnterior);
		conversacion.put("solicitarNuevamenteIDGrupo", solicitarNuevamenteIDGrupo);		
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
