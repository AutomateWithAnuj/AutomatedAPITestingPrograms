package com.APIAutomation._05_TestNG_Examples;

import org.testng.Assert;              // Used for validation (Assertions)
import org.testng.annotations.Test;    // Used to mark methods as TestNG test cases

/**
 * Class Name: ApiTest21_Enabled
 *
 * Purpose:
 * This class demonstrates how to use the 'enabled' attribute
 * inside the @Test annotation in TestNG.
 *
 * - enabled = true  → Test will execute
 * - enabled = false → Test will be skipped
 *
 * By default, enabled = true (even if not written explicitly).
 */
public class ApiTest21_Enabled {

    /**
     * Test Case 1
     * enabled = true (Explicitly written, though the default is true)
     * This test will EXECUTE.
     */
    @Test(enabled = true)
    public void test01() {

        // Validating that condition is TRUE.
        // Since condition is true → Test will PASS.
        Assert.assertTrue(true);  // Expected Output in TestNG Report: PASSED
    }

    /**
     * Test Case 2
     * enabled = false
     * This test will NOT execute.
     * TestNG will SKIP this test.
     */
    @Test(enabled = false)
    public void test02() {

        // This line will never execute because test is disabled.
        Assert.assertTrue(true);  // Expected Output in TestNG Report: SKIPPED
    }

    /**
     * Test Case 3
     * enabled = true
     * This test will EXECUTE normally.
     */
    @Test(enabled = true)
    public void test03() {

        // Checking a true condition.
        // This assertion will PASS.
        Assert.assertTrue(true);  // Expected Output in TestNG Report: PASSED
    }
}
