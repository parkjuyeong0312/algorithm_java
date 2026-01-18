package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj15686 {
    static int N,M;
    static List<int[]> houses = new ArrayList<>();
    static List<int[]> chickens = new ArrayList<>();
    static int[][] dist;
    static int C;
    static int H;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        for(int i =0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int v = Integer.parseInt(st.nextToken());
                if (v==1) houses.add(new int[]{i,j});
                else if(v==2) chickens.add(new int[]{i,j});
            }
        }

        H=houses.size();
        C=chickens.size();
        dist = new int[H][C];

        for(int h = 0; h<H; h++){
            int hx = houses.get(h)[0];
            int hy = houses.get(h)[1];
            for(int c=0; c<C; c++){
                int cx = chickens.get(c)[0];
                int cy = chickens.get(c)[1];
                dist[h][c] = Math.abs(hx-cx)+Math.abs(hy-cy);
            }
        }

        int[] picked = new int[M];
        comb(0,0,picked);

        System.out.println(answer);

    }

    static void comb(int start, int dept, int[] picked){
        if(dept == M){
            answer = Math.min(answer, calcCityDistance(picked));
            return;
        }
        for(int i=start; i<C; i++){
            picked[dept]=i;
            comb(i+1, dept+1,picked);
        }
    }

    static int calcCityDistance(int[] picked){
        int sum=0;
        for(int h=0; h<H; h++){
            int best = Integer.MAX_VALUE;
            for(int idx : picked){
                best = Math.min(best, dist[h][idx]);

                if(best == 1) break;
            }
            sum+=best;

            if(sum>=answer) return sum;
        }
        return sum;
    }
}
