import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());//노드 개수
        int M = Integer.parseInt(st.nextToken());//케이스 개수

        //indegree가 0되는 부분이 result에 기록된다.
        //그니까, 자식->부모 순이 맞는듯

        //필요한거

        //인접리스트 구현
        ArrayList<Integer>[] graph = new ArrayList[N+1];//1부터 N까지 잇는 연결리스트
        //작업 큐
        Queue<Integer> q = new ArrayDeque<>();
        //결과값 적는 list
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0; i<=N; i++){
            graph[i]=new ArrayList<>();
        }

        //일단 indegree[i] : 노드 i의 indegree 노드의 개수(들어오는 노드의 개수)
        
        int[] indegree = new int[N+1];

        //indegree개수를 0으로 초기화.
        for(int i=1; i<=N; i++){
            indegree[i]=0;
        }
        
        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int child = Integer.parseInt(st.nextToken());
            int parent = Integer.parseInt(st.nextToken());

            graph[child].add(parent);
            //indegree 올리고,연결관계를 표시하지 않아도 될까?
            indegree[parent]+=1;
        }

        //indegree가 0인값을 큐에 넣기
        for(int i=1; i<=N; i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){//큐가 빌때까지 반복
            int node = q.poll();//큐에서 노드 꺼내고,
            result.add(node);//그리고 result에 추가하기
            for(int nxt : graph[node]){//연결된 노드의 indegree값 하나씩 다 내림.
                indegree[nxt]--;

                if(indegree[nxt]==0){//만약, indegree값이 0이된다면,
                    q.offer(nxt);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int num : result){
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }
}













