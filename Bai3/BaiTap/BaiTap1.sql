use quanlisinhvien;
select * from student where studentName like "H%";
select * from class where extract(month from datestart) = 12;
select * from subject where credit between 3 and 5;
select * from student;
-- maybe không phải
update student
set classId = 1 where studentId = 1;

select s.studentName, sub.SubName, M.Mark from student as s join mark as M on M.studentId = s.studentId join `subject` as sub on sub.subId = M.subId order by mark DESC;



