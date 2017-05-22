package icaro.aplicaciones.informacion.gestionPizzeria;
import java.util.List;

import icaro.aplicaciones.informacion.gestionPizzeria.Pizza.MasaPizza;
import icaro.aplicaciones.informacion.gestionPizzeria.Pizza.TamanioPizza;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Pedido {
	
	public enum MetodoPago{
		tarjeta("tarjeta"), efectivo("efectivo");
		
		 private final String metodo;       

		    private MetodoPago(String s) {
		        metodo = s;
		    }

		    public String toString() {
		       return this.metodo;
		    }
		
	}
	
	
	private Usuario usuario;
	private ArrayList<Pizza> pizzas;
	private List<String> bebidas ;
	private MetodoPago metodoPago;
	private int cambioEfectivo;
	private Date fechaEntrega;
	public boolean tieneAlergia;
	private List<Ingrediente> alergias;
	private int nBebidas;
	public int numeroPizzas;
	public int numeroTotalPizzas;
	
	public Pedido(){
		nBebidas=0;
		pizzas = new ArrayList<Pizza>();
		bebidas = new ArrayList<String>();
		/*ArrayList<Ingrediente> ingredientes  = new ArrayList<String>(Arrays.asList("Quesos ", "Bacon", "Champiñón", "Cebolla"));
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
		pizzas.add(pizza1);*/
	}
	
	public Pedido pedidoPrueba(){
		Pedido p = new Pedido();
		
		Usuario u = new Usuario();
		u.setUsername("bea");
		p.setUsuario(u);
		
		nBebidas=0;
		pizzas = new ArrayList<Pizza>();
		bebidas = new ArrayList<String>();
		ArrayList<Ingrediente> ingredientes  = new ArrayList<Ingrediente>();
		ingredientes.add(new Ingrediente("pollo"));
		ingredientes.add(new Ingrediente("ternera"));
		ingredientes.add(new Ingrediente("bacon"));
		Pizza pizza = new Pizza();
		pizza.setNombrePizza("carbonara");
		pizza.setSalsa("botzzaroni");
		pizza.setMasa(MasaPizza.normal);
		pizza.setTamanio(TamanioPizza.familiar);
		pizza.setPrecio(10.0);
		pizza.setIngredientes(ingredientes);
		pizza.setPersonalizada(false);
		pizzas.add(pizza);
		
		Pizza pizza1 = new Pizza();
		ArrayList<Ingrediente> ingredientes1  = new ArrayList<Ingrediente>();
		ingredientes.add(new Ingrediente("york"));
		ingredientes.add(new Ingrediente("ternera"));
		ingredientes.add(new Ingrediente("pollo"));
		pizza1.setNombrePizza("barbacoa");
		pizza1.setSalsa("botzzaroni");
		pizza1.setMasa(MasaPizza.fina);
		pizza1.setTamanio(TamanioPizza.mediana);
		pizza1.setPrecio(7.0);
		pizza1.setIngredientes(ingredientes1);
		pizza1.setPersonalizada(false);
		pizzas.add(pizza1);
		
		Pizza pizza2 = new Pizza();
		ArrayList<Ingrediente> ingredientes2  = new ArrayList<Ingrediente>();
		ingredientes.add(new Ingrediente("york"));
		ingredientes.add(new Ingrediente("queso azul"));
		ingredientes.add(new Ingrediente("queso provolone"));
		pizza2.setNombrePizza("topeguay");
		pizza2.setSalsa("diabola");
		pizza2.setMasa(MasaPizza.normal);
		pizza2.setTamanio(TamanioPizza.pequenia);
		pizza2.setPrecio(12.0);
		pizza2.setIngredientes(ingredientes2);
		pizza2.setPersonalizada(true);
		pizza2.setUsuarioCreador(u);
		pizzas.add(pizza2);
		
		
		Date d = new Date();
		p.setFechaEntrega(d);
		p.setMetodoPago(MetodoPago.tarjeta);
		p.setCambioEfectivo(0);
		p.tieneAlergia = true;
		List<Ingrediente> aler = new ArrayList<Ingrediente>();
		aler.add(new Ingrediente("cebolla"));
		aler.add(new Ingrediente("oregano"));
		p.alergias = aler;
		
		bebidas.add("cocacola");
		bebidas.add("nestea");
		bebidas.add("cerveza");
		
		p.setBebidas(bebidas);
		p.setPizzas(pizzas);
		return p;
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
	
	public void addPizza(Pizza p){
		this.pizzas.add(p);
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

	@Override
	public String toString() {
		return "Pedido [usuario=" + usuario + ", pizzas=" + pizzas + ", bebidas=" + bebidas + ", metodoPago="
				+ metodoPago + ", cambioEfectivo=" + cambioEfectivo + ", fechaEntrega=" + fechaEntrega
				+ ", tieneAlergia=" + tieneAlergia + ", alergias=" + alergias + ", nBebidas=" + nBebidas
				+ ", numeroPizzas=" + numeroPizzas + ", numeroTotalPizzas=" + numeroTotalPizzas + "]";
	}
	
	
	
	/*
	 * java.util.Date utilDate = new java.util.Date();
	 * java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	 */
	
}
