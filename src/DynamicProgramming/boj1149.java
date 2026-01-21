package DynamicProgramming;
//RGB거리
//
//문제
//RGB거리에는 집이 N개 있다.
//거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.
//집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다. 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때, 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.
//
//1번 집의 색은 2번 집의 색과 같지 않아야 한다.
//N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
//i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
//입력
//첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다. 집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.
//
//출력
//첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.
//
//예제 입력
//        3
//        26 40 83
//        49 60 57
//        13 89 99
//예제 출력
//        96
//예제 입력
//        3
//        1 100 100
//        100 1 100
//        100 100 1
//예제 출력
//        3

//테이블 정의
//모든 집을 칠하는 비용의 최솟값
//i번째 집을 칠하는 최소 비용 D[i]

//점화식 찾기
//1. 비용에 해당하는 것과, 어떤 색을 골랐는지에 대한 정보가 같이 넣는 방법
//2. 테이블을 따로 두는 방법
//D[N][1] : 색
//D[N][2] : 최소비용

//1 10 10
//10 1 10
//99 10 99
//이럴수도 있는거잖아

//1->10->10이 최소
//1단계 : min(R,G,B)
//2단계 : min(R+G,R+B,G+B)
//3단계 : min(R+G+R,R+G+B,R+B+R,R+B+G,G+B+R,G+B+G)

//D[k][0]=min(C[k][0] + G[k-1], C[k][0] + B[k-1])
//D[k][1]=min(C[k][1] + R[k-1], C[k][1] + B[k-1])
//D[k][2]=min(C[k][2] + R[k-1], C[k][2] + G[k-1])

//초기값
//D[1][0] = C[1][0]
//D[1][1] = C[1][1]
//D[1][2] = C[1][2]

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1149 {
    static int[][] RGB;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        RGB = new int[N+1][3];
        dp = new int[N+1][3];

        StringTokenizer st;

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                RGB[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][0] = RGB[1][0];
        dp[1][1] = RGB[1][1];
        dp[1][2] = RGB[1][2];

        for(int i=2; i<=N; i++){
            dp[i][0]=Math.min(RGB[i][0]+dp[i-1][1],RGB[i][0]+dp[i-1][2]); //RED
            dp[i][1]=Math.min(RGB[i][1]+dp[i-1][0],RGB[i][1]+dp[i-1][2]); //GREEN
            dp[i][2]=Math.min(RGB[i][2]+dp[i-1][0],RGB[i][2]+dp[i-1][1]); //BLUE
        }

        int ans = Math.min(Math.min(dp[N][0],dp[N][1]),dp[N][2]);
        System.out.println(ans);
    }
}
