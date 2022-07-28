package stringaddcalculator;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringAddCalculator {
    static int result;

    public static int splitAndSum(String input) {
        result = calculate(input);

        return result;
    }

    private static int calculate(String input) {

        if(!CalculatorUtil.checkNull(input)){
            return 0;
        }

        if(CalculatorUtil.checkSingleNum(input)){
            result = Integer.parseInt(input);
            return result;
        }
        String[] formula = splitInput(input);

        result = Arrays.stream(Stream.of(formula).filter(n ->CalculatorUtil.numVaildate(n)).mapToInt(Integer::parseInt).toArray()).sum();

        return result;
    }

    private static String[] splitInput(String input) {
        if(isCustomOperation(input)){
            return customsplit(input);
        }
        return input.split(CalculatorOption.basic_separator);
    }

    private static String[] customsplit(String input) {
        char custom_op = input.charAt(CalculatorOption.custom_op_index);
        input = input.substring(CalculatorOption.custom_begin_index);

        return input.split(String.valueOf(custom_op));
    }

    private static boolean isCustomOperation(String input) {
        return input.matches(CalculatorOption.custom_separator);
    }
}
