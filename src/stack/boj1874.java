// (8)
// 4
package stack;
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


public class boj1874 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] seq = new int[N];
        Deque<Integer> stack = new ArrayDeque<>();
        //수열받기
        for(int i = 0; i < N; i++){
            seq[i]=Integer.parseInt(br.readLine());
        }
        int seqCount=0;
        StringBuilder sb = new StringBuilder();
        //로직 :
        //<전제> seqCount!=N+1일때까지 반복하는거임.
        //a. seqCount+1<=seq[seqCount] : push를 반복적으로 해줘야된다.
        //b. seqCount+1>seq[seqCount] : pop을 한다.seqCount++
        //b(조건) pop을 한 값이 seq[seqCount]와 값이 같느냐
        //같다면 continue
        //다르다면 print(NO), break
        //<변수> seqCount : 순열의 index를 나타내며, pop을 했을때에만 증가한다. 초기값은 0이다.
        //<변수> seqCount+1 : 다음으로 넣어야되는 원소값
        int nextUnit=1;
        while(seqCount<N){
            //<문제> seqCount값이 변해버리면서 조건문에서 문제가 생겨버림.
            if(nextUnit<=seq[seqCount]){// seq=<4
                stack.push(nextUnit);
                nextUnit++;
                sb.append("+\n");
            }else{
                if(!stack.isEmpty() && stack.peek()==seq[seqCount]){
                    stack.pop();
                    seqCount++;//7->8
                    sb.append("-\n");
                }else{
                    sb.setLength(0);
                    sb.append("NO");
                    break;
                }
            }
        }
        System.out.print(sb);
    }
}

        