package ru.NikitaPopovskiy.service;

import ru.NikitaPopovskiy.dto.CurrentMatchDto;
import ru.NikitaPopovskiy.enums.ExceptionMessage;
import ru.NikitaPopovskiy.exception.MatchNotFoundException;
import ru.NikitaPopovskiy.mapper.MatchMapper;
import ru.NikitaPopovskiy.model.Match;
import ru.NikitaPopovskiy.model.Player;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class OngoingMatchesService {
    private final ConcurrentHashMap<UUID, Match> currencyMatches = new ConcurrentHashMap<>();
    private final PlayerService playerService;
    private final FinishedMatchesService finishedMatchesService;

    public OngoingMatchesService(PlayerService playerService, FinishedMatchesService finishedMatchesService) {
        this.playerService = playerService;
        this.finishedMatchesService = finishedMatchesService;
    }

    public void addMatch (UUID uuid, Match match) {
        currencyMatches.put(uuid, match);
    }

    public CurrentMatchDto addPoint (UUID matchId, String playerName) {
        Player player = playerService.getByName(playerName);
        Match match = getMatch(matchId);

        match.pointByWon(player);

        if (match.hasWinner()) {
            finishedMatchesService.save(match);
        }

        return MatchMapper.toDTO(match);
    }

    private Match getMatch (UUID id) {
        Match match = currencyMatches.get(id);
        if (match == null) {
            throw new MatchNotFoundException(ExceptionMessage.MATCH_NOT_FOUND.getMessage());
        }
        return match;
    }

}
