create table jong_starmember(
	sm_id varchar2(10 char) primary key,
	sm_pw varchar2(10 char) not null,
	sm_name varchar2(10 char) not null,
	sm_addr varchar2(50 char) not null,
	sm_img varchar2(200 char) not null
);

select*from jong_starmember
delete from jong_starmember

create table jong_startxt(
	st_no number(5) primary key,
	st_id varchar2(10 char) not null,
	st_txt varchar2(300 char) not null,
	st_img varchar2(200 char) not null,
	st_photo varchar2(200 char) not null,
	st_date Date not null,
	st_host varchar2(30 char) not null
);
select*from jong_startxt
delete from jong_startxt
drop table jong_startxt cascade constraint purge
create sequence jong_startxt_seq

select*from jong_startxt,jong_starmember order by st_date desc

-- 100만개 전체 불러오기가???

-- OracleDB스러운 해결
-- 2page: 11~20번까지 나와야 한다치면
-- DB에서 11~20번까지 조회하면 될일 
-- seq가 순서대로가 아님

-- DBA DB 관리자
-- rownum(가상 필드)
-- order by보다 먼저
select*from jong_startxt,jong_starmember where sm_id=st_id

select*
from(
	select rownum as rn,st_no,st_txt,st_date 
	from (
		select*
		from JONG_STARTXT
		order by st_txt
	)
)
where rn >=5 and rn<=10;

select*from(select rownum as rn,st_no,st_id,st_img,st_photo,st_txt,st_date from (select*from JONG_STARTXT,jong_starmember where sm_id=st_id order by st_txt)) where rn >=5 and rn<=10

select rownum as r,st_no,st_txt,st_date 
from (
	select*
	from JONG_STARTXT
	order by st_txt
)


create table jong_starcomment(
	sc_no number(7) primary key,
	sc_st_no number(5) not null,
	sc_id varchar2(10 char) not null,
	sc_txt varchar2(200 char) not null,
	sc_img varchar2(200 char) not null,
	sc_host varchar2(30 char) not null,
	sc_date date,
	constraint sns_comment foreign key(sc_st_no) references jong_startxt(st_no) on delete cascade
	
);
select*from jong_starcomment where sc_no=362
delete from jong_starcomment
create sequence jong_starcomment_seq
alter table jong_starcomment add constraint sns_comment foreign key(sc_st_no) references jong_startxt(st_no) on delete cascade
		insert into jong_starcomment values(jong_starcomment_seq.nextval,217,'s','s','s','s',sysdate)
drop table jong_starcomment cascade constraint purge
constraint 조건 이름 foreign key(필드명) references 테이블명(필드명) on delete cascade --삭제되게

select*from jong_starcomment

create table jong_starfile(
	sf_no number(5) primary key,
	sf_id varchar2(10 char) not null,
	sf_img varchar2(200 char) not null,
	sf_title varchar2(30 char) not null,
	sf_file varchar2(200 char) not null,
	sf_color varchar2(16 char) not null,
	sf_date date not null
);
delete from jong_starfile

create sequence jong_starfile_seq
select*from jong_starfile
select*from jong_starfile order by sf_date desc


create table jong_starmessage(
	sme_no number(7) primary key,
	sme_sm_id varchar2(10 char) not null,
	sme_txt varchar2(200 char) not null,
	sme_img varchar2(200 char) not null,
	sme_id varchar2(10 char) not null,
	sme_name varchar2(10 char) not null,
	sme_date date not null
);
select*from jong_starmessage
alter table jong_starmessage add constraint member_message foreign key(sme_sm_id) references jong_starmember(sm_id) on delete cascade
create sequence jong_starmessage_seq
delete from jong_starmessage

create table jong_starfollow(
	jsf_followingid varchar2(10 char) not null,
	jsf_followerid varchar2(10 char) not null,
	jsf_date date not null
)

insert into jong_starfollow values('koko2921','qqqq',sysdate);
insert into jong_starfollow values('koko2921','aaaa',sysdate);
insert into jong_starfollow values('aaaa','koko2921',sysdate);
insert into jong_starfollow values('qqqq','koko2921',sysdate);
delete from jong_starfollow

create table jong_starhart(
	sh_st_no number(5) not null,
	sh_id varchar2(10 char) not null,
	sh_date date not null
)
insert into jong_starhart values(381,'qqqq',sysdate);
insert into jong_starhart values(381,'koko2921',sysdate);

