/**
 * 
 */
package com;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.bus.spring.SpringBusFactory;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.ws.security.wss4j.DefaultCryptoCoverageChecker;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;

import com.server.atm.ATMAtmcashoutPortTypeImpl;

/**
 * @author edinjos
 *
 */
public class PublishService {
	private static final String WSSE_NS = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";
	private static final String WSU_NS = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd";
	private static Map<String, Object> outProps = new HashMap<String, Object>();
	private static Map<String, Object> inProps = new HashMap<String, Object>();
	private static DefaultCryptoCoverageChecker coverageChecker = new DefaultCryptoCoverageChecker();
	public static String address = "http://localhost:9000/helloWorld";
	
	static {
		outProps.put("action", "UsernameToken Timestamp Signature Encrypt");
		outProps.put("passwordType", "PasswordText");
		outProps.put("passwordCallbackClass", "com.UTPasswordCallback");
		outProps.put("user", "Alice");
		outProps.put("signatureUser", "serverx509v1");

		outProps.put("encryptionUser", "clientx509v1");
		outProps.put("encryptionPropFile", "etc/Server_SignVerf.properties");
		outProps.put("encryptionKeyIdentifier", "IssuerSerial");
		outProps.put("encryptionParts", "{Element}{" + WSSE_NS
				+ "}UsernameToken;"
				+ "{Content}{http://schemas.xmlsoap.org/soap/envelope/}Body");

		outProps.put("signaturePropFile", "etc/Server_Decrypt.properties");
		outProps.put("signatureKeyIdentifier", "DirectReference");
		outProps.put("signatureParts", "{Element}{" + WSU_NS + "}Timestamp;"
				+ "{Element}{http://schemas.xmlsoap.org/soap/envelope/}Body");

		outProps.put("encryptionKeyTransportAlgorithm",
				"http://www.w3.org/2001/04/xmlenc#rsa-oaep-mgf1p");
		outProps.put("signatureAlgorithm",
				"http://www.w3.org/2000/09/xmldsig#rsa-sha1");

		inProps.put("action", "UsernameToken Timestamp Signature Encrypt");
		inProps.put("passwordType", "PasswordDigest");
		inProps.put("passwordCallbackClass", "com.UTPasswordCallback");

		inProps.put("decryptionPropFile", "etc/Server_Decrypt.properties");
		inProps.put("encryptionKeyIdentifier", "IssuerSerial");

		inProps.put("signaturePropFile", "etc/Server_SignVerf.properties");
		inProps.put("signatureKeyIdentifier", "DirectReference");
		inProps.put("encryptionKeyTransportAlgorithm",
				"http://www.w3.org/2001/04/xmlenc#rsa-oaep-mgf1p");
		inProps.put("signatureAlgorithm",
				"http://www.w3.org/2000/09/xmldsig#rsa-sha1");

		coverageChecker.setSignBody(true);
		coverageChecker.setSignTimestamp(true);
		coverageChecker.setEncryptBody(true);

	}

	/**
	 * 
	 */
	public static void publishWS() {
		System.out.println("Starting Server");

		Object implementor = new ATMAtmcashoutPortTypeImpl();

		EndpointImpl endpoint = (EndpointImpl) Endpoint.publish(address,
				implementor);

		endpoint.getOutInterceptors().add(new WSS4JOutInterceptor(outProps));
		endpoint.getInInterceptors().add(new WSS4JInInterceptor(inProps));
		endpoint.getInInterceptors().add(coverageChecker);
	}

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		SpringBusFactory bf = new SpringBusFactory();
		URL busFile = PublishService.class.getResource("wssec.xml");
		Bus bus = bf.createBus(busFile.toString());
		BusFactory.setDefaultBus(bus);
		publishWS();
		System.out.println("Server ready...");
		// bus.shutdown(true);
		// System.out.println("Server exiting");
		// System.exit(0);
	}

}
