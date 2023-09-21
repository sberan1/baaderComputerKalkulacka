package dev.sberan;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Parameter<T> {
    protected T value;
    private String key;
    private String description;
    private boolean hasValue;
    private String[] alias;
    private boolean required;
    public abstract int action(String[] args, int index);
}
