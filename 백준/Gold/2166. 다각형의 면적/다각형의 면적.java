import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        long[] x = new long[N + 1];
        long[] y = new long[N + 1];
        
        for (int i = 0; i < N; i++) {
            x[i] = sc.nextLong();
            y[i] = sc.nextLong();
        }
        
        // 마지막에 첫 번째 좌표 추가
        x[N] = x[0];
        y[N] = y[0];
        
        long sumA = 0;
        long sumB = 0;
        
        for (int i = 0; i < N; i++) {
            sumA += x[i] * y[i + 1];
            sumB += y[i] * x[i + 1];
        }
        
        double area = Math.abs(sumA - sumB) / 2.0;
        System.out.printf("%.1f\n", area);
    }
}