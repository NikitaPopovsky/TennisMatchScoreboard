package ru.NikitaPopovskiy.dto;

import lombok.Builder;

@Builder
public class FinishedMatchDto {
    private String firstPlayerName;
    private String secondPlayerName;
    private String winnerName;
}
