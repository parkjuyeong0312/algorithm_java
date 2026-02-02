package randomSolve;

//최솟값 찾기
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2.4 초 (하단 참고)	512 MB	55143	18715	11875	32.492%

//문제
//N개의 수 A1, A2, ..., AN과 L이 주어진다.
//Di = Ai-L+1 ~ Ai 중의 최솟값이라고 할 때, D에 저장된 수를 출력하는 프로그램을 작성하시오. 이때, i ≤ 0 인 Ai는 무시하고 D를 구해야 한다.
//
//입력
//첫째 줄에 N과 L이 주어진다. (1 ≤ L ≤ N ≤ 5,000,000)
//둘째 줄에는 N개의 수 Ai가 주어진다. (-109 ≤ Ai ≤ 109)
//
//출력
//첫째 줄에 Di를 공백으로 구분하여 순서대로 출력한다.
//
//예제 입력
//        12 3
//        1 5 2 3 6 2 3 7 3 5 2 6
//예제 출력
//        1 1 1 2 2 2 2 2 3 3 2 2

//풀이
//우선순위 큐를 이용해서 해볼까?
//그냥 슬라이딩 하면서 확인할수는없을까?
//근데 L의 길이가 500만이라서, 이게 조금만 길어져도 NL이기 떄문에, 최악의경우  N^2에 버금가는 시간복잡도를 가져가게 될 수 있다.
//그렇기에 경우의수마다 확인하는건 무리가 있다.

//그렇다면, 어떤식을 확인해야할까?
//원소를 클래스로 선언한다.
//원소는 num, index
//이고,
//while(index<=N)
//add(num[i])
//while(i-peek.index+1>L) //길이 범위 내부에 있을때
//  poll 해버림.
//출력
//index++

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj11003 {
    static class Node{
        int num;
        int index;

        public Node(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        Deque<Node> dq = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=N; i++){
            int x = Integer.parseInt(st.nextToken());

            while(!dq.isEmpty()&&dq.peekLast().num>x) dq.pollLast();

            dq.add(new Node(x,i));

            while(!dq.isEmpty()&&i-dq.peek().index+1>L) dq.pollFirst();

            sb.append(dq.peekFirst().num).append(' ');
        }
        System.out.println(sb);
    }
}
//원소는 num, index
//이고,
//while(index<=N)
//add(num[i])
//while(i-peek.index+1>L) //길이 범위 내부에 있을때
//  poll 해버림.
//출력
//index++