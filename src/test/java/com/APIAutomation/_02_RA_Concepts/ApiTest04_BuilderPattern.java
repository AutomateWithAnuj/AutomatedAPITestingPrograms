package com.APIAutomation._02_RA_Concepts;

/**
 * This class demonstrates a Real Builder Pattern
 * similar to how Rest Assured works.
 *
 * Each step returns a DIFFERENT object,
 * and the next step works on that returned object.
 */
public class ApiTest04_BuilderPattern {

    /**
     * Step 1 - Similar to given()
     * Returns RequestSpecification object
     */
    public static RequestSpecification step1() {
        System.out.println("Step 1 - Preparing Request");
        return new RequestSpecification();
    }

    /**
     * RequestSpecification class
     * Similar to Rest Assured's RequestSpecification
     */
    static class RequestSpecification {

        /**
         * Step 2 - Similar to when()
         * Returns Response object
         */
        public Response step2() {
            System.out.println("Step 2 - Sending Request");
            return new Response();
        }
    }

    /**
     * Response class
     * Similar to Rest Assured's Response
     */
    static class Response {

        /**
         * Step 3 - Similar to then()
         * Returns ValidatableResponse object
         */
        public ValidatableResponse step3(String param1) {
            System.out.println("Step 3 - Validating Response");
            System.out.println("Parameter Passed: " + param1);
            return new ValidatableResponse();
        }
    }

    /**
     * Final Validation class
     */
    static class ValidatableResponse {

        public void statusCode(int code) {
            System.out.println("Validating Status Code: " + code);
        }
    }

    /**
     * Main method
     */
    public static void main(String[] args) {

        // Real Builder Flow
        step1()
                .step2()
                .step3("Sample Data")
                .statusCode(200);
    }
}
