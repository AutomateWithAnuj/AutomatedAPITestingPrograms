package com.APIAutomation._05_TestNG_Examples;

import org.testng.annotations.Test;   // Used to mark methods as TestNG test cases

/**
 * Class Name: ApiTest24_InvocationCount
 *
 * Purpose:
 * This class demonstrates the usage of the 'invocationCount' attribute in TestNG.
 *
 * invocationCount = 3 →
 * The same test method will execute 3 times automatically.
 *
 * Useful for:
 * - Load testing
 * - Repeating a test multiple times
 * - Checking stability of a test
 */
public class ApiTest24_InvocationCount {

    /**
     * Test Case 1
     * invocationCount = 3
     *
     * This method will execute 3 times.
     */
    @Test(invocationCount = 3)
    public void test01() {

        // Prints "Hi" to the console.
        // Since invocationCount = 3 → "Hi" will be printed 3 times.
        System.out.println("Hi");   // Console Output:
                                    // Hi
                                    // Hi
                                    // Hi
    }

    /**
     * Test Case 2
     * invocationCount = 3
     *
     * This method will also execute 3 times.
     */
    @Test(invocationCount = 3)
    public void test02() {

        // Prints "Bye" to the console.
        // Since invocationCount = 3 → "Bye" will be printed 3 times.
        System.out.println("Bye");  // Console Output:
                                    // Bye
                                    // Bye
                                    // Bye
    }
}
