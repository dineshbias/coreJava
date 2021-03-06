
package com.client.atm;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.10
 * 2014-08-31T15:31:45.580+05:30
 * Generated source version: 2.7.10
 * 
 */
public final class ATMAtmcashoutPortType_ATMAtmcashoutPort_Client {

    private static final QName SERVICE_NAME = new QName("http://atm-atmcashout.em.emm.ericsson.com", "ATM-atmcashoutService");

    private ATMAtmcashoutPortType_ATMAtmcashoutPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = ATMAtmcashoutService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        ATMAtmcashoutService ss = new ATMAtmcashoutService(wsdlURL, SERVICE_NAME);
        ATMAtmcashoutPortType port = ss.getATMAtmcashoutPort();  
        
        {
        System.out.println("Invoking atmcashout...");
        com.client.atm.Atmcashoutrequest _atmcashout_atmcashoutrequest = null;
        try {
            com.client.atm.Atmcashoutresponse _atmcashout__return = port.atmcashout(_atmcashout_atmcashoutrequest);
            System.out.println("atmcashout.result=" + _atmcashout__return);

        } catch (ErrorResponse_Exception e) { 
            System.out.println("Expected exception: errorResponse has occurred.");
            System.out.println(e.toString());
        }
            }

        System.exit(0);
    }

}
