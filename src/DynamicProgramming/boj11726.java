package DynamicProgramming;
//문제
//2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
//아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.

//입력
//첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)
//
//출력
//첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
//
//예제 입력
//        2
//예제 출력
//        2

//예제 입력
//        9
//예제 출력
//        55

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//테이블 정의
//D[i]=i번째 길이 까지 넣을 수 있는 방법의 수
//점화식
//D[k]=D[k-2]+2
public class boj11726 {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp=new int[1001];

        dp[0]=1;
        dp[1]=1;

        //dp[i]로 올수 있는 경우의수 = 1칸 오던가, 2칸오던가
        for(int i=2; i<=N; i++){
            dp[i]=(dp[i-2]+dp[i-1])%10007;
        }

        System.out.println(dp[N]%10007);
    }
}
