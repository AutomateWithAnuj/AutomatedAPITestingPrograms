package com.APIAutomation._04_RA_HTTP_Methods.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class ApiTest08_GET_BDDStyle {
    @Test
    public void test_GET_BDD_Positive_TC1(){
        String pincode = "475673";
        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us/")
                    .basePath("/IN/"+pincode)
                .when()
                    .log().all()
                    .get()
                .then()
                    .log().all()
                    .statusCode(200);
    }
}
