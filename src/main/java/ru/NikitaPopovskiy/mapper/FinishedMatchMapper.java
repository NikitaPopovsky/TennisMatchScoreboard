package ru.NikitaPopovskiy.mapper;

import ru.NikitaPopovskiy.dto.FinishedMatchDto;
import ru.NikitaPopovskiy.entity.MatchEntity;

import java.util.List;

public class FinishedMatchMapper {
    public static FinishedMatchDto toDto (MatchEntity match) {
        return FinishedMatchDto.builder()
                .firstPlayerName(match.getPlayer1().getName())
                .secondPlayerName(match.getPlayer2().getName())
                .winnerName(match.getWinner().getName())
                .build();
    }

    public static List<FinishedMatchDto> toListDTO (List<MatchEntity> matches) {
        return matches.stream().map(FinishedMatchMapper::toDto).toList();
    }
}
