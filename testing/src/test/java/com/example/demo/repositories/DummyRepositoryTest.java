/**
 * 
 */
package com.example.demo.repositories;

import static org.junit.Assert.assertArrayEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;

/**
 * @author dinesh.joshi
 *
 */
public class DummyRepositoryTest {

	private DummyRepository dummyRepository;

	@Before
	public void initializeObject() {
		System.out.println("Test initializeObject | @Before");
		dummyRepository = new DummyRepository();
	}

	@After
	public void releaseObject() {
		System.out.println("Test releaseObject | @After");
		dummyRepository = null;
	}

	@Test
	public void insertDummyDataTest() {
		System.out.println("Test insertDummyDataTest");

		String record = "testRecord";
		int i = dummyRepository.insertDummyData(record);

		assertArrayEquals(new int[] { 10 }, new int[] { i });
	}

	@Test
	public void getUserTest() {
		System.out.println("Test getUserTest");

		String record = "testRecord";
		User actualResponse = dummyRepository.getUser(record);

		assertArrayEquals(new Object[] { new User(record, "default", new Role("Admin")) },
				new Object[] { actualResponse });
	}

}
