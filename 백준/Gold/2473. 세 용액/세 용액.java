import java.util.*;
import java.lang.*;
import java.io.*;


// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] solutions = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            solutions[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(solutions);

        long min = Long.MAX_VALUE;
        long[] ans = new long[3];
        
        for(int i=0; i<=N-3; i++){
            int left =i+1;
            int right = N-1;
            while(left<right){
                long mix = solutions[i]+solutions[left]+solutions[right];

                if(mix==0){
                    ans[0]=solutions[i];
                    ans[1]=solutions[left];
                    ans[2]=solutions[right];
                    break;
                }
                else if(mix<0){
                    if(min>Math.abs(mix)){
                        min=Math.abs(mix);
                        ans[0]=solutions[i];
                        ans[1]=solutions[left];
                        ans[2]=solutions[right];
                    }
                    left+=1;
                }else{
                    if(min>Math.abs(mix)){
                        min=Math.abs(mix);
                        ans[0]=solutions[i];
                        ans[1]=solutions[left];
                        ans[2]=solutions[right];
                    }
                    right-=1;
                }
            }
        }

        System.out.println(ans[0]+" "+ans[1]+" "+ans[2]);
        
    }
}