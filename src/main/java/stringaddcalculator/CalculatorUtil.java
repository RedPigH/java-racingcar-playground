package stringaddcalculator;

import java.util.regex.Pattern;

public class CalculatorUtil {

    public static Pattern isdisit = Pattern.compile(CalculatorOption.vaild_num_condition);

    public static boolean checkSingleNum(String input) {
        if(input.length() == 1 && numVaildate(input)){
            return true;
        }
        return false;
    }

    public static boolean numVaildate(String token) {
        if(!isdisit.matcher(token).matches()){
            throw new RuntimeException();
        }
        return true;
    }

    public static boolean checkNull(String input) {
        if(input == null || input.isEmpty()){
            return false;
        }
        return true;
    }
}
