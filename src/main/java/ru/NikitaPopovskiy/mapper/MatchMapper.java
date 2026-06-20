package ru.NikitaPopovskiy.mapper;

import ru.NikitaPopovskiy.dto.MatchDto;
import ru.NikitaPopovskiy.model.Match;

public class MatchMapper {
    public static MatchDto toDTO (Match match) {
        return MatchDto.builder()
                .firstPlayerName(match.getFirstPlayer().getName())
                .secondPlayerName(match.getSecondPlayer().getName())
                .firstPlayerSet(match.getSetScore().getFirstPlayerScore())
                .secondPlayerSet(match.getSetScore().getSecondPlayerScore())
                .firstPlayerGame(match.getGameScore().getFirstPlayerScore())
                .secondPlayerGame(match.getGameScore().getSecondPlayerScore())
                .firstPlayerPoint(match.getPointScore().getFirstPlayerScore())
                .secondPlayerPoint(match.getPointScore().getSecondPlayerScore())
                .build();
    }
}
