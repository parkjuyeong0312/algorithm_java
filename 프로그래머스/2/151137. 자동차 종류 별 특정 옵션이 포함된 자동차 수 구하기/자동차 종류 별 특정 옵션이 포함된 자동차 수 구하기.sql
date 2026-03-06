-- 코드를 입력하세요

# '통풍시트', '열선시트', '가죽시트' 중 하나 이상의 옵션이 포함된 자동차가





#이때 자동차 수에 대한 컬럼명은 CARS로 지정하고,
SELECT CAR_TYPE, COUNT(*) AS CARS
# CAR_RENTAL_COMPANY_CAR 테이블에서
FROM CAR_RENTAL_COMPANY_CAR
WHERE OPTIONS LIKE '%통풍시트%'OR OPTIONS LIKE '%열선시트%'OR OPTIONS LIKE '%가죽시트%'
#자동차 종류 별로 몇 대인지 출력
GROUP BY CAR_TYPE
#결과는 자동차 종류를 기준으로 오름차순 정렬해주세요.
ORDER BY CAR_TYPE ASC;