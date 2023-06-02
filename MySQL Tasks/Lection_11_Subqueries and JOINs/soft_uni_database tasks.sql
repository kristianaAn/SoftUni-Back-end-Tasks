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
