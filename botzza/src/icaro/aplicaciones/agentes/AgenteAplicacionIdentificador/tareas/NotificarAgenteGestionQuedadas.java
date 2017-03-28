//package icaro.aplicaciones.agentes.AgenteAplicacionIdentificador.tareas;
//
//import icaro.aplicaciones.informacion.gestionQuedadas.NotificacionIdentificado;
//import icaro.aplicaciones.informacion.gestionQuedadas.Quedada;
//import icaro.aplicaciones.informacion.gestionQuedadas.VocabularioGestionQuedadas;
//import icaro.aplicaciones.recursos.persistenciaQuedadas.ItfPersistenciaQuedadas;
//import icaro.aplicaciones.agentes.AgenteAplicacionIdentificador.objetivos.RedireccionarNotifAgenteDialogoQuedadas;
//import icaro.aplicaciones.agentes.AgenteAplicacionIdentificador.objetivos.RedireccionarNotifAgenteGestionQuedadas;
//import icaro.aplicaciones.informacion.gestionQuedadas.Grupo;
//import icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
//import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;
//import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaComunicacion;
//
///**
// *
// * @author Jorge Casas Hernan
// */
//public class NotificarAgenteGestionQuedadas extends TareaComunicacion {
//
//	@Override
//	public void ejecutar(Object... params) {
//
//		this.getIdentTarea();
//		this.getIdentAgente();
//		String identInterlocutor    = (String) params[0];
//		Grupo gr = (Grupo) params[1];
//		try {
//			ItfPersistenciaQuedadas persistencia = (ItfPersistenciaQuedadas) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ.obtenerInterfazUso(VocabularioGestionQuedadas.IdentRecursoPersistenciaQuedadas);
//			Quedada quedada = persistencia.obtenerQuedadaDeGrupo(gr.getId());
//			quedada.idChat = identInterlocutor;
//			NotificacionIdentificado ngri = new NotificacionIdentificado(identInterlocutor, gr, quedada);
//			ngri.setTipoNotificacion("NOINFO");
//			this.informaraOtroAgente(ngri, VocabularioGestionQuedadas.IdentAgenteAplicacionGestionQuedadas);
//		
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}
