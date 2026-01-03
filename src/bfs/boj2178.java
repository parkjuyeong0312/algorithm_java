package bfs;
//문제
//N×M크기의 배열로 표현되는 미로가 있다.
//
//미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다. 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
//
//위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
//
//입력
//첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.
//
//        출력
//첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.

//예제 입력 1
//        4 6
//        101111
//        101010
//        101011
//        111011
//예제 출력 1
//        15

//풀이
//<문제> 어떻게 도착 길이를 count하지?
    //재귀형식으로 return 해야하나?
//왜 BFS를 사용한걸까? 배우진 않았지만, DFS, BFS 용도차이는 뭐지?
    //BFS는 최단경로를 보장한다.

//<풀이>
//그냥 [][]len이라는 배열을 놓고, 거리 값을 넣어서 풀어보자.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj2178 {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][]graph = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        int[][]len = new int[N][M];

        //그래프 초기화
        for(int i =0;i<N;i++){
            String[] line = br.readLine().split("");
            for(int j = 0 ; j<line.length; j++){
                graph[i][j]=Integer.parseInt(line[j]);
            }
        }
        System.out.println(bfs(graph,visited,len,N,M));
    }

    static int bfs(int[][]graph, boolean[][]visited, int[][] len, int N, int M){

        Deque<int[]> queue = new ArrayDeque<>();

        queue.offerLast(new int[]{0,0});
        visited[0][0]=true;
        len[0][0]++;

        while(!queue.isEmpty()){
            int[] unit = queue.pop();

            int x = unit[0];
            int y = unit[1];

            if(x==N-1 && y==M-1) break;

            for(int i = 0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx<0||nx>=N||ny<0||ny>=M) continue;

                if(graph[nx][ny]==0) continue;

                if(visited[nx][ny]) continue;

                queue.offerLast(new int[]{nx,ny});
                visited[nx][ny]=true;
                len[nx][ny]=len[x][y]+1;
            }

        }

        return len[N-1][M-1];
    }
}
