//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.08.26 at 05:48:28 PM IST 
//


package com.ericsson.am.xsd;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sessionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sessionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="timeout" use="required" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *       &lt;attribute name="timeunit" use="required" type="{http://www.ericsson.com/am/xsd}timeunitType" />
 *       &lt;attribute name="multicastGroup" type="{http://www.w3.org/2001/XMLSchema}string" default="" />
 *       &lt;attribute name="multicastPort" type="{http://www.w3.org/2001/XMLSchema}integer" default="0" />
 *       &lt;attribute name="multicastTimeout" type="{http://www.w3.org/2001/XMLSchema}integer" default="1000" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sessionType")
public class SessionType {

    @XmlAttribute(name = "timeout", required = true)
    protected BigInteger timeout;
    @XmlAttribute(name = "timeunit", required = true)
    protected TimeunitType timeunit;
    @XmlAttribute(name = "multicastGroup")
    protected String multicastGroup;
    @XmlAttribute(name = "multicastPort")
    protected BigInteger multicastPort;
    @XmlAttribute(name = "multicastTimeout")
    protected BigInteger multicastTimeout;

    /**
     * Gets the value of the timeout property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getTimeout() {
        return timeout;
    }

    /**
     * Sets the value of the timeout property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setTimeout(BigInteger value) {
        this.timeout = value;
    }

    /**
     * Gets the value of the timeunit property.
     * 
     * @return
     *     possible object is
     *     {@link TimeunitType }
     *     
     */
    public TimeunitType getTimeunit() {
        return timeunit;
    }

    /**
     * Sets the value of the timeunit property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeunitType }
     *     
     */
    public void setTimeunit(TimeunitType value) {
        this.timeunit = value;
    }

    /**
     * Gets the value of the multicastGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMulticastGroup() {
        if (multicastGroup == null) {
            return "";
        } else {
            return multicastGroup;
        }
    }

    /**
     * Sets the value of the multicastGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMulticastGroup(String value) {
        this.multicastGroup = value;
    }

    /**
     * Gets the value of the multicastPort property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMulticastPort() {
        if (multicastPort == null) {
            return new BigInteger("0");
        } else {
            return multicastPort;
        }
    }

    /**
     * Sets the value of the multicastPort property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMulticastPort(BigInteger value) {
        this.multicastPort = value;
    }

    /**
     * Gets the value of the multicastTimeout property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMulticastTimeout() {
        if (multicastTimeout == null) {
            return new BigInteger("1000");
        } else {
            return multicastTimeout;
        }
    }

    /**
     * Sets the value of the multicastTimeout property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMulticastTimeout(BigInteger value) {
        this.multicastTimeout = value;
    }

}
