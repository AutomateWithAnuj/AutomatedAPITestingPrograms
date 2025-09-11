package com.APIAutomation._05_TestNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTest22_AlwaysRun {
    @Test
    public void test01(){
        Assert.assertTrue(true);
    }
    @Test(alwaysRun = true, enabled = false) //will not run now
    public void test02(){
        Assert.assertTrue(true);
    }
    @Test
    public void test03(){
        Assert.assertTrue(true);
    }
}
