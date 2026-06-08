package ru.NikitaPopovskiy.dao;

import ru.NikitaPopovskiy.entity.Match;
import ru.NikitaPopovskiy.entity.Player;

import java.util.List;

public interface MatchDao {
    Match save (Match match);
    List<Match> getByPlayersName (String name, int pageSize, int offset);
    List<Match> getAll (int pageSize, int offset);
}
