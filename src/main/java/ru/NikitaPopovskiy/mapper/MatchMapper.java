package ru.NikitaPopovskiy.mapper;

import ru.NikitaPopovskiy.dto.MatchDto;
import ru.NikitaPopovskiy.model.*;

public class MatchMapper {
    public static MatchDto toDTO (Match match) {
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
                .build();
    }

    private static String getPlayerScore (DisplayScore score, Player player) {
        return score.getPlayerScoreDisplay(player);
    }
}
