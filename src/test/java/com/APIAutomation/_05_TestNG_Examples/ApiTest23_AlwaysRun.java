package com.APIAutomation._05_TestNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiTest23_AlwaysRun {
    @Test
    public void test_new_register() {
        Assert.assertTrue(true);
    }

    @Test(alwaysRun = true)//this test case we will run always when someone is
    // regirstered to check if he is on the login page
    public void test_loginPage() {
        Assert.assertTrue(true);
    }

    @Test
    public void test_normal() {
        Assert.assertTrue(true);
    }
}
