///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package icaro.aplicaciones.agentes.AgenteAplicacionDialogoQuedadas.tareas;
//
//import icaro.aplicaciones.informacion.gestionQuedadas.Quedada;
//import icaro.aplicaciones.informacion.gestionQuedadas.VocabularioGestionQuedadas;
//import icaro.aplicaciones.recursos.persistenciaQuedadas.ItfPersistenciaQuedadas;
//import icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
//import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.CausaTerminacionTarea;
//import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Objetivo;
//import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaSincrona;
//
///**
// *
// * @author SONIAGroup
// */
//public class AlmacenarQuedada extends TareaSincrona {
//	private Objetivo contextoEjecucionTarea = null;
//
//	@Override
//	public void ejecutar(Object... params) {
//
//		String identDeEstaTarea = this.getIdentTarea();
//		String identAgenteOrdenante = this.getIdentAgente();
//		Quedada que = (Quedada) params[0];
//		try {
//
//			// // Se busca la interfaz del recurso en el repositorio de
//			// interfaces
//			ItfPersistenciaQuedadas persistencia = (ItfPersistenciaQuedadas) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ
//					.obtenerInterfazUso(VocabularioGestionQuedadas.IdentRecursoPersistenciaQuedadas);
//			persistencia.insertarQuedada(que);
//		
//
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
