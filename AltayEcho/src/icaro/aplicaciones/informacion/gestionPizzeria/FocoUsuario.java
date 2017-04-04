package icaro.aplicaciones.informacion.gestionPizzeria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.MisObjetivos;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;
import icaro.infraestructura.recursosOrganizacion.recursoTrazas.ItfUsoRecursoTrazas;
import icaro.infraestructura.recursosOrganizacion.recursoTrazas.imp.componentes.InfoTraza;

public class FocoUsuario {
	
	protected String username;

	protected List<Objetivo> listaObjetivos = new ArrayList<Objetivo>();

	protected Objetivo foco;

	protected Objetivo[] focosAnteriores = null;
	
	public int intentos;
	/**
	 * Tamao maximo de la cola circular
	 */
	protected final static int TAM_COLA_FOCOS = 5;
	/**
	 * Indice de la cola circular
	 */
	public String getUsername(){
		return username;
	}
	
	public FocoUsuario(String username){
		this.username = username;
		this.focosAnteriores = new Objetivo[TAM_COLA_FOCOS];
		Arrays.fill(this.focosAnteriores, null);
		this.indice = 0;
		objetivoFocalizado = null;
		intentos =0;
	}
	
	protected int indice = 0;
	protected Objetivo objetivoFocalizado;

	protected ItfUsoRecursoTrazas trazas = NombresPredefinidos.RECURSO_TRAZAS_OBJ;

	public Objetivo getFoco() {
		return this.foco;
	}

	public Objetivo getFocoAnterior() {
		return this.focosAnteriores[((TAM_COLA_FOCOS + this.indice) - 1)
				% TAM_COLA_FOCOS];
	}

	public void refocus() {
		this.indice = ((TAM_COLA_FOCOS + this.indice) - 1) % TAM_COLA_FOCOS;
		this.foco = this.focosAnteriores[this.indice];
		trazas.aceptaNuevaTraza(new InfoTraza("",
				"Foco: Focalizando el objetivo " + foco.getgoalId(),
				InfoTraza.NivelTraza.debug));

	}

	public void refocusYCambiaAPending() {
		this.indice = ((TAM_COLA_FOCOS + this.indice) - 1) % TAM_COLA_FOCOS;
		this.foco = this.focosAnteriores[this.indice];
		this.foco.setPending();
		trazas.aceptaNuevaTraza(new InfoTraza("",
				"Foco: Focalizando el objetivo " + foco.getgoalId(),
				InfoTraza.NivelTraza.debug));
	}

	public void setFocusToObjetivoMasPrioritario(MisObjetivos misObjs) {
		Objetivo obj = misObjs.getobjetivoMasPrioritario();
		if (obj == null) {
			this.foco = null;
		} else if (obj != this.foco) {

			this.foco = obj;

			this.indice = (this.indice + 1) % TAM_COLA_FOCOS;
			this.focosAnteriores[indice] = obj;

		}
	}

	public void setFoco(Objetivo obj) {
		if (obj == null) {
			this.foco = null;
		} else {
			int posobjetivos = 0;
			String claseobjetivo = obj.getClass().getName();
			posobjetivos = claseobjetivo.indexOf("objetivos");
			claseobjetivo = claseobjetivo.substring(posobjetivos);
			
			// Introduce el foco nuevo en la cola, siempre que no fuera el mismo
			// objetivo que el anterior
			if (obj != this.foco) {
				if (foco != null) {
					foco.setisfocused(false);
				}
				this.foco = obj;
				obj.setisfocused(true);
				this.focosAnteriores[indice] = obj;
				this.indice = (this.indice + 1) % TAM_COLA_FOCOS;

			}
		}
	}
}
