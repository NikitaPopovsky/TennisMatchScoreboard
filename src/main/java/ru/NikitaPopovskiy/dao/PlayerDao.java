package ru.NikitaPopovskiy.dao;

import ru.NikitaPopovskiy.entity.Player;

import java.sql.SQLException;
import java.util.Optional;

public interface PlayerDao {
    Player save (Player player);
    Optional<Player> getByName (String name);
}
