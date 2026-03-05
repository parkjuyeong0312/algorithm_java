-- 코드를 작성해주세요

# 2. WITH RECURSIVE의 표준 3단계 구성
# 이 세트는 항상 아래와 같은 3층 구조로 이루어져 있습니다.

# 앵커(Anchor) 멤버: 반복의 시작점 (예: 1세대 대장균 찾기)
# UNION ALL: 위아래 쿼리를 합쳐주는 접착제
# 재귀(Recursive) 멤버: 부모를 타고 자식을 찾는 반복문 (자기 자신을 JOIN함)

WITH RECURSIVE GenerationCTE AS(
    SELECT ID,1 AS GENERATION
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL
    
    UNION ALL
    # 이 아래부분을 함수가 돌려줌.
    SELECT E.ID, G.GENERATION+1
    FROM ECOLI_DATA E
    JOIN GenerationCTE G ON E.PARENT_ID = G.ID
)


SELECT COUNT(*) AS COUNT, GENERATION
FROM GenerationCTE
WHERE ID NOT IN (
    SELECT DISTINCT PARENT_ID
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NOT NULL
)
GROUP BY GENERATION #Generation별로 행을 묶어놓겠다. 그러면 GENERATION 행에 맞춰서 count가 됨. 매인 col이되는거지
ORDER BY GENERATION ASC;









# WITH RECURSIVE GenerationCTE AS (
#     -- 1단계: 1세대(부모가 NULL) 찾기
#     SELECT ID, 1 AS GENERATION
#     FROM ECOLI_DATA
#     WHERE PARENT_ID IS NULL
    
#     UNION ALL
    
#     -- 2단계: 부모와 자식을 연결하며 세대 번호 늘리기
#     SELECT E.ID, G.GENERATION + 1
#     FROM ECOLI_DATA E
#     JOIN GenerationCTE G ON E.PARENT_ID = G.ID
# )

# SELECT 
#     COUNT(*) AS COUNT, 
#     GENERATION
# FROM GenerationCTE
# WHERE ID NOT IN (
#     -- 자식이 있는 ID들(누군가의 PARENT_ID인 ID들)을 제외
#     SELECT DISTINCT PARENT_ID 
#     FROM ECOLI_DATA 
#     WHERE PARENT_ID IS NOT NULL
# )
# GROUP BY GENERATION
# ORDER BY GENERATION ASC;