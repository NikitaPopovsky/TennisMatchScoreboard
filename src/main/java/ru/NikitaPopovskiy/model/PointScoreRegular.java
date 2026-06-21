package ru.NikitaPopovskiy.model;

import lombok.Getter;
import ru.NikitaPopovskiy.enums.ExceptionMessage;
import ru.NikitaPopovskiy.enums.TennisPoint;
import ru.NikitaPopovskiy.exception.PlayerNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class PointScoreRegular implements PointScore {
    private static final TennisPoint PRE_WINNER_POINT = TennisPoint.FORTY;

    private final Map<Player,TennisPoint> score = new HashMap<>();
    @Getter
    private Player winner;

    public PointScoreRegular(Player firstPlayer, Player secondPlayer) {
        score.put(firstPlayer, TennisPoint.LOVE);
        score.put(secondPlayer, TennisPoint.LOVE);
    }

    public String getPlayerScore (Player player) {
        return String.valueOf(score.get(player));
    }

    @Override
    public void pointWonBy(Player pointWinner) {
        Player opponent = getOpponent(pointWinner);
        TennisPoint pointWinnerScore = score.get(pointWinner);
        TennisPoint opponentScore = score.get(opponent);

        if (pointWinnerScore == PRE_WINNER_POINT) {
            if (pointWinnerScore.isMore(opponentScore)){
                this.winner = pointWinner;
            } else if (opponentScore == PRE_WINNER_POINT) {
                updatePlayerScore(pointWinner, pointWinnerScore.next());
            } else {
                updatePlayerScore(opponent, PRE_WINNER_POINT);
            }
        } else {
            updatePlayerScore(pointWinner, pointWinnerScore.next());
        }

    }

    public Boolean hasWinner() {
        return winner != null;
    }

    private void updatePlayerScore(Player player, TennisPoint point) {
        score.put(player, point);
    }

    private Player getOpponent(Player pointWinner) {
        return score.keySet().stream()
                .filter(player->!player.equals(pointWinner))
                .findFirst()
                .orElseThrow(()->new PlayerNotFoundException(ExceptionMessage.PLAYER_NOT_FOUND.getMessage()));
    }
}
