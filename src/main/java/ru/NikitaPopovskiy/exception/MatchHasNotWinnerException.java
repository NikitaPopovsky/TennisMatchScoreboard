package ru.NikitaPopovskiy.exception;

public class MatchHasNotWinnerException extends TennisMatchScoreboardException {
    public MatchHasNotWinnerException(String message) {
        super(message, 500);
    }
}
