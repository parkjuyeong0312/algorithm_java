
//문제
//방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.
//
//        출력
//첫째 줄에 연결 요소의 개수를 출력한다.
//
//예제 입력 1
//        6 5
//        1 2
//        2 5
//        5 1
//        3 4
//        4 6
//예제 출력 1
//        2
//예제 입력 2
//        6 8
//        1 2
//        2 5
//        5 1
//        3 4
//        4 6
//        5 4
//        2 4
//        2 3
//예제 출력 2
//        1

//뭔가 그래프를 선언하고, 연결을 한다음에,
//BFS같은걸로 탐색을 하면 될 거 같긴한데..

//인접행렬과 인접리스트 두가지 방식이 있다고 했다.
//뭘 사용하는게 적절할까?
//둘 다 뭐 구현방식에 있어서 얼마나 차이가 있으려나 모르겟지만, 둘다 구현이 가능할 것 같다. 내생각엔
//그럼 먼저 인접행렬로 해볼까?
//연결을 한다. 그렇다면, 무방향 그래프니까 둘다 연결을 한다.
//bfs같은걸로 해야되니까, 아무래도, visited같은걸해야겟지?
//행 기준으로 자기 번호에 붙어있는거가 1이면 쭉쭉~가면될듯.

//그럼 행렬그래프 선언할 이차원배열하나랑, 방문여부 처리할 이차원배열 하나 이렇게 구현해서 BFS를 돌리면 되겟네.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static boolean[] visited;
    static int count =0;
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());//정점개수
        M = Integer.parseInt(st.nextToken());//간선개수

        graph = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph[node1][node2]=1;
            graph[node2][node1]=1;
        }

        //순회를 할때, 다 볼 필요 없지않나? 절반만 보면 되잖아.
        for(int i=1; i<=N; i++){
            if(visited[i]) continue;//방문을 했다면 continue 하는것도 이상해. 방문을 안햇다가 뭐 나중에 검사할수도 있는거아냐?
            bfs(i);
            count+=1;
        }

        System.out.println(count);
    }

    //deque에는 한 원소만 넣는가?
    static void bfs(int x){
        Deque<Integer> dq = new ArrayDeque<>();
        visited[x]= true;
        dq.offer(x);

        while(!dq.isEmpty()){
            int node = dq.poll();
            for(int i =1; i<=N; i++){
                if(graph[node][i]==1&&!visited[i]){
                    visited[i] = true;
                    dq.offer(i);
                }
            }
        }
    }

}
