package icaro.aplicaciones.informacion.gestionPizzeria;
import java.util.List;
import java.util.Date;

public class Pedido {
	
	public enum MetodoPago{
		tarjeta, efectivo
	}
	
	
	private Usuario usuario;
	private List<Pizza> pizzas;
	private List<Bebida> bebidas ;
	private MetodoPago metodoPago;
	private int cambioEfectivo;
	private Date fechaEntrega;
	private List<Ingrediente> alergias;
	
	/*
	 * java.util.Date utilDate = new java.util.Date();
	 * java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	 */
	
}
