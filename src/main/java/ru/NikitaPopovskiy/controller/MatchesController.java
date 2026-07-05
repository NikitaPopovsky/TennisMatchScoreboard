package ru.NikitaPopovskiy.controller;

import org.springframework.web.bind.annotation.*;
import ru.NikitaPopovskiy.dto.CurrentMatchDto;
import ru.NikitaPopovskiy.dto.MatchesPageDto;
import ru.NikitaPopovskiy.dto.request.CreateMatchRequest;
import ru.NikitaPopovskiy.dto.request.PlayerNameRequest;
import ru.NikitaPopovskiy.service.*;

import java.util.UUID;

@RestController("/matches")
public class MatchesController {
    private final NewMatchService newMatchService;
    private final OngoingMatchesService ongoingMatchesService;
    private final FinishedMatchesService finishedMatchesService;

    public MatchesController(NewMatchService newMatchService,
                             OngoingMatchesService ongoingMatchesService,
                             FinishedMatchesService finishedMatchesService) {
        this.newMatchService = newMatchService;
        this.ongoingMatchesService = ongoingMatchesService;
        this.finishedMatchesService = finishedMatchesService;
    }

    @PostMapping("/")
    public UUID createMatch(@RequestBody CreateMatchRequest createMatchRequest) {
        return newMatchService.createNewMatch(createMatchRequest.getFirstPlayerName(), createMatchRequest.getSecondPlayerName());
    }

    @PostMapping("/{uuid}/point")
    public CurrentMatchDto addPoint (@PathVariable UUID uuid, @RequestBody PlayerNameRequest playerNameRequest) {
        return ongoingMatchesService.addPoint(uuid, playerNameRequest.getName());
    }

    @GetMapping("/{uuid}/")
    public CurrentMatchDto getMatch (@PathVariable UUID uuid) {
        return ongoingMatchesService.getMatchScore(uuid);
    }

    @GetMapping("/")
    public MatchesPageDto getMatches (@RequestParam(defaultValue = "1") int page,
                                      @RequestParam(required = false) String playerName) {
        return finishedMatchesService.get(page, playerName);
    }

}
