package greedy;

//문제
//매우 큰 도화지에 자를 대고 선을 그으려고 한다. 선을 그을 때에는 자의 한 점에서 다른 한 점까지 긋게 된다. 선을 그을 때에는 이미 선이 있는 위치에 겹쳐서 그릴 수도 있는데, 여러 번 그은 곳과 한 번 그은 곳의 차이를 구별할 수 없다고 하자.
//
//이와 같은 식으로 선을 그었을 때, 그려진 선(들)의 총 길이를 구하는 프로그램을 작성하시오. 선이 여러 번 그려진 곳은 한 번씩만 계산한다.
//
//입력
//첫째 줄에 선을 그은 횟수 N (1 ≤ N ≤ 1,000,000)이 주어진다. 다음 N개의 줄에는 선을 그을 때 선택한 두 점의 위치 x, y (-1,000,000,000 ≤ x < y ≤ 1,000,000,000)가 주어진다.
//
//출력
//첫째 줄에 그은 선의 총 길이를 출력한다.
//
//예제 입력 1
//        4
//        1 3
//        2 5
//        3 5
//        6 7
//예제 출력 1
//        5

//풀이
//N이 100만이므로, for문을 두번돌리게되면 1000억이다.
// 절대 시간초과가 난다.
//N lon N을 한다고 하면, 600만정도 이니까, 정렬은 할 수 있다.

//1. 시작 순으로 정렬한다.
//2. 종료 시점은 상관없다.

//순회는 한번만 한다.
//조건
//while(i<N)
//if(기존 end>= 새 start)
    //기존 end = 새 end
    //i++
    //continue
//if(기존 end < 새 start)

//sum에다가 더하는 식으로 하기만 하면 됨.

//시작순으로 정렬했다.
//-> 종료시간을 우선순위 큐에 넣는다.
//-> 가장 빠른 종료시간 >= 시작시간이라면, 길이를 이어 붙힐 수 있는 것이다.
    //poll,후에 offer
//->가장 빠른 종료시간 < 시작시간이라면 -> 더이상 이전 길에 덧그려지는 일은 없음. 그냥 count를 올리고 갱신하면 됨.
//우선순위 큐에 넣을 필요가없음.

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//count를 어떻게 처리하지?

//192mb
//long -> 8byte,
public class boj2170 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] lines = new long[N][2];
        StringTokenizer st;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            lines[i][0]=Long.parseLong(st.nextToken());
            lines[i][1]=Long.parseLong(st.nextToken());
        }

        Arrays.sort(lines,(a,b)->Long.compare(a[0],b[0]));

//        for(int i=0; i<N; i++){
//            System.out.println(Arrays.toString(lines[i]));
//        }

        long start;
        long end;
        long sum =0;
        int i=0;

        while(i<N){
            start = lines[i][0];
            end=lines[i][1];
            i++;

            //i가 범위를 넘지않으면서
            //시작점이 종료시점 이전, 이어그릴 수 있을때
            while(i<N&&lines[i][0]<=end){
                end = Math.max(lines[i][1],end);
                i++;
            }
            //i가 다 끝낫거나,
            //시작점>종료시점일때
//            System.out.println(" start : "+ start+"  end : "+ end);
            sum+=end-start;
        }

        System.out.println(sum);

    }
}
