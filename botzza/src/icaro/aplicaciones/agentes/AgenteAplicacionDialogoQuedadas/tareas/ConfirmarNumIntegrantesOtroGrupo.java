///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package icaro.aplicaciones.agentes.AgenteAplicacionDialogoQuedadas.tareas;
//
//import icaro.aplicaciones.informacion.gestionQuedadas.VocabularioGestionQuedadas;
//import icaro.aplicaciones.recursos.comunicacionChat.ItfUsoComunicacionChat;
//import icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
//import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.CausaTerminacionTarea;
//import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;
//import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;
//
///**
// * 
// * @author Mariano Hern�ndez Garc�a
// *
// */
//public class ConfirmarNumIntegrantesOtroGrupo extends TareaSincrona {
//	private Objetivo contextoEjecucionTarea = null;
//
//	@Override
//	public void ejecutar(Object... params) {
//
//		String identDeEstaTarea 	= this.getIdentTarea();
//		String identAgenteOrdenante = this.getIdentAgente();
//		String identInterlocutor 	= (String) params[0];
//		int numIntegrantes 			= (int) params[1];
//		
//		try {
//			
//			ItfUsoComunicacionChat recComunicacionChat = (ItfUsoComunicacionChat) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ
//					.obtenerInterfazUso(VocabularioGestionQuedadas.IdentRecursoComunicacionChat);
//			
//			if (recComunicacionChat != null) {
//				recComunicacionChat.comenzar(identAgenteOrdenante);
//				
//				String mensajeAenviar = null;
//				
//				
//				if ( numIntegrantes == -1 )
//					mensajeAenviar = "Entendido. No os importa el número de integrantes del otro grupo";
//				
//				else if ( numIntegrantes > 0 )
//					
//					if ( numIntegrantes == 1)
//						mensajeAenviar = "¿Sólo queréis quedar con una persona? Interesante.. ;)";
//					else
//						mensajeAenviar = "Entendido. El otro grupo deberá tener  " + numIntegrantes + " personas";
//					
//				recComunicacionChat.enviarMensagePrivado(identInterlocutor,mensajeAenviar);
//
//			} 
//			else {
//				identAgenteOrdenante = this.getAgente().getIdentAgente();
//				this.generarInformeConCausaTerminacion(
//						identDeEstaTarea,
//						contextoEjecucionTarea,
//						identAgenteOrdenante,
//						"Error-AlObtener:Interfaz:"
//								+ VocabularioGestionQuedadas.IdentRecursoComunicacionChat,
//						CausaTerminacionTarea.ERROR);
//			}
//		} catch (Exception e) {
//			this.generarInformeConCausaTerminacion(
//					identDeEstaTarea,
//					contextoEjecucionTarea,
//					identAgenteOrdenante,
//					"Error-Acceso:Interfaz:"
//							+ VocabularioGestionQuedadas.IdentRecursoComunicacionChat,
//					CausaTerminacionTarea.ERROR);
//			e.printStackTrace();
//		}
//	}
//
//}
