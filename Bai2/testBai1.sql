create database test;
create table phieuxuat
(
	soPX int primary key auto_increment,
    ngayXuat date,
    maVatTu int not null unique,
    foreign key(maVatTu) references vattu(mavattu)
);

create table phieunhap
(
	soPN int primary key auto_increment,
    ngayNhap date not null,
    maVatTu int not null unique,
    foreign key(maVatTu) references vattu(mavattu)
);

create table vattu
(
	maVatTu int primary key auto_increment,
    tenVatTu varchar(255)
);

create table donDH
(
	soDH int primary key auto_increment,
    ngayDH date not null,
        maVatTu int not null unique,
    foreign key(maVatTu) references vattu(mavattu)
);

create table nhacc
(
	MaNCC int primary key auto_increment,
    tenNCC varchar(255),
    diachi text,
    soDT varchar(10)
)