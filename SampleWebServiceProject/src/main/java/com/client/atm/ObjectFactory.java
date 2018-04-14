
package com.client.atm;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.client.atm package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.client.atm
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Atmcashoutrequest }
     * 
     */
    public Atmcashoutrequest createAtmcashoutrequest() {
        return new Atmcashoutrequest();
    }

    /**
     * Create an instance of {@link HeaderfieldsType }
     * 
     */
    public HeaderfieldsType createHeaderfieldsType() {
        return new HeaderfieldsType();
    }

    /**
     * Create an instance of {@link Atmcashoutresponse }
     * 
     */
    public Atmcashoutresponse createAtmcashoutresponse() {
        return new Atmcashoutresponse();
    }

    /**
     * Create an instance of {@link Loyalty }
     * 
     */
    public Loyalty createLoyalty() {
        return new Loyalty();
    }

    /**
     * Create an instance of {@link ErrorResponse }
     * 
     */
    public ErrorResponse createErrorResponse() {
        return new ErrorResponse();
    }

    /**
     * Create an instance of {@link Errorargumenttype }
     * 
     */
    public Errorargumenttype createErrorargumenttype() {
        return new Errorargumenttype();
    }

    /**
     * Create an instance of {@link HeaderfieldType }
     * 
     */
    public HeaderfieldType createHeaderfieldType() {
        return new HeaderfieldType();
    }

}
