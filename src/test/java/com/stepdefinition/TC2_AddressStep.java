package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import com.base.BaseClass;
import com.pojo.AddUserAddress_Input_Pojo;
import com.pojo.AddUserAddress_Output_Pojo;
import com.pojo.DeleteAddress_Input_Pojo;
import com.pojo.DeleteAddress_Output_Pojo;
import com.pojo.GetUserAddress_Output_Pojo;
import com.pojo.UpdateUserAddress_Input_Pojo;
import com.pojo.UpdateUserAddress_Output_Pojo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

/**
 * @author Lenovo
 * @Description User add,update,get,delete the address
 * @Date 21/08/2022
 */
public class TC2_AddressStep extends BaseClass {

	Response response;

	String addressId;
	
	/**
	 * @Description Used to add headers
	 */

	@Given("User should add headers")
	public void user_should_add_headers() {

		// addHeaders
		List<Header> header = new ArrayList<>();

		Header h1 = new Header("accept", "application/json");
		Header h2 = new Header("Authorization", "Bearer "+TC1_LoginStep.logtoken);
		Header h3 = new Header("Content-Type", "application/json");

		header.add(h1);
		header.add(h2);
		header.add(h3);

		Headers headers = new Headers(header);
		addHeaders(headers);
	}

	/**
	 * @Description User add address data
	 * @param firstName
	 * @param lastName
	 * @param mobile
	 * @param apartment
	 * @param state
	 * @param city
	 * @param country
	 * @param zipcode
	 * @param address
	 * @param address_type
	 */
	@When("User should add required data for adding the address {string}, {string}, {string}, {string}, {int}, {int}, {int}, {string}, {string} and {string}")
	public void user_should_add_required_data_for_adding_the_address_and(String firstName, String lastName,
			String mobile, String apartment, int state, int city, int country, String zipcode, String address,
			String address_type) {

		AddUserAddress_Input_Pojo addUserAddressInputPojo = new AddUserAddress_Input_Pojo(firstName, lastName, mobile,
				apartment, state, city, country, zipcode, address, address_type);

		addBody(addUserAddressInputPojo);

	}

	/**
	 * @Description Used to send RequestType and EndPoints
	 * @param reqType
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@When("User should send {string} request to AddAddress endpoint")
	public void user_should_send_request_to_AddAddress_endpoint(String reqType)
			throws FileNotFoundException, IOException {

		response = requestType("POST",getPropertyValueEndPoints("addUserAddress"));
	}

	/**
	 * @Description Used  Verify ResponseMsg and saved Address Id
	 * @param expAddressAddedResponseMsg
	 */
	@Then("User should verify the addAddress response body message matches {string} and get the address id saved")
	public void user_should_verify_the_addAddress_response_body_message_matches_and_get_the_address_id_saved(
			String expAddressAddedResponseMsg) {

		AddUserAddress_Output_Pojo addUserAddressOutput = response.as(AddUserAddress_Output_Pojo.class);

		String actAddressAddedResponseMsg = addUserAddressOutput.getMessage();
		System.out.println("Adderss Added Response Message :"+actAddressAddedResponseMsg);

		Assert.assertEquals(actAddressAddedResponseMsg, expAddressAddedResponseMsg, "Verify Address Added Response Message");

		int id = addUserAddressOutput.getAddress_id();
		System.out.println("User Address Id : " + id);

		addressId = String.valueOf(id);
	}
	
	/**
	 * @Description Used to update the Address
	 * @param addressId
	 * @param firstName
	 * @param lastName
	 * @param mobile
	 * @param apartment
	 * @param state
	 * @param city
	 * @param country
	 * @param zipcode
	 * @param address
	 * @param address_type
	 */
	@When("User should add required data for updating the address {string}, {string}, {string}, {string}, {int}, {int}, {int}, {string}, {string} and {string}")
	public void user_should_add_required_data_for_updating_the_address_and(String addressId, String firstName,
			String lastName, String mobile, String apartment, int state, int city, int country, String zipcode,
			String address, String address_type) {

		UpdateUserAddress_Input_Pojo updateAddressInput = new UpdateUserAddress_Input_Pojo(addressId, firstName,
				lastName, mobile, apartment, state, city, country, zipcode, address, address_type);

		addBody(updateAddressInput);

	}

	/**
	 * @Description Used to add RequestType and Endpoints
	 * @param string
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@When("User should send {string} request to UpdateAddress endpoint")
	public void user_should_send_request_to_UpdateAddress_endpoint(String string)
			throws FileNotFoundException, IOException {

		response = requestType("PUT", getPropertyValueEndPoints("updateUserAddress"));
	}

	/**
	 * @param expUpdateAddressMessage
	 */
	@Then("User should verify the updateAddress response body message matches {string}")
	public void user_should_verify_the_updateAddress_response_body_message_matches(String expUpdateAddressMessage) {

		UpdateUserAddress_Output_Pojo updateAddressOutput = response.as(UpdateUserAddress_Output_Pojo.class);
		String actUpdateAddressMessage = updateAddressOutput.getMessage();

		Assert.assertEquals(actUpdateAddressMessage, expUpdateAddressMessage, "Verify Updated ResponseBody  Message");

	}

	/**
	 * 
	 * @param string
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@When("User should send {string} request to getAddress endpoint")
	public void user_should_send_request_to_getAddress_endpoint(String string)
			throws FileNotFoundException, IOException {

		response = requestType("GET", getPropertyValueEndPoints("getUserAddress"));

	}

	/**
	 * 
	 * @param expGetAddressMessage
	 */
	@Then("User should verify the getaddress response body message matches {string}")
	public void user_should_verify_the_getaddress_response_body_message_matches(String expGetAddressMessage) {

		GetUserAddress_Output_Pojo getAddressOutput = new GetUserAddress_Output_Pojo();

		String actGetAddressMessage = getAddressOutput.getMessage();

		Assert.assertEquals(actGetAddressMessage, expGetAddressMessage, "Verify the GetAddress Message");
	}

	/**
	 * @Description Used to deletethe address
	 */
	@When("User should add addressId in request body for deleting the address")
	public void user_should_add_addressId_in_request_body_for_deleting_the_address() {

		DeleteAddress_Input_Pojo deleteAddress_Input_Pojo = new DeleteAddress_Input_Pojo(addressId);
		addBody(deleteAddress_Input_Pojo);
	}

	/**
	 * 
	 * @param string
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@When("User should send {string} request to deleteaddress endpoint")
	public void user_should_send_request_to_deleteaddress_endpoint(String string)
			throws FileNotFoundException, IOException {

		response = requestType("DELETE", getPropertyValueEndPoints("deleteAddress"));
	}

	/**
	 * 
	 * @param expDeleteAddressMsg
	 */
	@Then("User should verify the deleteAddress response body message matches {string}")
	public void user_should_verify_the_deleteAddress_response_body_message_matches(String expDeleteAddressMsg) {

		DeleteAddress_Output_Pojo DeleteAddressOutput = new DeleteAddress_Output_Pojo();

		String actDeleteAddressMsg = DeleteAddressOutput.getMessage();

		Assert.assertEquals(actDeleteAddressMsg, expDeleteAddressMsg, "Verify the Delete Address Message");
	}

}
