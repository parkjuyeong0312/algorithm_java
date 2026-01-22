package DynamicProgramming;
//문제
//수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다. 둘째 줄에는 N개의 수가 주어진다. 수는 1,000보다 작거나 같은 자연수이다. 셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.
//
//출력
//총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.
//
//        제한
//1 ≤ N ≤ 100,000
//        1 ≤ M ≤ 100,000
//        1 ≤ i ≤ j ≤ N
//예제 입력
//        5 3
//        5 4 3 2 1
//        1 3
//        2 4
//        5 5
//예제 출력
//        12
//        9
//        1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//테이블정의
//i번째 행까지의 합 D[i]
//점화식
//D[k]=D[k-1]+nums[k]
//초기값
//D[1]=nums[1]
public class boj11659 {
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        nums = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            nums[i]=Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[100001];
        dp[0]=0;
        dp[1]=nums[1];

        for(int i =2; i<=N; i++){
            dp[i]=dp[i-1]+nums[i];
        }
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int start= Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(dp[end]-dp[start-1]).append("\n");
        }

        System.out.println(sb);
    }
}
