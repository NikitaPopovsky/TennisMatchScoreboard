package ru.NikitaPopovskiy.dao;

import org.springframework.stereotype.Repository;
import ru.NikitaPopovskiy.entity.MatchEntity;

import java.util.List;

@Repository
public interface MatchDao {
    void save (MatchEntity match);
    List<MatchEntity> getByPlayersName (String name, int pageSize, int offset);
    List<MatchEntity> getAll (int pageSize, int offset);
    int getCount ();
    int getCountByPlayerName(String name);
}
