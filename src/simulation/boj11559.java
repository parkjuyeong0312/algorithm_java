package simulation;

//문제
//1.뿌요를 놓고 난 후, 같은 색 뿌요가 4개 이상 상하좌우로 연결되어 있으면 연결된 같은 색 뿌요들이 한꺼번에 없어진다. 이때 1연쇄가 시작된다.
//2.뿌요들이 없어지고 나서 위에 다른 뿌요들이 있다면, 역시 중력의 영향을 받아 차례대로 아래로 떨어지게 된다.
    //아래로 떨어지고 나서 다시 같은 색의 뿌요들이 4개 이상 모이게 되면 또 터지게 되는데, 터진 후 뿌요들이 내려오고 다시 터짐을 반복할 때마다 1연쇄씩 늘어난다.
//3.터질 수 있는 뿌요가 여러 그룹이 있다면 동시에 터져야 하고 여러 그룹이 터지더라도 한번의 연쇄가 추가된다.

//
//입력
//총 12개의 줄에 필드의 정보가 주어지며, 각 줄에는 6개의 문자가 있다.
//이때 .은 빈공간이고 .이 아닌것은 각각의 색깔의 뿌요를 나타낸다.
//R은 빨강, G는 초록, B는 파랑, P는 보라, Y는 노랑이다.
//입력으로 주어지는 필드는 뿌요들이 전부 아래로 떨어진 뒤의 상태이다. 즉, 뿌요 아래에 빈 칸이 있는 경우는 없다.
//
//출력
//현재 주어진 상황에서 몇연쇄가 되는지 출력한다. 하나도 터지지 않는다면 0을 출력한다.
//
//예제 입력
//        ......
//        ......
//        ......
//        ......
//        ......
//        ......
//        ......
//        ......
//        .Y....
//        .YG...
//        RRYG..
//        RRYGG.
//예제 출력
//        3

//1. 탐색
//2. 연쇄 함수
//3. 내리기 함수
//연쇄 -> 내리기 순으로 진행된다.

//1. 탐색
//탐색의 경우, 배열의 가장 아래에서 부터 시작한다.
//탐색의 경우 열단위로 열의 가장 아래 행에서 부터 시작하되, '.'을 만나면 탐색을 멈춘다.
//탐색은 bfs로 진행하며, 탐색 수가 count가 4가 넘어가면, true를 반환한다.

//2. 연쇄
//탐색이 true 라면, isBoom값을 true로 바꾼다. isBoom은 하나라도 탐색한 값이 true라면 값을 count+1하는 용도로 사용할 예정이다.
//연쇄를 일으키는데, 해당 값을 연쇄를 일으키고, 해당 문자값을 '*'으로 전환한다.

//3.내리기
//탐색처럼 열의 아래행에서 위 방향으로 진행한다.
//'*'을 만나면, gravityCount가 증가한다.
//'.'을 만나면 내리기를 종료한다.
//그 외의 뿌요 값을 만나면, gravityCount값 만큼 행을 내리고, 기존 값은  '.'으로 값을 초기화한다.


//탐색
//  1.폭발함
//내리기
//  2.폭발안함.
//끝!


//1. 탐색
//탐색의 경우, 배열의 가장 아래에서 부터 시작한다.
//탐색의 경우 열단위로 열의 가장 아래 행에서 부터 시작하되, '.'을 만나면 탐색을 멈춘다.
//탐색은 bfs로 진행하며, 탐색 수가 count가 4가 넘어가면, true를 반환한다.
//문제 : 탐색을 어떻게 할 것인가? 일일히 다 뒤져보기에는 너무 많이 뒤진다.
//visited[ROW][COL]
//isBoom=false
//for(int i=ROW-1; i>=0; i--)
//for(int j=0; j<COL; j++){
//if(graph[i][j]=='.') continue;
//if(visited[i][j]) continue;
//if(detect(i,j))
//isBoom=true
//boom(i,j)
//}
//}
//if(isBoom){
//for(int i=0; i<COL; i++){
//down(i)
//count ++;
//

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;


public class boj11559 {
    static int ROW = 12;
    static int COL = 6;
    static char[][] graph = new char[ROW][COL];
    static int boomCount;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<ROW; i++){
            graph[i] = br.readLine().toCharArray();
        }

//        for(int i=0;i<ROW;i++){
//            System.out.println(Arrays.toString(graph[i]));
//        }

        boolean isBoom=true;

        while(isBoom){
            boolean[][] visited = new boolean[ROW][COL];
            isBoom = false;

            for(int j=0; j<COL; j++){
                for(int i=ROW-1; i>=0; i--){
                    if(graph[i][j]=='.') break;
                    if(visited[i][j]) continue;
                    if(detected(i,j,visited)){
                        isBoom=true;
                        boom(i,j);
                    }
                }
            }
            if(isBoom){
                down();
                boomCount++;
            }
        }

        System.out.println(boomCount);

    }

    static boolean detected(int startX, int startY, boolean[][] visited){
        Deque<int[]> queue = new ArrayDeque<>();

        visited[startX][startY]=true;
        queue.offer(new int[]{startX,startY});

        char target = graph[startX][startY];
        int count = 1;

        while(!queue.isEmpty()){
            int[] unit = queue.poll();
            int x = unit[0];
            int y = unit[1];

            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx<0||nx>=ROW||ny<0||ny>=COL) continue;

                if(visited[nx][ny]) continue;

                if(graph[nx][ny]!=target) continue;

                count++;
                visited[nx][ny]=true;
                queue.offer(new int[]{nx,ny});
            }
        }

        return count >= 4;
    }

    static void boom(int startX, int startY){
        Deque<int[]> queue = new ArrayDeque<>();

        boolean[][] visited = new boolean[ROW][COL];

        visited[startX][startY]=true;
        queue.offer(new int[]{startX,startY});

        char target = graph[startX][startY];

        while(!queue.isEmpty()){
            int[] unit = queue.poll();
            int x = unit[0];
            int y = unit[1];
            graph[x][y]='*';

            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                if(nx<0||nx>=ROW||ny<0||ny>=COL) continue;

                if(visited[nx][ny]) continue;

                if(graph[nx][ny]!=target) continue;

                visited[nx][ny]=true;
                queue.offer(new int[]{nx,ny});
            }
        }
    }

    static void down(){
        for(int j=0; j<COL; j++){
            int downSize=0;
            for(int i=ROW-1; i>=0; i--){
                if(graph[i][j]=='.') break;
                else if (graph[i][j]=='*') {
                    downSize++;
                    graph[i][j]='.';
                }else{
                    char unit = graph[i][j];
                    graph[i][j]='.';
                    graph[i+downSize][j] = unit;
                }
            }
        }
    }
}
