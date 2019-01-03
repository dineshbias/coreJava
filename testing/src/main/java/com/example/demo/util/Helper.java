/**
 * 
 */
package com.example.demo.util;

import org.springframework.stereotype.Component;

/**
 * @author dinesh.joshi
 *
 */
@Component
public class Helper {

	private String helper;

	public void doSomething() {
		System.out.println(this + " public void doSomething");
	}

	public void doSomethingWithInput(String input) {
		System.out.println(this + " public void doSomethingWithInput");
		helper = input.toLowerCase();
	}

	public String manipulateAndReturn(String input) {
		System.out.println(this + " public void manipulateAndReturn");
		input = helper;
		return input;
	}

	public void testDoNothing() {
		System.out.println(this + " public void testDoNothing");
	}
}
