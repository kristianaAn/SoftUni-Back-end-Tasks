-- Part I – Queries for SoftUni Database
-- 1. Find Names of All Employees by First Name
SELECT 
    `first_name`, `last_name`
FROM
    `employees`
WHERE
    `first_name` LIKE 'Sa%'
ORDER BY `employee_id`;

/* SELECT 
    `first_name`, `last_name`
FROM
    `employees`
WHERE
    SUBSTRING(`first_name`, 1, 2) = 'Sa'
ORDER BY `employee_id`; */

-- 2. Find Names of All Employees by Last Name
SELECT 
    `first_name`, `last_name`
FROM
    `employees`
WHERE
    `last_name` LIKE '%ei%'
ORDER BY `employee_id`;

--  3. Find First Names of All Employees
SELECT 
    `first_name`
FROM
    `employees`
WHERE
    `department_id` IN (3 , 10)
        AND EXTRACT(YEAR FROM `hire_date`) BETWEEN 1995 AND 2005
ORDER BY `employee_id`;

-- 4. Find All Employees Except Engineers
SELECT 
    `first_name`, `last_name`
FROM
    `employees`
WHERE
    `job_title` NOT LIKE '%engineer%'
ORDER BY `employee_id`;

-- 5. Find Towns with Name Length
SELECT 
    `name`
FROM
    `towns`
WHERE
    CHAR_LENGTH(`name`) IN (5 , 6)
ORDER BY `name` ASC;

-- 6. Find Towns Starting With
SELECT 
    `town_id`, `name`
FROM
    `towns`
WHERE
    `name` REGEXP '^[M, K, B, E]'
ORDER BY `name` ASC;

-- 07. Find Towns Not Starting With
SELECT 
    *
FROM
    `towns`
WHERE
    `name` NOT LIKE 'R%'
        AND `name` NOT LIKE 'B%'
        AND `name` NOT LIKE 'D%'
ORDER BY `name` ASC;

-- 8. Create View Employees Hired After 2000 Year
CREATE VIEW `v_employees_hired_after_2000` AS
    SELECT 
        `first_name`, `last_name`
    FROM
        `employees`
    WHERE
        YEAR(`hire_date`) > 2000;

SELECT 
    *
FROM
    `v_employees_hired_after_2000`;

-- 9. Length of Last Name
SELECT 
    `first_name`, `last_name`
FROM
    `employees`
WHERE
    CHAR_LENGTH(`last_name`) = 5;
    