/**
 * 
 */
package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.repositories.DummyRepository;

/**
 * @author dinesh.joshi
 *
 */
@Service
public class DummyService {

	@Autowired
	private DummyRepository repository;

	public String dummyServicing(String greeting) {
		System.out.println(this + " dummyServicing.." + greeting);

		int result = repository.insertDummyData(greeting);
		System.out.println(this + " dummyServicing.." + result);
		if (result == 0)
			throw new RuntimeException();

		User resp = repository.getUser(greeting);
		System.out.println(this + " dummyServicing.." + resp);
		if (null == resp)
			throw new RuntimeException();

		return greeting.toLowerCase();
	}

}
