create database SalesManagement;
use SalesManagement;
create table Category
(
	idCat int primary key auto_increment,
    `nameCat` varchar(250) not null,
    createdDate date,
    `status` tinyint
);

create table Product
(
	idPro int primary key auto_increment,
    namePro varchar(250) not null,
    price float not null,
    imgLink longtext,
    quantity int not null,
    title text,
    createdDate date,
    `status` tinyint default(1),
	catId int,
    foreign key (catId) references Category(idCat)
);

create table `Address` 
(
	addId int primary key auto_increment,
    addName varchar(250),
    phoneNumber varchar(10),
    nameReciever varchar(250) not null
);

create table `User`
(
	userId int primary key auto_increment,
    userName varchar(250) not null unique,
    `password` varchar(250) not null,
    `role` varchar(250),
    `status` tinyint default(1),
    addId int,
    foreign key (addId) references `Address`(addId)
);

create table `Order`
(
	orderId int primary key auto_increment,
    createdDate date not null,
    total float not null,
    userId int,
	foreign key (userID) references `User`(userId),
    status tinyint default(1),
    type tinyint default(1)
);

create table OrderDetail
(
	id int primary key auto_increment,
	orderId int,
    productId int,
    productName varchar(250) not null,
    productPrice float not null,
	quantity int not null,
    foreign key (orderId) references `Order`(orderId),
    foreign key (productId) references Product(idPro)
);

insert into Category (`nameCat`, createdDate, `status`) values
("Acoustic Guitar", current_date(), 1),
("Strings Guitar", "2023-08-28", 1),
("Pickup & EQ", "2023-08-28", 0),
("Audio Equipments & Record", "2023-03-28", 1),
("Drum & Percussion", "2023-08-09", 1);

insert into Product (namePro, price, imgLink, quantity, title, createdDate, `status`, catId) values
("Guitar Plus F5 Premium", 7000000, "link", 500, "perfect guitar", "2020-08-28", 0, 1),
("Guitar Plus F0 Premium", 8000000, null, 200, "perfect guitar", "2020-08-28", 1, 1),
("Guitar Plus F3 Standard", 4000000, "link", 500, "perfect guitar", "2020-08-28", 1, 1),
("Elixir Strings Guitar", 400000, "link", 500, null, "2020-08-28", 1, 2),
("D'Addario Strings Guitar", 120000, null, 500, null, "2020-08-28", 1, 2),
("Fishman EQ", 8000000, "link", 500, null, "2020-08-28", 1, 3),
("Met B-12 EQ", 500000, "link", 1000, null, "2020-08-28", 1, 3),
("DrumStick Vic Firth American", 300000, "link", 500, null, "2020-08-28", 1, 5),
("Soundcard Forcusrite", 2000000, "link", 500, null, "2020-08-28", 1, 3),
("Soundcard Komplete Audio 6", 4000000, "link", 700, null, "2020-08-28", 1, 3);

insert into Address (addName, phoneNumber, nameReciever) values 
("Tây Hồ, Hà Nội", "0912586743", "Thầy Hùng"),
("Hai Bà Trưng, Hà Nội", "0912586743", "Thầy Hùng"),
("Cầu Giấy, Hà Nội", "0912586743", "Thầy Hùng"),
("Nam Từ Liêm, Hà Nội", "0912586743", "Thầy Hùng");

insert into `User` (userName, `password`, `role`, status, addId) values
("nambeo", "pikachu123", 3, 1, 4),
("khoapug", "pikachu123", 3, 1, 4),
("nhantic", "pikachu123", 0, 1, 1),
("minhbeo", "pikachu123", 2, 0, 3);

insert into `order`(createdDate, total, userId, status, type) values
("2020-08-28", 50000, 3, 0, 0),
("2020-08-28", 1000000, 1, 1, 0),
("2020-08-28", 150000, 2, 0, 0),
("2020-08-28", 2000, 4, 0, 0);

insert into OrderDetail (orderId, productId, productName, productPrice, quantity) values
(1, 1, "Guitar Plus F5 Premium", 7000000, 4),
(1, 2, "Guitar Plus F0 Premium", 8000000, 2),
(1, 3, "Guitar Plus F3 Standard", 4000000, 1),
(2, 4, "Elixir Strings Guitar", 400000, 4),
(2, 3, "Guitar Plus F3 Standard", 4000000, 2),
(3, 10, "Soundcard Komplete Audio 6", 4000000, 1),
(3, 8, "DrumStick Vic Firth American", 300000, 1),
(3, 7, "Met B-12 EQ", 500000, 2),
(3, 3, "Guitar Plus F3 Standard", 4000000, 1);

select idPro, namePro, price from Product;