package icaro.aplicaciones.agentes.AgenteAplicacionPago.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConversacionPago {
	
	private static HashMap<String,List<String>> conversacion;
	
	static{
		conversacion = new HashMap<String, List<String>>();
		
		List<String> confirmacionPedido = new ArrayList<String>();
		confirmacionPedido.add("¿Aceptas el pedido?");
		confirmacionPedido.add("Antes de comenzar el pago. ¿Aceptas el pedido?");
		
		List<String> aceptaDesconocido = new ArrayList<String>();
		aceptaDesconocido.add("En serio, necesito saber si aceptas el pedido para poder continuar");
		aceptaDesconocido.add("Perdona, no te he entendido. ¿Aceptas el pedido?");
		aceptaDesconocido.add("Aceptas el pedido, ¿sí o no?");
		
		List<String> solicitarMetodoDePago = new ArrayList<String>();
		solicitarMetodoDePago.add("Bueno y ahora llega la parte más dolorosa ... ¿Deseas pagar en efectivo o con tarjeta?");
		solicitarMetodoDePago.add("Vale, ya casi estamos. ¿Cómo quieres realizar el pago: en efectivo o con tarjeta?");
		solicitarMetodoDePago.add("Disponemos de pago en efectivo o con tarjeta ¿Qué método prefieres?");
		
		List<String> metodoDePagoTarjeta = new ArrayList<String>();
		metodoDePagoTarjeta.add("Muy bien, nuestro repartidor llevara el datáfono");
		metodoDePagoTarjeta.add("Perfecto, el pago se efectuará con tarjeta");
		
		List<String> metodoDePagoEfectivo = new ArrayList<String>();
		metodoDePagoEfectivo.add("Perfecto, pago en efectivo. ¿Necesitas cambio?");
		metodoDePagoEfectivo.add("Ok, el pago se realizará en efectivo. ¿Vas a necesitar cambio?");
		
		List<String> solicitarCambio = new ArrayList<String>();
		solicitarCambio.add("¿Podrías decirme cuál va a ser la cantidad con la que vas a pagar?. Así podré llevar el cambio justo.");
		solicitarCambio.add("¿De cuánto?");
		
		List<String> cambioDesconocido = new ArrayList<String>();
		cambioDesconocido.add("En serio, necesito saber si necesitas cambio para poder continuar");
		cambioDesconocido.add("Perdona, no te he entendido. ¿Necesitas cambio?");
		cambioDesconocido.add("Necesitas cambio, ¿sí o no?");
		
		List<String> cambioInvalido = new ArrayList<String>();
		cambioInvalido.add("En serio, necesito saber con qué vas a pagar para poder continuar");
		cambioInvalido.add("Perdona, no te he entendido. ¿Me lo puedes repetir?");
		cambioInvalido.add("Por favor, dime de cuánto necesitas el cambio");
		
		List<String> finPago = new ArrayList<String>();
		finPago.add("Perfecto, ya hemos terminado con el pago");
		
		List<String> metodoDePagoDesconocido = new ArrayList<String>();
		metodoDePagoDesconocido.add("Este método de pago no está disponible en Botzzaroni. Dinos otro, por favor.");
		metodoDePagoDesconocido.add("Este método de pago no está disponible en Botzzaroni. Los métodos válidos son en efectivo y con tarjeta.");

		
		List<String> inactividad = new ArrayList<String>();
		inactividad.add("¡Qué solo estoy! ¡¡Qué solo!! Decidme algo ;(");
		inactividad.add("Soy un robot muy ocupado, ¡¡no puedo esperar eternamente!!");
			
		List<String> sincontexto = new ArrayList<String>(); 
		sincontexto.add("Disculpa que sea tan cortito, pero no te estoy entendiendo ;(");
		sincontexto.add("No me estarás vacilando, ¿no? Es que no entiendo de que me estás hablando :(");
		sincontexto.add("Lo siento, pero no os entiendo. Estoy preparado especialmente para pedir pizzas ;(");

		List<String> despedida = new ArrayList<String>(); 
		despedida.add("Espero que volváis pronto. ¡¡Ciaooo!! ");
		despedida.add("¡¡Hasta pronto!!");
		despedida.add("¡¡Adiós!! Espero que os hayáis llevado una buena impresión de mí :)");
		despedida.add("¡¡Hasta la próxima!! :)");

		conversacion.put("confirmacionPedido", confirmacionPedido);
		conversacion.put("aceptaDesconocido", aceptaDesconocido);
		conversacion.put("solicitarMetodoDePago", solicitarMetodoDePago);
		conversacion.put("metodoDePagoTarjeta", metodoDePagoTarjeta);
		conversacion.put("metodoDePagoEfectivo", metodoDePagoEfectivo);
		conversacion.put("metodoDePagoDesconocido", metodoDePagoDesconocido);
		conversacion.put("cambioDesconocido", cambioDesconocido);
		conversacion.put("solicitarCambio", solicitarCambio);
		conversacion.put("cambioInvalido", cambioInvalido);
		
		conversacion.put("inactividad", inactividad);
		conversacion.put("sincontexto", sincontexto);
		conversacion.put("despedida", despedida);
		
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
