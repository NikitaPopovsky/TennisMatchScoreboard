package ru.NikitaPopovskiy.service;

import ru.NikitaPopovskiy.dto.MatchDto;
import ru.NikitaPopovskiy.dao.PlayerDao;
import ru.NikitaPopovskiy.entity.PlayerEntity;
import ru.NikitaPopovskiy.mapper.MatchMapper;
import ru.NikitaPopovskiy.mapper.PlayerMapper;
import ru.NikitaPopovskiy.model.Match;
import ru.NikitaPopovskiy.model.Player;

import java.util.Optional;
import java.util.UUID;

public class NewMatchService {
    private PlayerDao playerDao;
    private OngoingMatchesService ongoingMatchesService;

    public MatchDto createNewMatch (String firstPlayerName, String secondPlayerName) {
        Player firstPlayer = getPlayer(firstPlayerName);
        Player secondPlayer = getPlayer(secondPlayerName);
        UUID uuid = UUID.randomUUID();
        Match match = new Match(firstPlayer, secondPlayer);

        ongoingMatchesService.addMatch(match, uuid);

        return MatchMapper.toDTO(match);
    }

    private Player getPlayer (String name) {
        Optional<PlayerEntity> playerEntityOptional = playerDao.getByName(name);
        PlayerEntity playerEntity = playerEntityOptional.orElse(playerDao.save(new PlayerEntity(name)));
        return PlayerMapper.toModel(playerEntity);
    }
}
