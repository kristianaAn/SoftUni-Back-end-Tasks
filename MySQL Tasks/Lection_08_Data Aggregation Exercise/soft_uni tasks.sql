USE `soft_uni`;

-- 12. Employees Minimum Salaries
SELECT 
    `department_id`, MIN(`salary`) AS 'minimum_salary'
FROM
    `employees`
WHERE
    `department_id` IN (2 , 5, 7)
        AND DATE(`hire_date`) > '2000-01-01'
GROUP BY `department_id`
ORDER BY `department_id` ASC;

-- 13. Employees Average Salaries
CREATE TABLE `highly_paid_employees` (SELECT * FROM
    `employees`
WHERE
    `salary` > 30000);

DELETE FROM `highly_paid_employees` 
WHERE
    `manager_id` = 42;

UPDATE `highly_paid_employees` 
SET 
    `salary` = `salary` + 5000
WHERE
    `department_id` = 1;

SELECT 
    `department_id`, AVG(`salary`) AS 'avg_salary'
FROM
    `highly_paid_employees`
GROUP BY `department_id`
ORDER BY `department_id` ASC;

-- 14. Employees Maximum Salaries
SELECT 
    `department_id`, MAX(`salary`) AS `max_salary`
FROM
    `employees`
GROUP BY `department_id`
HAVING `max_salary` NOT BETWEEN 30000 AND 70000
ORDER BY `department_id` ASC;

-- 15. Employees Count Salaries
SELECT 
    COUNT(*)
FROM
    `employees`
WHERE
    `manager_id` IS NULL;
    
-- 16. 3rd Highest Salary
SELECT 
    `department_id`, 
    (SELECT DISTINCT `salary` FROM `employees` AS e
    WHERE e.`department_id` = `employees`.department_id
    ORDER BY `salary` DESC
    LIMIT 2 , 1
    ) AS `third_highest_salary`
FROM
    `employees`
GROUP BY `department_id`
HAVING `third_highest_salary` != 0
ORDER BY `department_id`;

-- 17. Salary Challenge**
CREATE TABLE `avg_salaries` (SELECT `department_id`, ROUND(AVG(`salary`), 2) AS `AVG_Salary` FROM
    `employees`
GROUP BY `department_id`
ORDER BY `department_id`);

SELECT 
    `first_name`, `last_name`, `department_id`
FROM
    `employees` AS e
WHERE
    `salary` > (SELECT 
            `AVG_Salary`
        FROM
            `avg_salaries` AS a
        WHERE
            e.`department_id` = a.`department_id`)
ORDER BY `department_id` , `employee_id`
LIMIT 10;

-- 18. Departments Total Salaries
SELECT 
    `department_id`, SUM(`salary`) AS `total_salary`
FROM
    `employees`
GROUP BY `department_id`
ORDER BY `department_id`;
