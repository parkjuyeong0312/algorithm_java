package greedy;

//문제
//오늘은 공주님이 태어난 경사스러운 날이다. 왕은 이 날을 기념하기 위해 늘 꽃이 피어있는 작은 정원을 만들기로 결정했다.
//
//총 N개의 꽃이 있는 데, 꽃은 모두 같은 해에 피어서 같은 해에 진다.
//하나의 꽃은 피는 날과 지는 날이 정해져 있다. 예를 들어, 5월 8일 피어서 6월 13일 지는 꽃은 5월 8일부터 6월 12일까지는 꽃이 피어 있고, 6월 13일을 포함하여 이후로는 꽃을 볼 수 없다는 의미이다.
//(올해는 4, 6, 9, 11월은 30일까지 있고, 1, 3, 5, 7, 8, 10, 12월은 31일까지 있으며, 2월은 28일까지만 있다.)
//
//이러한 N개의 꽃들 중에서 다음의 두 조건을 만족하는 꽃들을 선택하고 싶다.
//
//공주가 가장 좋아하는 계절인 3월 1일부터 11월 30일까지 매일 꽃이 한 가지 이상 피어 있도록 한다.
//정원이 넓지 않으므로 정원에 심는 꽃들의 수를 가능한 적게 한다.
//N개의 꽃들 중에서 위의 두 조건을 만족하는, 즉 3월 1일부터 11월 30일까지 매일 꽃이 한 가지 이상 피어 있도록 꽃들을 선택할 때,
//선택한 꽃들의 최소 개수를 출력하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에는 꽃들의 총 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 다음 N개의 줄에는 각 꽃이 피는 날짜와 지는 날짜가 주어진다.
//하나의 날짜는 월과 일을 나타내는 두 숫자로 표현된다. 예를 들어서, 3 8 7 31은 꽃이 3월 8일에 피어서 7월 31일에 진다는 것을 나타낸다.
//
//출력
//첫째 줄에 선택한 꽃들의 최소 개수를 출력한다. 만약 두 조건을 만족하는 꽃들을 선택할 수 없다면 0을 출력한다.
//
//예제 입력 1
//        4
//        1 1 5 31
//        1 1 6 30
//        5 15 8 31
//        6 10 12 10
//예제 출력 1
//        2

//종료시점을 기준으로 정렬한다?
//시작시점으로 기준으로 정렬하는건?
//정렬 : 시작시점을 기준으로 잡는다.
//그럼 카운트를, 각 상황에 맞게 다르게 세야겟네
//시작 시점을 잡는 배열이나, 변수를 하나 두자.
//빠른 시작 시점을 기준으로 정렬하고, 시작시점이 같다면, 종료시점이 빠른걸 기준으로 정렬한다.
//그러면, 빠른 시점이 오게 되면, 일단 잡아서 체크하고, 만약, 그 뒤에 오는게 이어서 오지 않으면 다음걸 확인한다?
//하지만, 종료시점도 고려를 해야한다.
//시작시점이 빠르고, 종료시점이 엄청 긴 경우에는 -> 개이득
//종료시점>시작시점인 친구는 고려할 필요가 없는가?->그것도아님
//시작시점/종료시점을 고려했을때,
//1. 시작이 빠르고/종료가 길다.->고른다.(무조건 이득)
//2. 이떄부터는, 종료가 이전보다 작은얘들은 필요없음.
//3. 시작이 종료보다 이전이지만, 종료가 더 긴가? -> 종료가 더 길면 고르면됨.
//4. 종료가 더 길었을때, 골라.

//정렬 Nlog(N)
//10 000 000 000

//정렬을 , 시작 빠른순/ 종료 빠른 순으로 한다.\
//        1 1 5 31 (90), 3월 1일 기준, 약 60일 앞서있음.
//        1 1 6 30 (120/30) , 3월 1일 기준, 90일 앞서있고 , 5월30일 기준 30일 앞서있음.
//        5 15 8 31 (75/
//        6 10 12 10
//이렇게되면, 가장 긴 날짜가 잡히게 되는데, ->되도록이면 겹치는 날짜가 적었으면 좋겠다고 했었다.
//그러면 짧은 날짜로 하는게 좋을까? ->그렇다.
//

//5. 기간 순으로 정렬해야할까? -> 왜냐면 어짜피 부피 차지하기니까?
//근데 또 최소한으로 하는게좋잖아. 그건아닌거같아.

//조건 : 일수도 확인을 해야된다. 3월 1일부터, 11월 30일까지 한가지 이상 피어있어야함.
//빼봐야되나?

//일단 시간 순으로 정렬하는건 맞는것같음.
//가장 빠른순으로 정렬해야 순서대로 가니까, 시작일 빠른순으로 정렬을 먼저 하고,
//그다음에 세부적인 정렬을 어떻게할거냐인데,
//단순히 한번 정렬하는 걸로는 해결이 안될 거 같음.
//문제 정의 : 중복 기간이 짧은걸로 단순히 선택하기에는, 종료기점을 알 수 없다.
//



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//
public class boj2457 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Flower[] flowers = new Flower[N];
        StringTokenizer st;

        //날짜형식으로 받기
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int fm = Integer.parseInt(st.nextToken());
            int fd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());

            int start = toMMDD(fm,fd);
            int end = toMMDD(em,ed);

            flowers[i] = new Flower(start, end);
        }

        Arrays.sort(flowers, (a,b)->{
            if(a.start!=b.start) return a.start-b.start;//오름차순
            return b.end - a.end; //내림차순
        });


        int cur = 301;
        int target = 1130;
        int i =0;
        int ans = 0;

        while(cur<=target){
            int bestEnd = cur;

            //start가 cur보다 작을때,
            while(i<N && flowers[i].start<=cur){
                bestEnd = Math.max(bestEnd, flowers[i].end);
                i++;
            }

            if(bestEnd==cur){
                System.out.println(0);
                return;
            }

            ans++;
            cur=bestEnd;
        }

        System.out.println(ans);


    }

    static class Flower{
        int start,end;
        Flower(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    static int toMMDD(int m, int d){
        return m*100+d;
    }
}
