package racingGame.ui;

import java.util.Scanner;

public class InputView {
    Scanner sc;

    public InputView() {
        this.sc = new Scanner(System.in);
    }

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carNames = sc.next();
        return carNames;
    }

    public int inputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = sc.nextInt();
        return tryCount;
    }
}
