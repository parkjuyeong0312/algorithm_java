package backTracking;

//문제
//자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
//1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
//입력
//첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
//
//출력
//한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
//
//수열은 사전 순으로 증가하는 순서로 출력해야 한다.

//예제 입력
//        3 1
//예제 출력
//        1
//        2
//        3
//예제 입력
//        4 2
//예제 출력
//        1 2
//        1 3
//        1 4
//        2 1
//        2 3
//        2 4
//        3 1
//        3 2
//        3 4
//        4 1
//        4 2
//        4 3

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//백트래킹
//재귀의 일종
public class boj15649 {
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[M];
        boolean[] visited = new boolean[N];

        func(arr,visited,0);

        sb.delete(sb.length()-1,sb.length());

        System.out.println(sb);
    }

    static void func(int[] arr, boolean[] visited,int count){
        if(count==M) {
            for(int i =0; i<M; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i =0; i<N; i++){

            //원소가 있으면, 패스
            if(visited[i]) continue;
            int newCount = count;
            int[] newArr = Arrays.copyOf(arr,M);
            boolean[] newVisited = Arrays.copyOf(visited,N);
            newArr[count]=i+1;
            newVisited[i]=true;
            func(newArr,newVisited,newCount+1);
        }
    }
}
