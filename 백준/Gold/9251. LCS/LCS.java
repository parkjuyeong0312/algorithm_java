
//LCS

//문제
//LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때,
//모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.
//예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.
//
//입력
//첫째 줄과 둘째 줄에 두 문자열이 주어진다. 문자열은 알파벳 대문자로만 이루어져 있으며, 최대 1000글자로 이루어져 있다.
//
//출력
//첫째 줄에 입력으로 주어진 두 문자열의 LCS의 길이를 출력한다.
//
//예제 입력
//ACAYKP
//CAPCAK
//예제 출력
//4

//A의 i번째 글자를 쓸까?
//B의 j번째 글자를 쓸까?

//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = br.readLine();
        String secondLine = br.readLine();

        int firstlen = firstLine.length();
        int secondlen = secondLine.length();

        //dp[i][j]=firstLine의 앞에서부터 i글자와 secondLine의 앞에서부터 j글자의 LCS길이
        int[][] dp = new int[firstlen+1][secondlen+1];

        for(int i=1; i<=firstlen; i++){
            for(int j=1; j<=secondlen; j++){
                if(firstLine.charAt(i-1) == secondLine.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                dp[i][j]=Math.max(dp[i][j], Math.max(dp[i-1][j],dp[i][j-1]));
            }
        }

        System.out.println(dp[firstlen][secondlen]);
    }
}
