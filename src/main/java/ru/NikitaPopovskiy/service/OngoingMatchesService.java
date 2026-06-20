package ru.NikitaPopovskiy.service;

import ru.NikitaPopovskiy.model.Match;
import ru.NikitaPopovskiy.model.Player;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class OngoingMatchesService {
    private final ConcurrentHashMap<UUID, Match> currencyMatches = new ConcurrentHashMap<>();

    public void addMatch (Match match, UUID uuid) {
        currencyMatches.put(uuid, match);
    }

    public Match getMatch (UUID uuid) {
        return currencyMatches.get(uuid);
    }

}
