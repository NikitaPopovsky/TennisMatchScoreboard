package ru.NikitaPopovskiy.model;
import ru.NikitaPopovskiy.enums.TennisPoint;

public class PointScoreRegular extends AbstractPointScore<TennisPoint> {
    private static final TennisPoint FORTY = TennisPoint.FORTY;
    private static final TennisPoint AD = TennisPoint.ADVANTAGE;

    public PointScoreRegular(Player firstPlayer, Player secondPlayer) {
        super(firstPlayer, secondPlayer, TennisPoint.LOVE);
    }

    public void pointWonBy(Player pointWinner) {
        Player opponent = getOpponent(pointWinner);
        TennisPoint pointWinnerScore = score.get(pointWinner);
        TennisPoint opponentScore = score.get(opponent);

        if (isWin(pointWinnerScore, opponentScore)) {
            this.winner = pointWinner;
        }

        if (pointWinnerScore == FORTY && opponentScore == AD) {
            updatePlayerScore(pointWinner, FORTY);
        } else {
            updatePlayerScore(pointWinner, pointWinnerScore.next());
        }

    }

    @Override
    protected boolean isWin(TennisPoint pointWinnerScore, TennisPoint opponentScore) {
        return (pointWinnerScore == FORTY && pointWinnerScore.isMore(opponentScore))
                || pointWinnerScore == AD;
    }
}
