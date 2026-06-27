package ru.NikitaPopovskiy.model;

import lombok.Getter;

public class GameScore extends AbstractScore<Integer> {
    private static final int SCORE_TO_WIN= 6;
    private static final int ADVANTAGE_TO_WIN = 2;

    @Getter
    private AbstractPointScore currentPointScore;

    public GameScore(Player firstPlayer, Player secondPlayer) {
        super(firstPlayer, secondPlayer, 0);
        this.currentPointScore = new PointScoreRegular(firstPlayer, secondPlayer);
    }

    @Override
    public void pointWonBy(Player pointWinner) {
        currentPointScore.pointWonBy(pointWinner);

        if (currentPointScore.hasWinner()){
            Player opponent = getOpponent(pointWinner);
            int opponentScore = score.get(opponent);
            int pointWinnerScore = score.get(pointWinner) + 1;

            updatePlayerScore(pointWinner, pointWinnerScore);
            createNewPointScore(isTieBreak(pointWinnerScore, opponentScore));
            if (isWin(pointWinnerScore, opponentScore)) {
                this.winner = pointWinner;
            }
        }
    }

    @Override
    protected boolean isWin(Integer pointWinnerScore, Integer opponentScore) {
        return (pointWinnerScore >= SCORE_TO_WIN
                && pointWinnerScore - opponentScore >= ADVANTAGE_TO_WIN)
                || (pointWinnerScore > SCORE_TO_WIN && opponentScore == SCORE_TO_WIN);
    }

    private void createNewPointScore(Boolean tieBreak) {
        if (tieBreak) {
            this.currentPointScore = new PointScoreTiebreak(firstPlayer, secondPlayer);
        } else {
            this.currentPointScore = new PointScoreTiebreak(firstPlayer, secondPlayer);
        }
    }

    private Boolean isTieBreak (int playerScore, int opponentScore) {
        return playerScore == opponentScore && playerScore == SCORE_TO_WIN;
    }
}
