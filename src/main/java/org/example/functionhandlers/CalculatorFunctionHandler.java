package org.example.functionhandlers;

import org.example.parameterinitializers.CalculatorParameterInitializer;
import org.example.parameterinitializers.IParamaterInitializer;
import org.example.enums.Operations;
import org.example.parameters.Parameter;
import org.example.parameters.ParameterBoolean;
import org.example.parameters.ParameterInteger;
import org.example.parameters.ParameterOperationsEnum;

import java.util.Set;

public class CalculatorFunctionHandler implements IFunctionHandler{
    private final IParamaterInitializer paramaterInitializer = new CalculatorParameterInitializer();
    private final Set<Parameter> parameters = paramaterInitializer.initialize();
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
        doMath();

    }

    private void doMath(){
        ParameterInteger left = (ParameterInteger) getParameter("-l");
        ParameterInteger right = (ParameterInteger) getParameter("-r");
        ParameterOperationsEnum operation = (ParameterOperationsEnum) getParameter("-o");
        ParameterBoolean verbose = (ParameterBoolean) getParameter("-v");
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

    private int processParameter(Parameter parameter, String[] args, int index) {
        switch (parameter.getKey()) {
            case "left":
            case "right":
                ((ParameterInteger)parameter).setValue(Integer.parseInt(args[index + 1]));
                return index + 1;
            case "operation":
                ((ParameterOperationsEnum)parameter).setValue(args[index + 1]);
                return index + 1;
            case "verbose":
                if(index + 1 >= args.length || args[index + 1].startsWith("-")){
                    ((ParameterBoolean)parameter).setValue(true);
                    return index;
                }
                else {
                    ((ParameterBoolean)parameter).setValue(args[index + 1]);
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
