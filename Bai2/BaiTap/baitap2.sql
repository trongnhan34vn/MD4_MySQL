create database quanlybanhang;
use quanlybanhang;
create table customer
(
	cID int primary key,
    cName varchar(250) not null,
    cAge int
);

create table `order`
(
	oID int primary key,
    cID int,
    foreign key (cID) references customer(cID),
    oDate date,
    oTotalPrice float
);

create table product
(
	pID int primary key,
    pName varchar(250),
    pPrice float
);

create table orderDetail
(
	oID int,
    foreign key (oID) references `order`(oID),
    pID int,
	foreign key (pID) references product(pID),
    odQuantity int
);

