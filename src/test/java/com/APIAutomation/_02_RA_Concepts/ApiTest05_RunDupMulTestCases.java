package com.APIAutomation._02_RA_Concepts;

import io.restassured.RestAssured;

public class ApiTest05_RunDupMulTestCases {
    public static void main(String[] args) {
        String pincode = "110048"; //positive test case
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);

        pincode = "@"; //negative test case will give error
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);

        pincode = " "; //negative test case will give error
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when()
                .get()
                .then()
                .log().all().statusCode(200);

        //but here we are pasting same things all the time and we must have to see something to reuse
    }
}
