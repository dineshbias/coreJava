/**
 * 
 */
package com;

import java.net.URL;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.bus.spring.SpringBusFactory;

import com.server.atm.ATMAtmcashoutPortTypeImpl;
import com.client.atm.ATMAtmcashoutPortType_ATMAtmcashoutPort_Client;

/**
 * @author edinjos
 *
 */
public class TestWebService {

	/**
	 * 
	 */
	public TestWebService() {
		System.out.println("Instantiated TestWebService");
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("Starting Server");
		ATMAtmcashoutPortTypeImpl implementor = new ATMAtmcashoutPortTypeImpl();
		String address = "http://localhost:9000/helloWorld";
		Endpoint.publish(address, implementor);
		System.out.println("Server Started");
		callWebService();

	}

	public static void callWebService() throws Exception {

		ATMAtmcashoutPortType_ATMAtmcashoutPort_Client.main(null);

	}

	
}
