// 문제
// 요세푸스 문제는 다음과 같다.

// 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다.
//  이제 순서대로 K번째 사람을 제거한다.
//  한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다.
//  이 과정은 N명의 사람이 모두 제거될 때까지 계속된다.
// 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다.
// 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.

// N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 5,000)

// 출력
// 예제와 같이 요세푸스 순열을 출력한다.

// 예제 입력 1 
// 7 3
// 예제 출력 1 
// <3, 6, 2, 7, 5, 1, 4>

//Linked리스트를 선언을 한다.
//그리고 요소의 크기인 N만큼 반복을 하는데, 해당 사이즈가 계속 줄기 떄문에,
//현재 남은 원소의 변수를 따로 추가한다. currentSize
//연결리스트의 경우에도, INDEX를 초과하면 런타임에러가 나니까, (index+K+currentSize-1)/currentSize로 계산한다.


package linked;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1158{
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        
        LinkedList<Integer> list = new LinkedList<>();

        for(int i = 0; i<N; i ++){
            list.add(i);
        }
        int currentSize=N;
        int i =0;
        System.out.print("<");
        while(list.isEmpty()){
            i=(i+K+currentSize-1)/currentSize;
            System.out.print(list.remove(i));
            if(currentSize!=list.size()){
                System.out.print(", ");
            }
            currentSize--;
        }
        System.out.print(">");
    }
}




















