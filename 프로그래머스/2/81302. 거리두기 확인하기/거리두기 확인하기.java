
// bfs로 풀거다.

// <변수 설정>
// //초기화
// 대기실 크기 : i=0~i=4
// String[] place = places[i];
// (5번의 반복) : graph[j][k]=place[j].charAt(k)
// P의 포지션을 ArrayList에 저장해놓고, 꺼내서 쓰자.
// 그리고 bfs를 각각 돌리고, return값을 boolean으로 둔다.
// if(!bfs) solution[i]= 0, continue

// solution [i]=1
import java.util.*;
import java.io.*;



class Solution {
    static Character[][] graph;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        ArrayList<int[]> pList;
        
        //T : 테스트  케이스 횟수
        for(int T=0; T<5; T++){
            //place는 강의실 한개를 의미함.
            String[] place = places[T];
            //graph는 강의실 내부 매트릭스를 의미함. 5*5크기임.
            graph = new Character[5][5]; 
            pList = new ArrayList<>();
            for(int i=0; i<5; i++){
                for(int j=0; j<5; j++){
                    char unit = place[i].charAt(j);
                    if(unit == 'P') pList.add(new int[]{i,j});
                    graph[i][j]=unit;
                }
            }
            answer[T]=1;
            //bfs시작
            for(int[] pos : pList){
                if(!bfs(pos)){
                    answer[T]=0;
                    break;
                }
            }
            
            
            System.out.println();
            
            
            // //디버깅용
            // for(int i=0; i<5; i++){
            //     for(int j=0; j<5; j++){
            //         System.out.print(graph[i][j]);
            //     }
            //     System.out.println();
            // }
            // System.out.println();
        }
        
        
        
        return answer;
    }
    
    //1. p위치는 잘 들어가고 있다.
    
    
    static boolean bfs(int[] pos){
        int x = pos[0];
        int y = pos[1];
        
        
        boolean[][] visited = new boolean[5][5];
        int[][] dept = new int[5][5];
        
        
        Deque<int[]> dq = new ArrayDeque<>();
        visited[x][y]=true;
        dq.offer(new int[]{x,y});
        
        while(!dq.isEmpty()){
            //현재 위치를 꺼낸다.
            int[] now = dq.poll(); 
            int nowX = now[0];
            int nowY = now[1];
            //dept검사는 어디서하지?
            if(dept[nowX][nowY]>=2) continue;
            
            //자신과 관련된 부분을 넣는 중
            for(int i=0; i<4; i++){
                int nx = nowX+dx[i];
                int ny = nowY+dy[i];
                
                //1. 범위를 벗어나면 패스 
                if(nx<0||nx>=5||ny<0||ny>=5) continue;
                //2. 파티션이면 패스
                if(graph[nx][ny]=='X') continue;
                //3. 방문처리를 체크안했다.
                if(visited[nx][ny]) continue;
                //4. 사람을 만난다면? 그냥 바로 false 리턴
                if(graph[nx][ny]=='P'){
                    // System.out.println("hi");
                    //false가 리턴이 된다!
                    //근데 이렇게 많이?
                    // System.out.println("x : "+nx+" y: "+ny);
                    return false;
                }
                
                
                //사람도 아니고, 파티션도 아니고, 깊이도 아직 2 미만이면
                //1. 방문처리하고
                visited[nx][ny]=true;
                //2. dpt처리
                dept[nx][ny]=dept[nowX][nowY]+1;
                dq.offer(new int[]{nx,ny});
            }
        }
        return true;//다 통과하면 true 반환
    }
}
















