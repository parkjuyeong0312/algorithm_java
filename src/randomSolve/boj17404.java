package randomSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//문제
//RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고, 1번 집부터 N번 집이 순서대로 있다.
//집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다.
//각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때,
//아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.
//
//1번 집의 색은 2번, N번 집의 색과 같지 않아야 한다.
//N번 집의 색은 N-1번, 1번 집의 색과 같지 않아야 한다.
//i(2 ≤ i ≤ N-1)번 집의 색은 i-1, i+1번 집의 색과 같지 않아야 한다.
//입력
//첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다.
//둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다.
//집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.
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
//        110

//테이블 정의 : i번째 색을 골랐을때의 최대 값
//  R,G,B에 따른 dp를 모두 구해야한다.
// 마지막과 첫번째의 색을 고르는 부분은..

//dp[N] = max(dpR[N-1]+G[N], dpR[N-1]+B[N], ... )
//조합이 유지되는가?
//그니까 두번째 최대를 고른다고했을때, 그때의 골랏던 첫번째 값이 , 마지막 색과 중복이 안된다고 했을때도 유지되는가?
//안된다.

//첫번째로 R을 골랐을 때의 최대이면서(현재 R,G,B의 최대), 첫번째로 G를 골랐을때의 최대(현재 R,G,B의 최대), 첫번째로 B를 골랐을때의 최대(현재 R,G,B의 최대)
//i=2부터
//redFirst[i][3]
//greenFirst[i][3]
//blueFirst[i][3]



public class boj17404 {
    static int MAX = 1001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] R = new int[N+1];
        int[] G = new int[N+1];
        int[] B = new int[N+1];
        StringTokenizer st;

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            R[i]= Integer.parseInt(st.nextToken());
            G[i]= Integer.parseInt(st.nextToken());
            B[i]= Integer.parseInt(st.nextToken());
        }

        int[][] redFirst = new int[N][3];
        int[][] greenFirst = new int[N][3];
        int[][] blueFirst = new int[N][3];

        redFirst[1][0]=R[1];
        redFirst[1][1]= MAX;
        redFirst[1][2]= MAX;

        greenFirst[1][0]= MAX;
        greenFirst[1][1]=G[1];
        greenFirst[1][2]= MAX;


        blueFirst[1][0]= MAX;
        blueFirst[1][1]= MAX;
        blueFirst[1][2]=B[1];

        for(int i=2; i<N; i++){
            //redFirst
            //red
            redFirst[i][0] = Math.min(redFirst[i-1][1]+R[i],redFirst[i-1][2]+R[i]);
            redFirst[i][1] = Math.min(redFirst[i-1][0]+G[i],redFirst[i-1][2]+G[i]);
            redFirst[i][2] = Math.min(redFirst[i-1][0]+B[i],redFirst[i-1][1]+B[i]);
            //greenFirst
            greenFirst[i][0] = Math.min(greenFirst[i-1][1]+R[i],greenFirst[i-1][2]+R[i]);
            greenFirst[i][1] = Math.min(greenFirst[i-1][0]+G[i],greenFirst[i-1][2]+G[i]);
            greenFirst[i][2] = Math.min(greenFirst[i-1][0]+B[i],greenFirst[i-1][1]+B[i]);

            //blueFirst
            blueFirst[i][0] = Math.min(blueFirst[i-1][1]+R[i],blueFirst[i-1][2]+R[i]);
            blueFirst[i][1] = Math.min(blueFirst[i-1][0]+G[i],blueFirst[i-1][2]+G[i]);
            blueFirst[i][2] = Math.min(blueFirst[i-1][0]+B[i],blueFirst[i-1][1]+B[i]);
        }

        int redLast = Math.min(Math.min(Math.min(greenFirst[N-1][2]+R[N],blueFirst[N-1][1]+R[N]),greenFirst[N-1][1]+R[N]),blueFirst[N-1][2]+R[N]);
        int greenLast = Math.min(Math.min(Math.min(redFirst[N-1][2]+G[N],blueFirst[N-1][0]+G[N]),redFirst[N-1][0]+G[N]),blueFirst[N-1][2]+G[N]);
        int blueLast = Math.min(Math.min(Math.min(redFirst[N-1][1]+B[N],greenFirst[N-1][0]+B[N]),redFirst[N-1][0]+B[N]),greenFirst[N-1][1]+B[N]);

        int ans = Math.min(Math.min(redLast,greenLast),blueLast);

        System.out.println(ans);
    }
}
