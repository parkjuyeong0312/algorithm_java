import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".

//위상정렬로 푸는 문제다.
//불가능 할 경우 어떤식으로 할 건지만 파악하면 될 거 같다.
//불가능 할때에는, 
//애초에 순환 참조가 발생하면, result의 길이가 n의 길이와 같은지를 확인하면 된다.


class Main {
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //우선 연결된 그래프가 있어야된다.
        //그리고 indegree하는 테이블도 필요한데
        int[] indegree = new int[N+1];
        //다 0으로 초기화 되어있음. 

        
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            graph[i]=new ArrayList<>();
        }

        

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());//3이면 3명
            if(size<=1) continue; // ?? size가 1보다 작으면 건너뛰어도 될까?
            int[] singers = new int[size];//0,1,2

            int child=Integer.parseInt(st.nextToken());
            int parent=Integer.parseInt(st.nextToken());

            //연결 부모 처리하고,
            graph[child].add(parent);
            //indegree 추가하고
            indegree[parent]++;

            for(int j=1; j<size-1; j++){//마지막에 한번은 빼야되니까 // 2번 더 조회해야하는데.
                child = parent;
                parent = Integer.parseInt(st.nextToken());//여기에 입력값이 안들어온다.
                graph[child].add(parent);
                indegree[parent]++;
            }
        }

        //위상정렬에서 처음에 큐를 선언한다.
        //그리고, 해당 큐에 indegree가 0인 값들을 넣는다.
        //그리고, 큐가 빌때까지 반복한다.

        Queue<Integer> q = new ArrayDeque<>();

        for(int i=1; i<=N; i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        int count = 0;

        while(!q.isEmpty()){
            int unit = q.poll();
            count++;
            sb.append(unit).append("\n");
            for(int parent : graph[unit]){
                //내 부모들을 둘러보고,연결을 끊는다.
                indegree[parent]--;

                if(indegree[parent]==0){
                    q.offer(parent);
                }
            }
        }

        if(count!=N){
            System.out.println(0);
        }else{
            System.out.println(sb);
        }

        // for(int i=1; i<=N; i++){
        //     System.out.println(i+" : "+graph[i]);
        // }
    }
}


























