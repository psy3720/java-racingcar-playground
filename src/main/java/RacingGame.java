import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGame {
    final Cars cars;
    public RacingGame(String cars) {
        this.cars = new Cars(cars);
    }

    public void start(int count) {
        for(int i = 0; i<count; i++) {
            cars.move();
        }
        cars.result();
    }
}
