package com.APIAutomation._05_TestNG_Examples;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * This class demonstrates the usage of:
 * 1) @BeforeTest  → Executes BEFORE any @Test method in this class
 * 2) @Test        → Actual test case
 * 3) @AfterTest   → Executes AFTER all @Test methods are completed
 *
 * Scenario (PUT Request Flow):
 * Step 1 → Get Token
 * Step 2 → Get Booking ID
 * Step 3 → Execute PUT request using above data
 * Step 4 → Close/cleanup resources
 */
public class ApiTest16_BeforeTest_AfterTest_Annotations {

    /**
     * This method runs BEFORE any test method.
     * Purpose: Simulates generating an authentication token.
     */
    @BeforeTest
    public void getToken() {
        System.out.println("BeforeTest - Get Token");
        // Output: BeforeTest - Get Token
    }

    /**
     * This method also runs BEFORE any test method.
     * Note: Multiple @BeforeTest methods are allowed.
     * Purpose: Simulates fetching Booking ID.
     */
    @BeforeTest
    public void getBookingId() {
        System.out.println("BeforeTest - Get Booking ID");
        // Output: BeforeTest - Get Booking ID
    }

    /*
    * If multiple @BeforeTest methods are present, TestNG does not guarantee execution order. 
    * So we should not rely on it and instead control order using dependsOnMethods or combine logic into a single setup method.
    */
    
    /**
     * This is the actual TestNG test case.
     * It executes after all @BeforeTest methods.
     * Purpose: Simulates executing a PUT request.
     * If a class contains @BeforeTest and @AfterTest but no @Test method, 
     * then TestNG will not execute anything because lifecycle annotations are triggered only when at least one test method is present.
     */
    @Test
    public void testPUT() {
        System.out.println("Test - Execute PUT Request");
        // Output: Test - Execute PUT Request
    }

    /*
    * By default, TestNG does not guarantee alphabetical execution. 
    * In some environments, it may appear alphabetical due to reflection order, but it is not officially guaranteed. 
    * If order matters, we should use priority or dependsOnMethods.
    */
    
    /**
     * This method runs AFTER all @Test methods are executed.
     * Purpose: Cleanup activities (closing connections, etc.).
     */
    @AfterTest
    public void closeAllThings() {
        System.out.println("AfterTest - Close All Resources");
        // Output: AfterTest - Close All Resources
    }
}
