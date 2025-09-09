package com.APIAutomation._04_RA_HTTP_Methods.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class ApiTest14_DELETE_NonBDDStyle {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    //booking Id in URL -  https://restful-booker.herokuapp.com/booking/1
    //Headers like Content Type, Accept,Auth - Cookie(token)
    //No payload required for Delete it will take booking Id from the URL

    @Test
    public void test_DELETE_NonBDDStyle_Create_Token(){
        String cookie_token = "8d8d22c8e4ced60";
        String bookingId = "609";

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingId);
        r.contentType(ContentType.JSON);
//     r.header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=");
        r.auth().preemptive().basic("admin", "password123");
        r.cookie("token",cookie_token);
        response = r.when().log().all().delete();
        vr = response.then().log().all().statusCode(201);
    }
}
