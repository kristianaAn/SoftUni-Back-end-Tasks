USE `soft_uni`;
-- 1. Employees with Salary Above 35000
CREATE PROCEDURE usp_get_employees_salary_above_35000()
SELECT `first_name`, `last_name` FROM `employees`
WHERE `salary` > 35000
ORDER BY `first_name` ASC, `last_name` ASC, `employee_id` ASC;

CALL usp_get_employees_salary_above_35000();

-- 2. Employees with Salary Above Number
CREATE PROCEDURE usp_get_employees_salary_above(salary_parameter DECIMAL(19,4))
SELECT `first_name`, `last_name` FROM `employees`
WHERE `salary` >= `salary_parameter`
ORDER BY `first_name` ASC, `last_name` ASC, `employee_id` ASC;

CALL usp_get_employees_salary_above(45000);

-- 3. Town Names Starting With
CREATE PROCEDURE usp_get_towns_starting_with(word_template VARCHAR(50))
SELECT `name` AS `town_name` FROM `towns` 
WHERE `name` LIKE CONCAT(`word_template`, '%')
ORDER BY `town_name`;

CALL usp_get_towns_starting_with('b');