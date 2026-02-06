
//문제
//루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.
//
//출력
//첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.
//
//예제 입력 1
//        7
//        1 6
//        6 3
//        3 5
//        4 1
//        2 4
//        4 7
//예제 출력 1
//        4
//        6
//        1
//        3
//        1
//        4
//예제 입력 2
//        12
//        1 2
//        1 3
//        2 4
//        3 5
//        3 6
//        4 7
//        4 8
//        5 9
//        5 10
//        6 11
//        6 12
//예제 출력 2
//        1
//        1
//        2
//        3
//        3
//        4
//        4
//        5
//        5
//        6
//        6

//인접행렬형식으로 먼저 그래프의 연결관계를 표시하고,
//1을 기준으로 시작하여, 부모 트리를 기록한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] motherNode;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());//7

        graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            graph[i] = new ArrayList<>();
        }

        motherNode = new int[N+1];

        StringTokenizer st;
        for(int i =0; i<N-1; i++){//
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        bfs();

        for(int i=2;i<=N;i++){
            System.out.println(motherNode[i]);
        }
    }

    //1. 시간초과가 떳다!
    //흠.. 100_000이니까, N^2를 하면, 1억임.
    //1초가 시간제한이니까, 시간초과남.

    //그러면..연결리스트방식을써야하는거임.

    //
    static void bfs(){
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(1);
        motherNode[1]=-1;

        while(!dq.isEmpty()){
            int node = dq.poll();

            for(int next : graph[node]){
                if(motherNode[next]==0){
                    motherNode[next]=node;
                    dq.offer(next);
                }
            }
        }
    }
}
