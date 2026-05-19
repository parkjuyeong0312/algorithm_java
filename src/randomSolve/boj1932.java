package randomSolve;

//위 그림은 크기가 5인 정수 삼각형의 한 모습이다.
//
//맨 위층 7부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때, 이제까지 선택된 수의 합이 최대가 되는 경로를 구하는 프로그램을 작성하라. 아래층에 있는 수는 현재 층에서 선택된 수의 대각선 왼쪽 또는 대각선 오른쪽에 있는 것 중에서만 선택할 수 있다.
//
//삼각형의 크기는 1 이상 500 이하이다. 삼각형을 이루고 있는 각 수는 모두 정수이며, 범위는 0 이상 9999 이하이다.
//
//        입력
//첫째 줄에 삼각형의 크기 n(1 ≤ n ≤ 500)이 주어지고, 둘째 줄부터 n+1번째 줄까지 정수 삼각형이 주어진다.
//
//        출력
//첫째 줄에 합이 최대가 되는 경로에 있는 수의 합을 출력한다.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1932 {
    static int[][] graph;
    static int[][] dp;
    static int ans = Integer.MIN_VALUE;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        dp = new int[N][N];
        StringTokenizer st;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<=i; j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0]=graph[0][0];

        for(int i=1; i<N; i++){
            dp[i][0]=dp[i-1][0]+graph[i][0];
            dp[i][i]=dp[i-1][i-1]+graph[i][i];
            for(int j=1; j<=i-1; j++){
                dp[i][j]=Math.max(dp[i-1][j-1]+graph[i][j],dp[i-1][j]+graph[i][j]);
            }
        }

        for(int i=0; i<N; i++){
//            System.out.println(Arrays.toString(dp[i]));
            ans=Math.max(dp[N-1][i],ans);
        }

//        func(0,0, 0 );
//
        System.out.println(ans);

    }
    //시간초과
//    static void func(int index, int sum, int dept){
//        if(dept == N){
//            ans = Math.max(ans, sum);
//            return;
//        }
//        func(index,sum+graph[dept][index],dept+1);//5가 나온다
//        func(index+1,sum+graph[dept][index],dept+1);
//    }
}
