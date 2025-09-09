package com.APIAutomation._04_RA_HTTP_Methods.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class ApiTest09_GET_NonBDDStyle {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    @Test
    public void test_GET_NonBDD_Positive_TC1(){
        String pincode = "475673";
        //GIVEN
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us/");
        r.basePath("/IN/"+pincode);
        //WHEN
        response = r.when().log().all().get();
        System.out.println(response.statusCode());
        //THEN
        vr = response.then();
        vr.log().all().statusCode(200);
    }
    @Test
    public void test_GET_NonBDD_Negative_TC2(){
        String pincode = "@";
        //GIVEN
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us/");
        r.basePath("/IN/"+pincode);
        //WHEN
        response = r.when().log().all().get();
        System.out.println(response.statusCode());
        //THEN
        vr = response.then();
        vr.log().all().statusCode(404);
    }

    @Test
    public void test_GET_NonBDD_Negative_TC3(){
        String pincode = " ";
        //GIVEN
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us/");
        r.basePath("/IN/"+pincode);
        //WHEN
        response = r.when().log().all().get();
        System.out.println(response.statusCode());
        //THEN
        vr = response.then();
        vr.log().all().statusCode(404);
    }
}