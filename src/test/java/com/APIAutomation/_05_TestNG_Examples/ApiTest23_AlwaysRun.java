package com.APIAutomation._05_TestNG_Examples;

import org.testng.Assert;              // Used for performing validations (assertions)
import org.testng.annotations.Test;    // Used to mark methods as TestNG test cases

/**
 * Class Name: ApiTest23_AlwaysRun
 *
 * Purpose:
 * This class demonstrates the usage of the 'alwaysRun' attribute in TestNG.
 *
 * alwaysRun = true →
 * Ensures that this test method runs even if it depends on another test
 * that fails or is skipped (in dependency scenarios).
 *
 * Note:
 * In this example, there are no dependencies.
 * So all enabled tests will run normally.
 */
public class ApiTest23_AlwaysRun {

    /**
     * Test Case 1: New User Registration
     * Default behavior (enabled = true).
     * This test will EXECUTE.
     */
    @Test
    public void test_new_register() {

        // Validates that registration is successful.
        // Since condition is true → Test will PASS.
        Assert.assertTrue(true);  // Expected Result in TestNG Report: PASSED
    }

    /**
     * Test Case 2: Login Page Verification
     *
     * alwaysRun = true →
     * This test is intended to always execute,
     * especially in dependency scenarios (like after registration).
     *
     * Here, it will run normally because it is enabled by default.
     */
    @Test(alwaysRun = true)
    public void test_loginPage() {

        // Validates that user is redirected to login page.
        // Condition is true → Test will PASS.
        Assert.assertTrue(true);  // Expected Result in TestNG Report: PASSED
    }

    /**
     * Test Case 3: Normal Test Case
     * Default behavior (enabled = true).
     * This test will EXECUTE.
     */
    @Test
    public void test_normal() {

        // Simple validation.
        // Condition is true → Test will PASS.
        Assert.assertTrue(true);  // Expected Result in TestNG Report: PASSED
    }
}
