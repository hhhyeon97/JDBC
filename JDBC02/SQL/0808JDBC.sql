
create table test0808(
tno number(38) primary key
,tid varchar2(50) not null
,tpwd varchar2(50) not null
,temail varchar2(50) not null
);

create sequence seq01
start with 1
increment by 1
nocache;


insert into test0808 values(seq01.nextval,'chuchu','chu111','chu@naver.com');
insert into test0808 values(seq01.nextval,'susu','su111','su@naver.com');

select * from test0808;

/* 항상 커밋 잊지 말자 ! */
commit;

alter table test0808 rename to test0809;

select * from test0809;

commit;



