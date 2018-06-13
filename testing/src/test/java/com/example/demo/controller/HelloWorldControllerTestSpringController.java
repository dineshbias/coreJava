/**
 * 
 */
package com.example.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIOException;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.services.DummyService;
import com.example.demo.services.SimpleService;
import com.example.demo.util.Helper;

/**
 * @author dinesh.joshi This class is used to test Controllers.
 * @WebMvcTest is used to test controllers in isolation and won't load all your
 *             app's beans at all. So all refrenced beans needs to be created as
 *             MockBean main purposes of @WebMvcTest is to automatically
 *             configure a MockMvc instance
 */
@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTestSpringController {

	@MockBean
	private DummyService dummyService;

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
		// BDDMockito.given(dummyService.dummyServicing("Dinesh")).willReturn("Dummy
		// Data");

		Mockito.when(dummyService.dummyServicing(anyString())).thenReturn("Dummy Data");
	}

	@Test
	public void testHandlePathAndRequestParams() {
		System.out.println("---------------Test testHandlePathAndRequestParams-------------");
		assertNotNull(dummyService);
		assertNotNull(helper);
		assertNotNull(simpleService);

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
		assertNotNull(dummyService);
		assertNotNull(helper);
		assertNotNull(simpleService);

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
