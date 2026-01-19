package sort;
//수 정렬하기
//
//문제
//N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
//
//출력
//첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
//
//예제 입력
//        5
//        5
//        2
//        3
//        4
//        1
//예제 출력
//        1
//        2
//        3
//        4
//        5

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj2750 {
    static int[] arr;
    static int[] tmp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        tmp = new int[N];

        for(int i=0; i<N; i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        mergeSort(0,N-1);
//        quickSort(0,N);

        for(int i =0; i<N; i++){
            System.out.println(arr[i]);
        }

    }

    static void mergeSort(int left, int right){
        if(left>=right) return ; // 원소 1개면 끝

        int mid = (left + right)/2;

        mergeSort(left,mid);
        mergeSort(mid+1,right);

        merge(left,mid,right);
    }

    static void merge(int left, int mid, int right){
        int i = left; //왼쪽 포인터
        int j = mid+1;//오른쪽 포인터
        int k = left; //temp에 넣을 위치

        while(i<=mid && j<=right){
            if(arr[i]<=arr[j]) tmp[k++] = arr[i++];
            else tmp[k++] = arr[j++];
        }

        while(i<=mid) tmp[k++]=arr[i++];

        while(j<=right) tmp[k++] = arr[j++];

        for(int idx = left; idx<=right; idx++){
            arr[idx]=tmp[idx];
        }
    }

    static void quickSort(int start, int end){
        if(end-1<=start) return;

        int pivot = arr[start];
        int l = start+1;
        int r = end -1;

        while(true){
            while(l<=r && arr[l]<=pivot) l++;
            while(l<=r && arr[r]>=pivot) r--;

            if(l>r) break;

            swap(l,r);
        }

        swap(start,r);

        quickSort(start,r);
        quickSort(r+1,end);
    }

    static void swap(int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b]=tmp;
    }
}
