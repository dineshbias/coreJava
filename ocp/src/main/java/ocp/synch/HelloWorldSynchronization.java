/**
 * 
 */
package ocp.synch;

/**
 * @author dinesh.joshi
 *
 */
public class HelloWorldSynchronization {

	private static int i;

	String s = "MUTEX";

	public synchronized static void test1() {
		System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId()
				+ " test1:Class Lock :" + Thread.holdsLock(HelloWorldSynchronization.class));
		System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " test1:sleep");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " test1:awake");
	}

	public synchronized void test2() {
		System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId()
				+ " test2:Object Lock :" + Thread.holdsLock(this));
		System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId()
				+ " test2:Class Lock :" + Thread.holdsLock(HelloWorldSynchronization.class));
		System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " test2:sleep");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " test2:awake");
	}

	public void test3() {
		System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId()
				+ " test3:Object Lock :" + Thread.holdsLock(this));
		System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId()
				+ " test3:Class Lock :" + Thread.holdsLock(HelloWorldSynchronization.class));
		System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " test3.sleep");
		try {
			synchronized (this) {
				System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId()
						+ " test3: Inside Synchronized");
				System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId()
						+ " test3:Object Lock :" + Thread.holdsLock(this));
				System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId()
						+ " test3:Class Lock :" + Thread.holdsLock(HelloWorldSynchronization.class));
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId()
						+ " test3: Exiting Synchronized");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " test3.awake");
	}

	public void test4() {
		System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId()
				+ " test4:Object Lock :" + Thread.holdsLock(this));
		System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId()
				+ " test4:Class Lock :" + Thread.holdsLock(HelloWorldSynchronization.class));
		System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " test4.sleep");
		try {
			synchronized (s) {
				System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId()
						+ " test4: Inside Synchronized");
				System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId()
						+ " test4:Object Lock on this :" + Thread.holdsLock(this));
				System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId()
						+ " test4:Object Lock on s :" + Thread.holdsLock(s));
				System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId()
						+ " test4:Class Lock :" + Thread.holdsLock(HelloWorldSynchronization.class));
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId()
						+ " test4: Exiting Synchronized");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " test4.awake");
	}

	public void test5() {
		System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId()
				+ " test5:Object Lock :" + Thread.holdsLock(this));

		try {
			synchronized ("deadLock") {
				System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId()
						+ " test5: Inside Synchronized");
				System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId()
						+ " test5:Object Lock on this :" + Thread.holdsLock(this));
				System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId()
						+ " test5:Object Lock on deadLock :" + Thread.holdsLock("deadLock"));
				System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId()
						+ " test5:Class Lock :" + Thread.holdsLock(HelloWorldSynchronization.class));
				Thread.sleep(1000);
				test2();
				System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId()
						+ " test5: Exiting Synchronized");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " test5.awake");
	}

	public synchronized void test6() {
		System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId()
				+ " test6:Object Lock :" + Thread.holdsLock(this));
		System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId()
				+ " test6:Class Lock :" + Thread.holdsLock(HelloWorldSynchronization.class));
		System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " test6.sleep");
		try {
			synchronized ("deadLock") {
				System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId()
						+ " test6: Inside Synchronized");
				System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId()
						+ " test6:Object Lock on this :" + Thread.holdsLock(this));
				System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId()
						+ " test6:Object Lock on s :" + Thread.holdsLock(s));
				System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId()
						+ " test6:Class Lock :" + Thread.holdsLock(HelloWorldSynchronization.class));
				Thread.sleep(10000);
				System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId()
						+ " test6: Exiting Synchronized");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getId() + " test6.awake");
	}

}
