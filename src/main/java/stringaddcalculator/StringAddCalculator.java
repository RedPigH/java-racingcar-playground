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

        if (!CalculatorUtil.checkNull(input)) {
            return 0;
        }

        if (CalculatorUtil.checkSingleNum(input)) {
            result = Integer.parseInt(input);
            return result;
        }
        String[] formula = splitInput(input);

        result = Arrays
                .stream(formula)
                .filter(number -> CalculatorUtil.isPositiveNum(number))
                .mapToInt(Integer::parseInt)
                .sum();

        return result;
    }
    private static String[] splitInput(String input) {
        if (isCustomOperation(input)) {
            return customsplit(input);
        }
        return input.split(CalculatorOption.basic_separator);
    }
    private static String[] customsplit(String input) {
        char custom_separator = input.charAt(CalculatorOption.custom_separator_index);
        input = input.substring(CalculatorOption.custom_begin_index);

        return input.split(String.valueOf(custom_separator));
    }
    private static boolean isCustomOperation(String input) {
        return input.matches(CalculatorOption.custom_separator);
    }
}
