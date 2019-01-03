/**
 * 
 */
package com.example.demo.controller;

import java.text.SimpleDateFormat;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.dto.UserResponse;
import com.example.demo.services.DummyService;
import com.example.demo.services.SimpleService;
import com.example.demo.util.Helper;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author dinesh.joshi
 *
 */
@RestController
public class HelloWorldController {

	private DummyService dummyService;

	private Helper helper;

	private SimpleService simpleService;

	public HelloWorldController(DummyService dummyService, SimpleService simpleService, Helper helper) {
		this.dummyService = dummyService;
		this.simpleService = simpleService;
		this.helper = helper;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getHelloWorld(@RequestParam("name") final String name) {

		System.out.println(this + " getHelloWorld " + name);

		String nameT = dummyService.dummyServicing(name);
		if (null == nameT || nameT.isEmpty())
			throw new RuntimeException();

		return "Hello " + name;

	}

	@RequestMapping(value = "/util", method = RequestMethod.GET)
	public String testUtil(@RequestParam("name") final String name) {

		System.out.println(this + " testUtil " + name);

		helper.doSomething();
		helper.doSomethingWithInput(name);
		String s = simpleService.simpleServicing(name);
		return "Hello " + name;

	}

	@RequestMapping(value = "/user/{id}")
	public String handlePathAndRequestParams(@PathVariable(value = "id") String id,
			@RequestParam(value = "username", required = false) String username) {
		System.out.println(this + " handlePathAndRequestParams " + id + " " + username);

		helper.doSomething();
		helper.doSomethingWithInput(username);

		String nameT = dummyService.dummyServicing(username);
		if (null == nameT) {
			throw new RuntimeException();
		}

		simpleService.simpleServicing(username);

		return id + " " + username;
	}

	@RequestMapping(value = "/user/create", produces = "application/json; charset=UTF-8", consumes = "application/json; charset=UTF-8", method = RequestMethod.POST)
	public @ResponseBody String handlePathAndRequestBody(@RequestBody final User user) {

		System.out.println(this + " handlePathAndRequestBody ");

		System.out.println(user);

		helper.doSomething();

		String nameT = dummyService.dummyServicing(user.getFirstName());
		if (null == nameT) {
			throw new RuntimeException();
		}

		simpleService.simpleServicing(user.getFirstName());

		UserResponse response = new UserResponse();
		response.setUser(user);
		response.setId("001");
		return toJSON(response);

	}

	@RequestMapping(value = "/user/doNothing/{id}")
	public String doNothing(@PathVariable(value = "id") String id,
			@RequestParam(value = "username", required = false) String username) {
		System.out.println(this + " handlePathAndRequestParams " + id + " " + username);

		helper.testDoNothing();

		simpleService.simpleServicing(username);

		return id + " " + username;
	}

	public String toJSON(Object obj) {

		if (obj == null)
			return null;

		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.setDateFormat(new SimpleDateFormat("MMM dd, yyyy hh:mm:ss a"));
			mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
			return mapper.writeValueAsString(obj);
		} catch (Throwable e) {

			throw new RuntimeException("Error serializing the object");
		}
	}

}
