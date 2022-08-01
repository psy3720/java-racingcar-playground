package racingGame.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> carList;

    public Cars(String carNames) {
        carList = new ArrayList<>();

        String[] strings = carNames.split(",");
        for (String carName : strings) {
            carList.add(new Car(carName, 1));
        }
    }

    public List<Car> move() {
        for (Car car : carList) {
            car.move(RacingGame.createRandomNumber());
        }
        return carList;
    }

    public List<Car> winnersCarList() {
        List<Car> winnersCarList = new ArrayList<>();
        int max = 0;

        for (Car car : carList) {
            if (car.isGreaterThanPosition(max)) {
                max = car.getPosition().getPosition();
            }
        }

        for (Car car : carList) {
            if (car.isEqualPosition(max)) {
                winnersCarList.add(car);
            }
        }

        return winnersCarList;
    }
}
