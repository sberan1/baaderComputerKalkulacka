package org.example;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ParameterString extends Parameter{
    private String value;
    private Integer minValue;
    private Integer maxValue;

    public ParameterString(String key, String description, boolean hasValue, String[] alias) {
        super(key, description, hasValue, alias);
    }

    public ParameterString() {
    }

    public void setValue(String value) {
        if((minValue == null || value.length() >= minValue) && (maxValue == null || value.length() <= maxValue)) {
            this.value = value;
        }
        else {
            System.out.println("Length must be between " + minValue + " and " + maxValue);
        }
    }
}
