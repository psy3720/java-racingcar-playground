package racingGame.domain;

import java.util.Objects;

public class Car {
    private static final int FORWARD_NUM = 4;
    private Name name;
    private Position position;

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public Position move(MovingStrategy movingStrategy) {
        if(movingStrategy.isMovable()) {
            return position.plus();
        }
        return position;
    }

    public Position move(int randomNumber) {
        if (randomNumber >= FORWARD_NUM) {
            return position.plus();
        }
        return position;
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isWinner(int max) {
        return position.getPosition() == max;
    }

    public boolean isGreaterThanPosition(int max) {
        return position.getPosition() > max;
    }

    public Position getMaxPosition(Position position) {
        if (this.position.lessThan(position)) {
            return position;
        }
        return this.position;
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
