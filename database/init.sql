CREATE DATABASE IF NOT EXISTS itemDb;

USE itemDb;

CREATE TABLE IF NOT EXISTS  item (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255)
);
