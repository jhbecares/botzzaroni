package icaro.aplicaciones.agentes.AgenteAplicacionPizzero.tareas;

import icaro.aplicaciones.agentes.AgenteAplicacionContexto.objetivos.SaludarConocer;
import icaro.aplicaciones.informacion.gestionPizzeria.Pizza;
import icaro.aplicaciones.informacion.gestionPizzeria.Usuario;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;

public class AniadirSalsaPizza extends TareaSincrona {
	private Objetivo contextoEjecucionTarea = null;


	@Override
	public void ejecutar(Object... params) {
		String identDeEstaTarea = this.getIdentTarea();
		String identAgenteOrdenante = this.getIdentAgente();
		Pizza pizza = (Pizza) params[0];
		String salsa = (String) params[1];
		pizza.setSalsa(salsa);
		this.getEnvioHechos().actualizarHecho(pizza);
	}

}
