package ru.NikitaPopovskiy.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MatchesPageDto {
    private List<FinishedMatchDto> matches;
    private int currentPage;
    private int totalPages;
}
