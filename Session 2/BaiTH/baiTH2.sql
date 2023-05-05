-- create database quanlidiemthi;-- 
-- use quanlidiemthi;
create table hocsinh (
	MaHS varchar(20) primary key,
    TenHS varchar(50),
    Ngaysinh date,
	Lop varchar(20),
    GT varchar(20)
);

create table monhoc(
	MaMH varchar(20) primary key,
    TenMH varchar(50)
);

create table bangdiem(
	MaHS varchar(20),
    MaMH varchar(20),
    Diemthi int,
    NgayKiemtra date,
    primary key(MaHS, MaMH),
    foreign key(MaHS) references hocsinh(MaHS),
    foreign key(MaMH) references monhoc(MaMH)
);

create table GiaoVien(
	MaGV varchar(20) primary key,
    TenGV varchar(50),
    SDT varchar(10)
);

alter table Monhoc add MaGV varchar(20);
alter table Monhoc add constraint FK_MaGV foreign key (MaGV) references GiaoVien(MaGV);