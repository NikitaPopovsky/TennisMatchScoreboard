import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.NikitaPopovskiy.enums.TennisPoint;
import ru.NikitaPopovskiy.model.Player;
import ru.NikitaPopovskiy.model.PointScoreRegular;

import static org.junit.jupiter.api.Assertions.*;

public class PointScoreRegularTest {
    private final Player firstPlayerTest = new Player(1, "FirstPlayerTest");
    private final Player secondPlayerTest = new Player(2, "SecondPlayerTest");
    private PointScoreRegular pointScoreRegular;

    @BeforeEach
    void init () {
        this.pointScoreRegular = new PointScoreRegular(firstPlayerTest, secondPlayerTest);
    }

    @Test
    void pointByWon_whenScoreIs_0_0_Should_15_0() {
        pointScoreRegular.pointWonBy(firstPlayerTest);

        assertEquals("15", pointScoreRegular.getPlayerScoreDisplay(firstPlayerTest));
        assertEquals("0", pointScoreRegular.getPlayerScoreDisplay(secondPlayerTest));
    }

    @Test
    void pointByWon_whenScoreIs_40_0_Should_Win() {
        putScore(firstPlayerTest, TennisPoint.FORTY);

        pointScoreRegular.pointWonBy(firstPlayerTest);

        assertEquals(firstPlayerTest,pointScoreRegular.getWinner());
    }

    @Test
    void pointByWon_whenScoreIs_40_40_Should_AD_40() {
        putScore(firstPlayerTest, TennisPoint.FORTY);
        putScore(secondPlayerTest, TennisPoint.FORTY);

        pointScoreRegular.pointWonBy(firstPlayerTest);

        assertEquals("AD",pointScoreRegular.getPlayerScoreDisplay(firstPlayerTest));
        assertEquals("40",pointScoreRegular.getPlayerScoreDisplay(secondPlayerTest));
        assertNull(pointScoreRegular.getWinner());
    }

    @Test
    void pointByWon_whenScoreIs_AD_40_Should_Win() {
        putScore(firstPlayerTest, TennisPoint.ADVANTAGE);
        putScore(secondPlayerTest, TennisPoint.FORTY);

        pointScoreRegular.pointWonBy(firstPlayerTest);

        assertEquals(firstPlayerTest,pointScoreRegular.getWinner());
    }

    @Test
    void pointByWon_whenScoreIs_40_AD_Should_40_40() {
        putScore(firstPlayerTest, TennisPoint.FORTY);
        putScore(secondPlayerTest, TennisPoint.ADVANTAGE);

        pointScoreRegular.pointWonBy(firstPlayerTest);

        assertEquals("40",pointScoreRegular.getPlayerScoreDisplay(firstPlayerTest));
        assertEquals("40",pointScoreRegular.getPlayerScoreDisplay(secondPlayerTest));
        assertNull(pointScoreRegular.getWinner());
    }

    private void putScore (Player player, TennisPoint score) {
        for(TennisPoint i = TennisPoint.LOVE; score.isMore(i); i = i.next()) {
            pointScoreRegular.pointWonBy(player);
        }
    }
}
