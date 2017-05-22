package icaro.aplicaciones.informacion.gestionPizzeria;

public class Bebida {
	
	public enum TipoBebida{ // Provisional, a�adir m�s
		fantalimon, fantaNaranja, cocacola, cerveza, agua, nestea		
	}
	
	public enum TamanioBebida{ // Provisional, para modificar
		lata, botellaLitro, botellaDosLitros
	}
	
	private TipoBebida tipoBebida;
	private TamanioBebida tamanioBebida;
	private double precio; 
	
	public String toString(){
		return tipoBebida.toString() + "( " + tamanioBebida.toString() + ")" + " ------------------------------------ " + precio;
	}
	
	public void establecePrecio(){
		if (tamanioBebida.equals(TamanioBebida.lata)){
			precio = 1.20;
		}
		else if (tamanioBebida.equals(TamanioBebida.botellaLitro)){
			precio = 2.10;
		}
		else if (tamanioBebida.equals(TamanioBebida.botellaDosLitros)){
			precio = 3.00;
		}
	}
	
	public double getPrecio(){
		return precio;
	}
}
