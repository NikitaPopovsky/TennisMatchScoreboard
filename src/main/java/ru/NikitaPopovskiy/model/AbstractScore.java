package ru.NikitaPopovskiy.model;

import lombok.Getter;
import ru.NikitaPopovskiy.enums.ExceptionMessage;
import ru.NikitaPopovskiy.enums.TennisPoint;
import ru.NikitaPopovskiy.exception.PlayerNotFoundException;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractScore <T> implements DisplayScore{
    protected  Player firstPlayer;
    protected  Player secondPlayer;
    protected  final Map<Player, T> score = new HashMap<>();
    @Getter
    protected  Player winner;

    @Override
    public String getPlayerScoreDisplay(Player player) {
        return String.valueOf(score.get(player));
    }

    public AbstractScore(Player firstPlayer, Player secondPlayer, T initValue) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    protected Boolean hasWinner() {
        return winner != null;
    }

    protected Player getOpponent(Player player) {
        if (player.equals(firstPlayer)) {
            return secondPlayer;
        }
        return firstPlayer;
    }

    protected void updatePlayerScore(Player player, T point) {
        score.put(player, point);
    }

    abstract void pointWonBy(Player player);

    protected abstract boolean isWin(T pointWinnerScore,T opponentScore);
}
