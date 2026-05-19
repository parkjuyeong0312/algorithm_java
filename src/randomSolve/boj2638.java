package randomSolve;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

//시간제한은 1초
//N과 M은 100까지이다.
//N*M=10000최악의경우
//그리고 각 BFS 10000
//100 000 000
//딱 1억뜸.
//시간초과될 확률이 있음아슬아슬하긴한데
//그래서 빈칸마다 bfs돌리는건 에반거같고
//한번 0이뜨면 bfs를 돌리는데,
//1이 뜨면? 그 나름대로 또 돌려야되나? 그 다음에 돌려야됨.

//외부로 나갔다의 경우 0~N+2범위로 그래프를 설정하고, 0,0에서 BFS를 돌려서 방문처리를 하면 된다. ㅇㅈ?

//그렇게되면, 1인 각 요소에 대해 count값이 줄떄까지 반복해서 melt를 진행하면 되는데,
//우선 melt가 됐다는거는 외부에 노출됐다는거니까 , 녹았을때도 외부에 있는 0으로 변경해도 될듯
//1의 카운트를 세고, 다 녹았을때의 시간을 재보자.
//

//고려해야할게 외부공기를 받아야된다는거다.
//bfs를 쓰는데, 외부공기를 받아야된다는 조건은,
//아무래도, 외부로 나갔냐?를 봐야되는거같다.


//그리고 녹은 부분에 대해서도 고려를 해야한다.




//1. 0에대한 bfs 를 돌린다.
//2. 1에 대한 검토를 한다.
//3.
public class boj2638 {
    static int[][] graph;
    static int cheeseCount = 0;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0 ,0,1,-1};
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());

        graph = new int[N+2][M+2];


        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                int unit = Integer.parseInt(st.nextToken());
                graph[i][j] = unit;
                if(unit == 1){
                    cheeseCount++;
                }
            }
        }

        int ans=0;

        while(cheeseCount>0){
            ans++;
            ArrayList<int[]> melt = new ArrayList<>();
            bfs();
            for(int i=1; i<=N; i++){
                for(int j=1; j<=M; j++){
                    if(graph[i][j]!=1) continue;

                    int count = 0;

                    for(int k=0; k<4; k++){
                        int nx = i+dx[k];
                        int ny = j+dy[k];

                        if(nx<1||nx>N||ny<1||ny>M) continue;
                        if(graph[nx][ny]==0&&visited[nx][ny]){
                            count++;
                        }
                    }
                    if(count>=2){
                        melt.add(new int[]{i,j});
                    }
                }
            }
            cheeseCount-=melt.size();

            for(int[] pos : melt){
                int x = pos[0];
                int y = pos[1];

                graph[x][y]=0;
            }

        }

        System.out.println(ans);



    }
    static void bfs(){
        visited=new boolean[N+2][M+2];
        Deque<int[]> dq = new ArrayDeque<>();
        visited[0][0]=true;
        dq.offer(new int[]{0,0});

        while(!dq.isEmpty()){
            int[] pos = dq.poll();

            for(int i=0; i<4; i++){
                int nx = pos[0]+dx[i];
                int ny = pos[1]+dy[i];

                if(nx<0||nx>N+1||ny<0||ny>M+1) continue;
                if(graph[nx][ny]!=0) continue;
                if(visited[nx][ny]) continue;

                visited[nx][ny]=true;
                dq.offer(new int[]{nx,ny});
            }
        }
    }
}
