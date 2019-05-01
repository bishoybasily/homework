CREATE TABLE IF NOT EXISTS users (

    id        BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    name      VARCHAR(255)                      NOT NULL,
    email     VARCHAR(255) UNIQUE               NOT NULL,
    telephone VARCHAR(255) UNIQUE               NOT NULL

);
