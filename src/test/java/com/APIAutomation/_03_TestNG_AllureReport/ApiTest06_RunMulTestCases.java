package com.APIAutomation._03_TestNG_AllureReport;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

/**
 * This class demonstrates running multiple API test cases using
 * TestNG with Rest Assured in BDD style.
 *
 * Key Point / Drawback Highlighted:
 * - Each @Test method repeats the same BDD steps
 * - Only the test data (pincode) is changing
 * - This leads to code duplication and poor reusability
 */
public class ApiTest06_RunMulTestCases {

    // Default pincode used for positive test case
    String pincode = "110048";

    /**
     * Positive Test Case
     * Valid pincode → Expected status code 200
     */
    @Test
    public void test_GET_POSITIVE_TC1() {

        RestAssured
                .given() // given(): prepares the request specification
                .baseUri("https://api.zippopotam.us") // setting base URI of API
                .basePath("/IN/" + pincode) // passing valid pincode in path
                .when() // when(): executes the request
                .get() // sending HTTP GET request
                .then() // then(): validates the response
                .log().all() // prints full response on console
                .statusCode(200); // validates HTTP status code (PASS)
    }

    /**
     * Negative Test Case
     * Invalid pincode (@) → API error expected
     */
    @Test
    public void test_GET_NEGATIVE_TC2() {

        pincode = "@"; // invalid pincode input

        RestAssured
                .given() // same request preparation repeated
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .get()
                .then()
                .log().all() // prints error response on console
                .statusCode(200); // validation still applied (logical failure)
    }

    /**
     * Negative Test Case
     * Blank pincode → API error expected
     */
    @Test
    public void test_GET_NEGATIVE_TC3() {

        pincode = " "; // blank pincode input

        RestAssured
                .given() // same BDD flow copied again
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .get()
                .then()
                .log().all() // prints error response on console
                .statusCode(200); // validation remains same

        /*
         * Drawback Observed:
         * - given(), baseUri(), basePath(), when(), get(), then() are repeated
         * - Only pincode value changes per test case
         * - This violates DRY principle (Don't Repeat Yourself)
         * - Indicates need for reuse via common methods or data-driven testing
         */
    }
}
