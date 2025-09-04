package com.APIAutomation._01_RA_Basics;

import io.restassured.RestAssured;

import java.util.Scanner;

public class ApiTest02_BasicGet {
    public static void main(String[] args) {
//        Given - prerequisite - URL, Headers, Auth, Body
//        When - action - HTTP Method? - GET/POST/PUT/PATCH/DELETE
//        Then - validation - 200 OK, Firstname == Anuj

//        Full URL - https://api.zippopotam.us/IN/475673
//        Base URI - https://api.zippopotam.us
//        Base Path - /IN/475673
//        Endpoint - IN
//        Parameter - 560016
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the pincode!");
        String pincode = sc.next();
        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/"+pincode)
                .when()
                    .get()
                .then()
                    .log().all()
                    .statusCode(200); //verifying the status code

        //the above-mentioned code actually is a single line we have just put it in a different manner
        //the above-mentioned code in java is called the builder pattern
        //in the end the semicolon is needed
        //we can also verify the Headers, Cookies, Response Body, others
    }
}
