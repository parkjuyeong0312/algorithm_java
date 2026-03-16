import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] nums;
    static int[][] visited;
    static int N,M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N+1];
        visited = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            Arrays.fill(visited[i],-1);
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            nums[i]=Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            sb.append(check(left,right)).append("\n");
        }

        System.out.println(sb);
        // for(int i=1; i<=N; i++){
        //     System.out.println(Arrays.toString(visited[i]));
        // }
    }

    //visited가 초기화가 안되고 있는 상황이다. 
    static int check(int left, int right){
        if(left>N||right<0) return 1;
        if(visited[left][right]!=-1) return visited[left][right];//-1이 아니라면, 현재 값을 반환.
        //visited값이 -1일때, 그니까 처음 방문할때,
        //만약 left>=right라면, 팰린드롬 성공이니까 1을 반
        if(left>right) return 1;//팰린드롬 성공
        //nums 기준으로, left와 right가 같다면, 다음 팰린드롬을 확인해봐야함.
        if(nums[left]==nums[right]){
            
            visited[left][right]=check(left+1,right-1);
        }else{//같지 않다면, 0을 반환함.
            visited[left][right]=0;
        }

        // System.out.println("left:"+left+" right:"+right+" value: "+visited[left][right]);
        return visited[left][right];
    }
}

        
        //이차원 배열을 선언하자.
        //이차원 배열로, 해가지고 좌표별로 지정하는거다.
        //0: 팰린드롬 실패
        //1 : 팰린드롬 성공
        //-1 : 초기화

        //재귀 식으로 해서 진행을 하는데,
        //int func()
        //if(visited[left][right]!=-1) 이미 방문 한 거라면, return visited[left][right]        
        //if(left>=right라면, return 1) : 무사히 이전까지 다 통과했다는 의미이니까.
        //그럼 nums[left]==nums[right]일 경우에는, 한번 더 재귀로 들어가야됨.
            //visited[left][right]=func(left+1,right-1)
        //nums[left]!=nums[right] : return 0

        //이런식으로 해가지고, 출력하면 됨!

    //시간복잡도가 오바되어서 터질거다.
    //그냥 일일히 질문수만큼 비교를 한다면, 20억의 연산인데
    //지금은 시간복잡도가 0.5초이다.

    //그래서, 팰린드롬인지 판단할 알고리즘이 필요하다.
    //뭘까?
    //이차원 배열로 해가지고 
























