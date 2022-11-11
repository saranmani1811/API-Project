package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Assert;

import com.base.BaseClass;
import com.pojo.Login_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

/**
 * @author Lenovo
 * @Description To Login the Swagger UI
 * @Date 22/08/2022
 */

public class TC1_LoginStep extends BaseClass {

	Response response;

	public static String logtoken;
	public int statusCode;

	Login_Output_Pojo loginOutputPojo = new Login_Output_Pojo();

	/**
	 * @Description Used to add the header
	 */
	@Given("User should add header")
	public void user_should_add_header() {
		addHeader("accept", "application/json");
	}

	/**
	 * @Description Used to add basic authentication
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@When("User should add basic authentication for login")
	public void user_should_add_basic_authentication_for_login() throws FileNotFoundException, IOException {
		basicAuth(getPropertyValueConfig("userName"), getPropertyValueConfig("password"));
	}
	
	/**
	 * @Description Used to send requestType and endpoint
	 * @param string
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@When("User should send {string} request to login endpoint")
	public void user_should_send_request_to_login_endpoint(String string) throws FileNotFoundException, IOException {
		response = requestType("POST", getPropertyValueEndPoints("basicAuthEndpoint"));

	}

	/**
	 * @Description Used to Verify the user FirstName and save logtoken
	 * @param firstName
	 */
	@Then("User should verify the login response body firstName present as {string} and get the logtoken saved")
	public void user_should_verify_the_login_response_body_firstName_present_as_and_get_the_logtoken_saved(
			String firstName) {

		Assert.assertEquals(firstName, "Mani", "Verify the First Name");

		Login_Output_Pojo Login_Output_Pojo = response.as(Login_Output_Pojo.class);

		logtoken = Login_Output_Pojo.getData().getLogtoken();

	}

}
