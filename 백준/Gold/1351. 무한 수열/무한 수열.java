import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static long N,P,Q;
    static Map<Long, Long> memo = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());

        long ans = func(N);
        System.out.println(ans);
    }
    static long func(long n){
        if (n==0) return 1;

        if(memo.containsKey(n)) return memo.get(n);

        long result = func(n/P)+func(n/Q);
        memo.put(n,result);

        return result;
    }
}

//P,Q값이 뭔가 규칙을 연관짓는 요소일까?
//P가 2라면, 2,4,6,8단위로 값이 바뀜
//Q가 3이면, 3,6,9단위로 바뀜
//N이 1조라서, N횟수만큼 하나씩 계산하면 시간초과가 난다.

//P와 Q의 변화주기를 관계로 규칙을 찾아내야한다.
//A7 = A3+A2
//A3 = A1+A1+A1+A0
//분할정복을 이용해서 쪼개서 계산할 수 있을듯
//A0+A0
//분할정복으로 풀어보자그럼


//풀이
//int func(n)
//if(n==1) return 1
//sum = func(n/P)+func(n/Q);
//return sum;

//-> 시간초과가 났다.
//보니까 중복된 부분에 대해서 계산을 하는것같음.
//그럼 분할정복을 하되, 이미 계산된 부분에 대해서 처리를 해주면 되지 않을까?
