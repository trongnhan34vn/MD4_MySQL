use quanlybanhang;

create table Customer
(
	cID int primary key auto_increment,
    cName varchar(25) not null,
    cAge tinyint
);

drop table `Order`;
create table `Order`
(
	oId int primary key auto_increment,
	cId int,
    foreign key (cId) references Customer(cId),
    oDate date,
    oTotalPrice int
);

insert into `Order` (cId, oDate) values
(1, "2006-03-21"),
(2, "2006-03-23"),
(1, "2006-03-16");

drop table Product;
create table Product
(
	pId int primary key auto_increment,
    pName varchar(25),
    pPrice int
);

insert into Product (pName, pPrice) values
("May Giat", 3),
("Tu Lanh", 5),
("Dieu Hoa", 7),
("Quat", 1),
("Bep Dien", 2);

drop table OrderDetail;
create table OrderDetail 
(
	oId int not null,
    foreign key (oId) references `Order`(oId),
    pId int not null,
    foreign key (pId) references Product(pId),
    odQTY int
);

insert into OrderDetail (oID, pId, odQTY) values
(1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);

select o.oId, o.oDate, o.oToTalPrice from `order` as o;
select p.pName, c.cName from `order` as o join customer as c on c.cId = o.cId join orderDetail as od on od.oId = o.oId join product as p on od.pId = p.pId group by p.pName, c.cName;
select c.cName from customer as c where c.cId not in (select o.cId from `order` as o);

select o.oId, o.oDate, od.odQTY * p.pPrice as oTotalPrice from `order` as o join orderDetail as od on o.oId = od.oId join Product as p on od.pId = p.pId;
