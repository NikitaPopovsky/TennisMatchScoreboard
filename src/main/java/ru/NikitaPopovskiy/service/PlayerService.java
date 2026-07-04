package ru.NikitaPopovskiy.service;

import ru.NikitaPopovskiy.dao.PlayerDao;
import ru.NikitaPopovskiy.entity.PlayerEntity;
import ru.NikitaPopovskiy.enums.ExceptionMessage;
import ru.NikitaPopovskiy.exception.PlayerNotFoundException;
import ru.NikitaPopovskiy.mapper.PlayerMapper;
import ru.NikitaPopovskiy.model.Player;

import java.util.Optional;

public class PlayerService {
    private PlayerDao playerDao;

    public Player getOrCreate (String playerName) {
        Optional<PlayerEntity> playerEntityOptional = playerDao.getByName(playerName);
        PlayerEntity playerEntity = playerEntityOptional.orElse(playerDao.save(new PlayerEntity(playerName)));
        return PlayerMapper.toModel(playerEntity);
    }

    public Player getByName (String playerName) {
        PlayerEntity playerEntity = playerDao.getByName(playerName)
                .orElseThrow(()-> new PlayerNotFoundException(ExceptionMessage.PLAYER_NOT_FOUND.getMessage()));
        return PlayerMapper.toModel(playerEntity);
    }
}
