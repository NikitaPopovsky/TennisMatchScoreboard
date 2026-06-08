package ru.NikitaPopovskiy.enums;

public enum ExceptionMessage {
    DB_NOT_UNAVAILABLE ("Database execution error");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
