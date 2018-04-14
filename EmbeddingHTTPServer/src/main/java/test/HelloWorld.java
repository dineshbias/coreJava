/**
 * 
 */
package test;

import org.eclipse.jetty.server.Server;

import test.handlers.ExampleHandler;

/**
 * @author edinjos
 *
 */
public class HelloWorld {

	/**
	 * 
	 */
	public HelloWorld() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Server server = new Server(8080);
		server.setHandler(new ExampleHandler());

		try {
			server.start();
			server.join();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
