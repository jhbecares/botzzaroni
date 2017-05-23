package icaro.aplicaciones.agentes.AgenteAplicacionPizzero.tareas;

import icaro.aplicaciones.informacion.gestionPizzeria.Pedido;
import icaro.aplicaciones.informacion.gestionPizzeria.Pizza;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;

public class ParserIngredientesAlergia extends TareaSincrona{

	public ParserIngredientesAlergia() {
		// TODO Auto-generated constructor stub
	}
	private Objetivo contextoEjecucionTarea = null;

	@Override
	public void ejecutar(Object... params) {
		
		String msgg = (String)params[0];
		Pedido p = (Pedido) params[1];
		String[] a = msgg.split("-");
	 	for(int i = 0; i < a.length; i++){
	 		System.out.println("-------------------------------" + a[i]);
	 		String msgg2 = a[i];
	 		if(msgg2.equalsIgnoreCase("kitkat") || msgg2.equalsIgnoreCase("Kit Kat")){
	    		p.addAlergia("Kitkat");
	    	}else if(msgg2.equalsIgnoreCase("cebolla")){
	    		p.addAlergia("Cebolla");
	    	}else if(msgg2.equalsIgnoreCase("bacon") || msgg2.equalsIgnoreCase("Bacón")){
	    		p.addAlergia("Bacon");
	    	}else if(msgg2.equalsIgnoreCase("pollo")){
	    		p.addAlergia("Pollo");
	    	}else if(msgg2.equalsIgnoreCase("ternera")){
	    		p.addAlergia("Ternera");
	    	}else if(msgg2.equalsIgnoreCase("bacon crispy")){
	    		p.addAlergia("Bacon crispy");
	    	}else if(msgg2.equalsIgnoreCase("jamon serrano")|| msgg2.equalsIgnoreCase("jamón serrano")){
	    		p.addAlergia("Jamon serrano");
	    	}else if(msgg2.equalsIgnoreCase("champiñon")|| msgg2.equalsIgnoreCase("champiñón")||msgg2.equalsIgnoreCase("champiñónes")||msgg2.equalsIgnoreCase("champis")){
	    		p.addAlergia("Champiñon");
	    	}else if(msgg2.equalsIgnoreCase("Topping a base de mozzarella")|| msgg2.equalsIgnoreCase("topping de mozzarella")){
	    		p.addAlergia("Topping a base de mozzarella");
	    	}else if(msgg2.equalsIgnoreCase("Queso cheddar")|| msgg2.equalsIgnoreCase("queso chedar")){
	    		p.addAlergia("Queso cheddar");
	    	}else if(msgg2.equalsIgnoreCase("Queso emmental")|| msgg2.equalsIgnoreCase("queso emental")){
	    		p.addAlergia("Queso emmental");
	    	}else if(msgg2.equalsIgnoreCase("queso edam")){
	    		p.addAlergia("queso edam");
	    	}else if(msgg2.equalsIgnoreCase("queso provolone")){
	    		p.addAlergia("queso provolone");
	    	}else if(msgg2.equalsIgnoreCase("queso azul")){
	    		p.addAlergia("queso azul");
	    	}else if(msgg2.equalsIgnoreCase("york")){
	    		p.addAlergia("york");
	    	}else if(msgg2.equalsIgnoreCase("piña")){
	    		p.addAlergia("piña");
	    	}else if(msgg2.equalsIgnoreCase("tomate natural")|| msgg2.equalsIgnoreCase("tomate")){
	    		p.addAlergia("tomate natural");
	    	}else if(msgg2.equalsIgnoreCase("tomate confitado")){
	    		p.addAlergia("tomate confitado");
	    	}else if(msgg2.equalsIgnoreCase("oregano")|| msgg2.equalsIgnoreCase("orégano")){
	    		p.addAlergia("oregano");
	    	}else if(msgg2.equalsIgnoreCase("crema de cacao y avellanas")|| msgg2.equalsIgnoreCase("nocilla")){
	    		p.addAlergia("crema de cacao y avellanas");
	    	}
	 	}
	 	this.getEnvioHechos().actualizarHecho(p);
		
	}
}
