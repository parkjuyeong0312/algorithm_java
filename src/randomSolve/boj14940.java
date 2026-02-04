package randomSolve;
//쉬운 최단거리
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	128 MB	52901	21651	17536	38.625%
//문제
//지도가 주어지면 모든 지점에 대해서 목표지점까지의 거리를 구하여라.
//
//문제를 쉽게 만들기 위해 오직 가로와 세로로만 움직일 수 있다고 하자.
//
//        입력
//지도의 크기 n과 m이 주어진다. n은 세로의 크기, m은 가로의 크기다.(2 ≤ n ≤ 1000, 2 ≤ m ≤ 1000)
//
//다음 n개의 줄에 m개의 숫자가 주어진다. 0은 갈 수 없는 땅이고 1은 갈 수 있는 땅, 2는 목표지점이다. 입력에서 2는 단 한개이다.
//
//        출력
//각 지점에서 목표지점까지의 거리를 출력한다. 원래 갈 수 없는 땅인 위치는 0을 출력하고, 원래 갈 수 있는 땅인 부분 중에서 도달할 수 없는 위치는 -1을 출력한다.
//
//예제 입력 1
//        15 15
//        2 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//        1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//        1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//        1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//        1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//        1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//        1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//        1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//        1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//        1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//        1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
//        1 1 1 1 1 1 1 1 1 1 0 0 0 0 1
//        1 1 1 1 1 1 1 1 1 1 0 1 1 1 1
//        1 1 1 1 1 1 1 1 1 1 0 1 0 0 0
//        1 1 1 1 1 1 1 1 1 1 0 1 1 1 1
//예제 출력 1
//        0 1 2 3 4 5 6 7 8 9 10 11 12 13 14
//        1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
//        2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
//        3 4 5 6 7 8 9 10 11 12 13 14 15 16 17
//        4 5 6 7 8 9 10 11 12 13 14 15 16 17 18
//        5 6 7 8 9 10 11 12 13 14 15 16 17 18 19
//        6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
//        7 8 9 10 11 12 13 14 15 16 17 18 19 20 21
//        8 9 10 11 12 13 14 15 16 17 18 19 20 21 22
//        9 10 11 12 13 14 15 16 17 18 19 20 21 22 23
//        10 11 12 13 14 15 16 17 18 19 20 21 22 23 24
//        11 12 13 14 15 16 17 18 19 20 0 0 0 0 25
//        12 13 14 15 16 17 18 19 20 21 0 29 28 27 26
//        13 14 15 16 17 18 19 20 21 22 0 30 0 0 0
//        14 15 16 17 18 19 20 21 22 23 0 31 32 33 34

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj14940 {
    static int[][] arr;
    static int[][] dist;
    static int N,M;
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new int[N][M];
        arr = new int[N][M];

        int startX=0, startY=0;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int unit = Integer.parseInt(st.nextToken());
                if(unit == 2) {
                    startX = i;
                    startY = j;
                }
                arr[i][j] =unit;
                if(unit == 0){
                    dist[i][j] = 0;
                }else{
                    dist[i][j] = -1;
                }
            }
        }

        bfs(startX, startY);

    }

    static void bfs(int startX, int startY){




        Deque<int[]> dq = new ArrayDeque<>();

        dq.offer(new int[]{startX,startY});
        dist[startX][startY]=0;

        while(!dq.isEmpty()){
            int[] unit = dq.poll();
            int x = unit[0];
            int y = unit[1];

            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx<0||nx>=N||ny<0||ny>=M) continue;

                if(arr[nx][ny]==0) continue;

                if(dist[nx][ny]!=-1) continue;

                dist[nx][ny] = dist[x][y]+1;
                dq.offer(new int[]{nx,ny});
            }
        }
        dist[startX][startY]=0;

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                sb.append(dist[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
