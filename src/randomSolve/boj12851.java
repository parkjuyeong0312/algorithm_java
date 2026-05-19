package randomSolve;
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	512 MB	77352	22839	15866	26.866%
//문제
//수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
//
//수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 그리고, 가장 빠른 시간으로 찾는 방법이 몇 가지 인지 구하는 프로그램을 작성하시오.
//
//입력
//첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.
//
//        출력
//첫째 줄에 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
//
//둘째 줄에는 가장 빠른 시간으로 수빈이가 동생을 찾는 방법의 수를 출력한다.
//
//예제 입력 1
//        5 17
//예제 출력 1
//        4
//        2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

//뭐 bfs로 푸는 문제 같다.
//가장 빠른 시간을 출력하면된다.
public class boj12851 {
    static int subin, sister;
    static int[] dp;
    static boolean[] visited;
    static int count;
    static int minTime;
    static int MAX = 100001;
    static int MAXTIME = 200000;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        subin = Integer.parseInt(st.nextToken());
        sister = Integer.parseInt(st.nextToken());

        dp = new int[MAX];
        Arrays.fill(dp,MAXTIME);
        visited = new boolean[MAX];
        //첫번째 : 거리
        //0으로 초기화 되어있을것이다.

        bfs();

//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[sister]);
        System.out.println(count);

    }

    static void bfs(){
        visited[subin]=true;
        dp[subin]=0;
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{subin,0});

        while(!dq.isEmpty()){
            int[] unit = dq.poll();
            int pos = unit[0];
            int time = unit[1];

            if(pos==sister){
                count++;
            }

            int plus = pos+1;
            int minus = pos-1;
            int jump = pos*2;

            if(plus<MAX&&dp[plus]>=time+1){
//                visited[plus]=true;
                dp[plus]=time+1;
                dq.offer(new int[]{plus,time+1});
            }

            if(minus>=0&&dp[minus]>=time+1){
//                visited[minus]=true;
                dp[minus]=time+1;
                dq.offer(new int[]{minus,time+1});
            }

            if(jump<MAX&&dp[jump]>=time+1){
//                visited[jump]=true;
                dp[jump]=time+1;
                dq.offer(new int[]{jump,time+1});
            }
        }
    }

    //로직을 생각해보자.
    //visited


}
