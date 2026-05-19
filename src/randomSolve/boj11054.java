package randomSolve;

//째 줄에 수열 A의 크기 N이 주어지고, 둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ N ≤ 1,000, 1 ≤ Ai ≤ 1,000)
//제한시간 1초
//내 생각엔 dp로 푸는 문제인 것 같다.
//10
//1 5 2 1 4 3 4 5 2 1

//dp로 푼다면 점화식을 어떻게 정의할건데?
// 떠오르는게 없는데..

//증가~하는 방식과 감소하는 케이스를 나눠서 해야겟지?
//뭐든 알고리즘을 풀떄에는 개념을 단순화해서 정의한 후에 푸는것이 적절하다.

//dp[i] i번째까지의 바이토닉 수열의 최대 길이
//i번째 원소를 기준으로 좌,우를 뒤지면 되는거 아님?
//왼쪽기준,
//.. 근데 ㅇㅈㄹ로 하면,
//N개에 원소에 대해, N번의 탐색을 하면 된다? -> N^2
// 근데 뭐, 어떤식으로 해야, 이게 감소가되고, 그런걸 확인하지?

//감소하는 방향에서 이걸 어떻게 처리하느냐가 더 중요한거같은게
//만약 내가 원소가 더 크다하면, 왼쪽으로의 바이토닉수열의 최대길이를 왼쪽꺼에서 받아서 더하면 될거같음
//dp[i]=dp[i-1]+1

//바이토닉수열의 최대길이를 어떤 로직으로 구하는가? << 이게 문제임.
//왼쪽, 오른쪽 기준으로 구하는데,
//왼쪽은
//A[j]<A[i] && dp[i]<dp[j]+1 조건이 맞으면
//dp[i]=dp[j]+1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int[] leftDp = new int[N];
        int[] rightDp = new int[N];

        for(int i=0; i<N; i++){
            leftDp[i]=1;
            for(int j=0; j<i; j++) {
                if (arr[j] < arr[i] && leftDp[i] < leftDp[j] + 1) {
                    leftDp[i] = leftDp[j] + 1;
                }
            }
        }

        for(int i=N-1; i>=0; i--){
            rightDp[i]=0;
            for(int j=N-1; j>i; j--) {
                if (arr[j] < arr[i] && rightDp[i] < rightDp[j] + 1) {
                    rightDp[i] = rightDp[j] + 1;
                }
            }
        }

        int max=Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            max = Math.max(leftDp[i]+rightDp[i],max);
        }

        System.out.println(max);

    }
}
