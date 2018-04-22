/**
 *
 */
package test.objectToxml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import test.xmlToObject.Customer;

/**
 * @author edinjos
 *
 */
public class JAXBExample {

	/**
	 *
	 */
	public JAXBExample() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		customer.setName("Dinesh Joshi");
		customer.setAge(30);
		customer.setId(7878);
		File file = new File("/home/edinjos/text2.xml");
		try {
			JAXBContext ctx = JAXBContext.newInstance(Customer.class);
			Marshaller jaxbMarshaller = ctx.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(customer, file);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
