USE `soft_uni`;
-- 1. Managers
SELECT 
    e.`employee_id`,
    CONCAT_WS(' ', e.`first_name`, e.`last_name`) AS `full_name`,
    d.`department_id`,
    d.`name` AS `department_name`
FROM
    `departments` AS d
        JOIN
    `employees` AS e ON e.`employee_id` = d.`manager_id`
ORDER BY `employee_id`
LIMIT 5;

-- 2. Towns Addresses
SELECT 
    t.`town_id`, t.`name` AS `town_name`, a.`address_text`
FROM
    `towns` AS t
        JOIN
    `addresses` AS a ON a.`town_id` = t.`town_id`
WHERE
    t.`name` IN ('San Francisco' , 'Sofia', 'Carnation')
ORDER BY t.`town_id` ASC , a.`address_id` ASC;

-- 3. Employees Without Managers
SELECT 
    `employee_id`,
    `first_name`,
    `last_name`,
    `department_id`,
    `salary`
FROM
    `employees`
WHERE
    `manager_id` IS NULL;
    
-- 4. High Salary
SELECT 
    COUNT(*) AS `count`
FROM
    `employees`
WHERE
    `salary` > (SELECT 
            AVG(`salary`)
        FROM
            `employees`);
            
-- Self-referencing table
SELECT 
    e.`employee_id`,
    CONCAT(e.`first_name`, ' ', e.`last_name`) AS `full_name`,
    CONCAT(m.`first_name`, ' ', m.`last_name`) AS `manager_full_name`
FROM
    `employees` AS e
        JOIN
    `employees` AS m ON m.`manager_id` = e.`employee_id`;