import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] matrix = new int[N + 1][2];
        long[][] dp = new long[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken()); // row
            matrix[i][1] = Integer.parseInt(st.nextToken()); // col
        }

        // len: 곱할 행렬의 범위 (2개부터 N개까지)
        for (int len = 1; len < N; len++) {
            // i: 시작 행렬 번호
            for (int i = 1; i + len <= N; i++) {
                int j = i + len; // j: 끝 행렬 번호
                dp[i][j] = Long.MAX_VALUE;

                // k: 분할 지점 (i <= k < j)
                for (int k = i; k < j; k++) {
                    // (i~k 최소비용) + (k+1~j 최소비용) + (두 덩어리를 곱하는 비용)
                    long cost = dp[i][k] + dp[k + 1][j] + 
                                (long) matrix[i][0] * matrix[k][1] * matrix[j][1];
                    
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        System.out.println(dp[1][N]);
    }
}