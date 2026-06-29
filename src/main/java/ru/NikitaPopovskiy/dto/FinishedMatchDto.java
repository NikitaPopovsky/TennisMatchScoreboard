package ru.NikitaPopovskiy.dto;

import lombok.Builder;
import ru.NikitaPopovskiy.entity.PlayerEntity;

@Builder
public class FinishedMatchDto {
    private PlayerEntity player1;
    private PlayerEntity player2;
    private PlayerEntity winner;
}
