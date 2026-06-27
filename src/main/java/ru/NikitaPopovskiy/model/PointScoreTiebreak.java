package ru.NikitaPopovskiy.model;

import ru.NikitaPopovskiy.enums.TennisPoint;

import java.util.HashMap;
import java.util.Map;

public class PointScoreTiebreak extends AbstractPointScore<Integer> {
    private static final int SCORE_TO_WIN = 7;
    private static final int ADVANTAGE_TO_WIN = 2;

    public PointScoreTiebreak(Player firstPlayer, Player secondPlayer) {
        super(firstPlayer, secondPlayer, 0);
    }

    @Override
    public void pointWonBy(Player pointWinner) {
        Player opponent = getOpponent(pointWinner);
        int pointWinnerScore = score.get(pointWinner) + 1;
        int opponentScore = score.get(opponent);

        updatePlayerScore(pointWinner, pointWinnerScore);

        if (isWin(pointWinnerScore, opponentScore)) {
            this.winner = pointWinner;
        }
    }

    @Override
    protected boolean isWin(Integer pointWinnerScore, Integer opponentScore) {
        return pointWinnerScore >= 7 && pointWinnerScore - opponentScore >= 2;
    }

}
