package dev.sberan;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public abstract class ParameterBoolean extends Parameter<Boolean> {
    private String[] trueAlias = {"true", "t", "yes", "y", "1"};
    private String[] falseAlias = {"false", "f", "no", "n", "0"};

    public ParameterBoolean(String key, String description, boolean hasValue, String[] alias) {
        super(false, key, description, hasValue, alias, false);
    }

    public ParameterBoolean() {
    }

    public void setValue(String value) {
        if (value == null) {
            this.value = true;
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

