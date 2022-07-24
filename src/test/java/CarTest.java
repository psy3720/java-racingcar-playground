import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    @DisplayName("차이름은 최대 5자리")
    void createCar() {
        assertThatThrownBy(() -> new Car("carname"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("4이상인 경우 이동")
    void isMove() {
        Car car = new Car("car");
        assertThat(car.isMove(4)).isTrue();
    }

    @Test
    void moveCarPrint() {
        Car car = new Car("car");
        assertThat(car.getPosition()).isEqualTo("car : -");
    }

    @Test
    void max() {

    }

    public static void main(String[] args) {
        RacingGame racingGame = new RacingGame("pobi,nunu,rara");
        racingGame.start(5);
    }
}
