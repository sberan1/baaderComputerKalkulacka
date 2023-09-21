package dev.sberan;

import java.util.Set;

public abstract class FunctionHandler {
    public abstract void handle();
    public FunctionHandler(ParamaterInitializer paramaterInitializer, String[] args){
        this.parameters = paramaterInitializer.initialize();
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if (arg.startsWith("-")) {
                Parameter parameter = getParameter(arg);
                if (parameter != null) {
                    i = parameter.action(args, i);
                } else {
                    System.out.println("Parameter " + arg + " is not supported.");
                }
            }
        }
    }
    private Set<Parameter> parameters;
    public Parameter getParameter(String arg) {
        for(Parameter parameter : parameters){
            for (String e : parameter.getAlias()){
                if(arg.equals(e)){
                    return parameter;
                }
            }
        }
        return null;
    }

    public Set<Parameter> getParameters() {
        return parameters;
    }
}
