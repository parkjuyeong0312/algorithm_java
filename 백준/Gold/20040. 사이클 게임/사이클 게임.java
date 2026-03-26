import java.util.*;
import java.lang.*;
import java.io.*;

//<문제 분석>
//n : 점의 개수, 3<=n<=500,000
//m : 차례 수 , 3<=m<=1,000,000


//<사고흐름>
//사이클을 만들면 게임이 종료이다. 
//사이클을 검증하는 알고리즘은 내가 기억하기로는, 벨만포드?인가 그랬던거같은데
//어쨋든, n-1번에 대해서 검사를 하면 된다는 논리이다. 근데 이걸, 
//그래프가 완성되는 와중에 해야되는거니까. ㅇㅇ 
//근데 이건 가중치가 없는 문제이다. 

//일단 확실히 정할 수 있는거는
//1개 정하고, 다음에 또 확인하고~ 이런식이면, 
//뭐가됐든 n제곱의 복잡도를 가질 것이라는 것이다. 

// 생각
//     전역적인 변수를 하나 둔다.
//     그리고, 그래프를 만들때 다음과 같은 조건을 단다.
//     1. 두 노드가 방문이 안됐을경우
//     두 노드가 방문이 안됐을 경우에는, 그것을 하나의 그래프로 처리하고, 전역변수값++로 하여 초기화한다
    
//     2. 한 노드만 방문했을 경우
//     해당 노드의 값을 이어서 붙힌다?
    
//     3. 두 노드가 방문했을 경우
//     만약, 두 노드의 값이 다르면 합치고, 같다면 그 상태로 종료한다.

//     근데 이 "합치는 과정"이 유니온 파인드가 아닐까 생각을 했다.

//     유니온 파인드란 무엇인가? 그걸 잘 모르겠다.
    
//     일단 진행해보자.

//     그래프를 연결하고, bfs형식으로, 넣는 거 겠지?

//     구현 방식은 2가지가 될 것 같다.
//     1. 그래프를 미리 만들어놓고, 그 다음에 뭔가 선언을 하는 경우
//         이 경우에는, 어떤식으로 할려는지 잘 모르겠다.
//         ㄴㄴ 이 방법은 아니다.
//     2. 그래프를 만들면서 확인하는 경우
//         그래프로 만들면서 확인하는거다.

// 구현 흐름
//     n과 m을 만든다.
//     n은 노드의 개수인데, 연결리스트로 구현할때, 해당 노드가 연결된 자식노드들을 나열한다.
//     부모노드는 1, 자식노드는 2,3,4라고 했을때, 2,3,4가 거기 들어가있겠지?
//     연결되어서 말이다.

//     그리고, 해당 노드의 값을 확인하면 될 것 같다.

//     뭐가 됐던 양방향 리스트 처럼 되어야되니까 둘다 넣어야 될 것 같고,

//     노드의 value를 기록하는 숫자배열 하나를 둬야할것같다.

//     1. 각 value[] 값을 확인한다. A,B
//         a. A==0 && B==0 , A,B = graphNum
//         b. A=B
//              같다면, count 값 리턴 후 종료
//             다르다면, B를 A로 BFS로 돌면서 통일함.
    
//         c. 다르다면, 한쪽으로 추가 
//             B=A


//첫번째 시도 : 시간초과
//왜 시간초과가 났을까?
// BFS의 시간복잡도는 O(V+E)이다.
// 그 뜻은, 기본적으로 1,000,000회의 그래프 붙히기 가 일어나지만, 만약
//정확하지는 않지만 대략 1000번이상의 bfs가 수행된다면, 시간초과가 일어날 수 있다고 계산이 된다.

//그렇다면 bfs말고 뭘 해야 이게 가능한거지?

//유니온파인드방식으로 다시 시도.


    
import java.util.*;
import java.io.*;

class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 1. 초기화: 모든 노드는 자기 자신을 부모로 가짐
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 2. 두 노드의 루트를 찾음
            int rootU = find(u);
            int rootV = find(v);

            // 3. 사이클 판별: 루트가 같다면 이미 같은 그룹 -> 연결 시 사이클 발생
            if (rootU == rootV) {
                System.out.println(i);
                return;
            }

            // 4. 합치기 (Union): 두 그룹을 하나로 통합
            union(rootU, rootV);
        }

        System.out.println(0);
    }

    // Find 연산: 루트 노드를 찾고 경로 압축을 진행
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    // Union 연산: 한 쪽 그룹을 다른 쪽 그룹에 편입
    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}














