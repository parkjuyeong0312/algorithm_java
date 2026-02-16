
//피보나치 수 6
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	256 MB	32571	14790	12293	47.943%
//문제
//피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.
//이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.
//n=17일때 까지 피보나치 수를 써보면 다음과 같다.
//0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
//n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 n이 주어진다. n은 1,000,000,000,000,000,000보다 작거나 같은 자연수이다.
//
//출력
//첫째 줄에 n번째 피보나치 수를 1,000,000,007으로 나눈 나머지를 출력한다.
//
//예제 입력
//        1000
//예제 출력
//        517691607
//출처

//일단 long을 사용해야겟군
//dp로 구하는걸까?
//n자체가 1억을 훨씬 상회하기 때문에, 일반적으로, 구하면 1초가 초과된다.
//10억으로 n을 나누면 대충 1억 정도이긴하다.
//피보나치 수 자체가 반복이되나?
//1,000,000,007으로 나눈 나머지 -> 이게 무슨 의미를 갖는거지?
//분할정복?
//수학?

//분할정복을 이용해서 해보자.
//피보나치 행렬식을 이용한다.
//


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[][] matrix;
    static long n;
    final static long MOD = 1_000_000_007;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        n = Long.parseLong(br.readLine());

        if(n==0||n==1){
            System.out.println(n);
            return;
        }

        //기본 행렬
        matrix = new long[][]{{1, 1}, {1, 0}};

        long[][] result = pow(matrix,n);

        System.out.println(result[0][1]);

    }

    public static long[][] pow(long[][] matrix, long exp){
        if(exp==1){
            return matrix;
        }

        long[][] half = pow(matrix,exp/2);
        long[][] result = multiply(half,half);

        if(exp%2==1){
            result=multiply(result,matrix);
        }

        return result;
    }

    public static long[][] multiply(long[][]o1, long[][]o2){
        long [][] ret = new long[2][2];
        ret[0][0] = (o1[0][0]*o2[0][0]+o1[0][1]*o2[1][0])%MOD;
        ret[0][1] = (o1[0][0]*o2[0][1]+o1[0][1]*o2[1][1])%MOD;
        ret[1][0] = (o1[1][0]*o2[0][0]+o1[1][1]*o2[1][0])%MOD;
        ret[1][1] = (o1[1][0]*o2[0][1]+o1[1][1]*o2[1][1])%MOD;

        return ret;
    }
}
