package simulation;

//문제
//스타트링크의 사무실은 1×1크기의 정사각형으로 나누어져 있는 N×M 크기의 직사각형으로 나타낼 수 있다. 사무실에는 총 K개의 CCTV가 설치되어져 있는데, CCTV는 5가지 종류가 있다. 각 CCTV가 감시할 수 있는 방법은 다음과 같다.
//
//
//1번 CCTV는 한 쪽 방향만 감시할 수 있다.
//2번과 3번은 두 방향을 감시할 수 있는데,
//2번은 감시하는 방향이 서로 반대방향이어야 하고,
//3번은 직각 방향이어야 한다. 4번은 세 방향, 5번은 네 방향을 감시할 수 있다.
//CCTV는 감시할 수 있는 방향에 있는 칸 전체를 감시할 수 있다. 사무실에는 벽이 있는데, CCTV는 벽을 통과할 수 없다. CCTV가 감시할 수 없는 영역은 사각지대라고 한다.
//CCTV는 회전시킬 수 있는데, 회전은 항상 90도 방향으로 해야 하며, 감시하려고 하는 방향이 가로 또는 세로 방향이어야 한다.
//
//
//입력
//첫째 줄에 사무실의 세로 크기 N과 가로 크기 M이 주어진다. (1 ≤ N, M ≤ 8)
//
//둘째 줄부터 N개의 줄에는 사무실 각 칸의 정보가 주어진다. 0은 빈 칸, 6은 벽, 1~5는 CCTV를 나타내고, 문제에서 설명한 CCTV의 종류이다.
//
//CCTV의 최대 개수는 8개를 넘지 않는다.
//
//        출력
//첫째 줄에 사각 지대의 최소 크기를 출력한다.


//풀이
//cctv는 cctv를 통과할 수 있다. -> cctv가 가는 방향을 벽으로 만드는 건 로직상 적절하지 않다.
//count하지 않는 부분
//  1. cctv가 배치된 곳
//  2. 이미 cctv가 확인한 곳

//특징
//1. 어짜피 상하좌우를 모두 확인해야한다.
//  그중에서 top 몇개를 고르는 방식?
//  브루트포스로 하나하나?
//2. cctv 기능이 큰 순서대로 놓으면 된다.
//3.

//그래프
//int count func(dept)
//if(dept == cctvCount)
//for문으로 0개수 세기
//static sum 갱신하기

//cctvPos -> x,y좌표 꺼내기
//switch(graph[x][y]):
    //case 1 :
        //leftTrue
        //func(dept+1)
        //leftFalse
        //
        //rightTrue
        //func(dept+1)
        //rightFalse
        //...
    //case 2 :
    //case 3 :
    //case 4 :
    //case 5 :

//leftTrue(x,y)
//for(int i =x+1;i<M;i++)
    //if(i>=M) break;
    //if(visited[x][i]) continue
    //if(graph[x][i] == 6) break;
    //visit[x][i] = true
    //graph[x][i] = dept
//leftFalse(x,y)
    //if(graph[x][i]!=dept) continue;
    //if(graph[x][i]==6) break;
    //visited[x][i] = false
    //graph[x][i] = 0;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

//leftFalse()
//rightTrue()
//rightFalse()
//upTrue()
//upFalse()
//downTrue()
//downFalse()
public class boj15683 {
    static int N,M;
    static int [][] graph;
    static boolean [][] visited;
    static int max = Integer.MIN_VALUE;
    static int cctvNum=0;
    static int wallNum =0;
    static int[] cctvX = new int[8];
    static int[] cctvY = new int[8];
    static int[] cctvUnit = new int[8];

    static int count=0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        graph=new int[N][M];


        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int unit = Integer.parseInt(st.nextToken());
                graph[i][j]=unit;
                if(unit>0&&unit<6){
                    cctvX[cctvNum]=i;
                    cctvY[cctvNum]=j;
                    cctvUnit[cctvNum]=unit;
                    cctvNum++;
                }
                if(unit == 6){
                    wallNum++;
                }
            }
        }

        func(10);

        System.out.println((N)*(M)-cctvNum-wallNum-max);

    }

    static void func(int dept){
        if(dept == cctvNum+10){
            if(count>max) max = count;
            return;
        }
        int type = cctvUnit[dept-10];
        int x = cctvX[dept-10];
        int y = cctvY[dept-10];

        switch (type){
            case 1 :
                left(x,y,dept);
                func(dept+1);
                left(x,y,dept);

                right(x,y,dept);
                func(dept+1);
                right(x,y,dept);

                up(x,y,dept);
                func(dept+1);
                up(x,y,dept);

                down(x,y,dept);
                func(dept+1);
                down(x,y,dept);

                break;
            case 2:
                left(x,y,dept);
                right(x,y,dept);
                func(dept+1);
                left(x,y,dept);
                right(x,y,dept);

                up(x,y,dept);
                down(x,y,dept);
                func(dept+1);
                up(x,y,dept);
                down(x,y,dept);
                break;
            case 3:
                up(x,y,dept);
                right(x,y,dept);
                func(dept+1);
                right(x,y,dept);

                left(x,y,dept);
                func(dept+1);


                up(x,y,dept);
                down(x,y,dept);
                func(dept+1);
                left(x,y,dept);
                right(x,y,dept);
                func(dept+1);
                right(x,y,dept);
                down(x,y,dept);

                break;
            case 4:
                left(x,y,dept);
                right(x,y,dept);
                up(x,y,dept);
                func(dept+1);
                up(x,y,dept);
                down(x,y,dept);
                func(dept+1);//left,right,down 남아있음

                up(x,y,dept);//up 켜기
                right(x,y,dept);//right 끄기 / up,down,left
                func(dept+1);
                left(x,y,dept);//left끄기
                right(x,y,dept);
                func(dept+1);
                right(x,y,dept);
                up(x,y,dept);
                down(x,y,dept);

                break;
            case 5:
                left(x,y,dept);
                right(x,y,dept);
                up(x,y,dept);
                down(x,y,dept);
                func(dept+1);
                left(x,y,dept);
                right(x,y,dept);
                up(x,y,dept);
                down(x,y,dept);
                break;
        }

    }

    static void left(int x,int y,int dept){
        for(int i=y-1;i>=0;i--){
            if(graph[x][i]==6){
                return;
            }

            if(graph[x][i]==0){
                graph[x][i] = dept;
                count++;
                continue;
            }

            if(graph[x][i]>=1&&graph[x][i]<=5) continue;

            if(graph[x][i]==dept){
                graph[x][i] = 0;
                count--;
            }
        }
    }

    static void right(int x,int y,int dept){
        for(int i=y+1;i<M;i++){
            if(graph[x][i]==6){
                return;
            }

            if(graph[x][i]==0){
                graph[x][i] = dept;
                count++;
                continue;
            }

            if(graph[x][i]>=1&&graph[x][i]<=5) continue;

            if(graph[x][i]==dept){
                graph[x][i] = 0;
                count--;
            }
        }
    }
    static void up(int x,int y,int dept){
        for(int i=x-1;i>=0;i--){
            if(graph[i][y]==6){
                return;
            }

            if(graph[i][y]==0){
                graph[i][y] = dept;
                count++;
                continue;
            }

            if(graph[i][y]>=1&&graph[i][y]<=5) continue;

            if(graph[i][y]==dept){
                graph[i][y] = 0;
                count--;
            }
        }
    }
    static void down(int x,int y,int dept){
        for(int i=x+1;i<N;i++){
            if(graph[i][y]==6){
                return;
            }

            if(graph[i][y]==0){
                graph[i][y] = dept;
                count++;
                continue;
            }

            if(graph[i][y]>=1&&graph[i][y]<=5) continue;

            if(graph[i][y]==dept){
                graph[i][y] = 0;
                count--;
            }
        }
    }
}
