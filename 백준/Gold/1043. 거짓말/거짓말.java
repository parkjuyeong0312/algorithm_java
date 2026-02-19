
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 1. 초기화: 자기 자신을 부모로 가짐
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        st = new StringTokenizer(br.readLine());
        int trueNum = Integer.parseInt(st.nextToken());
        int[] truePeople = new int[trueNum];
        for (int i = 0; i < trueNum; i++) {
            truePeople[i] = Integer.parseInt(st.nextToken());
        }

        // 2. 파티 정보를 저장하고, 같은 파티원끼리 union
        ArrayList<Integer>[] parties = new ArrayList[M];
        for (int i = 0; i < M; i++) {
            parties[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int partySize = Integer.parseInt(st.nextToken());
            
            int firstPerson = -1;
            if (partySize > 0) {
                firstPerson = Integer.parseInt(st.nextToken());
                parties[i].add(firstPerson);
            }

            for (int j = 1; j < partySize; j++) {
                int nextPerson = Integer.parseInt(st.nextToken());
                parties[i].add(nextPerson);
                union(firstPerson, nextPerson); // 한 파티에 있는 사람들을 하나의 집합으로 묶음
            }
        }

        // 3. 각 파티를 돌며 거짓말을 할 수 있는지 체크
        int ans = 0;
        for (int i = 0; i < M; i++) {
            boolean canLie = true;
            for (int person : parties[i]) {
                if (isConnectedToTrue(person, truePeople)) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) ans++;
        }

        System.out.println(ans);
    }

    // 진실을 아는 사람 중 한 명이라도 같은 집합에 있는지 확인
    static boolean isConnectedToTrue(int person, int[] truePeople) {
        int root = find(person);
        for (int truePerson : truePeople) {
            if (root == find(truePerson)) return true;
        }
        return false;
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) parent[y] = x;
    }
}