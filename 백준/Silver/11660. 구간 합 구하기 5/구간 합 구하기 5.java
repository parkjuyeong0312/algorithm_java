import java.util.*;
import java.lang.*;
import java.io.*;


//최악의 경우를 생각해봤을때 N이 1024일때, N^2으로, M 번하는거니까
//1_000_000*100000이니까 -> 1억 1초 넘김. 1024니까 사실 이거보다 좀 더 크고, ㅇㅇ 
// 그렇다고, 원소 하나씩마다 미리 계산을해서 넣어놓는다고 했을때, 이것도 시간복잡도가 터질 거 같다.
//
// The main method must be in a class named "Main".
class Main {
    static int[][] arr;
    static int[][] dp;
    
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr= new int[N+1][N+1];
        dp= new int[N+1][N+1];
        
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                dp[i][j]=arr[i][j];
                dp[i][j]+=dp[i-1][j];
                dp[i][j]+=dp[i][j-1];
                dp[i][j]-=dp[i-1][j-1];
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());

            int ans = dp[targetX][targetY];

            ans-=dp[startX-1][targetY];

            ans-=dp[targetX][startY-1];
            ans+=dp[startX-1][startY-1];

            sb.append(ans).append("\n");
            
        }

        System.out.println(sb);

        
    }
}