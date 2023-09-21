package example;

import dev.sberan.ParameterBoolean;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ParameterVerbose extends ParameterBoolean {
    public ParameterVerbose() {
        super("verbose", "Prints full output with all data", true, new String[]{"-v", "--verbose"});
    }

    @Override
    public int action(String[] args, int index) {
        if(index + 1 >= args.length || args[index + 1].startsWith("-")){
            setValue(true);
            return index;
        }
        else {
            setValue(args[index + 1]);
            return index + 1;
        }
    }
}
