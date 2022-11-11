package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.base.BaseClass;
import com.pojo.ChangeProfilePic_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

/**
 * @author Lenovo
 * @Description Used to ChangeProfile Picture
 * @Date 21/08/2022
 */
public class TC3_ProfilePicture extends BaseClass {

	Response response;

	/**
	 * @Description Used to add headers
	 */
	@Given("User should add headers including multipart-form_data")
	public void user_should_add_headers_including_multipart_form_data() {
		List<Header> header = new ArrayList<Header>();
		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer " + TC1_LoginStep.logtoken);
		Header h3 = new Header("Content-Type", "multipart/form-data");

		header.add(h1);
		header.add(h2);
		header.add(h3);

		Headers headers = new Headers(header);
		addHeaders(headers);
	}

	/**
	 * @Description Used to multipart-formdata
	 */
	@When("User should pass form-data")
	public void user_should_pass_form_data() {
		formData();
	}

	/**
	 * @Description Used to send ReuestType and Endpoint
	 * @param POST
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@When("User should send {string} request to UpdateProfilePic endpoint")
	public void user_should_send_request_to_UpdateProfilePic_endpoint(String POST)
			throws FileNotFoundException, IOException {
		response = requestType(POST, getPropertyValueEndPoints("changeProfilePic"));

	}

	/**
	 * @Description Verify the Updated ProfilePicture Message
	 * @param expUpdatedPictureMsg
	 */
	@Then("User should verify the updateProfilePic response body message matches {string}")
	public void user_should_verify_the_updateProfilePic_response_body_message_matches(String expUpdatedPictureMsg) {
		ChangeProfilePic_Output_Pojo changeProfilePicOutputPojo = response.as(ChangeProfilePic_Output_Pojo.class);

		String actUpdatedpictureMsgMessage = changeProfilePicOutputPojo.getMessage();
		System.out.println(actUpdatedpictureMsgMessage);

		Assert.assertEquals(actUpdatedpictureMsgMessage, expUpdatedPictureMsg, "Verify Change Profile Picture Message");

	}

}
