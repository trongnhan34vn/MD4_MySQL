use quanlisinhvien;
select * from `subject`;
-- Hiển thị môn học có credit lớn nhất 
select * 
from `subject`
where (credit = (select Max(credit) as max_credit from `subject`));	
-- Hiển thị thông tin môn học có điểm thi lớn nhất
select sub.subId, sub.subName, sub.credit, m.mark from `subject` as sub 
join mark as m on sub.subId = m.subId
where (m.mark = (select max(mark) as max_mark from mark));
-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select s.studentId, s.studentName, s.address, s.phone, s.`status`, avg(mark) from student as s 
join mark as m on m.studentId = s.studentId
group by s.studentId, s.studentName order by avg(mark) Asc;
