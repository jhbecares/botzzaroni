package icaro.aplicaciones.informacion.gestionPizzeria;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Pedido {
	
	public enum MetodoPago{
		tarjeta, efectivo
	}
	
	
	public Usuario usuario;
	public List<Pizza> pizzas;
	private List<Bebida> bebidas ;
	private MetodoPago metodoPago;
	private int cambioEfectivo;
	private Date fechaEntrega;
	public boolean tieneAlergia;
	private List<Ingrediente> alergias;
	public int numeroPizzas;
	public int numeroTotalPizzas;
	
	public Pedido(){
		usuario = new Usuario();
		pizzas = new ArrayList<Pizza>();
	}
	
	/*
	 * java.util.Date utilDate = new java.util.Date();
	 * java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	 */
	
}
