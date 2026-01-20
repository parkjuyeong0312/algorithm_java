package sort;
//문제
//준규는 숫자 카드 N장을 가지고 있다. 숫자 카드에는 정수가 하나 적혀있는데, 적혀있는 수는 -262보다 크거나 같고, 262보다 작거나 같다.
//준규가 가지고 있는 카드가 주어졌을 때, 가장 많이 가지고 있는 정수를 구하는 프로그램을 작성하시오. 만약, 가장 많이 가지고 있는 정수가 여러 가지라면, 작은 것을 출력한다.
//입력
//첫째 줄에 준규가 가지고 있는 숫자 카드의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개 줄에는 숫자 카드에 적혀있는 정수가 주어진다.
//
//출력
//첫째 줄에 준규가 가장 많이 가지고 있는 정수를 출력한다.
//
//예제 입력
//        5
//        1
//        2
//        1
//        2
//        1
//예제 출력
//        1

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

//1. 정렬
//2. 정렬 후에, mxcnt, cnt, mxval를 저장해놓음.
public class boj11652 {
    static int N;
    static long[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());

        arr = new long[N];

        for(int i=0; i<N; i++){
            arr[i]=Long.parseLong(br.readLine());
        }

        Arrays.sort(arr); //NlogN

        int mxcnt=0;
        long mxval = Long.MIN_VALUE;

        //1. arr[i]값을 확인한다.
        //이전 temp값과 같은지 확인한다.
        //2. temp값에 저장한다.
        //3. count값을 올린다.
        //4. mxcnt인지 확인한다.
        //5. mxcnt이면 maxval을 초기화한다.
        int cnt = 0;
        long temp = Long.MIN_VALUE;

        for(int i=0; i<N; i++){//N
            if(temp==arr[i]){
                cnt+=1;
                if(mxcnt<cnt){
                    mxcnt=cnt;
                    mxval=arr[i];
                }
            }else{
                cnt=1;
                if(mxcnt<cnt){
                    mxcnt=cnt;
                    mxval=arr[i];
                }
                temp=arr[i];
            }

        }

        System.out.println(mxval);
    }

}
