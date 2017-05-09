/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package icaro.infraestructura.recursosOrganizacion.comunicacionesOrganizacion.imp.RMI;

/**
 *
 * @author FGarijo
 */
import icaro.infraestructura.entidadesBasicas.comunicacion.MensajeSimple;
import icaro.infraestructura.recursosOrganizacion.comunicacionesOrganizacion.imp.ClaseGeneradoraComunicacionesOrganizacion;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class ComunicacionesOrganizacionRMI extends
		ClaseGeneradoraComunicacionesOrganizacion {
	/**
	 *
	 Esta clase se encarga de arrancar el registro RMI y de implementar las
	 * operaciones de mensajería Con dos clases separadas para poserlas manejar
	 * más facilmente
	 */

	public ComunicacionesOrganizacionRMI() throws RemoteException {
		super("ComunicacionesOrganizacionRMI");
		ControlRMI.startRMI();

	}

	@Override
	public void enviarMensaje(MensajeSimple mensaje) {
	}

	/**
	 * Crea el mensaje añade el contenido y lo envia al receptor
	 *
	 * @param contenido
	 * @param identAgenteReceptor
	 */
	@Override
	public void mandarInfoAAgenteId(Object contenido, String identAgenteReceptor) {
	}

	/**
	 *
	 * @param mensaje
	 * @param nombresAgentes
	 */
	@Override
	public void mandarMensajeaGrupoAgentes(MensajeSimple mensaje,
			ArrayList<String> nombresAgentes) {

	}

	/**
	 *
	 * @param infoaEnviar
	 * @param grupoDestinatarios
	 */
	@Override
	public void mandarInfoaGrupoAgentes(Object infoaEnviar,
			ArrayList<String> grupoDestinatarios) {

	}

	@Override
	public void termina() {

	}

}
