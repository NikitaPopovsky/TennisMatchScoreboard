package ru.NikitaPopovskiy.mapper;

import ru.NikitaPopovskiy.dto.MatchesPageDto;
import ru.NikitaPopovskiy.entity.MatchEntity;

import java.util.List;

public class MatchesPageMapper {
    public static MatchesPageDto toDTO (List<MatchEntity> matches, int page, int totalPages) {
        return MatchesPageDto.builder()
                .matches(FinishedMatchMapper.toListDTO(matches))
                .currentPage(page)
                .totalPages(totalPages)
                .build();
    }
}
