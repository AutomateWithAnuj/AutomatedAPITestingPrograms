package com.APIAutomation._04_RA_HTTP_Methods.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class ApiTest13_PATCH_NonBDDStyle {

 //booking Id in URL -  https://restful-booker.herokuapp.com/booking/1
 //Headers like Content Type, Accept,Auth - Cookie(token)
 //Payload Required

 RequestSpecification r;
 Response response;
 ValidatableResponse vr;

 //booking Id in URL -  https://restful-booker.herokuapp.com/booking/1
 //Headers like Content Type, Accept,Auth - Cookie(token)

 @Test
 public void test_POST_NonBDDStyle_Create_Token(){
  String cookie_token = "588d730e0fbd485";
  String bookingId = "2823";

  String PayloadPATCH = "{\n" +
          "    \"firstname\": \"Anuj\",\n" +
          "    \"lastname\": \"Rajput\"\n" +
          "}";
  r = RestAssured.given();
  r.baseUri("https://restful-booker.herokuapp.com");
  r.basePath("/booking/"+bookingId);
  r.body(PayloadPATCH);
  r.contentType(ContentType.JSON);
//     r.header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=");
  r.auth().preemptive().basic("admin", "password123");
  r.cookie("token",cookie_token);
  response = r.when().log().all().patch();
  vr = response.then().log().all().statusCode(200);
 }
}