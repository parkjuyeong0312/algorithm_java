package backTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj9663 {
    static int N;
    static int count = 0;

    static boolean[] usedCol;   // 열 점유 여부
    static boolean[] usedDiag1; // (row + col) 대각선 ↗
    static boolean[] usedDiag2; // (row - col + N - 1) 대각선 ↘

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        usedCol = new boolean[N];
        usedDiag1 = new boolean[2 * N - 1];
        usedDiag2 = new boolean[2 * N - 1];

        dfs(0); // 0번째 행부터 배치 시작
        System.out.println(count);
    }

    static void dfs(int row) {
        if (row == N) { // N개 행에 모두 배치 완료
            count++;
            return;
        }

        for (int col = 0; col < N; col++) {
            int d1 = row + col;            // ↗ 대각선 인덱스
            int d2 = row - col + (N - 1);  // ↘ 대각선 인덱스

            if (usedCol[col] || usedDiag1[d1] || usedDiag2[d2]) continue;

            usedCol[col] = true;
            usedDiag1[d1] = true;
            usedDiag2[d2] = true;

            dfs(row + 1);

            // 백트래킹(원상복구)
            usedCol[col] = false;
            usedDiag1[d1] = false;
            usedDiag2[d2] = false;
        }
    }
}
