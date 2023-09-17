package org.example;

public class Main {
    public static void main(String[] args) {
        IFunctionHandler calculatorFunctionHandler = new CalculatorFunctionHandler();
        calculatorFunctionHandler.handle(args);
    }
}