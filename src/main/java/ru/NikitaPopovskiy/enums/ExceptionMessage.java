package ru.NikitaPopovskiy.enums;

public enum ExceptionMessage {
    DB_NOT_UNAVAILABLE ("Database execution error"),
    PLAYER_NOT_FOUND ("Player not found"),
    MATCH_HAS_NOT_WINNER ("Match has not winner"),
    MATCH_NOT_FOUND ("Match not found");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
