use quanlisinhvien;
select Address, count(studentId) as "Số lượng học viên" from student group by address;
select s.studentId, s.studentName, AVG(Mark) 
from student as s join Mark M on S.studentId = M.studentId 
group by s.studentId, s.studentName;
select s.studentId, s.studentName, AVG(Mark) 
from student as s join Mark M on S.studentId = M.studentId 
group by s.studentId, s.studentName having AVG(Mark) > 15;

select s.studentId, s.studentName, AVG(Mark) 
from student as s join Mark M on S.studentId = M.studentId 
group by s.studentId, s.studentName having AVG(Mark) >= all(select AVG(Mark) from Mark group by Mark.studentId);