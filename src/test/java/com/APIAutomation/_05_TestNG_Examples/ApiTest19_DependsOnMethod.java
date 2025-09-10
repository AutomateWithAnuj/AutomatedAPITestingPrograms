package com.APIAutomation._05_TestNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTest19_DependsOnMethod {
    @Test
    public void serverStartedOk() {
        System.out.println("I will run first");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "serverStartedOk")
    public void test1() {
        System.out.println("method1");
        Assert.assertTrue(true);
    }

    @Test
    public void test2() {
        System.out.println("method2");
        Assert.assertTrue(true);
    }

}
