package solveByTopic.binarySearch;

//시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
//2 초	512 MB	134014	58653	43827	40.876%
//문제
//수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.
//
//Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표 Xj의 개수와 같아야 한다.
//
//X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.
//
//입력
//첫째 줄에 N이 주어진다.
//
//둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.
//
//출력
//첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.
//
//제한
//1 ≤ N ≤ 1,000,000
//        -109 ≤ Xi ≤ 109
//예제 입력 1
//        5
//        2 4 -10 4 -9
//예제 출력 1
//        2 3 0 3 1
//예제 입력 2
//        6
//        1000 999 1000 999 1000 999
//예제 출력 2
//        1 0 1 0 1 0

//배열로 입력받고,
//어쨋든 순서대로 출력을하긴해야되니까, 정렬용 배열, 출력용 순서 배열 이 순으로 두번 받아야할듯
//이걸 어카지?
//중복된걸 빼야하나?
//애초에 중복된걸 고려해서 배열을 만들면, 이분탐색으로 풀 필요가 없는 문제
//너무 복잡하게 가는딩.?
//

import java.util.*;
import java.io.*;

public class boj18870 {
    static int N;
    static int[] arr,sortArr,uniq;
    static int size;

    static int lowerIndex(int target){
        int start =0;
        int end = size;

        while(start<end){
            int mid = (start+end)/2;

            if(uniq[mid]>=target){
                end=mid;
            }else{
                start = mid+1;
            }
        }
        return start;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        sortArr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            sortArr[i] = num;
        }

        Arrays.sort(sortArr);

        uniq = new int[N];
        size =0;
        uniq[size++] = sortArr[0];

        for(int i=1; i<N;i++){
            if(uniq[size-1]!=sortArr[i]){
                uniq[size++]=sortArr[i];
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int num : arr){
            sb.append(lowerIndex(num)).append(" ");
        }
        System.out.println(sb);
    }
}
