//노드
//그래프 연결하기.
//첫 위치로부터 최단거리 구하기 : 다익스트라
//다익스트라는 우선순위큐를 사용한다.

//다익스트라도 아님. 거리 가중치가 없기 때문에,
//그냥 BFS로 방문하고, 
// 갱신하는 방식으로 진행하면 될 거같음.

import java.util.*;
import java.io.*;

class Solution {
    static int[] distance;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        //1. 노드별로 거리를 정해야되니까, distance배열을 선언한다.
        //노드의 개수만큼 선언한다. n은1부터시작하므로 n+1로 배열사이즈지정
        distance = new int[n+1];
        visited = new boolean[n+1];
        
        //2. 그 값은 -1로 초기화한다. 만약 해당 값이 -1이 아닌값이라면, 방문처리했다고 친다.
        // Arrays.fill(distance,-1);
        
        graph = new ArrayList<>();
        
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        //3. 그래프는 연결리스트로 구현한다. 요소는 int이다.
        for(int[] node : edge){
            int start = node[0];
            int end = node[1];
            
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        
        answer = bfs(1);
        //5. BFS를 구현한다.
        
        //6. 매번 노드 이동마다 max값보다 더 긴 거리값이 나오면 갱신한다.anser =0으로 초기화
        //max값보다 더 크다면 해당 answer++;로 갱신하고
        
        
        return answer;
    }
    
    static int bfs(int start){
        //1. 큐에 방문처리하고 넣는다.
        //2. 꺼낸다.
        //3. neighbor unit을 돈다.
            //방문처리 됐는지확인한다.
        visited[start]=true;
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(start);
        
        int count=0;
        int max = Integer.MIN_VALUE;
        
        
        while(!dq.isEmpty()){
            int unit = dq.poll();
            
            for(int neighbor : graph.get(unit)){
                
                if(visited[neighbor]) continue;
                
                visited[neighbor]=true;
                distance[neighbor]=distance[unit]+1;
                dq.offer(neighbor);
                
                if(max<distance[neighbor]){
                    max=distance[neighbor];
                    count =1;
                }else{
                    count+=1;
                }
            }
        }
        return count;
    }
}