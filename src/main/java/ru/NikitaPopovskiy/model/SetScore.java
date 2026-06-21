package ru.NikitaPopovskiy.model;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;


public class SetScore implements Score {
    private final Map<Player, Integer> score = new HashMap<>();
    @Getter
    private GameScore currentGameScore;

    public SetScore(Player firstPlayer, Player secondPlayer) {
        score.put(firstPlayer, 0);
        score.put(secondPlayer, 0);
        this.currentGameScore = new GameScore(firstPlayer, secondPlayer);
    }

    @Override
    public String getPlayerScore(Player player) {
        return String.valueOf(score.get(player));
    }

    @Override
    public void pointWonBy(Player player) {
        currentGameScore.pointWonBy(player);
    }
}
