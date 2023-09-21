package dev.sberan;

import java.util.Set;

public class ParameterHelp extends ParameterBoolean{
    Set<Parameter> parameters;
    public ParameterHelp(Set<Parameter> parameters) {
        super("help", "Prints help", false, new String[]{"-h", "--help"});
        this.parameters= parameters;
    }
    @Override
    public int action(String[] args, int index) {
        printHelp();
        return index;
    }
    public void printHelp() {
        System.out.println("Help message");
        for (Parameter parameter : parameters){
            System.out.println(parameter.getKey() + " | " + parameter.getDescription() + " | " + String.join(", ", parameter.getAlias()));
        }
    }
}
