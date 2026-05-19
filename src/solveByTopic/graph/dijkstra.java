//package solveByTopic.graph;
//
//import java.util.Arrays;
//import java.util.PriorityQueue;
//
//class Node implements Comparable<Node>{
//    int index;
//    int distance;
//
//    public Node(int index,int distance) {
//        this.index = index;
//        this.distance = distance;
//    }
//    @Override
//    public int compareTo(Node o) {
//        return this.distance-o.distance;//오름차순
//    }
//}
//
//public class dijkstra {
//
//    static int[] dist;
//    static int N;
//    static int MAX = Integer.MAX_VALUE;
//
//    public static void main(String[] args) {
//        dist = new int[N+1];
//
//        for(int i=1; i<=N; i++){
//            Arrays.fill(dist,MAX);
//        }
//    }
//
//    static void dijkstra(int start){
//        PriorityQueue<Node> pq = new PriorityQueue<>();
//        pq.offer(new Node(start,0));
//        dist[start]=0;
//
//        while(!pq.isEmpty()){
//            Node current = pq.poll();
//            int d = current.distance;
//            int now = current.index;
//
//            if(dist[now]<d) continue; //첫 노드는 0, dist[now]=0이기 때문에 패스
//
//            for(Node neighbor : graph.get(now)){
//                int cost = dist[now]+neighbor.distance;
//                if(cost<dist[neighbor.index]){
//                    dist[neighbor.index]=cost;
//                    pq.offer(new Node(neighbor.index,cost));
//                }
//            }
//        }
//    }
//}
