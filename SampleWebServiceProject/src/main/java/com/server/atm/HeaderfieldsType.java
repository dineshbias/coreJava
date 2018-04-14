
package com.server.atm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for headerfieldsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="headerfieldsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="headerfield" type="{http://atm-atmcashout.em.emm.ericsson.com}headerfieldType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "headerfieldsType", propOrder = {
    "headerfield"
})
public class HeaderfieldsType {

    protected HeaderfieldType headerfield;

    /**
     * Gets the value of the headerfield property.
     * 
     * @return
     *     possible object is
     *     {@link HeaderfieldType }
     *     
     */
    public HeaderfieldType getHeaderfield() {
        return headerfield;
    }

    /**
     * Sets the value of the headerfield property.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderfieldType }
     *     
     */
    public void setHeaderfield(HeaderfieldType value) {
        this.headerfield = value;
    }

}
