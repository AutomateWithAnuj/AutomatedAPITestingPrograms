package com.APIAutomation._04_RA_HTTP_Methods.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

/**
 * This class demonstrates how to generate an authentication token
 * using POST request in Rest Assured BDD style.
 *
 * API Used: /auth
 * Purpose : Authenticate user and receive token
 */
public class ApiTest10_POST_BDDStyle {

    /**
     * Test method to authenticate the user
     * using username and password.
     */
    @Test
    public void test_POST_Auth() {

        // JSON payload containing login credentials
        // This data is sent to server to generate an auth token
        // The auth payload can be sent as a String, Map, POJO, or external JSON file. 
        // Rest Assured serialises it into JSON before sending it to the server.
        String authPayload = "{\n" +
                "  \"username\" : \"admin\",\n" +
                "  \"password\" : \"password123\"\n" +
                "}";

        // BDD-style Rest Assured request
        RestAssured
                .given()
                    // Base URI of Restful Booker application
                    .baseUri("https://restful-booker.herokuapp.com")

                    // API endpoint for authentication
                    .basePath("/auth")

                    // Specify request body format as JSON
                    .contentType(ContentType.JSON)

                    // Print complete request details on console
                    // (headers, body, URI)
                    .log().all()

                    // Attach authentication payload to request body
                    .body(authPayload)
                .when()
                    // Print request execution details on console
                    .log().all()

                    // Send POST request to /auth endpoint
                    .post()
                .then()
                    // Print complete response details on console
                    // (status code, headers, response body with token)
                    .log().all()

                    // Validate that authentication is successful
                    .statusCode(200);
    }
}
