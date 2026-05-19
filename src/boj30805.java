


//1. 부분수열은 어떻게 구하는가?
//우선 부분수열을 어떻게 구하는지 떠올려보자.
//이거 같은 경우는,, 그냥 순차탐색으로 싹다 구하면 안되는건가?
//같은게 있다면, 뭐 어떡할건데

//차근차근해보자
//N,M 길이가 각각 100이니까,
//반복문으로, 원소를 구해보자.
//그렇게 되어서 원소를 추가하고, 이에 대해서 나중에 부분수열 원소들로, 우선순위큐에 부분집합을 추가하고, 그다음에 우선순위큐나 , 그리디 방식으로 꺼낸다.

//2. 우선순위 큐는 어떻게 설정할 것인가?


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj30805 {
    static int N,M;
    static int[] A,B;
    static ArrayList<Integer> partSetUnit;
    static PriorityQueue<Integer> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            A[i]=Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        B = new int[M];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<M; i++){
            B[i]=Integer.parseInt(st.nextToken());
        }


        //반복문으로 원소를 구해보자.
        partSetUnit = new ArrayList<>();

        int index = 0;


        for(int i=0; i<N; i++){
            for(int j=index; j<M; j++){
                if(A[i]==B[j]){
                    partSetUnit.add(A[i]);
                    index=j+1;
                    break;
                }
            }
        }

        int maxIndex =0;

        ArrayList<Integer> ans = new ArrayList<>();

        //부분수열을 결정하는 로직이 틀렸다.

        for(int i=0; i<partSetUnit.size(); i++){
            int maxValue = 0;
            for(int j=maxIndex; j<partSetUnit.size();j++){
                if(partSetUnit.get(j)>maxValue){
                    maxValue=partSetUnit.get(j);//초기화하고,
                    maxIndex=j+1;
                }
            }
            if(maxValue==0) break;
            ans.add(maxValue);
        }
        System.out.println(partSetUnit);

        int size =ans.size();

        System.out.println(size);

        if(size>0){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<size ; i++){
                sb.append(ans.get(i)).append(" ");
            }
            System.out.println(sb);
        }


    }

}
