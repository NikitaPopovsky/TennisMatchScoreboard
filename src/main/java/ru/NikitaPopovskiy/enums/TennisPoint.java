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

    public TennisPoint next() {
        return values()[this.ordinal()+1];
    }

    public Boolean isMore(TennisPoint point) {
        return this.ordinal() > point.ordinal();
    }
}
