CREATE DATABASE `car_rental`;

CREATE TABLE `categories`(
    id INT PRIMARY KEY AUTO_INCREMENT,
    category VARCHAR(30) NOT NULL,
    daily_rate DOUBLE,
    weekly_rate DOUBLE,
    monthly_rate DOUBLE,
    weekend_rate DOUBLE
);

CREATE TABLE `cars`(
    id INT PRIMARY KEY AUTO_INCREMENT,
    plate_number VARCHAR(20) NOT NULL,
    make VARCHAR(40) NOT NULL,
    model VARCHAR(50) NOT NULL,
    car_year YEAR,
    category_id INT NOT NULL,
    doors INT,
    picture BLOB,
    car_condition VARCHAR(30),
    available ENUM('Yes', 'No')
);

CREATE TABLE `employees` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    title VARCHAR(50) NOT NULL,
    notes TEXT
);

CREATE TABLE `customers` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    driver_licence_number INT NOT NULL,
    full_name VARCHAR(100) NOT NULL,
    address VARCHAR(100),
    city VARCHAR(50),
    zip_code INT,
    notes TEXT
);

CREATE TABLE `rental_orders` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    employee_id INT NOT NULL,
    customer_id INT NOT NULL,
    car_id INT NOT NULL,
    car_condition VARCHAR(30) NOT NULL,
    tank_level VARCHAR(30) NOT NULL,
    kilometrage_start DOUBLE,
    kilometrage_end DOUBLE,
    total_kilometrage DOUBLE,
    start_date DATE,
    end_date DATE,
    total_days INT NOT NULL,
    rate_applied DOUBLE,
    tax_rate DOUBLE,
    order_status VARCHAR(20) NOT NULL,
    notes TEXT
);

INSERT INTO `categories` (`category`) 
VALUES ('Luxury'),
 ('SUV'),
 ('Compact');
 
INSERT INTO `cars` (`plate_number`, `make`, `model`, `category_id`)
VALUES ('B9999HH', 'Jeep', 'Grand Cherokee', 2),
 ('CA9080BH', 'Audi', 'A7', 1),
 ('PB7557PP', 'BMW', '118d', 3);
 
INSERT INTO `employees` (`first_name`, `last_name`, `title`)
 VALUES ('Ivan', 'Ivanov', 'Customer Service Representative'),
  ('Peter', 'Petrov', 'Regional Manager'),
  ('Dimitar', 'Dimitrov', 'Rental Sales Agent');
  
INSERT INTO `customers` (`driver_licence_number`, `full_name`)
  VALUES (96402893 , 'Georgi Stefanov Petrov'),
   (23567813 , 'Asen Yordanov Atanasov'),
   (69522780 , 'Vladimir Ivanov Bonev');
   
INSERT INTO `rental_orders` (`employee_id`, `customer_id`, `car_id`, `car_condition`, `tank_level`, `total_days`, `order_status`)
VALUES (1, 2, 1, 'New', 'Full', 7, 'In progress'),
 (3, 1, 2, 'Like New', 'Half', 2, 'New'),
 (2, 3, 3, 'Used', 'Empty', 5, 'For review');