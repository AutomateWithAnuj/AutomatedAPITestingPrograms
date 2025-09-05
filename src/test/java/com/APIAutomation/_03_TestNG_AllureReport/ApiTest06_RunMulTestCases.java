package com.APIAutomation._03_TestNG_AllureReport;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class ApiTest06_RunMulTestCases {
    public void runGetRequest(String pincode, int expectedStatus){
        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/" + pincode)
                .when()
                    .get()
                .then()
                    .log().all()
                    .statusCode(expectedStatus);
    }

    @Test
    public void test_GET_POSITIVE_TC1(){
        runGetRequest("110048", 200);
    }

    @Test
    public void test_GET_NEGATIVE_TC2(){
        runGetRequest("@", 404);
    }

    @Test
    public void test_GET_NEGATIVE_TC3(){
        runGetRequest(" ", 404);
    }        //but here we are pasting same things all the time and we must have to see something to reuse
}