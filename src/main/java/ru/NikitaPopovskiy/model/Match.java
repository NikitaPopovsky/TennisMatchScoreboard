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
    private SetScore currentScoreSet;

    public void pointByWon(Player player) {
        currentScoreSet.pointWonBy(player);
    }
}
