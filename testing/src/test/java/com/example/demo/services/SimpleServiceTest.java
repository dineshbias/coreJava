package com.example.demo.services;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.repositories.DummyRepository;

@RunWith(MockitoJUnitRunner.class)
public class SimpleServiceTest {

	@InjectMocks
	private SimpleService sService;

	@Mock
	private DummyRepository repository;

	@Mock
	private DummyService dummyService;

	@Test
	public void simpleServicingTest() {
		System.out.println("Test simpleServicingTest");
		String actualResponse = sService.simpleServicing("Hello...");

		assertArrayEquals(new Object[] { "Hello...".toLowerCase() }, new Object[] { actualResponse });
	}

}
