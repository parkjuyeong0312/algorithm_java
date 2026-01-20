package DynamicProgramming;
//문제
//정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
//
//X가 3으로 나누어 떨어지면, 3으로 나눈다.
//X가 2로 나누어 떨어지면, 2로 나눈다.
//1을 뺀다.
//정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.
//
//입력
//첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.
//
//출력
//첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
//
//예제 입력
//        2
//예제 출력
//        1
//예제 입력
//        10
//예제 출력
//        3


import java.io.BufferedReader;
import java.io.InputStreamReader;

//1.테이블 정의하기
    //D[i] = ? 를 1로 만들기 위해 필요한 연산 사용 횟수의 최솟값 찾기
//2.점화식 찾기
    //D[12]의 경우
    //a. 3으로 나누기 : D[4] + 1 -> D[k/3]+1
    //b. 2로 나누기 : D[6] + 1 -> D[k/2] +1
    //c. 1빼기 : D[11] + 1 -> D[k-1] +1
//3.초기값 정하기
    //D[1] = 0
public class boj1463 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];

        dp[1]=0;

        for(int i=2; i<=N;i++){

            dp[i]=dp[i-1]+1;

            if(i%3==0){
                dp[i]=Math.min(dp[i],dp[i/3]+1);
            }

            if(i%2==0){
                dp[i]=Math.min(dp[i], dp[i/2]+1);
            }
        }

        System.out.println(dp[N]);
    }
}
