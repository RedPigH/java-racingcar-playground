package racingcar.util;

import racingcar.domain.Car;
import racingcar.domain.RaceOption;
import racingcar.io.InputProcess;

import java.util.List;
import java.util.Random;

public class RaceUtil {

    public static boolean checkNameLength(String name) {
        if (name.length() > 5) {
            //throw new RuntimeException("Car name cannot exceed 5 characters");\
            return false;
        }
        return true;
    }

    public static void isInputNull(String input){
        if(input.isEmpty() || input == null){
            throw new RuntimeException("Your input is not valid(null or empty");
        }
    }

    public static String[] splitInput(String input){
        return input.split(RaceOption.car_separator);
    }

    public static int makeMoveStatus(){
        Random ran = new Random();
        return ran.nextInt(10);
    }

    public static int maxMove(List<Car> carlist){
        int max = Integer.MIN_VALUE;

        for(Car car : carlist){
            if(car.getMove() > max){
                max = car.getMove();
            }
        }

        return max;
    }
}
