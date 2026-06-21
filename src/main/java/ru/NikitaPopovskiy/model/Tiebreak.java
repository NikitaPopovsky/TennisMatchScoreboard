package ru.NikitaPopovskiy.model;

import ru.NikitaPopovskiy.enums.TennisPoint;

import java.util.HashMap;
import java.util.Map;

public class Tiebreak implements PointScore{
    private final Map<Player, Integer> score = new HashMap<>();
    private Player winner;
    public Tiebreak(Player firstPlayer, Player secondPlayer) {
        score.put(firstPlayer, 0);
        score.put(secondPlayer, 0);
    }

    public String getPlayerScore (Player player) {
        return String.valueOf(score.get(player));
    }

    @Override
    public void pointWonBy(Player player) {

    }

    public Boolean hasWinner() {
        return winner != null;
    }
}
