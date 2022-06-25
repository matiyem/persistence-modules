CREATE DEFINER=`root`@`localhost` PROCEDURE `FIND_CAR_BY_YEAR`(in p_year int,out count int)
begin
SELECT ID , MODEL, YEAR
FROM CAR
WHERE YEAR = p_year ;
set count=98;
end