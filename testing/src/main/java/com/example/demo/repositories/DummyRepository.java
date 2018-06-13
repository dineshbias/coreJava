/**
 * 
 */
package com.example.demo.repositories;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;

/**
 * @author dinesh.joshi
 *
 */
@Repository
public class DummyRepository {

	public int insertDummyData(String record) {
		System.out.println(this + " insertDummyData. record.. " + record);
		return 10;
	}

	public User getUser(String record) {
		System.out.println(this + " getUser. record.. " + record);
		return new User(record, "default", new Role("Admin"));
	}

}
