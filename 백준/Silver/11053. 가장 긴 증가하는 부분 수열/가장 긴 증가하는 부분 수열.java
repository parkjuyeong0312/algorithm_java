//가장 긴 증가하는 부분 수열
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	256 MB	210143	86654	57434	39.005%
//문제
//수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.
//
//예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.
//
//입력
//첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.
//
//둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)
//
//출력
//첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.
//
//예제 입력 1
//        6
//        10 20 10 30 20 50
//예제 출력 1
//        4

//부분적으로 증가하는 수열
//정렬?
//dp로 풀수있을까?
//->생각은 안나네..
//다음 = 이전 +1꼴일거 같긴한데..
//나보다 바로 아래로 작은놈을 어떻게 찾지?
//최댓값?
//근데 N값이 1000이니까, N^2을 해도 여유로울것 같다.
//재귀로하면 터짐 2^1000이니까

//답은 dp다!
//테이블 정의 : i번째 원소를 최대값으로 갖는 증가 부분수열의 최대길이
//점화식 : dp[i] = max(dp[i], dp[j]+1)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];
        int[] arr= new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int ans =0;
        for(int i=0; i<N; i++){
            dp[i]=1;
            for(int j=0; j<i; j++){
                if(arr[j]<arr[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            ans = Math.max(ans,dp[i]);
        }

        System.out.println(ans);

    }

}
