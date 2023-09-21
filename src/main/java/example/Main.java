package example;

import dev.sberan.FunctionHandler;

public class Main {
    public static void main(String[] args) {
        FunctionHandler calculatorFunctionHandler = new CalculatorFunctionHandler(args);
        calculatorFunctionHandler.handle();
    }
}