show databases;
create database farmfresh;
use farmfresh;
create table category(
cname varchar(20)
);
insert into category values('Fruits');
insert into category values('Vegetables');
insert into category values('Millets');
insert into category values('Others');
create table clogin(
id int,
name varchar(20)
);
create table cusfid(
fid int
);
create table customercart(
cid int,
fid int,
category varchar(20),
goodsname varchar(20),
orderQty int,
price double,
totalprice double
);
create table customerlogin(
id int primary key auto_increment,
name varchar(40),
phoneno varchar(10),
location varchar(20),
username varchar(50),
password varchar(20)
);
create table customerorderdetails(
cid int,
fid int,
category varchar(20),
goodsname varchar(20),
orderQty int,
price double,
totalprice double
);
create table farmerlogin(
id int primary key auto_increment,
name varchar(40),
phoneno varchar(10),
location varchar(20),
username varchar(50),
password varchar(20)
);
create table farmerordertable(
fid int,
name varchar(40),
phone varchar(10),
location varchar(20),
category varchar(20),
goodsname varchar(20),
qty int
);
create table goods(
fid int,
category varchar(20),
gname varchar(20),
qty int,
price double
);
create table login(
id int,
name varchar(20)
);