package com.APIAutomation._07_Payload_Management.String;

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
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ApiTest30_plMgmt_String {
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

        //here matchers comes from the hamcrest library //4-5% companies are using this
        vr.body("booking.firstname", Matchers.equalTo("James"));
        vr.body("booking.lastname", Matchers.equalTo("Brown"));
        vr.body("booking.depositpaid", Matchers.equalTo(true));
        vr.body("bookingid", Matchers.notNullValue());
        //These above were the Default Rest Assured Assertions

        //now we want to add testNG and AssertJ Assertions all of these
        //to work with TestNG assertions we need to extract the details
            //firstname, bookingId, lastname, depositepaid
        Integer bookingid = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");
        String lastname = response.then().extract().path("booking.lastname");
        boolean depositepaid = response.then().extract().path("booking.depositpaid");

        //now we can use the testNG assertions - 75% companies still using this
        Assert.assertNotNull(bookingid, "Booking ID should not be null");
        Assert.assertEquals(firstname,"James");
        Assert.assertEquals(lastname,"Brown");
        Assert.assertTrue(depositepaid);
        //we don't use the soft assertions in these

        //AssertJ (3rd Library for assertions) - 20% Companies are using
        assertThat(bookingid).isNotZero().isNotNull().isPositive();//3 assertions in 1 line
        assertThat(firstname).isEqualTo("James").isNotBlank().isNotEmpty().isNotNull().isAlphanumeric();
        assertThat(lastname).isEqualTo("Brown");
        assertThat(depositepaid).isTrue();

    }
}