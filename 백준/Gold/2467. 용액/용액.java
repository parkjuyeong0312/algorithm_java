import java.util.*;
import java.lang.*;
import java.io.*;

//투포인터로 풀겠습니다.
//두 포인터가 가르키는 값이
//1. 양수인경우
    //mix > 0 : right+1;
//2. 음수인경우
    //mix <0  : left+1;
//3. 0인경우 -> 종료
    //print(left+" "+right);

// The main method must be in a class named "Main".
class Main {
    static int MAX_VALUE=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] solutions = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            solutions[i]=Integer.parseInt(st.nextToken());
        }

        int left =0;
        int right = N-1;
        int min=MAX_VALUE;
        int[] ans = new int[2];


        while(left<right){
            int a = solutions[left];
            int b= solutions[right];

            int mix = a+b;

            if(mix==0){
                ans[0]=solutions[left];
                ans[1]=solutions[right];
                break;
            }else if(mix>0){
                if(min>=mix){
                    ans[0]=solutions[left];
                    ans[1]=solutions[right];
                    min=mix;
                }
                right-=1;
            }else{
                if(min>=-mix){
                    ans[0]=solutions[left];
                    ans[1]=solutions[right];
                    min=-mix;
                }
                left+=1;
            }

        }

        System.out.println(ans[0]+" "+ans[1]);

        
    }
}