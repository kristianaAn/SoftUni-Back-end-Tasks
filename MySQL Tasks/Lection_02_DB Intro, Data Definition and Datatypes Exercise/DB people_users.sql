CREATE TABLE `users` (
id INT PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(30) NOT NULL UNIQUE,  -- Required
password VARCHAR(26) NOT NULL,  -- Required
profile_picture BLOB,
last_login_time TIME,
is_deleted BOOLEAN
);

INSERT INTO `users` (`username`, `password`) 
VALUES ('Jeremy96', '123456'),
       ('JessicaSmith87', '987654321'),
       ('CalvinJohnson', 'Il0v3P0rschA'),
       ('Samuel1986', 'mYp@ssW0rd'),
       ('Beverly456', '0123');
       
ALTER TABLE `users`
DROP PRIMARY KEY,
ADD PRIMARY KEY pk_users (`id`, `username`);

ALTER TABLE `users`
MODIFY COLUMN `last_login_time` DATETIME DEFAULT NOW();

ALTER TABLE `users`
DROP PRIMARY KEY,
ADD PRIMARY KEY (`id`),
MODIFY COLUMN `username` VARCHAR(30) UNIQUE;


