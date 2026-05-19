package randomSolve;

//A → B
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	512 MB	78168	32976	25921	40.490%
//문제
//정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다.
//
//        2를 곱한다.
//        1을 수의 가장 오른쪽에 추가한다.
//A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자.
//
//        입력
//첫째 줄에 A, B (1 ≤ A < B ≤ 109)가 주어진다.
//
//출력
//A를 B로 바꾸는데 필요한 연산의 최솟값에 1을 더한 값을 출력한다. 만들 수 없는 경우에는 -1을 출력한다.
//
//예제 입력 1
//        2 162
//예제 출력 1
//        5
//        2 → 4 → 8 → 81 → 162
//
//예제 입력 2
//        4 42
//예제 출력 2
//        -1
//예제 입력 3
//        100 40021
//예제 출력 3
//        5
//        100 → 200 → 2001 → 4002 → 40021

//이건 그냥, 재귀로 푸는걸까. 2초이고,
//10^9이니까 뭐 1억 까지 값이 나올 수 있는건데
//뭔가 2를 곱하거나 10*x +1꼴이니까
//2가 10^9까지 하는건 생각해보면, 2^36정도 된다고 생각해보면,
//36번만에 어쨋든 max값까지 도달가능하다는거고,
//10*x+1같은 경우에도, 9번만에 도달가능하다.
//어쨋든 최악의 경우를 생각해도, 2억이나 들만큼의 연산을 하지 않는다는 거고,
//재귀로 풀면 될거같다.-> 중복되는 경우가 발생할까? -> 발생할 수도 있는데 고려해야할까?

//일단풀어보자

//


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj16953 {
    static long A,B;
    static long min= Long.MAX_VALUE;
    static boolean isChange = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        func(A, 0);

        if(isChange){
            System.out.println(min+1);
        }else{
            System.out.println(-1);
        }
    }

    static void func(long num, int count){
        if(num == B){
            min = Math.min(count,min);
            isChange = true;
            return;
        }
        if(num>B) return;
        func(num*2,count+1);
        func(num*10+1,count+1);
    }
}
