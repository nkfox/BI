drop database bi;
create database bi;
use bi;

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

create table member(
  email CHAR(255) PRIMARY KEY,
  name CHAR(255) NOT NULL,
  country CHAR(255) NOT NULL,
  phone CHAR(255) NOT NULL
);

INSERT INTO member
VALUES ('vl@ukr.net', 'Владислав Побоченко', 'Украина',  '0678888888'),
  ('nt@ukr.net', 'Наталья Козорез', 'Украина',  '0671111111'),
  ('pahan@ukr.net', 'Пашка Ходак', 'Украина',  '0677777777'),
  ('dm@ukr.net', 'Дмитрий Цимбол', 'Украина',  '0672222222'),
  ('ps@ukr.net', 'Паша Шкурыхин', 'Украина',  '0679999999');

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
