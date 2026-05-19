package randomSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj10830 {
    static int N;
    static long B; // B는 최대 1000억이므로 long 필수
    static int MOD = 1000;
    static int[][] origin; // 초기 행렬 저장용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        origin = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                // B=1일 때를 대비해 미리 1000으로 나눈 나머지를 저장
                origin[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        // 분할 정복을 이용한 행렬 제곱 시작
        int[][] result = pow(origin, B);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    // 행렬 거듭제곱 함수 (분할 정복)
    static int[][] pow(int[][] A, long exp) {
        // 지수가 1이면 그대로 반환
        if (exp == 1L) {
            return A;
        }

        // 지수를 절반으로 나누어 재귀 호출
        int[][] half = pow(A, exp / 2);

        // half * half 계산 (A^(exp/2) * A^(exp/2))
        int[][] res = multiply(half, half);

        // 지수가 홀수라면 원본 행렬(A)을 한 번 더 곱해줌
        if (exp % 2 == 1L) {
            res = multiply(res, origin);
        }

        return res;
    }

    // 두 행렬을 곱하는 함수
    static int[][] multiply(int[][] m1, int[][] m2) {
        int[][] temp = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    // (m1의 i행 k열) * (m2의 k행 j열)
                    temp[i][j] += m1[i][k] * m2[k][j];
                    temp[i][j] %= MOD; // 연산 중간중간 나머지 계산
                }
            }
        }
        return temp;
    }
}