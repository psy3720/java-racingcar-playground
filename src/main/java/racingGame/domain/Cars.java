package racingGame.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> carList;

    public Cars(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> move() {
        for (Car car : carList) {
            car.move(RacingGame.createRandomNumber());
        }
        return carList;
    }

    public List<Car> winnersCarList() {
        return getWinnersCarList(getMaxPosition());
    }

    private List<Car> getWinnersCarList(int max) {
        List<Car> winnersCarList = new ArrayList<>();

        for (Car car : carList) {
            if (car.isWinner(max)) {
                winnersCarList.add(car);
            }
        }
        return winnersCarList;
    }

    private int getMaxPosition() {
        int max = 0;

        for (Car car : carList) {
            car.getMaxPosition(new Position(max));
            if (car.isGreaterThanPosition(max)) {
                max = car.getPosition().getPosition();
            }
        }
        return max;
    }
}
