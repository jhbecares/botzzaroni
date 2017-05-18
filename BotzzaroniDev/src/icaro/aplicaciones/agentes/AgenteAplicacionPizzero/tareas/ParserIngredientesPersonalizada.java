package icaro.aplicaciones.agentes.AgenteAplicacionPizzero.tareas;

import icaro.aplicaciones.informacion.gestionPizzeria.Pedido;
import icaro.aplicaciones.informacion.gestionPizzeria.Pizza;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;

public class ParserIngredientesPersonalizada extends TareaSincrona{

	public ParserIngredientesPersonalizada() {
		// TODO Auto-generated constructor stub
	}
public void ejecutar(Object... params) {
		
		String msgg = (String)params[0];
		Pizza pizza = (Pizza) params[1];
		String[] a = msgg.split("-");
	 	for(int i = 0; i < a.length; i++){
	 		String msgg2 = a[i];
	 		if(msgg2.equalsIgnoreCase("kitkat") || msgg2.equalsIgnoreCase("Kit Kat")){
	 			pizza.addIngrediente("Kitkat");
	    	}else if(msgg2.equalsIgnoreCase("cebolla")){
	    		pizza.addIngrediente("Cebolla");
	    	}else if(msgg2.equalsIgnoreCase("bacon") || msgg2.equalsIgnoreCase("Bacón")){
	    		pizza.addIngrediente("Bacon");
	    	}else if(msgg2.equalsIgnoreCase("pollo")){
	    		pizza.addIngrediente("Pollo");
	    	}else if(msgg2.equalsIgnoreCase("ternera")){
	    		pizza.addIngrediente("Ternera");
	    	}else if(msgg2.equalsIgnoreCase("bacon crispy")){
	    		pizza.addIngrediente("Bacon crispy");
	    	}else if(msgg2.equalsIgnoreCase("jamon serrano")|| msgg2.equalsIgnoreCase("jamón serrano")){
	    		pizza.addIngrediente("Jamon Serrano");
	    	}else if(msgg2.equalsIgnoreCase("champiñon")|| msgg2.equalsIgnoreCase("champiñón")||msgg2.equalsIgnoreCase("champiñónes")||msgg2.equalsIgnoreCase("champis")){
	    		pizza.addIngrediente("Champiñon");
	    	}else if(msgg2.equalsIgnoreCase("Topping a base de mozzarella")|| msgg2.equalsIgnoreCase("topping de mozzarella")){
	    		pizza.addIngrediente("Topping a base de mozzarella");
	    	}else if(msgg2.equalsIgnoreCase("Queso cheddar")|| msgg2.equalsIgnoreCase("queso chedar")){
	    		pizza.addIngrediente("Queso cheddar");
	    	}else if(msgg2.equalsIgnoreCase("Queso emmental")|| msgg2.equalsIgnoreCase("queso emental")){
	    		pizza.addIngrediente("Queso emmental");
	    	}else if(msgg2.equalsIgnoreCase("queso edam")){
	    		pizza.addIngrediente("Queso edam");
	    	}else if(msgg2.equalsIgnoreCase("queso provolone")){
	    		pizza.addIngrediente("Queso provolone");
	    	}else if(msgg2.equalsIgnoreCase("queso azul")){
	    		pizza.addIngrediente("Queso azul");
	    	}else if(msgg2.equalsIgnoreCase("york")){
	    		pizza.addIngrediente("York");
	    	}else if(msgg2.equalsIgnoreCase("piña")){
	    		pizza.addIngrediente("Piña");
	    	}else if(msgg2.equalsIgnoreCase("tomate natural")|| msgg2.equalsIgnoreCase("tomate")){
	    		pizza.addIngrediente("Tomate natural");
	    	}else if(msgg2.equalsIgnoreCase("tomate confitado")){
	    		pizza.addIngrediente("Tomate confitado");
	    	}else if(msgg2.equalsIgnoreCase("oregano")|| msgg2.equalsIgnoreCase("orégano")){
	    		pizza.addIngrediente("Oregano");
	    	}else if(msgg2.equalsIgnoreCase("crema de cacao y avellanas")|| msgg2.equalsIgnoreCase("nocilla")){
	    		pizza.addIngrediente("Crema de cacao y avellanas");
	    	}
	 	}
	 	this.getEnvioHechos().actualizarHecho(pizza);
		
	}
}
