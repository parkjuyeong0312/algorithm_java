package randomSolve;

//문제
//N줄에 0 이상 9 이하의 숫자가 세 개씩 적혀 있다. 내려가기 게임을 하고 있는데,
//이 게임은 첫 줄에서 시작해서 마지막 줄에서 끝나게 되는 놀이이다.
//먼저 처음에 적혀 있는 세 개의 숫자 중에서 하나를 골라서 시작하게 된다.
//그리고 다음 줄로 내려가는데, 다음 줄로 내려갈 때에는 다음과 같은 제약 조건이 있다.
// 바로 아래의 수로 넘어가거나, 아니면 바로 아래의 수와 붙어 있는 수로만 이동할 수 있다는 것이다. 이 제약 조건을 그림으로 나타내어 보면 다음과 같다.
//
//별표는 현재 위치이고, 그 아랫 줄의 파란 동그라미는 원룡이가 다음 줄로 내려갈 수 있는 위치이며,
//빨간 가위표는 원룡이가 내려갈 수 없는 위치가 된다.
//숫자표가 주어져 있을 때, 얻을 수 있는 최대 점수, 최소 점수를 구하는 프로그램을 작성하시오.
//점수는 원룡이가 위치한 곳의 수의 합이다.
//입력
//첫째 줄에 N(1 ≤ N ≤ 100,000)이 주어진다.
//다음 N개의 줄에는 숫자가 세 개씩 주어진다.
//숫자는 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 중의 하나가 된다.
//
//출력
//첫째 줄에 얻을 수 있는 최대 점수와 최소 점수를 띄어서 출력한다.
//
//예제 입력
//        3
//        1 2 3
//        4 5 6
//        4 9 0
//예제 출력
//        18 6


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//dp를 사용하는 문제인것같음.
//테이블 정의
// D[i] : 테이블의
//D[i][0] =
//D[i][1] =
public class boj2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] lines = new int[N+1][5];
        StringTokenizer st;

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            lines[i][1]=Integer.parseInt(st.nextToken());
            lines[i][2]=Integer.parseInt(st.nextToken());
            lines[i][3]=Integer.parseInt(st.nextToken());
        }

        int[][] dpMin = new int[N+1][5];
        int[][] dpMax = new int[N+1][5];

        for(int i=1; i<=N; i++){
            Arrays.fill(dpMin[i],900001);
            Arrays.fill(dpMax[i],-1);
        }

        //맨 처음 값을 어떻게 초기화할까?
        //왜냐하면, 최소 최대를 각각 초기화를 해야할 것 같은데
        dpMin[1][1]=lines[1][1];
        dpMin[1][2]=lines[1][2];
        dpMin[1][3]=lines[1][3];

        dpMax[1][1]=lines[1][1];
        dpMax[1][2]=lines[1][2];
        dpMax[1][3]=lines[1][3];


        for(int i=2; i<=N; i++){
            for(int j=1; j<=3; j++){
                for(int k=-1; k<=1;k++) {
                    dpMin[i][j] = Math.min(dpMin[i - 1][j + k]+lines[i][j], dpMin[i][j]);
                    dpMax[i][j] = Math.max(dpMax[i - 1][j + k] +lines[i][j], dpMax[i][j]);
                }
            }
        }

        int max = -1;
        int min = 900001;

        for(int i=1; i<=3; i++){
            max = Math.max(dpMax[N][i],max);
            min = Math.min(dpMin[N][i],min);
        }
        System.out.println(max + " " + min);
    }
}





























