package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

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

//        Arrays.sort(arr);
        mergeSort(0,N-1);

        StringBuilder sb = new StringBuilder();
        for(int i =0; i<N; i++){
            sb.append(arr[i]).append("\n");
        }

        sb.delete(sb.length()-1,sb.length());

        System.out.println(sb);
    }

    static void mergeSort(int left, int right){
        if(left>=right) return;
        int mid = (left+right)/2;

        mergeSort(left,mid);
        mergeSort(mid+1,right);

        merge(left,mid,right);
    }

    static void merge(int left, int mid, int right){
        int l = left;
        int r = mid+1;
        int k = left;

        while(l<=mid&&r<=right){
            if(arr[l]<=arr[r]) tmp[k++] = arr[l++];
            else tmp[k++] = arr[r++];
        }

        while(l<=mid) tmp[k++] = arr[l++];
        while(r<=right) tmp[k++] = arr[r++];

        for(int idx=left; idx<=right; idx++){
            arr[idx]=tmp[idx];
        }
    }
}
