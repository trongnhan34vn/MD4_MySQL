use quanlisinhvien;
select * from student;
select * from student where `status` = true;
select * from `subject` where credit < 10;

select s.studentId, s.studentName, c.className from student as s join class as c on s.classId = c.classId;
select s.studentId, s.studentName, c.className from student as s join class as c on s.classId = c.classId where c.classname = "A1";
select s.studentId, s.studentName, sub.subName, M.Mark from student as s join mark as M on s.studentId=m.studentId join `subject` as sub on M.subId = Sub.subId;
select s.studentId, s.studentName, sub.subName, M.Mark from student as s join mark as M on s.studentId=m.studentId join `subject` as sub on M.subId = Sub.subId where subName = "CF";