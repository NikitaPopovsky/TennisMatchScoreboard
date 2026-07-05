package ru.NikitaPopovskiy.service;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface NewMatchService {
    UUID createNewMatch (String firstPlayerName,
                         String secondPlayerName);
}
