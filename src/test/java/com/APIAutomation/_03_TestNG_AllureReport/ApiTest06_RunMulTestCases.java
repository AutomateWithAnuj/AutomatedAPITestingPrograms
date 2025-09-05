package com.APIAutomation._03_TestNG_AllureReport;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class ApiTest06_RunMulTestCases {

    String pincode = "110048";

    @Test
    public void test_GET_POSITIVE_TC1() {
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void test_GET_NEGATIVE_TC2() {
        pincode = "@";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void test_GET_NEGATIVE_TC3() {
        pincode = " ";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/" + pincode)
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200);

        // but here we are pasting same things all the time
        // and we must have to see something to reuse
    }
}
