
--헬스장 회원 등록 table 생성
create table test0810(
    tno number(38) primary key --회원 등록 번호
    ,tname varchar2(50) not null --회원명
    ,tpwd number(38) -- 헬스장 개인서랍 비번
    ,tdate date -- 회원 등록 날짜
);
--시퀀스 생성
create sequence tseq
start with 1
increment by 1
nocache;

--레코드 추가
insert into test0810 values(tseq.nextval,'이혜인',1111,sysdate);
insert into test0810 values(tseq.nextval,'박정아',2222,sysdate);

select * from test0810 order by tno;

commit;

