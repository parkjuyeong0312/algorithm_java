package simulation;

//문제
//혜윤이는 최근에 다양한 대회를 참여하면서 노트북에 붙일 수 있는 스티커들을 많이 받았다.
//스티커는 아래와 같이 사각 모눈종이 위에 인쇄되어 있으며, 스티커의 각 칸은 상하좌우로 모두 연결되어 있다.
//또한 모눈종이의 크기는 스티커의 크기에 꼭 맞아서, 상하좌우에 스티커가 포함되지 않는 불필요한 행이나 열이 존재하지 않는다.
//아래는 올바른 모눈종이의 예시이다. 주황색 칸은 스티커가 붙은 칸을, 하얀색 칸은 스티커가 붙지 않은 칸을 나타낸다.
//반면 아래는 올바르지 않은 모눈종이의 예시이다.
//첫 번째는 윗쪽에 불필요한 행이 있고,
//두 번째는 왼쪽에 불필요한 열이 있다.
//그리고 세 번째는 스티커의 각 칸이 상하좌우로 모두 연결되어 있지 않다.
//혜윤이는 자신의 노트북에 이 스티커들을 붙이기로 했다.
//혜윤이의 노트북은 마침 직사각형 모양이고, 스티커가 인쇄된 모눈종이와 같은 간격으로 격자가 그려져 있다.
//혜윤이는 스티커들을 먼저 받았던 것부터 차례대로 격자에 맞춰서 붙이려고 한다.
//혜윤이가 스티커를 붙이는 방법은 다음과 같다.
//
//스티커를 회전시키지 않고 모눈종이에서 떼어낸다.
//다른 스티커와 겹치거나 노트북을 벗어나지 않으면서 스티커를 붙일 수 있는 위치를 찾는다.
//혜윤이는 노트북의 위쪽부터 스티커를 채워 나가려고 해서, 스티커를 붙일 수 있는 위치가 여러 곳 있다면 가장 위쪽의 위치를 선택한다.
//가장 위쪽에 해당하는 위치도 여러 곳이 있다면 그중에서 가장 왼쪽의 위치를 선택한다.
//선택한 위치에 스티커를 붙인다. 만약 스티커를 붙일 수 있는 위치가 전혀 없어서 스티커를 붙이지 못했다면, 스티커를 시계 방향으로 90도 회전한 뒤 2번 과정을 반복한다.
//위의 과정을 네 번 반복해서 스티커를 0도, 90도, 180도, 270도 회전시켜 봤음에도 스티커를 붙이지 못했다면 해당 스티커를 붙이지 않고 버린다.
//
//입력
//첫째 줄에 노트북의 세로와 가로 길이를 나타내는 N(1 ≤ N ≤ 40)과 M(1 ≤ M ≤ 40), 그리고 스티커의 개수 K(1 ≤ K ≤ 100)이 한 칸의 빈칸을 사이에 두고 주어진다.
//그 다음 줄부터는 K개의 스티커들에 대한 정보가 주어진다. 각 스티커는 아래와 같은 형식으로 주어진다.
//먼저 i번째 스티커가 인쇄된 모눈종이의 행의 개수와 열의 개수를 나타내는 Ri(1 ≤ Ri ≤ 10)와 Ci(1 ≤ Ci ≤ 10)가 한 칸의 빈칸을 사이에 두고 주어진다.
//다음 Ri개의 줄에는 각 줄마다 모눈종이의 각 행을 나타내는 Ci개의 정수가 한 개의 빈칸을 사이에 두고 주어진다. 각 칸에 들어가는 값은 0, 1이다. 0은 스티커가 붙지 않은 칸을, 1은 스티커가 붙은 칸을 의미한다.
//문제에서 설명한 것과 같이 스티커는 모두 올바른 모눈종이에 인쇄되어 있다. 구체적으로 스티커의 각 칸은 상하좌우로 모두 연결되어 있고, 모눈종이의 크기는 스티커의 크기에 꼭 맞아서 상하좌우에 스티커에 전혀 포함되지 않는 불필요한 행이나 열이 존재하지 않는다.
//출력
//첫째 줄에 주어진 스티커들을 차례대로 붙였을 때 노트북에서 스티커가 붙은 칸의 수를 출력한다.
//
//예제 입력 1
//        5 4 4

//        3 3
//        1 0 1
//        1 1 1
//        1 0 1

//        2 5
//        1 1 1 1 1
//        0 0 0 1 0

//        2 3
//        1 1 1
//        1 0 1

//        3 3
//        1 0 0
//        1 1 1
//        1 0 0


//풀이
//위에서 오른쪽, 아래로 넘어가는 순서임.
//그래프를 선언을 하고, 해당원소가 모두 붙힐 수 있는 지여부를 확인함.
//아니라면 90도씩 돌려서 확인해야함.

//스티커 배열을 어떻게 관리하지?

//boolean func(sticker)

// N,M
// n,m,sticker
//for(int i=0; i<4; i++){
    //if(func(n,m,sticker)) :  break//스티커 붙히는데 성공했을 경우
    //

//func(int[][] sticker)
    //maxX=N-n
    //maxY=M-m
    //for(int i=0; i<maxX; i++)
        //정방향
        //boolean success=true;
        //for(int j=0; j<maxY; j++)
            //if(sticker[i][j]!=1) continue;
            //if(graph[i][j]!=0) success=false;

        //if(success)
        //for(int i=0; i<maxX; i++)
            //for(int j=0; j<maxY; j++)
                //graph[i][j]=1;
                //return true


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj18808 {
    static int[][] sticker0;
    static int[][] sticker90;
    static int[][] sticker180;
    static int[][] sticker270;

    static int[][] graph;
    static int N,M,K;
    public static void main(String[] args) throws Exception{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        int sum=0;

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            sticker0= new int[n][m];
            sticker90= new int[m][n];
            sticker180= new int[n][m];
            sticker270= new int[m][n];

            int size =0;

            for(int j=0; j<n; j++){
                st=new StringTokenizer(br.readLine());
                for(int k =0; k<m; k++){
                    int unit =Integer.parseInt(st.nextToken());
                    sticker0[j][k] = unit;
                    sticker90[k][n-j-1]=unit;
                    sticker180[n-j-1][m-k-1]=unit;
                    sticker270[m-k-1][j]=unit;
                    if(unit == 1) size++;
                }
            }
            if(func(sticker0,N-n,M-m,n,m)) sum+=size;
            else if(func(sticker90,N-m,M-n,m,n)) sum+=size;
            else if (func(sticker180,N-n,M-m,n,m)) sum+=size;
            else if(func(sticker270,N-m,M-n,m,n)) sum+=size;
        }

        System.out.println(sum);
    }

    //func(int[][] sticker)
    //maxX=N-n
    //maxY=M-m
    //for(int i=0; i<maxX; i++)
    //정방향R
    //boolean success=true;
    //for(int j=0; j<maxY; j++)
    //if(sticker[i][j]!=1) continue;
    //if(graph[i][j]!=0) success=false;

    //if(success)
    //for(int i=0; i<maxX; i++)
    //for(int j=0; j<maxY; j++)
    //graph[i][j]=1;
    //return true
    static boolean func(int[][] sticker,int maxX, int maxY,int row, int col){

        for(int x=0; x<=maxX; x++){
            for(int y=0; y<=maxY; y++){
                boolean canStick = true;
                for(int i=0; i<row; i++){
                    for(int j=0; j<col; j++){
                        if(sticker[i][j]!=1) {//스티커값이 1이 아니면 패스
                            continue;
                        }
                        //스티커 값 1
                        if(graph[x+i][y+j]==1){//이미 그래프 값이 1이면, 스티커 못붙힘
                            canStick=false;
                            break;
                        }else canStick=true;

                    }
                    if(!canStick) break;
                }
                //stick를 붙힐 수 있음.
                if(canStick){
                    for(int i=0; i<row; i++){
                        for(int j=0; j<col; j++) {
                            if(sticker[i][j]!=1){
                                continue;
                            }
                            graph[x+i][y+j]=1;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
