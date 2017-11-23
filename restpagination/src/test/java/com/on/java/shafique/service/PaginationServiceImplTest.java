/*
 * Copyright (c) 2017, 2018, AVIVA and its affiliates. All rights reserved.
 * AVIVA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */
package com.on.java.shafique.service;

import static org.hamcrest.CoreMatchers.containsString;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import com.jayway.restassured.RestAssured;

/**
 * Represent the PaginationService api implementation Test class.
 * 
 * @author Shafique Mohammed
 * 
 */
@RunWith(JUnit4ClassRunner.class)
public class PaginationServiceImplTest {

	@BeforeClass
	public static void setup() {
		RestAssured.port = Integer.valueOf(8080);
		String basePath = "/restpagination/pagination/";
		RestAssured.basePath = basePath;
		String baseHost = "http://localhost";
		RestAssured.baseURI = baseHost;

	}

	@Test
	public void getFirstPaageWith_10Records_200k() {
		RestAssured.given().when().get("/ps/numbers?startIndex=1&size=10").then().statusCode(200);
	}

	@Test
	public void getInternalServerError_500() {
		RestAssured.given().when().get("/ps/numbers?startIndex=1&size=-10").then().statusCode(500);
	}

	@Test
	public void checkPage1bodyContainsNumberBetween1_10() {
		RestAssured.given().when().get("/ps/numbers?startIndex=1&size=10").then().body(containsString("1"));
	}

}
