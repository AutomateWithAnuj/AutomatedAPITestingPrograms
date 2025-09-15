package com.APIAutomation._07_Payload_Management.Hashmap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class ApiTest31_plMgmt_HashMap {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    String token;
    Integer bookingId;

    @Test
    public void test_POST(){
/*
        String Payload = "{\n" +
                "        \"firstname\": \"James\",\n" +
                "        \"lastname\": \"Brown\",\n" +
                "        \"totalprice\": 111,\n" +
                "        \"depositpaid\": true,\n" +
                "        \"bookingdates\": {\n" + //parent
                "            \"checkin\": \"2018-01-01\",\n" + //child
                "            \"checkout\": \"2025-10-10\"\n" +
                "        },\n" +
                "        \"additionalneeds\": \"Breakfast\"\n" +
                "    }";
*/
    //Hashmap - A key-Value Pair
        Map<String, Object> jsonBodyUsingMap = new LinkedHashMap<>(); //Parent
        //LinkedHashMap we have used because it could keep the order
        jsonBodyUsingMap.put("firstname","James");
        jsonBodyUsingMap.put("lastname","Brown");
        jsonBodyUsingMap.put("totalprice",111);
        jsonBodyUsingMap.put("depositpaid",true);

        Map<String,Object> bookingDatesMap = new LinkedHashMap<>(); //child
        bookingDatesMap.put("checkin","2018-01-01");
        bookingDatesMap.put("checkout","2019-01-01");

        jsonBodyUsingMap.put("bookingdates",bookingDatesMap);

        jsonBodyUsingMap.put("additionalneeds","Breakfast");

        System.out.println(jsonBodyUsingMap);
        //when you will print the hashmap it will look exactly like the json data
//        {
//            "firstname": "Anuj",
//                "lastname": "Rajput",
//                "totalprice": 123,
//                "depositpaid": false,
//                "bookingdates": {
//                     "checkin": "2018-01-01",
//                    "checkout": "2019-01-01"
//                  },
//            "additionalneeds": "Breakfast"
//        }
        //but the above-mentioned is not json it is a hashmap only and we need to convert it into json
        //there are 2 libraries we can use for this conversion
        //1. gson

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking");
        r.contentType(ContentType.JSON).log().all();
        r.body(jsonBodyUsingMap);

        response = r.when().post();

        vr = response.then().log().all().statusCode(200);

        //till now we have validated only for the status code
        //but we also want to validate the firstname==james, Lastname==brown
        //BookingID must not be null

        //here matchers comes from the hamcrest library //4-5% companies are using this
        vr.body("booking.firstname", Matchers.equalTo("James"));
        vr.body("booking.lastname", Matchers.equalTo("Brown"));
        vr.body("booking.depositpaid", Matchers.equalTo(true));
        vr.body("bookingid", Matchers.notNullValue());
        //These above were the Default Rest Assured Assertions


    }
}
