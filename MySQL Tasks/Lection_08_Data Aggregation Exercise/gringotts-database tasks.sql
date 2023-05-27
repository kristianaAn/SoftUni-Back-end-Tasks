USE `gringotts`;

-- 1. Records' Count
SELECT 
    COUNT(*) AS `count`
FROM
    `wizzard_deposits`;
    
-- 2. Longest Magic Wand
SELECT 
    MAX(`magic_wand_size`) AS `longest_magic_wand`
FROM
    `wizzard_deposits`;
    
-- 3. Longest Magic Wand Per Deposit Groups
SELECT 
    `deposit_group`,
    MAX(`magic_wand_size`) AS `longest_magic_wand`
FROM
    `wizzard_deposits`
GROUP BY `deposit_group`
ORDER BY `longest_magic_wand` ASC , `deposit_group` ASC;

-- 4. Smallest Deposit Group Per Magic Wand Size*
SELECT 
    `deposit_group`
FROM
    `wizzard_deposits`
GROUP BY `deposit_group`
ORDER BY AVG(`deposit_group`) ASC
LIMIT 1;

-- 5. Deposits Sum
SELECT 
    `deposit_group`, SUM(`deposit_amount`) AS `total_sum`
FROM
    `wizzard_deposits`
GROUP BY `deposit_group`
ORDER BY `total_sum` ASC;

-- 06. Deposits Sum for Ollivander Family
SELECT 
    `deposit_group`, SUM(`deposit_amount`) AS `total_sum`
FROM
    `wizzard_deposits`
WHERE
    `magic_wand_creator` = 'Ollivander family'
GROUP BY `deposit_group`
ORDER BY `deposit_group` ASC;

-- 7. Deposits Filter
SELECT 
    `deposit_group`, SUM(`deposit_amount`) AS `total_sum`
FROM
    `wizzard_deposits`
WHERE
    `magic_wand_creator` = 'Ollivander family'
GROUP BY `deposit_group`
HAVING `total_sum` < 150000
ORDER BY `total_sum` DESC;

-- 8. Deposit Charge
SELECT 
    `deposit_group`,
    `magic_wand_creator`,
    MIN(`deposit_charge`) AS 'min_deposit_charge'
FROM
    `wizzard_deposits`
GROUP BY `deposit_group` , `magic_wand_creator`
ORDER BY `magic_wand_creator` ASC , `deposit_group` ASC;

-- 9. Age Groups
SELECT 
    (CASE
        WHEN `age` >= 0 AND age <= 10 THEN '[0-10]'
        WHEN `age` >= 11 AND age <= 20 THEN '[11-20]'
        WHEN `age` >= 21 AND age <= 30 THEN '[21-30]'
        WHEN `age` >= 31 AND age <= 40 THEN '[31-40]'
        WHEN `age` >= 41 AND age <= 50 THEN '[41-50]'
        WHEN `age` >= 51 AND age <= 60 THEN '[51-60]'
        WHEN `age` >= 61 THEN '[61+]'
    END) AS 'age_group',
    COUNT(`age`) AS `wizard_count`
FROM
    `wizzard_deposits`
GROUP BY `age_group`
ORDER BY `wizard_count` ASC;

-- 10. First Letter
SELECT DISTINCT
    LEFT(`first_name`, 1) AS 'first_letter'
FROM
    `wizzard_deposits`
WHERE
    `deposit_group` = 'Troll Chest'
GROUP BY `first_name`
ORDER BY `first_letter` ASC;

-- 11. Average Interest
SELECT 
    `deposit_group`,
    `is_deposit_expired`,
    AVG(`deposit_interest`)
FROM
    `wizzard_deposits`
WHERE
    `deposit_start_date` > '1985-01-01'
GROUP BY `deposit_group` , `is_deposit_expired`
ORDER BY `deposit_group` DESC , `is_deposit_expired` ASC;