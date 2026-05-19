package solveByTopic.bitMask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 소프티어복기_3번문제 {
    public static void main(String[] args) {
        int[][] problems = {
                {1, 1, 0, 0, 1},
                {1, 0, 0, 1, 0},
                {0, 0, 1, 1, 0},
                {0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1}
        };

        int problemCount = problems.length;
        int topicCount = problems[0].length;

        //1. target은 모든 값이 채워진 값
        int target = (1 << topicCount) -1;

        //2. 각 문제를 비트마스크로 변환하기
        int[] masks = new int[problemCount];
        for(int i=0; i<problemCount; i++){
            for(int j=0; j<topicCount; j++){
                //해당 요소가 1이면
                if(problems[i][j]==1){
                    //그 요소만 더하기
                    masks[i]|=1<<j;
                }
            }
        }

        //1. dp 선언하기
        //dp[state] = state 까지의 최소 경로 횟수
        int[] dp = new int[1<<topicCount]; //00000~11111까지
        int[] parentState = new int[1<<topicCount]; //역추적용
        int[] chosenProblem = new int[1<<topicCount]; //어떤 문제 골랐는지 체크용
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;

        for(int state=0; state<=target; state++){
            //제약조건1 : 방문하지 않은 state는 넘어간다.
            if(dp[state]==Integer.MAX_VALUE) continue;

            for(int i=0; i<problemCount; i++){
                int newState = state | masks[i];
                //기존 값(state)과 마스크를 OR 연산했을때 결과가(newState) 변화가 없다면 넘어가자.
                if(newState == state) continue;

                //변화가 있다면~?
                //기존의 경로보다 더 짧은가?
                if(dp[newState]>dp[state]+1) {
                    //짧다면, 경로를 업데이트한다.
                    dp[newState] = dp[state] + 1;
                    parentState[newState]=state;
                    chosenProblem[newState]=i;
                }
            }
        }

        System.out.println("최소문제수 : " + dp[target]);

        //결과 역추적하기
        ArrayList<Integer> list = new ArrayList<>();

        int cur = target;
        while(cur!=0){
            list.add(chosenProblem[cur]+1);
            cur=parentState[cur];
        }
//        Collections.reverse(list);

        System.out.println(list);

    }
}
