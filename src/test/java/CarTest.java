import racingGame.domain.Cars;
import racingGame.domain.Position;
import racingGame.domain.RacingGame;
import racingGame.domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    @DisplayName("차이름이 널값 또는 공백이면 에러")
    void createCarName_NullOrEmpty() {
        assertThatThrownBy(() -> new Car(null, 0)).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> new Car("", 0)).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("차이름은 5글자 넘어가면 에러")
    void createCarName_5글자넘어가면_에러() {
        assertThatThrownBy(() -> new Car("abcdefg", 0)).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("차이름은 5글자까지 가능")
    void createCarName_5글자까지가능() {
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
    @DisplayName("랜덤값이 4이상인 경우 이동")
    void move2_인터페이스사용() {
        Car car = new Car("test", 0);
        Position position = car.move(() -> true);
        assertThat(position).isEqualTo(new Position(1));
    }


    @Test
    @DisplayName("랜덤값이 4이하인 경우 그대로")
    void move_4이하_인터페이스사용() {
        Car car = new Car("test", 0);
        Position position = car.move(() -> false);
        assertThat(position).isEqualTo(new Position(0));
    }

    @Test
    void createRandomNumber() {
        RacingGame racingGame = new RacingGame();
        int randomNum = racingGame.createRandomNumber();
        assertThat(randomNum).isGreaterThanOrEqualTo(0);
        assertThat(randomNum).isLessThanOrEqualTo(9);
    }

    @Test
    @DisplayName("우승자 찾기")
    void winnersCarList() {
        Car car1 = new Car("test1", 2);
        Car car2 = new Car("test2", 0);
        Car car3 = new Car("test3", 3);

        Cars cars = new Cars(Arrays.asList(car1, car2, car3));
        List<Car> cars1 = cars.winnersCarList();
        assertThat(cars1).containsExactly(car3);
    }
}
