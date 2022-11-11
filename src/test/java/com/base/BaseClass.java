package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	RequestSpecification reqSpec;
	Response response;

	public void basicAuth(String userName, String password) {
		reqSpec = reqSpec.auth().preemptive().basic(userName, password);
	}

	public void addHeader(String key, String value) {
		reqSpec = RestAssured.given().header(key, value);
	}

	public void queryParam(String key, String value) {
		reqSpec = reqSpec.queryParam(key, value);
	}

	public void pathParam(String key, String value) {
		reqSpec = reqSpec.pathParam(key, value);
	}

	public void addBody(String body) {
		reqSpec = reqSpec.body(body);
	}

	public Response requestType(String type, String endPoint) {
		switch (type) {
		case "GET":
			response = reqSpec.get(endPoint);
			break;
		case "POST":
			response = reqSpec.post(endPoint);
			break;
		case "PUT":
			response = reqSpec.put(endPoint);
			break;
		case "DELETE":
			response = reqSpec.delete(endPoint);
			break;
		default:
			break;
		}
		return response;
	}

	public int getStatusCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;
	}

	public String getBodyAsString(Response response) {
		String asString = response.asString();
		return asString;
	}

	public String getBodyAsPrettyString(Response response) {
		String asPrettyString = response.asPrettyString();
		return asPrettyString;
	}

	public void addHeaders(Headers headers) {
		reqSpec = RestAssured.given().headers(headers);
	}

	public void addBody(Object body) {
		reqSpec = reqSpec.body(body);
	}

	public static String getPropertyValueConfig(String key) throws FileNotFoundException, IOException {
		Properties pro = new Properties();
		pro.load(new FileInputStream(System.getProperty("user.dir") + "//config//config.properties"));
		Object object = pro.get(key);
		String value = (String) object;
		return value;

	}
	
	public String getPropertyValueEndPoints(String key) throws FileNotFoundException, IOException {
		Properties pro = new Properties();
		pro.load(new FileInputStream(System.getProperty("user.dir") + "//target//Endpoints//EndPoints.properties"));
		Object object = pro.get(key);
		String value = (String) object;
		return value;

	}

	//(Key-->profile_picture from swagger UI and Value-->location of the image )
		public void formData()  {
			reqSpec=reqSpec.multiPart("profile_picture",new File("C://Users//Lenovo//Pictures//Camera Roll//cat.jpg"));
		}
		
}
