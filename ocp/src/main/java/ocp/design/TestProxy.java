/**
 * 
 */
package ocp.design;

import java.lang.reflect.Proxy;

import ocp.design.proxy.OwnerInvocationHandler;
import ocp.design.proxy.PersonBean;
import ocp.design.proxy.PersonBeanImpl;

/**
 * @author dinesh.joshi
 *
 */
public class TestProxy {

	public static void main(String... args) {
		TestProxy test = new TestProxy();

		test.testDrive();
	}

	public void testDrive() {
		PersonBean joe = new PersonBeanImpl("joe", "Male", "Dating", 1);

		PersonBean ownerProxy = getOwnerProxyBean(joe);
		System.out.println("Name is : " + ownerProxy.getName());
		ownerProxy.setInterests("bowling");
		System.out.println("Interest set for owner proxy : " + ownerProxy.getName());

		System.out.println("Rating " + ownerProxy.getHotOrNotRating());

		try {
			ownerProxy.setHotOrNotRating(45);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Rating " + ownerProxy.getHotOrNotRating());
	}

	public static PersonBean getOwnerProxyBean(PersonBean personBean) {
		return (PersonBean) Proxy.newProxyInstance(personBean.getClass().getClassLoader(),
				personBean.getClass().getInterfaces(), new OwnerInvocationHandler(personBean));
	}
}
