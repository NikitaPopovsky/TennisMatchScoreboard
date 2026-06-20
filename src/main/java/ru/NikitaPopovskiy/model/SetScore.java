package ru.NikitaPopovskiy.model;

public class SetScore implements Score {
    private int firstPlayerScore = 0;
    private int secondPlayerScore = 0;

    @Override
    public String getFirstPlayerScore() {
        return String.valueOf(firstPlayerScore);
    }
    @Override
    public String getSecondPlayerScore() {
        return String.valueOf(secondPlayerScore);
    }
}
