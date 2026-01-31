package solveByTopic.bfs;
//문제
//수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 500,000)에 있고,
//동생은 점 K(0 ≤ K ≤ 500,000)에 있다.
//수빈
//수빈이는 걷거나 순간이동을 할 수 있다.
//만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
//순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.



//동생은 항상 걷기만 한다.
//동생은 항상 매 초마다 이동을 하며, 이동은 가속이 붙는다.
//동생이 이동하는 거리는 이전에 이동한 거리보다 1을 더한 만큼 이동한다.
//즉, 동생의 처음 위치는 K, 1초가 지난 후 위치는 K+1, 2초가 지난 후 위치는 K+1+2, 3초가 지난 후의 위치는 K+1+2+3이다.
//
//수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
//동생을 찾는 위치는 정수 좌표이어야 하고, 수빈이가 0보다 작은 좌표로, 50만보다 큰 좌표로 이동하는 것은 불가능하다.
//
//입력
//첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.
//
//출력
//수빈이가 동생을 찾는 가장 빠른 시간을 출력한다. 수빈이가 동생을 찾을 수 없거나, 찾는 위치가 500,000을 넘는 경우에는 -1을 출력한다.
//
//예제 입력
//        5 17
//예제 출력
//        2

import java.io.*;
import java.util.*;

//예제 입력
//        17 5
//예제 출력
//        4
public class boj17071 {
    static int MAX = 500000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        }

        boolean[][] visited = new boolean[2][MAX + 1];
        ArrayDeque<Integer> q = new ArrayDeque<>();


        visited[0][N] = true;
        q.offer(N);

        int t = 0;


        while(!q.isEmpty()){
            long brother = (long)K+(long)t*(t+1)/2;
            //넘어가면 못잡은거임.
            if(brother>MAX){
                System.out.println(-1);
                break;
            }

            if(visited[t&1][(int)brother]){
                System.out.println(t);
                return;
            }

            int size = q.size();
            int nextParity = (t+1)&1;

            for(int i =0; i<size;i++){
                int x = q.poll();

                int nx1 = x-1;
                int nx2 = x+1;
                int nx3 = x*2;

                if (nx1 >= 0 && !visited[nextParity][nx1]) {
                    visited[nextParity][nx1] = true;
                    q.offer(nx1);
                }
                if (nx2 <= MAX && !visited[nextParity][nx2]) {
                    visited[nextParity][nx2] = true;
                    q.offer(nx2);
                }
                if (nx3 <= MAX && !visited[nextParity][nx3]) {
                    visited[nextParity][nx3] = true;
                    q.offer(nx3);
                }
            }

            t++;
        }

    }

}
