package com.APIAutomation._04_RA_HTTP_Methods.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

/**
 * This class demonstrates a GET API test
 * written using Rest Assured BDD (Behaviour Driven Development) style.
 */
public class ApiTest08_GET_BDDStyle {

    /**
     * Test method for positive GET request scenario.
     * Scenario: A valid Indian pincode is provided.
     */
    @Test
    public void test_GET_BDD_Positive_TC1() {

        // Test data: valid Indian pincode
        String pincode = "475673";

        // BDD-style API test using Rest Assured
        RestAssured
                .given() // GIVEN: request preconditions (URI, headers, params)
                    .baseUri("https://api.zippopotam.us/") // Base URL of the API
                    .basePath("/IN/" + pincode) // Endpoint with dynamic pincode
                .when() // WHEN: the request is executed
                    .log().all() // Logs request details to console
                    // Console Output: Request URI, headers, and method
                    .get() // Executes HTTP GET request
                .then() // THEN: validate the response
                    .log().all() // Logs response details to console
                    // Console Output: Response body, headers, and status
                    .statusCode(200); // Assertion: HTTP status code should be 200
    }
}
