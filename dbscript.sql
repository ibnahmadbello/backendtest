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
time_fed timestamp default current_timestamp

);



(
ID INT NOT NULL AUTO_INCREMENT,
FIRST_NAME VARCHAR(20),
LAST_NAME VARCHAR(20),
EMAIL VARCHAR(20),
PASSWORD VARCHAR(256), 
PRIMARY KEY (ID),
UNIQUE KEY (EMAIL)
)