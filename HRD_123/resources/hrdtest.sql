create table member_tbl_02 (
    custno number(6) not null primary key,
    custname varchar2(20),
    phone varchar2(13),
    address varchar2(60),
    joindate date,
    grade char(1),
    city char(2)
);
select * from member_tbl_02
order by custno;

insert into member_tbl_02 (custno, custname, phone, address, joindate, grade, city)
values (member_seq.currval, '차공단', '010-1111-7777', '제주도 제주시 외나무골', '2015-12-11', 'C', '60');

create table money_tbl_02 (
    custno number(6) not null,
    saleno number(8) not null,
    pcost number(8),
    amount number(4),
    price number(8),
    pcode varchar2(4),
    sdate date,
    
    constraint pk_custno primary key(custno, saleno),
    constraint fk_custno foreign key(custno) references member_tbl_02(custno)
);
desc money_tbl_02;
insert into MONEY_TBL_02 values
(100004, 20160010, 3000, 1, 3000, 'A007', '2016-01-06');
select * from money_tbl_02;

select * from (
select custno from member_tbl_02
order by custno desc)
where rownum = 1;

select member_seq.nextval from dual;
select custno, sum(price) as total from MONEY_TBL_02
group by custno
order by total desc;

select custno, sum(price)
from money_tbl_02 
group by custno 
order by sum(price) desc;




select MONEY_TBL_02.custno, CUSTNAME, grade, sum(price) as total 
from MONEY_TBL_02 INNER JOIN MEMBER_TBL_02 
on MONEY_TBL_02.custno = MEMBER_TBL_02.CUSTNO
group by MONEY_TBL_02.custno, CUSTNAME, grade
order by total desc;

select * from MEMBER_TBL_02;
where CUSTNO=100002;

update member_tbl_02 set CUSTNAME='홍길동', phone='1234', address='강원도', 
joindate='2018-02-01', grade='A', city='77'
where custno=100107;
commit;