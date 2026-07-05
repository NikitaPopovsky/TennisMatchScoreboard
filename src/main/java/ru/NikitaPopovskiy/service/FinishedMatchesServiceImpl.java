package ru.NikitaPopovskiy.service;

import ru.NikitaPopovskiy.dao.MatchDao;
import ru.NikitaPopovskiy.dto.MatchesPageDto;
import ru.NikitaPopovskiy.entity.MatchEntity;
import ru.NikitaPopovskiy.mapper.MatchMapper;
import ru.NikitaPopovskiy.mapper.MatchesPageMapper;
import ru.NikitaPopovskiy.model.Match;
import java.util.List;

public class FinishedMatchesServiceImpl implements FinishedMatchesService{
    private final MatchDao matchDao;

    public FinishedMatchesServiceImpl(MatchDao matchDao) {
        this.matchDao = matchDao;
    }

    public void save (Match match) {
        matchDao.save(MatchMapper.toEntity(match));
    }

    public MatchesPageDto get(int page, String playerName) {
        List<MatchEntity> matchesEntity;
        int totalPages;
        int PAGE_SIZE = 20;

        int offset = (PAGE_SIZE * page - PAGE_SIZE) + 1;

        if (playerName==null) {
            matchesEntity = matchDao.getAll(PAGE_SIZE, offset);
            totalPages = matchDao.getCount();
        } else {
            matchesEntity = matchDao.getByPlayersName(playerName, PAGE_SIZE, offset);
            totalPages = matchDao.getCountByPlayerName(playerName);
        }
        return MatchesPageMapper.toDTO(matchesEntity, page, totalPages);
    }
}
