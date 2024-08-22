DROP DATABASE IF EXISTS SportsDB;
CREATE DATABASE SportsDB;
USE SportsDB;

CREATE TABLE teams (
    teamID INT AUTO_INCREMENT,
    teamname VARCHAR(50) UNIQUE,
    location VARCHAR(50),
    PRIMARY KEY (teamID)
);

CREATE TABLE players (
    playerID INT AUTO_INCREMENT,
    playername VARCHAR(50) UNIQUE,
    jeresynumber INT,
    teamname VARCHAR,
    PRIMARY KEY (playerID),
    FOREIGN KEY (teamID) REFERENCES teams(teamID)
);