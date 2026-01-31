package randomSolve;

//문제
//인하대학교 후문 뒤쪽에는 어두운 굴다리가 있다. 겁쟁이 상빈이는 길이 조금이라도 어둡다면 가지 않는다.
//따라서 굴다리로 가면 최단거리로 집까지 갈수 있지만, 굴다리는 어둡기 때문에 빙빙 돌아서 집으로 간다.
//안타깝게 여긴 인식이는 굴다리 모든 길 0~N을 밝히게 가로등을 설치해 달라고 인천광역시에 민원을 넣었다.
//인천광역시에서 가로등을 설치할 개수 M과 각 가로등의 위치 x들의 결정을 끝냈다.
//그리고 각 가로등은 높이만큼 주위를 비출 수 있다.
//하지만 갑자기 예산이 부족해진 인천광역시는 가로등의 높이가 높을수록 가격이 비싸지기 때문에 최소한의 높이로 굴다리 모든 길 0~N을 밝히고자 한다.
//최소한의 예산이 들 높이를 구하자. 단 가로등은 모두 높이가 같아야 하고, 정수이다.
//다음 그림을 보자.
//
//
//입력
//첫 번째 줄에 굴다리의 길이 N 이 주어진다. (1 ≤ N ≤ 100,000)
//두 번째 줄에 가로등의 개수 M 이 주어진다. (1 ≤ M ≤ N)
//
//다음 줄에 M 개의 설치할 수 있는 가로등의 위치 x 가 주어진다. (0 ≤ x ≤ N)
//가로등의 위치 x는 오름차순으로 입력받으며 가로등의 위치는 중복되지 않으며, 정수이다.
//
//출력
//굴다리의 길이 N을 모두 비추기 위한 가로등의 최소 높이를 출력한다.
//
//예제 입력
//        5
//        2
//        2 4
//예제 출력
//        2
//예제 입력
//        3
//        1
//        0
//예제 출력
//        3

import java.util.*;
import java.io.*;

public class boj17266 {
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<M; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //원소의 처음과 마지막을 넣는다.
        int max = Math.max(arr[0],N-arr[M-1]);

        //1. 배열은 전봇대의 위치를 나타낸다.
        //2. 배열의 첫번째, 마지막은 따로 계산을한다.
        //3. 결국엔 최댓값을 구하는것이다.
        for(int i=1; i<M-1; i++){
            max=Math.max((arr[i+1]-arr[i]+1)/2,max);
        }

        System.out.println(max);

    }

}

































