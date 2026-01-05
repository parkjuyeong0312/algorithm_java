package bfs;
//문제
//수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
//수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
//순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
//
//수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
//
//입력
//첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.
//
//출력
//수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
//
//예제 입력
//        5 17
//예제 출력
//        4
//힌트
//수빈이가 5-10-9-18-17 순으로 가면 4초만에 동생을 찾을 수 있다.

//풀이
//"bfs"에서 시간은 이전 큐에 넣은 시간+1을 의미한다.
//점의 크기가 10만인데, 해당 칸을 -1로 채우고, 수빈이의 시작 시점을 0, 동생의 시작 시점을 -2로 설정한다.
//제한은 음수로 이동할 수 없으므로, nx가<0이거나 nx>=100000일시에 conitnue 조건으로 넘긴다.
//bfs에서 queue에 넣는 조건은 내가 가장 빨리도착해야하니까, time[x]+1<time[nx]이여야 넣어야된다.
    //근데 time[x]를 -1로 설정하게되면, time[x]+1의 조건이 성립을 안하므로, time[x]를 100000으로 설정하던가 -1일때의 조건을 추가해서 로직을 작성한다.
//값이 K보다 커지게 되면 사실상 -1밖에 할수 없으므로 해당 관련 조건문을 나눠서 불필요한 bfs가 수행되지 않도록 한다.
//+1,-1,*2

//<sudo>
//static dx = {


//int N,K
//int graph[100001]
//graph.fill(-1)
//graph[N]=0,graph[K]=0,

//bfs(graph,N)
//int queue 선언
//queue에 N 넣기

//while(!queue.isEmpty)
//  int x =queue.poll
//  if(x<K)
//
//      if(graph[x+1]==-2) graph[x]+1=graph[x+1],break
//      if(graph[x*2]==-2) graph[x}+1=graph[x*2],break
//      if(graph[x+1]!=-1 continue
//      queue.offer(x+1)
//      graph[x]+1=graph[x+1]
//
//      if(x*2>100000) continue
//      if(graph[x*2]!=-1) continue
//      queue.offer(x*2)
//      graph[x]+1=graph[2*x]
//
//  if(x>0)
//      if(graph[x-1]==-2) graph[x]+1=graph[x-1]+1,break
//      if(graph[x-1]!=-1) continue
//      queue.offer(x-1)
//      graph[x]+1=graph[x-1]
//


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj1697 {
    static int MAX=100001;
    public static void main(String[] args) throws IOException {
        //int N,K
        //int graph[100001]
        //graph.fill(-1)
        //graph[N]=0,graph[K]=0,
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

//        System.out.println("N:"+N+"K:"+K);

        int[] graph = new int[MAX];
        Arrays.fill(graph,-1);

        graph[N]=0;

//        System.out.println(Arrays.toString(graph));

        bfs(graph,N,K);

//        System.out.println(Arrays.toString(graph));
        System.out.println(graph[K]);

    }

    //bfs(graph,N)
        //int queue 선언
        //queue에 N 넣기

            //while(!queue.isEmpty)
        //  int x =queue.poll
        //  if(x<K)
        //
        //      if(graph[x+1]==-2) graph[x]+1=graph[x+1],break
        //      if(graph[x*2]==-2) graph[x}+1=graph[x*2],break
        //      if(graph[x+1]!=-1 continue
        //      queue.offer(x+1)
        //      graph[x]+1=graph[x+1]
        //
        //      if(x*2>100000) continue
        //      if(graph[x*2]!=-1) continue
        //      queue.offer(x*2)
        //      graph[x]+1=graph[2*x]
        //

    //문제, 0위치에서 시작했을때는? -> 문제없음
    static void bfs(int[] graph, int N,int K){

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(N);


        while(!queue.isEmpty()){
            int x = queue.poll();//5를꺼낸다.

            if(x==K) break;

            if(x+1<MAX){
                if(x+1==K){//-1 != -2
                    graph[x+1]=graph[x]+1;
                    break;
                }
                if(graph[x+1]==-1){
                    queue.offer(x+1);//offer(6)
                    graph[x+1]=graph[x]+1;//graph[6]=1;
                }

            }

            if(x*2<MAX){
                if(x*2==K){//-1 ! = -2
                    graph[x*2]=graph[x]+1;
                    break;
                }
                if(graph[x*2]==-1){
                    queue.offer(x*2);
                    graph[x*2]=graph[x]+1;
                }
            }


            if(x-1>=0){
                if(x-1==K){
                    graph[x-1]=graph[x]+1;
                    break;
                }
                if(graph[x-1]==-1){
                    queue.offer(x-1);
                    graph[x-1]=graph[x]+1;
                }
            }
        }
    }
}
