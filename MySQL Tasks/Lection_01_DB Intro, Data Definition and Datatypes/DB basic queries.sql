CREATE DATABASE gamebar ;

USE `gamebar`;
CREATE TABLE employees (
`id` INT AUTO_INCREMENT PRIMARY KEY,
`first_name` VARCHAR(50) NOT NULL,
`last_name` VARCHAR(50) NOT NULL
);

CREATE TABLE categories(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(50) NOT NULL
);

CREATE TABLE products(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(50) NOT NULL,
`category_id` INT NOT NULL
);

INSERT INTO employees (`first_name`, `last_name`) VALUES ('Peter', 'Petrov');
INSERT INTO employees (`first_name`, `last_name`) VALUES ('Ivan', 'Ivanov');
INSERT INTO employees (`first_name`, `last_name`) VALUES ('Dimitar', 'Dimitrov');

ALTER TABLE employees
ADD COLUMN `middle_name` VARCHAR(50);

ALTER TABLE products
ADD CONSTRAINT FOREIGN KEY (`category_id`)
REFERENCES categories (`id`);

ALTER TABLE employees
MODIFY COLUMN `middle_name` VARCHAR(100);