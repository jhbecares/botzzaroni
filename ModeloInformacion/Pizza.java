import java.util.List;

public class Pizza {
	
	public enum MasaPizza{
		normal, fila, queso
	}
	
	public enum TamanioPizza{
		pequenia, mediana, familiar
	}
	
	public enum SalsaPizza{
		carbonara, barbacoa, diabola, tomate, botzzaroni
	}
	
	public enum Ingrediente{ // Provisional, añadir
		jamonYork, mozzarella, cheddar, chorizo, jamonSerrano, pollo
	}

	private MasaPizza masa;
	private TamanioPizza tamanio;
	private SalsaPizza salsa;
	private List<Ingrediente> ingredientes;
	private boolean personalizada;
	
	
}
