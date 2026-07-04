package ru.NikitaPopovskiy.mapper;

import ru.NikitaPopovskiy.dto.CurrentMatchDto;
import ru.NikitaPopovskiy.entity.MatchEntity;
import ru.NikitaPopovskiy.enums.ExceptionMessage;
import ru.NikitaPopovskiy.exception.MatchHasNotWinnerException;
import ru.NikitaPopovskiy.model.*;

public class MatchMapper {
    public static CurrentMatchDto toDTO (Match match) {
        String winnerName = null;
        if (match.hasWinner()) {
            winnerName = match.getWinner().getName();
        }
        Player firstPlayer = match.getFirstPlayer();
        Player secondPlayer = match.getSecondPlayer();
        SetScore setScore = match.getCurrentScoreSet();
        GameScore gameScore = setScore.getCurrentGameScore();
        DisplayScore pointScore = gameScore.getCurrentPointScore();
        Boolean isTieBreak = gameScore.isTieBreak();
        return CurrentMatchDto.builder()
                .firstPlayerName(firstPlayer.getName())
                .secondPlayerName(secondPlayer.getName())
                .firstPlayerSets(getPlayerScore(setScore,firstPlayer))
                .secondPlayerSets(getPlayerScore(setScore, secondPlayer))
                .firstPlayerGames(getPlayerScore(gameScore, firstPlayer))
                .secondPlayerGames(getPlayerScore(gameScore, secondPlayer))
                .firstPlayerPoints((isTieBreak) ? null : getPlayerScore(pointScore, firstPlayer))
                .secondPlayerPoints((isTieBreak) ? null :getPlayerScore(pointScore, secondPlayer))
                .firstPlayerTieBreakPoints((isTieBreak) ? getPlayerScore(pointScore, firstPlayer) : null)
                .secondPlayerTieBreakPoints((isTieBreak) ? getPlayerScore(pointScore, secondPlayer) : null)
                .winnerName(winnerName)
                .build();
    }

    public static MatchEntity toEntity (Match match) {
        if (!match.hasWinner()) {
            throw new MatchHasNotWinnerException(ExceptionMessage.MATCH_HAS_NOT_WINNER.getMessage());
        }
        return new MatchEntity(PlayerMapper.toEntity(match.getFirstPlayer()),
                PlayerMapper.toEntity(match.getSecondPlayer()),
                PlayerMapper.toEntity(match.getWinner()));
    }

    private static String getPlayerScore (DisplayScore score, Player player) {
        return score.getPlayerScoreDisplay(player);
    }
}
