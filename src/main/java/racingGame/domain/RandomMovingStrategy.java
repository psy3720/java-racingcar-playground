package racingGame.domain;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy {
    private static final int FORWARD_NUM = 4;
    private static final int RANDOM_NUM_BOUND = 9;

    @Override
    public Boolean isMovable() {
        if(createRandomNumber() >= FORWARD_NUM)
            return true;
        return false;
    }

    public static int createRandomNumber() {
        return new Random().nextInt(RANDOM_NUM_BOUND);
    }
}
