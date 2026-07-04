package ru.NikitaPopovskiy.service;

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

    public UUID createNewMatch (String firstPlayerName, String secondPlayerName) {
        Player firstPlayer = playerService.getOrCreate(firstPlayerName);
        Player secondPlayer = playerService.getOrCreate(secondPlayerName);
        Match match = new Match(firstPlayer, secondPlayer);
        UUID uuid = UUID.randomUUID();
        ongoingMatchesService.addMatch(uuid, match);

        return uuid;
    }


}
