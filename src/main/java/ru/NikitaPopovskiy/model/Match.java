package ru.NikitaPopovskiy.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Match {
    @NonNull
    private final Player firstPlayer;
    @NonNull
    private final Player secondPlayer;
    private final SetScore currentScoreSet = new SetScore(firstPlayer, secondPlayer);
    Player winner;

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
