package backTracking;

//문제
//N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 정수의 개수를 나타내는 N과 정수 S가 주어진다.
//(1 ≤ N ≤ 20, |S| ≤ 1,000,000) 둘째 줄에 N개의 정수가 빈 칸을 사이에 두고 주어진다.
//주어지는 정수의 절댓값은 100,000을 넘지 않는다.
//
//출력
//첫째 줄에 합이 S가 되는 부분수열의 개수를 출력한다.
//
//예제 입력
//        5 0
//        -7 -3 -2 5 8
//예제 출력
//        1


//재귀함수, 백트래킹
//부분집합 구현


//재귀함수 구현


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1182 {
    static boolean[] visited;
    static int N,S;
    static long count =0;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        S=Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        func(0, 0);

        if(S==0) count--;

        System.out.println(count);

    }

    static void func(int dept ,int sum){
        if(dept==N){
            if(sum==S) count++;
            return;
        }

        func(dept+1,sum);
        func(dept+1,sum+arr[dept]);
    }

}
