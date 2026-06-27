package ru.NikitaPopovskiy.model;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;


public class SetScore extends AbstractScore<Integer> {
    private static final int SCORE_TO_WIN = 2;
    @Getter
    private GameScore currentGameScore;

    public SetScore(Player firstPlayer, Player secondPlayer) {
        super(firstPlayer, secondPlayer, 0);
    }

    @Override
    public void pointWonBy(Player pointWinner) {
        currentGameScore.pointWonBy(pointWinner);

        if (currentGameScore.hasWinner()){
            Player opponent = getOpponent(pointWinner);
            int opponentScore = score.get(opponent);
            int pointWinnerScore = score.get(pointWinner) + 1;

            updatePlayerScore(pointWinner, pointWinnerScore);
            this.currentGameScore = new GameScore(firstPlayer, secondPlayer);
            if (isWin(pointWinnerScore, opponentScore)) {
                this.winner = pointWinner;
            }
        }
    }

    @Override
    protected boolean isWin(Integer pointWinnerScore, Integer opponentScore) {
        return pointWinnerScore == SCORE_TO_WIN;
    }
}
