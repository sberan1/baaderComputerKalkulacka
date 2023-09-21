package example;

import dev.sberan.*;
import java.util.Set;

public class CalculatorParameterInitializer extends ParamaterInitializer {
    @Override
    public Set<Parameter> initialize() {
        ParameterOperationsEnum operation = new ParameterOperationsEnum();
        addValidParameter(operation);
        ParameterInteger left = new ParameterLeft();
        addValidParameter(left);
        ParameterInteger right = new ParameterRight();
        addValidParameter(right);
        ParameterBoolean verbose = new ParameterVerbose();
        addValidParameter(verbose);
        return getValidParameters();
    }
}
