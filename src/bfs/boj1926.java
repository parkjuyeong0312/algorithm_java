package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//문제
//어떤 큰 도화지에 그림이 그려져 있을 때, 그 그림의 개수와, 그 그림 중 넓이가 가장 넓은 것의 넓이를 출력하여라.
//단, 그림이라는 것은 1로 연결된 것을 한 그림이라고 정의하자.
//가로나 세로로 연결된 것은 연결이 된 것이고 대각선으로 연결이 된 것은 떨어진 그림이다.
//그림의 넓이란 그림에 포함된 1의 개수이다.
//
//입력
//첫째 줄에 도화지의 세로 크기 n(1 ≤ n ≤ 500)과 가로 크기 m(1 ≤ m ≤ 500)이 차례로 주어진다.
//두 번째 줄부터 n+1 줄 까지 그림의 정보가 주어진다. (단 그림의 정보는 0과 1이 공백을 두고 주어지며, 0은 색칠이 안된 부분, 1은 색칠이 된 부분을 의미한다)
//
//출력
//첫째 줄에는 그림의 개수, 둘째 줄에는 그 중 가장 넓은 그림의 넓이를 출력하여라.
// 단, 그림이 하나도 없는 경우에는 가장 넓은 그림의 넓이는 0이다.
//
//예제 입력
//        6 5
//        1 1 0 1 1
//        0 1 1 0 0
//        0 0 0 0 0
//        1 0 1 1 1
//        0 0 1 1 1
//        0 0 1 1 1
//예제 출력
//        4
//        9
//(풀이) 첫 bfs 구현
//이건 연결관계를 보여주는게 아니니까, 직접 이동을 해서 연결이 되어있는지 확인해야할 것 같음.
//결국 N,M만큼 순회를 돌면서, 연결되었는지 확인할 거지만, 상,하,좌,우 검색을 해야되려나?-> 해야됨
//그럼 상,하,좌,우를 검색할 수 있는 배열을 만들어야함.

//궁금한거 : 이거 클래스로 관리해서 각 객체마다 visited를 변수로 넣는건 별론가?

//bfs 함수 선언
//1. bfs는 배열의 모든 요소를 넣으며, 순회한다.
//2. 매개변수로는, visited, graph, startNode를 넣는다.

//1. queue를 선언한다.
//2. startNode를 방문처리한다.
//3. queue가 빌때까지 반복한다.
    //queue.poll() ->한 값을 방문처리하고, 상하좌우를 확인한다.
    //상하좌우를 반복해서 확인하고,만약,해당값이
        //방문되지 않았다면 큐에 넣는다.
        //방문했다면, 큐에 넣지 않는다.



public class boj1926 {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Node[][] graph = new Node[N][M];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j<M; j++){
                graph[i][j] = new Node(Integer.parseInt(st.nextToken()));
            }
//            sb.append(Arrays.toString(graph[i])).append("\n");
        }

        int count = 0;
        int max = 0;

        for(int i = 0 ; i<N; i++){
            for(int j = 0; j<M; j++){
                Node node = graph[i][j];
                if(!node.visited&&node.paint==1){
                    count++;
                    int area = bfs(graph,i,j,N,M);

                    if(max<area){
                        max=area;
                    }
                }
            }
        }

        System.out.println(count);
        System.out.println(max);

    }
    static int bfs(Node[][]graph, int startX, int startY,int N, int M){
        Deque<int[]> queue = new ArrayDeque();
        Node node = graph[startX][startY];
        int area =0;
        node.visited=true;
        queue.offerLast(new int[]{startX,startY});
        area++;

        while(!queue.isEmpty()){
            int[] popUnit= queue.pollFirst();
            int x = popUnit[0];
            int y = popUnit[1];

            for(int dir = 0; dir<4; dir++){
                int nx = x+dx[dir];
                int ny = y+dy[dir];

                if(nx<0 || nx>=N||ny<0||ny>=M) continue;

                Node nextNode = graph[nx][ny];

                if(nextNode.visited) continue;
                if(nextNode.paint!=1) continue;

                nextNode.visited=true;
                queue.offerLast(new int[]{nx,ny});
                area++;
            }
        }
        return area;
    }

}

class Node{
    boolean visited = false;
    int paint;

    public Node(int paint){
        this.paint = paint;
    }
}
