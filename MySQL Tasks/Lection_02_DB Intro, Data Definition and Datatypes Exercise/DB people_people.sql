CREATE DATABASE `people`;

USE `people`;
CREATE TABLE `people`(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(200) NOT NULL,
picture BLOB,
height DOUBLE(3, 2),
weight DOUBLE(5, 2),
gender CHAR(1) NOT NULL,
birthdate DATE NOT NULL,
biography TEXT
);

INSERT INTO `people` (`id`, `name`, `height`, `weight`, `gender`, `birthdate`, `biography`)
VALUES (1, 'Peter', 1.65, 85.25, 'm', DATE(NOW()), 'Some text'),
 (2, 'George', 1.74, 86.25, 'm', DATE(NOW()), 'Some text'),
 (3, 'Ivan', 1.85, 95.25, 'm', DATE(NOW()), 'Some text'),
 (4, 'Mariya', 1.55, 45.25, 'f', DATE(NOW()), 'Some text'),
 (5, 'John', 1.83, 75.85, 'm', DATE(NOW()), 'Some text');