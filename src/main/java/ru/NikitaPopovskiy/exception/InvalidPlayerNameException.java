package ru.NikitaPopovskiy.exception;

public class InvalidPlayerNameException extends TennisMatchScoreboardException{
    public InvalidPlayerNameException(String message) {
        super(message, 400);
    }
}
