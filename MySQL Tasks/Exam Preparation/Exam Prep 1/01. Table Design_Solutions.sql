CREATE DATABASE `restaurant_db`;
USE `restaurant_db`;

-- 1. Table Design
CREATE TABLE `products` (
`id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(30) NOT NULL UNIQUE,
`type` VARCHAR(30) NOT NULL,
`price` DECIMAL(10,2)
);

CREATE TABLE `clients` (
`id` INT AUTO_INCREMENT PRIMARY KEY,
`first_name` VARCHAR(50) NOT NULL,
`last_name` VARCHAR(50) NOT NULL,
`birthdate` DATE NOT NULL,
`card` VARCHAR(50),
`review` TEXT
);

CREATE TABLE `tables`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`floor` INT NOT NULL,
`reserved` TINYINT(1),
`capacity` INT NOT NULL
);

CREATE TABLE `waiters`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`first_name` VARCHAR(50) NOT NULL,
`last_name` VARCHAR(50) NOT NULL,
`email` VARCHAR(50) NOT NULL,
`phone` VARCHAR(50),
`salary` DECIMAL(10, 2)
);

CREATE TABLE `orders`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`table_id` INT NOT NULL,
`waiter_id` INT NOT NULL,
`order_time` TIME NOT NULL,
`payed_status` TINYINT(1),
CONSTRAINT fk_orders_to_tables FOREIGN KEY(`table_id`) REFERENCES `tables`(`id`),
CONSTRAINT fk_orders_to_waiters FOREIGN KEY(`waiter_id`) REFERENCES `waiters`(`id`)
);

CREATE TABLE `orders_clients`(
`order_id` INT,
`client_id` INT,
CONSTRAINT fk_order_id_orders FOREIGN KEY(`order_id`) REFERENCES `orders`(`id`),
CONSTRAINT fk_client_id_clients FOREIGN KEY(`client_id`) REFERENCES `clients`(`id`)
);

CREATE TABLE `orders_products`(
`order_id` INT, 
`product_id` INT,
CONSTRAINT fk_orders_to_orders_products FOREIGN KEY(`order_id`) REFERENCES `orders`(`id`),
CONSTRAINT fk_products_to_orders_products FOREIGN KEY(`product_id`) REFERENCES `products`(`id`)
);

-- 2.Insert
INSERT INTO `products`(`name`, `type`, `price`) 
(SELECT 
CONCAT(`waiters`.`last_name`, ' ', 'specialty'), 
'Cocktail', 
CEILING(`waiters`.`salary` * 0.01) 
FROM `waiters`
WHERE `waiters`.`id` > 6);

-- 3.Update
UPDATE `orders`
SET `table_id` = `table_id` - 1
WHERE `id` BETWEEN 12 AND 23;

-- 4.Delete
DELETE FROM `waiters` AS w
WHERE (SELECT COUNT(o.`id`) FROM `orders` AS o
                WHERE w.`id` = o.`waiter_id`) = 0;
                
-- 5.Clients
SELECT 
    *
FROM
    `clients`
ORDER BY `birthdate` DESC , `id` DESC;

-- 6.Birthdate
SELECT 
    `first_name`, `last_name`, `birthdate`, `review`
FROM
    `clients`
WHERE
    `card` IS NULL
        AND YEAR(`birthdate`) BETWEEN 1978 AND 1993
ORDER BY `last_name` DESC , `id` ASC
LIMIT 5;

-- 7.Accounts
SELECT 
    CONCAT(`last_name`,
            `first_name`,
            CHAR_LENGTH(`first_name`),
            'Restaurant') AS `username`,
    REVERSE(SUBSTRING(`email`, 2, 12)) AS `password`
FROM
    `waiters`
WHERE
    `salary` IS NOT NULL
ORDER BY `password` DESC;

-- 8. Top from menu
SELECT 
    p.`id`, p.`name`, COUNT(o.`id`) AS `count`
FROM
    `products` AS p
        JOIN
    `orders_products` AS op ON op.`product_id` = p.`id`
        JOIN
    `orders` AS o ON o.`id` = op.`order_id`
GROUP BY p.`id`
HAVING `count` >= 5
ORDER BY `count` DESC , p.`name` ASC;

-- 9. Availability
SELECT 
    t.`id`, 
    `capacity`,
    COUNT(oc.`client_id`) AS `count_clients`,
    (CASE
      WHEN t.`capacity` > COUNT(oc.`client_id`) THEN 'Free seats'
      WHEN t.`capacity` = COUNT(oc.`client_id`) THEN 'Full'
      WHEN t.`capacity` < COUNT(oc.`client_id`) THEN 'Extra seats' 
      END)
      AS `availability`
FROM `tables` AS t
        JOIN `orders` AS o ON o.`table_id` = t.`id`
        JOIN `orders_clients` AS oc ON oc.`order_id` = o.`id`
WHERE `floor` = 1
GROUP BY t.`id`
ORDER BY t.`id` DESC;

-- 10.Extract bill
DELIMITER $$
CREATE FUNCTION udf_client_bill(`full_name` VARCHAR(50))
RETURNS DECIMAL(19, 2)
DETERMINISTIC
BEGIN
 RETURN(SELECT 
    SUM(p.`price`) AS 'bill'
FROM
    `clients` AS c
        JOIN `orders_clients` AS oc ON oc.`client_id` = c.`id`
        JOIN `orders_products` AS op ON op.`order_id` = oc.`order_id`
        JOIN `products` AS p ON p.`id` = op.`product_id`
WHERE
    CONCAT(c.`first_name`, ' ',c.`last_name`) = `full_name`
    GROUP BY CONCAT(c.`first_name`, ' ', c.`last_name`));
END $$

DELIMITER ;
;

SELECT c.first_name,c.last_name, udf_client_bill('Rogers Haswall') as 'bill' FROM clients c
WHERE c.first_name = 'Rogers' AND c.last_name= 'Haswall';

-- 11. Happy hour
DELIMITER $$
CREATE PROCEDURE udp_happy_hour(`pr_type` VARCHAR(50))
BEGIN
  UPDATE `products` AS p
  SET p.`price` = p.`price` * 0.80
  WHERE p.`type` = `pr_type` AND p.`price` >= 10;
END $$

DELIMITER ;
;
CALL udp_happy_hour('Vodka');