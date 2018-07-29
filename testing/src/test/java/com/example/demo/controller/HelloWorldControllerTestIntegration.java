/**
 * 
 */
package com.example.demo.controller;

import static org.assertj.core.api.Assertions.assertThatIOException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.MainApplication;

/**
 * @author dinesh.joshi
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloWorldControllerTestIntegration {

	@LocalServerPort
	private int port;

	@Value("classpath:user.json")
	Resource userRequest;

	@Value("classpath:userResponse.json")
	Resource userResponse;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Before
	public void setupMock() {
		System.out.println("---------------Test setupMock-------------");
	}

	@Test
	public void testHandlePathAndRequestParams() {

		System.out.println("---------------\n\n\n\n\n-------------");
		System.out.println("---------------Test testHandlePathAndRequestParams-------------");

		try {

			String id = "1";
			String name = "Dinesh";
			HttpEntity<String> entity = new HttpEntity<String>(null, headers);
			Map<String, String> params = new HashMap<String, String>();
			params.put("username", name);

			ResponseEntity<String> response = restTemplate.exchange(createURLWithPort("/user/1"), HttpMethod.GET,
					entity, String.class, params);

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

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}
