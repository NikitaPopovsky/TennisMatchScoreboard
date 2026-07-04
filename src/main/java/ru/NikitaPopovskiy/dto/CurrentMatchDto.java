package ru.NikitaPopovskiy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class CurrentMatchDto {
    private String firstPlayerName;
    private String secondPlayerName;
    private String firstPlayerPoints;
    private String secondPlayerPoints;
    private String firstPlayerGames;
    private String secondPlayerGames;
    private String firstPlayerSets;
    private String secondPlayerSets;
    private String firstPlayerTieBreakPoints;
    private String secondPlayerTieBreakPoints;
    private String winnerName;
}
