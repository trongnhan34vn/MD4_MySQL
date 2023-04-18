
-- xoá dũ liệu
delete from student;
-- reset dữ liệu
truncate student;
insert into student (studentname, birthday, address) values
("Nhân","1998-03-09","Hà Nội"),
("Nam béo","1999-04-04","Hà Tĩnh"),
("Khoa Pug", "2000-08-06", "Kon Tum"),
("Chã","2003-10-12","Hưng Yên");

select studentid, studentname  from student

