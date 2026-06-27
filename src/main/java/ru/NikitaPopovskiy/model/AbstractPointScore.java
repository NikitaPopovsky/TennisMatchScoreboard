package ru.NikitaPopovskiy.model;

public abstract class AbstractPointScore<T> extends AbstractScore<T> {

    public AbstractPointScore(Player firstPlayer, Player secondPlayer, T initValue) {
        super(firstPlayer, secondPlayer, initValue);
    }

}
