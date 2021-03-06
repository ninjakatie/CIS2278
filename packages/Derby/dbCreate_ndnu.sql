DROP TABLE Employees;
DROP TABLE Departments;
DROP TABLE Phones;
DROP TABLE EmployeePhones;


CREATE TABLE Employees
(
   emp_id     	INTEGER NOT NULL,
   emp_firstname       VARCHAR(40),
   emp_lastname      VARCHAR(40),
   emp_hiredate 	DATE,
   emp_salary       DECIMAL(9,2),
   emp_deptid      VARCHAR(10)
);

CREATE TABLE Departments
(
   dept_id       VARCHAR(10),
   dept_name      VARCHAR(20)
);

CREATE TABLE Phones
(
	ph_number		VARCHAR(15),
	ph_model		VARCHAR(25)
);

CREATE TABLE EmployeePhones
(
	emp_id       INTEGER NOT NULL,
	phone_number       VARCHAR(15)
);

INSERT INTO Employees VALUES (1, 'Wonder', 'Woman', '1992-01-04', 175.97, 'IT');
INSERT INTO Employees VALUES (2, 'Captain', 'America', '2012-07-12', 1300.20, 'MKT');
INSERT INTO Employees VALUES (3, 'Robin', 'Hood', '2015-09-21', 309.56, 'FIN');

INSERT INTO Departments VALUES ('IT', 'Info Tech');
INSERT INTO Departments VALUES ('MKT', 'Marketing');
INSERT INTO Departments VALUES ('FIN', 'Finance');

COMMIT;
