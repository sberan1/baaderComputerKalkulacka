package org.example;

import java.util.Set;

public class CalculatorFunctionHandler implements IFunctionHandler{
    private final IParamaterInitializer paramaterInitializer = new CalculatorParameterInitializer();
    private Set<Parameter> parameters = paramaterInitializer.initialize();
    @Override
    public void handle(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if (arg.startsWith("-")) {
                Parameter parameter = getParameter(arg);
                if (parameter != null) {
                    i = processParameter(parameter, args, i);
                } else {
                    System.out.println("Parameter " + arg + " is not supported.");
                }
            }
        }

        for (Parameter parameter : parameters) {
            if (parameter.isRequired() && parameter.getValue() == null)
            {
                doMath();
                return;
            }
        }

    }

    private void doMath() {
        ParameterInteger left = (ParameterInteger) getParameter("-l");
        ParameterInteger right = (ParameterInteger) getParameter("-r");
        ParameterOperationsEnum operation = (ParameterOperationsEnum) getParameter("-o");
        ParameterBoolean verbose = (ParameterBoolean) getParameter("-v");
        if (operation.getValue() == Operations.DIVIDE && right.getValue() == 0){
            System.out.println("Cannot divide by 0");
        }
        if (verbose.getValue() == Boolean.TRUE){
            switch (operation.getValue()){
                case PLUS:
                    System.out.println(left.getValue() + " + " + right.getValue() + " = " + (left.getValue() + right.getValue()));
                    break;
                case MINUS:
                    System.out.println(left.getValue() + " - " + right.getValue() + " = " + (left.getValue() - right.getValue()));
                    break;
                case MULTIPLY:
                    System.out.println(left.getValue() + " * " + right.getValue() + " = " + (left.getValue() * right.getValue()));
                    break;
                case DIVIDE:
                    System.out.println(left.getValue() + " / " + right.getValue() + " = " + (left.getValue() / right.getValue()));
                    break;
            }
        }
        else {
            switch (operation.getValue()){
                case PLUS:
                    System.out.println(left.getValue() + right.getValue());
                    break;
                case MINUS:
                    System.out.println(left.getValue() - right.getValue());
                    break;
                case MULTIPLY:
                    System.out.println(left.getValue() * right.getValue());
                    break;
                case DIVIDE:
                    System.out.println(left.getValue() / right.getValue());
                    break;
            }
        }
    }

    private int processParameter(Parameter parameter, String[] args, int index) {
        switch (parameter.getKey()) {
            case "left":
            case "right":
                parameter.setValue(Integer.parseInt(args[index + 1]));
                return index + 1;
            case "operation":
                parameter.setValue(args[index + 1]);
                return index + 1;
            case "verbose":
                if(args[index + 1].startsWith("-")){
                    parameter.setValue(true);
                    return index;
                }
                else {
                    parameter.setValue(args[index + 1]);
                    return index + 1;
                }
            case "help":
                printHelp();
                return index;
            default:
                System.out.println("Parameter " + parameter.getKey() + " is not supported.");
                return index;
        }
    }

    private void printHelp() {
        System.out.println("Help message");
        for (Parameter parameter : parameters){
            System.out.println(parameter.getKey() + " | " + parameter.getDescription() + " | " + String.join(", ", parameter.getAlias()));
        }
    }

    private Parameter getParameter(String arg) {
        for(Parameter parameter : parameters){
            for (String e : parameter.getAlias()){
                if(arg.equals(e)){
                    return parameter;
                }
            }
        }
        return null;
    }
}
