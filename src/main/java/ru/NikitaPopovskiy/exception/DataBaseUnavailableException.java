package ru.NikitaPopovskiy.exception;

public class DataBaseUnavailableException extends TennisMatchScoreboardException {
    public DataBaseUnavailableException(String message) {
        super(message, 500);
    }
}
