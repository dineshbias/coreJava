//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.08.26 at 05:48:28 PM IST 
//


package com.ericsson.am.xsd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for businesslogicType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="businesslogicType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="properties" type="{http://www.ericsson.com/am/xsd}propertiesType"/>
 *         &lt;element name="propertylists" type="{http://www.ericsson.com/am/xsd}propertyListsType" minOccurs="0"/>
 *         &lt;element name="operations" type="{http://www.ericsson.com/am/xsd}operationsType" minOccurs="0"/>
 *         &lt;element name="remotes" type="{http://www.ericsson.com/am/xsd}remotesType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="class" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "businesslogicType", propOrder = {
    "properties",
    "propertylists",
    "operations",
    "remotes"
})
public class BusinesslogicType {

    @XmlElement(required = true)
    protected PropertiesType properties;
    protected PropertyListsType propertylists;
    protected OperationsType operations;
    protected RemotesType remotes;
    @XmlAttribute(name = "class", required = true)
    protected String clazz;

    /**
     * Gets the value of the properties property.
     * 
     * @return
     *     possible object is
     *     {@link PropertiesType }
     *     
     */
    public PropertiesType getProperties() {
        return properties;
    }

    /**
     * Sets the value of the properties property.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertiesType }
     *     
     */
    public void setProperties(PropertiesType value) {
        this.properties = value;
    }

    /**
     * Gets the value of the propertylists property.
     * 
     * @return
     *     possible object is
     *     {@link PropertyListsType }
     *     
     */
    public PropertyListsType getPropertylists() {
        return propertylists;
    }

    /**
     * Sets the value of the propertylists property.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertyListsType }
     *     
     */
    public void setPropertylists(PropertyListsType value) {
        this.propertylists = value;
    }

    /**
     * Gets the value of the operations property.
     * 
     * @return
     *     possible object is
     *     {@link OperationsType }
     *     
     */
    public OperationsType getOperations() {
        return operations;
    }

    /**
     * Sets the value of the operations property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperationsType }
     *     
     */
    public void setOperations(OperationsType value) {
        this.operations = value;
    }

    /**
     * Gets the value of the remotes property.
     * 
     * @return
     *     possible object is
     *     {@link RemotesType }
     *     
     */
    public RemotesType getRemotes() {
        return remotes;
    }

    /**
     * Sets the value of the remotes property.
     * 
     * @param value
     *     allowed object is
     *     {@link RemotesType }
     *     
     */
    public void setRemotes(RemotesType value) {
        this.remotes = value;
    }

    /**
     * Gets the value of the clazz property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClazz() {
        return clazz;
    }

    /**
     * Sets the value of the clazz property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClazz(String value) {
        this.clazz = value;
    }

}