package ru.NikitaPopovskiy.mapper;

import ru.NikitaPopovskiy.entity.PlayerEntity;
import ru.NikitaPopovskiy.model.Player;

public class PlayerMapper {
    public static Player toModel (PlayerEntity player) {
        return new Player(player.getId(), player.getName());
    }

    public static PlayerEntity toEntity (Player player) {
        return new PlayerEntity(player.getId(), player.getName());
    }
}
