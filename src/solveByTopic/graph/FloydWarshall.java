//package solveByTopic.graph;
//
//public class FloydWarshall {
//    static final int INF = 100_000_000;
//
//    for (int i = 1; i <= V; i++) {
//        // 1. 일단 모든 경로를 INF로 채움
//        Arrays.fill(dist[i], INF);
//        // 2. 자기 자신으로 가는 거리는 0으로 세팅
//        dist[i][i] = 0;
//    }
//
//    public void solve(int n, int[][] graph){
//        for(int k =1; k<=n; k++){//거쳐가는 노드
//            for(int i=1; i<=n; i++){
//                for(int j=1; j<=n; j++){
//                    if(dist[i][k]+dist[k][j]<dist[i][j]){
//                        dist[i][j]=dist[i][k]+dist[k][j];
//                    }
//                }
//            }
//        }
//    }
//}
