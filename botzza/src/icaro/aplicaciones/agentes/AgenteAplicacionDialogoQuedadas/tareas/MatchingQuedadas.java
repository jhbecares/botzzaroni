///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package icaro.aplicaciones.agentes.AgenteAplicacionDialogoQuedadas.tareas;
//
//import java.util.ArrayList;
//import java.util.Calendar;
//
//import icaro.aplicaciones.agentes.AgenteAplicacionDialogoQuedadas.objetivos.GuardarQuedadaIncompleta;
//import icaro.aplicaciones.agentes.AgenteAplicacionDialogoQuedadas.objetivos.ObtenerConfirmacionMatchingCuandoFunciona;
//import icaro.aplicaciones.agentes.AgenteAplicacionDialogoQuedadas.tools.ConversacionGrupo;
//import icaro.aplicaciones.informacion.gestionQuedadas.FocoGrupo;
//import icaro.aplicaciones.informacion.gestionQuedadas.Grupo;
//import icaro.aplicaciones.informacion.gestionQuedadas.Quedada;
//import icaro.aplicaciones.informacion.gestionQuedadas.TiposQuedada;
//import icaro.aplicaciones.informacion.gestionQuedadas.VocabularioGestionQuedadas;
//import icaro.aplicaciones.recursos.comunicacionChat.ItfUsoComunicacionChat;
//import icaro.aplicaciones.recursos.persistenciaQuedadas.ItfPersistenciaQuedadas;
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
//public class MatchingQuedadas extends TareaSincrona {
//	private Objetivo contextoEjecucionTarea = null;
//
//	@Override
//	public void ejecutar(Object... params) {
//
//		String identDeEstaTarea 	= this.getIdentTarea();
//		String identAgenteOrdenante = this.getIdentAgente();
//		String identInterlocutor 	= (String) params[0];
//		Quedada quedada 			= (Quedada) params[1];
//		FocoGrupo foco				= (FocoGrupo) params[2];
//		
//		try {
//			
//			ItfUsoComunicacionChat recComunicacionChat = (ItfUsoComunicacionChat) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ
//					.obtenerInterfazUso(VocabularioGestionQuedadas.IdentRecursoComunicacionChat);
//			
//			ItfPersistenciaQuedadas persistencia = (ItfPersistenciaQuedadas) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ
//					.obtenerInterfazUso(VocabularioGestionQuedadas.IdentRecursoPersistenciaQuedadas);
//			
//			if ( recComunicacionChat != null && persistencia != null ) {
//				recComunicacionChat.comenzar(identAgenteOrdenante);
//				
//				String mensajeAenviar = null;
//				
//				recComunicacionChat.enviarMensagePrivado(identInterlocutor, ConversacionGrupo.msg("confirmarQuedada"));
//				
//				ArrayList<Quedada> candidatas = persistencia.obtenerQuedadasSinGrupoQueAcepta();
//				
//				int a = 0;
//				int m = -1;
//				Quedada destino = null;
//				
//				for( Quedada q : candidatas ) {
//					a = afinidad(q, quedada);
//					if ( a > m ) {
//						m = a;
//						destino = q;
//					}
//				}
//				
//				// Si no se encuentra una quedada afin..
//				if ( m == -1 ) {
//					
//					// Mostramos los mensajes que informan sobre que no hay otro grupo para la quedada
//					// y para guardarla para un futuro
//					mensajeAenviar = ConversacionGrupo.msg("sinMatching");
//					Objetivo guardarQuedadaIncompleta = new GuardarQuedadaIncompleta();
//					guardarQuedadaIncompleta.setobjectReferenceId(identInterlocutor);
//					this.getEnvioHechos().insertarHechoWithoutFireRules(guardarQuedadaIncompleta);
//					
//					// Focalizamos en ese objetivo
//					foco.setFoco(guardarQuedadaIncompleta);
//					this.getEnvioHechos().actualizarHecho(foco);
//				}
//				else {
//					mensajeAenviar =  ConversacionGrupo.msg("conMatching") + " " + quedada.toString() + " " + ConversacionGrupo.msg("imperativoConfirmarQuedada");
//					
//					// Actualizamos la quedada
//					destino.setGrupoQueAcepta(quedada.getGrupoEmisor());
//					destino.idChat = identInterlocutor;
//					this.getEnvioHechos().eliminarHecho(quedada);
//					this.getEnvioHechos().insertarHecho(destino);
//					
//					// Creamos el objetivo
//					Objetivo obtenerConfirmacionMatching = new ObtenerConfirmacionMatchingCuandoFunciona();
//					obtenerConfirmacionMatching.setobjectReferenceId(identInterlocutor);
//					this.getEnvioHechos().insertarHechoWithoutFireRules(obtenerConfirmacionMatching);
//					
//					// Focalizamos en ese objetivo
//					foco.setFoco(obtenerConfirmacionMatching);
//					this.getEnvioHechos().actualizarHecho(foco);
//					
//				}
//				
//				recComunicacionChat.enviarMensagePrivado(identInterlocutor, mensajeAenviar);
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
//	
//	/**
//	 * Calcula y devuelve la afinidad existente entre dos quedadas.
//	 * 
//	 * @param Quedada q1
//	 * @param Quedada q2
//	 * @return afinidad (max. 80, min. -1)
//	 */
//	private int afinidad(Quedada q1, Quedada q2) {
//		
//		int a = 0;
//		
//		Calendar f1 = q1.getFecha();
//		Calendar f2 = q2.getFecha();
//		
//		Grupo g1 = q1.getGrupoEmisor();
//		Grupo g2 = q2.getGrupoEmisor();
//
//		boolean A = (q1.getNumIntegrantes() == -1 || q2.getNumIntegrantes() == -1) ||
//					(q1.getEdad() == -1 || q2.getEdad() == -1) ||
//					(q1.getSexo() == null || q2.getSexo() == null);
//		
///* Primero las condiciones que hacen que la afinidad sea la menor*/
//		
//		// Si las fechas no coinciden, la afinidad es la menor
//		if ( (f1.get(Calendar.DAY_OF_MONTH) != f2.get(Calendar.DAY_OF_MONTH)) ||
//			 (f1.get(Calendar.MONTH) != f2.get(Calendar.MONTH)) ||
//			 (f1.get(Calendar.YEAR) != f2.get(Calendar.YEAR)) ) {
//			
//			return -1;
//		}
//		
//		
//		// Si, en ambos sentidos,
//		// el numero de integrantes difiere en mas de 1 persona, 
//		// la edad difiere en mas de 2 a�os
//		// o el sexo no coincide
//		// las quedadas no son afines
//		
//		boolean B = (Math.abs(q1.getNumIntegrantes() - g2.getNumIntegrantes()) > 1) ||
//					(Math.abs(q1.getEdad() - g2.getEdad()) > 2) ||
//					(q1.getSexo() != g2.getSexo());
//		
//		boolean C = (Math.abs(q2.getNumIntegrantes() - g1.getNumIntegrantes()) > 1) ||
//					(Math.abs(q2.getEdad() - g1.getEdad()) > 2) ||
//					(q2.getSexo() != g1.getSexo());
//		
//		if ( !A && (B || C) ) {
//			return -1;
//		}
//		
//		
///* Se calcula la afinidad */
//		
//		// Si a alguno de los dos o a los dos no les importa los integrantes, edad y/o sexo
//		// del otro grupo, se suma 20
//		if ( A ) {
//			a += 20;
//		}
//		
//		
//		// Si las horas difieren en 10 min...
//		if ( ( Math.abs(f1.get(Calendar.HOUR_OF_DAY) - f2.get(Calendar.HOUR_OF_DAY)) < 2 ) && 
//				(Math.abs( f1.get(Calendar.MINUTE) - f2.get(Calendar.MINUTE) )  <= 10) ) {
//			
//			a += 20;
//		}
//		
//		// Si las horas difieren en 30 min..
//		else if ( ( Math.abs(f1.get(Calendar.HOUR_OF_DAY) - f2.get(Calendar.HOUR_OF_DAY)) < 2 ) && 
//				(Math.abs( f1.get(Calendar.MINUTE) - f2.get(Calendar.MINUTE) )  <= 30) ) {
//			
//			a += 10;
//		}
//		
//		
//		// Si lo que se quiere hacer en ambos planes coincide...
//		if ( q1.getQueHacer().equals(q2.getQueHacer()) ) {
//			a += 20;
//		}
//		// Si da igual alguno de lo que se quiere hacer...
//		else if ( q1.getQueHacer().equals(TiposQuedada.da_igual) || q2.getQueHacer().equals(TiposQuedada.da_igual) ) {
//			a += 10;
//		}
//		
//		// Si el lugar coincide...
//		if ( q1.getLugar().equals(q2.getLugar()) || q1.getLugar().contains(q2.getLugar()) ) {
//			a += 20;
//		}
//		else if ( q1.getLugar() == null || q2.getLugar() == null ) {
//			a += 15;
//		}
//		
//		
//		
//		return a;
//	}
//	
//
//}
