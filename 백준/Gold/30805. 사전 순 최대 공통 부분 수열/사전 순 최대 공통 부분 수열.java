import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> A = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) A.add(Integer.parseInt(st.nextToken()));

        int M = Integer.parseInt(br.readLine());
        List<Integer> B = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) B.add(Integer.parseInt(st.nextToken()));

        List<Integer> result = new ArrayList<>();

        while (true) {
            int maxVal = -1;
            int nextA = -1;
            int nextB = -1;

            // 현재 남은 A와 B에서 공통으로 가질 수 있는 가장 큰 값 찾기
            // 사전 순 최대이므로 무조건 큰 숫자부터 골라야 함
            for (int i = 0; i < A.size(); i++) {
                for (int j = 0; j < B.size(); j++) {
                    if (A.get(i).equals(B.get(j))) {
                        if (A.get(i) > maxVal) {
                            maxVal = A.get(i);
                            nextA = i;
                            nextB = j;
                        }
                    }
                }
            }

            // 더 이상 공통 원소가 없으면 종료
            if (maxVal == -1) break;

            result.add(maxVal);
            
            // 찾은 원소의 다음 인덱스부터 수열을 잘라냄 (순서 유지)
            A = A.subList(nextA + 1, A.size());
            B = B.subList(nextB + 1, B.size());
        }

        // 출력
        System.out.println(result.size());
        if (!result.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int val : result) sb.append(val).append(" ");
            System.out.println(sb.toString().trim());
        }
    }
}