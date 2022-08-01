package racingGame.ui;

import racingGame.domain.Car;
import racingGame.domain.Cars;

import java.util.List;

public class ResultView {
    public void gameResultPrint(Cars carList) {
        String result = "";
        List<Car> winners = carList.winnersCarList();

        for(Car car : winners) {
            result += car.getName() + ", ";
        }
        result = result.substring(0, result.length() - 2);

        System.out.println(result + "가 최종 우승했습니다.");
    }

    public void movePrint(List<Car> carList) {
        String result = "";
        for (Car car : carList) {
            result += car.getName() + " : ";
            for (int i = 0; i < car.getPosition().getPosition(); i++) {
                result += "-";
            }
            result += "\n";
        }
        System.out.println(result);
    }

    public void resultPrint() {
        System.out.println("실행 결과");
    }
}
