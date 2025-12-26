package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//문제
//첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
//
//입력
//첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.
//
//출력
//첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.
public class boj2439 {
    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//
//        int N = sc.nextInt();
//        int count = N-2;
//        for(int i = 0 ; i<N; i++){// 총 N번 돌기
//            for(int j = 0; j<N; j++){
//                if(j<=count){
//                    System.out.print(" ");
//                }else {
//                    System.out.print("*");
//                }
//            }
//            count -=1;
//            System.out.println();
//        }
//    }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < N - i; j++) sb.append(" ");
            for (int k = 0; k < i; k++) sb.append("*");
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
