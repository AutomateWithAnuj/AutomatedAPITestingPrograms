package com.APIAutomation._04_RA_HTTP_Methods.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

/**
 * This class demonstrates a PATCH API call
 * using Rest Assured NON-BDD (classic) style.
 *
 * Scenario:
 * - Update partial booking details (firstname, lastname)
 * - Authentication and token are required
 */
public class ApiTest13_PATCH_NonBDDStyle {

    // Request object used to build the PATCH request
    private RequestSpecification request;

    // Holds the raw response received from the API
    private Response response;

    // Used for response validation and assertions
    private ValidatableResponse validatableResponse;

    /**
     * Test method to perform PATCH request on booking API.
     * Purpose: Update partial booking details.
     */
    @Test
    public void test_PATCH_NonBDDStyle_Update_Booking() {

        // Token required for authorization (normally generated dynamically)
        String cookieToken = "588d730e0fbd485";

        // Booking ID to be updated
        String bookingId = "2823";

        // PATCH request payload (partial update)
        String patchPayload = "{\n" +
                "  \"firstname\": \"Anuj\",\n" +
                "  \"lastname\": \"Rajput\"\n" +
                "}";

        // ---------- GIVEN ----------
        request = RestAssured.given(); // Initialize request
        request.baseUri("https://restful-booker.herokuapp.com"); // Base API URL
        request.basePath("/booking/" + bookingId); // Endpoint with booking ID
        request.contentType(ContentType.JSON); // Setting request body type as JSON
        request.body(patchPayload); // Attaching PATCH payload to request
        request.auth().preemptive().basic("admin", "password123"); // Basic authentication
        request.cookie("token", cookieToken); // Cookie-based token authentication

        // ---------- WHEN ----------
        response = request.when().log().all().patch();
        // Console Output: Full request details + PATCH response

        // ---------- THEN ----------
        validatableResponse = response.then().log().all().statusCode(200);
        // Console Output: Updated booking response with HTTP 200 status
    }
}
