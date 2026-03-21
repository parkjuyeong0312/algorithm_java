import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".

//<문제조건>
//보석 N개
//보석은 각각 M,V가 있음.(1,000,000)
//가방을 K개 가지고 있음(300,000)
//가방에 담을 수 있는 최대 무게 C (100,000,000)
//시간제한은 1초

//<알고리즘 선택>
//그리디 알고리즘을 사용한다.

//<풀이>
//가방에 담을 수 있는 아이템은 단 하나이다.
//가방에는 가장 비싼 아이템을 먼저 넣어야된다."먼저"-> 우선순위 큐를 사용한다.
//가방은 무게라는 조건이 걸려있다.
//가장 높은 가치의 보석을, 가장 작은 가방에 넣는게 좋다.
//따라서, 가방을 무게 기준 오름차순
//보석도 무게 기준 오름차순으로 해서, 가방에 넣을 수 있는 아이템을 우선순위큐에 다 넣어놓고,
//그다음에 가장 가치가 큰 보석을 꺼내서 넣는다.

class Jewelry{
    int mass;
    int value;

    Jewelry(int mass, int value){
        this.mass = mass;
        this.value = value;
    }
}



class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        //보석은 N개
        Jewelry[] jewelry = new Jewelry[N];
        //가방은 K개
        int[] bags = new int[K];
        //보석이 주어진다.
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int mass = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            jewelry[i]=new Jewelry(mass,value);
        }

        for(int i=0; i<K; i++){
            bags[i]=Integer.parseInt(br.readLine());
        }
        

        //가방 무게로 낮->높 순으로 오름차순
        Arrays.sort(jewelry,(Jewelry o1,Jewelry o2)->{
            //무게가 같다면, 가치는 높->낮 순으로 내림차순
            if(o1.mass==o2.mass){
                return o2.value-o1.value;
            }else{
                return o1.mass-o2.mass;
            }
        });

        Arrays.sort(bags);
        

        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());//기본적으로 오름차순이다.
        

        //i번째 가방부터 비교한다.
        for(int i=0,j=0;i<K;i++){
            //j가 N보다 작으면서, 가방의 무게보다 작아야됨.
            while(j<N&&jewelry[j].mass<=bags[i]){
                pq.offer(jewelry[j++].value);
            }

            if(!pq.isEmpty()){
                ans+=pq.poll();
            }
        }
        System.out.println(ans);
    }
}





























