package racingcar.domain;

import org.apache.commons.lang3.StringUtils;
import racingcar.io.InputProcess;
import racingcar.io.OutputProcess;
import racingcar.util.RaceUtil;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private static List<Car> racingCar;

    public static List<Car> setRacingCar(List<String> Cars){

        racingCar = new ArrayList<Car>();

        for(int i = 0 ; i < Cars.size(); i++){
            racingCar.add(new Car(Cars.get(i)));
        }

        return racingCar;
    }

    public static List<Car> racing(List<Car> carlist, int tryCnt) {

        for (int i = 0; i < tryCnt; i++) {
            for (Car car : carlist) {
                car.moveCar();
                System.out.println(car);
            }
            System.out.println();
        }

        return carlist;
    }

    public static String getWinner(){
        ArrayList<String> winner = new ArrayList<String>();

        int max = RaceUtil.maxMove(racingCar);

        for(Car car : racingCar){
            if(car.getMove() == max){
                winner.add(car.name);
            }
        }

        return StringUtils.join(winner,", ");
    }

    public static void main(String[] args) {
        InputProcess inputProcess = new InputProcess();
        OutputProcess outputProcess = new OutputProcess();
        inputProcess.startRaceEvent();

        List<Car> result = racing(setRacingCar(inputProcess.getInpulist()), inputProcess.getTryCnt());

        outputProcess.endRaceEvent(getWinner());
    }
}
