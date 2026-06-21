package ru.NikitaPopovskiy.model;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class GameScore implements Score {
    private static final int SCORE_TO_WIN_MIN = 6;
    private static final int SCORE_TO_WIN_MAX = 7;
    private static final int ADVANTAGE_TO_WIN = 2;

    private final Map<Player, Integer> score = new HashMap<>();
    @Getter
    private PointScore currentPointScore;

    public GameScore(Player firstPlayer, Player secondPlayer) {
        score.put(firstPlayer, 0);
        score.put(secondPlayer, 0);
        this.currentPointScore = new PointScoreRegular(firstPlayer, secondPlayer);
    }

    @Override
    public String getPlayerScore(Player player) {
        return String.valueOf(score.get(player));
    }

    @Override
    public void pointWonBy(Player player) {
        currentPointScore.pointWonBy(player);
        if (currentPointScore.hasWinner()){
            updatePlayerScore(player);
            if (isTieBreak()) {

            }
        }
    }

    private void updatePlayerScore(Player player) {

    }

    private Boolean isTieBreak ()
}
