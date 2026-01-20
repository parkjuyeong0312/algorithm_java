package DynamicProgramming;

//문제
//정수 4를 1, 2, 3의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야 한다.
//        1+1+1+1
//        1+1+2
//        1+2+1
//        2+1+1
//        2+2
//        1+3
//        3+1
//정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 11보다 작다.
//
//출력
//각 테스트 케이스마다, n을 1, 2, 3의 합으로 나타내는 방법의 수를 출력한다.

//예제 입력
//        3
//        4
//        7
//        10
//예제 출력
//        7
//        44
//        274


//테이블 정의하기
//D[i]를 1,2,3을 더해서 가기위한 방법
//점화식 찾기
//D[k]=?
//D[k]=D[k-3]
//D[k]=D[k-2]
//D[k]=D[k-1]
//초기값 정하기
//D[1] = 1

//D[i]+=D[k-3]

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj9095 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++){
            int target = Integer.parseInt(br.readLine());

            int[] dp = new int[12];

            dp[1]=1;
            dp[2]=2;
            dp[3]=4;

            for(int j=4; j<=target; j++){
                dp[j]=dp[j-1]+dp[j-2]+dp[j-3];
            }
            sb.append(dp[target]).append("\n");
        }

        System.out.println(sb);

    }
}
