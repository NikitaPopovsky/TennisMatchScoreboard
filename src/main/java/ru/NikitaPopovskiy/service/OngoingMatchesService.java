package ru.NikitaPopovskiy.service;

import ru.NikitaPopovskiy.dao.PlayerDao;
import ru.NikitaPopovskiy.dto.MatchDto;
import ru.NikitaPopovskiy.entity.PlayerEntity;
import ru.NikitaPopovskiy.enums.ExceptionMessage;
import ru.NikitaPopovskiy.exception.PlayerNotFoundException;
import ru.NikitaPopovskiy.mapper.PlayerMapper;
import ru.NikitaPopovskiy.model.Match;
import ru.NikitaPopovskiy.model.Player;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class OngoingMatchesService {
    private final ConcurrentHashMap<UUID, Match> currencyMatches = new ConcurrentHashMap<>();
    private final PlayerDao playerDao;

    public OngoingMatchesService(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }

    public void addMatch (Match match, UUID uuid) {
        currencyMatches.put(uuid, match);
    }

    public Match getMatch (UUID uuid) {
        return currencyMatches.get(uuid);
    }

    public MatchDto addPoint (UUID matchUuid, int playerId) {
        PlayerEntity playerEntity = playerDao.getById(playerId)
                .orElseThrow(()-> new PlayerNotFoundException(ExceptionMessage.PLAYER_NOT_FOUND.getMessage()));
        Player player = PlayerMapper.toModel(playerEntity);
        Match match = getMatch(matchUuid);
        match.pointByWon(player);
        if (match.hasWinner()) {

        }
    }

}
