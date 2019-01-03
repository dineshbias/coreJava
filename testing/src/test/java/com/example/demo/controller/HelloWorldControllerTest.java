/**
 * 
 */
package com.example.demo.controller;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.services.DummyService;
import com.example.demo.services.SimpleService;
import com.example.demo.util.Helper;

/**
 * @author dinesh.joshi
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class HelloWorldControllerTest {

	@Mock
	private SimpleService simpleService;

	@Mock
	private DummyService dummyService;

	@Mock
	private Helper helper;

	@InjectMocks
	HelloWorldController controller;

	@Test
	public void testGetHelloWorld() {

		Mockito.when(dummyService.dummyServicing(anyString())).thenReturn("Dummy");

		String actualResponse = controller.getHelloWorld("Dinesh");

		assertArrayEquals(new Object[] { "Hello " + "Dinesh" }, new Object[] { actualResponse });

	}

	@Test
	public void testTestUtil() {
		String actualResponse = controller.testUtil("Ramesh");
		assertArrayEquals(new Object[] { "Hello " + "Ramesh" }, new Object[] { actualResponse });
	}

	@Test
	public void testDoNothing() {
		controller.doNothing("1", "Dinesh");
		verify(helper, times(1)).testDoNothing();
	}
}
