import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".

class Node implements Comparable<Node>{
    int index;
    int weight;

    Node(int index, int weight){
        this.index = index;
        this.weight = weight;
    }


    @Override
    public int compareTo(Node o){
        return this.weight - o.weight;
    }
}

class Main {
    static int N,M,X;
    static ArrayList<Node>[] graph;
    static int[] distFromX;
    static int INF = 100_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        X=Integer.parseInt(st.nextToken());

        graph=new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            graph[i]=new ArrayList<>();
        }

        //풀이
        //X에서 각 지점별로 갈 수 있는 최단거리 : 다익스트라로 구한다.

        //그리고, 각 점별로, 다익스트라 값을 구한다.
        //그리고 최종적으로는 X에서의 도착 값을 return 한다.

        //반복문을 돌려서 값을 구하고, 최대값을 추가한다.
        //그래프에 대해 노드를 설정해야한다.
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v,w));
        }

        distFromX = new int[N+1];
        Arrays.fill(distFromX,INF);

        dijkstraX();
        int max = 0;

        for(int i=1; i<=N; i++){
            // System.out.println(dijkstra(i));
            max=Math.max(max, distFromX[i]+dijkstra(i));
        }

        System.out.println(max);
    }
    //X의 경우, 모든 것에 대한 경로를 return 받아야하고
    //나머지의 경우 X까지의 경로 값을 얻으면 된다.
    
    static void dijkstraX(){
        distFromX[X]=0;
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(X,0));

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int curIndex = curNode.index;
            int curWeight = curNode.weight;

            if(curWeight>distFromX[curIndex]) continue;

            for(Node node : graph[curIndex]){
                int cost = distFromX[curIndex]+node.weight;
                if(distFromX[node.index]>cost){
                    distFromX[node.index]=cost;
                    pq.offer(new Node(node.index,cost));
                }
            }
        }
    }

    static int dijkstra(int start){
        int[] dist = new int[N+1];
        Arrays.fill(dist,INF);
        dist[start]=0;
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start,0));

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int curIndex = curNode.index;
            int curWeight = curNode.weight;

            if(curWeight>dist[curIndex]) continue;

            for(Node node : graph[curIndex]){
                int cost = dist[curIndex]+node.weight;
                if(dist[node.index]>cost){
                    dist[node.index]=cost;
                    pq.offer(new Node(node.index,cost));
                }
            }
        }
        return dist[X];
    }
}




















