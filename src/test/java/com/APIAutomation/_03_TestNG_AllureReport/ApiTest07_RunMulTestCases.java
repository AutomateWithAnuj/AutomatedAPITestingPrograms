package com.APIAutomation._03_TestNG_AllureReport;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

/**
 * This class demonstrates an IMPROVED version of BDD-style testing
 * by introducing a reusable helper method.
 *
 * Improvement over previous version:
 * - Common Rest Assured code is moved into one method
 * - Test methods only pass test data and expected result
 *
 * Still a Limitation (Important Concept):
 * - This is STILL BDD style
 * - Reusability is better, but NOT as flexible as Non-BDD style
 */
public class ApiTest07_RunMulTestCases {

    /**
     * Reusable helper method for executing GET requests.
     *
     * Why this method exists:
     * - Avoids repeating given() → when() → then() in every test
     * - Improves readability and reduces duplication
     *
     * @param pincode Input value to be passed in API path
     * @param expectedStatus Expected HTTP status code for validation
     */
    private void runGetRequest(String pincode, int expectedStatus) {

        RestAssured
                .given() // Step 1: Prepare request (BDD style starts here)
                .baseUri("https://api.zippopotam.us") // Base URL of the API
                .basePath("/IN/" + pincode) // Dynamic pincode passed in path
                .when() // Step 2: Perform the action
                .get() // Sends HTTP GET request
                .then() // Step 3: Validate the response
                .log().all() // Prints full response on console for debugging
                // Console Output: Status line, headers, and response body
                .statusCode(expectedStatus); // Validates HTTP status code
    }

    /**
     * Positive Test Case
     * Scenario: Valid Indian pincode
     */
    @Test
    public void test_GET_POSITIVE_TC1() {
        runGetRequest("110048", 200);
        // Console Output: Successful API response with status code 200
    }

    /**
     * Negative Test Case
     * Scenario: Invalid pincode using special character
     */
    @Test
    public void test_GET_NEGATIVE_TC2() {
        runGetRequest("@", 404);
        // Console Output: Error response with status code 404
    }

    /**
     * Negative Test Case
     * Scenario: Blank space as pincode
     */
    @Test
    public void test_GET_NEGATIVE_TC3() {
        runGetRequest(" ", 404);
        // Console Output: Error response with status code 404
    }

    /*
     * IMPORTANT INTERVIEW POINT:
     *
     * - This approach is MORE reusable than pure BDD tests
     * - Common request logic is centralized in one method
     *
     * BUT:
     * - given(), when(), then() are still tightly coupled
     * - Validation and execution happen together
     *
     * Non-BDD style (RequestSpecification / Response)
     * offers EVEN BETTER reusability and flexibility:
     * - Request creation
     * - Request execution
     * - Response validation
     * can all be controlled independently
     */
}
