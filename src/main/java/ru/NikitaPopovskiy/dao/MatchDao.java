package ru.NikitaPopovskiy.dao;

import ru.NikitaPopovskiy.entity.MatchEntity;

import java.util.List;

public interface MatchDao {
    void save (MatchEntity match);
    List<MatchEntity> getByPlayersName (String name, int pageSize, int offset);
    List<MatchEntity> getAll (int pageSize, int offset);
    int getCount ();
    int getCountByPlayerName(String name);
}
