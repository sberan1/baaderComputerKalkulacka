package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ParameterInteger extends Parameter{
    private Integer value;
    private Integer minValue;
    private Integer maxValue;

    public ParameterInteger(String key, String description, boolean hasValue, String[] alias) {
        super(key, description, hasValue, alias);
    }

    public ParameterInteger() {
    }

    public void setValue(int value) {
        if ((minValue == null || value >= minValue) && (maxValue == null || value <= maxValue)) {
            this.value = value;
        } else {
            System.out.println("Value must be between " + minValue + " and " + maxValue);
        }
    }
}
