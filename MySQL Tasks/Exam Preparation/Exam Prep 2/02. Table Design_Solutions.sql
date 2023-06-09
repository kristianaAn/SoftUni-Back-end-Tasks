CREATE DATABASE `online_store`;
USE `online_store`;

-- 1. Table Design
CREATE TABLE `brands`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE `categories`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(40) NOT NULL UNIQUE
);

CREATE TABLE `reviews`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`content` TEXT,
`rating` DECIMAL(10, 2) NOT NULL,
`picture_url` VARCHAR(80) NOT NULL,
`published_at` DATETIME NOT NULL
);

CREATE TABLE `products` (
`id` INT AUTO_INCREMENT PRIMARY KEY,
`name` VARCHAR(40) NOT NULL,
`price` DECIMAL(19, 2) NOT NULL,
`quantity_in_stock` INT,
`description` TEXT,
`brand_id` INT NOT NULL,
`category_id` INT NOT NULL,
`review_id` INT,
CONSTRAINT fk_products_brand_id FOREIGN KEY(`brand_id`) REFERENCES `brands`(`id`),
CONSTRAINT fk_products_category_id FOREIGN KEY(`category_id`) REFERENCES `categories`(`id`),
CONSTRAINT fk_products_review_id FOREIGN KEY(`review_id`) REFERENCES `reviews`(`id`)
);

CREATE TABLE `customers`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`first_name` VARCHAR(20) NOT NULL,
`last_name` VARCHAR(20) NOT NULL,
`phone` VARCHAR(30) NOT NULL UNIQUE,
`address` VARCHAR(60) NOT NULL,
`discount_card` BIT(1) DEFAULT false
);

CREATE TABLE `orders`(
`id` INT AUTO_INCREMENT PRIMARY KEY,
`order_datetime` DATETIME NOT NULL,
`customer_id` INT NOT NULL,
CONSTRAINT fk_orders_customer_id FOREIGN KEY(`customer_id`) REFERENCES `customers`(`id`)
);

CREATE TABLE `orders_products`(
`order_id` INT,
`product_id` INT,
CONSTRAINT fk_orders_products_order_id FOREIGN KEY(`order_id`) REFERENCES `orders`(`id`),
CONSTRAINT fk_orders_products_product_id FOREIGN KEY(`product_id`) REFERENCES `products`(`id`)
);

-- 02. Insert
INSERT INTO `reviews`(`content`, `picture_url`, `published_at`, `rating`)
(SELECT LEFT(`description`, 15), REVERSE(`name`), '2010-10-10', `price` / 8 FROM `products`
WHERE `id` >= 5
);

-- 03. Update
UPDATE `products` 
SET 
    `quantity_in_stock` = `quantity_in_stock` - 5
WHERE
    `quantity_in_stock` BETWEEN 60 AND 70;
    
-- 04. Delete
DELETE `customers` FROM `customers` AS c
LEFT JOIN `orders` AS o ON o.`customer_id` = c.`id`
WHERE o.`id` IS NULL;

-- 05.Categories 
SELECT `id`, `name` FROM `categories`
ORDER BY `name` DESC;

-- 06.Quantity
SELECT 
    `id`, `brand_id`, `name`, `quantity_in_stock`
FROM
    `products`
WHERE
    `price` > 1000
        AND `quantity_in_stock` < 30
ORDER BY `quantity_in_stock` ASC , `id` ASC;

-- 07. Review
SELECT 
    *
FROM
    `reviews`
WHERE
    `content` LIKE 'My%'
        AND CHAR_LENGTH(`content`) > 61
ORDER BY `rating` DESC;

-- 08. First customers
SELECT 
    CONCAT(c.`first_name`, ' ', c.`last_name`) AS `full_name`,
    c.`address`,
    o.`order_datetime` AS `order_date`
FROM
    `customers` AS c
        JOIN
    `orders` AS o ON o.`customer_id` = c.`id`
WHERE
    YEAR(o.`order_datetime`) <= 2018
ORDER BY `full_name` DESC;

-- 09. Best categories
SELECT 
    COUNT(p.`id`) AS `items_count`,
    c.`name`,
    SUM(p.`quantity_in_stock`) AS `total_quantity`
FROM
    `categories` AS c
        JOIN
    `products` AS p ON p.`category_id` = c.`id`
GROUP BY c.`id`
ORDER BY `items_count` DESC, `total_quantity` ASC
LIMIT 5;

-- 10. Extract client cards count
DELIMITER $$
CREATE FUNCTION udf_customer_products_count (`searched_name` VARCHAR(30))
RETURNS INT
DETERMINISTIC
BEGIN
RETURN(
    SELECT 
    COUNT(op.`product_id`)
FROM
    `customers` AS c
    JOIN `orders` AS o ON o.`customer_id` = c.`id`
    JOIN `orders_products` AS op ON op.`order_id` = o.`id`
    WHERE c.`first_name` = `searched_name`
);
END $$

DELIMITER ;
;
SELECT udf_customer_products_count('Shirley');

SELECT c.first_name,c.last_name, udf_customer_products_count('Shirley') as `total_products` 
FROM customers c
WHERE c.first_name = 'Shirley';

-- 11. Reduce price
SELECT * FROM `products` AS p
JOIN `categories` AS c ON c.`id` = p.`category_id`
JOIN `reviews` AS r ON r.`id` = p.`review_id` 
WHERE `category_id` = 1 AND r.`rating` < 4;

DELIMITER $$
CREATE PROCEDURE udp_reduce_price (`category_name` VARCHAR(50))
BEGIN
UPDATE `products` AS p
JOIN `categories` AS c ON c.`id` = p.`category_id`
JOIN `reviews` AS r ON r.`id` = p.`review_id`
SET `price` = `price` * 0.70
WHERE c.`name` = `category_name`
                AND r.`rating` < 4;
END $$

DELIMITER ;
;
CALL udp_reduce_price ('Phones and tablets');