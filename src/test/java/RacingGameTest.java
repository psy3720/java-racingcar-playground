import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    @Test
    void gameStart() {
        RacingGame racingGame = new RacingGame("pobi,honux,rara");
        racingGame.start(5);
    }
}
