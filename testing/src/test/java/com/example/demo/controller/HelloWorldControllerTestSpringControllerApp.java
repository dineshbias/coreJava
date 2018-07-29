/**
 * 
 */
package com.example.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIOException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.services.SimpleService;
import com.example.demo.util.Helper;

/**
 * @author dinesh.joshi
 *
 */
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class HelloWorldControllerTestSpringControllerApp {

	@MockBean
	private Helper helper;

	@MockBean
	private SimpleService simpleService;

	@Autowired
	private MockMvc mockMvc;

	@Value("classpath:user.json")
	Resource userRequest;

	@Value("classpath:userResponse.json")
	Resource userResponse;

	@Before
	public void setupMock() {
		System.out.println("---------------Test setupMock-------------");
	}

	@Test
	public void testHandlePathAndRequestParams() {
		System.out.println("---------------Test testHandlePathAndRequestParams-------------");

		try {
			String id = "1";
			String name = "Dinesh";

			ResultActions resultActions = mockMvc
					.perform(MockMvcRequestBuilders.get("/user/" + id).param("username", name));
			String actualResponse = resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andReturn()
					.getResponse().getContentAsString();
			assertThat(id + " " + name).isEqualTo(actualResponse);

		} catch (Exception e) {
			System.out.println(e);
			assertThatIOException();
		}
	}

	@Test
	public void testHHandlePathAndRequestBody() {
		System.out.println("---------------Test testHandlePathAndRequestBody-------------");

		try {

			ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/user/create")
					.contentType(MediaType.APPLICATION_JSON).content(readFully(userRequest.getInputStream())));

			String actualResponse = resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andReturn()
					.getResponse().getContentAsString();
			assertThat(new String(readFully(userResponse.getInputStream()))).isEqualTo(actualResponse);

		} catch (Exception e) {
			System.out.println(e);
			assertThatIOException();
		}
	}

	private byte[] readFully(InputStream input) throws IOException {
		byte[] buffer = new byte[8192];
		int bytesRead;
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		while ((bytesRead = input.read(buffer)) != -1) {
			output.write(buffer, 0, bytesRead);
		}
		return output.toByteArray();
	}
}
