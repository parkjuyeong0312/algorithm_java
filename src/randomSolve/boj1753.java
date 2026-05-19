//package randomSolve;
//
////최단경로
//
////문제
////방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하시오.
////단, 모든 간선의 가중치는 10 이하의 자연수이다.
//
////입력
////첫째 줄에 정점의 개수 V와 간선의 개수 E가 주어진다. (1 ≤ V ≤ 20,000, 1 ≤ E ≤ 300,000)
////모든 정점에는 1부터 V까지 번호가 매겨져 있다고 가정한다.
////둘째 줄에는 시작 정점의 번호 K(1 ≤ K ≤ V)가 주어진다.
////셋째 줄부터 E개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수 (u, v, w)가 순서대로 주어진다.
////이는 u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻이다. u와 v는 서로 다르며 w는 10 이하의 자연수이다.
////서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있음에 유의한다.
////
////출력
////첫째 줄부터 V개의 줄에 걸쳐, i번째 줄에 i번 정점으로의 최단 경로의 경로값을 출력한다. 시작점 자신은 0으로 출력하고, 경로가 존재하지 않는 경우에는 INF를 출력하면 된다.
////
////예제 입력 1
////        5 6
////        1
////        5 1 1
////        1 2 2
////        1 3 3
////        2 3 4
////        2 4 5
////        3 4 6
////예제 출력 1
////        0
////        2
////        3
////        7
////INF
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//
////class Node implements Comparable<Node>{
////    int end;
////    int weight;
////
////    public Node(int end, int weight){
////        this.end = end;
////        this.weight = weight;
////    }
////
////    @Override
////    public int compareTo(Node o){
////        return this.weight-o.weight;
////    }
////}
//
//
//public class boj1753 {
//
//    static int V,E,K;
//    static List<Node>[] list;
//    static int[] dist;
//    static final int INF = Integer.MAX_VALUE;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        V = Integer.parseInt(st.nextToken());
//        E = Integer.parseInt(st.nextToken());
//
//        K = Integer.parseInt(br.readLine());
//
//        list = new ArrayList[V+1];
//        for(int i=1; i<=V; i++){
//            list[i] = new ArrayList<>();
//        }
//
//        dist = new int[V+1];
//        Arrays.fill(dist,INF);
//
//
//        for(int i=0; i<E; i++){
//            st = new StringTokenizer(br.readLine());
//            int u = Integer.parseInt(st.nextToken());
//            int v = Integer.parseInt(st.nextToken());
//            int w = Integer.parseInt(st.nextToken());
//
//            list[u].add(new Node(v,w));
//        }
//
//        dijkstra(K);
//
//        StringBuilder sb = new StringBuilder();
//        for(int i=1; i<=V; i++){
//            if(dist[i]==INF){
//                sb.append("INF\n");
//            }else{
//                sb.append(dist[i]).append("\n");
//            }
//        }
//
//        System.out.print(sb);
//
//    }
//
//    private static void dijkstra(int start){
//        PriorityQueue<Node> pq= new PriorityQueue<>();
//        pq.add(new Node(start,0));
//
//        dist[start]=0;
//
//        while(!pq.isEmpty()){
//            Node curNode = pq.poll();
//            int curEnd = curNode.end;
//            int curWeight = curNode.weight;
//
//            //현재 꺼낸 노드의 거리가 이미 저장된 최단거리보다 크면 패스
//            if(curWeight>dist[curEnd]) continue;
//
//            for(Node nextNode : list[curEnd]){
//                if(dist[nextNode.end]>dist[curEnd]+nextNode.weight){
//                    dist[nextNode.end] = dist[curEnd]+nextNode.weight;
//                    pq.add(new Node(nextNode.end, dist[nextNode.end]));
//                }
//            }
//        }
//    }
//}
