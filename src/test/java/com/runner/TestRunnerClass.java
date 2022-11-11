package com.runner;

import org.junit.runner.RunWith;

import com.base.BaseClass;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(dryRun=false,monochrome=true,stepNotifications=true,features = {"src/test/resources" }, glue = "com.stepdefinition")

public class TestRunnerClass extends BaseClass {

	// @AfterClass
	// private void afterClass() throws FileNotFoundException, IOException {
	// Reporting.generateJVMReport(getPropertyValueConfig("jsonPath"));
	// }

}
