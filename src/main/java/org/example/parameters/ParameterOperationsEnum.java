package org.example.parameters;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.Operations;

@Getter @Setter
public class ParameterOperationsEnum extends Parameter<Operations>{

    public ParameterOperationsEnum(String key, String description, boolean hasValue, String[] alias, boolean isRequired) {
        super(null, key, description, hasValue, alias, isRequired);
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