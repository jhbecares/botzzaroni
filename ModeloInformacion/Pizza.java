import java.util.List;

public class Pizza {
	
	public enum MasaPizza{
		normal, fina, queso
	}
	
	public enum TamanioPizza{
		pequenia, mediana, familiar
	}
	

	private MasaPizza masa;
	private TamanioPizza tamanio;
	private SalsaPizza salsa;
	private List<Ingrediente> ingredientes;
	private boolean personalizada;
	
	
}
