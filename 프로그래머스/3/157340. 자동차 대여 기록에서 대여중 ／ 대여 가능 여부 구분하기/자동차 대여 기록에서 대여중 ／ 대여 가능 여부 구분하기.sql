-- 코드를 입력하세요
# 1. 차 ID별로 그룹을 짓는다.
# 2. 차가 쭉 있지만, 2022년 10월 16일 기준, 대여가능한지 여부를 보아야한다.
# 그니까 ,max로 해서 한번이라도 1이 뜨면, 대여가능인것임.
SELECT 
    CAR_ID,
    IF(MAX(IF(START_DATE<='2022-10-16'AND END_DATE>='2022-10-16',1,0))=1,'대여중','대여 가능') AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
ORDER BY CAR_ID DESC;