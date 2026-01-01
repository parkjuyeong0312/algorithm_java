package stack;

//문제
//KOI 통신연구소는 레이저를 이용한 새로운 비밀 통신 시스템 개발을 위한 실험을 하고 있다.
//실험을 위하여 일직선 위에 N개의 높이가 서로 다른 탑을 수평 직선의 왼쪽부터 오른쪽 방향으로 차례로 세우고,
//각 탑의 꼭대기에 레이저 송신기를 설치하였다.
//모든 탑의 레이저 송신기는 레이저 신호를 지표면과 평행하게 수평 직선의 왼쪽 방향으로 발사하고,
//탑의 기둥 모두에는 레이저 신호를 수신하는 장치가 설치되어 있다.
//하나의 탑에서 발사된 레이저 신호는 가장 먼저 만나는 단 하나의 탑에서만 수신이 가능하다.
//
//예를 들어 높이가 6, 9, 5, 7, 4인 다섯 개의 탑이 수평 직선에 일렬로 서 있고,
//모든 탑에서는 주어진 탑 순서의 반대 방향(왼쪽 방향)으로 동시에 레이저 신호를 발사한다고 하자.
//그러면, 높이가 4인 다섯 번째 탑에서 발사한 레이저 신호는 높이가 7인 네 번째 탑이 수신을 하고,
//높이가 7인 네 번째 탑의 신호는 높이가 9인 두 번째 탑이, 높이가 5인 세 번째 탑의 신호도 높이가 9인 두 번째 탑이 수신을 한다.
//높이가 9인 두 번째 탑과 높이가 6인 첫 번째 탑이 보낸 레이저 신호는 어떤 탑에서도 수신을 하지 못한다.
//
//탑들의 개수 N과 탑들의 높이가 주어질 때,
//각각의 탑에서 발사한 레이저 신호를 어느 탑에서 수신하는지를 알아내는 프로그램을 작성하라.
//
//입력
//첫째 줄에 탑의 수를 나타내는 정수 N이 주어진다. N은 1 이상 500,000 이하이다.
//둘째 줄에는 N개의 탑들의 높이가 직선상에 놓인 순서대로 하나의 빈칸을 사이에 두고 주어진다.
//탑들의 높이는 1 이상 100,000,000 이하의 정수이다.
//
//출력
//첫째 줄에 주어진 탑들의 순서대로 각각의 탑들에서 발사한 레이저 신호를 수신한 탑들의 번호를 하나의 빈칸을 사이에 두고 출력한다.
//만약 레이저 신호를 수신하는 탑이 존재하지 않으면 0을 출력한다.

//예제 입력 1
//        5
//        6 9 5 7 4
//예제 출력 1
//        0 0 2 2 4

//<풀이>
//<생각>
//이 풀이를 보고 스택을 굳이 써야할까? 그냥 배열로 받고 순회를 하면 되는거아니야?
    //N의 크기는 1억이다. 제한시간을 1.5초, 넉넉잡아, O(N)정도의 시간복잡도를 요구한다.
    //순회 방식으로 접근하면 시간초과로 터져버릴 것이다.
//각 레이저에 따라, 자신의 레이저를 어떤 송신탑이 수신했는지를 담아야한다.
    //<어떤 탑이 수신 했는지>를 담는 N의 크기의 자료구조가 필요하다.(스택/배열)
//레이저 송신탑 보다 가장 처음으로 큰 높이를 갖는 수신탑을 찾아야한다.
    //순회방식은 n^2이 나오기 대문에 안된다.
    //pop형식으로 하는것도 문제가 되는게, 결국엔 다음 원소를 또 확인해야하는데 곤란한거 같다.
//<풀이방법>
    //스택을 사용한다.
    //새로운 원소(A)가 push 될 때, 스택에서 가장 위에 있는 원소(B)보다 값이 크다면, 이후에 수신받을 수 있는 가능성이 없으므로, pop해서 버린다. if(A<B) pop
    //이를 반복한다.for/while
    //어떻게 index번호를 추출하지?
        //pop 될 때, 가장 앞의 원소의 index를 추가한다.
        //처음부터 끝까지 순회를 마치면, 스택을 pop하면서, 같은 과정을 거치고, 마지막 원소는 0을 넣는다.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class boj2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] inputs = br.readLine().split(" ");

        Deque<Top> stack = new ArrayDeque<>();

        Top[] topArray = new Top[N];
        for(int i = 0; i<N; i++){
            topArray[i] = new Top(i+1,Integer.parseInt(inputs[i]));
        }


        //첫 원소 push
        stack.push(topArray[0]);


        for(int i = 1; i< inputs.length; i++){
            Top nextTop = topArray[i];
            //앞의 원소가 더 클때까지

            while(!stack.isEmpty()&&stack.peek().height<nextTop.height){
                Top popTop = stack.pop();
                if(!stack.isEmpty()){
                    popTop.receiveTop = stack.peek().topNumber;
                }else{
                    popTop.receiveTop=0;
                }
            }
            stack.push(nextTop);
        }


        //남은것들 처리
        while(!stack.isEmpty()){
            Top popTop = stack.pop();
            if(!stack.isEmpty()){
                popTop.receiveTop = stack.peek().topNumber;
            }else{
                popTop.receiveTop=0;
            }
        }

        for(int i = 0; i<N; i++){
            Top top = topArray[i];
            System.out.println(top.receiveTop);
        }

    }

    static class Top{
        int topNumber;
        int height;
        int receiveTop;

        public Top(int topNumber,int height){
            this.topNumber = topNumber;
            this.height = height;
        }
    }

}
