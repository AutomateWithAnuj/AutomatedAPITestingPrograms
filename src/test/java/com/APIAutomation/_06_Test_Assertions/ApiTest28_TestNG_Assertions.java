package com.APIAutomation._06_Test_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ApiTest28_TestNG_Assertions {
    @Test(enabled=false)
    public void test_hardAssertExample(){
        System.out.println("Start of the Program");
        Assert.assertEquals("anuj","Anuj"); //Hard Assertion
        System.out.println("End of the program"); //Skipped if above assertion fails
    }
    @Test
    public void test_softAssertExample(){
        System.out.println("Start of the Program");
        Boolean is_neeru_male = false;
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("anuj","Anuj"); //Soft Assertion
        System.out.println("End of the program"); //Run if above assertion fails or passed
        softAssert.assertAll();  //it means assert all the asserts above
        //we can use soft assertion if we would like to continue the execution
        //it can be used when a small icon not working sometimes
    }
}
