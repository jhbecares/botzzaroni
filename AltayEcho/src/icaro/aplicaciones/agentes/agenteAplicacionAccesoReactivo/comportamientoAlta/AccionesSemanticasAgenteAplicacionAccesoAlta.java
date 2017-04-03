package icaro.aplicaciones.agentes.agenteAplicacionAccesoReactivo.comportamientoAlta;


import icaro.aplicaciones.agentes.agenteAplicacionAccesoReactivo.comportamiento.*;
import icaro.aplicaciones.informacion.dominioClases.aplicacionAcceso.InfoAccesoSinValidar;
import icaro.aplicaciones.informacion.dominioClases.aplicacionAcceso.InfoAccesoValidada;
import icaro.aplicaciones.informacion.gestionQuedadas.Notificacion;
import icaro.aplicaciones.informacion.gestionQuedadas.VocabularioGestionQuedadas;
import icaro.aplicaciones.recursos.interfazChatUsuario.ItfUsoInterfazChatUsuario;
import icaro.aplicaciones.recursos.persistenciaAccesoBD.ItfUsoPersistenciaAccesoBD;
import icaro.aplicaciones.recursos.visualizacionAcceso.ItfUsoVisualizadorAcceso;
import icaro.aplicaciones.recursos.visualizacionAccesoAlta.ItfUsoVisualizadorAccesoAlta;
import icaro.infraestructura.entidadesBasicas.comunicacion.EventoRecAgte;
import icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
import icaro.infraestructura.entidadesBasicas.comunicacion.AdaptadorRegRMI;
import icaro.infraestructura.entidadesBasicas.comunicacion.InfoContMsgAgteReactivo;
import icaro.infraestructura.entidadesBasicas.comunicacion.InfoContEvtMsgAgteReactivo;
import icaro.infraestructura.entidadesBasicas.comunicacion.MensajeSimple;
import icaro.infraestructura.entidadesBasicas.interfaces.InterfazGestion;
import icaro.infraestructura.entidadesBasicas.interfaces.InterfazUsoAgente;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.Tarea;
import icaro.infraestructura.entidadesBasicas.procesadorCognitivo.TareaAsincrona;
import icaro.infraestructura.patronAgenteReactivo.control.acciones.AccionesSemanticasAgenteReactivo;
import icaro.infraestructura.patronAgenteReactivo.factoriaEInterfaces.ItfUsoAgenteReactivo;
import icaro.infraestructura.patronRecursoSimple.ItfUsoRecursoSimple;
import icaro.infraestructura.recursosOrganizacion.configuracion.ItfUsoConfiguracion;
import icaro.infraestructura.recursosOrganizacion.recursoTrazas.ItfUsoRecursoTrazas;
import icaro.infraestructura.recursosOrganizacion.recursoTrazas.imp.componentes.InfoTraza;
import icaro.infraestructura.recursosOrganizacion.repositorioInterfaces.imp.ClaseGeneradoraRepositorioInterfaces;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AccionesSemanticasAgenteAplicacionAccesoAlta extends AccionesSemanticasAgenteReactivo {
	
	/**
	 * @uml.property  name="visualizacion"
	 * @uml.associationEnd  
	 */
	private ItfUsoVisualizadorAccesoAlta visualizacion;
	private ItfUsoInterfazChatUsuario chat;
	/**
	 * @uml.property  name="persistencia1"
	 * @uml.associationEnd  
	 */
	private ItfUsoPersistenciaAccesoBD persistencia;
	private String identRecursoPersistencia = "Persistencia1";
    private String identRecursoVisualizacionAcceso ="VisualizacionAccesoAlta1";
	private ItfUsoAgenteReactivo agenteAcceso;


	public void arranque(){
		
		try {
			visualizacion = (ItfUsoVisualizadorAccesoAlta) itfUsoRepositorio.obtenerInterfaz
			(NombresPredefinidos.ITF_USO+identRecursoVisualizacionAcceso);
            persistencia = (ItfUsoPersistenciaAccesoBD) itfUsoRepositorio.obtenerInterfaz
			(NombresPredefinidos.ITF_USO+identRecursoPersistencia);
			 visualizacion.mostrarVisualizadorAcceso(this.nombreAgente, NombresPredefinidos.TIPO_REACTIVO);
			trazas.aceptaNuevaTraza(new InfoTraza(this.nombreAgente,"Se acaba de mostrar el visualizador",InfoTraza.NivelTraza.debug));
		}

		catch (Exception ex) {
			try {
			ItfUsoRecursoTrazas trazas = (ItfUsoRecursoTrazas)ClaseGeneradoraRepositorioInterfaces.instance().obtenerInterfaz(
					NombresPredefinidos.ITF_USO+NombresPredefinidos.RECURSO_TRAZAS);
					trazas.aceptaNuevaTraza(new InfoTraza(this.nombreAgente, "Ha habido un problema al abrir el visualizador"
                                                + " de Acceso en accion semantica 'arranque()'",
                                                                InfoTraza.NivelTraza.error));
			}catch(Exception e){e.printStackTrace();}
		}
	}
	
	public void valida(InfoAccesoSinValidar infoUsuario) {
		boolean ok = false;
		try {
//			persistencia = (ItfUsoPersistenciaAccesoSimple) itfUsoRepositorio.obtenerInterfaz
//			(NombresPredefinidos.ITF_USO+identRecursoPersistencia);
			ok = persistencia.compruebaUsuario(infoUsuario.tomaUsuario(),infoUsuario.tomaPassword());
			try {
				ItfUsoRecursoTrazas trazas = (ItfUsoRecursoTrazas)ClaseGeneradoraRepositorioInterfaces.instance().obtenerInterfaz(
						NombresPredefinidos.ITF_USO+NombresPredefinidos.RECURSO_TRAZAS);
						trazas.aceptaNuevaTraza(new InfoTraza(this.nombreAgente,  "Comprobando usuario...", 
                                                                                    InfoTraza.NivelTraza.debug));
			}catch(Exception e){e.printStackTrace();}
		}

		catch (Exception ex){
			try {
                     
//				ItfUsoRecursoTrazas trazas = (ItfUsoRecursoTrazas)ClaseGeneradoraRepositorioInterfaces.instance().obtenerInterfaz(
//						NombresPredefinidos.ITF_USO+NombresPredefinidos.RECURSO_TRAZAS);
						trazas.aceptaNuevaTraza(new InfoTraza(this.nombreAgente, 
							"Ha habido un problema en la Persistencia1 al comprobar el usuario y el password", 
															  InfoTraza.NivelTraza.error));
				}catch(Exception e){e.printStackTrace();}
		}
		try {
			agenteAcceso = (ItfUsoAgenteReactivo) itfUsoRepositorio.obtenerInterfaz
			(NombresPredefinidos.ITF_USO+this.nombreAgente);
			Object[] datosEnvio = new Object[]{infoUsuario.tomaUsuario(), infoUsuario.tomaPassword()};
			if(ok){
////				agenteAcceso.aceptaEvento(new EventoRecAgte("usuarioValido",datosEnvio,this.nombreAgente,NombresPredefinidos.NOMBRE_AGENTE_APLICACION+"Acceso"));
			this.informaraMiAutomata("usuarioValido", datosEnvio);
                        }
			else{
//				agenteAcceso.aceptaEvento(new EventoRecAgte("usuarioNoValido", datosEnvio,this.nombreAgente,this.nombreAgente));
			this.informaraMiAutomata("usuarioNoValido", datosEnvio);
                        }
		}
		catch (Exception e) {
			try {
				ItfUsoRecursoTrazas trazas = (ItfUsoRecursoTrazas)ClaseGeneradoraRepositorioInterfaces.instance().obtenerInterfaz(
						NombresPredefinidos.ITF_USO+NombresPredefinidos.RECURSO_TRAZAS);
						trazas.aceptaNuevaTraza(new InfoTraza(this.nombreAgente, 
															  "Ha habido un problema enviar el evento usuario Valido/NoValido al agente", 
															  InfoTraza.NivelTraza.error));
				}catch(Exception e2){e2.printStackTrace();}
		}
	}

	public void mostrarErrorDatos(String us, String pass){
		 try {
			visualizacion.mostrarMensajeAviso("Datos erróneos", " El nombre de usuario y la clave no coinciden.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
        public void validaConRecRemoto(InfoAccesoSinValidar infoUsuario) {
		boolean ok = false;

//		InfoAccesoSinValidar datos = new InfoAccesoSinValidar(username,password);
		try {
                   ItfUsoConfiguracion  config = (ItfUsoConfiguracion) itfUsoRepositorio.obtenerInterfaz(
							NombresPredefinidos.ITF_USO
									+ NombresPredefinidos.CONFIGURACION);
//                         String nombreRec = "Persistencia1";
			 String identHostRecurso= config.getDescInstanciaRecursoAplicacion(identRecursoPersistencia).getNodo().getNombreUso();
                           ItfUsoPersistenciaAccesoBD itfUsoRec = (ItfUsoPersistenciaAccesoBD) AdaptadorRegRMI.getItfUsoRecursoRemoto(identHostRecurso, identRecursoPersistencia);
                            if (itfUsoRec == null)// la intf  es null El recruso no ha sido registrado
                            {
                             logger.debug("AgenteAcceso: No se puede dar la orden de arranque al recurso "+ identRecursoPersistencia + ". Porque su interfaz es null");
                             trazas.aceptaNuevaTraza(new InfoTraza(nombreAgente,
					" No se puede dar la orden de arranque al recurso "+ identRecursoPersistencia + ". Porque su interfaz es null",
					InfoTraza.NivelTraza.debug));
//                                        errorEnArranque = true;
                            }
                            else {
                             //
			ok = itfUsoRec.compruebaUsuario(infoUsuario.tomaUsuario(),infoUsuario.tomaPassword());
			try {
				ItfUsoRecursoTrazas trazas = (ItfUsoRecursoTrazas)ClaseGeneradoraRepositorioInterfaces.instance().obtenerInterfaz(
						NombresPredefinidos.ITF_USO+NombresPredefinidos.RECURSO_TRAZAS);
						trazas.aceptaNuevaTraza(new InfoTraza(this.nombreAgente,
															  "Comprobando usuario...",
															  InfoTraza.NivelTraza.debug));
			}catch(Exception e){e.printStackTrace();}
		}

                } catch (Exception ex) {
			try {

				ItfUsoRecursoTrazas trazas = (ItfUsoRecursoTrazas)ClaseGeneradoraRepositorioInterfaces.instance().obtenerInterfaz(
						NombresPredefinidos.ITF_USO+NombresPredefinidos.RECURSO_TRAZAS);
						trazas.aceptaNuevaTraza(new InfoTraza(this.nombreAgente,
							"Ha habido un problema en la Persistencia1 al comprobar el usuario y el password",
															  InfoTraza.NivelTraza.error));
				}catch(Exception e){e.printStackTrace();}
		}
		try {
			agenteAcceso = (ItfUsoAgenteReactivo) itfUsoRepositorio.obtenerInterfaz
			(NombresPredefinidos.ITF_USO+this.nombreAgente);
			Object[] datosEnvio = new Object[]{infoUsuario.tomaUsuario(), infoUsuario.tomaPassword()};
			if(ok){
				agenteAcceso.aceptaEvento(new EventoRecAgte("usuarioValido",datosEnvio,this.nombreAgente,NombresPredefinidos.NOMBRE_AGENTE_APLICACION+"Acceso"));
			}
			else{
				agenteAcceso.aceptaEvento(new EventoRecAgte("usuarioNoValido", datosEnvio,this.nombreAgente,this.nombreAgente));
			}
		}
		catch (Exception e) {
			try {
				ItfUsoRecursoTrazas trazas = (ItfUsoRecursoTrazas)ClaseGeneradoraRepositorioInterfaces.instance().obtenerInterfaz(
						NombresPredefinidos.ITF_USO+NombresPredefinidos.RECURSO_TRAZAS);
						trazas.aceptaNuevaTraza(new InfoTraza(this.nombreAgente,
															  "Ha habido un problema enviar el evento usuario Valido/NoValido al agente",
															  InfoTraza.NivelTraza.error));
				}catch(Exception e2){e2.printStackTrace();}
		}
	}

        public void mostrarAltaUsuario(InfoAccesoSinValidar infoUsuario){
        try {
        	this.visualizacion.cerrarVisualizadorAcceso();
			this.visualizacion.mostrarVisualizadorAccesoAlta("");

        } catch (Exception ex) {
            Logger.getLogger(AccionesSemanticasAgenteAplicacionAccesoAlta.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        
	public void mostrarUsuarioAccede(String username, String password){
		InfoAccesoValidada dav = new InfoAccesoValidada(username ,password);
		
		try{
			//visualizacion.mostrarMensajeInformacion("AccesoCorrecto", "El usuario "+ dav.tomaUsuario()+" ha accedido a Botzzaroni.");
			visualizacion.cerrarVisualizadorAcceso();
		
			/** ENVIAR MENSAJE DESDE ESTE AGENTE AL DE CONTEXTO PARA QUE INICIE EL CHAT CON EL USUARIO **/
			InterfazUsoAgente itfAgenteDialogo = (InterfazUsoAgente) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ.obtenerInterfaz
					(NombresPredefinidos.ITF_USO+ VocabularioGestionQuedadas.IdentAgenteContexto);; 
	    	Notificacion infoAenviar = new Notificacion(VocabularioGestionQuedadas.IdentRecursoComunicacionChat);
			infoAenviar.setTipoNotificacion(VocabularioGestionQuedadas.ResultadoAutenticacion_DatosValidos);
			infoAenviar.setMensajeNotificacion(dav.tomaUsuario());
			MensajeSimple mensajeAenviar = new MensajeSimple(infoAenviar, VocabularioGestionQuedadas.IdentRecursoComunicacionChat, 
					VocabularioGestionQuedadas.IdentAgenteContexto);
			itfAgenteDialogo.aceptaMensaje(mensajeAenviar);
		}
		catch (Exception ex) {
			try {
				ItfUsoRecursoTrazas trazas = (ItfUsoRecursoTrazas)ClaseGeneradoraRepositorioInterfaces.instance().obtenerInterfaz(
						NombresPredefinidos.ITF_USO+NombresPredefinidos.RECURSO_TRAZAS);
						trazas.aceptaNuevaTraza(new InfoTraza(this.nombreAgente, 
															  "Ha habido un problema al abrir el visualizador de Acceso", 
															  InfoTraza.NivelTraza.error));
				}catch(Exception e2){e2.printStackTrace();}
		}
		//pedirTerminacionGestorAgentes();
	}
	
	public void peticionInfoAlta(String username, String password){
		InfoAccesoSinValidar dav = new InfoAccesoSinValidar(username ,password);
		
		try{
//			visualizacion = (ItfUsoVisualizadorAccesoAlta) itfUsoRepositorio.obtenerInterfaz
//			(NombresPredefinidos.ITF_USO+"VisualizacionAcceso1");
//			visualizacion.mostrarMensajeError("Acceso Incorrecto", "El usuario "+dav.tomaUsuario()+" no ha accedido al sistema.");
//          visualizacion.mostrarMensajeAviso("Acceso Incorrecto", "Procedemos a darle de Alta ");
            visualizacion.cerrarVisualizadorAcceso();
            visualizacion.mostrarVisualizadorAccesoAlta("");
		}

		catch (Exception ex) {
			try {
				ItfUsoRecursoTrazas trazas = (ItfUsoRecursoTrazas)ClaseGeneradoraRepositorioInterfaces.instance().obtenerInterfaz(
						NombresPredefinidos.ITF_USO+NombresPredefinidos.RECURSO_TRAZAS);
						trazas.aceptaNuevaTraza(new InfoTraza(this.nombreAgente, 
									"Ha habido un problema al abrir el visualizador de Acceso", 
									InfoTraza.NivelTraza.error));
			}catch(Exception e2){e2.printStackTrace();}
		}
		// pedirTerminacionGestorAgentes();
	}
        public void registrarAltaUsuario(InfoAccesoSinValidar infoUsuario) {
            try {
            	Object[] datosEnvio = new Object[]{infoUsuario.tomaUsuario(), infoUsuario.tomaPassword()};
                String nombreUsuario = infoUsuario.tomaUsuario();
                String clave = infoUsuario.tomaPassword();
                if(!persistencia.compruebaUsuario(nombreUsuario,clave)){
                        persistencia.insertaUsuario(nombreUsuario, clave);
//                        visualizacion.mostrarMensajeInformacion("Usuario Registrado con exito", " El  usuario: " + nombreUsuario +
//                                " ha sido registrado con exito ");
                        visualizacion.cerrarVisualizadorAccesoAlta();
//                        visualizacion.mostrarVisualizadorAcceso(this.nombreAgente, NombresPredefinidos.TIPO_REACTIVO);
                        informaraMiAutomata("usuarioRegistrado", datosEnvio);
                }
                else
                        visualizacion.mostrarMensajeAviso("Usuario ya Registrado", " El nombre de usuario y la clave ya estan registrados. introduzca un nombre de"
                                + "usuario y/o una clave diferentes ");
        } catch (Exception ex) {
            Logger.getLogger(AccionesSemanticasAgenteAplicacionAccesoAlta.class.getName()).log(Level.SEVERE, null, ex);
            informaraMiAutomata("usuarioRegistrado", null);
        }

        }
      

	
	public void terminacion() {
		try {
			ItfUsoRecursoTrazas trazas = (ItfUsoRecursoTrazas)ClaseGeneradoraRepositorioInterfaces.instance().obtenerInterfaz(
					NombresPredefinidos.ITF_USO+NombresPredefinidos.RECURSO_TRAZAS);
					trazas.aceptaNuevaTraza(new InfoTraza(this.nombreAgente, 
														  "Terminando agente: "+NombresPredefinidos.NOMBRE_AGENTE_APLICACION+"Acceso1", 
														  InfoTraza.NivelTraza.debug));
//		try {
//			this.hebra.finalizar(); // CUIDADO, SI FALLASE LA CREACION DE LOS
//									// RECURSOS ESTA HEBRA
//		} // NO ESTA INICIALIZADA
//		catch (Exception e) {
//			e.printStackTrace();
//			logger.error("GestorOrganizacion: La hebra no ha podido ser finalizada porque no hab�a sido creada.");
//			trazas.aceptaNuevaTraza(new InfoTraza("GestorRecursos",
//					"La hebra no ha podido ser finalizada porque no hab�a sido creada.",
//					InfoTraza.NivelTraza.error));
//		}
		try {
                    visualizacion.cerrarVisualizadorAcceso();
                    ((InterfazGestion) this.itfUsoRepositorio
					.obtenerInterfaz(NombresPredefinidos.ITF_GESTION
							+ NombresPredefinidos.NOMBRE_GESTOR_AGENTES))
					.termina();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			this.itfUsoGestorAReportar.aceptaEvento(new EventoRecAgte(
					"gestor_agentes_terminado",
					NombresPredefinidos.NOMBRE_GESTOR_AGENTES,
					NombresPredefinidos.NOMBRE_GESTOR_ORGANIZACION));
		} catch (Exception e) {
			e.printStackTrace();
		}


                }catch(Exception e2){e2.printStackTrace();}
		logger.debug("Terminando agente: "+this.nombreAgente);
	}
	
	public void clasificaError(){
	/*
	 *A partir de esta funci�n se debe decidir si el sistema se puede recuperar del error o no.
	 *En este caso la pol�tica es que todos los errores son cr�ticos.  
	 */
		try {
			agenteAcceso = (ItfUsoAgenteReactivo) itfUsoRepositorio.obtenerInterfaz
			(NombresPredefinidos.ITF_USO+this.nombreAgente);
			agenteAcceso.aceptaEvento(new EventoRecAgte("errorIrrecuperable",this.nombreAgente,this.nombreAgente));

		}
		catch (Exception e) {
			try {
				ItfUsoRecursoTrazas trazas = (ItfUsoRecursoTrazas)ClaseGeneradoraRepositorioInterfaces.instance().obtenerInterfaz(
						NombresPredefinidos.ITF_USO+NombresPredefinidos.RECURSO_TRAZAS);
						trazas.aceptaNuevaTraza(new InfoTraza(this.nombreAgente, 
															  "Ha habido un problema enviar el evento usuario Valido/NoValido al agente Acceso", 
															  InfoTraza.NivelTraza.error));
			}catch(Exception e2){e2.printStackTrace();}
		}
	}
	public void pedirTerminacionGestorAgentes(){
		try {
			/*ItfUsoAgenteReactivo itfUsoGestorOrgan = (ItfUsoAgenteReactivo)itfUsoRepositorio.obtenerInterfaz
			("Itf_Uso_Gestor_Organizacion");
			itfUsoGestorOrgan.aceptaEvento(new EventoRecAgte("terminar_gestores_y_gestor_organizacion","AgenteAccesoUso","AgenteAccesoUso"));*/
//			this.itfUsoGestorAReportar.aceptaEvento(new EventoRecAgte("peticion_terminar_todo",this.nombreAgente,NombresPredefinidos.NOMBRE_GESTOR_AGENTES));
                         visualizacion.cerrarVisualizadorAcceso();
                        this.itfUsoGestorAReportar.aceptaMensaje(new MensajeSimple (new InfoContEvtMsgAgteReactivo("peticion_terminar_todo"), this.nombreAgente,NombresPredefinidos.NOMBRE_GESTOR_AGENTES));
		} catch (Exception e) {
			logger.error("Error al mandar el evento de terminar_todo",e);
			try {
				ItfUsoRecursoTrazas trazas = (ItfUsoRecursoTrazas)ClaseGeneradoraRepositorioInterfaces.instance().obtenerInterfaz(
						NombresPredefinidos.ITF_USO+NombresPredefinidos.RECURSO_TRAZAS);
						trazas.aceptaNuevaTraza(new InfoTraza(this.nombreAgente, 
															  "Error al mandar el evento de terminar_todo", 
															  InfoTraza.NivelTraza.error));
			}catch(Exception e2){e2.printStackTrace();}
			try{
				agenteAcceso = (ItfUsoAgenteReactivo) itfUsoRepositorio.obtenerInterfaz
				(NombresPredefinidos.ITF_USO+this.nombreAgente);
				agenteAcceso.aceptaEvento(new EventoRecAgte("error",this.nombreAgente,this.nombreAgente));
			}
			catch(Exception exc){
				try {
					ItfUsoRecursoTrazas trazas = (ItfUsoRecursoTrazas)ClaseGeneradoraRepositorioInterfaces.instance().obtenerInterfaz(
							NombresPredefinidos.ITF_USO+NombresPredefinidos.RECURSO_TRAZAS);
							trazas.aceptaNuevaTraza(new InfoTraza(this.nombreAgente, 
																  "Fallo al enviar un evento error.", 
																  InfoTraza.NivelTraza.error));
				}catch(Exception e2){e2.printStackTrace();}
				logger.error("Fallo al enviar un evento error.",exc);
			}
		}
	}

}