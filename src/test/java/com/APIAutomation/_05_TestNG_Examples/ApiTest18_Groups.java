package com.APIAutomation._05_TestNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * This class demonstrates:
 * 1. How to use TestNG Groups
 * 2. How priority controls execution order
 * 3. How assertions determine pass/fail status
 *
 * Groups used:
 * - "sanity"
 * - "reg"   (regression)
 * - "p1"    (priority 1 type test grouping, not TestNG priority)
 *
 * Execution Order (based on priority):
 * 1 → testSanityRun()
 * 2 → testRegressionRun()
 * 3 → testSmokeRun()
 */
public class ApiTest18_Groups {

    /**
     * This test belongs to both "sanity" and "reg" groups.
     * priority = 1 → Executes first.
     */
    @Test(groups = {"sanity", "reg"}, priority = 1)
    public void testSanityRun() {

        System.out.println("Sanity"); // Output: Sanity
        System.out.println("Reg");    // Output: Reg

        Assert.assertTrue(true);      // Test Status: PASS (condition is true)
    }

    /**
     * This test belongs only to "reg" group.
     * priority = 2 → Executes second.
     */
    @Test(groups = {"reg"}, priority = 2)
    public void testRegressionRun() {

        System.out.println("Reg");    // Output: Reg
        Assert.assertTrue(false);     // Test Status: FAIL (condition is false)
    }

    /**
     * This test belongs to "sanity", "p1", and "reg" groups.
     * priority = 3 → Executes third.
     */
    @Test(groups = {"sanity", "p1", "reg"}, priority = 3)
    public void testSmokeRun() {

        System.out.println("Smoke");  // Output: Smoke
        Assert.assertTrue(false);     // Test Status: FAIL (condition is false)
    }
}
