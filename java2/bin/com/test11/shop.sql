drop database shop;
create database shop;
use shop;
drop table goods
create table goods(id int,name varchar(20),madeTime date,price double(10,2));

insert into goods values(1,'����','2009-10-01',300000);
insert into goods values(2,'·��','2009-10-02',290000);
insert into goods values(3,'�µ�','2009-10-03',350000);

create table cargo(number varchar(10) primary key,name varchar(20),madeTime date,price double(10,2));

insert into cargo values('A001','����','2009-10-01',300000);
insert into cargo values('B002','·��','2009-10-02',290000);
insert into cargo values('C003','�µ�','2009-10-03',350000);