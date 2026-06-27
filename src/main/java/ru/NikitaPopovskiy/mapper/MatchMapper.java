package ru.NikitaPopovskiy.mapper;

import ru.NikitaPopovskiy.dto.MatchDto;
import ru.NikitaPopovskiy.entity.MatchEntity;
import ru.NikitaPopovskiy.enums.ExceptionMessage;
import ru.NikitaPopovskiy.exception.MatchHasNotWinnerException;
import ru.NikitaPopovskiy.model.*;

import java.util.UUID;

public class MatchMapper {
    public static MatchDto toDTO (Match match) {
        String winnerName = "";
        if (match.hasWinner()) {
            winnerName = match.getWinner().getName();
        }
        Player firstPlayer = match.getFirstPlayer();
        Player secondPlayer = match.getSecondPlayer();
        SetScore setScore = match.getCurrentScoreSet();
        GameScore gameScore = setScore.getCurrentGameScore();
        DisplayScore pointScore = (DisplayScore) gameScore.getCurrentPointScore();
        return MatchDto.builder()
                .firstPlayerName(firstPlayer.getName())
                .secondPlayerName(secondPlayer.getName())
                .firstPlayerSet(getPlayerScore(setScore,firstPlayer))
                .secondPlayerSet(getPlayerScore(setScore, secondPlayer))
                .firstPlayerGame(getPlayerScore(gameScore, firstPlayer))
                .secondPlayerGame(getPlayerScore(gameScore, secondPlayer))
                .firstPlayerPoint(getPlayerScore(pointScore, firstPlayer))
                .secondPlayerPoint(getPlayerScore(pointScore, secondPlayer))
                .winnerName(winnerName)
                .build();
    }

    public static MatchEntity toEntity (Match match) {
        if (!match.hasWinner()) {
            throw new MatchHasNotWinnerException(ExceptionMessage.MATCH_HAS_NOT_WINNER.getMessage());
        }
        return new MatchEntity(match.getId(), PlayerMapper.toEntity(match.getFirstPlayer()),
                PlayerMapper.toEntity(match.getSecondPlayer()),
                PlayerMapper.toEntity(match.getWinner()));
    }

    private static String getPlayerScore (DisplayScore score, Player player) {
        return score.getPlayerScoreDisplay(player);
    }
}
