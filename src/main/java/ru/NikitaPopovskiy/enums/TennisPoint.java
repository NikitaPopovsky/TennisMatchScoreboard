package ru.NikitaPopovskiy.enums;

public enum TennisPoint {
    LOVE("0"),
    FIFTEEN("15"),
    THIRTY("30"),
    FORTY("40"),
    ADVANTAGE("AD");

    private final String point;

    TennisPoint(String point) {
        this.point = point;
    }

    public String getPoint() {
        return point;
    }
}
