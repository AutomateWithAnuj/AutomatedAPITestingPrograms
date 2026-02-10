package com.APIAutomation._03_TestNG_AllureReport;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

/**
 * This class demonstrates running multiple API test cases
 * using TestNG with reusable request logic.
 *
 * Each @Test method represents one independent test case.
 */
public class ApiTest07_RunMulTestCases {

    /**
     * Reusable helper method to execute a GET request.
     * Purpose: Avoids duplicating Rest Assured code in every test.
     *
     * @param pincode           Input pincode used in API path
     * @param expectedStatus   Expected HTTP status code to validate
     */
    private void runGetRequest(String pincode, int expectedStatus) {

        // Rest Assured fluent-style API call
        RestAssured
                .given() // Step 1: Build the request
                .baseUri("https://api.zippopotam.us") // API base URL
                .basePath("/IN/" + pincode) // Country + dynamic pincode
                .when() // Step 2: Trigger the request
                .get() // HTTP GET request
                .then() // Step 3: Validate the response
                .log().all() // Prints full request & response to console
                // Console Output: Headers, body, and status details
                .statusCode(expectedStatus); // Asserts expected status code
    }

    /**
     * Positive test case
     * Scenario: Valid Indian pincode
     */
    @Test
    public void test_GET_POSITIVE_TC1() {
        runGetRequest("110048", 200); // Expected Output: Successful response, status 200
    }

    /**
     * Negative test case
     * Scenario: Invalid special character as pincode
     */
    @Test
    public void test_GET_NEGATIVE_TC2() {
        runGetRequest("@", 404); // Expected Output: Error response, status 404
    }

    /**
     * Negative test case
     * Scenario: Blank space as pincode
     */
    @Test
    public void test_GET_NEGATIVE_TC3() {
        runGetRequest(" ", 404); // Expected Output: Error response, status 404
    }

    // NOTE:
    // Although request logic is reused,
    // test methods still grow as test cases increase.
    // This highlights the need for better scalability (e.g., data-driven tests).
}
