CREATE TABLE Employee (
    employeeid int,
	name VARCHAR(30),
	password VARCHAR(20),
	lastLoginDate VARCHAR(10),
	lastLoginTime VARCHAR(10)
);

INSERT INTO Employee (employeeid, name, password, lastLoginDate, lastLoginTime)VALUES (4257001, 'Rashmita', 'Qwerty@123', '09/08/2022', '21:00:23');
INSERT INTO Employee (employeeid, name, password, lastLoginDate, lastLoginTime)VALUES (4257002, 'Meenakshi', 'asdFg!2T', '12/10/2021', '23:30:56');
INSERT INTO Employee (employeeid, name, password, lastLoginDate, lastLoginTime)VALUES (4257003, 'Ankur', 'Lpo9ji!!', '04/06/2022', '00:08:09');
INSERT INTO Employee (employeeid, name, password, lastLoginDate, lastLoginTime)VALUES (4257004, 'Disha', 'bvD?299', '12/12/2021', '10:00:34');
INSERT INTO Employee (employeeid, name, password, lastLoginDate, lastLoginTime)VALUES (4257005, 'Mayank', 'Plo7bh#ee', '07/02/2022', '16:00:51');
alter table Employee alter column employeeid not null; 
alter table Employee add primary key (employeeid);