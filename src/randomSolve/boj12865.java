package randomSolve;
//문제
//이 문제는 아주 평범한 배낭에 관한 문제이다.
//한 달 후면 국가의 부름을 받게 되는 준서는 여행을 가려고 한다.
//세상과의 단절을 슬퍼하며 최대한 즐기기 위한 여행이기 때문에, 가지고 다닐 배낭 또한 최대한 가치 있게 싸려고 한다.

//준서가 여행에 필요하다고 생각하는 N개의 물건이 있다. 각 물건은 무게 W와 가치 V를 가지는데, 해당 물건을 배낭에 넣어서 가면 준서가 V만큼 즐길 수 있다. 아직 행군을 해본 적이 없는 준서는 최대 K만큼의 무게만을 넣을 수 있는 배낭만 들고 다닐 수 있다. 준서가 최대한 즐거운 여행을 하기 위해 배낭에 넣을 수 있는 물건들의 가치의 최댓값을 알려주자.
//입력
//첫 줄에 물품의 수 N(1 ≤ N ≤ 100)과 준서가 버틸 수 있는 무게 K(1 ≤ K ≤ 100,000)가 주어진다.
// 두 번째 줄부터 N개의 줄에 거쳐 각 물건의 무게 W(1 ≤ W ≤ 100,000)와 해당 물건의 가치 V(0 ≤ V ≤ 1,000)가 주어진다.
//입력으로 주어지는 모든 수는 정수이다.
//
//        출력
//한 줄에 배낭에 넣을 수 있는 물건들의 가치합의 최댓값을 출력한다.
//dp 아니면 그리디로 풀수 있는 문제같다.
//일단 제한 무게가 있기때문에, 무게가 작은순으로 정렬하는게 맞는거같다.
//무게가 작다면, 기왕이면 가치가 큰게 좋겠지?
//근데 무게가 같은게 있으먄 어떡하지? 서로다른 무게라는 그런 조건은 없잔항.
//뭔가 이전꺼랑 더했을때랑, 뭐 현재가치가 큰지 비교를 해야될거같기도 하고

//value가 큰 순서대로 하되, 무게가 오바되면 패스하는식이 맞지 않나?
//근데 합쳤을때 또, 더 클 수 있잖아.
//재귀는 아니야 일단 2^100의 복잡도가 나오니까
//그리디는 아니고 ,dp로 풀수있다는데,

//음..
//점화식 정의
//D[i]


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] w = new int[N];
        int[] v = new int[N];

        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            w[i]= Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        //무게가 K까지니까.
        int[][] dp = new int[N][K+1];
        //i: i번째 물건
        //j : 배낭의 max무게
        //i번째 물건을 넣은 max가 j일때의 배낭의 무게
        for(int i=0; i<N; i++){
            for(int j=1; j<=K; j++){
                //물건 i를 안넣는경우(초기화)
                if(i-1>=0){
                    dp[i][j]=dp[i-1][j];
                }
                //현재 물건 i를 배낭에 넣는경우
                if(j-w[i]>=0){
                    if(i-1>=0){//현재 값, 이전 단계에서 내 무게만큼 뺀 값+ 내 가치
                        dp[i][j]=Math.max(dp[i][j],dp[i-1][j-w[i]]+v[i]);
                    }
                    else{
                        //첫번째 물건인 경우 무게가 허용되면 바로 넣음.
                        dp[i][j]=v[i];
                    }
                }
            }
        }

        System.out.println(dp[N-1][K]);

    }
}








