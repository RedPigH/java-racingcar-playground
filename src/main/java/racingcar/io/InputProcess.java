package racingcar.io;

import racingcar.util.RaceUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputProcess {

    private String input;
    private List<String> inputlist;

    private int tryCnt;
    private Scanner scan = new Scanner(System.in);

    public void startRaceEvent() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        input = scan.next();

        RaceUtil.isInputNull(input);

        String[] Cars = RaceUtil.splitInput(input);

        inputlist = new ArrayList<String>();

        for (String car : Cars) {
            RaceUtil.checkNameLength(car);
            System.out.println(car);
            inputlist.add(car);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        tryCnt = scan.nextInt();
    }

    public List<String> getInpulist() {
        return this.inputlist;
    }

    public int getTryCnt(){
        return this.tryCnt;
    }
}
