package ru.NikitaPopovskiy.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "players")
@Getter
@RequiredArgsConstructor
@NoArgsConstructor
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    @Column(name = "name")
    private String name;
}
