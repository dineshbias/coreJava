/**
 * 
 */
package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.DummyRepository;

/**
 * @author dinesh.joshi
 *
 */
@Service
public class SimpleService {

	@Autowired
	private DummyRepository repository;

	@Autowired
	private DummyService dummyService;

	public String simpleServicing(String greeting) {
		System.out.println(this + " simpleServicing.." + greeting);

		repository.getUser(greeting);

		dummyService.dummyServicing(greeting);

		return greeting.toLowerCase();
	}

}
