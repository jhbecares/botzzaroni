package icaro.aplicaciones.informacion.gestionQuedadas;

/**
 * 
 * @author Mariano Hernández García
 *
 */
public enum Sexo {
	
	masculino, femenino, mixto, sin_especificar;
	
	public String toString() {
		switch (this) {
			case masculino: return "masculino";
			case femenino: return "femenino";
			case mixto: return "mixto";
			case sin_especificar: return "sin especificar";
		}
		return null;
	}

}