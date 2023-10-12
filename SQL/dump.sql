CREATE TABLE IF NOT EXISTS competition(
    competition_id serial PRIMARY KEY,
	competition_name varchar NOT NULL,
    world_record decimal NOT NULL,
	set_date date NOT NULL
);

CREATE TABLE IF NOT EXISTS sportsman(
    sportsman_id serial PRIMARY KEY,
	sportsman_name varchar NOT NULL,
	rank integer,
	year_of_birth integer NOT NULL,
    personal_record decimal NOT NULL,
	country varchar NOT NULL
);
    
CREATE TABLE IF NOT EXISTS result(
    competition_id integer NOT NULL,
    sportsman_id integer NOT NULL,
	result decimal,
    city varchar NOT NULL,
	hold_date date NOT NULL, 
	PRIMARY KEY (competition_id, sportsman_id, result),
	FOREIGN KEY (competition_id)
    REFERENCES competition(competition_id)
	ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY (sportsman_id)
	REFERENCES sportsman(sportsman_id)
	ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO competition (competition_name, world_record, set_date) VALUES ('Бег на 100 метров. Мужчины', 9.81, '2014-04-12');
INSERT INTO competition (competition_name, world_record, set_date) VALUES('Бег на 200 метров. Мужчины', 19.19, '2009-08-20');
INSERT INTO competition (competition_name, world_record, set_date) VALUES ('Бег на 400 метров. Мужчины', 43.03, '2016-08-14');
INSERT INTO competition (competition_name, world_record, set_date) VALUES ('Бег на 800 метров. Мужчины', 100.91, '2012-08-09');
INSERT INTO competition (competition_name, world_record, set_date) VALUES ('Бег на 1000 метров. Мужчины', 131.96, '1999-09-05');
INSERT INTO competition (competition_name, world_record, set_date) VALUES ('Бег на 1500 метров. Мужчины', 206.00, '1998-07-14');
INSERT INTO competition (competition_name, world_record, set_date) VALUES ('Бег на 1 милю. Мужчины', 223.13, '1999-07-07');
INSERT INTO competition (competition_name, world_record, set_date) VALUES ('Бег на 2000 метров. Мужчины', 284.79, '1999-09-07');
INSERT INTO competition (competition_name, world_record, set_date) VALUES ('Бег на 3000 метров. Мужчины', 440.67, '1996-09-01');
INSERT INTO competition (competition_name, world_record, set_date) VALUES('Бег на 5000 метров. Мужчины', 755.36, '2020-08-14');
INSERT INTO competition (competition_name, world_record, set_date) VALUES ('Бег на 10000 метров. Мужчины', 1577.53, '2005-08-26');
INSERT INTO competition (competition_name, world_record, set_date) VALUES ('Бег на 20000 метров. Мужчины', 3385.98, '2007-06-27');
INSERT INTO competition (competition_name, world_record, set_date) VALUES ('Бег на 25000 метров. Мужчины', 4345.4, '2011-06-03');
INSERT INTO competition (competition_name, world_record, set_date) VALUES ('Бег на 30000 метров. Мужчины', 5207.4, '2011-06-13');
INSERT INTO competition (competition_name, world_record, set_date) VALUES ('Бег. Марафон. Мужчины', 7299, '2018-09-16');
INSERT INTO competition (competition_name, world_record, set_date) VALUES ('Бег 3000 метров с препятствиями. Мужчины', 473.63, '2004-09-03');
INSERT INTO competition (competition_name, world_record, set_date) VALUES ('Бег на 110 метров c барьерами. Мужчины', 12, '1990-09-07');
INSERT INTO competition (competition_name, world_record, set_date) VALUES ('Бег на 400 метров с барьерами. Мужчины', 46.78, '1992-08-06');
INSERT INTO competition (competition_name, world_record, set_date) VALUES ('Ходьба на 20000 метров. Мужчины', 4645.6, '1994-05-07');
INSERT INTO competition (competition_name, world_record, set_date) VALUES ('Ходьба на 30000 метров. Мужчины', 7304.1, '1992-10-03');
INSERT INTO competition (competition_name, world_record, set_date) VALUES ('Ходьба на 50000 метров. Мужчины', 12927.2, '2011-03-12');


INSERT INTO sportsman (sportsman_name, rank, year_of_birth, personal_record, country) VALUES
('John Smith', 1, 1985, 9.82, 'USA'),
('Maria Rodriguez', 2, 1990, 10.15, 'Spain'),
('Michael Johnson', 1, 1980, 9.63, 'USA'),
('Elena Petrova', 3, 1995, 10.35, 'Russia'),
('David Lee', 2, 1988, 9.99, 'Canada'),
('Anna Müller', 4, 1992, 10.45, 'Germany'),
('Daniel Kim', 3, 1987, 10.08, 'South Korea'),
('Sophie Martin', 5, 1998, 10.60, 'France'),
('Robert Chen', 4, 1986, 10.17, 'China'),
('Laura Brown', 6, 2000, 10.75, 'Canada'),
('Miguel González', 5, 1989, 10.22, 'Spain'),
('Yuki Tanaka', 7, 2002, 10.82, 'Japan'),
('Hannah Wilson', 6, 1991, 10.30, 'Australia'),
('Anton Petrov', 8, 2003, 11.05, 'Russia'),
('Amanda Smith', 7, 1993, 10.50, 'USA'),
('Sebastian Fischer', 9, 2005, 11.20, 'Germany'),
('Javier Ramirez', 8, 1994, 10.70, 'Mexico'),
('Chen Wei', 10, 2006, 11.35, 'China'),
('Emily Taylor', 9, 1996, 10.90, 'UK'),
('Takeshi Sato', 10, 2007, 11.50, 'Japan');

INSERT INTO result (competition_id, sportsman_id, result, city, hold_date) VALUES
(1, 1, 9.82, 'Los Angeles', '2014-04-12'),
(2, 3, 10.12, 'New York', '2023-06-20'),
(3, 5, 9.95, 'Moscow', '2016-08-14'),
(4, 7, 10.32, 'Paris', '2023-08-05'),
(5, 9, 9.76, 'Berlin', '2023-09-18'),
(1, 2, 10.05, 'Los Angeles', '2023-05-15'),
(2, 4, 10.24, 'New York', '2023-06-20'),
(3, 6, 9.88, 'Moscow', '2016-08-14'),
(4, 8, 10.40, 'Paris', '2023-08-05'),
(5, 10, 9.69, 'Berlin', '2023-09-18'),
(1, 11, 10.17, 'Los Angeles', '2023-05-15'),
(2, 13, 10.45, 'New York', '2023-06-20'),
(3, 15, 10.05, 'Moscow', '2016-08-14'),
(4, 17, 10.62, 'Paris', '2023-08-05'),
(5, 19, 9.88, 'Berlin', '2023-09-18');

