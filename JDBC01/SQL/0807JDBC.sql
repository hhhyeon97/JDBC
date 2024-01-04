commit


create table test0807(
tno number(38) primary key
,name varchar2(50) not null
,id varchar2(50) not null
,pwd number(30) not null
);

select * from test0807

create sequence tnoseq01
start with 1 -- 1부터 시작
increment by 1 --1씩 증가
nocache; 

insert into test0807 values (tnoseq01.nextval, '김추추','chuchu',111);
insert into test0807 values (tnoseq01.nextval, '강또또','ddoddo',222);

select * from test0807;

commit;

insert into test0807 values (tnoseq01.nextval,'한모모','momo',333);


delete from test0807 where tno=5;