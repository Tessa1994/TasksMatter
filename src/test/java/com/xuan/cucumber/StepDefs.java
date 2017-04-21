package com.xuan.cucumber;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration
public class StepDefs {
	private TestRestTemplate restTemplate = new TestRestTemplate();
	private ResponseEntity<String> response;

	@When("^the client calls /version$")
	public void the_client_issues_GET_version() throws Throwable {
		response = restTemplate.exchange("http://localhost:8080/version", HttpMethod.GET, null, String.class);
	}

	@Then("^the client receives status code of (\\d+)$")
	public void the_client_receives_status_code_of(int statusCode) throws Throwable {
		assertThat(response.getStatusCodeValue()).isEqualTo(statusCode);
	}

	@And("^the client receives server version (.+)$")
	public void the_client_receives_server_version_body(String version) throws Throwable {
		assertThat(response.getBody()).isEqualTo(version);
	}
}
