package greedy;

import java.io.*;
import java.util.*;

//문제
//길이가 N인 수열이 주어졌을 때, 그 수열의 합을 구하려고 한다.
//하지만, 그냥 그 수열의 합을 모두 더해서 구하는 것이 아니라,
//수열의 두 수를 묶으려고 한다. 어떤 수를 묶으려고 할 때, 위치에 상관없이 묶을 수 있다.
//하지만, 같은 위치에 있는 수(자기 자신)를 묶는 것은 불가능하다.
//그리고 어떤 수를 묶게 되면, 수열의 합을 구할 때 묶은 수는 서로 곱한 후에 더한다.
//
//예를 들면, 어떤 수열이 {0, 1, 2, 4, 3, 5}일 때, 그냥 이 수열의 합을 구하면 0+1+2+4+3+5 = 15이다.
//하지만, 2와 3을 묶고, 4와 5를 묶게 되면, 0+1+(2*3)+(4*5) = 27이 되어 최대가 된다.
//
//수열의 모든 수는 단 한번만 묶거나, 아니면 묶지 않아야한다.
//수열이 주어졌을 때, 수열의 각 수를 적절히 묶었을 때, 그 합이 최대가 되게 하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 수열의 크기 N이 주어진다. N은 50보다 작은 자연수이다.
//둘째 줄부터 N개의 줄에 수열의 각 수가 주어진다.
//수열의 수는 -1,000보다 크거나 같고, 1,000보다 작거나 같은 정수이다.
//
//출력
//수를 합이 최대가 나오게 묶었을 때 합을 출력한다. 정답은 항상 231보다 작다.
//
//예제 입력
//        4
//        -1
//        2
//        1
//        3
//예제 출력
//        6

//아이디어
//양수,0,음수 에 대한 고려를 해야함.
//같은 수가 나올수도 있는가?->있다.
//정렬을 한다고 가정
//양수만 : 그냥 큰 순서대로 두개씩 묶는게 좋을듯
//더한거보다 곱한게 더 크면 곱하고, 아니면 더하고?

//-5 -4 0 -> 20으로 묶어야됨.
//-4 0
//-4,0,0
//이 시점부터는 양수는 그냥 더하면됨
//양수, 음수, 0으로 나눠서 저장한다.
//양수는 큰수부터 정렬해서 두개씩 묶어서 계산한다.
//만약 수가 하나만 남으면 그냥 더한다.

//음수는 작은수부터 묶는다.
//그러다가 하나가 남았을 때, 0이 있으면 0으로 , 0이 없으면 더한다.





public class boj1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean isZero = false;
        int sum = 0;

        PriorityQueue<Integer> positiveQueue = new PriorityQueue<>((a,b)->{
            return Integer.compare(b,a);
        });

        PriorityQueue<Integer> negativeQueue = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num>0){
                positiveQueue.offer(num);
            }else if(num<0){
                negativeQueue.offer(num);
            }else{
                isZero = true;
            }
        }

        while(!positiveQueue.isEmpty()){
            int num1=positiveQueue.poll();
            if(positiveQueue.isEmpty()){
                sum+=num1;
                break;
            }
            int num2=positiveQueue.poll();
            sum+=Math.max(num1*num2,num1+num2);
        }

        while(!negativeQueue.isEmpty()){
            int num1=negativeQueue.poll();
            if(negativeQueue.isEmpty()){
                if(!isZero){
                    sum+=num1;
                }
                break;
            }
            int num2=negativeQueue.poll();
            sum+=num1*num2;
        }

        System.out.println(sum);

    }
}
