import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.NikitaPopovskiy.model.Player;
import ru.NikitaPopovskiy.model.PointScoreTiebreak;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PointScoreTiebreakTest {
    private final Player firstPlayerTest = new Player(1, "FirstPlayerTest");
    private final Player secondPlayerTest = new Player(2, "SecondPlayerTest");
    private PointScoreTiebreak pointScoreTiebreak;

    @BeforeEach
    void init () {
        this.pointScoreTiebreak = new PointScoreTiebreak(firstPlayerTest, secondPlayerTest);
    }

    @Test
    void pointByWon_whenScoreIs_0_0_Should_1_0() {
        pointScoreTiebreak.pointWonBy(firstPlayerTest);

        assertEquals("1", pointScoreTiebreak.getPlayerScoreDisplay(firstPlayerTest));
        assertEquals("0", pointScoreTiebreak.getPlayerScoreDisplay(secondPlayerTest));
    }

    @Test
    void pointByWon_whenScoreIs_6_0_Should_Win() {
        putScore(firstPlayerTest, 6);

        pointScoreTiebreak.pointWonBy(firstPlayerTest);

        assertEquals(firstPlayerTest, pointScoreTiebreak.getWinner());
    }

    @Test
    void pointByWon_whenScoreIs_6_6_Should_7_6() {
        putScore(firstPlayerTest, 6);
        putScore(secondPlayerTest, 6);

        pointScoreTiebreak.pointWonBy(firstPlayerTest);

        assertEquals("7", pointScoreTiebreak.getPlayerScoreDisplay(firstPlayerTest));
        assertEquals("6", pointScoreTiebreak.getPlayerScoreDisplay(secondPlayerTest));
    }

    @Test
    void pointByWon_whenScoreIs_6_5_Should_Win() {
        putScore(firstPlayerTest, 6);
        putScore(secondPlayerTest, 5);

        pointScoreTiebreak.pointWonBy(firstPlayerTest);

        assertEquals(firstPlayerTest, pointScoreTiebreak.getWinner());
    }

    @Test
    void pointByWon_whenScoreIs_6_6_Should_7_7() {
        putScore(firstPlayerTest, 6);
        putScore(secondPlayerTest, 6);

        pointScoreTiebreak.pointWonBy(firstPlayerTest);
        pointScoreTiebreak.pointWonBy(secondPlayerTest);

        assertEquals("7", pointScoreTiebreak.getPlayerScoreDisplay(firstPlayerTest));
        assertEquals("7", pointScoreTiebreak.getPlayerScoreDisplay(secondPlayerTest));
        assertNull(pointScoreTiebreak.getWinner());
    }

    @Test
    void pointByWon_whenScoreIs_6_6_Should_Win() {
        putScore(firstPlayerTest, 6);
        putScore(secondPlayerTest, 6);

        pointScoreTiebreak.pointWonBy(firstPlayerTest);
        pointScoreTiebreak.pointWonBy(firstPlayerTest);

        assertEquals(firstPlayerTest, pointScoreTiebreak.getWinner());
    }


    private void putScore(Player player, int score) {
        for(int i = 0; i < score; i++) {
            pointScoreTiebreak.pointWonBy(player);
        }
    }

}
