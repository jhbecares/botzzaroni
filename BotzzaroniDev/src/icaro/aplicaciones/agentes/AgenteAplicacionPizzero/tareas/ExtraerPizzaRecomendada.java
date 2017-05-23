package icaro.aplicaciones.agentes.AgenteAplicacionPizzero.tareas;

import java.util.ArrayList;

import icaro.aplicaciones.informacion.gestionPizzeria.Pedido;
import icaro.aplicaciones.informacion.gestionPizzeria.Pizza;
import icaro.aplicaciones.informacion.gestionPizzeria.Pizza.TamanioPizza;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;

public class ExtraerPizzaRecomendada extends TareaSincrona{

	@Override
	public void ejecutar(Object... params) {
		String msgg = (String)params[0];
		ArrayList<Pizza> array = (ArrayList<Pizza>) params[1];
		Pizza pizza = (Pizza) params[2];
		boolean pizzaCorrecta = false;
	 	for(int i = 0; i < array.size(); i++){
	 		if(array.get(i).getNombrePizza().equalsIgnoreCase(msgg)){
	 			pizza = array.get(i);
	 			pizzaCorrecta = true;
	 		}
	 	}
	 	
	 	if (!pizzaCorrecta){
	 		pizza.setNombrePizza("prueba");
	 		pizza.setTamanio(TamanioPizza.familiar);
	 	}
	 	
	 	this.getEnvioHechos().actualizarHecho(pizza);	
	}

}
