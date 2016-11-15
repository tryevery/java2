use shop;
drop table testFrom;
create table testFrom(timu varchar(50),itemA varchar(20),
itemB varchar(20),itemC varchar(20),itemD varchar(20),itemAnswer char(2));
insert into testFrom values('1.北京奥运会开幕时间?','A.2008年08月08日',
'B.2008年08月01日','C.2008年10月01日','D.2008年07月08日','A');
insert into testFrom values('2. 下列那个国家不属于亚洲','A.沙特','B.印度','C.巴西 ','D.越南','C');
