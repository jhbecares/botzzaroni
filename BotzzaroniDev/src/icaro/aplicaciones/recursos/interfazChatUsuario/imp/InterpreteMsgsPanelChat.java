/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icaro.aplicaciones.recursos.interfazChatUsuario.imp;

import icaro.aplicaciones.recursos.comunicacionChat.imp.*;
import gate.Annotation;
import icaro.aplicaciones.informacion.gestionPizzeria.InfoConexionUsuario;
import icaro.aplicaciones.informacion.gestionPizzeria.Notificacion;
import icaro.aplicaciones.informacion.gestionPizzeria.VocabularioGestionPizzeria;
import icaro.aplicaciones.recursos.comunicacionChat.imp.util.ConexionIrc;
import static icaro.aplicaciones.recursos.comunicacionChat.imp.util.ConexionIrc.VERSION;
import icaro.aplicaciones.recursos.extractorSemantico.ItfUsoExtractorSemantico;
import icaro.aplicaciones.recursos.interfazChatUsuario.ParserFecha;
import icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
import icaro.infraestructura.entidadesBasicas.comunicacion.ComunicacionAgentes;
import icaro.infraestructura.entidadesBasicas.comunicacion.MensajeSimple;
import icaro.infraestructura.entidadesBasicas.excepciones.ExcepcionEnComponente;
import icaro.infraestructura.entidadesBasicas.interfaces.InterfazUsoAgente;
import icaro.infraestructura.recursosOrganizacion.recursoTrazas.ItfUsoRecursoTrazas;
import icaro.infraestructura.recursosOrganizacion.recursoTrazas.imp.componentes.InfoTraza;
import icaro.infraestructura.recursosOrganizacion.repositorioInterfaces.ItfUsoRepositorioInterfaces;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author FGarijo
 */
public class InterpreteMsgsPanelChat {
    
     private boolean _verbose = true;
    private String _userNameAgente = VocabularioGestionPizzeria.IdentConexionAgte;
    private int _maxLineLength = 512;
    private ConexionIrc conectorIrc;
     protected ItfUsoRepositorioInterfaces itfUsoRepositorioInterfaces;
    protected ItfUsoRecursoTrazas trazas;
    private String identAgenteGestorDialogo;
    private String identRecExtractSemantico;
    private ComunicacionAgentes comunicator;
    private MensajeSimple mensajeAenviar;
    private InterfazUsoAgente itfAgenteDialogo;
    private ItfUsoExtractorSemantico itfUsoExtractorSem;
    private HashSet anotacionesRelevantes;
    private InfoConexionUsuario infoConecxInterlocutor;
    private String identificadordeEsteRecurso;
    private String identificadorAgenteaReportar;
    private InterfazUsoAgente itfUsoAgenteaReportar;
    private String sender;
    

    public InterpreteMsgsPanelChat (){}
	
    public InterpreteMsgsPanelChat(String identRecurso, String identAgteAreportar) {
       trazas = NombresPredefinidos.RECURSO_TRAZAS_OBJ;
        identificadordeEsteRecurso = identRecurso;
        identificadorAgenteaReportar = identAgteAreportar;
    }
	
    private InterfazUsoAgente buscarItfAgente(String identAgente){
        if (identAgente != null){
           try {
               itfUsoAgenteaReportar = (InterfazUsoAgente) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ.obtenerInterfaz(NombresPredefinidos.ITF_USO+identAgente);
           } catch (Exception ex) {
               Logger.getLogger(InterpreteMsgsPanelChat.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        else{
        	itfUsoAgenteaReportar = null;
        }
        return itfUsoAgenteaReportar;
    }
    
    
    public synchronized  void setItfusoAgenteGestorDialogo(InterfazUsoAgente itfAgteDialogo){
        this.itfAgenteDialogo=itfAgteDialogo;
    }
    public synchronized  void setIdentAgenteGestorDialogo(String idAgteDialogo){
        this.identAgenteGestorDialogo=idAgteDialogo;
    }
    
    public synchronized  void setItfusoRecExtractorSemantico(ItfUsoExtractorSemantico itfRecExtractorSem){
        this.itfUsoExtractorSem=itfRecExtractorSem;
    }
    public void log(String line) {
        if (_verbose) {
            System.out.println(System.currentTimeMillis() + " " + line);
        } 
    }
    
    public void interpetarTextoUsuario(String textoUsuario) {
    
    // Se envia la información al extrator semantico se traducen las anotaciones y se envia el contenido al agente de dialogo
    // de esta forma el agente recibe mensajes con entidades del modelo de información
			HashSet anotacionesBusquedaPrueba = new HashSet();
			anotacionesBusquedaPrueba.add("saludo");
			anotacionesBusquedaPrueba.add("telefono");
			anotacionesBusquedaPrueba.add("hora");
			anotacionesBusquedaPrueba.add("masapizza");
			anotacionesBusquedaPrueba.add("pizzas");
			anotacionesBusquedaPrueba.add("tamanyopizza");
			anotacionesBusquedaPrueba.add("salsas");
			anotacionesBusquedaPrueba.add("nombres");
			anotacionesBusquedaPrueba.add("ingredientes");
			anotacionesBusquedaPrueba.add("apellidos");
			anotacionesBusquedaPrueba.add("numero");
			anotacionesBusquedaPrueba.add("tipoPizzaCasa");
			anotacionesBusquedaPrueba.add("tipoPizzaPersonalizada");
			anotacionesBusquedaPrueba.add("si");
			anotacionesBusquedaPrueba.add("no");
			anotacionesBusquedaPrueba.add("calles");
			anotacionesBusquedaPrueba.add("portal");
			anotacionesBusquedaPrueba.add("piso");
			anotacionesBusquedaPrueba.add("puerta");
			
			if (itfUsoExtractorSem != null) {
				try {
					anotacionesRelevantes = itfUsoExtractorSem.extraerAnotaciones(anotacionesBusquedaPrueba, textoUsuario);
					String anot = anotacionesRelevantes.toString();
					System.out.println(System.currentTimeMillis() + " " + anot);
					ArrayList infoAenviar = interpretarAnotaciones(sender, textoUsuario, anotacionesRelevantes);
					enviarInfoExtraida(infoAenviar, sender);
				} catch (Exception ex) {
					Logger.getLogger(InterpreteMsgsIRC.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			}
//			// esto habria que pasarlo como parametro      
//		if(itfUsoExtractorSem ==null){
//			itfUsoExtractorSem= getItfUsoExtractorSemantico(VocabularioGestionPizzeria.IdentRecursoExtractorSemantico);
//	        try {
//	            anotacionesRelevantes = itfUsoExtractorSem.extraerAnotaciones(anotacionesBusquedaPrueba, textoUsuario);
//				String anot = anotacionesRelevantes.toString();
//				System.out.println(System.currentTimeMillis() + " " + anot);
//				
//				// Versión con extractor
//				ArrayList infoAenviar = interpretarAnotaciones(sender,textoUsuario, anotacionesRelevantes);
//				enviarInfoExtraida(infoAenviar, sender);
//				
//				// Pruebas comunicación haciendo ECHO
//				/*
//				ArrayList infoAenviar= new ArrayList();
//	        	infoAenviar.add(textoUsuario); 
//	            enviarInfoExtraida ( infoAenviar, this.identificadordeEsteRecurso);
//				*/
//				
//	        } catch (Exception ex) {
//	            Logger.getLogger(InterpreteMsgsPanelChat.class.getName()).log(Level.SEVERE, null, ex);
//	            System.out.println("Te pillé 1");
//	        }
//        }else{
//        	trazas.trazar(this.identificadordeEsteRecurso, "La interfaz del recurso de extracion semantica es null. Verificar la definición del identificador del recurso", InfoTraza.NivelTraza.error);
//
//        }
    }
   
    private void enviarInfoExtraida(ArrayList infoExtraida, String sender) {

    	if (itfAgenteDialogo != null) {
			try {
				if (infoExtraida.size() == 0) {
					Notificacion infoAenviar = new Notificacion(sender);
					infoAenviar.setTipoNotificacion(VocabularioGestionPizzeria.ExtraccionSemanticaNull);
					mensajeAenviar = new MensajeSimple(infoAenviar, sender,	identAgenteGestorDialogo);
				} else if (infoExtraida.size() == 1) {
					Object infoAenviar = infoExtraida.get(0);
					mensajeAenviar = new MensajeSimple(infoAenviar, sender,	identAgenteGestorDialogo);
				} else {
					mensajeAenviar = new MensajeSimple(infoExtraida, sender,identAgenteGestorDialogo);
				}

				itfAgenteDialogo.aceptaMensaje(mensajeAenviar);
			} catch (RemoteException ex) {
				Logger.getLogger(InterpreteMsgsIRC.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		}
	}   
   
	private ArrayList interpretarAnotaciones(String interlocutor,
			String contextoInterpretacion, HashSet anotacionesRelevantes) {
		// recorremos las anotaciones obtenidas y las traducimos a objetos del
		// modelo de informacion
		ArrayList anotacionesInterpretadas = new ArrayList();
		ArrayList<String> anotaciones_leidas = new ArrayList<String>();
 
		Iterator annotTypesSal = anotacionesRelevantes.iterator();

		boolean tienePeticion = false;
		while (annotTypesSal.hasNext()) {
			Annotation annot = (Annotation) annotTypesSal.next();
			String anotType = annot.getType();
			if (anotType.equalsIgnoreCase("saludo")) {
				anotaciones_leidas.add("saludo");
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
				// i++;
			} else if (!tienePeticion
					&& anotType.equalsIgnoreCase("iniciopeticion")&& !anotaciones_leidas.contains("iniciopeticion")) {
				anotaciones_leidas.add("iniciopeticion");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));

			} else if (anotType.equalsIgnoreCase("hora")&& !anotaciones_leidas.contains("hora")) {
				anotaciones_leidas.add("hora");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));

			} else if (anotType.equalsIgnoreCase("telefono")&& !anotaciones_leidas.contains("telefono")) {
				anotaciones_leidas.add("telefono");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));

			} else if (anotType.equalsIgnoreCase("despedida")&& !anotaciones_leidas.contains("despedida")) {
				anotaciones_leidas.add("despedida");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));

			} else if (anotType.equalsIgnoreCase("fecha")&& !anotaciones_leidas.contains("fecha")) {
				anotaciones_leidas.add("fecha");
				tienePeticion = true;
				anotacionesInterpretadas.add(ParserFecha
						.parseaFecha(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot)));


			} else if (anotType.equalsIgnoreCase("si")) {
				if (!anotaciones_leidas.contains("si"))
					anotaciones_leidas.add("si");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
				
			} else if (anotType.equalsIgnoreCase("no")) {
				if (!anotaciones_leidas.contains("no"))
					anotaciones_leidas.add("no");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}			
			else if (anotType.equalsIgnoreCase("nombres")) {
				if (!anotaciones_leidas.contains("nombres"))
					anotaciones_leidas.add("nombres");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}
			else if (anotType.equalsIgnoreCase("apellidos")) {
				if (!anotaciones_leidas.contains("apellidos"))
					anotaciones_leidas.add("apellidos");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}
			else if (anotType.equalsIgnoreCase("ingredientes")) {
				if (!anotaciones_leidas.contains("ingredientes"))
					anotaciones_leidas.add("ingredientes");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}
			else if (anotType.equalsIgnoreCase("salsas")) {
				if (!anotaciones_leidas.contains("salsas"))
					anotaciones_leidas.add("salsas");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}
			else if (anotType.equalsIgnoreCase("tamanyopizza")) {
				if (!anotaciones_leidas.contains("tamanyopizza"))
					anotaciones_leidas.add("tamanyopizza");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}
			else if (anotType.equalsIgnoreCase("masapizza")) {
				if (!anotaciones_leidas.contains("masapizza"))
					anotaciones_leidas.add("masapizza");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}
			else if (anotType.equalsIgnoreCase("pizzas")) {
				if (!anotaciones_leidas.contains("pizzas"))
					anotaciones_leidas.add("pizzas");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}

			else if (anotType.equalsIgnoreCase("numero")) {
				if (!anotaciones_leidas.contains("numero"))
					anotaciones_leidas.add("numero");

			else if (anotType.equalsIgnoreCase("calles")) {
				if (!anotaciones_leidas.contains("calles"))
					anotaciones_leidas.add("calles");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}
			else if (anotType.equalsIgnoreCase("tipoPizzaCasa")) {
				if (!anotaciones_leidas.contains("tipoPizzaCasa"))
					anotaciones_leidas.add("tipoPizzaCasa");
				
			} else if (anotType.equalsIgnoreCase("portal")&& !anotaciones_leidas.contains("portal")) {
				anotaciones_leidas.add("portal");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}
			else if (anotType.equalsIgnoreCase("tipoPizzaPersonalizada")) {
				if (!anotaciones_leidas.contains("tipoPizzaPersonalizada"))
					anotaciones_leidas.add("tipoPizzaPersonalizada");
	
			} else if (anotType.equalsIgnoreCase("piso")&& !anotaciones_leidas.contains("piso")) {
				anotaciones_leidas.add("piso");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
	
			} else if (anotType.equalsIgnoreCase("puerta")&& !anotaciones_leidas.contains("puerta")) {
				anotaciones_leidas.add("puerta");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}
		}
		}
		
		return anotacionesInterpretadas;
	}

	private Notificacion interpretarAnotacionSaludoEInicioPeticion(
			String conttextoInterpretacion, Annotation anotacionSaludo) {
				
		Notificacion notif = new Notificacion(this.sender);

		int posicionComienzoTexto = anotacionSaludo.getStartNode().getOffset().intValue();
		int posicionFinTexto = anotacionSaludo.getEndNode().getOffset().intValue();
		String msgNotif = conttextoInterpretacion.substring(posicionComienzoTexto, posicionFinTexto);

		// Se copia el mensaje y el tipo de anotacion en el objeto notificacion.
		notif.setTipoNotificacion(anotacionSaludo.getType());
		notif.setMensajeNotificacion(msgNotif);
		return notif;
	}
	
	
	public ItfUsoExtractorSemantico getItfUsoExtractorSemantico(String idExtractorSem) {
        ItfUsoExtractorSemantico itfUsoExtracSem = null;
             try {
				itfUsoExtracSem = (ItfUsoExtractorSemantico) NombresPredefinidos.REPOSITORIO_INTERFACES_OBJ.obtenerInterfaz
				(NombresPredefinidos.ITF_USO+idExtractorSem);
			}
			catch (Exception e) {
				Logger.getLogger(NotificacionesEventosItfUsuarioChat.class.getName()).log(Level.SEVERE, null, e);
				this.trazas.aceptaNuevaTraza(new InfoTraza(this.getClass().getSimpleName(),
				"Ha habido un problema al obtener la interfaz de uso del recurso: "+idExtractorSem,
				InfoTraza.NivelTraza.error));
			}
             return itfUsoExtracSem;
	}

	public void setSender(String nombre) {
		this.sender = nombre;
		
	}

	public String getIdentidadUsuario() {
		return this.sender;
	}
}
