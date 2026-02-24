
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long B; 
    static int MOD = 1000;
    static int[][] origin; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        origin = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        int[][] result = pow(origin, B);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static int[][] pow(int[][] A, long exp) {
        if (exp == 1L) {
            return A;
        }

        int[][] half = pow(A, exp / 2);

        int[][] res = multiply(half, half);

        if (exp % 2 == 1L) {
            res = multiply(res, origin);
        }

        return res;
    }

    static int[][] multiply(int[][] m1, int[][] m2) {
        int[][] temp = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    temp[i][j] += m1[i][k] * m2[k][j];
                    temp[i][j] %= MOD; // 연산 중간중간 나머지 계산
                }
            }
        }
        return temp;
    }
}