package com.APIAutomation._05_TestNG_Examples;

import org.testng.Assert;              // Used to perform assertions (validations)
import org.testng.annotations.Test;    // Used to mark methods as TestNG test cases

/**
 * Class Name: ApiTest22_AlwaysRun
 *
 * Purpose:
 * This class demonstrates the usage of:
 * 1. enabled attribute  → Controls whether a test method should run or not.
 * 2. alwaysRun attribute → Forces execution in certain dependency scenarios.
 *
 * IMPORTANT:
 * If enabled = false, the test will NOT execute,
 * even if alwaysRun = true is mentioned.
 */
public class ApiTest22_AlwaysRun {

    /**
     * Test Case 1
     * Default behavior (enabled = true by default).
     * This test will EXECUTE.
     */
    @Test
    public void test01() {

        // Validates that the condition is true.
        // Since condition is true → Test will PASS.
        Assert.assertTrue(true);  // Expected Result in TestNG Report: PASSED
    }

    /**
     * Test Case 2
     * enabled = false → This test is DISABLED.
     * alwaysRun = true → Has no effect because enabled = false.
     *
     * Final Behavior:
     * This test will NOT run and will be marked as SKIPPED.
     */
    @Test(alwaysRun = true, enabled = false)  // Disabled test
    public void test02() {

        // This line will never execute because the test is disabled.
        Assert.assertTrue(true);  // Expected Result in TestNG Report: SKIPPED
    }

    /**
     * Test Case 3
     * Default behavior (enabled = true).
     * This test will EXECUTE normally.
     */
    @Test
    public void test03() {

        // Validates a true condition.
        // This assertion will PASS.
        Assert.assertTrue(true);  // Expected Result in TestNG Report: PASSED
    }
}
