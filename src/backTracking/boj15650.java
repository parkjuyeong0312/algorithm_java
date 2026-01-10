package backTracking;

//문제
//자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
//
//1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
//고른 수열은 오름차순이어야 한다.
//입력
//첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
//
//출력
//한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
//
//수열은 사전 순으로 증가하는 순서로 출력해야 한다.
//
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
//        2 3
//        2 4
//        3 4
//예제 입력
//        4 4
//예제 출력
//        1 2 3 4

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15650 {
    static int N,M;
    static int[] arr;
    static boolean[] isUsed;
    static StringBuilder sb = new StringBuilder();

    static void func(int k){
        if(k==M){
            for(int i=0; i<M;i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i =0; i<N;i++){
            //이미 사용 되었다면
            if(isUsed[i]) continue;

            if(k>0&&arr[k-1]>i) continue;
            //사용 안되었다면
            arr[k]=i+1;
            isUsed[i]= true;
            func(k+1);
            isUsed[i] = false;
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        isUsed = new boolean[N];

        func(0);

        System.out.print(sb);
    }
}
