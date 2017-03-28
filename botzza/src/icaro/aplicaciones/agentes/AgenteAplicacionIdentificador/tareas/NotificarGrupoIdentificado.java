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
// * @author SONIAGroup
// */
//public class NotificarGrupoIdentificado extends TareaComunicacion {
//
//	@Override
//	public void ejecutar(Object... params) {
//
//		this.getIdentTarea();
//		this.getIdentAgente();
//		String identInterlocutor    = (String) params[0];
//		Grupo gr = (Grupo) params[1];
//		try {
//			NotificacionIdentificado ngri = null;
//			Objetivo ob = null;
//			ItfPersistenciaQuedadas persistencia = (ItfPersistenciaQuedadas) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ.obtenerInterfazUso(VocabularioGestionQuedadas.IdentRecursoPersistenciaQuedadas);
//			Quedada quedada = persistencia.obtenerQuedadaDeGrupo(gr.getId());
//			
//			if (quedada == null) {
//				ngri = new NotificacionIdentificado(identInterlocutor, gr);
//				this.informaraOtroAgente(ngri, VocabularioGestionQuedadas.IdentAgenteAplicacionDialogoQuedadas);
//				ob = new RedireccionarNotifAgenteDialogoQuedadas();
//			}
//			else {
//				quedada.idChat = identInterlocutor;
//				ngri = new NotificacionIdentificado(identInterlocutor, gr, quedada);
//				ngri.setTipoNotificacion("INFO");
//				this.informaraOtroAgente(ngri, VocabularioGestionQuedadas.IdentAgenteAplicacionGestionQuedadas);
//				ob = new RedireccionarNotifAgenteGestionQuedadas();
//			}
//			ob.setobjectReferenceId(identInterlocutor);
//			this.getEnvioHechos().insertarHechoWithoutFireRules(ob);
//		
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}
