
package com.client.atm;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="externaltransactionid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="transactionid" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="balance" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="fee" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="loyalty" type="{http://atm-atmcashout.em.emm.ericsson.com}loyalty" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "externaltransactionid",
    "transactionid",
    "balance",
    "fee",
    "loyalty"
})
@XmlRootElement(name = "atmcashoutresponse")
public class Atmcashoutresponse {

    @XmlElement(required = true)
    protected String externaltransactionid;
    protected long transactionid;
    @XmlElement(required = true)
    protected BigDecimal balance;
    @XmlElement(required = true)
    protected BigDecimal fee;
    protected Loyalty loyalty;

    /**
     * Gets the value of the externaltransactionid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternaltransactionid() {
        return externaltransactionid;
    }

    /**
     * Sets the value of the externaltransactionid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternaltransactionid(String value) {
        this.externaltransactionid = value;
    }

    /**
     * Gets the value of the transactionid property.
     * 
     */
    public long getTransactionid() {
        return transactionid;
    }

    /**
     * Sets the value of the transactionid property.
     * 
     */
    public void setTransactionid(long value) {
        this.transactionid = value;
    }

    /**
     * Gets the value of the balance property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * Sets the value of the balance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBalance(BigDecimal value) {
        this.balance = value;
    }

    /**
     * Gets the value of the fee property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFee() {
        return fee;
    }

    /**
     * Sets the value of the fee property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFee(BigDecimal value) {
        this.fee = value;
    }

    /**
     * Gets the value of the loyalty property.
     * 
     * @return
     *     possible object is
     *     {@link Loyalty }
     *     
     */
    public Loyalty getLoyalty() {
        return loyalty;
    }

    /**
     * Sets the value of the loyalty property.
     * 
     * @param value
     *     allowed object is
     *     {@link Loyalty }
     *     
     */
    public void setLoyalty(Loyalty value) {
        this.loyalty = value;
    }

}
