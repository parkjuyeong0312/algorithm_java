package recursion;
//8
//        1 1 0 0 0 0 1 1
//        1 1 0 0 0 0 1 1
//        0 0 0 0 1 1 0 0
//        0 0 0 0 1 1 0 0
//        1 0 0 0 1 1 1 1
//        0 1 0 0 1 1 1 1
//        0 0 1 1 1 1 1 1
//        0 0 1 1 1 1 1 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2630 {
        static int[][] graph;
        static int[] count = new int[2];

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

            for(int i =0; i<2;i++){
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
                    case 0 :
                        count[0]++;
                        break;
                    case 1 :
                        count[1]++;
                        break;
                }
                return;
            }

            for(int i=0; i<2; i++){
                for(int j=0; j<2; j++){
                    func(x+(i*len)/2,y+(j*len)/2,len/2);//3,6,9 -> 1,2,3 , len=1
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
