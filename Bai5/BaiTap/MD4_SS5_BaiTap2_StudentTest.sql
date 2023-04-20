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





