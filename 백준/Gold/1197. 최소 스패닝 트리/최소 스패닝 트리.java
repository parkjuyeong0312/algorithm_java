import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static ArrayList<int[]>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V+1];//nullpoint Exception
        visited = new boolean[V+1];

        for(int i=0; i<=V; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++){ // E번 반복한다. 
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());//가중치 c 

            graph[v1].add(new int[]{v2,w});
            graph[v2].add(new int[]{v1,w});
        }


        //이제 dfs를 구현해야하는데,
        System.out.print(prim(1,V));

        
    }
    static long prim(int start, int V){
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)-> Integer.compare(o1[1],o2[1]));

        pq.add(new int[]{start,0});

        long totalWeight = 0;
        int count =0;

        while(!pq.isEmpty()){
            int[] current = pq.poll();
            int vertex = current[0];
            int weight = current[1];

            if(visited[vertex]) continue;

            visited[vertex]=true;
            totalWeight+=weight;
            count++;

            if(count==V) break;

            for(int[] next : graph[vertex]){
                if(!visited[next[0]]){
                    pq.add(next);
                }
            }
        }
        return totalWeight;
    }
}




























