/**
 * 
 */
package ocp.design;

import ocp.design.cache.LRUCache;

/**
 * @author dinesh.joshi
 *
 */
public class TestLRUCache {

	/**
	 * 
	 */
	public TestLRUCache() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User user1 = new User(1, "Dinesh", "Joshi", 33);
		User user2 = new User(2, "Bhuwan", "Joshi", 30);
		User user3 = new User(3, "Maya", "Joshi", 38);
		User user4 = new User(4, "Mitansh", "Joshi", 1);
		User user5 = new User(5, "Tara", "Joshi", 22);

		LRUCache<Integer, User> userCache = LRUCache.getInstance(3);
		userCache.put(user1.getId(), user1);
		userCache.put(user2.getId(), user2);
		userCache.get(1);
		userCache.put(user3.getId(), user3);
		System.out.println(userCache);

		userCache.put(user4.getId(), user4);
		System.out.println(userCache);

		userCache.put(user5.getId(), user5);
		System.out.println(userCache);
	}

}

class User {
	private int id;
	private String firstName;
	private String lastName;
	private int age;

	public User(int id, String firstName, String lastName, int age) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}