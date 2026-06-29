import org.checkerframework.checker.lock.qual.MayReleaseLocks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.NikitaPopovskiy.enums.TennisPoint;
import ru.NikitaPopovskiy.model.AbstractPointScore;
import ru.NikitaPopovskiy.model.GameScore;
import ru.NikitaPopovskiy.model.Player;
import ru.NikitaPopovskiy.model.PointScoreTiebreak;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class GameScoreTest {
    private final int POINT_TO_WIN_GAME = 4;
    private final int POINT_TO_WIN_GAME_TIEBREAK = 7;
    private final Player firstPlayerTest = new Player(1, "FirstPlayerTest");
    private final Player secondPlayerTest = new Player(2, "SecondPlayerTest");
    private GameScore gameScore;
    private Boolean isTiebreak;

    @BeforeEach
    void init () {
        this.gameScore = new GameScore(firstPlayerTest, secondPlayerTest);
        this.isTiebreak = false;
    }

    @Test
    void pointByWon_whenScoreIs_0_0_Should_1_0() {
        addScore(firstPlayerTest, 1, isTiebreak);

        assertEquals("1",gameScore.getPlayerScoreDisplay(firstPlayerTest));
        assertEquals("0",gameScore.getPlayerScoreDisplay(secondPlayerTest));
        assertFalse(gameScore.hasWinner());
    }

    @Test
    void pointByWon_whenScoreIs_5_6_Should_haveTiebreak() {
        addScore(firstPlayerTest, 5, isTiebreak);
        addScore(secondPlayerTest, 6, isTiebreak);
        addScore(firstPlayerTest, 1, isTiebreak);

        assertEquals("6",gameScore.getPlayerScoreDisplay(firstPlayerTest));
        assertEquals("6",gameScore.getPlayerScoreDisplay(secondPlayerTest));
        assertInstanceOf(PointScoreTiebreak.class, gameScore.getCurrentPointScore());
    }

    @Test
    void pointByWon_whenScoreIs_6_6_Should_Win() {
        addScore(firstPlayerTest, 5, isTiebreak);
        addScore(secondPlayerTest, 6, isTiebreak);
        addScore(firstPlayerTest, 1, isTiebreak);

        this.isTiebreak = true;
        addScore(firstPlayerTest, 1, isTiebreak);

        assertEquals(firstPlayerTest,gameScore.getWinner());
    }

    @Test
    void pointByWon_whenScoreIs_5_4_Should_Win() {
        addScore(firstPlayerTest, 5, isTiebreak);
        addScore(firstPlayerTest, 4, isTiebreak);

        addScore(firstPlayerTest, 1, isTiebreak);

        assertEquals(firstPlayerTest,gameScore.getWinner());
    }

    private void addScore(Player player, int score, Boolean isTiebreak) {
        if (isTiebreak) {
            score = score * POINT_TO_WIN_GAME_TIEBREAK;
        } else {
            score = score * POINT_TO_WIN_GAME;
        }

        for(int i = 0; i < score; i++) {
            gameScore.pointWonBy(player);
        }
    }


}
