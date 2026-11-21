DROP TABLE IF EXISTS car;

CREATE TABLE car (
    id          BIGINT PRIMARY KEY,
    brand       VARCHAR(50),
    model       VARCHAR(50),
    owner_name  VARCHAR(100)
);