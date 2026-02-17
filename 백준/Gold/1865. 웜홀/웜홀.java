import java.util.*;
import java.lang.*;
import java.io.*;



class Edge {
    int s, e, t;
    public Edge(int s, int e, int t) {
        this.s = s;
        this.e = e;
        this.t = t;
    }
}

class Main {
    static int N,M,W;
    static int dist[];
    static ArrayList<Edge> edges;
    static final int INF = 1000000000;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        //벨만포드
        StringTokenizer st;
        for(int i=0; i<TC; i++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            edges = new ArrayList<>();
            dist = new int[N+1];

            //도로 입력
            for(int j=0; j<M; j++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                
                //양방향으로 넣어줌
                edges.add(new Edge(s,e,t));
                edges.add(new Edge(e,s,t));
            }

            //웜홀 입력
            for (int j = 0; j < W; j++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                edges.add(new Edge(s, e, -t)); // 시간이 줄어드므로 마이너스
            }

            if(bellmanFord()) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    static boolean bellmanFord(){
        Arrays.fill(dist,INF);
        dist[1]=0;

        //N-1간선 모두 확인
        for(int i =1; i<N; i++){
            boolean update =false;
            for(Edge edge : edges){
                if(dist[edge.e]>dist[edge.s]+edge.t){//더 최단거리라면
                    dist[edge.e]=dist[edge.s]+edge.t;
                    update = true;
                }
            }
            if(!update) break;
        }
        for(Edge edge : edges){
            if(dist[edge.e]>dist[edge.s]+edge.t){
                return true;
            }
        }
        return false;
    }
}


