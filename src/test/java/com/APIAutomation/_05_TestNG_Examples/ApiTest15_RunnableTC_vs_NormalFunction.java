package com.APIAutomation._05_TestNG_Examples;

import org.testng.annotations.Test;

public class ApiTest15_RunnableTC_vs_NormalFunction {
    //this will not be recognized as this is a runnable test case
    //this is a normal function
    public void test_post_request1(){

    }
    @Test //this will be recognized as this is a runnable test case
    public void test_post_request2(){

    }
}
