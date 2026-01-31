package randomSolve;
//2 초	256 MB	75052	27474	20027	34.959%
//문제
//인재 선발 시험은 1차 서류심사와 2차 면접시험으로 이루어진다.
//그래서 진영 주식회사는, 다른 모든 지원자와 비교했을 때 서류심사 성적과 면접시험 성적 중 적어도 하나가 다른 지원자보다 떨어지지 않는 자만 선발한다는 원칙을 세웠다.
//즉, 어떤 지원자 A의 성적이 다른 어떤 지원자 B의 성적에 비해 서류 심사 결과와 면접 성적이 모두 떨어진다면 A는 결코 선발되지 않는다.
//
//이러한 조건을 만족시키면서, 진영 주식회사가 이번 신규 사원 채용에서 선발할 수 있는 신입사원의 최대 인원수를 구하는 프로그램을 작성하시오.
//
//=입력
//첫째 줄에는 테스트 케이스의 개수 T(1 ≤ T ≤ 20)가 주어진다.
//각 테스트 케이스의 첫째 줄에 지원자의 숫자 N(1 ≤ N ≤ 100,000)이 주어진다.
//둘째 줄부터 N개 줄에는 각각의 지원자의 서류심사 성적, 면접 성적의 순위가 공백을 사이에 두고 한 줄에 주어진다.
//두 성적 순위는 모두 1위부터 N위까지 동석차 없이 결정된다고 가정한다.
//
//출력
//각 테스트 케이스에 대해서 진영 주식회사가 선발할 수 있는 신입사원의 최대 인원수를 한 줄에 하나씩 출력한다.
//10 000 000 000
//그냥 계산하면 터짐.
//20억나옴
//O(T*N^2)+O(NlogN)

//1. 우선 정렬을 하고
//2. dp처럼 최솟값을 구함.
//3. 그리고 그 최솟값을 dp에 저장해놓고 비교함.
//그럼 복잡도가
//NlogN + N+ N 이니까 가능


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//예제 입력
//        2
//        5
//        3 2
//        1 4
//        4 1
//        2 3
//        5 5
//        7
//        3 6
//        7 3
//        4 2
//        1 4
//        5 7
//        2 5
//        6 1
//예제 출력
//        4
//        3
public class boj1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr;
        int[] dp;

        StringBuilder sb = new StringBuilder();

        //테스트 수만큼 반복
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(br.readLine());
            arr=new int[N][2];
            dp = new int[N];
            for(int j = 0; j<N; j++){
                st = new StringTokenizer(br.readLine());
                arr[j][0]=Integer.parseInt(st.nextToken());
                arr[j][1]=Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr,(a,b)->{return a[0]-b[0];
            });

            int min = Integer.MAX_VALUE;

            for(int j=0; j<N; j++){
                min=Math.min(arr[j][1],min);
                dp[j]=min;
            }
            int count =1;

            for(int j=1; j<N; j++){
                if(dp[j-1]>arr[j][1]) count+=1;
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);

    }
}
