package ru.NikitaPopovskiy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
public class Match {
    private final Player firstPlayer;
    private final Player secondPlayer;
    private final SetScore currentScoreSet;
    Player winner;

    public Match(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.currentScoreSet = new SetScore(firstPlayer, secondPlayer);
    }

    public void pointByWon(Player player) {
        currentScoreSet.pointWonBy(player);

        if (currentScoreSet.hasWinner()){
            this.winner = player;
        }
    }

    public Boolean hasWinner() {
        return winner != null;
    }
}
