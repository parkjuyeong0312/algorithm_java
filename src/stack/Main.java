// (8)
// 4

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// 4
// 3
// 6
// 8
// 7
// 5
// 2
// 1


//int target값이 주어지고, 현재 값 보다 작으면 반복문을 돌려서 push를 호출한뒤 pop을한다.
//현재값보다 작으면 pop을 해당 값까지 호출한다.
//이때, pop내부에 count를 매기고, 수열의 원소 값과 비료를 한다.
//만약 비교를 했을때, 값이 다르면, NO를 호출, 아니면 그냥 진행


public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] seq = new int[N];
        Deque<Integer> stack = new ArrayDeque<>();
        //수열받기
        for(int i = 0; i < N; i++){
            seq[i]=Integer.parseInt(br.readLine());
            stack.push(i+1);
        }
        int seqCount=0; 

        for(int i = 0; i<N; i++){
            int target = seq[seqCount];
            System.out.println(target);

            if(stack.isEmpty()){
                do { 
                    stack.push(i);
                    System.out.println("+");
                } while (stack.peek()<target);
                continue;
            }

            if(stack.peek()<target){//target보다 인덱스가 작으면, push하면서 이동
                while(stack.peek()>target){
                    stack.push(i);//[1,2]
                    System.out.println("+");
                }
                if(seq[seqCount]==stack.peek()){
                    stack.pop();  //2
                    seqCount++;
                    System.out.println("-");
                }else{
                    System.out.println("1"+"NO");
                    break;
                }
            }else if(stack.peek()==target){
                if(seq[seqCount]==stack.peek()){
                    stack.pop();  //2
                    seqCount++;
                    System.out.println("-");
                }else{
                    System.out.println("2"+"NO");
                    break;
                }
            }else{
                while(stack.peek()<target){
                    if(seq[seqCount]==stack.peek()){
                        stack.pop();  //2
                        seqCount++;
                        System.out.println("-");
                    }else{
                        System.out.println("3"+"NO");
                        break;
                    }
                }
            }
        }
    }
}

        
        // //pop 함수를 만들자.
        