package ru.NikitaPopovskiy.exception;

public class MatchNotFoundException extends TennisMatchScoreboardException{
    public MatchNotFoundException(String message) {
        super(message, 400);
    }
}
