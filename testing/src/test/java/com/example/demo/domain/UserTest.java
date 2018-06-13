/**
 * 
 */
package com.example.demo.domain;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author dinesh.joshi
 *
 */
public class UserTest {

	@BeforeClass
	public static void testBeforeClass() {
		System.out.println("Test testBeforeClass ");
	}

	@Before
	public void testBefore() {
		System.out.println("Test testBefore");
	}

	@After
	public void testAfter() {
		System.out.println("Test testAfter");
	}

	@AfterClass
	public static void testAfterClass() {
		System.out.println("Test testAfterClass");
	}

	/**
	 * 
	 */
	@Test
	public void testUserCreation() {

		System.out.println("Test testUserCreation");

		String[] expectedResponse = { "Dinesh", "Joshi", "Admin" };
		User user = new User(expectedResponse[0], expectedResponse[1], new Role(expectedResponse[2]));

		assertNotNull(user);

		String[] actualRespone = { user.getFirstName(), user.getLastName(), user.getRole().getRoleName() };
		assertArrayEquals(expectedResponse, actualRespone);
	}

	@Test
	public void testDummy() {
		System.out.println("Test testDummy.. Won't test anything");

	}

}
