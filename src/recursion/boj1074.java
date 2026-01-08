package recursion;

//한수는 크기가 2N × 2N인 2차원 배열을 Z모양으로 탐색하려고 한다.
//예를 들어, 2×2배열을 왼쪽 위칸, 오른쪽 위칸, 왼쪽 아래칸, 오른쪽 아래칸 순서대로 방문하면 Z모양이다.
//N > 1인 경우, 배열을 크기가 2N-1 × 2N-1로 4등분 한 후에 재귀적으로 순서대로 방문한다.
//N이 주어졌을 때, r행 c열을 몇 번째로 방문하는지 출력하는 프로그램을 작성하시오.

//입력
//첫째 줄에 정수 N, r, c가 주어진다.
//
//출력
//r행 c열을 몇 번째로 방문했는지 출력한다.
//
//제한
//1 ≤ N ≤ 15
//0 ≤ r, c < 2N

//예제 입력
//        2 3 1
//예제 출력
//        11
//예제 입력
//        3 7 7
//예제 출력
//        63
//예제 입력
//        1 0 0
//예제 출력
//        0

//

//재귀함수
//정의 : N이 주어졌을때, len=2가 될때까지 그래프를 쪼개고, 그래프를 순서에 따라 초기화하는 함수
//생각해볼 점 :
//1.내가 이전에 풀었던 문제의 로직대로 짜게 되면,(색종이) , count값이 이어지지 않는다.
// r,c에 해당하는 값만 확인하면 되는데 모든 그래프를 초기화해야만 답이 나올까?
    //이전 로직에서는 시작점을 넣을 때, x+i*len/2 이런식으로 넣었었다.
    //2 -> 1번
    //4 -> 4번 , 0,4,8,12
    //8 -> 8번   0 16 32,48
    //즉, len 만큼의 Z가 만들어지게 된다.
    //그리고 가장 큰 값은 len의 배수값에서 시작한다.
    //그렇다면, 최종 제일 작은 z까지 쪼개서, 해당 값을 유추할 수 있다.
    //x,y를 받고, 해당 범위에 해당하는 값으로 재귀를 호출해보자.
        //len = 8, x=3, y=5라고 해보자.
        //len=2가 될때까지, x,y를 나누어 몫과 나머지를 구한다.
            //func(3,5,8)
                //size = pow(len/2,2) = 16 , 한칸당 시작 index
                //x/(len/2), y/(len/2)
                    //qx,qy=>0,1
                    //rx,ry=>3,1
            //func(3,1,4)
                //size=pow(len/2,2)=4
                    //qx=1,rx=1
                    //qy=0,ry=1
                //sum=func(1,1,2)
                //sum+=qx*2*size+qy*size
                //return sum
            //func(1,1,2)
                //size=pow(len/2,2)=1
                //return x*2*size+y*size
        //3+(8+0)+(16)=27


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs=br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int x = Integer.parseInt(inputs[1]);
        int y = Integer.parseInt(inputs[2]);

        int len = (int)Math.pow(2,N);



        System.out.println(func(x,y,len));
    }

    static int func(int x, int y, int len){
        //len=8, size=16
        if(len==1){
            return 0;
        }

        int size = (int)Math.pow((double)len/2,2);
        if(len==2) return x*2*size+y*size;
        //half=4
        int half = len/2;
        int qx = x/half;//qx=1
        int rx = x%half;//rx=3

        int qy = y/half;//rq=1
        int ry = y%half;//ry=3

        int sum = func(rx,ry,len/2);
        sum+=qx*2*size+qy*size;

        return sum;
    }

}
