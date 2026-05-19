package randomSolve;

//최소비용 구하기 2 스페셜 저지

//문제
//n(1≤n≤1,000)개의 도시가 있다.
//그리고 한 도시에서 출발하여 다른 도시에 도착하는 m(1≤m≤100,000)개의 버스가 있다.
//우리는 A번째 도시에서 B번째 도시까지 가는데 드는 버스 비용을 최소화 시키려고 한다.
//그러면 A번째 도시에서 B번째 도시 까지 가는데 드는 최소비용과 경로를 출력하여라.
//항상 시작점에서 도착점으로의 경로가 존재한다.
//
//입력
//첫째 줄에 도시의 개수 n(1≤n≤1,000)이 주어지고 둘째 줄에는 버스의 개수 m(1≤m≤100,000)이 주어진다.
//그리고 셋째 줄부터 m+2줄까지 다음과 같은 버스의 정보가 주어진다.
//먼저 처음에는 그 버스의 출발 도시의 번호가 주어진다.
//그리고 그 다음에는 도착지의 도시 번호가 주어지고 또 그 버스 비용이 주어진다.
//버스 비용은 0보다 크거나 같고, 100,000보다 작은 정수이다.
//
//그리고 m+3째 줄에는 우리가 구하고자 하는 구간 출발점의 도시번호와 도착점의 도시번호가 주어진다.
//
//출력
//첫째 줄에 출발 도시에서 도착 도시까지 가는데 드는 최소 비용을 출력한다.
//둘째 줄에는 그러한 최소 비용을 갖는 경로에 포함되어있는 도시의 개수를 출력한다.
//출발 도시와 도착 도시도 포함한다.
//셋째 줄에는 최소 비용을 갖는 경로를 방문하는 도시 순서대로 출력한다.
//경로가 여러가지인 경우 아무거나 하나 출력한다.
//
//예제 입력
//        5
//        8
//        1 2 2
//        1 3 3
//        1 4 1
//        1 5 10
//        2 4 2
//        3 4 1
//        3 5 1
//        4 5 3
//        1 5
//예제 출력
//        4
//        3
//        1 3 5

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;


public class boj11779 {
    static int N,M;
    static int[] dist;
    static List<Node>[] list ;
    static int[] route;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        M=Integer.parseInt(br.readLine());
        StringTokenizer st;


        //최단비용을 기록하는 배열
        dist = new int[N+1];
        Arrays.fill(dist,INF);

        route=new int[N+1];

        //연결관계 그래프
        list = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            list[i]=new ArrayList<>();
        }


        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end,weight));
        }

        st = new StringTokenizer(br.readLine());

        int startPoint = Integer.parseInt(st.nextToken());
        int endPoint = Integer.parseInt(st.nextToken());

        dijkstra(startPoint);

        StringBuilder sb = new StringBuilder();
        //최소비용
        sb.append(dist[endPoint]).append("\n");
        //경로를 기록하는 배열을 두어야하나?
        //경로에 포함되는 도시 개수
        ArrayList<Integer> path = new ArrayList<>();
        int cur = endPoint;
        while(cur!=0){
            path.add(cur);
            if(cur == startPoint) break;
            cur=route[cur];
        }

        Collections.reverse(path);

        sb.append(path.size()).append("\n");

        for(int node : path){
            sb.append(node).append(" ");
        }

        System.out.println(sb);

    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start,0));
        dist[start]=0;
        route[start]=0;

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int curEnd = curNode.end;
            int curWeight = curNode.weight;

            //현재 node의 거리가 최단거리보다 크다면, 패스(최적화)
            if(curWeight>dist[curEnd]) continue;


            for(Node nextNode : list[curEnd]){
                if(dist[nextNode.end]>dist[curEnd]+nextNode.weight){
                    dist[nextNode.end]=dist[curEnd]+nextNode.weight;
                    route[nextNode.end]=curEnd;
                    pq.add(new Node(nextNode.end,dist[nextNode.end]));
                }
            }
        }
    }

}

class Node implements Comparable<Node>{
    int end;
    int weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight-o.weight;
    }
}