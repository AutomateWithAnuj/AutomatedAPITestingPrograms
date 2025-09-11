package com.APIAutomation._05_TestNG_Examples;

import org.testng.annotations.*;

public class ApiTest25_All_Annotations {

        @BeforeSuite
        void beforeSuite() {
            System.out.println("BeforeSuite");
        }

        @BeforeTest
        void beforeTest() {
            System.out.println("BeforeTest");
        }

        @BeforeClass
        void beforeClass() {
            System.out.println("BeforeClass");
        }

        @BeforeMethod
        void beforeMethod() {
            System.out.println("BeforeMethod");
        }

        @Test
        void testMethod() {
            System.out.println("Test");
        }

        @AfterMethod
        void afterMethod() {
            System.out.println("AfterMethod");
        }

        @AfterClass
        void afterClass() {
            System.out.println("AfterClass");
        }

        @AfterTest
        void afterTest() {
            System.out.println("AfterTest");
        }

        @AfterSuite
        void afterSuite() {
            System.out.println("AfterSuite");
        }
}
