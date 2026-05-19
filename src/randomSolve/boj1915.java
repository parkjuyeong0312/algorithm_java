package randomSolve;

//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	128 MB	52293	16539	12072	30.726%
//문제
//n×m의 0, 1로 된 배열이 있다. 이 배열에서 1로 된 가장 큰 정사각형의 크기를 구하는 프로그램을 작성하시오.
//
//0	1	0	0
//        0	1	1	1
//        1	1	1	0
//        0	0	1	0
//위와 같은 예제에서는 가운데의 2×2 배열이 가장 큰 정사각형이다.
//
//입력
//첫째 줄에 n, m(1 ≤ n, m ≤ 1,000)이 주어진다. 다음 n개의 줄에는 m개의 숫자로 배열이 주어진다.
//
//        출력
//첫째 줄에 가장 큰 정사각형의 넓이를 출력한다.
//
//예제 입력 1
//        4 4
//        0100
//        0111
//        1110
//        0010
//예제 출력 1
//        4

//(i-1,j), (i,j-1), (i-1,j-1)을 검사한다.
//만약 값이 모두 같다면, 해당 값 +1을 dp에 넣고,
//만약 값이 모두 같지 않다면 max값을 그대로 옮긴다


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1915 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int max = Integer.MIN_VALUE;

        int[][] arr = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                arr[i][j] = line.charAt(j - 1) - '0';
            }
        }
        //i,j에서 그릴 수 있는 정사각형의 최대 넓이
        int[][] dp = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                //arr 값이 0이면 넘어가자.
                if (arr[i][j] == 0) continue;
                //좌,상,대각의 arr 값이 0인 값이 있으면,dp[i][j]=1이다.
                if (arr[i - 1][j] == 0 || arr[i][j - 1] == 0 || arr[i - 1][j - 1] == 0) {
                    dp[i][j] = 1;
                    max = Math.max(dp[i][j],max);
                    continue;
                }
                //dp 값이 좌,상의 최솟값 dp +1값이 현재 dp값이다.
                dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),dp[i-1][j-1]) + 1;
                max = Math.max(dp[i][j],max);
            }
        }
//        for(int i=1; i<=N; i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }

        System.out.println(max*max);
    }

}






















