package dev.sberan;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class ParameterString extends Parameter<String>{
    private Integer minValue;
    private Integer maxValue;

    public ParameterString(String key, String description, boolean hasValue, String[] alias, boolean isRequired) {
        super(null, key, description, hasValue, alias, isRequired);
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
