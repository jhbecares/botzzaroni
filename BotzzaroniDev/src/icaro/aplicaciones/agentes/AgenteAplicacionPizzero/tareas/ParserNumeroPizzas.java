package icaro.aplicaciones.agentes.AgenteAplicacionPizzero.tareas;

import icaro.aplicaciones.informacion.gestionPizzeria.Pedido;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;

public class ParserNumeroPizzas extends TareaSincrona{

	public ParserNumeroPizzas() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ejecutar(Object... params) {
		String msgg = (String) params[0];
		Pedido p = (Pedido) params[1];
		if (msgg.equalsIgnoreCase("uno")) msgg = "1";
	 	else if (msgg.equalsIgnoreCase("una")) msgg = "1";
	 	else if (msgg.equalsIgnoreCase("dos")) msgg = "2";
		else if (msgg.equalsIgnoreCase("tres")) msgg = "3";
		else if (msgg.equalsIgnoreCase("cuatro")) msgg = "4";
		else if (msgg.equalsIgnoreCase("cinco")) msgg = "5";
		else if (msgg.equalsIgnoreCase("seis")) msgg = "6";
		else if (msgg.equalsIgnoreCase("siete")) msgg = "7";
		else if (msgg.equalsIgnoreCase("ocho")) msgg = "8";
		else if (msgg.equalsIgnoreCase("nueve")) msgg = "9";
		else if (msgg.equalsIgnoreCase("diez")) msgg = "10";
		else if (msgg.equalsIgnoreCase("once")) msgg = "11";
		else if (msgg.equalsIgnoreCase("doce")) msgg = "12";
		else if (msgg.equalsIgnoreCase("trece")) msgg = "13";
		else if (msgg.equalsIgnoreCase("catorce")) msgg = "14";
		else if (msgg.equalsIgnoreCase("quince")) msgg = "15";
		else if (msgg.equalsIgnoreCase("deiciseis")) msgg = "16";
		else if (msgg.equalsIgnoreCase("diecisite")) msgg = "17";
		else if (msgg.equalsIgnoreCase("dieciocho")) msgg = "18";
		else if (msgg.equalsIgnoreCase("diecinueve")) msgg = "19";
		else if (msgg.equalsIgnoreCase("veinte"))  msgg = "20";
	 	
	 	p.numeroPizzas = Integer.parseInt(msgg);
	 	p.numeroTotalPizzas = 1;
	 	System.out.println("**********************" + p.numeroPizzas);
	 	this.getEnvioHechos().actualizarHecho(p);
		
	}

}
