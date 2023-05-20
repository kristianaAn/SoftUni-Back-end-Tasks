USE book_library;

SELECT SUBSTRING(`title`, 1, 10) FROM `books`;

-- 1. Find Book Titles
SELECT 
    `title` AS `title`
FROM
    `books`
WHERE
    SUBSTRING(`title` FROM 1 FOR 3) = 'The'
ORDER BY `id`;

-- 2. Replace Titles
SELECT 
    REPLACE(`title`, 'The', '***') AS `title`
FROM
    `books`
WHERE
    SUBSTRING(`title`, 1, 3) = 'The'
ORDER BY `id`;

-- 3. Sum Cost of All Books
SELECT 
    ROUND(SUM(`cost`), 2)
FROM
    `books`;

-- 4. Days Lived
SELECT 
    CONCAT_WS(' ',
            `first_name`,
            `last_name`) AS `Full Name`,
    TIMESTAMPDIFF(DAY, `born`, `died`) AS `Days Lived`
FROM
    `authors`;
    
-- 5. Harry Potter Books
SELECT 
    `title`
FROM
    `books`
WHERE `title` LIKE '%Harry Potter%';

SELECT 
    `title`
FROM
    `books`
WHERE
    `title` REGEXP 'Harry Potter';
