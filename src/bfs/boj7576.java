package bfs;
//문제
//철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다.
//토마토는 아래의 그림과 같이 격자 모양 상자의 칸에 하나씩 넣어서 창고에 보관한다.
//창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다.
//보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다.
//하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다. 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며,
//토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.
//
//토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때,
//며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.

//입력
//첫 줄에는 상자의 크기를 나타내는 두 정수 M,N이 주어진다.
//M은 상자의 가로 칸의 수
//N은 상자의 세로 칸의 수를 나타낸다.
//단, 2 ≤ M,N ≤ 1,000 이다. 둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다.
//즉, 둘째 줄부터 N개의 줄에는 상자에 담긴 토마토의 정보가 주어진다. 하나의 줄에는 상자 가로줄에 들어있는 토마토의 상태가 M개의 정수로 주어진다.
//정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
//
//토마토가 하나 이상 있는 경우만 입력으로 주어진다.
//
//출력
//여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다. 만약,
//저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.
//
//예제 입력 1
//        6 4
//        0 0 0 0 0 0
//        0 0 0 0 0 0
//        0 0 0 0 0 0
//        0 0 0 0 0 1
//예제 출력 1
//        8
//예제 입력 2
//        6 4
//        0 -1 0 0 0 0
//        -1 0 0 0 0 0
//        0 0 0 0 0 0
//        0 0 0 0 0 1
//예제 출력 2
//        -1


//<문제>
//동시에 익는 경우는 어떻게 처리하지?
    //하나의 점에서 bfs를 실행해버리면,그래프를 모두 탐색해버릴텐데,그러면 다른 시작점에서는 시작도 못함.
        //하지만, 함수라는건 어쨋든 순차적으로 실행된다. 따라서, 어떤 다른 접근법이 필요하다.
//<풀이>
//원래는 토마토가 익기 시작한, 즉 시작포인트에서 상하좌우의 토마토가 익기 시작한 시점부터 1일로 치는데,
//나는 익은 토마토를 queue에 넣는 시점을 1로 치고, 최종적으로 마무리 할때 -1일을 한다.
//이렇게 하는 이유는, 1이 토마토의 위치를 나타내는 고유성을 보장할 수 있기 때문이다.

//1. 원소의 값이 1일때, bfs를 돌린다.
//<문제> : 그럼 visited는 어떻게 처리할거? 이미 첫 bfs돌았을 때, visited=true로 만들어버리잖아.
    //visited를 그때마다 초기화한다면?
    //하지만 ripeDays는 초기화하지 않는다.
//기존의 ripeDays>새로운 ripeDays : ripeDays = 새로운 ripeDays
//이렇게 해서 bfs를 싹다 돌리고, 배열의 처음부터 싹 순회해서, 0이 있으면 -1출력
//max값을 두고, 갱신하면서 어쨋든 다 익었을때의 최대값 출력


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj7576 {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Deque<int[]> startPoints = new ArrayDeque<>();
        int[][] graph = new int[N][M];
        int[][] ripeDays = new int[N][M];

        for(int i = 0 ; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j<M; j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
                if(graph[i][j]==1){
                    startPoints.offerLast(new int[]{i,j});
                }
            }
        }


        while(!startPoints.isEmpty()){
            int[] startPoint = startPoints.pop();
            int x = startPoint[0];
            int y = startPoint[1];

            bfs(graph,ripeDays,x,y,N,M);
        }

//        for(int i = 0; i<N;i++){
//            for(int j = 0; j<M; j++){
//                System.out.print(ripeDays[i][j]+" ");
//            }
//            System.out.println();
//        }



        int max = -1;
        boolean isFail = false;
        for(int i = 0; i<N;i++){
            for(int j = 0; j<M; j++){
                //
                if(graph[i][j]==0&&ripeDays[i][j]==0){
//                    System.out.println("i:"+i+"j:"+j);
                    isFail=true;
                    break;
                }

                if(graph[i][j]!=-1){
                    if(max<ripeDays[i][j]){
                        max=ripeDays[i][j];
                    }
                }
            }
            if(isFail) break;
        }
        if(isFail) System.out.println(-1);
        else System.out.println(max);
    }




    static void bfs(int[][] graph, int[][] ripeDays, int startX, int startY, int N, int M){
        boolean[][]visited = new boolean[N][M];
        Deque<int[]> queue = new ArrayDeque<>();

        queue.offerLast(new int[]{startX,startY});
        visited[startX][startY]=true;
        int day = 0;
        ripeDays[startX][startY]=day;

        while(!queue.isEmpty()){
            int[] unit = queue.pollFirst();
            int x = unit[0];
            int y = unit[1];

            for(int i = 0 ;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
//                System.out.println(day+":"+nx+","+ny);

                if(nx<0||nx>=N||ny<0||ny>=M) continue;

                if(graph[nx][ny]!=0) continue;

                if(visited[nx][ny]) continue;

                if(ripeDays[nx][ny]==0){
                    ripeDays[nx][ny]=ripeDays[x][y]+1;
                    queue.offerLast(new int[]{nx,ny});
                    visited[nx][ny]=true;
                }else if(ripeDays[nx][ny]>=ripeDays[x][y]+1){
                    ripeDays[nx][ny]=ripeDays[x][y]+1;
                    queue.offerLast(new int[]{nx,ny});
                    visited[nx][ny]=true;
                }

            }
        }
    }
}
