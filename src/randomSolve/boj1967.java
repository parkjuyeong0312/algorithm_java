package randomSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1967 {
    static List<Node1167>[] graph;
    static int ans;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1; i<=N; i++){
            graph[i]=new ArrayList<>();
        }

        for(int i =1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int curNode = Integer.parseInt(st.nextToken());
            int nextNode = Integer.parseInt(st.nextToken());
            while(nextNode!=-1){
                graph[curNode].add(new Node1167(nextNode,Integer.parseInt(st.nextToken())));
                nextNode=Integer.parseInt(st.nextToken());
            }
        }

//        for(int i=1; i<=N; i++){
//            System.out.print(i+":");
//            for(Node1167 node : graph[i]){
//                System.out.print(node.index+" ");
//            }
//            System.out.println();
//        }
        visited[1]=true;
        func(1);

        System.out.println(ans);

    }

    //순서
    //1을 넣는다.
    //2,3이 자식으로 있다.
    //2,3을 각각 for문으로 수행한다.
    //2에 대해 func(2)를 한다.
    //func(2)는 2에서의 최대값을 반환한다.
    //맨 끝에서는 반환할 값이 없다.


    static int func(int index){
        ArrayList<Integer> values = new ArrayList<>();
        //자식들의 값을 비교하여, 가장 큰 값을 비교
        for(Node1167 node : graph[index]){
            if(visited[node.index])continue;
            visited[node.index]=true;
            values.add(func(node.index)+ node.weight);
        }

        Collections.sort(values,(a,b)->b-a);
        //트리에서의 가장 큰 2값을 지름으로 설정해서 갱신함.
        if(values.size()>=2){
            ans = Math.max(values.get(0)+values.get(1),ans);
        }else if(values.size()==1) {
            ans = Math.max(values.get(0), ans);
        }

        if(values.isEmpty()) return 0;
        else return values.get(0);//최대값을 반환함.
    }

}
class Node1167{
    int index;
    int weight;

    public Node1167(int index, int weight) {
        this.index = index;
        this.weight = weight;
    }
}
