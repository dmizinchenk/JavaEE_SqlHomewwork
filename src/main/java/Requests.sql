--task2
/*
SELECT * FROM Notepads;

SELECT country, COUNT(id) as "count"
FROM Notepads
GROUP BY country;

SELECT firm, COUNT(name)
FROM Notepads
GROUP BY firm
*/

--task3
/*
SELECT country, noteCount
FROM (SELECT country, COUNT(id) as noteCount
      FROM Notepads
      GROUP BY country)
WHERE noteCount =  (SELECT MAX(counts)
                    FROM (SELECT COUNT(country) as counts
                          FROM Notepads
                          GROUP BY country));

SELECT country, noteCount
FROM (SELECT country, COUNT(id) as noteCount
      FROM Notepads
      GROUP BY country)
WHERE noteCount =  (SELECT MIN(counts)
                    FROM (SELECT COUNT(country) as counts
                          FROM Notepads
                          GROUP BY country));

SELECT firm, noteCount
FROM (SELECT firm, COUNT(id) as noteCount
      FROM Notepads
      GROUP BY firm)
WHERE noteCount =  (SELECT MAX(counts)
                    FROM (SELECT COUNT(firm) as counts
                          FROM Notepads
                          GROUP BY firm));

SELECT firm, noteCount
FROM (SELECT firm, COUNT(id) as noteCount
      FROM Notepads
      GROUP BY firm)
WHERE noteCount =  (SELECT MIN(counts)
                    FROM (SELECT COUNT(firm) as counts
                          FROM Notepads
                          GROUP BY firm));

SELECT name
FROM Notepads
WHERE skinType = 'hard';

SELECT name
FROM Notepads
WHERE skinType = 'soft';
*/