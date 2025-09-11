package com.APIAutomation._05_TestNG_Examples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ApiTest20_Parameter {
    @Parameters("browser")
    @Test
    public void demo1(String browser){
        System.out.println("Hi I am demo");
        System.out.println("You are running this parameter");

        if(browser.equalsIgnoreCase("firefox")){
            System.out.println("Start the firefox");
        }
        if(browser.equalsIgnoreCase("chrome")){
            System.out.println("Start the chrome");
        }
    }
}
