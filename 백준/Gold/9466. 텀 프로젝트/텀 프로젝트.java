import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
//- 프로젝트 팀원 수에는 제한이 없다.
//- 모든 학생들이 같은 팀일 수도 있고, 한 팀만 있을 수도 있다.
//
//- 어느 프로젝트에도 속하지 않는 학생들의 수?

// "혼자 하고 싶다." -> 팀 매칭이 안된거 아닌가?
// "사이클이 돌아야 한 팀이다"가  포인트인 것 같다.

//근데 뭐 순서가 있다보니까, 위상정렬의 개념일 거 같은데
//위상정렬의 특징상, 사이클이 있게되면, 삭제가 되지 않느다.
//위상정렬로 삭제되는 인원들만 냅두면 되지 않을까?

//맨 처음에 초기화할때, indegree는 모두 0으로 초기화하는데, 자기 자신은 1로 하는걸로하자. 


//1.테스트 케이스 수 T만큼 입력을 받는다.
// 위상정렬은 indegree 배열을 선언해야한다.
// indegree[선택번호]+1;

//위상정렬 싹 한번 돌리고, poll하나 될때마다 count +1 ; 
//더이상 큐에 남아있는게 없다.




class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //테스트 케이스 입력
        int T = Integer.parseInt(br.readLine());
        //n 입력받기
        StringTokenizer st;
        // ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        while(T-->0){//T가 0이 되면 그만 횟수만큼 반복
            int n = Integer.parseInt(br.readLine());
            int count= 0;

            // for(int i=0; i<=n; i++){
            //     graph.add(new ArrayList<>());
            // }

            //indegree 초기화
            //기본적으로 0으로 초기화한다.
            int[] indegree = new int[n+1];
            int[] prefList = new int[n+1];
            //근데 생각해보니, 나는 하나밖에 못가르키잖아!
            //그냥 누가 누구가르키는지만 알면되네
            //
            //i : 학생 index
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++){
                int prefPersonIndex = Integer.parseInt(st.nextToken());
                //선호하는 사람의 indegree를 하나 올린다.
                indegree[prefPersonIndex]+=1;
                prefList[i]=prefPersonIndex;
                // graph.get()
            }

            Queue<Integer> q = new ArrayDeque<Integer>();

            for(int i=1; i<=n; i++){
                if(indegree[i]==0){
                    q.offer(i);
                }
            }

            while(!q.isEmpty()){
                int unit = q.poll();
                int pref = prefList[unit];
                count+=1;

                //1을 줄인다.
                indegree[pref]-=1;
                if(indegree[pref]==0){
                    q.offer(pref);
                }
            }

            sb.append(count).append("\n");
            
        }

        System.out.println(sb);
        
    }
}



























