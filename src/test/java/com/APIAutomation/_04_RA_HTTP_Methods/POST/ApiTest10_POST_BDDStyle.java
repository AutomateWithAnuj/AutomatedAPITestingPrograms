package com.APIAutomation._04_RA_HTTP_Methods.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class ApiTest10_POST_BDDStyle {
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
        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/auth")
                    .contentType(ContentType.JSON)
                    .log().all().body(payload)
                .when()
                    .log().all().post()
                .then()
                .log().all().statusCode(200);
    }
}
