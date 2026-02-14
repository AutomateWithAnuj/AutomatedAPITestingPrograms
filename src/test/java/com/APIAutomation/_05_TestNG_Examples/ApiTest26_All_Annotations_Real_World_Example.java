package com.APIAutomation._05_TestNG_Examples;

import org.testng.annotations.*;   // Importing all TestNG annotations

/**
 * Class Name: ApiTest26_All_Annotations_Real_World_Example
 *
 * Purpose:
 * This class demonstrates a real-world execution flow of TestNG annotations
 * in a practical automation testing scenario (UI/API).
 *
 * Flow Overview:
 * Suite Level   → Database setup/cleanup
 * Test Level    → Browser setup/cleanup
 * Class Level   → Application navigation/close
 * Group Level   → Smoke group-specific setup/cleanup
 * Method Level  → Login/Logout before & after each test
 */
public class ApiTest26_All_Annotations_Real_World_Example {

    // ======================== BEFORE SECTION ========================

    /**
     * Runs ONCE before the entire test suite starts.
     * Used for global setup like DB connection.
     */
    @BeforeSuite
    public void connectToDatabase() {
        System.out.println("Connecting to MySQL Database...");
        // Console Output: Connecting to MySQL Database...
        // Real World: Establish database connection here
    }

    /**
     * Runs before any <test> defined in testng.xml.
     * Used to initialize browser or driver.
     */
    @BeforeTest
    public void launchBrowser() {
        System.out.println("Launching Browser...");
        // Console Output: Launching Browser...
        // Real World: Initialize WebDriver instance
    }

    /**
     * Runs ONCE before the first test method in this class.
     * Used to navigate to application URL.
     */
    @BeforeClass
    public void navigateToApplication() {
        System.out.println("Navigating to Application URL...");
        // Console Output: Navigating to Application URL...
        // Real World: driver.get("https://myapp.com");
    }

    /**
     * Runs BEFORE any test method belonging to "smoke" group.
     * Used to prepare test data specific to smoke tests.
     */
    @BeforeGroups("smoke")
    public void beforeSmokeGroup() {
        System.out.println("Setting up preconditions for SMOKE group...");
        // Console Output: Setting up preconditions for SMOKE group...
        // Real World: Prepare smoke test data
    }

    /**
     * Runs BEFORE every @Test method.
     * Used for common setup like login.
     */
    @BeforeMethod
    public void loginUser() {
        System.out.println("Logging in before each test...");
        // Console Output: Logging in before each test...
        // Real World: Perform login (UI/API)
    }

    // ======================== TEST METHODS ========================

    /**
     * Smoke Test Case
     * Validates that user can search products.
     */
    @Test(groups = "smoke")
    public void verifyUserCanSearch() {
        System.out.println("Running Test: User can search products");
        // Console Output: Running Test: User can search products
        // Real World: Perform search and validate results
    }

    /**
     * Regression Test Case
     * Validates that user can add product to cart.
     */
    @Test(groups = "regression")
    public void verifyUserCanAddToCart() {
        System.out.println("Running Test: User can add product to cart");
        // Console Output: Running Test: User can add product to cart
        // Real World: Add product to cart and validate
    }

    // ======================== AFTER SECTION ========================

    /**
     * Runs AFTER every @Test method.
     * Used for common cleanup like logout.
     */
    @AfterMethod
    public void logoutUser() {
        System.out.println("Logging out after each test...");
        // Console Output: Logging out after each test...
        // Real World: Perform logout
    }

    /**
     * Runs AFTER all "smoke" group test methods.
     * Used to clean up smoke-specific data.
     */
    @AfterGroups("smoke")
    public void afterSmokeGroup() {
        System.out.println("Cleaning up after SMOKE group...");
        // Console Output: Cleaning up after SMOKE group...
        // Real World: Remove smoke test data
    }

    /**
     * Runs ONCE after all test methods in this class.
     * Used to close application.
     */
    @AfterClass
    public void closeApplication() {
        System.out.println("Closing Application...");
        // Console Output: Closing Application...
        // Real World: driver.close();
    }

    /**
     * Runs AFTER all tests inside <test> tag.
     * Used to close browser completely.
     */
    @AfterTest
    public void closeBrowser() {
        System.out.println("Closing Browser...");
        // Console Output: Closing Browser...
        // Real World: driver.quit();
    }

    /**
     * Runs ONCE after the entire test suite finishes.
     * Used to release global resources like DB connection.
     */
    @AfterSuite
    public void disconnectDatabase() {
        System.out.println("Disconnecting from MySQL Database...");
        // Console Output: Disconnecting from MySQL Database...
        // Real World: Close DB connection
    }
}
