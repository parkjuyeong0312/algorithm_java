import java.util.*;
import java.io.*;

class Main {
    static int N = 9;
    static int[][] graph = new int[N][N];
    static HashSet<Integer>[] row = new HashSet[N];
    static HashSet<Integer>[] col = new HashSet[N];
    static HashSet<Integer>[] rect = new HashSet[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < N; i++) {
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            rect[i] = new HashSet<>();
        }

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                int unit = str.charAt(j) - '0';
                graph[i][j] = unit;
                if (unit != 0) {
                    row[i].add(unit);
                    col[j].add(unit);
                    rect[(i / 3) * 3 + (j / 3)].add(unit);
                }
            }
        }

        solve(0, 0);
    }

    public static boolean solve(int r, int c) {
        // 끝까지 다 채웠으면 출력하고 종료
        if (r == N) {
            printGraph();
            return true; 
        }

        // 다음 칸 좌표 계산
        int nextR = (c == 8) ? r + 1 : r;
        int nextC = (c == 8) ? 0 : c + 1;

        // 이미 숫자가 채워져 있다면 패스
        if (graph[r][c] != 0) {
            return solve(nextR, nextC);
        }

        // 빈칸이라면 1~9까지 시도
        for (int k = 1; k <= 9; k++) {
            int rectIdx = (r / 3) * 3 + (c / 3);
            if (!row[r].contains(k) && !col[c].contains(k) && !rect[rectIdx].contains(k)) {
                // 숫자 넣기 (상태 변화)
                graph[r][c] = k;
                row[r].add(k);
                col[c].add(k);
                rect[rectIdx].add(k);

                // 다음 칸으로 진행
                if (solve(nextR, nextC)) return true;

                // 실패했다면 다시 빼기 (Backtrack: 상태 복구)
                graph[r][c] = 0;
                row[r].remove(k);
                col[c].remove(k);
                rect[rectIdx].remove(k);
            }
        }
        return false; // 넣을 수 있는 숫자가 없음
    }

    public static void printGraph() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(graph[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}