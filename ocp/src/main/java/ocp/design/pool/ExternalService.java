/**
 * 
 */
package ocp.design.pool;

/**
 * @author dinesh.joshi
 *
 */
public class ExternalService {

	private final String url;

	public ExternalService(String url) {
		System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId()
				+ " ExternalService instantiated");
		this.url = url;
	}

	public String call(int count) {
		System.out.println(
				Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " call enter:" + count);

		try {
			Thread.sleep(600);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return "Dummy Called with url " + url;
	}
}
