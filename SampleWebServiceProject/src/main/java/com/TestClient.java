package com;

import java.lang.reflect.UndeclaredThrowableException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.bus.spring.SpringBusFactory;
import org.apache.cxf.ws.security.wss4j.DefaultCryptoCoverageChecker;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;

import com.client.atm.ATMAtmcashoutPortType;
import com.client.atm.ATMAtmcashoutService;
import com.client.atm.Atmcashoutrequest;
import com.client.atm.Atmcashoutresponse;
import com.sun.xml.internal.ws.Closeable;

public class TestClient {
	
	private static final String WSSE_NS = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";
	private static final String WSU_NS = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd";
	private static Map<String, Object> outProps = new HashMap<String, Object>();
	private static Map<String, Object> inProps = new HashMap<String, Object>();
	private static DefaultCryptoCoverageChecker coverageChecker = new DefaultCryptoCoverageChecker();

	static {
		outProps.put("action", "UsernameToken Timestamp Signature Encrypt");
		outProps.put("passwordType", "PasswordDigest");
		outProps.put("passwordCallbackClass", "com.UTPasswordCallback");
		outProps.put("user", "abcd");
		outProps.put("signatureUser", "clientx509v1");

		outProps.put("encryptionUser", "serverx509v1");
		outProps.put("encryptionPropFile", "etc/Client_Encrypt.properties");
		outProps.put("encryptionKeyIdentifier", "IssuerSerial");
		outProps.put("encryptionParts", "{Element}{" + WSSE_NS
				+ "}UsernameToken;"
				+ "{Content}{http://schemas.xmlsoap.org/soap/envelope/}Body");

		outProps.put("signaturePropFile", "etc/Client_Sign.properties");
		outProps.put("signatureKeyIdentifier", "DirectReference");
		outProps.put("signatureParts", "{Element}{" + WSU_NS + "}Timestamp;"
				+ "{Element}{http://schemas.xmlsoap.org/soap/envelope/}Body;"
				+ "{}{http://www.w3.org/2005/08/addressing}ReplyTo;");

		outProps.put("encryptionKeyTransportAlgorithm",
				"http://www.w3.org/2001/04/xmlenc#rsa-oaep-mgf1p");
		outProps.put("signatureAlgorithm",
				"http://www.w3.org/2000/09/xmldsig#rsa-sha1");

		inProps.put("action", "UsernameToken Timestamp Signature Encrypt");
		inProps.put("passwordType", "PasswordText");
		inProps.put("passwordCallbackClass", "com.UTPasswordCallback");

		inProps.put("decryptionPropFile", "etc/Client_Sign.properties");
		inProps.put("encryptionKeyIdentifier", "IssuerSerial");

		inProps.put("signaturePropFile", "etc/Client_Encrypt.properties");
		inProps.put("signatureKeyIdentifier", "DirectReference");

		inProps.put("encryptionKeyTransportAlgorithm",
				"http://www.w3.org/2001/04/xmlenc#rsa-oaep-mgf1p");
		inProps.put("signatureAlgorithm",
				"http://www.w3.org/2000/09/xmldsig#rsa-sha1");

		// Check to make sure that the SOAP Body and Timestamp were signed,
		// and that the SOAP Body was encrypted

		coverageChecker.setSignBody(true);
		coverageChecker.setSignTimestamp(true);
		coverageChecker.setEncryptBody(true);

	}

	public static void main(String[] args) throws Exception {
		try {

			SpringBusFactory bf = new SpringBusFactory();
			URL busFile = PublishService.class.getResource("wssec.xml");
			Bus bus = bf.createBus(busFile.toString());
			BusFactory.setDefaultBus(bus);

			ATMAtmcashoutService service = new ATMAtmcashoutService();
			ATMAtmcashoutPortType port = service.getATMAtmcashoutPort();
			org.apache.cxf.endpoint.Client client = org.apache.cxf.frontend.ClientProxy
					.getClient(port);

			client.getInInterceptors().add(new WSS4JInInterceptor(inProps));
			client.getOutInterceptors().add(new WSS4JOutInterceptor(outProps));
			client.getInInterceptors().add(coverageChecker);

			System.out.println("Invoking Atmcashoutrequest...");
			Atmcashoutrequest req = new com.client.atm.Atmcashoutrequest();
			Atmcashoutresponse response = port.atmcashout(req);
			System.out.println("response: " + response + "\n");

			if (port instanceof Closeable) {
				((Closeable) port).close();
			}

			bus.shutdown(true);

		} catch (UndeclaredThrowableException ex) {
			ex.getUndeclaredThrowable().printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			System.exit(0);
		}
	}

}
