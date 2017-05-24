/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icaro.aplicaciones.recursos.interfazChatUsuario.imp;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import gate.Annotation;
import icaro.aplicaciones.informacion.gestionPizzeria.InfoConexionUsuario;
import icaro.aplicaciones.informacion.gestionPizzeria.Notificacion;
import icaro.aplicaciones.informacion.gestionPizzeria.VocabularioGestionPizzeria;
import icaro.aplicaciones.recursos.comunicacionChat.imp.InterpreteMsgsIRC;
import icaro.aplicaciones.recursos.comunicacionChat.imp.util.ConexionIrc;
import icaro.aplicaciones.recursos.extractorSemantico.ItfUsoExtractorSemantico;
import icaro.aplicaciones.recursos.interfazChatUsuario.ParserFecha;
import icaro.infraestructura.entidadesBasicas.NombresPredefinidos;
import icaro.infraestructura.entidadesBasicas.comunicacion.ComunicacionAgentes;
import icaro.infraestructura.entidadesBasicas.comunicacion.MensajeSimple;
import icaro.infraestructura.entidadesBasicas.interfaces.InterfazUsoAgente;
import icaro.infraestructura.recursosOrganizacion.recursoTrazas.ItfUsoRecursoTrazas;
import icaro.infraestructura.recursosOrganizacion.recursoTrazas.imp.componentes.InfoTraza;
import icaro.infraestructura.recursosOrganizacion.repositorioInterfaces.ItfUsoRepositorioInterfaces;

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
    private HashSet<?> anotacionesRelevantes;
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
			HashSet<String> anotacionesBusquedaPrueba = new HashSet<String>();
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
			anotacionesBusquedaPrueba.add("tipoPizzaRecomendacion");
			anotacionesBusquedaPrueba.add("si");
			anotacionesBusquedaPrueba.add("no");
			anotacionesBusquedaPrueba.add("calles");
			anotacionesBusquedaPrueba.add("portal");
			anotacionesBusquedaPrueba.add("piso");
			anotacionesBusquedaPrueba.add("puerta");
			anotacionesBusquedaPrueba.add("bebidas");
			anotacionesBusquedaPrueba.add("pagoEfectivo");
			anotacionesBusquedaPrueba.add("pagoTarjeta");
			anotacionesBusquedaPrueba.add("insultos");
			
			// ultima entrega. Fechas
			anotacionesBusquedaPrueba.add("fechaNumero");
			anotacionesBusquedaPrueba.add("TempDate");
			anotacionesBusquedaPrueba.add("TempTime");
			anotacionesBusquedaPrueba.add("TempYear");
			anotacionesBusquedaPrueba.add("year");
			anotacionesBusquedaPrueba.add("ampm");
			anotacionesBusquedaPrueba.add("time_modifier");
			anotacionesBusquedaPrueba.add("time_unit");
			anotacionesBusquedaPrueba.add("zone");
			anotacionesBusquedaPrueba.add("ordinal");
			//anotacionesBusquedaPrueba.add("hour");
			anotacionesBusquedaPrueba.add("horas");
			anotacionesBusquedaPrueba.add("month");
			anotacionesBusquedaPrueba.add("day");
			anotacionesBusquedaPrueba.add("Mes");
			anotacionesBusquedaPrueba.add("miHora");
			anotacionesBusquedaPrueba.add("miMinuto");
			anotacionesBusquedaPrueba.add("miDia");
			anotacionesBusquedaPrueba.add("miMes");
			anotacionesBusquedaPrueba.add("miYear");
			anotacionesBusquedaPrueba.add("miTimeframe");
			anotacionesBusquedaPrueba.add("miModificador");
			//anotacionesBusquedaPrueba.add("minutoLetra");

			anotacionesBusquedaPrueba.add("NombrePizzaPersonalizada");
			
			if (itfUsoExtractorSem != null) {
				try {
					anotacionesRelevantes = itfUsoExtractorSem.extraerAnotaciones(anotacionesBusquedaPrueba, textoUsuario);
					String anot = anotacionesRelevantes.toString();
					System.out.println(System.currentTimeMillis() + " " + anot);
					ArrayList<Notificacion> infoAenviar = interpretarAnotaciones(sender, textoUsuario, anotacionesRelevantes);
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
   
    private void enviarInfoExtraida(ArrayList<Notificacion> infoExtraida, String sender) {

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
   
	private ArrayList<Notificacion> interpretarAnotaciones(String interlocutor,
			String contextoInterpretacion, HashSet<?> anotacionesRelevantes) {
		// recorremos las anotaciones obtenidas y las traducimos a objetos del
		// modelo de informacion
		ArrayList<Notificacion> anotacionesInterpretadas = new ArrayList<Notificacion>();
		ArrayList<String> anotaciones_leidas = new ArrayList<String>();
		
		String ingredientes = "";
 
		Iterator<?> annotTypesSal = anotacionesRelevantes.iterator();

		boolean tienePeticion = false;
		while (annotTypesSal.hasNext()) {
			Annotation annot = (Annotation) annotTypesSal.next();
			String anotType = annot.getType();
			if (anotType.equalsIgnoreCase("saludo") && !anotaciones_leidas.contains("saludo")) {
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


			} else if (anotType.equalsIgnoreCase("si") && !anotaciones_leidas.contains("si")) {
				if (!anotaciones_leidas.contains("si"))
					anotaciones_leidas.add("si");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
				
			} else if (anotType.equalsIgnoreCase("no") && !anotaciones_leidas.contains("no")) {
				if (!anotaciones_leidas.contains("no"))
					anotaciones_leidas.add("no");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}			
			else if (anotType.equalsIgnoreCase("nombres") && !anotaciones_leidas.contains("nombres")) {
				if (!anotaciones_leidas.contains("nombres"))
					anotaciones_leidas.add("nombres");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}
			else if (anotType.equalsIgnoreCase("apellidos") && !anotaciones_leidas.contains("apellidos")) {
				if (!anotaciones_leidas.contains("apellidos"))
					anotaciones_leidas.add("apellidos");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}
			else if (anotType.equalsIgnoreCase("ingredientes")) {
					anotaciones_leidas.add("ingredientes");
				tienePeticion = true;
				// anotacionesInterpretadas .add(interpretarAnotacionSaludoEInicioPeticion(contextoInterpretacion, annot));
				Notificacion n  = interpretarAnotacionSaludoEInicioPeticion(contextoInterpretacion, annot);
				ingredientes += n.getMensajeNotificacion() + "-";
			}
			else if (anotType.equalsIgnoreCase("salsas") && !anotaciones_leidas.contains("salsas")) {
				if (!anotaciones_leidas.contains("salsas"))
					anotaciones_leidas.add("salsas");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}
			else if (anotType.equalsIgnoreCase("tamanyopizza") && !anotaciones_leidas.contains("tamanyopizza")) {
				if (!anotaciones_leidas.contains("tamanyopizza"))
					anotaciones_leidas.add("tamanyopizza");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}
			else if (anotType.equalsIgnoreCase("masapizza") && !anotaciones_leidas.contains("masapizza")) {
				if (!anotaciones_leidas.contains("masapizza"))
					anotaciones_leidas.add("masapizza");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}
			else if (anotType.equalsIgnoreCase("pizzas") && !anotaciones_leidas.contains("pizzas")) {
				if (!anotaciones_leidas.contains("pizzas"))
					anotaciones_leidas.add("pizzas");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}else if (anotType.equalsIgnoreCase("calles") && !anotaciones_leidas.contains("calles")) {
				if (!anotaciones_leidas.contains("calles"))
					anotaciones_leidas.add("calles");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
				
			}
			else if (anotType.equalsIgnoreCase("numero") && !anotaciones_leidas.contains("numero")) {
				if (!anotaciones_leidas.contains("numero"))
					anotaciones_leidas.add("numero");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}
			else if (anotType.equalsIgnoreCase("tipoPizzaCasa") && !anotaciones_leidas.contains("tipoPizzaCasa")) {
				if (!anotaciones_leidas.contains("tipoPizzaCasa"))
					anotaciones_leidas.add("tipoPizzaCasa");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
				
			}
			else if (anotType.equalsIgnoreCase("tipoPizzaPersonalizada") && !anotaciones_leidas.contains("tipoPizzaPersonalizada")) {
				if (!anotaciones_leidas.contains("tipoPizzaPersonalizada"))
					anotaciones_leidas.add("tipoPizzaPersonalizada");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}
			else if (anotType.equalsIgnoreCase("tipoPizzaRecomendacion") && !anotaciones_leidas.contains("tipoPizzaRecomendacion")) {
				if (!anotaciones_leidas.contains("tipoPizzaRecomendacion"))
					anotaciones_leidas.add("tipoPizzaRecomendacion");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}
			else if (anotType.equalsIgnoreCase("portal")&& !anotaciones_leidas.contains("portal")) {
				if (!anotaciones_leidas.contains("portal"))
					anotaciones_leidas.add("portal");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}
			else if (anotType.equalsIgnoreCase("piso")&& !anotaciones_leidas.contains("piso")) {
				if (!anotaciones_leidas.contains("piso"))
					anotaciones_leidas.add("piso");
				
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
	
			} else if (anotType.equalsIgnoreCase("puerta")&& !anotaciones_leidas.contains("puerta")) {
				if (!anotaciones_leidas.contains("puerta"))
					anotaciones_leidas.add("puerta");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}
			else if (anotType.equalsIgnoreCase("bebidas")&& !anotaciones_leidas.contains("bebidas")) {
				if (!anotaciones_leidas.contains("bebidas"))
					anotaciones_leidas.add("bebidas");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			} 
			else if (anotType.equalsIgnoreCase("pagoEfectivo")&& !anotaciones_leidas.contains("pagoEfectivo")) {
				if (!anotaciones_leidas.contains("pagoEfectivo"))
					anotaciones_leidas.add("pagoEfectivo");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			} 
			else if (anotType.equalsIgnoreCase("pagoTarjeta")&& !anotaciones_leidas.contains("pagoTarjeta")) {
				if (!anotaciones_leidas.contains("pagoTarjeta"))
					anotaciones_leidas.add("pagoTarjeta");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}
			else if (anotType.equalsIgnoreCase("insultos")&& !anotaciones_leidas.contains("insultos")) {
				if (!anotaciones_leidas.contains("insultos"))
					anotaciones_leidas.add("insultos");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			} 
			else if (anotType.equalsIgnoreCase("fechaNumero")&& !anotaciones_leidas.contains("fechaNumero")) {
				if (!anotaciones_leidas.contains("fechaNumero"))
					anotaciones_leidas.add("fechaNumero");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			} 
			else if (anotType.equalsIgnoreCase("TempDate")&& !anotaciones_leidas.contains("TempDate")) {
				if (!anotaciones_leidas.contains("TempDate"))
					anotaciones_leidas.add("TempDate");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			} 
			else if (anotType.equalsIgnoreCase("TempTime")&& !anotaciones_leidas.contains("TempTime")) {
				if (!anotaciones_leidas.contains("TempTime"))
					anotaciones_leidas.add("TempTime");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			} 
			else if (anotType.equalsIgnoreCase("TempYear")&& !anotaciones_leidas.contains("TempYear")) {
				if (!anotaciones_leidas.contains("TempYear"))
					anotaciones_leidas.add("TempYear");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			} 
			else if (anotType.equalsIgnoreCase("year")&& !anotaciones_leidas.contains("year")) {
				if (!anotaciones_leidas.contains("year"))
					anotaciones_leidas.add("year");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			} 
			else if (anotType.equalsIgnoreCase("ampm")&& !anotaciones_leidas.contains("ampm")) {
				if (!anotaciones_leidas.contains("ampm"))
					anotaciones_leidas.add("ampm");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}
			else if (anotType.equalsIgnoreCase("time_modifier")&& !anotaciones_leidas.contains("time_modifier")) {
				if (!anotaciones_leidas.contains("time_modifier"))
					anotaciones_leidas.add("time_modifier");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}
			else if (anotType.equalsIgnoreCase("time_unit")&& !anotaciones_leidas.contains("time_unit")) {
				if (!anotaciones_leidas.contains("time_unit"))
					anotaciones_leidas.add("time_unit");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}
			else if (anotType.equalsIgnoreCase("zone")&& !anotaciones_leidas.contains("zone")) {
				if (!anotaciones_leidas.contains("zone"))
					anotaciones_leidas.add("zone");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}
			else if (anotType.equalsIgnoreCase("ordinal")&& !anotaciones_leidas.contains("ordinal")) {
				if (!anotaciones_leidas.contains("ordinal"))
					anotaciones_leidas.add("ordinal");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}
			else if (anotType.equalsIgnoreCase("horas")&& !anotaciones_leidas.contains("horas")) {
				if (!anotaciones_leidas.contains("horas"))
					anotaciones_leidas.add("horas");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}
			else if (anotType.equalsIgnoreCase("month")&& !anotaciones_leidas.contains("month")) {
				if (!anotaciones_leidas.contains("month"))
					anotaciones_leidas.add("month");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}
			else if (anotType.equalsIgnoreCase("day")&& !anotaciones_leidas.contains("day")) {
				if (!anotaciones_leidas.contains("day"))
					anotaciones_leidas.add("day");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}
			else if (anotType.equalsIgnoreCase("Mes")&& !anotaciones_leidas.contains("Mes")) {
				if (!anotaciones_leidas.contains("Mes"))
					anotaciones_leidas.add("Mes");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}
			else if (anotType.equalsIgnoreCase("NombrePizzaPersonalizada")&& !anotaciones_leidas.contains("NombrePizzaPersonalizada")) {
				if (!anotaciones_leidas.contains("NombrePizzaPersonalizada"))
					anotaciones_leidas.add("NombrePizzaPersonalizada");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}
			else if (anotType.equalsIgnoreCase("miHora")&& !anotaciones_leidas.contains("miHora")) {
				if (!anotaciones_leidas.contains("miHora"))
					anotaciones_leidas.add("miHora");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}
			else if (anotType.equalsIgnoreCase("miMinuto")&& !anotaciones_leidas.contains("miMinuto")) {
				if (!anotaciones_leidas.contains("miMinuto"))
					anotaciones_leidas.add("miMinuto");
				tienePeticion = true;
				anotacionesInterpretadas
						.add(interpretarAnotacionSaludoEInicioPeticion(
								contextoInterpretacion, annot));
			}
	     else if (anotType.equalsIgnoreCase("miDia")&& !anotaciones_leidas.contains("miDia")) {
	         if (!anotaciones_leidas.contains("miDia"))
	           anotaciones_leidas.add("miDia");
	         tienePeticion = true;
	         anotacionesInterpretadas
	             .add(interpretarAnotacionSaludoEInicioPeticion(
	                 contextoInterpretacion, annot));
	    }
	      else if (anotType.equalsIgnoreCase("miMes")&& !anotaciones_leidas.contains("miMes")) {
	          if (!anotaciones_leidas.contains("miMes"))
	            anotaciones_leidas.add("miMes");
	          tienePeticion = true;
	          anotacionesInterpretadas
	              .add(interpretarAnotacionSaludoEInicioPeticion(
	                  contextoInterpretacion, annot));
	        }
	      else if (anotType.equalsIgnoreCase("miYear")&& !anotaciones_leidas.contains("miYear")) {
	          if (!anotaciones_leidas.contains("miYear"))
	            anotaciones_leidas.add("miYear");
	          tienePeticion = true;
	          anotacionesInterpretadas
	              .add(interpretarAnotacionSaludoEInicioPeticion(
	                  contextoInterpretacion, annot));
	        }			
        else if (anotType.equalsIgnoreCase("miTimeframe")&& !anotaciones_leidas.contains("miTimeframe")) {
            if (!anotaciones_leidas.contains("miTimeframe"))
              anotaciones_leidas.add("miTimeframe");
            tienePeticion = true;
            anotacionesInterpretadas
                .add(interpretarAnotacionSaludoEInicioPeticion(
                    contextoInterpretacion, annot));
          }
        else if (anotType.equalsIgnoreCase("miModificador")&& !anotaciones_leidas.contains("miModificador")) {
            if (!anotaciones_leidas.contains("miModificador"))
              anotaciones_leidas.add("miModificador");
            tienePeticion = true;
            anotacionesInterpretadas
                .add(interpretarAnotacionSaludoEInicioPeticion(
                    contextoInterpretacion, annot));
          }
	}
		if(!ingredientes.equalsIgnoreCase("")){
			Notificacion listaIngredientes = new Notificacion();
			listaIngredientes.setMensajeNotificacion(ingredientes);
			listaIngredientes.setTipoNotificacion("ingredientes");
			anotacionesInterpretadas.add(listaIngredientes);
			
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
