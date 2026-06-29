package ru.NikitaPopovskiy.service;

import ru.NikitaPopovskiy.dao.MatchDao;
import ru.NikitaPopovskiy.dto.MatchesPageDto;
import ru.NikitaPopovskiy.enums.SearchParameter;
import ru.NikitaPopovskiy.mapper.MatchMapper;
import ru.NikitaPopovskiy.mapper.MatchesMapper;
import ru.NikitaPopovskiy.model.Match;

import java.util.Map;

public class FinishedMatchesService {
    private final int PAGE_SIZE = 20;
    private final MatchDao matchDao;

    public FinishedMatchesService(MatchDao matchDao) {
        this.matchDao = matchDao;
    }

    public void save (Match match) {
        matchDao.save(MatchMapper.toEntity(match));
    }

    public MatchesPageDto get(Map<SearchParameter, String> parameters) {
        int page = Integer.parseInt(parameters.getOrDefault(SearchParameter.PAGE, "1"));
        String playerName = parameters.getOrDefault(SearchParameter.PLAYER_NAME, "");
        int offset = (PAGE_SIZE * page - PAGE_SIZE) + 1;

        if (playerName.isEmpty()) {
            return MatchesMapper.toDTO(matchDao.getAll(PAGE_SIZE, offset));
        } else {
            return MatchesMapper.toDTO(matchDao.getByPlayersName(playerName, PAGE_SIZE, offset));
        }
    }
}
