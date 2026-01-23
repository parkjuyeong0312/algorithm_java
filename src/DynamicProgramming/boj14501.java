package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj14501 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] T = new int[n + 2];
        int[] P = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i] = i일부터 n일까지 얻을 수 있는 최대 이익
        int[] dp = new int[n + 2]; // dp[n+1] = 0 (퇴사날 이후는 0)

        for (int i = n; i >= 1; i--) {
            // 1) i일 상담을 안 하는 경우
            dp[i] = dp[i + 1];

            // 2) i일 상담을 하는 경우 (퇴사 전까지 끝나야 함)
            int end = i + T[i];
            if (end <= n + 1) {
                dp[i] = Math.max(dp[i], P[i] + dp[end]);
            }
        }

        System.out.println(dp[1]);
    }
}
