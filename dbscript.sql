create database greenpeace

use greenpeace

create table volunteer
(
id int not null primary key auto_increment,
volunteer_name varchar(50),
number_fed int
);

create table cat
(
id int not null primary key auto_increment,
cat_name varchar(50),
time_fed timestamp default current_timestamp,
feeder_name varchar(50)
);


select * from cat;
drop table cat
datediff(hour, current_timestamp, current_time);
select hour(current_time());
select extract(hour from current_timestamp);
insert into cat;

SELECT timestamp;