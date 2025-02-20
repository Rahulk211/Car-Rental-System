create database CarRentalSystem;
use CarRentalSystem;

create table Cars (
cars_id int auto_increment primary key,
cars_model varchar(20),
cars_brand varchar(20),
cars_status boolean default true,
cars_rental_price double);


create table Customer (
customer_id int auto_increment primary key,
customer_name varchar(20),
phone varchar (10),
liscence_number varchar(10)
);


create table Rented(
id int auto_increment primary key,
customer_id int,
cars_id int, 
rental_date date,
return_date date,
total_price double ,
foreign key (customer_id) references Customer(customer_id),
foreign key (cars_id) references Cars(cars_id)
);

create table Cars_Avaliability(
cars_id int primary key,
avaliable boolean,
foreign key (cars_id) references Cars(cars_id)
);

show databases;
use carrentalsystem;
show tables;




