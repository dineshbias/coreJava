/**
 * 
 */
package ocp.design;

import ocp.design.singleton.StaffRegister;

/**
 * @author edinjos
 *
 */
public class TestSingletone {

	/**
	 * 
	 */
	public TestSingletone() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyRunnableThread mrt1 = new MyRunnableThread(), mrt2 = new MyRunnableThread(), mrt3 = new MyRunnableThread();
		Thread t1 = new Thread(mrt1);
		Thread t2 = new Thread(mrt2);
		Thread t3 = new Thread(mrt3);
		t1.start();
		t2.start();
		t3.start();
	}

}

class MyRunnableThread implements Runnable {

	public MyRunnableThread() {
	}

	public void run() {
		
		try {
			
			Thread.sleep(100);
			StaffRegister sR1 = StaffRegister.getInstance();
			StaffRegister sR2 = StaffRegister.getInstance();
			System.out.println(sR1==sR2);
			Thread.sleep(100);
			System.out.println(sR1);
			System.out.println(sR2);
		} catch (InterruptedException iex) {
			System.out.println("Exception in main thread: " + iex.getMessage());
		}
		
	}
}


