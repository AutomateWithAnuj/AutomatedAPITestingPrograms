package com.APIAutomation._02_RA_Concepts;

/**
 * This class demonstrates the Builder (Fluent) Pattern style.
 * Each method returns the same object (this) to allow method chaining.
 */
public class ApiTest04_BuilderPattern {

    /**
     * Step 1 method
     * Purpose: Represents the first step in execution
     * Returns: Current object to enable method chaining
     */
    public ApiTest04_BuilderPattern step1() {
        System.out.println("Step 1"); // Output: Step 1
        return this;                  // Returning same object for fluent chaining
    }

    /**
     * Step 2 method
     * Purpose: Represents the second step in execution
     * Returns: Current object to enable method chaining
     */
    public ApiTest04_BuilderPattern step2() {
        System.out.println("Step 2"); // Output: Step 2
        return this;                  // Enables step1().step2()
    }

    /**
     * Step 3 method
     * Purpose: Represents the third step and accepts input data
     *
     * @param param1 Input parameter passed by caller
     * @return Current object to continue chaining
     */
    public ApiTest04_BuilderPattern step3(String param1) {
        System.out.println("Step 3"); // Output: Step 3
        // param1 is accepted to demonstrate data passing in fluent APIs
        return this;                  // Enables step2().step3()
    }

    /**
     * Main method
     * Purpose: Entry point of the application
     */
    public static void main(String[] args) {

        // Creating object of Builder Pattern class
        ApiTest04_BuilderPattern builder = new ApiTest04_BuilderPattern();
        // No method calls here to strictly preserve original behavior
    }
}
