//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.2-147
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2012.07.04 at 04:19:28 PM CEST
//

package icaro.infraestructura.entidadesBasicas.descEntidadesOrganizacion.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for DescComportamientoAgentesAplicacion complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 *
 * <pre>
 * &lt;complexType name="DescComportamientoAgentesAplicacion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DescComportamientoAgente" type="{urn:icaro:aplicaciones:descripcionOrganizaciones}DescComportamientoAgente" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DescComportamientoAgentesAplicacion", propOrder = { "descComportamientoAgente" })
public class DescComportamientoAgentesAplicacion {

	@XmlElement(name = "DescComportamientoAgente")
	protected List<DescComportamientoAgente> descComportamientoAgente;

	/**
	 * Gets the value of the descComportamientoAgente property.
	 *
	 * <p>
	 * This accessor method returns a reference to the live list, not a
	 * snapshot. Therefore any modification you make to the returned list will
	 * be present inside the JAXB object. This is why there is not a
	 * <CODE>set</CODE> method for the descComportamientoAgente property.
	 *
	 * <p>
	 * For example, to add a new item, do as follows:
	 *
	 * <pre>
	 * getDescComportamientoAgente().add(newItem);
	 * </pre>
	 *
	 *
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link DescComportamientoAgente }
	 *
	 *
	 */
	public List<DescComportamientoAgente> getDescComportamientoAgente() {
		if (descComportamientoAgente == null) {
			descComportamientoAgente = new ArrayList<DescComportamientoAgente>();
		}
		return this.descComportamientoAgente;
	}

}
