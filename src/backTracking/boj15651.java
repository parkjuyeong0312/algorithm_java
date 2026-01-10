package backTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15651 {
    static int N,M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    static void func(int k){
        if(k==M){
            for(int i=0; i<M;i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i =0; i<N;i++){
            arr[k]=i+1;
            func(k+1);
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        func(0);

        System.out.print(sb);
    }
}
