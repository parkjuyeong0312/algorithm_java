
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R,C;
    static String[][] graph;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean visited[][];
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new String[R][C];
        visited = new boolean[R][C];

        for(int i=0; i<R; i++){
            String line = br.readLine();
            for(int j =0; j<C; j++){
                graph[i][j]=String.valueOf(line.charAt(j));
            }
        }

        func(0,0,"",0);

        System.out.println(max);
    }

    //DFS, 백트래킹을 사용하는 문제다.
    //백트래킹 어케하더라!

    static void func(int x, int y, String str,int dept){
        if(str.contains(graph[x][y])) return;

        str = str.concat(graph[x][y]);
        dept+=1;
        max = Math.max(max,dept);

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0||nx>=R||ny<0||ny>=C) continue;

            if(visited[nx][ny]) continue;

            visited[nx][ny]=true;
            func(nx,ny,str,dept);
            visited[nx][ny]=false;
        }
    }
}
