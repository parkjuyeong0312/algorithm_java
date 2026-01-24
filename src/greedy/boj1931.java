package greedy;
//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	128 MB	270580	93519	64246	32.083%
//문제
//한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다. 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자. 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다. 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.
//
//입력
//첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.
//
//출력
//첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.
//
//예제 입력
//        11
//        1 4
//        3 5
//        0 6
//        5 7
//        3 8
//        5 9
//        6 10
//        8 11
//        8 12
//        2 13
//        12 14
//예제 출력
//        4

//종료시간이 가장 빠른게 좋음.
//종료 시간 기준으로 정렬.
//종료시간 이후 값들을 또 나열

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1931 {
    static int[][] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        time = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }
        //시작시간에 대해서도 정렬을 해야하나?
        //그리디
        Arrays.sort(time, (a, b) ->{
            if(a[1]!=b[1]) return a[1]-b[1];
            return a[0]-b[0];
        });
//
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(time[i]));
        }
        int endTime = Integer.MIN_VALUE;
        int count =0;
        int startTime =Integer.MIN_VALUE;
        //중복에 대한 예외를 처리해야함.
        //
        for(int i=0; i< N; i++){
            if(time[i][0]>=endTime){
                startTime=time[i][0];
                endTime=time[i][1];//maxtime =4

                System.out.println("start : "+startTime+"  end : "+endTime);
                count++;
            }
        }

        System.out.println(count);
    }
}

