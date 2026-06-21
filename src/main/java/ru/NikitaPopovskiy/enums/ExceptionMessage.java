package ru.NikitaPopovskiy.enums;

public enum ExceptionMessage {
    DB_NOT_UNAVAILABLE ("Database execution error"),
    PLAYER_NOT_FOUND ("Player not found");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
