package icaro.aplicaciones.informacion.gestionPizzeria;
import java.util.List;

import icaro.aplicaciones.informacion.gestionPizzeria.Pizza.MasaPizza;
import icaro.aplicaciones.informacion.gestionPizzeria.Pizza.TamanioPizza;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Pedido {
	
	public enum MetodoPago{
		tarjeta, efectivo
	}
	
	
	private Usuario usuario;
	private ArrayList<Pizza> pizzas;
	private List<String> bebidas ;
	private MetodoPago metodoPago;
	private int cambioEfectivo;
	private Date fechaEntrega;
	private List<Ingrediente> alergias;
	private int nBebidas;

	public Pedido(){
		nBebidas=0;
		pizzas = new ArrayList<Pizza>();
		bebidas = new ArrayList<String>();
		ArrayList<String> ingredientes  = new ArrayList<String>(Arrays.asList("Quesos ", "Bacon", "Champiñón", "Cebolla"));
		Pizza pizza = new Pizza();
		pizza.setNombrePizza("Carbonara");
		pizza.setSalsa("Barbacoa");
		pizza.setMasa(MasaPizza.normal);
		pizza.setTamanio(TamanioPizza.familiar);
		pizza.setPrecio(10.0);
		pizza.setIngredientes(ingredientes);
		pizzas.add(pizza);
		
		Pizza pizza1 = new Pizza();
		ArrayList<String> ingredientes1  = new ArrayList<String>(Arrays.asList("Queso", "Pollo marinado", "Bacon ahumado", "Carne de vacuno"));
		pizza1.setNombrePizza("Barbacoa");
		pizza1.setSalsa("Carbonara");
		pizza1.setMasa(MasaPizza.fina);
		pizza1.setTamanio(TamanioPizza.mediana);
		pizza1.setPrecio(7.0);
		pizza1.setIngredientes(ingredientes1);
		pizzas.add(pizza1);
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public ArrayList<Pizza> getPizzas() {
		return pizzas;
	}
	
	public void setPizzas(ArrayList<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	
	public List<String> getBebidas() {
		return bebidas;
	}
	
	public void setBebidas(List<String> bebidas) {
		this.bebidas = bebidas;
	}
	
	public MetodoPago getMetodoPago() {
		return metodoPago;
	}
	
	public void setMetodoPago(MetodoPago metodoPago) {
		this.metodoPago = metodoPago;
	}
	
	public int getCambioEfectivo() {
		return cambioEfectivo;
	}
	
	public void setCambioEfectivo(int cambioEfectivo) {
		this.cambioEfectivo = cambioEfectivo;
	}
	
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	
	public List<Ingrediente> getAlergias() {
		return alergias;
	}
	
	public void setAlergias(List<Ingrediente> alergias) {
		this.alergias = alergias;
	}
	
	public int getnBebidas() {
		return nBebidas;
	}

	public void setnBebidas(int nBebidas) {
		this.nBebidas = nBebidas;
	}
	
	public String mostrarResumen(){
		String pedido = "Resumiendo, el pedido es el siguiente:";
		double precioFinal = 0;
		for(int i = 0; i < pizzas.size(); i++){
			pedido = pedido + pizzas.get(i).toString();
			precioFinal += pizzas.get(i).getPrecio();
		}
		pedido += "\n" + "Precio total: ------------------------------------ " + precioFinal + " € ";
		return pedido;
	}
	
	public void anadirBebida(String bebida) {
		this.bebidas.add(bebida);
	}
	
	/*
	 * java.util.Date utilDate = new java.util.Date();
	 * java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	 */
	
}
