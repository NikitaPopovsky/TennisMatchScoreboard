package ru.NikitaPopovskiy.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "matches")
public class MatchEntity {
    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name = "player1", referencedColumnName = "id")
    private PlayerEntity player1;
    @ManyToOne
    @JoinColumn(name = "player2", referencedColumnName = "id")
    private PlayerEntity player2;
    @ManyToOne
    @JoinColumn(name = "winner", referencedColumnName = "id")
    private PlayerEntity winner;
}
