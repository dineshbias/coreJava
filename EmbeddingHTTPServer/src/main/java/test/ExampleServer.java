/**
 * 
 */
package test;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;

import test.handlers.ExampleHandler;

/**
 * @author edinjos
 *
 */
public class ExampleServer {

	/**
	 * 
	 */
	public ExampleServer() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server = new Server(8080);
		
		ContextHandler context = new ContextHandler();
		context.setContextPath("/dinesh");
		context.setResourceBase(".");
		context.setClassLoader(Thread.currentThread().getContextClassLoader());
		context.setHandler(new ExampleHandler());
		
		server.setHandler(context);
		try {
			server.join();
			server.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

