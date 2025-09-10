package com.APIAutomation._05_TestNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTest18_Groups {
    //let's suppose in groups I have
    //sanity -> 1
    //reg -> 3
    //p1 -> 2
    @Test(groups = {"sanity","reg"},priority = 1)
    public void test_sanityRun(){
        System.out.println("Sanity");
        System.out.println("Reg");
        Assert.assertTrue(true);
    }
    @Test(groups = {"reg"},priority = 2)
    public void test_regRun(){
        System.out.println("Reg");
        Assert.assertTrue(false);
    }
    @Test(groups = {"sanity","p1","reg"},priority = 3)
    public void test_smokeRun(){
        System.out.println("Smoke");
        Assert.assertTrue(false);
    }
}
