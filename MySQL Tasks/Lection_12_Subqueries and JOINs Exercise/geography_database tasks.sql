USE `geography`;

-- 12. Highest Peaks in Bulgaria
SELECT 
    c.`country_code`,
    m.`mountain_range`,
    p.`peak_name`,
    p.`elevation`
FROM
    `countries` AS c
        JOIN
    `mountains_countries` AS mc ON mc.`country_code` = c.`country_code`
        JOIN
    `mountains` AS m ON mc.`mountain_id` = m.`id`
        JOIN
    `peaks` AS p ON m.`id` = p.`mountain_id`
WHERE
    c.`country_code` = 'BG'
        AND p.`elevation` > 2835
ORDER BY p.`elevation` DESC;

-- 13. Count Mountain Ranges
SELECT 
    mc.`country_code`,
	COUNT(m.`mountain_range`) AS 'mountain_range_count'
FROM
    `mountains_countries` AS mc
		JOIN
    `mountains` AS m ON m.`id` = mc.`mountain_id`
WHERE mc.`country_code` = 'BG' OR mc.`country_code` = 'RU' OR mc.`country_code` = 'US'
GROUP BY mc.`country_code`
ORDER BY `mountain_range_count` DESC;

-- 14. Countries with Rivers
SELECT 
    c.`country_name`, r.`river_name`
FROM
    `countries` AS c
        LEFT JOIN
    `countries_rivers` AS cr ON c.`country_code` = cr.`country_code`
        LEFT JOIN
    `rivers` AS r ON r.`id` = cr.`river_id`
WHERE
    c.`continent_code` = 'AF'
ORDER BY c.`country_name` ASC
LIMIT 5;

-- 16. Countries Without Any Mountains
SELECT 
    COUNT(*) AS 'country_count'
FROM
    `countries` AS c
        LEFT JOIN
    `mountains_countries` AS mc ON mc.`country_code` = c.`country_code`
        LEFT JOIN
    `mountains` AS m ON m.`id` = mc.`mountain_id`
WHERE
    m.`mountain_range` IS NULL;
    
-- 17. Highest Peak and Longest River by Country
SELECT 
    c.`country_name`,
    MAX(p.`elevation`) AS 'highest_peak_elevation',
    MAX(r.`length`) AS 'longest_river_length'
FROM
    `countries` AS c
        LEFT JOIN
    `mountains_countries` AS mc ON mc.`country_code` = c.`country_code`
        LEFT JOIN
    `peaks` AS p ON p.`mountain_id` = mc.`mountain_id`
        LEFT JOIN
    `countries_rivers` AS cr ON cr.`country_code` = c.`country_code`
        LEFT JOIN
    `rivers` AS r ON r.`id` = cr.`river_id`
GROUP BY c.`country_name`
ORDER BY `highest_peak_elevation` DESC , `longest_river_length` DESC , c.`country_name` ASC
LIMIT 5;