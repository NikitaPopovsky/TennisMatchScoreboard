package ru.NikitaPopovskiy.exception;

public class PlayerNotFoundException extends TennisMatchScoreboardException{
    public PlayerNotFoundException(String message) {
        super(message, 400);
    }
}
