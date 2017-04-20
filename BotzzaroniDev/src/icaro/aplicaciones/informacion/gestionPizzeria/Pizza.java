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
	
	private String nombrePizza; // nombre de la pizza
	private ArrayList<Ingrediente> ingredientes;
	private TamanioPizza tamanio;
	private MasaPizza masa;
	private String salsa;
	private double precio;
	private Usuario usuarioCreador; // será un admin general si no la ha creado un usuario
	private boolean personalizada; 
		
	public static String String_Default="";
	
	// FIXME
	public Pizza(){
		ingredientes = new ArrayList<Ingrediente>();
		usuarioCreador = new Usuario();
		salsa = String_Default;
	}
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public MasaPizza getMasa() {
		return masa;
	}
	
	public void setMasa(MasaPizza masa) {
		this.masa = masa;
	}
	
	public TamanioPizza getTamanio() {
		return tamanio;
	}
	
	public void setTamanio(TamanioPizza tamanio) {
		this.tamanio = tamanio;
	}
	
	public String getSalsa() {
		return salsa;
	}
	
	public void setSalsa(String salsa) {
		this.salsa = salsa;
	}
	
	public ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}
	
	public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}
	
	public boolean isPersonalizada() {
		return personalizada;
	}
	
	public void setPersonalizada(boolean personalizada) {
		this.personalizada = personalizada;
	}
	
	public Usuario getUsuarioCreador() {
		return usuarioCreador;
	}
	
	public void setUsuarioCreador(Usuario usuarioCreador) {
		this.usuarioCreador = usuarioCreador;
	}
	
	public String getNombrePizza() {
		return nombrePizza;
	}
	
	public void setNombrePizza(String nombrePizza) {
		this.nombrePizza = nombrePizza;
	}

	@Override
	public String toString() {
		return "\n" + "Pizza " + nombrePizza + " ------------------------------------ " + precio + " €" +  "\n" +
				"Tamaño: " + tamanio + " - Masa: " + masa + " - Salsa: " + salsa + "\n" +
				"Ingredientes: " + ingredientes.toString().replace("[", "").replace("]", "");
	}
	

	
	
}
