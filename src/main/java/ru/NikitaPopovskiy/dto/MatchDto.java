package ru.NikitaPopovskiy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class MatchDto {
    private String firstPlayerName;
    private String secondPlayerName;
    private String firstPlayerSet;
    private String secondPlayerSet;
    private String firstPlayerGame;
    private String secondPlayerGame;
    private String firstPlayerPoint;
    private String secondPlayerPoint;
}
