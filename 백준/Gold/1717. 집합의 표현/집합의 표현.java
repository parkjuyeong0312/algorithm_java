import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] parents;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //부모 집합
        parents = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parents[i] = i; // 부모는 자기자신으로 초기화
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            switch (type) {
                case 0:
                    union(a, b);
                    break;
                case 1:
                    isSameGruop(a, b);
                    break;
            }
        }

        System.out.println(sb);
    }



    static void isSameGruop(int a, int b){
        if(find(a)==find(b)) sb.append("YES").append("\n");
        else sb. append("NO").append("\n");
    }

    static int find(int a){
        if(parents[a]==a) return a;
        return parents[a]=find(parents[a]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b) parents[b] = a;
    }
}
