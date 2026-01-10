package backTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj15654 {
    static int N,M;
    static int[] sortArr;
    static int[] arr;
    static boolean[] isVisited;
    static StringBuilder sb = new StringBuilder();

    static void func(int k){
        if(k==M){
            for(int i=0; i<M;i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0; i<N; i++){
            if(isVisited[i]) continue;
            arr[k]=sortArr[i];
            isVisited[i]=true;
            func(k+1);
            isVisited[i]=false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        isVisited = new boolean[N];
        sortArr = new int[N];

        st=new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            sortArr[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sortArr);

        func(0);

        System.out.print(sb);
    }
}
