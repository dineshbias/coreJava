/**
 * 
 */
package test.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

/**
 * @author edinjos
 *
 */
public class ExampleContextHandler extends AbstractHandler {

	/**
	 * 
	 */
	public ExampleContextHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(String target, Request baseRequest,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("Entering " + this);
		response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        baseRequest.setHandled(true);
        response.getWriter().println("<h1>Hello World ExampleContextHandler</h1>");
		
	}

}
