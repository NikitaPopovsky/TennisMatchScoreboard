package ru.NikitaPopovskiy.model;

public class GameScore implements Score{
    private int firstPlayerScore;
    private int secondPlayerScore;

    @Override
    public String getFirstPlayerScore() {
        return String.valueOf(firstPlayerScore);
    }
    @Override
    public String getSecondPlayerScore() {
        return String.valueOf(secondPlayerScore);
    }
}
