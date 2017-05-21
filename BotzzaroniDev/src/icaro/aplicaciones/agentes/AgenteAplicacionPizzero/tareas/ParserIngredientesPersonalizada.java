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
	 			pizza.addIngrediente("kitkat");
	    	}else if(msgg2.equalsIgnoreCase("cebolla")){
	    		pizza.addIngrediente("cebolla");
	    	}else if(msgg2.equalsIgnoreCase("bacon") || msgg2.equalsIgnoreCase("Bacón")){
	    		pizza.addIngrediente("bacon");
	    	}else if(msgg2.equalsIgnoreCase("pollo")){
	    		pizza.addIngrediente("pollo");
	    	}else if(msgg2.equalsIgnoreCase("ternera")){
	    		pizza.addIngrediente("ternera");
	    	}else if(msgg2.equalsIgnoreCase("bacon crispy")){
	    		pizza.addIngrediente("bacon crispy");
	    	}else if(msgg2.equalsIgnoreCase("jamon serrano")|| msgg2.equalsIgnoreCase("jamón serrano")){
	    		pizza.addIngrediente("kamon Serrano");
	    	}else if(msgg2.equalsIgnoreCase("champiñon")|| msgg2.equalsIgnoreCase("champiñón")||msgg2.equalsIgnoreCase("champiñónes")||msgg2.equalsIgnoreCase("champis")){
	    		pizza.addIngrediente("champiñon");
	    	}else if(msgg2.equalsIgnoreCase("Topping a base de mozzarella")|| msgg2.equalsIgnoreCase("topping de mozzarella")){
	    		pizza.addIngrediente("topping a base de mozzarella");
	    	}else if(msgg2.equalsIgnoreCase("Queso cheddar")|| msgg2.equalsIgnoreCase("queso chedar")){
	    		pizza.addIngrediente("queso cheddar");
	    	}else if(msgg2.equalsIgnoreCase("Queso emmental")|| msgg2.equalsIgnoreCase("queso emental")){
	    		pizza.addIngrediente("queso emmental");
	    	}else if(msgg2.equalsIgnoreCase("queso edam")){
	    		pizza.addIngrediente("queso edam");
	    	}else if(msgg2.equalsIgnoreCase("queso provolone")){
	    		pizza.addIngrediente("queso provolone");
	    	}else if(msgg2.equalsIgnoreCase("queso azul")){
	    		pizza.addIngrediente("Queso azul");
	    	}else if(msgg2.equalsIgnoreCase("york")){
	    		pizza.addIngrediente("york");
	    	}else if(msgg2.equalsIgnoreCase("piña")){
	    		pizza.addIngrediente("piña");
	    	}else if(msgg2.equalsIgnoreCase("tomate natural")|| msgg2.equalsIgnoreCase("tomate")){
	    		pizza.addIngrediente("tomate natural");
	    	}else if(msgg2.equalsIgnoreCase("tomate confitado")){
	    		pizza.addIngrediente("tomate confitado");
	    	}else if(msgg2.equalsIgnoreCase("oregano")|| msgg2.equalsIgnoreCase("orégano")){
	    		pizza.addIngrediente("oregano");
	    	}else if(msgg2.equalsIgnoreCase("crema de cacao y avellanas")|| msgg2.equalsIgnoreCase("nocilla")){
	    		pizza.addIngrediente("crema de cacao y avellanas");
	    	}
	 	}
	 	this.getEnvioHechos().actualizarHecho(pizza);
		
	}
}
