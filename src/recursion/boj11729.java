package recursion;
//문제
//세 개의 장대가 있고 첫 번째 장대에는 반경이 서로 다른 n개의 원판이 쌓여 있다.
//각 원판은 반경이 큰 순서대로 쌓여있다.
//이제 수도승들이 다음 규칙에 따라 첫 번째 장대에서 세 번째 장대로 옮기려 한다.
//
//한 번에 한 개의 원판만을 다른 탑으로 옮길 수 있다.
//쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.
//이 작업을 수행하는데 필요한 이동 순서를 출력하는 프로그램을 작성하라. 단, 이동 횟수는 최소가 되어야 한다.
//
//아래 그림은 원판이 5개인 경우의 예시이다.
//
//입력
//첫째 줄에 첫 번째 장대에 쌓인 원판의 개수 N (1 ≤ N ≤ 20)이 주어진다.
//
//출력
//첫째 줄에 옮긴 횟수 K를 출력한다.
//
//두 번째 줄부터 수행 과정을 출력한다.
//두 번째 줄부터 K개의 줄에 걸쳐 두 정수 A B를 빈칸을 사이에 두고 출력하는데,
//이는 A번째 탑의 가장 위에 있는 원판을 B번째 탑의 가장 위로 옮긴다는 뜻이다.
//예제 입력
//        3
//예제 출력
//        7
//        1 3
//        1 2
//        3 2
//        1 3
//        2 1
//        2 3
//        1 3

//절차지향적인 사고를 버리자.

//재귀함수
//패턴찾기
//1. 쌓아 놓은 원판은 항상 위의 것이 아래의 것보다 작아야 한다.
//2. n-1개의 원판을 기둥 1에서 2로 옮긴다.
//3. 원판 n을 기둥 1에서 3으로 옮긴다.
//4. n-1개의 원판을 기둥 2에서 1로 옮긴다.
//5. 원판 n-1을 기둥 2에서 3으로 옮긴다.

//원판 n개를 a기둥에서 b로 옮기려면,

//결론 :
//원판이 1개 일때, 원판을 옮길 수 있다.
//원판이 k개 일때, 원판을 옮길 수 있으면 원판이 k+1일때도 옮길 수 있다.

//재귀함수의 정의
//원판 n개를 a번 기둥에서 b번 기둥으로 옮기는 함수
//원판 n을 b로 옮기려면, n-1을 (원판합-a-b)로 옮겨야한다.

//base condition
//n=1일때, 원판 n을 b로 옮긴다.

//1. n-1개의 원판을 a에서 6-a-b로 옮긴다. func(a,6-a-b,n-1)
//2. 원판 n을 b로 옮긴다.
//3. n-1개의 원판을 6-a-b에서 b로 옮긴다.(func(6-a-b,b,n-1)


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.nio.file.Files.move;

public class boj11729 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long moves = (1L << n)-1; //2^n-1
        sb.append(moves).append("\n");

        move(n,1,3);
        System.out.println(sb);

    }

    static void move(int n, int from , int to){
        //base-case :
        if(n==1){
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }

        int sub = 6 - from - to;

        move(n-1,from,sub);//n-1개를 보조로
        sb.append(from).append(" ").append(sub).append("\n");//n을 목적지로
        move(n-1,sub,to);//n-1개를 목적지로
    }

}
