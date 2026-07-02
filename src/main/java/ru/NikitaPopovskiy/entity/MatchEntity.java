package ru.NikitaPopovskiy.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "matches")
public class MatchEntity {
    @Id
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "player1", referencedColumnName = "id")
    @NonNull
    private PlayerEntity player1;
    @ManyToOne
    @JoinColumn(name = "player2", referencedColumnName = "id")
    @NonNull
    private PlayerEntity player2;
    @ManyToOne
    @JoinColumn(name = "winner", referencedColumnName = "id")
    @NonNull
    private PlayerEntity winner;
}
