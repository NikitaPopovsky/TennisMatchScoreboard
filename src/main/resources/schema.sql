CREATE TABLE IF NOT EXISTS players
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS matches
(
    id      SERIAL PRIMARY KEY,
    player1 INT REFERENCES players (id),
    player2 INT REFERENCES players (id),
    winner  INT REFERENCES players (id)
);
