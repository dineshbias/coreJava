package com.tutorialspoint.test;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "helloWorld", eager = true)
@RequestScoped
public class HelloWorld {

	@ManagedProperty(value = "#{message}")
	private com.tutorialspoint.test.Message messageBean;

	private String message;

	public HelloWorld() {
		System.out.println("HelloWorld started!");
	}

	public String getMessage() {
		System.out.println("HelloWorld getMessage called");
		if (null != messageBean) {
			message = messageBean.getMessage();
		}
		return message;
	}

	public void setMessageBean(Message message) {
		System.out.println("HelloWorld setMessageBean called");
		this.messageBean = message;
	}
}
