package recursion;
//문제
//N×N크기의 행렬로 표현되는 종이가 있다. 종이의 각 칸에는 -1, 0, 1 중 하나가 저장되어 있다.
//우리는 이 행렬을 다음과 같은 규칙에 따라 적절한 크기로 자르려고 한다.
//
//1. 만약 종이가 모두 같은 수로 되어 있다면 이 종이를 그대로 사용한다.
//2.(1)이 아닌 경우에는 종이를 같은 크기의 종이 9개로 자르고,각각의 잘린 종이에 대해서 (1)의 과정을 반복한다.
//이와 같이 종이를 잘랐을 때, -1로만 채워진 종이의 개수,
//0으로만 채워진 종이의 개수, 1로만 채워진 종이의 개수를 구해내는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 N(1 ≤ N ≤ 37, N은 3k 꼴)이 주어진다. 다음 N개의 줄에는 N개의 정수로 행렬이 주어진다.
//
//출력
//첫째 줄에 -1로만 채워진 종이의 개수를, 둘째 줄에 0으로만 채워진 종이의 개수를, 셋째 줄에 1로만 채워진 종이의 개수를 출력한다.
//
//예제 입력
//        9
//        0 0 0 1 1 1 -1 -1 -1
//        0 0 0 1 1 1 -1 -1 -1
//        0 0 0 1 1 1 -1 -1 -1
//        1 1 1 0 0 0 0 0 0
//        1 1 1 0 0 0 0 0 0
//        1 1 1 0 0 0 0 0 0
//        0 1 -1 0 1 -1 0 1 -1
//        0 -1 1 0 1 -1 0 1 -1
//        0 1 -1 1 0 -1 0 1 -1
//예제 출력
//        10
//        12
//        11



//풀이 ->재귀함수
//정의 : 내부에 모두 같은 숫자로 구성되어 있는지 확인하는 함수
//base case : 내부에 모두 같은 숫자로 이루어져있을때

//재귀함수 구성
//int func(x,y) : 3등분 할 때의 시작점 x:0, y:0 / 종이의 길이 len : 9/3=3
//if(check(x,y,len)) return 1

//~~~check가 false 일떄~~~

//int sum = 0

//for(3)
    //for(3)
        //sum+= func(i*len,j*len,len/3)

//return sum


//함수
//check(x,y,len)
//if(len == 1) return 1
//int init = graph[x][y]
//boolean allSame = true
//for(N)
//  for(N)
//      if(init!=graph[i][j]) allSame = false, break;

//return allSame


import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1780 {
    static int[][] graph;
    static int[] count = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        graph = new int[N][N];

        StringTokenizer st;

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++){
                graph[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        func(0,0,N);

        for(int i =0; i<3;i++){
            System.out.println(count[i]);
        }
    }
    //재귀함수 구성
//int func(x,y) : 3등분 할 때의 시작점 x:0, y:0 / 종이의 길이 len : 9/3=3
//if(check(x,y,len)) return 1

//~~~check가 false 일떄~~~

//int sum = 0

//for(3)
    //for(3)
    //sum+= func(i*len,j*len,len/3)

    //return sum
    static void func(int x, int y, int len){
        if(check(x,y,len)) {
            int num = graph[x][y];
            switch (num){
                case -1 :
                    count[0]++;
                    break;
                case 0 :
                    count[1]++;
                    break;
                case 1 :
                    count[2]++;
                    break;
            }
            return;
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                func(x+(i*len)/3,y+(j*len)/3,len/3);//3,6,9 -> 1,2,3 , len=1
            }
        }

    }
    //함수
    //check(x,y,len)
    //if(len == 1) return 1
    //int init = graph[x][y]
    //boolean allSame = true
    //for(N)
    //  for(N)
    //      if(init!=graph[i][j]) allSame = false, break;

    //return allSame
    static boolean check(int x, int y, int len){
        if(len == 1) return true;

        int init = graph[x][y];
        boolean allSame = true;

        for(int i = 0; i<len; i++){
            for(int j =0; j<len; j++){
                if(init!=graph[x+i][y+j]) {
                    allSame=false;
                    break;
                }
            }
            if(!allSame) break;
        }


        return allSame;
    }
}
