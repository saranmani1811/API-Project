package com.stepdefinition;

import org.testng.Assert;

import com.base.BaseClass;

import io.cucumber.java.en.Then;

/**
 * 
 * @author Lenovo
 * @Description To Verify the Status Code
 * @Date 21/08/2022
 */

public class CommonStep extends BaseClass {

	/**
	 * 
	 * @param statusCode
	 */
	@Then("User should verify the status code is {int}")
	public void user_should_verify_the_status_code_is(Integer statusCode) {

		String expStatusCode = String.valueOf(statusCode);

		// Assert.assertEquals(statusCode, expStatusCode, "Verify Status Code");

	}

}
