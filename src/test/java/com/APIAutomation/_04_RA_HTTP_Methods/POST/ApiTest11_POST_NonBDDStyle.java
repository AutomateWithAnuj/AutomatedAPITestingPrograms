package com.APIAutomation._04_RA_HTTP_Methods.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class ApiTest11_POST_NonBDDStyle {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    @Test
    public void test_POST_Auth(){

        //URL -> https://restful-booker.herokuapp.com/auth
        //Payload
        //{
        //    "username" : "admin",
        //    "password" : "password123"
        //}

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        //Pre-condition - Preparing Request - URL, Headers, Auth?, Payload
        System.out.println("<---------Part 1----------->");
        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON);
        r.log().all().body(payload);

        //Making HTTP Request -> Part 2
        System.out.println("<---------Part 2----------->");
        response = r.when().log().all().post();

        //Verification Part -> Part 3
        System.out.println("<---------Part 3----------->");
        vr = response.then();
        vr.log().all().statusCode(200);
    }

}
