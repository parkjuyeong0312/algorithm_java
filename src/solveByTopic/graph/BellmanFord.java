//package solveByTopic.graph;
//
//class Edge{
//    int from, to, weight;
//
//    Edge(int from, int to, int weight){
//        this.from = from;
//        this.to = to;
//        this.weight = weight;
//    }
//}
//
//public class BellmanFord {
//    static final int INF = 1000000000;
//
//    public static boolean solution(int n, int m , int start, List<Edge> edge){
//        long[] dist = new long[n+1];
//        Arrays.fill(dist,INF);
//        dist[start]=0;
//
//        for(int i =1; i<=n; i++){
//            //매 반복마다 모든 간선을 확인
//            for(Edge edge : edges){
//                int u = edge.from;
//                int v = edge.to;
//                int w = edge.weight;
//
//                if(dist[u]!=INF&&dist[v]>dist[u]+w){//시작지가 갱신됐고, 더 가까울때
//                    dist[v]=dist[u]+w;
//
//                    if (i == n) {
//                        return true;
//                    }
//                }
//
//
//
//
//            }
//        }
//
//        return false;
//    }
//
//}
