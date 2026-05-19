package randomSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj16236 {
    static int N;
    static int[][] graph;
    static int sharkSize = 2;
    static int sharkEatCount = 0; // 추가: 먹은 개수 체크
    static int[] sharkPos;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int unit = Integer.parseInt(st.nextToken());
                if (unit == 9) {
                    sharkPos = new int[]{i, j};
                    graph[i][j] = 0; // 시작할 때 상어 자리는 미리 0으로!
                } else {
                    graph[i][j] = unit;
                }
            }
        }

        // bfs가 true를 반환하는 동안 계속 반복
        while (bfs());

        System.out.println(sum);
    }

    static boolean bfs() {
        // [수정 1] 우선순위 큐 사용 (거리 순 -> 위쪽 순 -> 왼쪽 순)
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[2] != o2[2]) return o1[2] - o2[2]; // 거리(time) 짧은 순
            if (o1[0] != o2[0]) return o1[0] - o2[0]; // r(행) 작은 순 (위쪽)
            return o1[1] - o2[1]; // c(열) 작은 순 (왼쪽)
        });

        boolean[][] visited = new boolean[N][N];
        pq.offer(new int[]{sharkPos[0], sharkPos[1], 0});
        visited[sharkPos[0]][sharkPos[1]] = true;

        while (!pq.isEmpty()) {
            int[] pos = pq.poll();
            int x = pos[0];
            int y = pos[1];
            int time = pos[2];

            // [수정 2] 먹을 수 있는 물고기를 찾은 경우 (PQ 덕분에 가장 최적의 물고기가 먼저 나옴)
            if (graph[x][y] != 0 && graph[x][y] < sharkSize) {
                graph[x][y] = 0; // 물고기 먹기
                sharkPos[0] = x; // 상어 위치 갱신
                sharkPos[1] = y;
                sum += time;     // 총 시간 누적

                // [수정 3] 상어 레벨업 로직을 여기로 이동
                sharkEatCount++;
                if (sharkEatCount == sharkSize) {
                    sharkSize++;
                    sharkEatCount = 0;
                }
                return true; // 한 마리 먹었으니 다시 처음부터 찾기 위해 true 반환
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (visited[nx][ny] || graph[nx][ny] > sharkSize) continue;

                visited[nx][ny] = true;
                pq.offer(new int[]{nx, ny, time + 1});
            }
        }

        return false; // 더 이상 먹을 물고기가 없음
    }
}