package queue;
//문제
//정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
//


//입력
//첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다.
//둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.
//주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다.
//문제에 나와있지 않은 명령이 주어지는 경우는 없다.
//

//출력
//출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//예제 입력
//15
//push 1
//push 2
//front
//back
//size
//empty
//pop
//pop
//pop
//size
//empty
//pop
//push 3
//empty
//front
//예제 출력
//        1
//        2
//        2
//        0
//        1
//        2
//        -1
//        0
//        1
//        -1
//        0
//        3
public class boj10845 {
    static StringBuilder sb= new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> queue = new ArrayDeque<>();

        for(int i = 0; i<N; i++){
            String[] input = br.readLine().split(" ");
//            System.out.println(Arrays.toString(input));
            switch (input[0]){
                case "push":
                    push(queue,Integer.parseInt(input[1]));
                    break;
                case "pop":
                    pop(queue);
                    break;
                case "size":
                    size(queue);
                    break;
                case "empty":
                    empty(queue);
                    break;
                case "front" :
                    front(queue);
                    break;
                case "back" :
                    back(queue);
                    break;
            }
        }

        System.out.println(sb);
    }

    //명령은 총 여섯 가지이다.
    //
    //push X: 정수 X를 큐에 넣는 연산이다.
    //pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    //size: 큐에 들어있는 정수의 개수를 출력한다.
    //empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
    //front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    //back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    static void push(Deque<Integer> queue,int number){
        queue.offerLast(number);
    }

    static void pop(Deque<Integer> queue){
        if(queue.isEmpty()){
            sb.append("-1\n");
            return;
        }
        sb.append(queue.pollFirst()).append("\n");
    }

    static void back(Deque<Integer> queue){
        if(queue.isEmpty()){
            sb.append(-1).append("\n");
            return;
        }
        sb.append(queue.peekLast()).append("\n");
    }

    static void size(Deque<Integer> queue){
        sb.append(queue.size()).append("\n");
    }

    static void empty(Deque<Integer> queue){
        if(queue.isEmpty()){
            sb.append(1).append("\n");
        }
        else{
            sb.append(0).append("\n");
        }
    }

    static void front(Deque<Integer> queue){
        if(queue.isEmpty()){
            sb.append(-1).append("\n");
            return;
        }
        sb.append(queue.peekFirst()).append("\n");
    }
}
