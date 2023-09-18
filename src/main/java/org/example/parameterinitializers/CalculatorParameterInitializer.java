package org.example.parameterinitializers;

import org.example.parameters.Parameter;
import org.example.parameters.ParameterBoolean;
import org.example.parameters.ParameterInteger;
import org.example.parameters.ParameterOperationsEnum;

import java.util.HashSet;
import java.util.Set;

public class CalculatorParameterInitializer implements IParamaterInitializer{
    Set<Parameter> validParameters = new HashSet<>();

    @Override
    public Set<Parameter> initialize() {
        ParameterBoolean help = new ParameterBoolean("help", "Prints help message", true, new String[]{"-h", "--help"});
        validParameters.add(help);
        ParameterInteger left = new ParameterInteger("left", "left number in an equasion", true, new String[]{"-l", "--left"}, true);
        validParameters.add(left);
        ParameterInteger right = new ParameterInteger("right", "right number in an equasion", true, new String[]{"-r", "--right"}, true);
        validParameters.add(right);
        ParameterOperationsEnum operation = new ParameterOperationsEnum("operation", "operation to be executed", true, new String[]{"-o", "--operation"}, true);
        validParameters.add(operation);
        ParameterBoolean verbose = new ParameterBoolean("verbose", "Prints full output with all data", true, new String[]{"-v", "--verbose"});
        validParameters.add(verbose);
        return validParameters;
    }
}
