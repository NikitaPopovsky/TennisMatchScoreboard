package ru.NikitaPopovskiy.service;

import org.springframework.stereotype.Service;
import ru.NikitaPopovskiy.dao.PlayerDao;
import ru.NikitaPopovskiy.entity.PlayerEntity;
import ru.NikitaPopovskiy.enums.ExceptionMessage;
import ru.NikitaPopovskiy.exception.InvalidPlayerNameException;
import ru.NikitaPopovskiy.exception.PlayerNotFoundException;
import ru.NikitaPopovskiy.mapper.PlayerMapper;
import ru.NikitaPopovskiy.model.Player;

import java.util.Optional;

@Service
public class PlayerService {
    private final PlayerDao playerDao;

    public PlayerService(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }

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

    public void validatePlayersName(String firstName, String secondName) {
        if (firstName.isEmpty() || secondName.isEmpty() ||
        firstName.length() > 50 || secondName.length() > 50
                || firstName.equals(secondName))
            throw new InvalidPlayerNameException("Invalid player name");

    }
}
