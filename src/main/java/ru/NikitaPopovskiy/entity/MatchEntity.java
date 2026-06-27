package ru.NikitaPopovskiy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "matches")
public class MatchEntity {
    @Id
    private UUID id;
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
