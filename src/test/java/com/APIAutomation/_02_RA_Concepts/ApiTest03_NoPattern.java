package com.APIAutomation._02_RA_Concepts;

public class ApiTest03_NoPattern {
    public void step1() {
        System.out.println("Step 1");
    }

    public void step2() {
        System.out.println("Step 2");
    }

    public void step3(String param1) {
        System.out.println("Step 3");
    }

    public static void main(String[] args) {
        ApiTest03_NoPattern np = new ApiTest03_NoPattern();
        np.step1();
        np.step2();
        np.step3("Anuj");//here each will be run one by one
    }
}
