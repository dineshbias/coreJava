/**
 * 
 */
package ocp.design.pool;

/**
 * @author dinesh.joshi
 *
 */
public class Sample {

	private static ObjectPool<ExternalService> extServicePool;

	private int count;

	static {

		extServicePool = new ObjectPool<ExternalService>(20, 20, 1) {

			@Override
			protected ExternalService createObject() {
				return new ExternalService("http:google.com");
			}
		};

		System.out.println("Static Block Loaded");
	}

	public Sample(int count) {
		super();
		this.count = count;
	}

	public void processRequest() {
		ExternalService extService = extServicePool.borrowObject();
		extService.call(count);
		extServicePool.returnObject(extService);
	}
}
