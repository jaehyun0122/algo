use world;
#1. 도시명이 kabul이 속한 국가 이름
select * from city;
select coun.code, coun.name
from country coun join city ci on coun.capital = ci.id
where ci.name = "kabul";

#2. 국가의 공식 언어 사용율이 100%인 국가의 정보 / 국가 이름asc
select name, language, percentage
from country c join countrylanguage lang on c.code = lang.countrycode
where lang.percentage = 100
order by c.name;

#3. 도시명이 amsterdam에서 사용되는 주요 언어와 속한국가

select city.name, countrylanguage.language, country.name
from country join countrylanguage on country.code = countrylanguage.countrycode join city on city.countrycode = countrylanguage.countrycode
where city.name = "amsterdam"
order by countrylanguage.percentage desc
limit 1;

#4. 국가명이 united로 시작하는 국가의 정보와 수도의 이름, 인구를 함께 출력, 수도 정보가 없다면 출력하지 않는다
select country.name, country.capital, city.name 수도, city.population 수도인구
from country join city on country.code = city.countrycode
where country.capital = city.id and country.name like "united%";

#5. 
select co.name, co.capital, 
          (case when ci.name is null then "수도없음" 
                  else ci.name end) as 수도, 
          (case when ci.population is null then "수도없음" 
          else ci.population end) as 수도인구
from country co left join city ci on ci.id = co.capital
where co.name like "united%";

#6.
select count(*) 국가수
from countrylanguage
where percentage > (select percentage
from countrylanguage
where countrycode = "che" and isofficial = "T"
order by percentage desc
limit 1) and isofficial = "T";

#7.
select language
from countrylanguage
where countrycode = "KOR" and isofficial = "T";

#8.
select country.name, country.code, count(*) 도시개수
from country, city
where country.name like "bo%" and country.code = city.countrycode
group by country.name;

#9.
select country.name, case when count(city.id) = 0 then "단독" else count(city.id) end  as 도시개수
from country left join city on country.code = city.countrycode
where country.name like "bo%"
group by country.name;

#10.
select * from city;
select countrycode, name, population
from city
order by population desc
limit 1;

#11.
select country.name, countrycode, city.name, city.population
from city, country
where country.code = (
select countrycode
from city
order by population
limit 1)
order by population
limit 1;

#12.
select countrycode, name, population
from city
where population > (
select population
from city
where name = "seoul");

#13.
select countrycode, language
from countrylanguage
where countrycode in (
select countrycode
from city
where name = "San Miguel") and isofficial = "T"
group by countrycode;


#14.
select countrycode, population max_pop
from city
group by countrycode
order by countrycode;

#15.
select countrycode, name, population
from city
group by countrycode;

#16.
select country.code, country.name, city.name, city.population
from country left join city on country.code = city.countrycode
group by country.code;


#17.
create view summary as(select country.code, country.name as co_name, city.name as ci_name, city.population
from country, city
where country.code = city.countrycode);

#18.
select code, co_name, ci_name, max(population)
from summary
where code = "KOR";
