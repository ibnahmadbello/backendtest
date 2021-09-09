create database greenpeace

use greenpeace

create table volunteer
(
id int not null auto_increment,
volunteer_name varchar(50),
number_fed int

);

create table cat
(
id int not null auto_increment,
cat_name varchar(50),
time_fed timestamp default current_timestamp,
feeder_name varchar(50)
);
