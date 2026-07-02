package ru.NikitaPopovskiy.dto;

import lombok.Builder;
import ru.NikitaPopovskiy.entity.PlayerEntity;

@Builder
public class FinishedMatchDto {
    private String firstPlayerName;
    private String secondPlayerName;
    private String winnerName;
}
