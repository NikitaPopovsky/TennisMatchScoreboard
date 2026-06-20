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
    private final SetScore setScore = new SetScore();
    private final GameScore gameScore = new GameScore();
    private final PointScore pointScore = new PointScore();
}
