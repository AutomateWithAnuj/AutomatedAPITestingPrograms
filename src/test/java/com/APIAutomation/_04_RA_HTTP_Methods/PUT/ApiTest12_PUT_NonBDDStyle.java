package com.APIAutomation._04_RA_HTTP_Methods.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class ApiTest12_PUT_NonBDDStyle {
   RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    //booking Id in URL -  https://restful-booker.herokuapp.com/booking/1
    //Headers like Content Type, Accept,Auth - Cookie(token)
    //Payload Required

    @Test
    public void test_POST_NonBDDStyle_Create_Token(){
     String cookie_token = "83eef0426f058f8";
     String bookingId = "1180";

     String PayloadPUT = "{\n" +
             "    \"firstname\" : \"James\",\n" +
             "    \"lastname\" : \"Brown\",\n" +
             "    \"totalprice\" : 111,\n" +
             "    \"depositpaid\" : true,\n" +
             "    \"bookingdates\" : {\n" +
             "        \"checkin\" : \"2018-01-01\",\n" +
             "        \"checkout\" : \"2019-01-01\"\n" +
             "    },\n" +
             "    \"additionalneeds\" : \"Breakfast\"\n" +
             "}";
     r = RestAssured.given();
     r.baseUri("https://restful-booker.herokuapp.com");
     r.basePath("/booking/"+bookingId);
     r.body(PayloadPUT);
     r.contentType(ContentType.JSON);
//     r.header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=");
     r.auth().preemptive().basic("admin", "password123");
     r.cookie("token",cookie_token);
     response = r.when().log().all().put();
     vr = response.then().log().all().statusCode(200);
    }
}