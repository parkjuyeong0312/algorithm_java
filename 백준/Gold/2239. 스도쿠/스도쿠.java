import java.util.*;
import java.lang.*;
import java.io.*;

//스도쿠의 원리를 이해해야될 것 같음.
//9*9라는 크기, 100으로 대충 잡는다고 쳐도. 
//뭔가 브루투포스, 깡구현으로 풀어야되는 문제인가? 그런 생각이 든다.

//3*3 크기 내에서도 점검을 한번 해야하고,
//행에서도 점검을 해야한다.

//사전식으로 앞서는 것을 출력한다고 했다.
//그렇다면, 뭐 숫자를 앞에서부터 순차적으로 검사해가면서, 풀면 되지 않을까 그런 생각이 든다.

//시간복잡도를 대충 계산해보자.
//만약 모든 칸에 대해, 0으로 채워져있다고하면,

//1. 3*3칸에 대해 검사를 해야하고, 
//2. 행에 대해서도 검사를 해야하는데, 행, 열 둘다 검사를 해야한다.

//근데 3*3에 대해서는, hashSet으로 해서 관리해도 될 거 같긴하다.
//행과 열에 대해서도 관리해도 되려나?
//굳이 이걸 계속해서 반복할 필요는 없다고 생각한다.

//그러면 시간복잡도는, 81칸에 대해서 일단 수행해야하고,
//각 칸별로, set을 하는거니까, 81*(9+9+9) => 대략 1000이니까 충분하지 않나 싶다.

//이건 브루트포스 문제이다.

// The main method must be in a class named "Main".
class Main {
    static int N = 9;
    static int D;
    static ArrayList<int[]> zeroPoint;
    static HashSet<Integer>[] row;
    static HashSet<Integer>[] col;
    static HashSet<Integer>[] rect;
    static int[][] graph; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        graph = new int[N][N];

        //row
        //col
        //rectangle
        row = new HashSet[N];
        col = new HashSet[N];
        rect = new HashSet[N];

        for(int i=0; i<N; i++){
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            rect[i] = new HashSet<>();
        }


        zeroPoint = new ArrayList<>();

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                int unit = Integer.parseInt(str.charAt(j)+"");
                graph[i][j]=unit;//[에러]char는 String으로 전환될 수 없다.

                if(unit ==0){
                    zeroPoint.add(new int[]{i,j});
                    continue;
                }
                row[i].add(unit);
                col[j].add(unit);

                rect[i/3*3+j/3].add(unit);
                
            }
        }

        // System.out.println(rect[0]);.

        //백트래킹으로 풀어야한다.

        D = zeroPoint.size();

        //우선 맨 처음 좌표를 찍어야겟지?
        func(0);

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sb.append(graph[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
        
    }
    
    static boolean func(int dept){
        if(dept == D) {
            return true;
        }

        int[] pos = zeroPoint.get(dept);
        int x = pos[0];
        int y = pos[1];

        for(int i=1;i<=N; i++){
            //백트래킹은 안하나요?
            if(row[x].contains(i)) continue;
            if(col[y].contains(i)) continue;
            if(rect[x/3*3+y/3].contains(i)) continue;

            row[x].add(i);
            col[y].add(i);
            rect[x/3*3+y/3].add(i);
            graph[x][y]=i;
            if(func(dept+1)) return true;
            row[x].remove(i);
            col[y].remove(i);
            rect[x/3*3+y/3].remove(i);
            graph[x][y]=0;
        }
        return false;
    }

}



                // for(int k=1; k<=N; k++){
                //     if(row[i].contains(k)) continue;
                //     if(col[j].contains(k)) continue;
                //     if(rect[i/3*3+j/3].contains(k)) continue;

                //     row[i].add(k);
                //     col[j].add(k);
                //     rect[i/3*3+j/3].add(k);
                //     graph[i][j]=k;
                    
                //     break;




















