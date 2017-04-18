package icaro.aplicaciones.informacion.gestionPizzeria;

import java.util.ArrayList;
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
	

	public MasaPizza masa;
	public TamanioPizza tamanio;
	public SalsaPizza salsa;
	public List<Ingrediente> ingredientes;
	public boolean personalizada; 
	public Usuario usuarioCreador; // será un admin general si no la ha creado un usuario
	public String nombrePizza; // nombre de la pizza
	
	public static String String_Default="";
	public Pizza(){
		ingredientes = new ArrayList<Ingrediente>();
		usuarioCreador = new Usuario();
		salsa.salsa = String_Default;
	}
	
	
}
