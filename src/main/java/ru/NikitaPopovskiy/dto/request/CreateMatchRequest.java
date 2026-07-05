package ru.NikitaPopovskiy.dto.request;

import lombok.Getter;

@Getter
public class CreateMatchRequest {
    private String firstPlayerName;
    private String secondPlayerName;
}
