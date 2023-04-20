CREATE DATABASE QuanlySinhvien;

USE QuanlySinhvien;
CREATE TABLE Students
(
	StudentID INT PRIMARY KEY AUTO_INCREMENT,
    StudentName VARCHAR(50) NOT NULL,
    Age INT,
    Email VARCHAR(20)
);

CREATE TABLE Classes 
(
	ClassID INT PRIMARY KEY AUTO_INCREMENT,
    ClassName VARCHAR(10) NOT NULL
);

CREATE TABLE ClassStudent 
(
	StudentID INT NOT NULL,
    FOREIGN KEY (StudentID) REFERENCES Students(StudentID),
    ClassID INT NOT NULL,
    FOREIGN KEY (ClassID) REFERENCES Classes(ClassID)
);

CREATE TABLE Subjects 
(
	SubjectID INT PRIMARY KEY AUTO_INCREMENT,
    SubjectName VARCHAR(50) NOT NULL
);

CREATE TABLE Marks
(
	Mark INT NOT NULL,
    SubjectID INT NOT NULL,
    FOREIGN KEY (SubjectID) REFERENCES Subjects(SubjectID),
    StudentID INT NOT NULL,
    FOREIGN KEY (StudentID) REFERENCES Students(StudentID)
);

INSERT INTO Students (StudentName, Age, Email) VALUES
("Nguyen Quang An", 18, "an@yahoo.com"),
("Nguyen Cong Vinh", 20, "vinh@gmail.com"),
("Nguyen Van Quyen", 19, "quyen"),
("Pham Thanh Binh", 25, "binh@com"),
("Nguyen Van Tai Em", 30, "taiem@sport.vn");

INSERT INTO Classes (ClassName) VALUES
("C0706L"),
("C0708G");

INSERT INTO Subjects (SubjectName) VALUES
("SQL"),
("Java"),
("C"),
("Visual Basic");

INSERT INTO ClassStudent VALUES 
(1, 1),
(2, 1),
(3, 2),
(4, 2),
(5, 2);

INSERT INTO Marks VALUES 
(8, 1, 1),
(4, 2, 1),
(9, 1, 1),
(7, 1, 3),
(3, 1, 4),
(5, 2, 5),
(8, 3, 3),
(1, 3, 5),
(3, 2, 4);

-- 1. HIỂN THỊ DANH SÁCH SINH VIÊN
CREATE VIEW StudentView AS
SELECT * FROM Students;

SELECT * FROM StudentView;

-- 2. HIỂN THỊ DANH SÁCH TẤT CẢ MÔN HỌC
CREATE VIEW SubjectView AS
SELECT * FROM Subjects;

SELECT * FROM SubjectView;

-- 3. TÍNH ĐIỂM TRUNG BÌNH
SELECT s.studentName AS StudentName, AVG(Mark) 
FROM Marks AS m 
JOIN Students AS s ON m.StudentID = s.StudentID 
GROUP BY m.StudentID;

-- 4. HIỂN THỊ MÔN HỌC CÓ HỌC SINH THI ĐƯỢC ĐIỂM CAO NHẤT
SELECT MAX(Mark) AS Mark, sub.SubjectName AS SubjectName, s.StudentName AS StudentName FROM Marks AS m 
JOIN Subjects AS sub ON sub.SubjectID = m.SubjectID 
GROUP BY sub.SubjectName HAVING MAX(Mark) = (SELECT max(Mark) FROM Marks); 

-- 5. ĐÁNH SỐ THỨ TỰ CỦA ĐIỂM THEO CHIỀU GIẢM DẦN
SELECT @rownum:=@rownum+1 AS STT, Mark 
FROM Marks, (SELECT @rownum:=0) AS A
ORDER BY Mark DESC;

-- 7. THÊM DÒNG CHỮ "ĐÂY LÀ MÔN HỌC..." VÀO TRƯỚC CÁC BẢN GHI CỘT SUBJECTNAME TRONG BẢNG SUBJECTS
DELIMITER //
CREATE PROCEDURE updateSubjectName() 
BEGIN 
	UPDATE Subjects
    SET SubjectName = CONCAT("Đây là môn học ", SubjectName);
END //
DELIMITER ;

CALL updateSubjectName();

SELECT * FROM Subjects;

-- 8. VIẾT CHECK CONSTRAINT ĐỂ KIỂM TRA ĐỘ TUỔI NHẬP VÀO TRONG BẢNG STUDENT YÊU CẦU 15 < AGE < 50
ALTER TABLE Students
MODIFY COLUMN Age INT CHECK(Age > 15 AND Age < 50);

-- 9. LOẠI BỎ QUAN HỆ GIỮA CÁC BẢNG
ALTER TABLE Marks 
DROP CONSTRAINT marks_ibfk_1,
DROP CONSTRAINT marks_ibfk_2;

ALTER TABLE ClassStudent 
DROP CONSTRAINT classstudent_ibfk_1,
DROP CONSTRAINT classstudent_ibfk_2;

-- 10. XOÁ HỌC VIÊN CÓ STUDENTID = 1
DELETE FROM Students WHERE StudentID = 1;
SELECT * FROM Students;

-- 11. THÊM 1 COLUMN STATUS BẢNG STUDENTS
ALTER TABLE Students
ADD COLUMN `Status` BIT DEFAULT(1);

-- 12. CẬP NHẬT GIÁ TRỊ STATUS 0
UPDATE Students
SET `Status` = 0;
  