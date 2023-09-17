package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ParameterBoolean extends Parameter {
    private Boolean value = false;
    private final String[] trueAlias = {"true", "t", "yes", "y", "1"};
    private final String[] falseAlias = {"false", "f", "no", "n", "0"};
    public ParameterBoolean(String key, String description, boolean hasValue, String[] alias) {
        super(key, description, hasValue, alias);
    }

    public ParameterBoolean() {
    }

    public void setValue(String value) {
        if (value == null) {
            this.value = false;
        } else {
            for (String trueAlias : trueAlias) {
                if (value.equals(trueAlias)) {
                    this.value = true;
                    return;
                }
            }
            for (String falseAlias : falseAlias) {
                if (value.equals(falseAlias)) {
                    this.value = false;
                    return;
                }
            }
            System.out.println("Invalid value");
        }
    }

}

