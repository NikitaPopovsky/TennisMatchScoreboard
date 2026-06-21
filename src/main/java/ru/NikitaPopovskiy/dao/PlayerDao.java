package ru.NikitaPopovskiy.dao;

import ru.NikitaPopovskiy.entity.PlayerEntity;

import java.util.Optional;


public interface PlayerDao {
    PlayerEntity save (PlayerEntity player);
    Optional<PlayerEntity> getByName (String name);
    Optional<PlayerEntity> getById (int id);
}
