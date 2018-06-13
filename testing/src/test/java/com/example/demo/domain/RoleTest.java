/**
 * 
 */
package com.example.demo.domain;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * @author dinesh.joshi
 *
 */
public class RoleTest {

	@Test
	public void testRoleCreation() {
		System.out.println("Test testRoleCreation");
		Role role = new Role("Tester");

		assertArrayEquals(new Object[] { "Tester" }, new Object[] { role.getRoleName() });
	}
}
