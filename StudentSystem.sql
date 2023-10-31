create database StudentSystem;

use StudentSystem;
create table table_Student(      #学生表
  Student_Id varchar(20) primary key,
  Student_Name nvarchar(20) not null,
  Student_Sex nchar(3) default '男' not null check (Student_Sex in('男','女')),
  Classe int not null,
  Major_ID varchar(30) not null,
  Major_Name nvarchar(30)  not null,
  Department_ID varchar(20) not null,
  Department_Name nvarchar(10)  not null,
  foreign key(Department_ID) references table_Department(Department_ID),
  foreign key(Major_ID) references table_Major(Major_ID),
  foreign key(Department_Name) references table_Department(Department_Name),
  foreign key(Major_Name) references table_Major(Major_Name)
);

use StudentSystem;
create table table_Classe(
Classe int not null,
Grade int not null,
Major_ID varchar(20) not null,
primary key(Classe,Grade,Major_ID)
);

use StudentSystem;
create table table_Department(
 Department_ID varchar(10) primary key,
 Department_Name nvarchar(20) unique not null
);

use StudentSystem;
create table table_Major(
Major_ID varchar(30) primary key,
Major_Name nvarchar(30) unique not null,
Department_ID varchar(20) not null,
foreign key(Department_ID) references table_Department(Department_ID)
);


use StudentSystem;
create table table_User(
 User_name nvarchar(10) primary key,
 Password_ varchar(20) not null,
 IsLogin bit not null DEFAULT 0     #是否重复登陆

);


use StudentSystem;
create table table_Course(
  Course_Name nvarchar(50) not null,
  Major_ID varchar(30) not null,
  foreign key(Major_ID) references table_Major(Major_ID),
  Grade int not null,	#年级
  primary key(Course_Name,Major_ID,Grade)
);


use StudentSystem;
create table table_Score(
 Student_Id varchar(30) not null,
 Student_Name nvarchar(50) not null,
 Course_Name nvarchar(50) not null,
 primary key(Course_Name,Student_Id),
 foreign key(Student_Id) references table_Student(Student_Id),
 foreign key(Course_Name) references table_Course(Course_Name),
 Score dec(4,1) default null  check(Score between 0.0 and 100.0)
);


/*插入院系*/
insert into table_Department(Department_ID ,Department_Name) values('01','电子信息系');
insert into table_Department(Department_ID ,Department_Name) values('02','艺术系');
insert into table_Department(Department_ID ,Department_Name) values('03','计算机科学与工程');
insert into table_Department(Department_ID ,Department_Name) values('04','物流与信息管理系');


/*插入专业*/
insert into table_Major(Major_ID,Major_Name,Department_ID) values('01','计算机科学与技术专业','03');
insert into table_Major(Major_ID,Major_Name,Department_ID) values('02','软件工程专业','03');
insert into table_Major(Major_ID,Major_Name,Department_ID) values('03','物流管理专业','04');
insert into table_Major(Major_ID,Major_Name,Department_ID) values('04','信息管理与信息系统专业','04');
insert into table_Major(Major_ID,Major_Name,Department_ID) values('05','电子信息科学与技术专业','01');
insert into table_Major(Major_ID,Major_Name,Department_ID) values('06','微电子科学与工程专业','01');
insert into table_Major(Major_ID,Major_Name,Department_ID) values('07','视觉设计专业','02');
insert into table_Major(Major_ID,Major_Name,Department_ID) values('08','3D动画专业','02');




/*添加班级*/
insert into table_Classe(Classe,Grade,Major_ID) values(1,2020,'01');
insert into table_Classe(Classe,Grade,Major_ID) values(2,2020,'01');
insert into table_Classe(Classe,Grade,Major_ID) values(3,2020,'01');
insert into table_Classe(Classe,Grade,Major_ID) values(4,2020,'01');
insert into table_Classe(Classe,Grade,Major_ID) values(1,2020,'02');
insert into table_Classe(Classe,Grade,Major_ID) values(2,2020,'02');
insert into table_Classe(Classe,Grade,Major_ID) values(3,2020,'02');
insert into table_Classe(Classe,Grade,Major_ID) values(4,2020,'02');
insert into table_Classe(Classe,Grade,Major_ID) values(1,2020,'03');
insert into table_Classe(Classe,Grade,Major_ID) values(2,2020,'03');
insert into table_Classe(Classe,Grade,Major_ID) values(3,2020,'03');
insert into table_Classe(Classe,Grade,Major_ID) values(4,2020,'03');
insert into table_Classe(Classe,Grade,Major_ID) values(1,2020,'04');
insert into table_Classe(Classe,Grade,Major_ID) values(2,2020,'04');
insert into table_Classe(Classe,Grade,Major_ID) values(3,2020,'04');
insert into table_Classe(Classe,Grade,Major_ID) values(4,2020,'04');
insert into table_Classe(Classe,Grade,Major_ID) values(1,2020,'05');
insert into table_Classe(Classe,Grade,Major_ID) values(2,2020,'05');
insert into table_Classe(Classe,Grade,Major_ID) values(3,2020,'05');
insert into table_Classe(Classe,Grade,Major_ID) values(4,2020,'05');
insert into table_Classe(Classe,Grade,Major_ID) values(1,2020,'06');
insert into table_Classe(Classe,Grade,Major_ID) values(2,2020,'06');
insert into table_Classe(Classe,Grade,Major_ID) values(3,2020,'06');
insert into table_Classe(Classe,Grade,Major_ID) values(4,2020,'06');
insert into table_Classe(Classe,Grade,Major_ID) values(1,2020,'07');
insert into table_Classe(Classe,Grade,Major_ID) values(2,2020,'07');
insert into table_Classe(Classe,Grade,Major_ID) values(3,2020,'07');
insert into table_Classe(Classe,Grade,Major_ID) values(4,2020,'07');
insert into table_Classe(Classe,Grade,Major_ID) values(1,2020,'08');
insert into table_Classe(Classe,Grade,Major_ID) values(2,2020,'08');
insert into table_Classe(Classe,Grade,Major_ID) values(3,2020,'08');
insert into table_Classe(Classe,Grade,Major_ID) values(4,2020,'08');

insert into table_Classe(Classe,Grade,Major_ID) values(1,2021,'01');
insert into table_Classe(Classe,Grade,Major_ID) values(2,2021,'01');
insert into table_Classe(Classe,Grade,Major_ID) values(3,2021,'01');
insert into table_Classe(Classe,Grade,Major_ID) values(4,2021,'01');
insert into table_Classe(Classe,Grade,Major_ID) values(1,2021,'02');
insert into table_Classe(Classe,Grade,Major_ID) values(2,2021,'02');
insert into table_Classe(Classe,Grade,Major_ID) values(3,2021,'02');
insert into table_Classe(Classe,Grade,Major_ID) values(4,2021,'02');
insert into table_Classe(Classe,Grade,Major_ID) values(1,2021,'03');
insert into table_Classe(Classe,Grade,Major_ID) values(2,2021,'03');
insert into table_Classe(Classe,Grade,Major_ID) values(3,2021,'03');
insert into table_Classe(Classe,Grade,Major_ID) values(4,2021,'03');
insert into table_Classe(Classe,Grade,Major_ID) values(1,2021,'04');
insert into table_Classe(Classe,Grade,Major_ID) values(2,2021,'04');
insert into table_Classe(Classe,Grade,Major_ID) values(3,2021,'04');
insert into table_Classe(Classe,Grade,Major_ID) values(4,2021,'04');
insert into table_Classe(Classe,Grade,Major_ID) values(1,2021,'05');
insert into table_Classe(Classe,Grade,Major_ID) values(2,2021,'05');
insert into table_Classe(Classe,Grade,Major_ID) values(3,2021,'05');
insert into table_Classe(Classe,Grade,Major_ID) values(4,2021,'05');
insert into table_Classe(Classe,Grade,Major_ID) values(1,2021,'06');
insert into table_Classe(Classe,Grade,Major_ID) values(2,2021,'06');
insert into table_Classe(Classe,Grade,Major_ID) values(3,2021,'06');
insert into table_Classe(Classe,Grade,Major_ID) values(4,2021,'06');
insert into table_Classe(Classe,Grade,Major_ID) values(1,2021,'07');
insert into table_Classe(Classe,Grade,Major_ID) values(2,2021,'07');
insert into table_Classe(Classe,Grade,Major_ID) values(3,2021,'07');
insert into table_Classe(Classe,Grade,Major_ID) values(4,2021,'07');
insert into table_Classe(Classe,Grade,Major_ID) values(1,2021,'08');
insert into table_Classe(Classe,Grade,Major_ID) values(2,2021,'08');
insert into table_Classe(Classe,Grade,Major_ID) values(3,2021,'08');
insert into table_Classe(Classe,Grade,Major_ID) values(4,2021,'08');


insert into table_Classe(Classe,Grade,Major_ID) values(1,2022,'01');
insert into table_Classe(Classe,Grade,Major_ID) values(2,2022,'01');
insert into table_Classe(Classe,Grade,Major_ID) values(3,2022,'01');
insert into table_Classe(Classe,Grade,Major_ID) values(4,2022,'01');
insert into table_Classe(Classe,Grade,Major_ID) values(1,2022,'02');
insert into table_Classe(Classe,Grade,Major_ID) values(2,2022,'02');
insert into table_Classe(Classe,Grade,Major_ID) values(3,2022,'02');
insert into table_Classe(Classe,Grade,Major_ID) values(4,2022,'02');
insert into table_Classe(Classe,Grade,Major_ID) values(1,2022,'03');
insert into table_Classe(Classe,Grade,Major_ID) values(2,2022,'03');
insert into table_Classe(Classe,Grade,Major_ID) values(3,2022,'03');
insert into table_Classe(Classe,Grade,Major_ID) values(4,2022,'03');
insert into table_Classe(Classe,Grade,Major_ID) values(1,2022,'04');
insert into table_Classe(Classe,Grade,Major_ID) values(2,2022,'04');
insert into table_Classe(Classe,Grade,Major_ID) values(3,2022,'04');
insert into table_Classe(Classe,Grade,Major_ID) values(4,2022,'04');
insert into table_Classe(Classe,Grade,Major_ID) values(1,2022,'05');
insert into table_Classe(Classe,Grade,Major_ID) values(2,2022,'05');
insert into table_Classe(Classe,Grade,Major_ID) values(3,2022,'05');
insert into table_Classe(Classe,Grade,Major_ID) values(4,2022,'05');
insert into table_Classe(Classe,Grade,Major_ID) values(1,2022,'06');
insert into table_Classe(Classe,Grade,Major_ID) values(2,2022,'06');
insert into table_Classe(Classe,Grade,Major_ID) values(3,2022,'06');
insert into table_Classe(Classe,Grade,Major_ID) values(4,2022,'06');
insert into table_Classe(Classe,Grade,Major_ID) values(1,2022,'07');
insert into table_Classe(Classe,Grade,Major_ID) values(2,2022,'07');
insert into table_Classe(Classe,Grade,Major_ID) values(3,2022,'07');
insert into table_Classe(Classe,Grade,Major_ID) values(4,2022,'07');
insert into table_Classe(Classe,Grade,Major_ID) values(1,2022,'08');
insert into table_Classe(Classe,Grade,Major_ID) values(2,2022,'08');
insert into table_Classe(Classe,Grade,Major_ID) values(3,2022,'08');
insert into table_Classe(Classe,Grade,Major_ID) values(4,2022,'08');

insert into table_Classe(Classe,Grade,Major_ID) values(1,2023,'01');
insert into table_Classe(Classe,Grade,Major_ID) values(2,2023,'01');
insert into table_Classe(Classe,Grade,Major_ID) values(3,2023,'01');
insert into table_Classe(Classe,Grade,Major_ID) values(4,2023,'01');
insert into table_Classe(Classe,Grade,Major_ID) values(1,2023,'02');
insert into table_Classe(Classe,Grade,Major_ID) values(2,2023,'02');
insert into table_Classe(Classe,Grade,Major_ID) values(3,2023,'02');
insert into table_Classe(Classe,Grade,Major_ID) values(4,2023,'02');
insert into table_Classe(Classe,Grade,Major_ID) values(1,2023,'03');
insert into table_Classe(Classe,Grade,Major_ID) values(2,2023,'03');
insert into table_Classe(Classe,Grade,Major_ID) values(3,2023,'03');
insert into table_Classe(Classe,Grade,Major_ID) values(4,2023,'03');
insert into table_Classe(Classe,Grade,Major_ID) values(1,2023,'04');
insert into table_Classe(Classe,Grade,Major_ID) values(2,2023,'04');
insert into table_Classe(Classe,Grade,Major_ID) values(3,2023,'04');
insert into table_Classe(Classe,Grade,Major_ID) values(4,2023,'04');
insert into table_Classe(Classe,Grade,Major_ID) values(1,2023,'05');
insert into table_Classe(Classe,Grade,Major_ID) values(2,2023,'05');
insert into table_Classe(Classe,Grade,Major_ID) values(3,2023,'05');
insert into table_Classe(Classe,Grade,Major_ID) values(4,2023,'05');
insert into table_Classe(Classe,Grade,Major_ID) values(1,2023,'06');
insert into table_Classe(Classe,Grade,Major_ID) values(2,2023,'06');
insert into table_Classe(Classe,Grade,Major_ID) values(3,2023,'06');
insert into table_Classe(Classe,Grade,Major_ID) values(4,2023,'06');
insert into table_Classe(Classe,Grade,Major_ID) values(1,2023,'07');
insert into table_Classe(Classe,Grade,Major_ID) values(2,2023,'07');
insert into table_Classe(Classe,Grade,Major_ID) values(3,2023,'07');
insert into table_Classe(Classe,Grade,Major_ID) values(4,2023,'07');
insert into table_Classe(Classe,Grade,Major_ID) values(1,2023,'08');
insert into table_Classe(Classe,Grade,Major_ID) values(2,2023,'08');
insert into table_Classe(Classe,Grade,Major_ID) values(3,2023,'08');
insert into table_Classe(Classe,Grade,Major_ID) values(4,2023,'08');

/*添加课程*/
insert into table_Course(Course_Name,Major_ID,Grade) values ('高等数学','01',2020);
insert into table_Course(Course_Name,Major_ID,Grade) values ('英语','01',2020);
insert into table_Course(Course_Name,Major_ID,Grade) values ('数据结构','01',2020);
insert into table_Course(Course_Name,Major_ID,Grade) values ('计算机组成原理','01',2020);
insert into table_Course(Course_Name,Major_ID,Grade) values ('面向对象程序设计','01',2020);

insert into table_Course(Course_Name,Major_ID,Grade) values ('高等数学','02',2020);
insert into table_Course(Course_Name,Major_ID,Grade) values ('英语','02',2020);
insert into table_Course(Course_Name,Major_ID,Grade) values ('数据结构','02',2020);
insert into table_Course(Course_Name,Major_ID,Grade) values ('软件工程导论','02',2020);
insert into table_Course(Course_Name,Major_ID,Grade) values ('面向对象程序设计','02',2020);

insert into table_Course(Course_Name,Major_ID,Grade) values ('高等数学','03',2020);
insert into table_Course(Course_Name,Major_ID,Grade) values ('英语','03',2020);
insert into table_Course(Course_Name,Major_ID,Grade) values ('数据结构','03',2020);
insert into table_Course(Course_Name,Major_ID,Grade) values ('计算机网络','03',2020);
insert into table_Course(Course_Name,Major_ID,Grade) values ('面向对象程序设计','03',2020);

insert into table_Course(Course_Name,Major_ID,Grade) values ('高等数学','04',2020);
insert into table_Course(Course_Name,Major_ID,Grade) values ('英语','04',2020);
insert into table_Course(Course_Name,Major_ID,Grade) values ('数据结构','04',2020);
insert into table_Course(Course_Name,Major_ID,Grade) values ('计算机网络','04',2020);
insert into table_Course(Course_Name,Major_ID,Grade) values ('面向对象程序设计','04',2020);

insert into table_Course(Course_Name,Major_ID,Grade) values ('高等数学','05',2020);
insert into table_Course(Course_Name,Major_ID,Grade) values ('英语','05',2020);
insert into table_Course(Course_Name,Major_ID,Grade) values ('数据结构','05',2020);
insert into table_Course(Course_Name,Major_ID,Grade) values ('计算机网络','05',2020);
insert into table_Course(Course_Name,Major_ID,Grade) values ('面向对象程序设计','05',2020);



insert into table_Course(Course_Name,Major_ID,Grade) values ('高等数学','06',2020);
insert into table_Course(Course_Name,Major_ID,Grade) values ('英语','06',2020);
insert into table_Course(Course_Name,Major_ID,Grade) values ('数据结构','06',2020);
insert into table_Course(Course_Name,Major_ID,Grade) values ('计算机网络','06',2020);
insert into table_Course(Course_Name,Major_ID,Grade) values ('面向对象程序设计','06',2020);

insert into table_Course(Course_Name,Major_ID,Grade) values ('高等数学','07',2020);
insert into table_Course(Course_Name,Major_ID,Grade) values ('英语','07',2020);
insert into table_Course(Course_Name,Major_ID,Grade) values ('数据结构','07',2020);
insert into table_Course(Course_Name,Major_ID,Grade) values ('计算机网络','07',2020);
insert into table_Course(Course_Name,Major_ID,Grade) values ('面向对象程序设计','07',2020);


insert into table_Course(Course_Name,Major_ID,Grade) values ('高等数学','08',2020);
insert into table_Course(Course_Name,Major_ID,Grade) values ('英语','08',2020);
insert into table_Course(Course_Name,Major_ID,Grade) values ('数据结构','08',2020);
insert into table_Course(Course_Name,Major_ID,Grade) values ('计算机网络','08',2020);
insert into table_Course(Course_Name,Major_ID,Grade) values ('面向对象程序设计','08',2020);



insert into table_Course(Course_Name,Major_ID,Grade) values ('高等数学','01',2021);
insert into table_Course(Course_Name,Major_ID,Grade) values ('英语','01',2021);
insert into table_Course(Course_Name,Major_ID,Grade) values ('数据结构','01',2021);
insert into table_Course(Course_Name,Major_ID,Grade) values ('计算机组成原理','01',2021);
insert into table_Course(Course_Name,Major_ID,Grade) values ('面向对象程序设计','01',2021);

insert into table_Course(Course_Name,Major_ID,Grade) values ('高等数学','02',2021);
insert into table_Course(Course_Name,Major_ID,Grade) values ('英语','02',2021);
insert into table_Course(Course_Name,Major_ID,Grade) values ('数据结构','02',2021);
insert into table_Course(Course_Name,Major_ID,Grade) values ('软件工程导论','02',2021);
insert into table_Course(Course_Name,Major_ID,Grade) values ('面向对象程序设计','02',2021);

insert into table_Course(Course_Name,Major_ID,Grade) values ('高等数学','03',2021);
insert into table_Course(Course_Name,Major_ID,Grade) values ('英语','03',2021);
insert into table_Course(Course_Name,Major_ID,Grade) values ('数据结构','03',2021);
insert into table_Course(Course_Name,Major_ID,Grade) values ('计算机网络','03',2021);
insert into table_Course(Course_Name,Major_ID,Grade) values ('面向对象程序设计','03',2021);

insert into table_Course(Course_Name,Major_ID,Grade) values ('高等数学','04',2021);
insert into table_Course(Course_Name,Major_ID,Grade) values ('英语','04',2021);
insert into table_Course(Course_Name,Major_ID,Grade) values ('数据结构','04',2021);
insert into table_Course(Course_Name,Major_ID,Grade) values ('计算机网络','04',2021);
insert into table_Course(Course_Name,Major_ID,Grade) values ('面向对象程序设计','04',2021);

insert into table_Course(Course_Name,Major_ID,Grade) values ('高等数学','05',2021);
insert into table_Course(Course_Name,Major_ID,Grade) values ('英语','05',2021);
insert into table_Course(Course_Name,Major_ID,Grade) values ('数据结构','05',2021);
insert into table_Course(Course_Name,Major_ID,Grade) values ('计算机网络','05',2021);
insert into table_Course(Course_Name,Major_ID,Grade) values ('面向对象程序设计','05',2021);



insert into table_Course(Course_Name,Major_ID,Grade) values ('高等数学','06',2021);
insert into table_Course(Course_Name,Major_ID,Grade) values ('英语','06',2021);
insert into table_Course(Course_Name,Major_ID,Grade) values ('数据结构','06',2021);
insert into table_Course(Course_Name,Major_ID,Grade) values ('计算机网络','06',2021);
insert into table_Course(Course_Name,Major_ID,Grade) values ('面向对象程序设计','06',2021);

insert into table_Course(Course_Name,Major_ID,Grade) values ('高等数学','07',2021);
insert into table_Course(Course_Name,Major_ID,Grade) values ('英语','07',2021);
insert into table_Course(Course_Name,Major_ID,Grade) values ('数据结构','07',2021);
insert into table_Course(Course_Name,Major_ID,Grade) values ('计算机网络','07',2021);
insert into table_Course(Course_Name,Major_ID,Grade) values ('面向对象程序设计','07',2021);


insert into table_Course(Course_Name,Major_ID,Grade) values ('高等数学','08',2021);
insert into table_Course(Course_Name,Major_ID,Grade) values ('英语','08',2021);
insert into table_Course(Course_Name,Major_ID,Grade) values ('数据结构','08',2021);
insert into table_Course(Course_Name,Major_ID,Grade) values ('计算机网络','08',2021);
insert into table_Course(Course_Name,Major_ID,Grade) values ('面向对象程序设计','08',2021);


insert into table_Course(Course_Name,Major_ID,Grade) values ('高等数学','01',2022);
insert into table_Course(Course_Name,Major_ID,Grade) values ('英语','01',2022);
insert into table_Course(Course_Name,Major_ID,Grade) values ('数据结构','01',2022);
insert into table_Course(Course_Name,Major_ID,Grade) values ('计算机组成原理','01',2022);
insert into table_Course(Course_Name,Major_ID,Grade) values ('面向对象程序设计','01',2022);

insert into table_Course(Course_Name,Major_ID,Grade) values ('高等数学','02',2022);
insert into table_Course(Course_Name,Major_ID,Grade) values ('英语','02',2022);
insert into table_Course(Course_Name,Major_ID,Grade) values ('数据结构','02',2022);
insert into table_Course(Course_Name,Major_ID,Grade) values ('软件工程导论','02',2022);
insert into table_Course(Course_Name,Major_ID,Grade) values ('面向对象程序设计','02',2022);

insert into table_Course(Course_Name,Major_ID,Grade) values ('高等数学','03',2022);
insert into table_Course(Course_Name,Major_ID,Grade) values ('英语','03',2022);
insert into table_Course(Course_Name,Major_ID,Grade) values ('数据结构','03',2022);
insert into table_Course(Course_Name,Major_ID,Grade) values ('计算机网络','03',2022);
insert into table_Course(Course_Name,Major_ID,Grade) values ('面向对象程序设计','03',2022);

insert into table_Course(Course_Name,Major_ID,Grade) values ('高等数学','04',2022);
insert into table_Course(Course_Name,Major_ID,Grade) values ('英语','04',2022);
insert into table_Course(Course_Name,Major_ID,Grade) values ('数据结构','04',2022);
insert into table_Course(Course_Name,Major_ID,Grade) values ('计算机网络','04',2022);
insert into table_Course(Course_Name,Major_ID,Grade) values ('面向对象程序设计','04',2022);

insert into table_Course(Course_Name,Major_ID,Grade) values ('高等数学','05',2022);
insert into table_Course(Course_Name,Major_ID,Grade) values ('英语','05',2022);
insert into table_Course(Course_Name,Major_ID,Grade) values ('数据结构','05',2022);
insert into table_Course(Course_Name,Major_ID,Grade) values ('计算机网络','05',2022);
insert into table_Course(Course_Name,Major_ID,Grade) values ('面向对象程序设计','05',2022);



insert into table_Course(Course_Name,Major_ID,Grade) values ('高等数学','06',2022);
insert into table_Course(Course_Name,Major_ID,Grade) values ('英语','06',2022);
insert into table_Course(Course_Name,Major_ID,Grade) values ('数据结构','06',2022);
insert into table_Course(Course_Name,Major_ID,Grade) values ('计算机网络','06',2022);
insert into table_Course(Course_Name,Major_ID,Grade) values ('面向对象程序设计','06',2022);

insert into table_Course(Course_Name,Major_ID,Grade) values ('高等数学','07',2022);
insert into table_Course(Course_Name,Major_ID,Grade) values ('英语','07',2022);
insert into table_Course(Course_Name,Major_ID,Grade) values ('数据结构','07',2022);
insert into table_Course(Course_Name,Major_ID,Grade) values ('计算机网络','07',2022);
insert into table_Course(Course_Name,Major_ID,Grade) values ('面向对象程序设计','07',2022);


insert into table_Course(Course_Name,Major_ID,Grade) values ('高等数学','08',2022);
insert into table_Course(Course_Name,Major_ID,Grade) values ('英语','08',2022);
insert into table_Course(Course_Name,Major_ID,Grade) values ('数据结构','08',2022);
insert into table_Course(Course_Name,Major_ID,Grade) values ('计算机网络','08',2022);
insert into table_Course(Course_Name,Major_ID,Grade) values ('面向对象程序设计','08',2022);

insert into table_Course(Course_Name,Major_ID,Grade) values ('高等数学','01',2023);
insert into table_Course(Course_Name,Major_ID,Grade) values ('英语','01',2023);
insert into table_Course(Course_Name,Major_ID,Grade) values ('数据结构','01',2023);
insert into table_Course(Course_Name,Major_ID,Grade) values ('计算机组成原理','01',2023);
insert into table_Course(Course_Name,Major_ID,Grade) values ('面向对象程序设计','01',2023);

insert into table_Course(Course_Name,Major_ID,Grade) values ('高等数学','02',2023);
insert into table_Course(Course_Name,Major_ID,Grade) values ('英语','02',2023);
insert into table_Course(Course_Name,Major_ID,Grade) values ('数据结构','02',2023);
insert into table_Course(Course_Name,Major_ID,Grade) values ('软件工程导论','02',2023);
insert into table_Course(Course_Name,Major_ID,Grade) values ('面向对象程序设计','02',2023);

insert into table_Course(Course_Name,Major_ID,Grade) values ('高等数学','03',2023);
insert into table_Course(Course_Name,Major_ID,Grade) values ('英语','03',2023);
insert into table_Course(Course_Name,Major_ID,Grade) values ('数据结构','03',2023);
insert into table_Course(Course_Name,Major_ID,Grade) values ('计算机网络','03',2023);
insert into table_Course(Course_Name,Major_ID,Grade) values ('面向对象程序设计','03',2023);

insert into table_Course(Course_Name,Major_ID,Grade) values ('高等数学','04',2023);
insert into table_Course(Course_Name,Major_ID,Grade) values ('英语','04',2023);
insert into table_Course(Course_Name,Major_ID,Grade) values ('数据结构','04',2023);
insert into table_Course(Course_Name,Major_ID,Grade) values ('计算机网络','04',2023);
insert into table_Course(Course_Name,Major_ID,Grade) values ('面向对象程序设计','04',2023);

insert into table_Course(Course_Name,Major_ID,Grade) values ('高等数学','05',2023);
insert into table_Course(Course_Name,Major_ID,Grade) values ('英语','05',2023);
insert into table_Course(Course_Name,Major_ID,Grade) values ('数据结构','05',2023);
insert into table_Course(Course_Name,Major_ID,Grade) values ('计算机网络','05',2023);
insert into table_Course(Course_Name,Major_ID,Grade) values ('面向对象程序设计','05',2023);



insert into table_Course(Course_Name,Major_ID,Grade) values ('高等数学','06',2023);
insert into table_Course(Course_Name,Major_ID,Grade) values ('英语','06',2023);
insert into table_Course(Course_Name,Major_ID,Grade) values ('数据结构','06',2023);
insert into table_Course(Course_Name,Major_ID,Grade) values ('计算机网络','06',2023);
insert into table_Course(Course_Name,Major_ID,Grade) values ('面向对象程序设计','06',2023);

insert into table_Course(Course_Name,Major_ID,Grade) values ('高等数学','07',2023);
insert into table_Course(Course_Name,Major_ID,Grade) values ('英语','07',2023);
insert into table_Course(Course_Name,Major_ID,Grade) values ('数据结构','07',2023);
insert into table_Course(Course_Name,Major_ID,Grade) values ('计算机网络','07',2023);
insert into table_Course(Course_Name,Major_ID,Grade) values ('面向对象程序设计','07',2023);


insert into table_Course(Course_Name,Major_ID,Grade) values ('高等数学','08',2023);
insert into table_Course(Course_Name,Major_ID,Grade) values ('英语','08',2023);
insert into table_Course(Course_Name,Major_ID,Grade) values ('数据结构','08',2023);
insert into table_Course(Course_Name,Major_ID,Grade) values ('计算机网络','08',2023);
insert into table_Course(Course_Name,Major_ID,Grade) values ('面向对象程序设计','08',2023);



