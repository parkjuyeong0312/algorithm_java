package backTracking;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//
//
//재귀함수
//정의
//func(dept, arr)
//base-case
//if dept ==6 , arr 출력
//

public class boj6603 {
    static int[] arr;
    static int k;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        while (true){
            String line = br.readLine();
            if(line.equals("0")) break;

            StringTokenizer st = new StringTokenizer(line);

            k = Integer.parseInt(st.nextToken());
            sb = new StringBuilder();
            arr = new int[k];

            for(int i = 0; i<k; i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }

            func(0,0,new int[6]);
            System.out.println(sb);
        }
    }

    static void func(int idx, int count, int[] picked){
        if(count == 6){
            for(int i=0; i<6; i++){
                sb.append(picked[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        picked[count] = arr[idx];
        func(idx+1, count+1, picked);
        if(k-(idx)>6-count){//7-1>6-0
            func(idx+1,count,picked);//고르지 않고 넘어갔을때,
        }
    }
}
