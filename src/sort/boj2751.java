package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//문제
//N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
//
//출력
//첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
//
//예제 입력
//        5
//        5
//        4
//        3
//        2
//        1
//예제 출력
//        1
//        2
//        3
//        4
//        5
public class boj2751 {
    static int[] arr;
    static int[] tmp;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        tmp = new int[N];

        for(int i=0; i<N; i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        mergeSort(0,N-1);

        for(int i =0; i<N; i++){
            System.out.println(arr[i]);
        }
    }

    static void mergeSort(int left, int right){
        if(left>=right) return;
        int mid = (left+right)/2;

        mergeSort(left,mid);
        mergeSort(mid+1,right);

        merge(left,mid,right);
    }

    static void merge(int left, int mid, int right){
        int i = left;
        int j = mid+1;
        int k = left;

        while(i<=mid&&j<=right){
            if(arr[i]<=arr[j]) tmp[k++]=arr[i++];
            else tmp[k++]=arr[j++];
        }

        while(i<=mid){
            tmp[k++]=arr[i++];
        }

        while(j<=right){
            tmp[k++]=arr[j++];
        }

        for(int idx = left; idx<=right;idx++){
            arr[idx]=tmp[idx];
        }
    }
}
