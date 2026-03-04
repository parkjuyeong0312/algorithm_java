import java.util.*;

class Solution {
    public int[] solution(int[][] edges, int[] target) {
        int n = target.length;
        List<Integer>[] adj = new ArrayList[n+1];
        for(int i=1; i<=n; i++) adj[i]=new ArrayList<>();
        for(int[] edge : edges) adj[edge[0]].add(edge[1]);
        
        // 자식 노드 번호 순으로 정렬 (문제 규칙)
        for (int i = 1; i <= n; i++) Collections.sort(adj[i]);
        
        int[] edgeIdx = new int[n+1];//각 노드가 가르키는 현재 간선 인덱스
        List<Integer> order = new ArrayList<>();//리프노드에 도달하는 순서 기록
        int[] leafCount = new int[n+1];//각 리프 노드에 쌓인 숫자 개수
        
        //edgeIdx : 어디로 길이 열려있는가
        while(true){
            int now =1;
            while(adj[now].size()>0){//리프노드까지 이동
                int next = adj[now].get(edgeIdx[now]);
                edgeIdx[now]=(edgeIdx[now]+1)%adj[now].size();
                now=next;
            }
            
            order.add(now);
            leafCount[now]++;//각 리프노드에 쌓인 숫자개수
            
            if(leafCount[now]>target[now-1]) return new int[]{-1};
            
            boolean allSatisfied = true;
            
            for(int i=1; i<=n; i++){
                if(target[i-1]==0) continue;
            
            
                if(leafCount[i]*3<target[i-1]||leafCount[i]>target[i-1]){
                    allSatisfied=false;
                    break;
                }
            }
            
            if(allSatisfied) break;
        }
        
        int[] result = new int[order.size()];
        for(int i=0; i<order.size(); i++){
            int node = order.get(i);
            leafCount[node]--;
            
            //1,2,3중 사전순으로 작은 값부터 시도
            for(int val = 1; val<=3; val++){
                int remainTarget = target[node-1]-val;
                
                if(remainTarget>=leafCount[node]&&remainTarget<=leafCount[node]*3){
                    result[i]=val;
                    target[node-1]-=val;
                    break;
                }
            }
        }
                                    
                                    
        return result;           
                                    
    }
                                    
                                    
                                    
}