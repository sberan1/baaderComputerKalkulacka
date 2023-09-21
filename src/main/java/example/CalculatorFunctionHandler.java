package example;

import dev.sberan.*;

public class CalculatorFunctionHandler extends FunctionHandler {

    public CalculatorFunctionHandler(String[] args) {
        super(new CalculatorParameterInitializer(), args);
    }

    @Override
    public void handle() {
        doMath();
    }

    private void doMath(){
        ParameterInteger left = (ParameterInteger) getParameter("-l");
        ParameterInteger right = (ParameterInteger) getParameter("-r");
        ParameterOperationsEnum operation = (ParameterOperationsEnum) getParameter("-o");
        ParameterBoolean verbose = (ParameterBoolean) getParameter("-v");
        if (left.getValue() == null || right.getValue() == null || operation.getValue() == null){
            System.out.println("Missing required parameter");
            return;
        }

        if (operation.getValue() == Operations.DIVIDE && right.getValue() == 0){
            System.out.println("Cannot divide by 0");
            return;
        }
        if(verbose.getValue() == Boolean.TRUE && operation.getValue() == Operations.PLUS){
            System.out.println(left.getValue() + " + " + right.getValue() + " = " + (left.getValue() + right.getValue()));
        }
        else if(verbose.getValue() == Boolean.TRUE && operation.getValue() == Operations.MINUS){
            System.out.println(left.getValue() + " - " + right.getValue() + " = " + (left.getValue() - right.getValue()));
        }
        else if(verbose.getValue() == Boolean.TRUE && operation.getValue() == Operations.DIVIDE) {
            System.out.println(left.getValue() + " / " + right.getValue() + " = " + (left.getValue() / right.getValue()));
        }
        else if (verbose.getValue() == Boolean.TRUE && operation.getValue() == Operations.MULTIPLY) {
            System.out.println(left.getValue() + " * " + right.getValue() + " = " + (left.getValue() * right.getValue()));
        }
        else if (verbose.getValue() == Boolean.FALSE && operation.getValue() == Operations.PLUS){
            System.out.println(left.getValue() + right.getValue());
        } else if (verbose.getValue() == Boolean.FALSE && operation.getValue() == Operations.MINUS){
            System.out.println(left.getValue() - right.getValue());
        } else if (verbose.getValue() == Boolean.FALSE && operation.getValue() == Operations.DIVIDE){
            System.out.println(left.getValue() / right.getValue());
        } else if (verbose.getValue() == Boolean.FALSE && operation.getValue() == Operations.MULTIPLY){
            System.out.println(left.getValue() * right.getValue());
        }
    }




}
