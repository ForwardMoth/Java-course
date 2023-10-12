--Выдайте всю информацию о спортсменах из таблицы sportsman.
SELECT * FROM sportsman;

-- Выдайте наименование и мировые результаты по всем соревнованиям.
SELECT competition_name, world_record FROM competition;

-- Выберите имена всех спортсменов, которые родились в 1990 году.
SELECT sportsman_name FROM sportsman WHERE year_of_birth = 1990;

-- Выберите наименование и мировые результаты по всем соревнованиям, установленные 12-05-2010 или 15-05-2010.
SELECT competition_name, world_record FROM competition WHERE set_date = '2010-05-12' or set_date = '2010-05-15';

-- Выберите дату проведения всех соревнований, которые проводились в Москве и полученные на них результаты равны 10 секунд.
SELECT hold_date FROM result WHERE city = 'Moscow' and result = 10;

-- Выберите имена всех спортсменов, у которых персональный рекорд не равен 25 с
SELECT sportsman_name FROM sportsman WHERE personal_record <> 25;

-- Выберите названия всех соревнований, у которых мировой рекорд равен 15 с и дата установки рекорда не равна 12-02-2015
SELECT competition_name FROM competition WHERE world_record = 15 and set_date <> '2015-02-12';

-- Выберите города проведения соревнований, где результаты принадлежат множеству {13, 25, 17, 9}
SELECT city FROM result WHERE result IN (13, 25,17,9);

-- Выберите имена всех спортсменов, у которых год рождения 2000 и разряд не принадлежит множеству {3, 7, 9}.
SELECT * FROM sportsman WHERE year_of_birth = 2000 and rank NOT IN (3, 7, 9);

-- Выберите дату проведения всех соревнований, у которых город проведения начинается с буквы "М".
SELECT hold_date FROM result WHERE city LIKE 'M%';

-- Выберите имена всех спортсменов, у которых имена начинаются с буквы "М" и год рождения не заканчивается на "6".
SELECT * FROM sportsman WHERE sportsman_name LIKE 'M%' AND year_of_birth % 10 = 6;

-- Выберите наименования всех соревнований, у которых в названии есть слово "международные"
SELECT competition_name FROM competition WHERE competition_name LIKE '%международные%';

-- Выберите годы рождения всех спортсменов без повторений
SELECT DISTINCT year_of_birth FROM sportsman;

-- Найдите количество результатов, полученных 12-05-2014.
SELECT COUNT(*) FROM result WHERE hold_date = '2014-05-12';

-- Вычислите максимальный результат, полученный в Москве.
SELECT max(result) FROM result WHERE city = 'Moscow';

-- Вычислите минимальный год рождения спортсменов, которые имеют 1 разряд.
SELECT min(year_of_birth) FROM sportsman WHERE rank = 1;

-- Определите имена спортсменов, у которых личные рекорды совпадают с результатами, установленными 12-04-2014.
SELECT DISTINCT sportsman_name FROM sportsman sp 
JOIN result r ON sp.sportsman_id = r.sportsman_id
WHERE hold_date = '2014-04-12' and r.result = personal_record;

-- Выведите наименования соревнований, у которых дата установления мирового рекорда совпадает с датой проведения соревнований в - Москве 20-04-2015
SELECT DISTINCT competition_name FROM competition c 
JOIN result r ON r.competition_id = c.competition_id
WHERE city = 'Moscow' and c.set_date = r.hold_date;

-- Вычислите средний результат каждого из спортсменов
SELECT sportsman_id, ROUND(AVG(personal_record),2) as avg_result FROM sportsman GROUP BY sportsman_id;

-- Выведите годы рождения спортсменов, у которых результат, показанный в Москве выше среднего по всем спортсменам
SELECT DISTINCT year_of_birth 
FROM sportsman 
WHERE sportsman_id IN(
    SELECT sportsman_id 
    FROM result 
    WHERE city = 'Moscow' and 
    result > (SELECT ROUND(AVG(result),2) 
              FROM result 
              WHERE city = 'Moscow'));

-- Выведите имена всех спортсменов, у которых год рождения больше, чем год установления мирового рекорда, равного 12 с
SELECT sportsman_name 
FROM sportsman 
WHERE year_of_birth > (SELECT EXTRACT(year from set_date) 
                       FROM competition 
                       WHERE world_record = 12)

-- Выведите список спортсменов в виде 'Спортсмен ' ['имя спортсмена'] 'показал результат' ['результат'] 'в городе' ['город']
SELECT 'Спортсмен ' || sportsman_name || ' показал результат ' || result || ' в городе ' || city as sentence
FROM result r 
JOIN sportsman s
ON r.sportsman_id = s.sportsman_id;

-- Выведите имена всех спортсменов, у которых разряд ниже среднего разряда всех спортсменов, родившихся в 2000 году
SELECT sportsman_name 
FROM sportsman
WHERE rank < (SELECT CAST(avg(rank) as integer)
              FROM sportsman
              WHERE year_of_birth = 2000)


-- Выведите данные о спортсменах, у которых персональный рекорд совпадает с мировым
SELECT * FROM sportsman WHERE personal_record IN(SELECT world_record FROM competition)

-- Определите количество участников с фамилией Иванов, которые участвовали в соревнованиях с названием, содержащим слово 'Региональные'
SELECT COUNT(*) 
FROM sportsman
WHERE sportsman_name LIKE '%Ivanov' AND
sportsman_id IN (SELECT sportsman_id FROM competition c 
                 JOIN result r
                 ON r.competition_id = c.competition_id
                 WHERE competition_name LIKE '%Региональные%');

-- Выведите города, в которых были установлены мировые рекорды
SELECT DISTINCT city 
FROM competition c 
JOIN result r
ON r.competition_id = c.competition_id;

-- Найдите минимальный разряд спортсменов, которые установили мировой рекорд
SELECT min(rank) FROM sportsman WHERE personal_record IN(SELECT world_record FROM competition)

-- Выведите названия соревнований, на которых было установлено максимальное количество мировых рекордов
SELECT competition_name
FROM competition c 
GROUP BY competition_name
ORDER BY COUNT(*) DESC 
LIMIT 1; 

-- Определите, спортсмены какой страны участвовали в соревнованиях больше всего
SELECT country
FROM sportsman s 
JOIN result r
ON r.sportsman_id = s.sportsman_id
GROUP BY country
ORDER BY COUNT(*) DESC
LIMIT 1; 

-- Измените разряд на 1 тех спортсменов, у которых личный рекорд совпадает с мировым
UPDATE sportsman 
SET rank = 1
WHERE sportsman_id IN (SELECT sportsman_id 
                       FROM sportsman 
                       WHERE personal_record IN(SELECT world_record FROM competition))

-- Измените дату проведения всех соревнований, проходящих в Москве на 4 дня вперед
UPDATE result
set hold_date = hold_date + 4
WHERE city = 'Moscow';

-- Измените страну у спортсменов, у которых разряд равен 1 или 2, с Италии на Россию
UPDATE sportsman 
SET country = 'Russia'
WHERE rank IN (1,2) and country = 'Italy';

-- Увеличьте мировой результат на 2 с для соревнований ранее 20-03-2005
UPDATE competition 
SET world_record = world_record + 2
WHERE set_date < '2005-03-20'

-- Удалите все результаты спортсменов, которые родились в 2001 году
DELETE FROM sportsman WHERE year_of_birth = 2001




