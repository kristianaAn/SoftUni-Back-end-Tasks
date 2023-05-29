-- Project Management DB*
CREATE DATABASE `project management`;

CREATE TABLE `clients` (
   `id` INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
   `client_name` VARCHAR(100)
);

CREATE TABLE `projects` (
    `id` INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    `client_id` INT,
    CONSTRAINT fk_client_id FOREIGN KEY (`client_id`)
        REFERENCES `clients` (`id`),
    `project_lead_id` INT
);

CREATE TABLE `employees` (
    `id` INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    `first_name` VARCHAR(30),
    `last_name` VARCHAR(30),
    `project_id` INT,
    CONSTRAINT fk_project_id FOREIGN KEY (`project_id`)
        REFERENCES `projects` (`id`)
);

ALTER TABLE `projects`
ADD CONSTRAINT fk_project_lead_id__employees FOREIGN KEY(`project_lead_id`) REFERENCES `employees`(`id`);
