CREATE DATABASE StudentTest;
USE StudentTest;
CREATE TABLE Student
(
	RN INT PRIMARY KEY AUTO_INCREMENT,
    `Name` VARCHAR(20) NOT NULL,
    Age TINYINT
);

CREATE TABLE Test
(
	TestID INT PRIMARY KEY AUTO_INCREMENT,
    `Name` VARCHAR(20) NOT NULL
);

CREATE TABLE StudentTest
(
	RN INT,
    FOREIGN KEY (RN) REFERENCES Student(RN),
    TestID INT,
    FOREIGN KEY (TestID) REFERENCES Test(TestID),
    `Date` DATETIME,
    Mark FLOAT
);

INSERT INTO Student(`Name`, Age) VALUES
("Nguyen Hong Ha", 20),
("Truong Ngoc Anh", 30),
("Tuan Minh", 25),
("Dan Truong", 22);

INSERT INTO Test(`Name`) VALUES
("EPC"),
("DWMX"),
("SQL1"),
("SQL2");

INSERT INTO StudentTest VALUES
(1, 1, "2006-07-17", 8),
(1, 2, "2006-07-18", 5),
(1, 3, "2006-07-19", 7),
(2, 1, "2006-07-17", 7),
(2, 2, "2006-07-18", 4),
(2, 3, "2006-07-19", 2),
(3, 1, "2006-07-17", 10),
(3, 3, "2006-07-18", 1);

-- 2. Sử dụng alter để thay đổi
-- a. Thêm ràng buộc cho cột age với giá trị 15-55
ALTER TABLE Student
MODIFY COLUMN Age INT CHECK(Age BETWEEN 15 AND 55);
-- b. Thêm giá trị mặc định cho cột mark trong bảng StudentTest là 0
ALTER TABLE StudentTest
MODIFY COLUMN Mark FLOAT DEFAULT(0);
-- c. Thêm khóa chính cho bảng studenttest là (RN,TestID)
ALTER TABLE StudentTest
ADD PRIMARY KEY (RN, TestID);
-- d. Thêm ràng buộc duy nhất (unique) cho cột name trên bảng Test
ALTER TABLE Test
MODIFY COLUMN `Name` VARCHAR(20) UNIQUE;
-- e. Xóa ràng buộc duy nhất (unique) trên bảng Test
ALTER TABLE Test
DROP INDEX `Name_2`;

-- 3. Hiển thị danh sách các học viên đã tham gia thi, các môn thi được thi bởi các học viên đó, điểm thi và ngày thi
SELECT @rownum:= @rownum + 1 as STT, s.`Name` AS StudentName, t.`Name` AS TestName , st.Mark, st.`Date` 
FROM (SELECT @rownum:= 0) as STT, StudentTest AS st
JOIN Student AS s ON s.RN = st.RN 
JOIN Test AS t ON t.TestID = st.TestID;

-- 4. Hiển thị danh sách các bạn học viên chưa thi môn nào như hình sau:
SELECT @rownum:= @rownum + 1 as STT, s.RN, s.`Name`, s.Age 
FROM (SELECT @rownum:= 0) as STT, Student as s 
WHERE s.RN NOT IN (SELECT RN FROM StudentTest);

-- 5. Hiển thị danh sách học viên phải thi lại, tên môn học phải thi lại và điểm thi(điểm phải thi lại là điểm nhỏ hơn 5) như sau:
SELECT @rownum:= @rownum + 1 AS STT, s.`Name`, t.`Name`, st.Mark, st.`Date` 
FROM (SELECT @rownum:= 0) AS STT, Student s
JOIN StudentTest st ON st.RN = s.RN
JOIN Test t ON st.TestID = t.TestID
WHERE st.Mark < 5;

-- 6. Hiển thị danh sách học viên và điểm trung bình(Average) của các môn đã thi. Danh sách phải sắp xếp theo thứ tự điểm trung bình giảm dần(nếu không sắp xếp thì chỉ được ½ số điểm) như sau:  
SELECT @rownum:= @rownum + 1 AS STT, s.`Name`, AVG(Mark) AS Mark 
FROM (SELECT @rownum:= 0) AS STT, Student s
JOIN StudentTest st ON st.RN = s.RN
GROUP BY s.Name
ORDER BY Mark DESC;

-- 7. Hiển thị tên và điểm trung bình của học viên có điểm trung bình lớn nhất như sau:
SELECT s.`Name`, AVG(Mark) AS AVGMark 
FROM Student s
JOIN StudentTest st ON st.RN = s.RN
GROUP BY s.Name
HAVING AVGMark = (
	SELECT MAX(AVGMark) FROM (
		SELECT s.`Name`, AVG(Mark) AS AVGMark 
		FROM Student s
		JOIN StudentTest st ON st.RN = s.RN
		GROUP BY s.Name
	) AS MAX
);

-- 8. Hiển thị điểm thi cao nhất của từng môn học. Danh sách phải được sắp xếp theo tên môn học
SELECT @rownum:= @rownum + 1, t.`Name`, Max(Mark) AS MaxMark 
FROM (SELECT @rownum:= 0) AS STT, StudentTest AS st 
JOIN Test AS t ON st.TestID = t.TestID
GROUP BY t.`Name`
ORDER BY t.`Name`;

-- 9. Hiển thị danh sách tất cả các học viên và môn học mà các học viên đó đã thi nếu học viên chưa thi môn nào thì phần tên môn học để Null 
SELECT s.`Name` AS StudentName, t.`Name` AS TestName 
FROM Student AS s
LEFT JOIN StudentTest AS st ON s.RN = st.RN
LEFT JOIN Test AS t ON t.TestID = st.TestID;

-- 10. Sửa (Update) tuổi của tất cả các học viên mỗi người lên một tuổi.
UPDATE Student
SET Age = Age + 1;

SELECT * FROM Student;

-- 11. Thêm trường tên là Status có kiểu Varchar(10) vào bảng Student.
ALTER TABLE Student
ADD COLUMN `Status` VARCHAR(10);

-- 12. Cập nhật(Update) trường Status sao cho những học viên nhỏ hơn 30 tuổi sẽ nhận giá trị ‘Young’, trường hợp còn lại nhận giá trị ‘Old’ sau đó hiển thị toàn bộ nội dung bảng Student 
UPDATE Student
SET `Status` = CASE
			WHEN Age <= 30 THEN "Young"
            WHEN Age > 30 THEN "Old"
END;

SELECT * FROM Student;

-- 13. Hiển thị danh sách học viên và điểm thi, dánh sách phải sắp xếp tăng dần theo ngày thi 
SELECT @rownum:= @rownum + 1 AS STT, s.`Name` AS StudentName, t.`Name` AS TestName, st.Mark, st.Date 
FROM (SELECT @rownum:= 0) AS STT, Student s
JOIN StudentTest st ON st.RN = s.RN
JOIN Test t ON t.TestID = st.TestID
ORDER BY st.Date;

-- 14. Hiển thị các thông tin sinh viên có tên bắt đầu bằng ký tự ‘T’ và điểm thi trung bình >4.5. Thông tin bao gồm Tên sinh viên, tuổi, điểm trung bình
SELECT s.`Name` AS StudentName, s.Age, AVG(Mark) AS AVGMark 
FROM Student s 
JOIN StudentTest st ON st.RN = s.RN
GROUP BY StudentName, s.Age 
HAVING StudentName like "T%" AND AVGMark > 4.5;

-- 15. Hiển thị các thông tin sinh viên (Mã, tên, tuổi, điểm trung bình, xếp hạng). Trong đó, xếp hạng dựa vào điểm trung bình của học viên, điểm trung bình cao nhất thì xếp hạng 1.
SELECT s.RN, s.`Name`, AVG(Mark), DENSE_RANK() OVER(ORDER BY AVG(Mark) DESC) AS `Rank`
FROM Student s
JOIN StudentTest st ON st.RN = s.RN
GROUP BY s.Name, s.RN;

-- 18. Xóa tất cả các môn học chưa có bất kỳ sinh viên nào thi
DELETE FROM Test WHERE `Name` NOT IN (
SELECT `Name` FROM (
	SELECT t.`Name` 
	FROM Test AS t 
	JOIN StudentTest st ON st.TestID = t.TestID
	) AS c
);

-- 19. Xóa thông tin điểm thi của sinh viên có điểm <5. 
DELETE FROM StudentTest WHERE Mark < 5;
SELECT * FROM StudentTest;


DELIMITER $$
CREATE TRIGGER `test_before_insert` BEFORE INSERT ON `Initial_Fees`
FOR EACH ROW
BEGIN
    IF ((SELECT Activation from Portfolio WHERE idPortfolio = New.idPortfolio)=false) THEN
        SIGNAL SQLSTATE '45000' -- Note: no semicolon
        SET MESSAGE_TEXT = 'Disabled Thing'; -- Note the = operator
    END IF;
END$$   
DELIMITER ; 