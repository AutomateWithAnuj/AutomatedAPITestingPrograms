package com.APIAutomation._05_TestNG_Examples;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ApiTest16_BeforeTest_AfterTest_Annotations {
    // PUT Request -
    // 1. getToken
    // 2. getBookingId
    // 3. test_PUT (which will use the above two methods)
    // 4. closeAllThings

    @BeforeTest
    public void getToken(){
        System.out.println("Before Get Token");
    }
    @BeforeTest
    public void getBookingId(){
        System.out.println("Before Booking ID");
    }
    @Test
    public void test_PUT(){
        System.out.println("test_PUT");
    }
    @AfterTest
    public void closeAllThings(){
        System.out.println("After Close");
    }
}
