use sku;
select count(*) from gisa;
select max(kor+eng) maxscore
from gisa
where loc_code = 'B';

select std_no
from gisa
where loc_code = 'B'
order by (kor+eng) desc, std_no asc
limit 4,1;

select sum(total)+sum(case
						when acc_code='A' then 5
                        when acc_code='B' then 15
                        when acc_code='C' then 20
                      end) point
from gisa
where (eng+math)>=120;

select count(*)
from
(select *
	from gisa
	where acc_code='A' or acc_code='B') A
where kor+(case
				when loc_code='A' then 5
                when loc_code='B' then 10
                when loc_code='C' then 15
			end)>=50;





