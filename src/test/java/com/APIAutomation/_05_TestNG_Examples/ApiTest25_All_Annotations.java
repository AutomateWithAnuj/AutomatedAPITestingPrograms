package com.APIAutomation._05_TestNG_Examples;

import org.testng.annotations.*;   // Importing all TestNG annotations

/**
 * Class Name: ApiTest25_AllAnnotations
 *
 * Purpose:
 * This class demonstrates the execution flow of all major TestNG annotations.
 *
 * Execution Order:
 * 1. @BeforeSuite
 * 2. @BeforeTest
 * 3. @BeforeClass
 * 4. @BeforeMethod
 * 5. @Test
 * 6. @AfterMethod
 * 7. @AfterClass
 * 8. @AfterTest
 * 9. @AfterSuite
 *
 * This structure is very important for interview explanation.
 */
public class ApiTest25_All_Annotations {

    /**
     * Runs ONCE before the entire suite execution.
     * (Suite = Complete TestNG execution)
     */
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("BeforeSuite");  
        // Console Output: BeforeSuite
    }

    /**
     * Runs before any test defined inside <test> tag in testng.xml.
     */
    @BeforeTest
    public void beforeTest() {
        System.out.println("BeforeTest");
        // Console Output: BeforeTest
    }

    /**
     * Runs ONCE before the first @Test method
     * in this class.
     */
    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass");
        // Console Output: BeforeClass
    }

    /**
     * Runs BEFORE every @Test method.
     * If there were multiple test methods,
     * this would run before each one.
     */
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BeforeMethod");
        // Console Output: BeforeMethod
    }

    /**
     * Actual Test Case
     * This is where test logic is written.
     */
    @Test
    public void testMethod() {
        System.out.println("Test");
        // Console Output: Test
    }

    /**
     * Runs AFTER every @Test method.
     */
    @AfterMethod
    public void afterMethod() {
        System.out.println("AfterMethod");
        // Console Output: AfterMethod
    }

    /**
     * Runs ONCE after all @Test methods
     * in this class are executed.
     */
    @AfterClass
    public void afterClass() {
        System.out.println("AfterClass");
        // Console Output: AfterClass
    }

    /**
     * Runs after all tests inside <test> tag
     * in testng.xml are completed.
     */
    @AfterTest
    public void afterTest() {
        System.out.println("AfterTest");
        // Console Output: AfterTest
    }

    /**
     * Runs ONCE after the entire suite execution finishes.
     */
    @AfterSuite
    public void afterSuite() {
        System.out.println("AfterSuite");
        // Console Output: AfterSuite
    }
}
