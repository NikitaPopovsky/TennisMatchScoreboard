package ru.NikitaPopovskiy.model;

import ru.NikitaPopovskiy.enums.TennisPoint;

public class PointScore implements Score{
    private TennisPoint firstPlayerScore = TennisPoint.LOVE;
    private TennisPoint secondPlayerScore = TennisPoint.LOVE;

    @Override
    public String getFirstPlayerScore() {
        return firstPlayerScore.getPoint();
    }
    @Override
    public String getSecondPlayerScore() {
        return secondPlayerScore.getPoint();
    }
}
