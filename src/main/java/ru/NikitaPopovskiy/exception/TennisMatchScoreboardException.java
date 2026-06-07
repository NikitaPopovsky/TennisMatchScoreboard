package ru.NikitaPopovskiy.exception;

public abstract class TennisMatchScoreboardException extends RuntimeException {
    private final int statusCode;

    public TennisMatchScoreboardException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
