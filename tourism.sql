create database tourism;
use tourism;

create table signup(signupId varchar(20),loginId varchar(20),username varchar(30),name varchar(30),password varchar(30),phone varchar(30),securityQuestion varchar(100),answer varchar(30),user_type varchar(30));

create table login(loginId varchar(20),username varchar(30),password varchar(30),user_type varchar(30));
insert into login values(101,"admin1","admin@123","ADMIN");
insert into login values(102,"admin2","admin@753","ADMIN");


select * from login;
create table addcustomer(name varchar(20) ,username varchar(30) ,id varchar(20) ,idNumber varchar(20) ,gender varchar(10),country varchar(20),address varchar(50),email varchar(30),phone varchar(15));
select *from addcustomer;

create table travelagency(travelAgency_id varchar(20), name varchar(50), phone varchar(30), email varchar(50), address varchar(200), transportations varchar(100));
select * from travelagency;

create table hotel(hotel_id varchar(20), name varchar(30), phone varchar(30), price varchar(30), email varchar(30), address varchar(200), description varchar(500), ratings varchar(20));
select * from hotel;

create table package(package_id varchar(20), name varchar(30), destination varchar(100), price varchar(20), packageDescription varchar(500));
select * from package;

create table BookPackage(packageBooking_id varchar(20), user_id varchar(20), package_id varchar(40), travelagency_id varchar(30), transportation varchar(30), persons varchar(20), price varchar(30), payment_id varchar(30), bookedOn varchar(40));
select * from BookPackage;

create table bookHotel(hotelBooking_id varchar(20), user_id varchar(20), hotel_id varchar(40), name varchar(30), hotel varchar(40), price varchar(30), payment_id varchar(30), bookedOn varchar(40));
select * from bookHotel;

create table payments(payment_id varchar(30), booking_id varchar(30), user_id varchar(30), paymentMethod varchar(40), paymentDetails varchar(30), paymentAmount varchar(30), paidOn varchar(40));
select * from payments;

create table ratings(user_id varchar(30), userName varchar(30), hotel_id varchar(30), hotel varchar(30), rating varchar(20), review varchar(100), ratingOn varchar(50));
select * from ratings;

create table calculateRatings(hotel_id varchar(30), rating int, numberOfRatings int);
select * from calculateRatings;

drop table login;