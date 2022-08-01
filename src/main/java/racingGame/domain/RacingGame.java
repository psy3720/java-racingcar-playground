package racingGame.domain;

import racingGame.ui.InputView;
import racingGame.ui.ResultView;

import java.util.Random;

public class RacingGame {
    private static final int RANDOM_NUM_BOUND = 9;
    Cars carList;
    ResultView resultView;
    InputView inputView;

    public RacingGame() {
        resultView = new ResultView();
        inputView = new InputView();
    }

    public void start() {
        carList = new Cars(inputView.inputCarNames());
        this.start(inputView.inputTryCount());
    }

    public void start(int count) {
        resultView.resultPrint();
        for (int i = 0; i < count; i++) {
            resultView.movePrint(carList.move());
        }
        resultView.gameResultPrint(carList);
    }

    public static int createRandomNumber() {
        return new Random().nextInt(RANDOM_NUM_BOUND);
    }
}
