# StudentManagementSystem
Java编写的学生信息管理系统


# 学生信息管理系统说明文档

## 介绍

- **系统名称：** 学生信息管理系统
- **系统版本：** 1.0
- **作者信息：** 张富贵
  

## 系统概述

- **目的：** 介绍系统的主要目标，学生信息跟踪和管理。
- **功能：** 系统提供的主要功能，如学生登记、成绩管理、课程安排等。
- **主要特点：** 强调系统的特点，如多用户支持、报表生成、数据导出等。
- **技术栈：** 说明系统使用的java和MySQL数据库。

## 安装和部署

- **系统要求：** win10及以上
- **数据库设置：** 提供数据库的架构和初始化脚本，以及如何设置和维护数据库。

## 使用指南

- **用户角色：** 管理员、教师和学生。
- **学生信息管理：** 。
- **教师信息管理：** 
- **课程信息管理：** 

## 数据库结构
Department_ID	VARCHAR(10)	主键
Department_Name	VARCHAR(20)	
图4.13 专业表
列名	数据类型	约束
Major_ID	VARCHAR(30)	主键
Major_Name	VARCHAR(30)	
Department_ID	VARCHAR(20)	
图4.14 管理员表
列名	数据类型	约束
User_name	VARCHAR(10)	主键
Password_	VARCHAR(20)	
IsLogin	BIT(1)	
图4.15 课程表
列名	数据类型	约束
Course_Name	VARCHAR(50)	主键
Major_ID	VARCHAR(30)	主键
Grade	INT	主键
图4.16 成绩表
列名	数据类型	约束
Student_ID	VARCHAR(30)	主键
Student_Name	VARCHAR(50)	
Course_Name	VARCHAR(50)	主键
Score	DECIMAL(4,1)	



。





