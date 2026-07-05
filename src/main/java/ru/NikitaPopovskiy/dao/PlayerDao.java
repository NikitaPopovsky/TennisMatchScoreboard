package ru.NikitaPopovskiy.dao;

import org.springframework.stereotype.Repository;
import ru.NikitaPopovskiy.entity.PlayerEntity;

import java.util.Optional;

@Repository
public interface PlayerDao {
    PlayerEntity save (PlayerEntity player);
    Optional<PlayerEntity> getByName (String name);
}
