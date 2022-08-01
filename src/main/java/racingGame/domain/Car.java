package racingGame.domain;

import java.util.Objects;

public class Car {
    private Name name;
    private Position position;

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public Position move(int randomNumber) {
        if (randomNumber >= 4) {
            position.plus();
        }
        return position;
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isEqualPosition(int max) {
        return position.getPosition() == max;
    }

    public boolean isGreaterThanPosition(int max) {
        return position.getPosition() > max;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
