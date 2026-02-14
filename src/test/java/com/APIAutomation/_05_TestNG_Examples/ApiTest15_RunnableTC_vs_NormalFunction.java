package com.APIAutomation._05_TestNG_Examples;

import org.testng.annotations.Test;

/**
 * This class demonstrates the difference between:
 * 1) A normal Java method
 * 2) A TestNG runnable test case
 *
 * Key Concept:
 * Only methods annotated with @Test will be executed by TestNG.
 */
public class ApiTest15_RunnableTC_vs_NormalFunction {

    /**
     * This is a NORMAL Java method.
     * 
     * ❌ It will NOT be executed by TestNG
     * because it does not have the @Test annotation.
     * 
     * It behaves like any regular method in Java.
     */
    public void testPostRequest1() {
        System.out.println("This is a normal method, NOT executed by TestNG.");
        // Output: This is a normal method, NOT executed by TestNG.
    }

    /**
     * This is a TestNG test method.
     * 
     * ✅ It WILL be executed by TestNG
     * because it is annotated with @Test.
     * 
     * TestNG scans for @Test annotations
     * and runs only those methods.
     */
    @Test
    public void testPostRequest2() {
        System.out.println("This is a TestNG runnable test case.");
        // Output: This is a TestNG runnable test case.
    }
}
