package com.APIAutomation._05_TestNG_Examples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * This class demonstrates how to use @Parameters in TestNG.
 *
 * Purpose:
 * - To pass external values (from testng.xml) into test methods.
 * - Helps in running the same test with different inputs.
 *
 * Example:
 * <parameter name="browser" value="chrome"/>
 */
public class ApiTest20_Parameter {

    /**
     * @Parameters("browser")
     * - Reads the value of "browser" from testng.xml.
     * - That value is injected into this method as a String.
     */
    @Parameters("browser")
    @Test
    public void demoTest(String browser) {

        System.out.println("Hi I am demo"); 
        // Output: Hi I am demo

        System.out.println("You are running this parameter");
        // Output: You are running this parameter

        // Check if browser value is "firefox" (case-insensitive)
        if (browser.equalsIgnoreCase("firefox")) {

            System.out.println("Start the firefox");
            // Output (if parameter = firefox): Start the firefox
        }

        // Check if browser value is "chrome" (case-insensitive)
        if (browser.equalsIgnoreCase("chrome")) {

            System.out.println("Start the chrome");
            // Output (if parameter = chrome): Start the chrome
        }
    }
}
