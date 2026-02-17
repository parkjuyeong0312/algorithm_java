import java.util.*;
import java.lang.*;
import java.io.*;

// 동전
 
// 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
// 1 초	128 MB	18484	12435	10080	68.210%
// 문제
// 우리나라 화폐단위, 특히 동전에는 1원, 5원, 10원, 50원, 100원, 500원이 있다.
//이 동전들로는 정수의 금액을 만들 수 있으며 그 방법도 여러 가지가 있을 수 있다.
//예를 들어, 30원을 만들기 위해서는 1원짜리 30개 또는 10원짜리 2개와 5원짜리 2개 등의 방법이 가능하다.

// 동전의 종류가 주어질 때에 주어진 금액을 만드는 모든 방법을 세는 프로그램을 작성하시오.

// 입력
// 입력의 첫 줄에는 테스트 케이스의 개수 T(1 ≤ T ≤ 10)가 주어진다.
//각 테스트 케이스의 첫 번째 줄에는 동전의 가지 수 N(1 ≤ N ≤ 20)이 주어지고
//두 번째 줄에는 N가지 동전의 각 금액이 오름차순으로 정렬되어 주어진다.
//각 금액은 정수로서 1원부터 10000원까지 있을 수 있으며 공백으로 구분된다.
//세 번째 줄에는 주어진 N가지 동전으로 만들어야 할 금액 M(1 ≤ M ≤ 10000)이 주어진다.

// 편의를 위해 방법의 수는 231 - 1 보다 작고, 같은 동전이 여러 번 주어지는 경우는 없다.

// 출력
// 각 테스트 케이스에 대해 입력으로 주어지는 N가지 동전으로 금액 M을 만드는 모든 방법의 수를 한 줄에 하나씩 출력한다.

//D[i][j]=i번째 동전까지 썼을 때, j원을 만드는 방법의 수
//i번째 동전을 0개 쓴경우, 1개쓴 경우, 2개쓴 경우 ,,,,,
//i번째 동전을 0개 쓴경우(i번째 동전을 사용하지 않는경우) : D[i-1][j],이전거를 그대로 가져옴.
//i번째 동전을 1개 쓴경우 : D[i-1][j-c[i]], 이전단계에서, 가치만큼 뺀거를 그대로 가져옴.


// 예제 입력 1 
// 3
// 2
// 1 2
// 1000
// 3
// 1 5 10
// 100
// 2
// 5 7
// 22
// 예제 출력 1 
// 501
// 121
// 1

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while(T-- >0){
            int N = Integer.parseInt(br.readLine());
            
            int[] coins = new int[N+1];//i번째 코인이므로 1부터 시작
            
            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=N;i++){
                coins[i]=Integer.parseInt(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());

            int[][] dp = new int[N+1][M+1];

            //i번째까지의 동전으로 j원을 만드는 경우의수
            for(int i=0; i<=N; i++){
                dp[i][0] = 1;//0원을 만드는 경우의 수는 1임. "사용하지 않는다."
            }

            for(int i=1; i<=N; i++){
                int curCoin = coins[i];
                for(int j=0; j<=M; j++){
                    dp[i][j]=dp[i-1][j];//동전을 사용하지 않았을 때

                    if(j>=curCoin){
                        dp[i][j]+=dp[i][j-curCoin];
                    }
                }
            }
            System.out.println(dp[N][M]);
        }
    }
}

