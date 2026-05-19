package randomSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj13172 {
    static long M;
    static long MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        M = Integer.parseInt(br.readLine());
        StringTokenizer st;

        long ans=0;
        //입력
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken());
            int S=Integer.parseInt(st.nextToken());

            ans += S*func(N, MOD-2)%MOD;
            ans%=MOD;
//            result = func(N,MOD-2);
        }

        System.out.println(ans);

    }

    static long func(long N,long degree){
        if(degree==0){
            return 1;
        }

        long half = func(N,degree/2);

        long result = half*half%MOD;
        if(degree%2!=0) result*=N%MOD;

        return result%MOD;
    }
}
