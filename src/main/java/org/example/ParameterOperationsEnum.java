package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ParameterOperationsEnum extends Parameter{
    private Operations value;

    public ParameterOperationsEnum(String key, String description, boolean hasValue, String[] alias) {
        super(key, description, hasValue, alias);
    }

    public ParameterOperationsEnum() {
    }

    public void setValue(String value) {
        try {
            this.value = Operations.valueOf(value);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid value");
        }
    }
}
