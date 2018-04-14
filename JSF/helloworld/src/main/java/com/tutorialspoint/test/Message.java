/**
 * 
 */
package com.tutorialspoint.test;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * @author edinjos
 *
 */
@ManagedBean(name = "message", eager = true)
@RequestScoped
public class Message {

	private String message = "Hello World";

	public String getMessage() {
		System.out.println("Message returning.");
		return message;
	}

	public void setMessage(String message) {
		System.out.println("Message set.");
		this.message = message;
	}

	public Message() {
		System.out.println("Message Instantiated.");
	}

}
