-- Import this file in phpMyAdmin to create database and sample data for bai2 app.
CREATE DATABASE IF NOT EXISTS bai2
  CHARACTER SET utf8mb4
  COLLATE utf8mb4_unicode_ci;

USE bai2;

CREATE TABLE IF NOT EXISTS books (
  id BIGINT NOT NULL AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  author VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO books (title, author) VALUES
  ('Clean Code', 'Robert C. Martin'),
  ('Effective Java', 'Joshua Bloch'),
  ('Head First Design Patterns', 'Eric Freeman');
