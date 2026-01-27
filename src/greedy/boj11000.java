package greedy;
//문제
//수강신청의 마스터 김종혜 선생님에게 새로운 과제가 주어졌다.
//김종혜 선생님한테는 Si에 시작해서 Ti에 끝나는 N개의 수업이 주어지는데, 최소의 강의실을 사용해서 모든 수업을 가능하게 해야 한다.
//참고로, 수업이 끝난 직후에 다음 수업을 시작할 수 있다. (즉, Ti ≤ Sj 일 경우 i 수업과 j 수업은 같이 들을 수 있다.)
//수강신청 대충한 게 찔리면, 선생님을 도와드리자!
//
//입력
//첫 번째 줄에 N이 주어진다. (1 ≤ N ≤ 200,000)
//이후 N개의 줄에 Si, Ti가 주어진다. (0 ≤ Si < Ti ≤ 10^9)
//
//출력
//강의실의 개수를 출력하라.
//
//예제 입력 1
//        3
//        1 3
//        2 4
//        3 5
//예제 출력 1
//        2

//200,000

//1. 시작시간 오름차순 정렬로 해서 조건만 맞으면(Ti<=Sj) 배열에서 제외?한다.
//제외를 어케하는데?
//종료시간은 어떤게 좋을까? 내림차순?오름차순? 중요한가? -> 상관없다.
//"최소의 강의실"
//만약, 사용을 한 부분에 대해서는 앞으로 어떻게 처리할거지?
//20만개의 객체를 생성할 것인가?
//반복문의 조건은? -> 모든 강의실을 다 예약하면,
//예약할때마다 count값을 올린다. 그 값이 N이 되면 멈춘다.

//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj11000 {
    static class ClassTime{
        int start;
        int end;

        public ClassTime(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ClassTime[] classTimes = new ClassTime[N];

        StringTokenizer st;


        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int s= Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            classTimes[i]= new ClassTime(s,e);
        }

        //정렬해야됨.
        Arrays.sort(classTimes, (a,b)->{
            if(a.start!=b.start) return Integer.compare(a.start, b.start);
            return Integer.compare(a.end,b.end);
        });


        PriorityQueue<Integer> pq = new PriorityQueue<>();

        //시작 시간 순으로 배열해놓았으니,
        //우선순위큐에서는 종료시간 순으로 정렬해준다.
        //가장 빠른 종료시간<=시작시간이라면, 같은 강의실 개념이므로,기존의 종료시간을 빼고, 새로운 종료시간을 갱신하고,
        //가장 빠른 종료시간>시작시간이라면, 다른 강의실이므로, 종료시간을 추가한다.
        for(ClassTime ct : classTimes){
            if(!pq.isEmpty()&&pq.peek()<=ct.start){
                pq.poll();
            }
            pq.offer(ct.end);
        }

        System.out.println(pq.size());

    }
}
