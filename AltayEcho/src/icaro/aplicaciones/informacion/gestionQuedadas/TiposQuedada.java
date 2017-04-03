package icaro.aplicaciones.informacion.gestionQuedadas;

/**
 * 
 * @author Mariano Hernández García
 *
 */
public enum TiposQuedada {
	
	beber, deporte, deporte_futbol, deporte_baloncesto, deporte_tenis, deporte_bici, deporte_correr, deporte_patinar, 
	cultural, cultura_cine, cultura_museo, cultura_karaoke, cultura_opera, cultura_musical, cultura_parque_tematico, 
	compras,
	comer,
	fiesta,
	da_igual;
	
	public String toString() {
		switch (this) {
			case beber: return "ir a tomar algo";
			case deporte: return "practicar un deporte";
			case deporte_futbol: return "jugar al futbol";
			case deporte_baloncesto: return "jugar al baloncesto";
			case deporte_tenis: return "jugar al tenis";
			case deporte_bici: return "montar en bici";
			case deporte_correr: return "correr";
			case deporte_patinar: return "patinar";
			case cultural: return "hacer una actividad cultural";
			case cultura_cine: return "ver una peli";
			case cultura_museo: return "ir al museo";
			case cultura_karaoke: return "cantar en un karaoke";
			case cultura_opera: return "asistir a la opera";
			case cultura_musical: return "ver un musical";
			case cultura_parque_tematico: return "divertirse en un paqrue tematico";
			case compras: return "ir de compras";
			case comer: return "comer";
			case fiesta: return "ir de fiesta";
			case da_igual: return "hacer cualquier plan";
		}
		return null;
	}
	
	public static TiposQuedada parseaDeporte(String msg) {
		if( msg.contains("futbol") || msg.contains("fútbol") ) 
			return TiposQuedada.deporte_futbol;
		else if ( msg.contains("baloncesto") || msg.contains("basket") )
			return TiposQuedada.deporte_baloncesto;
		else if ( msg.contains("tenis") )
			return TiposQuedada.deporte_tenis;
		else if ( msg.contains("bici") || msg.contains("bicicleta") )
			return TiposQuedada.deporte_bici;
		else if ( msg.contains("correr") || msg.contains("running") )
			return TiposQuedada.deporte_correr;
		else if ( msg.contains("patinar") )
			return TiposQuedada.deporte_patinar;
		else return TiposQuedada.deporte;
	}
	
	public static TiposQuedada parseaCultural(String msg) {
		if( msg.contains("cine") || msg.contains("peli") ) 
			return TiposQuedada.cultura_cine;
		else if ( msg.contains("museo") )
			return TiposQuedada.cultura_museo;
		else if ( msg.contains("karaoke") )
			return TiposQuedada.cultura_karaoke;
		else if ( msg.contains("opera"))
			return TiposQuedada.cultura_opera;
		else if ( msg.contains("musical") )
			return TiposQuedada.cultura_musical;
		else if ( msg.contains("zoo") || msg.contains("atracciones"))
			return TiposQuedada.cultura_parque_tematico;
		else return TiposQuedada.cultural;
	}

}