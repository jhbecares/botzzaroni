package icaro.aplicaciones.informacion.gestionQuedadas;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import icaro.aplicaciones.informacion.gestionQuedadas.DateUtil;

/**
 *  Clase que modela una quedada
 *  
 * @author Mariano Hern�ndez Garc�a Y Jorge Casas Hernan
 *
 */
public class Quedada implements Serializable {


	private static final long serialVersionUID = -2159848484753598994L;
	public String idChat;			
	private Grupo grupoEmisor;
	private Grupo grupoQueAcepta;
	private int numIntegrantes;
	private Sexo sexo;
	private int edad;
	private TiposQuedada queHacer;
	private String descripcion_queHacer;
	private String lugar;
	private Calendar fecha;
	private boolean confirmada;


	private long tiempo;
	
	public Quedada(String idChat, Grupo grupoEmisor) {
		this.idChat 			  = idChat;
		this.grupoEmisor		  = grupoEmisor;
		this.grupoQueAcepta		  = null;
		this.numIntegrantes 	  = 0;
		this.sexo 				  = null;
		this.edad 				  = 0;
		this.tiempo 			  = System.currentTimeMillis();
		this.queHacer 			  = null;
		this.descripcion_queHacer = null;
		this.lugar 				  = "";
		this.fecha				  = null;
		this.confirmada			  = false;
	}

	public void setGrupoEmisor(Grupo grupoEmisor) {
		this.grupoEmisor = grupoEmisor;
	}
	
	public Grupo getGrupoEmisor() {
		return grupoEmisor;
	}
	
	public void setGrupoQueAcepta(Grupo grupoQueAcepta) {
		this.grupoQueAcepta = grupoQueAcepta;
	}
	
	public Grupo getGrupoQueAcepta() {
		return grupoQueAcepta;
	}

	public int getNumIntegrantes() {
		return numIntegrantes;
	}

	public void setNumIntegrantes(int numIntegrantes) {
		this.numIntegrantes = numIntegrantes;
	}

	public String getSexo() {
		// Se puede utilizar sexo.toString() directamente
		String sexo_str = null;
		if (sexo == Sexo.masculino)
			sexo_str = "hombres";
		else if (sexo == Sexo.masculino)
			sexo_str = "mujeres";
		else if (sexo == Sexo.masculino)
			sexo_str = "mixto";
		return sexo_str;
	}

	public void setSexo(String sexo) {
		if(sexo.indexOf("hombre") >= 0)
			this.sexo = Sexo.masculino;
		else if(sexo.indexOf("mujer") >= 0)
			this.sexo = Sexo.femenino;
		else if(sexo.indexOf("mixto") >= 0)
			this.sexo = Sexo.mixto;
		else if(sexo.indexOf("sin_especificar") >= 0) {
			this.sexo = Sexo.sin_especificar;
		}
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public void actividad() {
		tiempo = System.currentTimeMillis();
	}
	
	public boolean inactividad(int i) {
		long tim = ((System.currentTimeMillis() - tiempo) / 1000) / 60;
		return tim >= i;
	}
	
	
	public String getQueHacer() {
		return queHacer.toString();
	}

	public void setQueHacer(TiposQuedada queHacer) {
		this.queHacer = queHacer;
	}
	
	public String getDescripcionQueHacer() {
		return this.descripcion_queHacer;
	}
	
	public void setDecripcionQueHacer(String desc) {
		if(desc != null)
			this.descripcion_queHacer = desc;
	}
	
	public void setLugar(String dondeHacer) {
		this.lugar = dondeHacer;
	}

	public String getLugar() {
		return lugar;
	}
	
	public Calendar getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		if (this.fecha == null)
			this.fecha = DateUtil.toCalendar(new Date());
		
		String[] parts = fecha.split("/");
		this.fecha.set(Calendar.DAY_OF_MONTH, Integer.parseInt(parts[0]));
		this.fecha.set(Calendar.MONTH, Integer.parseInt(parts[1]));
		this.fecha.set(Calendar.YEAR, Integer.parseInt(parts[2]));
	}
	
	public void setHora(String hora) {
		if (this.fecha == null)
			this.fecha = DateUtil.toCalendar(new Date());
		
		String[] parts;
		if(hora.indexOf(":") >= 0)
			parts = hora.split(":");
		else if(hora.indexOf(".") >= 0)
			parts = hora.split("\\.");
		else
			parts = hora.split(" ");
		
		this.fecha.set(Calendar.HOUR_OF_DAY, Integer.parseInt(parts[0]));
		this.fecha.set(Calendar.MINUTE, Integer.parseInt(parts[1]));
	}
	
	public boolean getConfirmada() {
		return this.confirmada;
	}
	
	public void setConfirmada(boolean confirmada) {
		this.confirmada = confirmada;
	}

	private String getFechaFormateada() {
		
		String min = "" + fecha.get(Calendar.MINUTE);
		String dia = "";
		String mes = ""; 
		
		if ( fecha.get(Calendar.MINUTE) < 10 )	
			min = "0" + min;
		
		switch(this.fecha.get(Calendar.DAY_OF_MONTH)) {
			case Calendar.MONDAY:
				dia = "lunes";
			break;
			case Calendar.TUESDAY:
				dia = "martes";
			break;
			case Calendar.WEDNESDAY:
				dia = "miercoles";
			break;
			case Calendar.THURSDAY:
				dia = "jueves";
			break;
			case Calendar.FRIDAY:
				dia = "viernes";
			break;
			case Calendar.SATURDAY:
				dia = "sabado";
			break;
			case Calendar.SUNDAY:
				dia = "domingo";
			break;
		}
		
		switch(this.fecha.get(Calendar.MONTH) - 1) {
			case Calendar.JANUARY:
				mes = "Enero";
			break;
			case Calendar.FEBRUARY:
				mes = "Febrero";
			break;
			case Calendar.MARCH:
				mes = "Marzo";
			break;
			case Calendar.APRIL:
				mes = "Abril";
			break;
			case Calendar.MAY:
				mes = "Mayo";
			break;
			case Calendar.JUNE:
				mes = "Junio";
			break;
			case Calendar.JULY:
				mes = "Julio";
			break;
			case Calendar.AUGUST:
				mes = "Agosto";
			break;
			case Calendar.SEPTEMBER:
				mes = "Septiembre";
			break;
			case Calendar.OCTOBER:
				mes = "Octubre";
			break;
			case Calendar.NOVEMBER:
				mes = "Noviembre";
			break;
			case Calendar.DECEMBER:
				mes = "Diciembre";
			break;
		}
		
		return dia + " " + fecha.get(Calendar.DAY_OF_MONTH) + " de " + mes + " a las " + fecha.get(Calendar.HOUR_OF_DAY) + ":" + min;//+ "/" + fecha.get(Calendar.MONTH) + "/" + fecha.get(Calendar.YEAR) + " a las " + fecha.get(Calendar.HOUR_OF_DAY) + ":" + min;
	}

	@Override
	public String toString() {
		
		String que = "";
		String donde = "";
		String integrantes = "";
		String edad = "";
		String sexo = "";
		
		if ( descripcion_queHacer == null ) {
			que = getQueHacer();
		}
		else {
			que = getQueHacer() + " (" + descripcion_queHacer + ")";
		}
		
				
		if ( this.lugar == null) 
			donde = "cualquier lugar";
		else
			donde = this.lugar;
		
		if ( this.edad == -1 ) 
			edad = "sin especificar";
		else 
			edad = "de " + this.edad + " años ";
		
		if ( this.sexo == Sexo.sin_especificar ) 
			sexo = "sin especificar";
		else
			sexo = this.sexo.toString();
		
		if ( this.numIntegrantes != -1)
			integrantes = " " + this.numIntegrantes;
		
		
		return que + " en " + donde + " el " + this.getFechaFormateada() + ", con un grupo de" + integrantes + " personas, de una edad media " + edad + " y de sexo " + sexo; 
	}

	

}
