/**
 *
 */
package test.xmlToObject;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

/**
 * @author edinjos
 *
 */
public class JAXBExample {

	/**
	 *
	 */
	public JAXBExample() {
		System.out.println("****************");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
        File file ;
		file = new File("/home/edinjos/text.xml");
		JAXBContext ctx ;
		try {
			ctx = JAXBContext.newInstance(Customer.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			System.out.println("jaxb context couldn't be created");
			System.out.println("..."+e);
			return;
		}

		Unmarshaller jaxbUnMarshaller;

		try {
			jaxbUnMarshaller = ctx.createUnmarshaller();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			System.out.println("jaxbUnMarshaller couldn't be created");
			System.out.println("..."+e);
			return;
		}
		Customer customer;
		try {
			//Object obj = jaxbUnMarshaller.unmarshal(file);
			customer = (Customer)jaxbUnMarshaller.unmarshal(file);

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			System.out.println("jaxbUnMarshaller couldn't unmarshall file");
			System.out.println("..."+e);
			return;
		}
		System.out.println(customer.toString());
		System.out.println( file.getPath());
	}
}
