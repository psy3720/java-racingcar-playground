import racingGame.domain.Position;
import racingGame.domain.RacingGame;
import racingGame.domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void createCarName_NullOrEmpty() {
        assertThatThrownBy(() -> new Car(null, 0)).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> new Car("", 0)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void createCarName_5글자까지가능() {
        assertThatThrownBy(() -> new Car("abcdefg", 0)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void createCarName_5글자까지가능2() {
        Car abc = new Car("abc", 0);
        assertThat(abc).usingRecursiveComparison().isEqualTo(new Car("abc", 0));
    }

    @Test
    void createCar() {
        Car car = new Car("popo", 0);
        assertThat(car).usingRecursiveComparison().isEqualTo(new Car("popo", 0));
    }

    @Test
    @DisplayName("랜덤값이 4이상인 경우 이동")
    void move() {
        Car car = new Car("test", 0);
        Position position = car.move(4);
        assertThat(position).isEqualTo(new Position(1));
    }

    @Test
    @DisplayName("랜덤값이 4이하인 경우 그대로")
    void move_4이하() {
        Car car = new Car("test", 0);
        Position position = car.move(0);
        assertThat(position).isEqualTo(new Position(0));
    }

    @Test
    void createRandomNumber() {
        RacingGame racingGame = new RacingGame();
        int randomNum = racingGame.createRandomNumber();
        assertThat(randomNum).isGreaterThanOrEqualTo(0);
        assertThat(randomNum).isLessThanOrEqualTo(9);
    }

}
