package recursion;
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//1 초	256 MB	88048	50447	37709	56.978%
//문제
//재귀적인 패턴으로 별을 찍어 보자. N이 3의 거듭제곱(3, 9, 27, ...)이라고 할 때,
//크기 N의 패턴은 N×N 정사각형 모양이다.
//
//크기 3의 패턴은 가운데에 공백이 있고, 가운데를 제외한 모든 칸에 별이 하나씩 있는 패턴이다.
//
//***
//* *
//***
//N이 3보다 클 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태이다. 예를 들어 크기 27의 패턴은 예제 출력 1과 같다.
//
//입력
//첫째 줄에 N이 주어진다. N은 3의 거듭제곱이다. 즉 어떤 정수 k에 대해 N=3k이며, 이때 1 ≤ k < 8이다.
//
//출력
//첫째 줄부터 N번째 줄까지 별을 출력한다.


//재귀함수정의
//별을 지우는 함수
//func(x,y,n)
//base condition
//n=1


//풀이흐름
//우선 그래프를 *로 초기화한다.
//3일때 다음 좌표를 공백으로 만든다.
    //x=1(1칸)
    //y=1(1칸)
//9일때
    //x=3~5(3칸)
    //y=3~4(3칸)
//27일때
    //x=9~17(9칸)
    //y=9~17(9칸)

//시작 좌표를 넣고 반복문으로 재귀를 여러번 호출하는 방식으로 해야함
//len=27일때,
//(0,0) , (0,9), (0,18) -> 3번반복 고정값
//x축도 똑같이 진행, => for문 2개

//func(i*nextlen/3,j*nextlen/3,len/3)

//시간초과 => N최대값 3^8 약 7만
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj2447 {
    static char[][] graph;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        graph=new char[N][N];
        sb = new StringBuilder();

        for(int i=0; i<N; i++){//O(N^2)
            Arrays.fill(graph[i],'*');
        }

        func(0,0,N);

        for(int i=0;i<N;i++){//O(N^2)
            for(int j=0; j<N; j++){
                sb.append(graph[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
    //재귀의 시간복잡도? -> O(N^2)*재귀횟수?
    //재귀가 200번정도만 돌아도 터진다. 1억/49만=204..
    static void func(int x, int y , int len){
        if(len==1) return;

        int nextLen= len/3;

        for(int i=0;i<nextLen;i++){
            for(int j=0; j<nextLen; j++){
                graph[x+nextLen+i][y+nextLen+j] = ' ';
            }
        }

        for(int i=0; i<3; i++){
            for(int j =0; j<3; j++){
                if(i==1&&j==1) continue;//가운데는 스킵
                func(x+i*nextLen,y+j*nextLen,nextLen);
            }
        }
    }
}
