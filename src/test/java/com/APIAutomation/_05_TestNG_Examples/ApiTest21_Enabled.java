package com.APIAutomation._05_TestNG_Examples;

import org.testng.Assert;        // Used for performing validations (assertions)
import org.testng.annotations.Test;  // Used to mark methods as TestNG test cases

/**
 * Class Name: ApiTest21Enabled
 *
 * Purpose:
 * This class demonstrates basic TestNG test methods.
 * Each method is marked with @Test annotation,
 * meaning TestNG will execute them as independent test cases.
 *
 * All test methods here validate a simple condition: true == true.
 * So all tests will PASS.
 */
public class ApiTest21_Enabled {

    /**
     * Test Case 1
     * Purpose: Validates that the condition is true.
     */
    @Test
    public void test01() {

        // Assert that the given condition is TRUE.
        // If the condition is false, the test will FAIL.
        Assert.assertTrue(true);  // Expected: PASS
    }

    /**
     * Test Case 2
     * Purpose: Another independent test case.
     * TestNG treats this separately from test01.
     */
    @Test
    public void test02() {

        // Checking a true condition.
        // Since condition is true, this test will PASS.
        Assert.assertTrue(true);  // Expected: PASS
    }

    /**
     * Test Case 3
     * Purpose: Demonstrates multiple test methods in a single class.
     * Each method runs independently.
     */
    @Test
    public void test03() {

        // Validates that true is true.
        // This assertion will PASS.
        Assert.assertTrue(true);  // Expected: PASS
    }
}
