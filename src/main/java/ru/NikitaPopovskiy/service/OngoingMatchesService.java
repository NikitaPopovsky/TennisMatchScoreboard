package ru.NikitaPopovskiy.service;

import org.springframework.stereotype.Service;
import ru.NikitaPopovskiy.dto.CurrentMatchDto;
import ru.NikitaPopovskiy.model.Match;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public interface OngoingMatchesService {
    void addMatch (UUID uuid, Match match);
    CurrentMatchDto addPoint (UUID matchId, String playerName);
    CurrentMatchDto getMatchScore (UUID uuid);

}
