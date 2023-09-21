package example;

import dev.sberan.Parameter;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ParameterOperationsEnum extends Parameter<Operations> {

    public ParameterOperationsEnum() {
        super(null, "operation", "operation to be executed", true, new String[]{"-o", "--operation"}, true);
    }

    public void setValue(String value) {
        try {
            this.value = Operations.valueOf(value);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid value");
        }
    }

    @Override
    public int action(String[] args, int index) {
        setValue(args[index + 1]);
        return index + 1;    }
}
