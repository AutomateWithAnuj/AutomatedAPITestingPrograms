package com.APIAutomation._06_Test_Assertions;

// ======================= IMPORTS =======================

// TestNG Hard Assertion
import org.testng.Assert;

// TestNG Annotations
import org.testng.annotations.Test;

// TestNG Soft Assertion
import org.testng.asserts.SoftAssert;

/**
 * This class demonstrates:
 * 1. Difference between Hard Assertion and Soft Assertion in TestNG
 * 2. How execution flow behaves when assertion fails
 */
public class ApiTest28_TestNG_Assertions {

    /**
     * HARD ASSERT EXAMPLE
     * If assertion fails → execution stops immediately.
     */
    @Test(enabled = false) // Disabled test (will not execute)
    public void testHardAssertExample() {

        System.out.println("Start of the Program");
        // Console Output: Start of the Program

        // Hard Assertion → Stops execution if condition fails
        Assert.assertEquals("anuj", "Anuj");  
        // This will FAIL because "anuj" ≠ "Anuj" (case-sensitive comparison)

        // This line will NOT execute if assertion fails above
        System.out.println("End of the Program");
        // Skipped due to assertion failure
    }


    /**
     * SOFT ASSERT EXAMPLE
     * If assertion fails → execution continues.
     * But we MUST call assertAll() at the end.
     */
    @Test
    public void testSoftAssertExample() {

        System.out.println("Start of the Program");
        // Console Output: Start of the Program

        Boolean isNeeruMale = false;  
        // Sample variable (not used in assertion, just for demonstration)

        // Create object of SoftAssert
        SoftAssert softAssert = new SoftAssert();

        // Soft Assertion → Does NOT stop execution immediately
        softAssert.assertEquals("anuj", "Anuj");
        // This will FAIL but execution continues

        System.out.println("End of the Program");
        // Console Output: End of the Program (This WILL execute)

        // IMPORTANT: Collects all soft assertion results
        softAssert.assertAll();  
        /*
           If any soft assertion failed above:
           → Test will FAIL here.
           
           If all soft assertions passed:
           → Test will PASS.
           Soft assertions allow test execution to continue until assertAll() is called. Once assertAll() executes, 
           if any assertion has failed, it throws AssertionError and stops further execution.
        */

        /*
         Soft Assertions are useful when:
         → You want test to continue execution
         → You want to validate multiple things in one test
         */
    }
}
