package com.APIAutomation._05_TestNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * This class demonstrates the use of:
 * 1. dependsOnMethods in TestNG
 * 2. How test execution order is controlled using dependencies
 *
 * Key Concept:
 * - If a test method depends on another method,
 *   it will execute only after the dependent method passes.
 * - If the dependent method fails, the dependent test will be SKIPPED.
 */
public class ApiTest19_DependsOnMethod {

    /**
     * This method represents a prerequisite step.
     * Example: Server must start successfully before running dependent tests.
     *
     * Since no dependency is defined here,
     * this test runs independently.
     */
    @Test
    public void serverStartedOk() {

        System.out.println("I will run first"); // Output: I will run first

        Assert.assertTrue(true); // Test Status: PASS
    }

    /**
     * This method depends on serverStartedOk().
     *
     * Meaning:
     * - It will execute only if serverStartedOk() passes.
     * - If serverStartedOk() fails, this test will be SKIPPED.
     */
    @Test(dependsOnMethods = "serverStartedOk")
    public void testMethod1() {

        System.out.println("method1"); // Output: method1

        Assert.assertTrue(true); // Test Status: PASS
    }

    /**
     * This method has no dependency.
     * It runs independently of other test methods.
     *
     * Execution order is not guaranteed unless priority is defined.
     */
    @Test
    public void testMethod2() {

        System.out.println("method2"); // Output: method2

        Assert.assertTrue(true); // Test Status: PASS
    }
}
