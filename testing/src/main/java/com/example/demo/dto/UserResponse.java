/**
 * 
 */
package com.example.demo.dto;

import com.example.demo.domain.User;

/**
 * @author dinesh.joshi
 *
 */
public class UserResponse {

	private User user;
	private String id;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
