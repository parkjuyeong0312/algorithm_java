import java.util.*;
import java.lang.*;
import java.io.*;

class Node implements Comparable<Node>{
    int index;
    int distance;

    Node(int index, int distance){
        this.index = index;
        this.distance = distance;
    }

    public int compareTo(Node o){
        return this.distance - o.distance;//너남오름차순
    }
}

// The main method must be in a class named "Main".
class Main {
    static int N, E;
    static ArrayList<Node>[] graph;    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            graph[i]=new ArrayList<>();
        }

        while(E-- >0){
            st = new StringTokenizer(br.readLine());

            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            graph[node1].add(new Node(node2,distance));
            graph[node2].add(new Node(node1,distance));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[]startDist = dijkstra(1);
        int[]v1Dist = dijkstra(v1);
        int[]v2Dist = dijkstra(v2);

        

        int case1=startDist[v1]+v1Dist[v2]+v2Dist[N];
        int case2=startDist[v2]+v2Dist[v1]+v1Dist[N];

        int ans = Math.min(case1,case2);

        if(ans >=10000000) ans = -1;
        
        System.out.println(ans);
        
    }

    static int[] dijkstra(int start){
        int[] dist = new int[N+1];
        Arrays.fill(dist,10000000);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start]=0;
        pq.offer(new Node(start,0));

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int now = curNode.index;
            int distance = curNode.distance;

            //다익스트라에서 한번 여기서 뭘 거르는데
            //이미 추가한 걸 봤을때, 현재 거리보다 ~가 안될때 이런식으로 걸럿는데
            //머엿지 
            if(distance>dist[now]) continue;

            for(Node neighbor : graph[now]){
                int cost = dist[now]+neighbor.distance;
                if(cost<dist[neighbor.index]){
                    dist[neighbor.index]=cost;
                    pq.offer(new Node(neighbor.index,cost));
                }
            }
        }

        return dist;
        
    }







    
}