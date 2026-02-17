import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N,M;
    static int[][] arr;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];

        for(int i=1; i<=N; i++){
            String line = br.readLine();
            for(int j=1; j<=M; j++){
                arr[i][j] = line.charAt(j-1)-'0';
            }
        }

        //1,1에서 출발해서, N,M까지 도착
        int ans = bfs();
        System.out.println(ans);

    }
    static int bfs(){
        //경우의 수
        //1. 벽을 부순다.
        //2. 벽을 부수지 않는다.

        //벽을 부순다의 경우 crush라는 변수를 넣는다.
        //crush라는 변수가 들어가면, 다음에는 벽을 부술 수 없다.
        //crush를 했을때와, 안했을때의 가능성은 다르다.
        //crush를 했을때와, 안했을때 모두 큐에 넣어봐야한다.
        //그니까 visited 값을 2개를 두어서 풀었던 것인데,
        //crush를 한 이후에는, visited1을 갱신하며, visited0를 확인만 한다.
        //crush를 하지 않은 상태에서는 visited0을 갱신하며, visited0을 확인한다.

        //len의 경우 crush를 한 이후에는 len1을 갱신한다.

        
        boolean[][][] visited = new boolean[N+1][M+1][2];
        int[][][] len = new int[N+1][M+1][2];

        Deque<int[]> queue = new ArrayDeque<>();
        
        visited[1][1][0]=true;
        
        len[1][1][0]=1;
        
        len[N][M][0]=Integer.MAX_VALUE;
        len[N][M][1]=Integer.MAX_VALUE;
        
        queue.offer(new int[]{1,1,0,1});

        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];
            int crush = pos[2];
            int dist = pos[3];

            if(x==N&&y==M){
                return dist;
            }

            for(int i=0; i<4; i++){
                int nx=x+dx[i];
                int ny=y+dy[i];

                if(nx<1||nx>N||ny<1||ny>M) continue;
                

                if(arr[nx][ny]==0){
                    if(!visited[nx][ny][crush]){
                        visited[nx][ny][crush]=true;
                        queue.offer(new int[]{nx,ny,crush,dist+1});
                    }
                }else{
                    if(crush==0&&!visited[nx][ny][1]){
                        visited[nx][ny][1]=true;
                        queue.offer(new int[]{nx,ny,1,dist+1});
                    }
                }

            }
        }
        return -1;
    }
}


//큐가 겹쳐버리니까, 이게 최단거리를 보장할 수 잇나?
//이런느낌이 아니고, 벽을 뚫는다고 했을때, len으로 최단거리를 비교할 수는 없나?
//len이 더 짧다면, 벽을 뚫고 올 필요가 없는거잖아. 일단 visited이긴 한데, len이 더 짧다면, 통과?
//





























