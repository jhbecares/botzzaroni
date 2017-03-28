package icaro.aplicaciones.agentes.AgenteAplicacionDialogoQuedadas.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Herramienta que abstrae la conversacion con un usuario (grupo de personas)
 * 
 * @author mariano
 *
 */
public class ConversacionGrupo {
	
	private static HashMap<String,List<String>> conversacionGrupo;
	
	static{
		
		conversacionGrupo = new HashMap<String, List<String>>();
		
		/* Sin contexto */
		List<String> pedirInfoOtroGrupo = new ArrayList<String>();
		pedirInfoOtroGrupo.add("Necesito saber con cuántas personas queréis quedar, su edad media y si queréis quedar con hombres, mujeres o con un grupo mixto");
		pedirInfoOtroGrupo.add("Describidme el grupo con el que os apetecería quedar.");
		pedirInfoOtroGrupo.add("¿Con qué clase de grupo os apetecería quedar? ¡Describídmelo!");
		
	/* Sin contexto */
		List<String> sinContexto = new ArrayList<String>();
		sinContexto.add("¿¿Eing?? No entiendo lo que me estás diciendo. Repetírmelo, anda.");
		sinContexto.add("No estoy muy segura de estar entendiendoos. ¿Podríais repetirmelo?");
		sinContexto.add("¿¿Hablamos el mismo idioma?? XD. Repetírmelo con otras palabras");
	/*///////////////////// */
	
	/* Obtener informacion del grupo con el que se quiere quedar*/
		List<String> pedirInfoOtroGrupo_numIntegrantes = new ArrayList<String>();
		pedirInfoOtroGrupo_numIntegrantes.add("Necesito saber con cuántas personas queréis quedar.");
		pedirInfoOtroGrupo_numIntegrantes.add("¿Con cuántas personas os gustaría quedar?");
		pedirInfoOtroGrupo_numIntegrantes.add("¿Queréis quedar con un número aproximado de personas u os da igual?");
		
		List<String> imperativoInfoOtroGrupo_numIntegrantes = new ArrayList<String>();
		imperativoInfoOtroGrupo_numIntegrantes.add("Vamos mas lentos que los caracoles :( ¡¡Decidme el número de integrantes del otro grupo!! ¿¿U os da igual??");
		
		List<String> noInfoValidaOtroGrupo = new ArrayList<String>();
		noInfoValidaOtroGrupo.add("¡Creo que no me estáis entendiendo bien! Yo lo que quiero que me digais es el número de personas, edad y sexo del otro grupo con el que queréis quedar.");
		
		List<String> errorInfoOtroGrupo_numIntegrantes = new ArrayList<String>();
		errorInfoOtroGrupo_numIntegrantes.add("Así que queréis quedar con un grupo de 0 personas... ¡¡pues ya esta la quedada!! Venga, en serio, decidme con cuantas personas queréis quedar.");
	
		List<String> pedirInfoOtroGrupo_edad = new ArrayList<String>();
		pedirInfoOtroGrupo_edad.add("¿Qué edad media te gustaría que tuvieran?");
		pedirInfoOtroGrupo_edad.add("¿Qué edad, mas o menos, queréis que tengan?");
		
		List<String> imperativoInfoOtroGrupo_edad = new ArrayList<String>();
		imperativoInfoOtroGrupo_edad.add("Cómo os gusta tomarme el pelo... ¿Qué edad media os gustaría que tuvieran?");
		
		List<String> errorInfoOtroGrupo_edad = new ArrayList<String>();
		errorInfoOtroGrupo_edad.add("Perdonad, pero sólo podéis quedar con gente mayor de edad... Decidme una edad aproximada,  por favor.");
		
		List<String> pedirInfoOtroGrupo_sexo = new ArrayList<String>();
		pedirInfoOtroGrupo_sexo.add("¿Queréis quedar con chicos, chicas u os da igual?");
		pedirInfoOtroGrupo_sexo.add("¿Queréis que sean hombres, mujeres u os da igual?");
		
		List<String> confirmacionInfoOtroGrupo_sexo = new ArrayList<String>();
		confirmacionInfoOtroGrupo_sexo.add("Okay, ya sabemos el sexo del otro grupo");
		
		List<String> imperativoInfoOtroGrupo_sexo = new ArrayList<String>();
		imperativoInfoOtroGrupo_sexo.add("Venga... Necesito saber el sexo del otro grupo. Si os das igual, decídmelo");
		
		
		List<String> imperativoPedirInfoOtroGrupo = new ArrayList<String>();
		imperativoPedirInfoOtroGrupo.add("Por favor, necesito que me digais los datos de la gente con la que queréis quedar");
		imperativoPedirInfoOtroGrupo.add("Si no me decís con quien os gustaría quedar no podré ayudaros :(");
		
		List<String> confirmacionInfoOtroGrupo = new ArrayList<String>();
		confirmacionInfoOtroGrupo.add("¡¡Muchas gracias!! Ya tengo la información sobre el otro grupo");
		confirmacionInfoOtroGrupo.add("Genial, pasemos ahora a determinar los datos de la quedada ;)");
		confirmacionInfoOtroGrupo.add("Esto va sobre la marcha. Vamos a hablar de la quedada.");
	/*///////////////////// */
		
	/* Obtener que se quiere hacer*/
		List<String> pedirQueHacer = new ArrayList<String>();
		pedirQueHacer.add("¿Qué os apetece hacer?");
		pedirQueHacer.add("¿Qué os gustaria hacer?");
		pedirQueHacer.add("¿Cual es el plan que se os ha ocurrido?");
		pedirQueHacer.add("¿Sabéis el plan que queréis hacer u os da igual?");
		
		List<String> imperativoQueHacer = new ArrayList<String>();
		imperativoQueHacer.add("Necesito saber qué queréis hacer...Si no lo sabeis u os da igual, podéis decirme 'me da igual'");
		imperativoQueHacer.add("No seas rollo. ¿Qué os apetece hacer?");
		
		List<String> confirmacionQueHacer = new ArrayList<String>();
		confirmacionQueHacer.add("¡¡Bien!! Ya sabemos el plan.");
		confirmacionQueHacer.add("Suena interesante... Seguro que lo pasais genial :)");
		confirmacionQueHacer.add("¡Qué divertido! Pasemos a lo siguiente.");
	/*///////////////////// */
		
	/* Obtener donde se quiere hacer*/
		List<String> pedirDonde = new ArrayList<String>();
		pedirDonde.add("Ahora necesito saber el sitio. Algunas opciones son Sol, Atocha, Príncipe Pío...");
		pedirDonde.add("¿Donde queréis quedar? Lo mejor es que me digáis un lugar bien conocido.");
		pedirDonde.add("Ahora tenéis que decirme el sitio. Procurad que sea conocido para encontraros a otro grupo cuanto antes :)");
		
		List<String> imperativoDonde = new ArrayList<String>();
		imperativoDonde.add("Sois unos cansinos... ¡Decidme donde queréis quedar!");
		imperativoDonde.add("No tengo todo el dia, ¿Sabéis el lugar u os da igual?");
		
		List<String> confirmacionDonde = new ArrayList<String>();
		confirmacionDonde.add("Vale, ya tenemos el lugar para quedar");
		confirmacionDonde.add("Ese lugar me suena ;)");
	/*///////////////////// */
		
	/* Obtener fecha y hora */	
		List<String> pedirFechayHora = new ArrayList<String>();
		pedirFechayHora.add("¿Cuándo queréis quedar con el otro grupo?");
		pedirFechayHora.add("¿Cuándo os gustaría quedar con el otro grupo?");
		pedirFechayHora.add("¿Cuándo queréis hacer la quedada con el otro grupo?");
		
		List<String> imperativopedirFechayHora = new ArrayList<String>();
		imperativopedirFechayHora.add("No podré encontrar a otro grupo para quedar a menos que me digáis cuándo queréis quedar...");
		imperativopedirFechayHora.add("Por favor, necesito saber cuándo queréis quedar.");
		imperativopedirFechayHora.add("Yo también tengo vida... Dime cuándo queréis quedar, anda.");
		
		List<String> confirmarFechayHora = new ArrayList<String>();
		confirmarFechayHora.add("¡¡Perfecto!! Ya tenemos la fecha y la hora ;)");
		confirmarFechayHora.add("Vale, esa fecha es válida.");
		
		List<String> pedirFecha = new ArrayList<String>();
		pedirFecha.add("¿Qué día exacto queréis quedar?");
		
		List<String> fechaAnterior = new ArrayList<String>();
		fechaAnterior.add("Jajaja estáis locos ¡No podéis quedar en un día que ya ha pasado! Decidme un día a partir de hoy.");
		fechaAnterior.add("A pesar de que estáis hablando con un bot, la tecnología no ha avanzado suficiente como para viajar en el tiempo jajaja. Decidme un dia a partir de hoy.");
		
		List<String> pedirHora = new ArrayList<String>();
		pedirHora.add("¿A qué hora exacta os gustaría quedar?");
	/*///////////////////// */
				
	/* Confirmar quedada*/	
		List<String> confirmarQuedada = new ArrayList<String>();
		confirmarQuedada.add("Voy a buscaros un grupo. Dadme un momentito ¡¡please!!");
		confirmarQuedada.add("Comenzaré a buscaros al otro grupo para que quedéis ;)");
		confirmarQuedada.add("Bien, dadme unos segundos para que busque un plan que se adapte lo máximo posible a vuestra quedada...");
		
		
		List<String> imperativoConfirmarQuedada = new ArrayList<String>();
		imperativoConfirmarQuedada.add("¿Estáis de acuerdo?");
		imperativoConfirmarQuedada.add("¿Esto es lo que estáis buscando?");
	/*///////////////////// */
		
	/* Rechazar quedada*/	
		List<String> rechazarQuedada = new ArrayList<String>();
		rechazarQuedada.add("Siento no haber podido ayudarte ;(. Espero que volvamos a hablar pronto. Chaoo");
		rechazarQuedada.add("Ok, siento que no os haya gustado mi propuesta :(");
	
		
	/*///////////////////// */
		
	/* Matching */
		List<String> conMatching = new ArrayList<String>();
		conMatching.add("¡¡Os he encontrado una quedada!! Se trata de");
		conMatching.add("¡¡Aja!! Tengo un plan para vosotros:");
		
		List<String> sinMatching = new ArrayList<String>();
		sinMatching.add("Lo siento, no he encontrado ninguna quedada que se parezca a la vuestra. ¿Queréis que os avise si encuentro una?");
		sinMatching.add("Vaya... no tengo localizada ninguna quedada similar ;( ¿¿Os aviso cuando encuentre una??");
		
	/*///////////////////// */
		
	/* Fin */
		List<String> despedirse = new ArrayList<String>();
		despedirse.add("Vaya... siento no haberos sido de ayuda ;( ¡Espero que volvais pronto!");
		despedirse.add("Jouch, odio las despedidas. Nos vemos pronto, ¿eeh? ;)");
		
		List<String> finalizar = new ArrayList<String>();
		finalizar.add("Mi tarea aquí ha concluido. Os avisaré sobre las novedades de vuestra quedada cada vez que volvais. Chaoo ;)");
		finalizar.add("Me ha encantado ayudaros. Os mantendré informados cada vez que volvamos a hablar. ¡¡Hasta luego cocodrilo!!");
		
	/*///////////////////// */
		
		
	/* Agregamos los dialogos a la conversacion global */
		conversacionGrupo.put("sinContexto", sinContexto);
		conversacionGrupo.put("pedirInfoOtroGrupo", pedirInfoOtroGrupo);
		conversacionGrupo.put("confirmacionInfoOtroGrupo", confirmacionInfoOtroGrupo);
		conversacionGrupo.put("noInfoValidaOtroGrupo", noInfoValidaOtroGrupo);
		
		conversacionGrupo.put("pedirInfoOtroGrupo_numIntegrantes", pedirInfoOtroGrupo_numIntegrantes);
		conversacionGrupo.put("errorInfoOtroGrupo_numIntegrantes", errorInfoOtroGrupo_numIntegrantes);
		conversacionGrupo.put("imperativoInfoOtroGrupo_numIntegrantes", imperativoInfoOtroGrupo_numIntegrantes);
		
		conversacionGrupo.put("pedirInfoOtroGrupo_edad", pedirInfoOtroGrupo_edad);
		conversacionGrupo.put("imperativoInfoOtroGrupo_edad", imperativoInfoOtroGrupo_edad);
		conversacionGrupo.put("errorInfoOtroGrupo_edad", errorInfoOtroGrupo_edad);
		
		conversacionGrupo.put("pedirInfoOtroGrupo_sexo", pedirInfoOtroGrupo_sexo);
		conversacionGrupo.put("confirmacionInfoOtroGrupo_sexo", confirmacionInfoOtroGrupo_sexo);
		conversacionGrupo.put("imperativoInfoOtroGrupo_sexo", imperativoInfoOtroGrupo_sexo);
		
		conversacionGrupo.put("imperativoPedirInfoOtroGrupo", imperativoPedirInfoOtroGrupo);
		
		conversacionGrupo.put("pedirQueHacer", pedirQueHacer);
		conversacionGrupo.put("imperativoQueHacer", imperativoQueHacer);
		conversacionGrupo.put("confirmacionQueHacer", confirmacionQueHacer);
		conversacionGrupo.put("pedirDonde", pedirDonde);
		conversacionGrupo.put("imperativoDonde", imperativoDonde);
		conversacionGrupo.put("confirmacionDonde", confirmacionDonde);
		conversacionGrupo.put("pedirFechayHora", pedirFechayHora);
		conversacionGrupo.put("pedirHora", pedirHora);
		conversacionGrupo.put("pedirFecha", pedirFecha);
		conversacionGrupo.put("fechaAnterior", fechaAnterior);
		conversacionGrupo.put("imperativopedirFechayHora", imperativopedirFechayHora);
		conversacionGrupo.put("confirmarFechayHora", confirmarFechayHora);
		conversacionGrupo.put("confirmarQuedada", confirmarQuedada);
		conversacionGrupo.put("rechazarQuedada", rechazarQuedada);
		conversacionGrupo.put("imperativoConfirmarQuedada", imperativoConfirmarQuedada);
		
		conversacionGrupo.put("conMatching", conMatching);
		conversacionGrupo.put("sinMatching", sinMatching);
		
		conversacionGrupo.put("despedirse", despedirse);
		conversacionGrupo.put("finalizar", finalizar);
			
	}
	
	
	public static String msg(String tipo){
		
		String msg = null;
		if(conversacionGrupo.get(tipo) != null && conversacionGrupo.get(tipo).size() > 0){
			int index = (int)(System.currentTimeMillis() % conversacionGrupo.get(tipo).size());
			msg = conversacionGrupo.get(tipo).get(index);
		}
		return msg;
	}
	
}
