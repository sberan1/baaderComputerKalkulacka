package dev.sberan;

import java.util.HashSet;
import java.util.Set;

public abstract class ParamaterInitializer {
    private Set<Parameter> validParameters = new HashSet<>();
    public abstract Set<Parameter> initialize();

    public ParamaterInitializer() {
        ParameterHelp help = new ParameterHelp(validParameters);
        validParameters.add(help);
    }

    public Set<Parameter> getValidParameters() {
        return validParameters;
    }

    public void addValidParameter(Parameter parameter) {
        this.validParameters.add(parameter);
    }
}
