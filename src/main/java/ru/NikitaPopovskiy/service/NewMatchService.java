package ru.NikitaPopovskiy.service;

import ru.NikitaPopovskiy.dto.MatchDto;
import ru.NikitaPopovskiy.mapper.MatchMapper;
import ru.NikitaPopovskiy.model.Match;
import ru.NikitaPopovskiy.model.Player;

import java.util.UUID;

public class NewMatchService {
    private final PlayerService playerService;
    private final OngoingMatchesService ongoingMatchesService;

    public NewMatchService(PlayerService playerService, OngoingMatchesService ongoingMatchesService) {
        this.playerService = playerService;
        this.ongoingMatchesService = ongoingMatchesService;
    }

    public MatchDto createNewMatch (String firstPlayerName, String secondPlayerName) {
        Player firstPlayer = playerService.getOrCreate(firstPlayerName);
        Player secondPlayer = playerService.getOrCreate(secondPlayerName);
        UUID id = UUID.randomUUID();
        Match match = new Match(id, firstPlayer, secondPlayer);

        ongoingMatchesService.addMatch(match);

        return MatchMapper.toDTO(match);
    }


}
