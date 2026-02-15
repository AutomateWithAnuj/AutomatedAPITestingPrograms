package com.APIAutomation._06_Test_Assertions;

// ========================== IMPORTS ==========================

// Allure Reporting
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

// Rest Assured
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

// Hamcrest (Default RA Assertions)
import org.hamcrest.Matchers;

// TestNG Assertions
import org.testng.Assert;
import org.testng.annotations.Test;

// AssertJ Assertions
import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class demonstrates:
 * 1. Rest Assured default assertions (Hamcrest)
 * 2. TestNG assertions
 * 3. AssertJ assertions
 * 
 * All are validating the same API response.
 */
public class ApiTest29_RA_TestNG_AssertJ_Assertions {

    // Request builder
    private RequestSpecification request;

    // Raw response
    private Response response;

    // Used for Rest Assured validations
    private ValidatableResponse validatableResponse;

    @Owner("Anuj")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify booking creation & validate response using RA, TestNG & AssertJ")
    @Test
    public void testCreateBooking_POST() {

        // ========================== REQUEST PAYLOAD ==========================

        String payload = """
                {
                    "firstname": "James",
                    "lastname": "Brown",
                    "totalprice": 111,
                    "depositpaid": true,
                    "bookingdates": {
                        "checkin": "2018-01-01",
                        "checkout": "2025-10-10"
                    },
                    "additionalneeds": "Breakfast"
                }
                """;

        // ========================== BUILD REQUEST ==========================

        request = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com") // Base URL
                .basePath("/booking")                            // Endpoint
                .contentType(ContentType.JSON)                   // JSON request
                .body(payload);                                  // Attach body

        // ========================== SEND REQUEST ==========================

        response = request.when().post(); // Send POST request

        // ========================== STATUS CODE VALIDATION ==========================

        validatableResponse = response.then().statusCode(200);
        // If status is not 200 → test fails here

        // ========================== 1️⃣ REST ASSURED ASSERTIONS ==========================

        validatableResponse
                .body("booking.firstname", Matchers.equalTo("James"))
                .body("booking.lastname", Matchers.equalTo("Brown"))
                .body("booking.depositpaid", Matchers.equalTo(true))
                .body("bookingid", Matchers.notNullValue());
        // These are default Rest Assured (Hamcrest) assertions

        // ========================== EXTRACT VALUES ==========================

        Integer bookingId = response.then().extract().path("bookingid");
        String firstName = response.then().extract().path("booking.firstname");
        String lastName = response.then().extract().path("booking.lastname");
        boolean depositPaid = response.then().extract().path("booking.depositpaid");

        // ========================== 2️⃣ TESTNG ASSERTIONS ==========================

        Assert.assertNotNull(bookingId, "Booking ID should not be null");
        Assert.assertEquals(firstName, "James");
        Assert.assertEquals(lastName, "Brown");
        Assert.assertTrue(depositPaid);
        // If any assertion fails → execution stops immediately (Hard Assert)

        // ========================== 3️⃣ ASSERTJ ASSERTIONS ==========================

        assertThat(bookingId)
                .isNotNull()
                .isPositive()
                .isNotZero(); // Multiple validations in one fluent line

        assertThat(firstName)
                .isEqualTo("James")
                .isNotBlank()
                .isNotEmpty()
                .isAlphanumeric();

        assertThat(lastName)
                .isEqualTo("Brown");

        assertThat(depositPaid)
                .isTrue();

        /*
         If all validations pass:
         → Booking successfully created
         → All 3 assertion styles validated correctly

         If any assertion fails:
         → Test fails at that specific assertion point
        */
    }
}
