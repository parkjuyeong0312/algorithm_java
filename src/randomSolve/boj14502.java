package randomSolve;
//연구소
//
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	512 MB	125505	73943	41604	56.406%
//문제
//인체에 치명적인 바이러스를 연구하던 연구소에서 바이러스가 유출되었다. 다행히 바이러스는 아직 퍼지지 않았고, 바이러스의 확산을 막기 위해서 연구소에 벽을 세우려고 한다.
//
//연구소는 크기가 N×M인 직사각형으로 나타낼 수 있으며, 직사각형은 1×1 크기의 정사각형으로 나누어져 있다. 연구소는 빈 칸, 벽으로 이루어져 있으며, 벽은 칸 하나를 가득 차지한다.
//
//일부 칸은 바이러스가 존재하며, 이 바이러스는 상하좌우로 인접한 빈 칸으로 모두 퍼져나갈 수 있다. 새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 한다.
//
//예를 들어, 아래와 같이 연구소가 생긴 경우를 살펴보자.
//
//2 0 0 0 1 1 0
//0 0 1 0 1 2 0
//0 1 1 0 1 0 0
//0 1 0 0 0 0 0
//0 0 0 0 0 1 1
//0 1 0 0 0 0 0
//0 1 0 0 0 0 0
//이때, 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 곳이다. 아무런 벽을 세우지 않는다면, 바이러스는 모든 빈 칸으로 퍼져나갈 수 있다.
//
//2행 1열, 1행 2열, 4행 6열에 벽을 세운다면 지도의 모양은 아래와 같아지게 된다.
//
//2 1 0 0 1 1 0
//1 0 1 0 1 2 0
//0 1 1 0 1 0 0
//0 1 0 0 0 1 0
//0 0 0 0 0 1 1
//0 1 0 0 0 0 0
//0 1 0 0 0 0 0
//바이러스가 퍼진 뒤의 모습은 아래와 같아진다.
//
//2 1 0 0 1 1 2
//1 0 1 0 1 2 2
//0 1 1 0 1 2 2
//0 1 0 0 0 1 2
//0 0 0 0 0 1 1
//0 1 0 0 0 0 0
//0 1 0 0 0 0 0
//벽을 3개 세운 뒤, 바이러스가 퍼질 수 없는 곳을 안전 영역이라고 한다. 위의 지도에서 안전 영역의 크기는 27이다.
//
//연구소의 지도가 주어졌을 때 얻을 수 있는 안전 영역 크기의 최댓값을 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 지도의 세로 크기 N과 가로 크기 M이 주어진다. (3 ≤ N, M ≤ 8)
//
//둘째 줄부터 N개의 줄에 지도의 모양이 주어진다. 0은 빈 칸, 1은 벽, 2는 바이러스가 있는 위치이다. 2의 개수는 2보다 크거나 같고, 10보다 작거나 같은 자연수이다.
//
//빈 칸의 개수는 3개 이상이다.
//
//출력
//첫째 줄에 얻을 수 있는 안전 영역의 최대 크기를 출력한다.
//
//예제 입력 1
//7 7
//2 0 0 0 1 1 0
//0 0 1 0 1 2 0
//0 1 1 0 1 0 0
//0 1 0 0 0 0 0
//0 0 0 0 0 1 1
//0 1 0 0 0 0 0
//0 1 0 0 0 0 0
//예제 출력 1
//27


//시간의 개념이 필요할까?
//안전영역의 크기의 최댓값을 구해야한다.

//1.일단 3개의 지점에 벽을 놧다고 했을때, 브루트 포스로 되는지 해볼까?
//1을 아무데나 놓고,


//2. 벽을 기준으로 bfs?, 3개를 놓았을때, 넓이가 정해지는가?

//3. 그리디의 개념이 들어가는가?
//무조건적인 규칙이 잇나

//정답 : 안전 구역의 최대값

//그냥 다 해보는건?
//N=8, matrix = 64
//64의 세제곱 ->널널하게 잡아도 1 000 000
//그렇다면~ 세 점을 아무렇게나 잡고, max값을 구한다면~?
//될거같은데?1 000 000*3*bfs의 시간복잡도,10 000
//10_000_000_000 => 100억

//뭔가 아슬아슬한데, 내생각에 어떤 로직의 시간복잡도를 줄이면돼
// 벽세우는거에서 줄일수 있나?

//음 일단 바이러스에 대해서 bfs를 돌리고, 거기서 2가 퍼져나간 부분에 대해서만 벽을 세우는 건?
//좀 줄일수는 있겠다.

//그리고 벽을 세우는거에 대해서 중복은 어떡할건데?
//3개의 벽이 세워지는데 중복이 있을거아냐.
//그러게 이건 뭐 어케해야하지

//벽을 이을 필요는 없다.

//결론 1 : 벽을 세우는데에는 기준은 없다. 그냥 세워야된다.
//하지만, 기왕이면 2가 닿는 곳으로 하는게 좋다.
//그렇다고 하기엔, 이미 안전지역이 확보된상태에선 벽을 놓을수가 없다? -> 만약 그 수가 작다면, 그 만큼 빼면 되지않을 가 싶다.
//벽을 세우고, 그때마다 BFS를 돌려보자.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj14502 {
    static int N,M;
    static int[][] matrix;
    static int[] dx = new int[]{1,-1,0,0};
    static int[] dy = new int[]{0,0,1,-1};
    static int max = 0;

    static ArrayList<int[]> virusList, emptyList;

    static int totalBox;
    static int emptySize;


    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        matrix= new int[N][M];
        virusList = new ArrayList<>();
        emptyList = new ArrayList<>();


        //matrix 초기화
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int unit = Integer.parseInt(st.nextToken());
                if(unit == 2){
                    virusList.add(new int[]{i,j});
                }else if(unit == 0){
                    emptyList.add(new int[]{i,j});
                }
                matrix[i][j]=unit;
            }
        }

        totalBox = N*M;
        emptySize = emptyList.size();

        combination(0,0,new int[3]);

        System.out.println(max-3);
    }

    //emptyList에서 원소를 3개 골라야한다.
    //start : 어디 부터 뽑을건지 지정하는 부분
    //dept, 깊이를 지정, 3이면 3개의 조합을 뽑은것으로, return
    //selected : 어떤 원소를 골랐는지임. 이건 bfs를 돌리고, selected에 포함된 원소는 못가는 처리를 하면됨.


    //백트래킹으로 해야한다.
    //start, count, int[] selected
    static void combination(int start, int dept, int[] selected){
        if(dept==3){
            bfs(selected);
            return;
        }

        for(int i=start; i<totalBox; i++){
            int r = i/M;
            int c = i%M;

            if(matrix[r][c]!=0) continue;
            selected[dept]=i;
            combination(i+1,dept+1,selected);
        }

    }

    static void bfs(int[] selected){
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[][] virusVisited = new boolean[N][M];


        //virusList에서 pos를 꺼내서, 큐에 넣는다.
        for(int[] pos :virusList){
            int x = pos[0];
            int y = pos[1];

            dq.offer(pos);
            virusVisited[x][y]=true;
        }

        while(!dq.isEmpty()){
            int[] pos = dq.poll();
            for(int i=0; i<4; i++){
                int nx = pos[0]+dx[i];
                int ny = pos[1]+dy[i];

                if(nx<0||nx>=N||ny<0||ny>=M) continue;
                if(virusVisited[nx][ny]) continue;
                if(matrix[nx][ny]!=0) continue;
                boolean isWall=false;
                for(int j=0; j<3; j++){
                    int index = selected[j];
                    int row = index/M;
                    int col = index%M;
                    if(row==nx&&col==ny){
                        isWall=true;
                        break;
                    }
                }
                if(isWall) continue;

                virusVisited[nx][ny]=true;
                dq.offer(new int[]{nx,ny});
            }
        }

        int emptyCount=0;
        for(int i=0;i<N;i++){
            for(int j=0; j<M; j++){
                if(matrix[i][j]==0&&!virusVisited[i][j]){
                    emptyCount++;
                }
            }
        }

        max = Math.max(max,emptyCount);

    }

}
