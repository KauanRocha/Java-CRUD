create database crud;

create table produtos(
    id int not null auto_increment primary key,
    name varchar(40),
    categoy varchar(40)
)