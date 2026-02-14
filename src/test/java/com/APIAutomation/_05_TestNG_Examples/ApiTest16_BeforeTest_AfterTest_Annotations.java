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
     * Purpose: Simulates generating authentication token.
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

    /**
     * This is the actual TestNG test case.
     * It executes after all @BeforeTest methods.
     * Purpose: Simulates executing PUT request.
     */
    @Test
    public void testPUT() {
        System.out.println("Test - Execute PUT Request");
        // Output: Test - Execute PUT Request
    }

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
