package ru.NikitaPopovskiy.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "matches")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Match {
    @Id
    private int id;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "player1", referencedColumnName = "id")
    private Player player1;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "player2", referencedColumnName = "id")
    private Player player2;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "winner", referencedColumnName = "id")
    private Player winner;
}
