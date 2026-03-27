import java.util.*;
import java.lang.*;
import java.io.*;
// 2 // 테스트 케이스 수(t)
// 3 // 유저 수(n) , 0,1,2
// 1 // 친구 관계 수(k)
// 0 1 // 0과 1은 친구다.
// 2 // 친구관계 확인 케이스
// 0 1 // 0과 1은 친구관계 인가?
// 1 2 // 1과 2는 친구관계 인가?
// //=======
// 5// n,0,1,2,3,4
// 3// k 
// 0 1
// 1 2
// 3 4
// 2//k
// 0 2
// 1 3

// The main method must be in a class named "Main".
class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int testNum = 1;

        while(T-->0){
            sb.append("Scenario ").append(testNum++).append(":\n");
            int n = Integer.parseInt(br.readLine());
            parent = new int[n]; // 0~n-1까지니까
            for(int i=0; i<n; i++){
                parent[i]=i; // 부모를 자기 자신으로 지정
            }
            int k = Integer.parseInt(br.readLine());
            for(int i=0; i<k;i++){
                //0과 1은 친구다.
                st = new StringTokenizer(br.readLine());
                int user1 = Integer.parseInt(st.nextToken());
                int user2 = Integer.parseInt(st.nextToken());

                //부모를 찾자.
                int user1Parent = find(user1);
                int user2Parent = find(user2);

                //부모가 다르다면,
                if(user1Parent!=user2Parent){
                    union(user1Parent,user2Parent);
                }
                //부모가 같다면 그냥 다음턴 ㅇㅇ 
            }

            //이제 연결 다 했고,
            int m = Integer.parseInt(br.readLine());
            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int user1 = Integer.parseInt(st.nextToken());
                int user2 = Integer.parseInt(st.nextToken());

                if(find(user1)==find(user2)) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }

            sb.append("\n");
        }

        System.out.println(sb);
        
    }

    //함수를 만들자.
    // main함수에서 호출해야되는거니까, 앞에 static을 붙여야 호출이 가능
    static int find(int user){
        if(parent[user]==user){//만약 부모가 자신이라면(루트라면)
            return user;
        }
        //부모가 아니라면
        return parent[user]=find(parent[user]);
        //재귀형식으로, 경로 압축 진행
    }

    static void union(int user1, int user2){
        parent[user2] = user1;
    }
}


























