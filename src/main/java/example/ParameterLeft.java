package example;

import dev.sberan.ParameterInteger;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ParameterLeft extends ParameterInteger {

    public ParameterLeft() {
        super("left", "The left operand",true, new String[]{"-l", "--left"}, true);
    }

    @Override
    public int action(String[] args, int index) {
        try{
            setValue(Integer.parseInt(args[index + 1]));
        }
        catch (NumberFormatException e){
            System.out.println("Invalid value");
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Missing value");
        }
        return index + 1;
    }
}

