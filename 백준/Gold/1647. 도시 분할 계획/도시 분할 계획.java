import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
//<문제 조건>
//2초,256mb
//집 : N개 (2~100,000)
//길 : M개 (1~1,000,000)
//유지비가 있음. 
//임의의 두집 사이 경로 항상 존재.

//[분리계획]
//분리 된 마을을 연결하는 길은 없애도 됨.
//분리된 두 마을에서도 다 연결되어 있어야된다.
//길을 모두 없애고, 나머지 길의 유지비 합을 최소로하고 싶다.

//1. 일단 마을을 2개로 쪼갠다.
//2. 그다음에, 마을안에서도, 굳이 필요없는 부분은 삭제할 수 있다. 
//A,B,C는 1~1000

//최소신장트리로 푸는 문제


class Edge implements Comparable<Edge>{
    int home;
    int cost; 

    public Edge(int home, int cost){
        this.home = home;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o){
        return this.cost - o.cost; //비용 낮은순대로.
    }
}


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        boolean[] visited = new boolean[N+1];

        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<Edge>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int homeA = Integer.parseInt(st.nextToken());
            int homeB = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(homeA).add(new Edge(homeB,w));
            graph.get(homeB).add(new Edge(homeA,w));
            //방향이 없는 그래프이다.
            //그러면 ArrayList로 해가지고, 두개다 넣으면 되지 않을까?
            //ㅇㅇ 뭐 그렇게 하면 될거같은데
            //근데 이렇게되면 이건, 사실 크루스칼 쓰는게 더 적합하겠다.
            //응 몰라 그냥할거야.
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        int total = 0;
        int max = 0;
        
        pq.offer(new Edge(1,0));//시작점 1이고, 가중치 0인걸 넣는다.

        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            int now = edge.home;
            int cost = edge.cost;

            if(visited[now]) continue;//이미 방문햇다면 패스

            visited[now]=true;
            total += cost;
            max = Math.max(max,cost);

            for(Edge e : graph.get(now)){
                if(!visited[e.home]){
                    pq.offer(e);
                }
            }
        }

        System.out.println(total-max);
    }
}





























