DROP DATABASE Notepad;

CREATE DATABASE Notepad;

DROP TABLE IF EXISTS Notepads;

CREATE TABLE Notepads(
                         id INT GENERATED ALWAYS AS IDENTITY UNIQUE,
                         firm varchar(30),
                         name varchar(30),
                         pages int check ( pages > 0 ),
                         skinType varchar(30),
                         country varchar(30),
                         pageView varchar (30)
);

INSERT INTO Notepads (firm, name, pages, skinType, country, pageView)  VALUES
                   ('NotePro', 'phonebook', 50, 'hard', 'USA', 'line'),
                   ('NotePro', 'phonebook-Lite', 25, 'soft', 'USA', 'blank'),
                   ('NotePro', 'studyBook', 75, 'soft', 'China', 'cell'),
                   ('NotePro', 'daily', 20, 'soft', 'China', 'line'),
                   ('Miami', 'phones', 70, 'soft', 'Japan', 'blank'),
                   ('Miami', 'trainer', 20, 'soft', 'Japan', 'line'),
                   ('Miami', 'business', 40, 'hard', 'Japan', 'line'),
                   ('Miami', 'trader', 50, 'soft', 'China', 'cell'),
                   ('Miami', 'geometry', 50, 'hard', 'China', 'cell'),
                   ('ART', 'blankBook', 100, 'soft', 'Switzerland', 'blank'),
                   ('ART', 'childBook', 25, 'hard', 'Switzerland', 'cell'),
                   ('ART', 'remarks', 35, 'soft', 'Switzerland', 'line'),
                   ('ART', 'productList', 30, 'soft', 'Switzerland', 'line'),
                   ('ART', 'recipe', 100, 'hard', 'Switzerland', 'line');
