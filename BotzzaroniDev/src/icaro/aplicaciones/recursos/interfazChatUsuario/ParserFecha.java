package icaro.aplicaciones.recursos.interfazChatUsuario;


import icaro.aplicaciones.informacion.gestionPizzeria.Notificacion;
import icaro.aplicaciones.informacion.gestionPizzeria.tipoNotif;
//import icaro.aplicaciones.informacion.gestionQuedadas.tipoNotif;
//import icaro.aplicaciones.informacion.gestionQuedadas.Notificacion;
import icaro.aplicaciones.informacion.gestionPizzeria.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class ParserFecha {
	
	public static final SimpleDateFormat slashFormatter = new SimpleDateFormat("dd/MM/yyyy");

	private static final int DIA = 1;
	private static final int SEMANA = 7;
	private static final int MES = 30;
	private static final int ANO = 365;

	/**
	 * Los valores de estas claves se sumar�n/restar�n a la fecha actual
	 */
	private static final Map<String, Integer> MAPEO_FECHAS = new HashMap<String, Integer>() {

		/**
		 * 
		 */
		private static final long serialVersionUID = 685284131402410709L;

		{
			put("hoy", 0);
			put("pasado mañana", 2 * DIA);
			put("mañana", DIA);
			put("maniana", DIA);
			put("manana", DIA);
			put("ayer", -DIA);
			put("semana que viene", SEMANA);
			put("semana próxima", SEMANA);
			put("semana proxima", SEMANA);
			put("semana siguiente", SEMANA);
			put("siguiente semana", SEMANA);
			put("siguiente semana", SEMANA);
			put("mes que viene", MES);
			put("mes siguiente", MES);
			put("año siguiente", ANO);
			put("año próximo", ANO);
			put("año proximo", ANO);
			put("próximo año", ANO);
			put("mes próximo", MES);
			put("mes proximo", MES);
			put("proximo año", ANO);
			put("proximo mes", MES);
			put("próximo mes", MES);
			put("próxima semana", SEMANA);
			put("proxima semana", SEMANA);
			put("próximo día", DIA);
			put("proximo día", DIA);
			put("proximo dia", DIA);
		}
	};

	/**
	 * Los valores de estas claves ser�n usados para obtener la fecha
	 * correspondiente al d�a de la semana
	 */
	private static final Map<String, Integer> MAPEO_DIAS_SEMANA = new HashMap<String, Integer>() {

		/**
		 * 
		 */
		private static final long serialVersionUID = -2170365284292450115L;

		{
			put("lunes", Calendar.MONDAY);
			put("martes", Calendar.TUESDAY);
			put("miércoles", Calendar.WEDNESDAY);
			put("miercoles", Calendar.WEDNESDAY);
			put("jueves", Calendar.THURSDAY);
			put("viernes", Calendar.FRIDAY);
			put("sábado", Calendar.SATURDAY);
			put("sabado", Calendar.SATURDAY);
			put("domingo", Calendar.SUNDAY);
		}
	};

	private ParserFecha() {
	}

	/**
	 * Dada una notificaci�n con una anotaci�n de tipo "fecha" del tipo
	 * "ma�ana, pasado, ayer, el viernes, etc." la convierte a un mensaje de
	 * tipo "dd/MM/yyyy"
	 * 
	 * @param notif
	 * @return
	 */
	public static final Notificacion parseaFecha(Notificacion notif) {

		String msg = notif.getMensajeNotificacion();

		Integer dias = MAPEO_FECHAS.get(msg);

		if (dias != null) {
			Date date = new Date();
			Date nuevaFecha = DateUtil.addDays(date, dias);
			if (nuevaFecha.before(date)) {
				// enviar notificacion a usuario de que la fecha es anterior a
				// la actual.
				// poner anotacion de fecha anterior a la actual y que el agente
				// espere esta
				// notificacion para enviar mensaje al usuario.
				notif.setTipoNotificacion(tipoNotif.fechaAnterior);
			} else {
				msg = slashFormatter.format(nuevaFecha);
				notif.setMensajeNotificacion(msg);
			}
		} else {

			Integer diaSemana = MAPEO_DIAS_SEMANA.get(msg);
			if (diaSemana != null) {
				Calendar calendar = Calendar.getInstance();
				Date date = new Date();
				calendar.setTime(date);
				calendar.set(Calendar.DAY_OF_WEEK, diaSemana);

				Date msgDate = calendar.getTime();
				
				if (msgDate.before(date)) {
					date = DateUtil.addDays(date, SEMANA);
					calendar.setTime(date);
					calendar.set(Calendar.DAY_OF_WEEK, diaSemana);
					msgDate = calendar.getTime();
				}
				
				msg = slashFormatter.format(msgDate);
				notif.setMensajeNotificacion(msg);
			}
		}

		return notif;
	}

	public static Object parseaFechaNumero(Notificacion notif) {
		notif.setTipoNotificacion(tipoNotif.fecha);
		String stringNumero;
		int numero=0;
		String msg = notif.getMensajeNotificacion();
		// este mensaje tiene una estructura "el" + <numero>
		String[] divisiones = msg.split(" ");
		stringNumero = divisiones[divisiones.length - 1];
		try {
			numero = Integer.valueOf(stringNumero);
		} catch (NumberFormatException exc) {
			exc.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		Date date = new Date();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, numero);
		
		Date msgDate = calendar.getTime();
		if (msgDate.before(date)) {
			// enviar notificacion a usuario de que la fecha es anterior
			// a la actual.
			// poner anotacion de fecha anterior a la actual y que el
			// agente espere esta
			// notificacion para enviar mensaje al usuario.
			//notif.setTipoNotificacion(tipoNotif.fechaAnterior);
			calendar.set(calendar.get(Calendar.YEAR),(calendar.get(Calendar.MONTH))+1,numero);
			msgDate = calendar.getTime();
		} 
		msg = slashFormatter.format(msgDate);
		notif.setMensajeNotificacion(msg);
		return notif;
	}
}
