package ru.NikitaPopovskiy.service;

import org.springframework.stereotype.Service;
import ru.NikitaPopovskiy.dto.MatchesPageDto;
import ru.NikitaPopovskiy.model.Match;

@Service
public interface FinishedMatchesService {
    void save (Match match);
    MatchesPageDto get(int page, String playerName);
}
