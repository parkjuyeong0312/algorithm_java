package recursion;//곱셈
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//0.5 초 (추가 시간 없음)	128 MB	166908	49123	35532	28.356%
//문제
//자연수 A를 B번 곱한 수를 알고 싶다.
//단 구하려는 수가 매우 커질 수 있으므로 이를 C로 나눈 나머지를 구하는 프로그램을 작성하시오.
//입력
//첫째 줄에 A, B, C가 빈 칸을 사이에 두고 순서대로 주어진다. A, B, C는 모두 2,147,483,647 이하의 자연수이다.
//출력
//첫째 줄에 A를 B번 곱한 수를 C로 나눈 나머지를 출력한다.

//예제 입력
//        10 11 12
//예제 출력
//        4


//풀이
//문제의 특징을 분석해보자.
//A^10 = A^5*A^5
//A^7 = A^6 * A
//와 같이 쪼갤 수 있다.

//분할정복을 사용한다.(O(logN))
// : 큰 문제를 하나의 문제로 풀지않고 작은 단위로 쪼개서 푸는 방법

//분할정복은 분할,정복,결합 3단계를 따른다.
//1. 충분히 분할한다.
//2. 해결할수 있을만큼 작아지면 직접 해결한다.(종료)
//3. 작은 답을 합쳐서 전체 결과를 얻는다.

//Ak=(짝수)Ak/2*Ak/2
//   (홀수)Ak/2*Ak/2*A

//재귀함수 : Ak/2
//base case : b==0일때, return 1
//          : b==1일때, return A

//long half = a,b/2

//if(b%2==0)짝수라면
//  return half*half%C
//else 홀수라면
//  return half*half*A%C



//A^k(modC)를 알면 A^2k와 A^(2k+1)를 O(1)로 알 수 있다.
//A^n(modC)*A^n(modC) = A^2n이고,
//A^n(modC)*A^n(modC)*A(modC) = A^2n+1이다.

//재귀함수를 설정해야하는데,

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj1629 {
    static long A;
    static long B;
    static long C;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());


        System.out.println(pow(A,B));
    }

    static long pow(long a, long b){
        if(b==0) return 1;
        if(b==1) return a%C;

        long half = pow(a,b/2);

        if(b%2==0){
            return (half*half)%C;
        }else{
            return ((half*half)%C)*(a%C)%C;
        }
    }

}
