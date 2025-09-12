package com.APIAutomation._06_Test_Assertions;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class ApiTest29_RA_TestNG_AssertJ_Assertions {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    String token;
    Integer bookingID;

    @Owner("Anuj")
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC#1 is for verifying the create Booking is working fine & Booking Id is not null")
    @Test
    public void test_createBooking_POST(){
        String Payload = "{\n" +
                "        \"firstname\": \"James\",\n" +
                "        \"lastname\": \"Brown\",\n" +
                "        \"totalprice\": 111,\n" +
                "        \"depositpaid\": true,\n" +
                "        \"bookingdates\": {\n" +
                "            \"checkin\": \"2018-01-01\",\n" +
                "            \"checkout\": \"2025-10-10\"\n" +
                "        },\n" +
                "        \"additionalneeds\": \"Breakfast\"\n" +
                "    }";
        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.body(Payload);

        response = r.when().post();

        vr = response.then().statusCode(200);

        //till now we have validated only for the status code
        //but we also want to validate the firstname==james, Lastname==brown
        //BookingID must not be null

        //here matchers comes from the hamcrest library
        vr.body("booking.firstname", Matchers.equalTo("James"));
        vr.body("booking.lastname", Matchers.equalTo("Brown"));
        vr.body("booking.depositpaid", Matchers.equalTo(true));
        vr.body("bookingid", Matchers.notNullValue());
        //These above were the Default Rest Assured Assertions

        //now we want to add testNG and AssertJ Assertions all of these
        //to work with TestNG assertions we need to extract the details
            //firstname, bookingId, lastname, depositepaid
        bookingID = response.then().extract().path("bookingid");s
    }
}
