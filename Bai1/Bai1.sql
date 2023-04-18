create database studentmanagement;
create table class 
( id int primary key,
name varchar(250)
);
create table teacher
(
	id int primary key,
    name varchar(250),
    age int,
    counrty text
)