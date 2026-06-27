package ru.NikitaPopovskiy.service;

import ru.NikitaPopovskiy.dto.MatchDto;
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

    public void addMatch (Match match) {
        currencyMatches.put(match.getId(), match);
    }

    public MatchDto addPoint (UUID matchId, int playerId) {
        Player player = playerService.getById(playerId);
        Match match = getMatch(matchId);

        match.pointByWon(player);

        if (match.hasWinner()) {
            finishedMatchesService.save(match);
        }

        return MatchMapper.toDTO(match);
    }

    private Match getMatch (UUID id) {
        return currencyMatches.get(id);
    }

}
