package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//문제
//N개의 수가 주어졌을 때, 이를 비내림차순으로 정렬하는 프로그램을 작성하시오.
//길이가 K인 수열 A가 A1 ≤ A2 ≤ ... ≤ AK-1 ≤ AK를 만족하면, 비내림차순이라고 한다.
//
//입력
//첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이며, 같은 수가 여러 번 중복될 수도 있다.
//
//출력
//첫째 줄부터 N개의 줄에 비내림차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
//
//예제 입력
//        5
//        5
//        4
//        3
//        2
//        1
//예제 출력
//        1
//        2
//        3
//        4
//        5
public class countingSort {
    static int[] arr;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int OFFSET = 1_000_000;
        arr = new int[2_000_001];

        for(int i=0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            arr[x+OFFSET]++;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<2_000_001; i++){
            int c = arr[i];
            if (c == 0) continue;
            int val = i - OFFSET;
            for (int j = 0; j < c; j++) {
                sb.append(val).append('\n');
            }
        }

        sb.delete(sb.length()-1,sb.length());

        System.out.println(sb);
    }
}
