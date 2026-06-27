package ru.NikitaPopovskiy.service;

import ru.NikitaPopovskiy.dao.MatchDao;
import ru.NikitaPopovskiy.mapper.MatchMapper;
import ru.NikitaPopovskiy.model.Match;

public class FinishedMatchesService {
    private MatchDao matchDao;

    public void save (Match match) {
        matchDao.save(MatchMapper.toEntity(match));
    }
}
