-- 1. Mountains and Peaks
CREATE TABLE `mountains` (
    `id` INT AUTO_INCREMENT NOT NULL,
    `name` VARCHAR(100),
    CONSTRAINT pk_mountain_id PRIMARY KEY (`id`)
);

CREATE TABLE `peaks` (
    `id` INT AUTO_INCREMENT NOT NULL,
    `name` VARCHAR(100),
    `mountain_id` INT,
    CONSTRAINT pk_peaks_id PRIMARY KEY (`id`),
    CONSTRAINT fk_mountain_id_in_peaks_id FOREIGN KEY (`mountain_id`)
        REFERENCES `mountains` (`id`)
);

-- 2. Trip Organization
SELECT 
    v.`driver_id`,
    v.`vehicle_type`,
    CONCAT(`first_name`, ' ', `last_name`) AS `driver_name`
FROM
    `vehicles` AS v
        JOIN
    `campers` ON v.`driver_id` = `campers`.`id`; 
    
-- 3. SoftUni Hiking
SELECT 
    `starting_point` AS `route_starting_point`,
    `end_point` AS `route_ending_point`,
    `leader_id`,
    CONCAT(`first_name`, ' ', `last_name`) AS `leader_name`
FROM
    `routes` AS r
        JOIN
    `campers` ON r.`leader_id` = `campers`.id;
    
-- 4. Delete Mountains
CREATE DATABASE `mountains_DB`;
USE `mountains_DB`;

CREATE TABLE `mountains` (
    `id` INT AUTO_INCREMENT NOT NULL,
    `name` VARCHAR(100),
    CONSTRAINT pk_mountain_id PRIMARY KEY (`id`)
);

CREATE TABLE `peaks` (
    `id` INT AUTO_INCREMENT NOT NULL,
    `name` VARCHAR(100),
    `mountain_id` INT,
    CONSTRAINT pk_peaks_id PRIMARY KEY (`id`),
    CONSTRAINT fk_mountain_id_in_peaks_id FOREIGN KEY (`mountain_id`)
        REFERENCES `mountains` (`id`)
        ON DELETE CASCADE
);

INSERT INTO `mountains` (`name`) VALUES ('Rila'), ('Pirin'), ('Stara Planina');

INSERT INTO `peaks` (`name`, `mountain_id`) VALUES ('Mussala', 1), ('Botev', 3), ('Vihren', 2);
INSERT INTO `peaks` (`name`, `mountain_id`) VALUES ('Vihren2', 2), ('Botev2', 2), ('Vihren3', 2);

DELETE FROM `mountains` WHERE `id` = 2;