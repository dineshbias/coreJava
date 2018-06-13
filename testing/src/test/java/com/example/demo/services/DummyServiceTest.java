/**
 * 
 */
package com.example.demo.services;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.ArgumentMatchers.anyString;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import com.example.demo.repositories.DummyRepository;

/**
 * @author dinesh.joshi
 * @RunWith(MockitoJUnitRunner.class) or Mockito.initMocks(this) is used to
 *                                    intialize the mocks.
 */
@RunWith(MockitoJUnitRunner.class)
public class DummyServiceTest {

	/*
	 * @InjectMocks: This tells Mockito which class to inject mocks into:
	 */
	@InjectMocks
	DummyService dummyService;

	/*
	 * @Mock: Which specific methods or objects inside the class, in this case
	 * DummyService, will be substituted with mocks. In case of Mock Call to
	 * real method is not made.
	 */
	@Mock
	private DummyRepository repository;

	/*
	 * In case of spy. calls to methods of spied objects will be made although
	 * method output is not considered. It is like spying on an object. What all
	 * is happening inside methods of object being spied upon.
	 */
	// @Spy
	// private DummyRepository repository;

	@Test
	public void dummyServicingTest() {

		System.out.println("Test dummyServicingTest");

		Mockito.when(repository.insertDummyData(anyString())).thenReturn(103);

		Mockito.when(repository.getUser(anyString())).thenReturn(new User("Dhampu", "Pampu", new Role("Admin")));

		repository.insertDummyData("Test");

		String actualResponse = dummyService.dummyServicing("M.J. Akbar");

		assertArrayEquals(new Object[] { "M.J. Akbar".toLowerCase() }, new Object[] { actualResponse });

	}

	@Test
	public void dummyServicingSpyTest() {

		System.out.println("Test dummyServicingSpyTest");

		Mockito.when(repository.insertDummyData(anyString())).thenReturn(202);
		Mockito.when(repository.getUser(anyString())).thenReturn(new User("Dhampu", "Pampu", new Role("Admin")));

		String actualResponse = dummyService.dummyServicing("M.J. Akbar");

		assertArrayEquals(new Object[] { "M.J. Akbar".toLowerCase() }, new Object[] { actualResponse });

	}

}
