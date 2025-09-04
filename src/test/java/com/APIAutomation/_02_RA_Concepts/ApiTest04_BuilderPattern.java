package com.APIAutomation._02_RA_Concepts;

public class ApiTest04_BuilderPattern {
    public ApiTest04_BuilderPattern step1() {
        System.out.println("Step 1");
        return this;
    }
    public ApiTest04_BuilderPattern step2() {
        System.out.println("Step 2");
        return this;
    }
    public ApiTest04_BuilderPattern step3(String param1) {
        System.out.println("Step 3");
        return this;
    }
    public static void main(String[] args) {
        ApiTest04_BuilderPattern bp = new ApiTest04_BuilderPattern();
    }
}
