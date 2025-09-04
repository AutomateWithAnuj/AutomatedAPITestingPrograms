package com.APIAutomation._01_RA_Basics;

import io.restassured.RestAssured;

public class ApiTest01_BasicGet {
    public static void main(String[] args) {
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/ping") //this is the URL we are going to use
                .when()
                    .get() //in when we need to write what method we have to use
                    //we can use here .post, .put, .patch, .delete
                .then()
                    .log().all().statusCode(201);
    }
}
