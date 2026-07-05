package ru.NikitaPopovskiy.controller;

import org.springframework.web.bind.annotation.*;
import ru.NikitaPopovskiy.dto.CurrentMatchDto;
import ru.NikitaPopovskiy.dto.MatchesPageDto;
import ru.NikitaPopovskiy.dto.request.CreateMatchRequest;
import ru.NikitaPopovskiy.dto.request.PlayerNameRequest;
import ru.NikitaPopovskiy.service.FinishedMatchesService;
import ru.NikitaPopovskiy.service.NewMatchService;
import ru.NikitaPopovskiy.service.OngoingMatchesService;

import java.util.UUID;

@RestController("/matches")
public class MatchesController {
    private NewMatchService newMatchService;
    private OngoingMatchesService ongoingMatchesService;
    private FinishedMatchesService finishedMatchesService;

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
