package org.example;

import org.example.functionhandlers.CalculatorFunctionHandler;
import org.example.functionhandlers.IFunctionHandler;

public class Main {
    public static void main(String[] args) {
        IFunctionHandler calculatorFunctionHandler = new CalculatorFunctionHandler();
        calculatorFunctionHandler.handle(args);
    }
}