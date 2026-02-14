package com.APIAutomation._05_TestNG_Examples;

import org.testng.annotations.Test;

/**
 * This class demonstrates how TestNG executes test methods
 * based on the "priority" attribute.
 *
 * Lower priority number = executed first.
 * Higher priority number = executed later.
 *
 * Execution Order here will be:
 * t1() -> t2() -> t3() -> t4()
 */
public class ApiTest17_Priority {

    /**
     * priority = 1
     * This test will execute first because it has the lowest priority number.
     */
    @Test(priority = 1)
    public void t1() {
        System.out.println("1");  // Output: 1 (Executed 1st)
    }

    /**
     * priority = 2
     * This test will execute second.
     */
    @Test(priority = 2)
    public void t2() {
        System.out.println("3");  // Output: 3 (Executed 2nd)
        // Note: Although method name is t2, it prints "3" as per original logic.
    }

    /**
     * priority = 3
     * This test will execute third.
     */
    @Test(priority = 3)
    public void t3() {
        System.out.println("3");  // Output: 3 (Executed 3rd)
    }

    /**
     * priority = 4
     * This test will execute last.
     */
    @Test(priority = 4)
    public void t4() {
        System.out.println("4");  // Output: 4 (Executed 4th)
    }
}
