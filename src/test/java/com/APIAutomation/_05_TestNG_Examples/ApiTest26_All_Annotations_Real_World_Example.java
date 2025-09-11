package com.APIAutomation._05_TestNG_Examples;

import org.testng.annotations.*;

public class ApiTest26_All_Annotations_Real_World_Example {

        // ======================== BEFORE ========================
        @BeforeSuite
        void connectToDatabase() {
            System.out.println("🔹 Connecting to MySQL Database...");
            // Code: Establish DB connection
        }

        @BeforeTest
        void launchBrowser() {
            System.out.println("🔹 Launching Browser...");
            // Code: Start WebDriver or Browser instance
        }

        @BeforeClass
        void navigateToApplication() {
            System.out.println("🔹 Navigating to Application URL...");
            // Code: driver.get("https://myapp.com");
        }

        @BeforeGroups("smoke")
        void beforeSmokeGroup() {
            System.out.println("🔹 Setting up preconditions for SMOKE group...");
            // Code: Prepare test data for smoke tests
        }

        @BeforeMethod
        void loginUser() {
            System.out.println("🔹 Logging in before each test...");
            // Code: Perform login API call or UI login
        }

        // ======================== TEST CASES ========================
        @Test(groups = "smoke")
        void verifyUserCanSearch() {
            System.out.println("✅ Running Test: User can search products");
            // Code: Perform search and validate results
        }

        @Test(groups = "regression")
        void verifyUserCanAddToCart() {
            System.out.println("✅ Running Test: User can add product to cart");
            // Code: Add product to cart and validate
        }

        // ======================== AFTER ========================
        @AfterMethod
        void logoutUser() {
            System.out.println("🔹 Logging out after each test...");
            // Code: Perform logout
        }

        @AfterGroups("smoke")
        void afterSmokeGroup() {
            System.out.println("🔹 Cleaning up after SMOKE group...");
            // Code: Remove test data created in smoke tests
        }

        @AfterClass
        void closeApplication() {
            System.out.println("🔹 Closing Application...");
            // Code: driver.close();
        }

        @AfterTest
        void closeBrowser() {
            System.out.println("🔹 Closing Browser...");
            // Code: driver.quit();
        }

        @AfterSuite
        void disconnectDatabase() {
            System.out.println("🔹 Disconnecting from MySQL Database...");
            // Code: Close DB connection
        }
}