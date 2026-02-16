
//문제
//유현이가 새 집으로 이사했다. 새 집의 크기는 N×N의 격자판으로 나타낼 수 있고,
//1×1크기의 정사각형 칸으로 나누어져 있다.
//각각의 칸은 (r, c)로 나타낼 수 있다.
//여기서 r은 행의 번호, c는 열의 번호이고, 행과 열의 번호는 1부터 시작한다. 각각의 칸은 빈 칸이거나 벽이다.
//
//오늘은 집 수리를 위해서 파이프 하나를 옮기려고 한다. 파이프는 아래와 같은 형태이고, 2개의 연속된 칸을 차지하는 크기이다.
//파이프는 회전시킬 수 있으며, 아래와 같이 3가지 방향이 가능하다.
//
//
//파이프는 매우 무겁기 때문에, 유현이는 파이프를 밀어서 이동시키려고 한다.
//벽에는 새로운 벽지를 발랐기 때문에, 파이프가 벽을 긁으면 안 된다. 즉, 파이프는 항상 빈 칸만 차지해야 한다.
//
//파이프를 밀 수 있는 방향은 총 3가지가 있으며, →, ↘, ↓ 방향이다. 파이프는 밀면서 회전시킬 수 있다. 회전은 45도만 회전시킬 수 있으며, 미는 방향은 오른쪽, 아래, 또는 오른쪽 아래 대각선 방향이어야 한다.
//
//파이프가 가로로 놓여진 경우에 가능한 이동 방법은 총 2가지, 세로로 놓여진 경우에는 2가지, 대각선 방향으로 놓여진 경우에는 3가지가 있다.
//
//아래 그림은 파이프가 놓여진 방향에 따라서 이동할 수 있는 방법을 모두 나타낸 것이고, 꼭 빈 칸이어야 하는 곳은 색으로 표시되어져 있다.
//
//
//
//가로
//
//
//
//        세로
//
//
//
//대각선
//
//가장 처음에 파이프는 (1, 1)와 (1, 2)를 차지하고 있고, 방향은 가로이다. 파이프의 한쪽 끝을 (N, N)로 이동시키는 방법의 개수를 구해보자.
//
//입력
//첫째 줄에 집의 크기 N(3 ≤ N ≤ 16)이 주어진다. 둘째 줄부터 N개의 줄에는 집의 상태가 주어진다. 빈 칸은 0, 벽은 1로 주어진다. (1, 1)과 (1, 2)는 항상 빈 칸이다.
//
//출력
//첫째 줄에 파이프의 한쪽 끝을 (N, N)으로 이동시키는 방법의 수를 출력한다. 이동시킬 수 없는 경우에는 0을 출력한다. 방법의 수는 항상 1,000,000보다 작거나 같다.
//
//예제 입력 1
//        3
//        0 0 0
//        0 0 0
//        0 0 0
//예제 출력 1
//        1
//예제 입력 2
//        4
//        0 0 0 0
//        0 0 0 0
//        0 0 0 0
//        0 0 0 0
//예제 출력 2
//        3


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//일반적인 재귀 문제.
//그냥 경우의 수 대로 돌리면될거같음.
public class Main {
    static int[][] graph;
    static int N;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());

        graph = new int[N+1][N+1];

        StringTokenizer st;
        for(int i =1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        func(1,2,0);

        System.out.println(ans);

    }

    static void func(int x, int y,int dir){
        if(x>N||y>N) return;
        switch (dir){
            case 0 :
                if(graph[x][y]==1) return;
                break;
            case 1 :
                if(graph[x][y]==1) return;
                if(graph[x-1][y]==1) return;
                if(graph[x][y-1]==1) return;
                break;
            case 2 :
                if(graph[x][y]==1) return;
                break;
        }


        //재귀니까, baseLine을 잡고
        if(x==N&&y==N){
            ans++;
            return;
        }

        switch (dir){
            case 0 :
                func(x,y+1,0);
                func(x+1,y+1,1);
                break;
            case 1 :
                func(x,y+1,0);
                func(x+1,y+1,1);
                func(x+1,y,2);
                break;
            case 2:
                func(x+1,y+1, 1);
                func(x+1,y, 2);
        }
    }
}
