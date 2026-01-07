package bfs;
//문제
//적록색약은 빨간색과 초록색의 차이를 거의 느끼지 못한다.
//따라서, 적록색약인 사람이 보는 그림은 아닌 사람이 보는 그림과는 좀 다를 수 있다.
//크기가 N×N인 그리드의 각 칸에 R(빨강), G(초록), B(파랑) 중 하나를 색칠한 그림이 있다.
//그림은 몇 개의 구역으로 나뉘어져 있는데, 구역은 같은 색으로 이루어져 있다.
//또, 같은 색상이 상하좌우로 인접해 있는 경우에 두 글자는 같은 구역에 속한다.
//(색상의 차이를 거의 느끼지 못하는 경우도 같은 색상이라 한다)
//
//예를 들어, 그림이 아래와 같은 경우에
//
//RRRBB
//GGBBB
//BBBRR
//BBRRR
//RRRRR
//적록색약이 아닌 사람이 봤을 때 구역의 수는 총 4개이다.
//(빨강 2, 파랑 1, 초록 1) 하지만, 적록색약인 사람은 구역을 3개 볼 수 있다.
//(빨강-초록 2, 파랑 1)
//
//그림이 입력으로 주어졌을 때,
//적록색약인 사람이 봤을 때
//아닌 사람이 봤을 때
//구역의 수를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 N이 주어진다. (1 ≤ N ≤ 100)
//둘째 줄부터 N개 줄에는 그림이 주어진다.
//
//출력
//적록색약이 아닌 사람이 봤을 때의 구역의 개수와 적록색약인 사람이 봤을 때의 구역의 수를 공백으로 구분해 출력한다.
//
//예제 입력
//5
//RRRBB
//GGBBB
//BBBRR
//BBRRR
//RRRRR
//예제 출력
//4 3


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

//풀이
//R,G,B가 있다.
//적록색맹은 R과 G를 같은 걸로 취급한다.
//BFS를 두번 돌리면 되는걸까?
//BFS 로직을 다르게 짤까~? 아니면 graph 초기화를 다르게할까?
//grpah초기화를 다르게하자! 로직 따로 짜기는 귀찮 ㅋ
//N의 크기가 100이므로 두번 돌려도 뭐 문제는 없을 것 같다. BFS는 시간복잡도가 N이니까.
public class boj10026 {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        char[][] rgbGraph = new char[N][N];
        boolean[][] rgbVisited = new boolean [N][N];
        char[][] rbGraph = new char[N][N];
        boolean[][] rbVisited = new boolean [N][N];


        for(int i =0 ; i<N; i++){
            char[] line= br.readLine().toCharArray();
            for(int j = 0; j<N; j++){
                char ch = line[j];
                rgbGraph[i][j]=ch;
                if(ch=='G') ch = 'R';
                rbGraph[i][j] = ch;
            }
        }

        int rgbSum=0;
        int rbSum=0;

        for(int i = 0; i<N; i++){
            for(int j =0; j<N; j++){
                if(!rgbVisited[i][j]){
                    bfs(rgbGraph,rgbVisited,i,j,N);
                    rgbSum++;
                }

                if(!rbVisited[i][j]){
                    bfs(rbGraph,rbVisited,i,j,N);
                    rbSum++;
                }
            }
        }

        System.out.print(rgbSum);
        System.out.print(" ");
        System.out.print(rbSum);

    }

    static void bfs(char[][] graph, boolean[][] visited, int startX, int startY, int N){
        Deque<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{startX,startY});
        visited[startX][startY]=true;

        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];

            for(int i=0; i<4; i++){
                int nx= x+dx[i];
                int ny = y+dy[i];

                if(nx<0||nx>=N||ny<0||ny>=N) continue;

                if(visited[nx][ny]) continue;

                if(graph[x][y]!=graph[nx][ny]) continue;

                queue.offer(new int[]{nx,ny});
                visited[nx][ny]=true;
            }
        }
    }
}
