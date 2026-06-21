package ru.NikitaPopovskiy.model;

public interface Score {
    String getPlayerScore(Player player);
    void pointWonBy(Player player);
    void updatePlayerScore(Player player, int point);
    Boolean hasWinner ();
}
