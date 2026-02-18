import java.util.*;
import java.lang.*;
import java.io.*;

//bfs + dp 문제인거같다
//이전 경로값을 이어서 받아와서, 갱신할 수 있는가? 
//점화식 정의
//D[i][j] = i,j에서 갈수 있는 최대 길이 값
//D[i][j] = visited라면, 해당 값+1, visited가 아니라면, 해당 경로로 bfs 돌린 값을
//최대 경로로 해서 값에 저장.

//for문, if(!visited[i][j])func(i,j)
//func(i,j){
//   visited[i][j]=true
// 큐선언, 넣기
// while(!queue.isEmpty){
// 상하좌우 pos
// max값 = 0
// for(pos):
//if(pos visited) max = Math.max(max, dp[nx][ny])
//if(pos !visited) max = Math.max(max, func(nx,ny))
//}

//return max
//}

// The main method must be in a class named "Main".
class Main {
    static int N;
    static int[][] arr;
    static int[][] dp;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int ans=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new int[N][N];
        visited = new boolean[N][N];
        
        StringTokenizer st;

        
        for(int i=0; i<N; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    func(i,j);
                }
            }
        }

        // for(int i=0; i<N; i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // }

        System.out.println(ans);
        
    }

    static int func(int x, int y){
        Deque<int[]> queue = new ArrayDeque<>();
        visited[x][y]=true;
        queue.offer(new int[]{x,y});

        int max = 1;

        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            for(int i =0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx<0||nx>=N||ny<0||ny>=N) continue;
                if(arr[nx][ny]<=arr[x][y]) continue;

                if(visited[nx][ny]){
                    max=Math.max(max,dp[nx][ny]+1);
                }else{
                    max=Math.max(max,func(nx,ny)+1);
                }
            }
        }
        ans = Math.max(ans,max);
        dp[x][y]=max;
        return max;
    }
}
//문제 : 방문처리를 해버리면, 

//for문, if(!visited[i][j])func(i,j)
//func(i,j){
//   visited[i][j]=true
// 큐선언, 넣기
// while(!queue.isEmpty){
// 상하좌우 pos
// max값 = 0
// for(pos):
//if(pos visited) max = Math.max(max, dp[nx][ny])
//if(pos !visited) max = Math.max(max, func(nx,ny))
//}

//return max
//}
























