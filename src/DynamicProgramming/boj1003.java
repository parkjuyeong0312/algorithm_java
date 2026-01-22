package DynamicProgramming;

//입력
//첫째 줄에 테스트 케이스의 개수 T가 주어진다.
//각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. N은 40보다 작거나 같은 자연수 또는 0이다.
//
//출력
//각 테스트 케이스마다 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력한다.
//
//예제 입력
//        3
//        0
//        1
//        3
//예제 출력
//        1 0
//        0 1
//        1 2


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1003 {
    static int zeroCount;
    static int oneCount;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        int[][] dp = new int[41][2];

        dp[0][0]=1;
        dp[0][1]=0;
        dp[1][0]=0;
        dp[1][1]=1;


        for(int i=2; i<=40; i++){
            dp[i][0]=dp[i-1][0]+dp[i-2][0];
            dp[i][1]=dp[i-1][1]+dp[i-2][1];
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<testCase; i++){
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n][0]).append(" ").append(dp[n][1]).append("\n");
        }
        System.out.println(sb);
    }
}
