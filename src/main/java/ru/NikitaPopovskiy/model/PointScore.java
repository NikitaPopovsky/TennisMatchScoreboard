package ru.NikitaPopovskiy.model;

import ru.NikitaPopovskiy.enums.TennisPoint;

public interface PointScore extends Score{
    void updatePlayerScore(Player player, TennisPoint point);

}
