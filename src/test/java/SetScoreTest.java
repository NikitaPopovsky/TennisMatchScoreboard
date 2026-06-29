import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.NikitaPopovskiy.model.GameScore;
import ru.NikitaPopovskiy.model.Player;
import ru.NikitaPopovskiy.model.SetScore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SetScoreTest {
    private final int POINT_TO_WIN_GAME = 4;
    private final int POINT_TO_WIN_SET = 6;
    private final Player firstPlayerTest = new Player(1, "FirstPlayerTest");
    private final Player secondPlayerTest = new Player(2, "SecondPlayerTest");
    private SetScore setScore;

    @BeforeEach
    void init () {
        this.setScore = new SetScore(firstPlayerTest, secondPlayerTest);
    }

    @Test
    void pointByWon_whenScoreIs_0_0_Should_1_0() {
        addScore(firstPlayerTest, 1);

        assertEquals("1",setScore.getPlayerScoreDisplay(firstPlayerTest));
        assertEquals("0",setScore.getPlayerScoreDisplay(secondPlayerTest));
        assertFalse(setScore.hasWinner());
    }

    @Test
    void pointByWon_whenScoreIs_1_1_Should_Win() {
        addScore(firstPlayerTest, 1);
        addScore(secondPlayerTest, 1);

        addScore(firstPlayerTest, 1);

        assertEquals(firstPlayerTest, setScore.getWinner());
    }

    @Test
    void pointByWon_whenScoreIs_1_0_Should_Win() {
        addScore(firstPlayerTest, 2);

        assertEquals(firstPlayerTest, setScore.getWinner());
    }

    private void addScore(Player player, int score) {
        score = score * POINT_TO_WIN_SET * POINT_TO_WIN_GAME;

        for(int i = 0; i < score; i++) {
            setScore.pointWonBy(player);
        }
    }
}
