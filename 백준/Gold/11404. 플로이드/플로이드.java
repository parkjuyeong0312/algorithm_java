import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N,M;
    static int[][] graph;
    static int INF = 10_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            Arrays.fill(graph[i],INF);
            graph[i][i]=0;
        }
        StringTokenizer st;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u][v]=Math.min(graph[u][v],w);
        }

        floyd();
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N;i++){
            for(int j=1; j<=N; j++){
                int unit = graph[i][j];
                if(unit == INF){
                    sb.append(0).append(" ");
                }else{
                    sb.append(unit).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void floyd(){
        //floyd를 해보자!
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                for(int k=1; k<=N; k++){
                    if(graph[j][k]>graph[j][i]+graph[i][k]){
                        graph[j][k]=graph[j][i]+graph[i][k];
                    }
                }
            }
        }
    }
}





























