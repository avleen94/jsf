CREATE TABLE users(
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL
);

INSERT INTO users (ID, username, password) VALUES (1, "webtech", "webtech");

CREATE TABLE filme(
    filmID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    titel VARCHAR(50),
    regisseur VARCHAR(50),
    erscheinungsjahr INT,
    genre VARCHAR(50),
    schauspieler VARCHAR(50)
);

