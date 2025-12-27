package basic;
//문제
//N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
//
//        입력
//첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다.
// 모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.
//
//출력
//첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.

//예제 입력
//        5
//        20 10 35 30 7
//예제 출력
//        7 35
// 정렬을 사용하면 좋을 것 같음.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();

        String[] inputs = br.readLine().split(" ");

        int[] inputInteger = new int [inputs.length];

        for(int i = 0; i<inputs.length; i++){
            inputInteger[i] = Integer.parseInt(inputs[i]);
        }

        Arrays.sort(inputInteger);

        System.out.print(inputInteger[0]+" "+inputInteger[inputInteger.length-1]);
    }
}
