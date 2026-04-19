package ru.NikitaPopovskiy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "players")
public class Player {
    @Id
    private int id;
    @Column(name = "name")
    private String name;
}
