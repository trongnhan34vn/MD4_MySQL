create database quanlybanhang_thayHungHx;
use quanlybanhang_thayHungHx;
create table KhachHang
(
	maKH varchar(4) primary key,
    tenKH varchar(30) not null,
    diaChi varchar(50),
    ngaySinh datetime,
    soDT varchar(15)
);

create table NhanVien
(
	maNV varchar(4) primary key,
    hoTen varchar(30) not null,
    gioiTinh bit,
    diaChi varchar(50) not null,
    ngaySinh datetime not null,
    dienThoai varchar(15),
    email text,
    noiSinh varchar(20) not null,
    ngayVaoLam datetime,
    maNQL varchar(4)
);

create table NhaCC
(
	maNCC varchar(5) primary key,
    tenNCC varchar(50) not null,
    diaChi varchar(50) not null,
    dienThoai varchar(15) not null,
    email varchar(30) not null,
    website varchar(30)
);

create table LoaiSanPham
(
	maLoaiSP varchar(4) primary key,
    tenLoaiSP varchar(30) not null,
    ghiChu varchar(100)
);

create table SanPham
(
	maSP varchar(4) primary key,
    maLoaiSP varchar(4) not null,
    tenSP varchar(50) not null,
    donViTinh varchar(10) not null,
    ghiChu varchar(100) 
);

alter table SanPham
add foreign key (maLoaiSP) references LoaiSanPham(maLoaiSP);

create table PhieuNhap
(
	soPN varchar(5) primary key,
    maNV varchar(4) not null,
    maNCC varchar(5) not null,
    ngayNhap datetime not null default now(),
    ghiChu varchar(100)
);

alter table PhieuNhap
add foreign key (maNV) references NhanVien(maNV),
add foreign key (maNCC) references NhaCC(maNCC);

create table ChiTietPhieuNhap
(
	maSP varchar(4) not null,
    soPN varchar(5) not null,
    soLuong int not null check(soLuong > 0),
    giaNhap float not null check(giaNhap >= 0),
    primary key (maSP, soPN)
);

alter table ChiTietPhieuNhap
add foreign key (maSP) references SanPham(maSP),
add foreign key (soPN) references PhieuNhap(soPN);

create table PhieuXuat
(
	soPX varchar(5) primary key,
    maNV varchar(4) not null,
    maKH varchar(5) not null,
    ngayBan datetime not null,
    ghiChu varchar(100)	
);

alter table PhieuXuat
add foreign key (maNV) references NhanVien(maNV),
add foreign key (maKH) references KhachHang(maKH);

create table ChiTietPhieuXuat
(
	soPX varchar(5) not null,
    maSP varchar(4) not null,
    soLuong int not null,
    giaBan float not null,
    primary key (soPX, maSP)
);

alter table ChiTietPhieuXuat
add foreign key (soPX) references PhieuXuat(soPX),
add foreign key (maSP) references SanPham(maSP);

insert into LoaiSanPham values 
("LSP1", "Loại SP1", null),
("LSP2", "Loại SP2", null),
("LSP3", "Loại SP3", null);

insert into SanPham values 
("SP01", "LSP1", "Sản phẩm 1", "cái", null),
("SP02", "LSP2", "Sản phẩm 2", "cái", null),
("SP03", "LSP3", "Sản phẩm 3", "cái", null);

insert into SanPham values 
("SP04", "LSP4", "Sản phẩm 4", "chai", null),
("SP05", "LSP5", "Sản phẩm 5", "chai", null),
("SP06", "LSP6", "Sản phẩm 6", "chai", null);

insert into NhaCC values 
("NCC01", "NCC 1", "HN", "0969543214", "email1", "website1");

insert into NhanVien values 
("NV01", "Nambeo", 1, "Hà Tĩnh", "1999-04-04", "0967446598", "nambeo@gmail.com", "Hà Tĩnh", "2020-11-28", "NQL1");

insert into KhachHang values
("KH01", "Khoa Pug", "Đà Nẵng", "2000-05-06", "096755789");

insert into PhieuNhap values
("PN001", "NV01", "NCC01", concat("2023-",month(current_date()),"-23" ), null),
("PN002", "NV01", "NCC01", concat("2023-",month(current_date()),"-10" ), null);

insert into ChiTietPhieuNhap values 
("SP01", "PN001", 5, 5000),
("SP02", "PN001", 2, 3000),
("SP03", "PN002", 1, 3000),
("SP02", "PN002", 2, 2000);

insert into PhieuXuat values 
("PX001", "NV01", "KH01", current_date(), null),
("PX002", "NV01", "KH01", current_date(), null);

insert into ChiTietPhieuXuat values
("PX001", "SP01", 5, 2000),
("PX001", "SP02", 2, 1000),
("PX001", "SP03", 2, 3000),
("PX002", "SP01", 4, 2000),
("PX002", "SP02", 1, 1000),
("PX002", "SP03", 3, 1000);

insert into KhachHang values
("KH10", "Tào Lao", "Đà Nẵng", "2000-04-20", "096755789");

insert into NhanVien values 
("NV02", "Khoa Pug", 1, "Hà Tĩnh", "2000-04-09", "0967446598", "khoaPug@gmail.com", "Đăk Lăk", "2020-11-28", "NQL1");

update KhachHang
set soDT = "0123456789" where maKH = "KH10";

select * from KhachHang;

-- 1. Liệt kê thông tin về nhân viên trong cửa hàng
select nv.maNV, nv.hoTen, nv.gioiTinh, nv.ngaySinh, nv.diaChi, nv.dienThoai, year(current_date()) - year(nv.ngaySinh) as tuổi from NhanVien as nv order by tuổi asc;

-- 2. Liệt kê các hóa đơn nhập hàng trong tháng hiện hành
select pn.soPN, pn.maNV, nv.hoTen, ncc.tenNCC, pn.ngayNhap, pn.ghiChu from PhieuNhap as pn 
join NhanVien as nv on nv.maNV = pn.maNV 
join NhaCC as ncc on ncc.maNCC = pn.maNCC where month(ngayNhap) = month(current_date());

-- 3. Liệt kê tất cả sản phẩm có đơn vị tính là chai, gồm tất cả thông tin về sản phẩm.
select * from SanPham where donViTinh= "chai";

-- 4. Liệt kê chi tiết nhập hàng trong tháng hiện hành gồm thông tin: số phiếu nhập, mã sản phẩm, tên sản phẩm, loại sản phẩm, đơn vị tính, số lượng, giá nhập, thành tiền.
select ctpn.soPN as "Số Phiếu Nhập", ctpn.maSP as "Mã Sản Phẩm", sp.tenSP as "Tên Sản Phẩm", lsp.tenLoaiSP as "Tên Loại Sản Phẩm", sp.donViTinh as "Đơn vị", ctpn.soLuong as "Số lượng", ctpn.giaNhap as "Giá Nhập", ctpn.giaNhap*ctpn.soLuong as "Thành Tiền" from ChiTietPhieuNhap as ctpn
join SanPham as sp on sp.maSP = ctpn.maSP
join LoaiSanPham as lsp on lsp.maLoaiSP = sp.maLoaiSP
join PhieuNhap as pn on pn.soPN = ctpn.soPN
where month(ngayNhap) = month(current_date());


