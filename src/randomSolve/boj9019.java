package randomSolve;

//네 개의 명령어 D, S, L, R 을 이용하는 간단한 계산기가 있다.
//이 계산기에는 레지스터가 하나 있는데, 이 레지스터에는 0 이상 10,000 미만의 십진수를 저장할 수 있다.
//각 명령어는 이 레지스터에 저장된 n을 다음과 같이 변환한다.
//n의 네 자릿수를 d1, d2, d3, d4라고 하자(즉 n = ((d1 × 10 + d2) × 10 + d3) × 10 + d4라고 하자)
//
//D: D 는 n을 두 배로 바꾼다. 결과 값이 9999 보다 큰 경우에는 10000 으로 나눈 나머지를 취한다. 그 결과 값(2n mod 10000)을 레지스터에 저장한다.
//S: S 는 n에서 1 을 뺀 결과 n-1을 레지스터에 저장한다. n이 0 이라면 9999 가 대신 레지스터에 저장된다.
//L: L 은 n의 각 자릿수를 왼편으로 회전시켜 그 결과를 레지스터에 저장한다. 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d2, d3, d4, d1이 된다.
//R: R 은 n의 각 자릿수를 오른편으로 회전시켜 그 결과를 레지스터에 저장한다. 이 연산이 끝나면 레지스터에 저장된 네 자릿수는 왼편부터 d4, d1, d2, d3이 된다.
//위에서 언급한 것처럼, L 과 R 명령어는 십진 자릿수를 가정하고 연산을 수행한다. 예를 들어서 n = 1234 라면 여기에 L 을 적용하면 2341 이 되고 R 을 적용하면 4123 이 된다.
//여러분이 작성할 프로그램은 주어진 서로 다른 두 정수 A와 B(A ≠ B)에 대하여 A를 B로 바꾸는 최소한의 명령어를 생성하는 프로그램이다. 예를 들어서 A = 1234, B = 3412 라면 다음과 같이 두 개의 명령어를 적용하면 A를 B로 변환할 수 있다.
//        1234 →L 2341 →L 3412
//        1234 →R 4123 →R 3412
//
//따라서 여러분의 프로그램은 이 경우에 LL 이나 RR 을 출력해야 한다.
//
//n의 자릿수로 0 이 포함된 경우에 주의해야 한다. 예를 들어서 1000 에 L 을 적용하면 0001 이 되므로 결과는 1 이 된다. 그러나 R 을 적용하면 0100 이 되므로 결과는 100 이 된다.
//
//입력
//프로그램 입력은 T 개의 테스트 케이스로 구성된다. 테스트 케이스 개수 T 는 입력의 첫 줄에 주어진다.
//각 테스트 케이스로는 두 개의 정수 A와 B(A ≠ B)가 공백으로 분리되어 차례로 주어지는데 A는 레지스터의 초기 값을 나타내고 B는 최종 값을 나타낸다. A 와 B는 모두 0 이상 10,000 미만이다.
//
//        출력
//A에서 B로 변환하기 위해 필요한 최소한의 명령어 나열을 출력한다. 가능한 명령어 나열이 여러가지면, 아무거나 출력한다.
//
//예제 입력
//        3
//        1234 3412
//        1000 1
//        1 16
//예제 출력
//LL
//L
//DDDD


//뭔가 덱을 쓰는거같긴함.
//맨 마지막에 0일때의 출력처리정도만 해주면 될듯
//D : n을 2배로
//S : 1을 뺀다.
//L 앞에서 꺼내서 뒤로 넘기기
//R 뒤에서 꺼내서 앞으로 넘기기

//근데 과연 덱을 쓰는걸까?
//하나하나씩 꺼내서 하기엔 너무나 비용이 크다.
//물론 시간제한은 6초로 넉넉하긴 하다.
//n은 4자리수
//테스트 케이스 수가 주어지지 않는데? 음?

//어쨋든 빨리 최단거리로 도착하는 거니까,
//BFS를 사용하는거겟지?
//BFS 형식으로 큐에 넣는데, 최소 범위가 보장되나?
//그리고 그에 따른 리스트는 어떻게 보내는거지?
//사용된 경로에 대해 노출해야되는거잖아
//애초에 BFS니까, 최초로 발견된 시점에서, return을 때려버리고, 그 경로에 따라 출력을 하면, 그게 최단경로를 보장할까?
//대충 생각해봤을때는 보장하는거 같긴해

//bfs()
//D
//S
//L
//R


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj9019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<testCase; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            sb.append(bfs(start, target)).append("\n");
        }

        System.out.println(sb);
    }

    //출력을 어떻게 해야하지?
    //일단 배열을 10000사이즈로 선언을하자.
    //그리고, 이걸 visited처럼 운영하는게 맞는듯
    //그리고 그 안에 string을 ㅅ넣는건어때
    //예를 들어 초기화된 값이 그런거지 DSLR
    //그래그래 그리고 String을 합치는 형식으로 넣는건가?
    //ㅇㅇ ㄱㅊ네 음 . String을 이어붙히는 방법이 있었던거같은,concat이란걸 사용하면됨.
    static String bfs(int start, int target){
        String[] arr = new String[10000];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(start);
        arr[start] = "";
        int nextNum;
        while(!dq.isEmpty()){
            int num = dq.poll();
            if(num == target){
                break;
            }
            //D
            nextNum = twice(num);
            if(arr[nextNum]==null){
                arr[nextNum]=arr[num].concat("D");
                dq.offer(nextNum);
            }
            //S
            nextNum = minus(num);
            if(arr[nextNum]==null){
                arr[nextNum]=arr[num].concat("S");
                dq.offer(nextNum);
            }
            //L
            nextNum = left(num);
            if(arr[nextNum]==null){
                arr[nextNum]=arr[num].concat("L");
                dq.offer(nextNum);
            }
            //R
            nextNum = right(num);
            if(arr[nextNum]==null){
                arr[nextNum]=arr[num].concat("R");
                dq.offer(nextNum);
            }

        }
        return arr[target];
    }
    //일단
    static int left(int num){
        int firstNum = num/1000;
        int temp = num%1000;
        return temp*10+firstNum;
    }

    static int right(int num){
        int lastNum = num%10;
        int temp = num/10;
        return lastNum*1000+temp;
    }

    static int twice(int num){
        return num*2%10000;
    }

    static int minus(int num){
        return (10000+(num-1))%10000;
    }
}
