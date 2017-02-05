drop database bi;
create database bi;
use bi;

create table university(
  email CHAR(255) PRIMARY KEY,
  name CHAR(255) NOT NULL,
  country CHAR(255) NOT NULL,
  info text,
  picture CHAR(255) NOT NULL,
  city CHAR(255) NOT NULL
);

INSERT INTO university
VALUES ('knu@gmail.com', 'Taras Shevchenko National University of Kiev', 'Ukraine', '7th in the world', 'tsnuk', 'Kiev'),
  ('ttu@gmail.com', 'Tallinn University of Technology', 'Estonia', 'one of the best', 'ttu', 'Tallin'),
  ('ntnu@gmail.com', 'Norvegian University of Science and Technology', 'Norway', 'good univ', 'ntnu', 'Oslo');

create table student(
  email CHAR(255) PRIMARY KEY,
  name CHAR(255) NOT NULL,
  country CHAR(255) NOT NULL,
  info text,
  picture CHAR(255) NOT NULL,
  birthDate DATETIME NOT NULL,
  university CHAR(255) NOT NULL,
  faculty CHAR(255) NOT NULL,
  speciality CHAR(255) NOT NULL,
  year CHAR(255) NOT NULL,

  FOREIGN KEY (university) REFERENCES university(email)
);

INSERT INTO student
VALUES ('vl@ukr.net', 'Владислав Побоченко', 'Украина', 'frontend dev', 'v.p', '1995-09-09','knu@gmail.com', 'cybernetics', 'MI', '1 master'),
  ('nt@gmail.com', 'Наталья Козорез', 'Украина', 'backend dev', 'n.k', '1994-12-16','knu@gmail.com', 'cybernetics', 'BI', '1 master'),
  ('grom@gmail.com', 'Hryhoriy Omelianenko', 'Украина', 'designer', 'h.o', '1994-06-11','knu@gmail.com', 'cybernetics', 'TK', '1 master');

create table teacher(
  email CHAR(255) PRIMARY KEY,
  name CHAR(255) NOT NULL,
  country CHAR(255) NOT NULL,
  info text,
  picture CHAR(255) NOT NULL,
  birthDate DATETIME NOT NULL,
  university CHAR(255) NOT NULL,
  post CHAR(255) NOT NULL,
  degree CHAR(255) NOT NULL
);

INSERT INTO teacher
VALUES ('vz@gmail.com', 'Volodymyr Zaslavsky', 'Ukraine', 'innivation', 'v.z', '1957-07-21','knu@gmail.com', 'Professor', 'Doctor of Engineering');



CREATE TABLE event (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  title CHAR(255) NOT NULL,
  startDate DATETIME NOT NULL,
  endDate DATETIME NOT NULL,
  place CHAR(255) NOT NULL,
  organizer CHAR(255) not null,
  participants CHAR(255) NOT NULL,
  description TEXT NOT NULL,

  CONSTRAINT eDateCheck CHECK(startDate <= endDate)
);

INSERT INTO event
VALUES (1, 'КНУ', '22.11.16', '23.11.16', 'Читалка', 'Таблеточки, Анна Газаманова', 'Все для студента', 'Все будет агонь'),
  (2, 'КНУ', '25.11.16', '27.11.16', 'Читалка', 'Артем Байраков', 'Будет все!!! ', 'Крутое описание тут'),
  (3, 'КПИ', '28.11.16', '30.11.16', '01аудитория', 'Михаил Круг', 'Ничего не надо делать!', 'Может и лучше'),
  (4, 'ДУТ', '30.11.16', '01.12.16', 'Конференц-зал', 'Андрей Царь', 'Будущее - все!', 'Все....или ничего');


create table news(
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  title CHAR(255) NOT NULL,
  author CHAR(255) NOT NULL,
  date DATETIME NOT NULL,
  description text NOT NULL
);

INSERT INTO news
VALUES ('1','Король Виталий','Изменения стипендии','23.10.16','Пришли новые правила начисления...'),
  ('3','Сайд Аткаев','Как поменять обучение','25.11.16','Мысли про это...');

create table project(
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  name CHAR(255) NOT NULL,
  category CHAR(255) NOT NULL,
  startDate DATETIME NOT NULL,
  endDate DATETIME NOT NULL,
  organizer CHAR(255) NOT NULL,
  description text NOT NULL,

  CONSTRAINT pDateCheck CHECK(startDate <= endDate)
);

INSERT INTO project
VALUES ('1','Уникальные модули переводчика', 'Лингвистика','09.09.2016','10.12.16','Наталья Козорез','Разработка новых модулей переводчика'),
  ('2','Ритмы сердца', 'Медицина','19.09.2016','15.11.16','Григорий Омельяненко','Разработка новых подходов к расчету ритма сердца'),
  ('3','Быстрая аутентификация пользователей', 'Криптография','29.10.2016','10.11.16','Владислав Побоченко','Новые кодировки'),
  ('4','Нейронные сети', 'Искусственный интелект','07.11.2016','10.12.16','Андрей Тарануха','Разработка новых модулей интелекта');
