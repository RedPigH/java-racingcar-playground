package stringaddcalculator;

public class StringAddCalculator {
    static int result = 0;
    static String basic_op = ",|:";
    public static int splitAndSum(String input) {
        if(!checkNull(input)){
            return result;
        }

        if(checkSingleNum(input)){
            result = Integer.parseInt(input);
            return result;
        }
        String[] formula = splitInput(input);

        for(String str : formula){
            if(numVaildate(str)){
                result += Integer.parseInt(str);
            }
        }

        return result;
    }

    private static String[] splitInput(String input) {
        return input.split(basic_op);
    }

    private static boolean checkSingleNum(String input) {
        if(input.length() == 1 && numVaildate(input)){
            return true;
        }
        return false;
    }

    private static boolean numVaildate(String token) {
        return token.matches("[0-9]");
    }

    private static boolean checkNull(String input) {
        if(input == null || input.isEmpty()){
            return false;
        }
        return true;
    }
}
