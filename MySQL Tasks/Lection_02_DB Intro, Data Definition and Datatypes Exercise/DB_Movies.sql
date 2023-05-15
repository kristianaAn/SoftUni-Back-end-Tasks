CREATE DATABASE `Movies`;

CREATE TABLE `directors`(
id INT PRIMARY KEY AUTO_INCREMENT,
director_name VARCHAR(70) NOT NULL,
notes TEXT
);

CREATE TABLE `genres`(
id INT PRIMARY KEY AUTO_INCREMENT,
genre_name VARCHAR(30) NOT NULL,
notes TEXT
);

CREATE TABLE `categories`(
id INT PRIMARY KEY AUTO_INCREMENT,
category_name VARCHAR(70) NOT NULL,
notes TEXT
);

CREATE TABLE `movies`(
id INT PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(255) NOT NULL,
director_id INT NOT NULL,
copyright_year YEAR,
length TIME,
genre_id INT NOT NULL,
category_id INT NOT NULL,
rating DOUBLE(4,2),
notes TEXT
);

INSERT INTO `directors`(`director_name`) 
VALUES ('David Cronenberg'),
 ('Woody Allen'),
 ('Tim Burton'),
 ('Francis Ford Coppola'),
 ('Steven Spielberg');
 
INSERT INTO `genres` (`genre_name`)
 VALUES ('Comedy'),
  ('Fantasy'),
  ('Action'),
  ('Animation'),
  ('Thriller');
  
INSERT INTO `categories` (`category_name`)
  VALUES ('Biography'),
   ('Documentary'),
   ('Narrative'),
   ('Experimental'),
   ('Western');
   
INSERT INTO `movies` (`title`, `director_id`, `genre_id`, `category_id`)
   VALUES ('Fast & furious', 2, 3, 3),
    ('Titanic', 3, 2, 2),
    ('The Matrix', 1, 5, 1),
    ('Murder Mystery', 4, 1, 4),
    ('Cars', 5, 4, 5);