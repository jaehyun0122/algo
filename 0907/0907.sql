#Back-End+DB 02

#1
select count(*) 전체, count(indepyear)
from country;

#2
select round(sum(LifeExpectancy), 2) 합계, round(avg(LifeExpectancy), 2) 평균, round(max(LifeExpectancy), 2) 최대, round(min(LifeExpectancy), 2) 최소
from country;

#3
select continent, count(name) "국가 수", sum(population) "인구 합"
from country
group by continent
order by count(name) desc;

#4
select continent, sum(surfacearea) "표면적 합"
from country
group by continent
order by sum(surfacearea) desc;

#5
select continent, sum(gnp) "gnp 합"
from country
where population >= 50000000
group by continent;

#6
select continent, sum(gnp) "gnp 합"
from country
where population >= 50000000
group by continent
having sum(gnp)>=5000000;

#7
select indepyear, count(*)
from country
group by indepyear
having count(*) >= 10;

#8
select continent, name, gnp, avg(gnp) over() "전세계 평균", avg(gnp) over(partition by(continent)) "대륙 평균"
from country
order by continent;

select * from countrylanguage;
#9
#외래 키 값을 삽입하거나 수정하려 할때 외래 키가 참조하는 주 키에서 사용하는 값 이외의 값이 들어 가면 에러가 난다
insert into countrylanguage value("AAA","외계어","F",10);

#10
# primary key가 unique key로 되어있다. replace into로 해주면 된다.

replace into countrylanguage value("ABW", "Dutch", "F", 10);

#11
#country table의 code가 char(3)으로 되어있어 Tcode의 길이가 더 길기 때문에 에러가 난다. 그리고 제약조건에 code가 primary key이므로 바로 추가가 않되 제약조건 삭제 후 추가함.
#code의 길이를 늘려준다. name의 디폴트 값을 넣어준다.
show columns from country;
alter table countryLanguage drop foreign key countryLanguage_ibfk_1;
alter table city drop foreign key city_ibfk_1;
alter table country modify code char(5);
insert into country(code, region, code2, name) values("TCode", "TREgion", "TC", " ");
select * from country where code = "TCode";

#12
select id, name, population*1.1 population
from city
where id=2331;

#13
# code가 primary key로 되어있어 삭제가 안됨. 제약조건을 삭제해준다.
delete 
from country
where code="USA";


#14
start transaction;
rollback;

#15
create schema ssafy_ws_5th;

#16
drop table user;

#17
create table user(
id varchar(50) not null primary key default(null),
name varchar(100) not null default"익명",
pass varchar(100) not null default(null)
);
show columns from user;

#18
insert into user value("ssafy", "1234", "김싸피");
insert into user value("hong", "5678", "홍싸피");
insert into user value("test", "test", "테스트");
select * from user;

#19
update user 
set pass= concat(id,"@test")
where id = "test";

#20
delete
from user
where id = "test";
select * from user;

#21
commit;
