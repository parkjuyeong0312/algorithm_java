package bfs;
//문제
//지훈이는 미로에서 일을 한다. 지훈이를 미로에서 탈출하도록 도와주자!
//미로에서의 지훈이의 위치와 불이 붙은 위치를 감안해서 지훈이가 불에 타기전에 탈출할 수 있는지의 여부, 그리고 얼마나 빨리 탈출할 수 있는지를 결정해야한다.
//지훈이와 불은 매 분마다 한칸씩 수평또는 수직으로(비스듬하게 이동하지 않는다) 이동한다.
//불은 각 지점에서 네 방향으로 확산된다.
//지훈이는 미로의 가장자리에 접한 공간에서 탈출할 수 있다.
//지훈이와 불은 벽이 있는 공간은 통과하지 못한다.
//
//입력
//입력의 첫째 줄에는 공백으로 구분된 두 정수 R과 C가 주어진다. 단, 1 ≤ R, C ≤ 1000 이다. R은 미로 행의 개수, C는 열의 개수이다.
//다음 입력으로 R줄동안 각각의 미로 행이 주어진다.
//각각의 문자들은 다음을 뜻한다.
// #: 벽
// .: 지나갈 수 있는 공간
//J: 지훈이의 미로에서의 초기위치 (지나갈 수 있는 공간)
//F: 불이 난 공간
//J는 입력에서 하나만 주어진다.
//
//출력
//지훈이가 불이 도달하기 전에 미로를 탈출 할 수 없는 경우 IMPOSSIBLE 을 출력한다.
//
//지훈이가 미로를 탈출할 수 있는 경우에는 가장 빠른 탈출시간을 출력한다.

//예제 입력
//        4 4
//        ####
//        #JF#
//        #..#
//        #..#
//예제 출력
//        3

//<풀이>
//J의 탈출조건은 nx>=N || ny>=M이다.
//J는 해당 위치가 fire이거나, visited, #이면 방문하지 않는다.
//J는 BFS를 진행하며, queue에 넣을때, count++
//F가 J가 지나간 자리를 밟으면 count--
//J가 0이되면, F에게 따라 잡힌것이 된다.
//초기 queue에는 J,F순으로 넣는다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj4179 {

    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] graph = new char[R][C];
        boolean[][] visited = new boolean[R][C];
        boolean[][] fire = new boolean[R][C];
        int[][] distance = new int[R][C];
        int[][] fireDistance = new int[R][C];

        Deque<int[]> startPoint = new ArrayDeque<>();

        for(int i = 0 ; i<R ; i++){
            char[] line = br.readLine().toCharArray();
            for(int j = 0; j<C; j++){
                graph[i][j]=line[j];
                if(graph[i][j]=='F'||graph[i][j]=='J'){
                    startPoint.offerLast(new int[]{i,j});
                }
            }
        }


        bfs(graph,visited,fire,startPoint,R,C,distance,fireDistance);


    }

    static void bfs(char[][] graph, boolean[][] visited, boolean[][] fire, Deque<int[]> startPoint,int R, int C,int[][] distance,int[][] fireDistance){
        Deque<int[]> queue = new ArrayDeque<>();

        int size =startPoint.size();
        for(int i = 0 ; i<size; i++){
            int[] pos = startPoint.pollFirst();
            int r = pos[0];
            int c = pos[1];

            queue.offerLast(pos);
            if(graph[r][c]=='J'){
                visited[r][c]=true;
            } else if (graph[r][c]=='F') {
                fire[r][c] = true;
            }
        }
        int escapeDistance=0;
        int jCount = 1;
        boolean escape = false;

        while(!queue.isEmpty()){
            int[] pos = queue.pollFirst();
            int r = pos[0];
            int c = pos[1];


            for(int i =0; i<4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(graph[r][c]=='J'){

                    if(nr<0||nr>=R||nc<0||nc>=C){
                        escape=true;
                        escapeDistance=distance[r][c]+1;
                        break;
                    }

                    if(graph[nr][nc]!='.') continue;


                    if(fire[nr][nc]) {
                        continue;
                    }

                    if(visited[nr][nc]) continue;

                    queue.offerLast(new int[]{nr,nc});
                    visited[nr][nc]=true;
                    distance[nr][nc]=distance[r][c]+1;
                    graph[r][c]='.';
                    graph[nr][nc]='J';
                }else if(graph[r][c]=='F'){

                    if(nr<0||nr>=R||nc<0||nc>=C) continue;

                    if (graph[nr][nc] == '#') continue;

                    if(fire[nr][nc]) continue;

                    if(graph[nr][nc]=='J'&&fireDistance[r][c]<distance[nr][nc]) jCount--;

                    queue.offerLast(new int[]{nr,nc});
                    fire[nr][nc]=true;
                    fireDistance[nr][nc]=fireDistance[r][c]+1;
                }
            }
            if(jCount==0) escape = false;

            if(escape) break;
        }
        //따라 잡히기 전에 탈출해야되는건데, 어쨋든 큐를 다 비우고나면, 탈출하기전에 잡혔는지 안잡혔는지 알 수 없다.

        if(escape){
            System.out.println(escapeDistance);
        }else{
            System.out.println("IMPOSSIBLE");
        }
        //문제 : FJ가 있다고하면, 그냥 F가 바로 J의 count를 내려버리면 '불가능'처리가 되어버림.
        //로직이 틀렸음.
        //F도 이동거리(이동시간)을 체크해야될 거 같음.
        //F의 len과 비교하면 되지 않을까..?


    }
}

//4 4
//        ####
//        #JF#
//        #..#
//        #.F#