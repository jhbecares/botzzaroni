import java.util.List;

public class Pizza {
	
	// TODO se debería considerar sacar la masa y el tamanyo de aquí
	// y, además, también considerar que pizza fuera una interfaz o algo
	// así y que luego se implemente pizzaCarta y pizzaPersonalizada, 
	// porque me he dado cuenta
	// de que hay que guardar cosas más "tochas" como el usuario y tal.
	// no sé...

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
	private Usuario usuarioCreador; // será un admin general si no la ha creado un usuario
	private String nombrePizza; // nombre de la pizza
	
	
}
