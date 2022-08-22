package racingcar.domain;

import racingcar.util.RaceUtil;

public class Car {
    String name;
    int move;

    String mark;

    public Car(String name){
        this.name = name;
        this.move = 0;
        this.mark = "";
    }

    public int getMove(){
        return this.move;
    }

    public void moveCar(){
        if(RaceUtil.makeMoveStatus() >= RaceOption.possible_move){
            this.move += 1;
            this.mark += RaceOption.move_mark;
        }
    }
    public String toString() {
        return this.name + " : " + this.mark;
    }
}
