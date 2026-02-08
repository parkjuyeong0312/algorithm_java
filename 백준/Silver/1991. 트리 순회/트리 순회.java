// 이진 트리를 입력받아
// 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)한
// 결과를 출력하는 프로그램을 작성하시오.

// 예를 들어 위와 같은 이진 트리가 입력되면,

// 전위 순회한 결과 : ABDCEFG // (루트) (왼쪽 자식) (오른쪽 자식)
// 중위 순회한 결과 : DBAECFG // (왼쪽 자식) (루트) (오른쪽 자식)
// 후위 순회한 결과 : DBEGFCA // (왼쪽 자식) (오른쪽 자식) (루트)
// 가 된다.

// 입력
// 첫째 줄에는 이진 트리의 노드의 개수 N(1 ≤ N ≤ 26)이 주어진다.
// 둘째 줄부터 N개의 줄에 걸쳐 각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드가 주어진다.
// 노드의 이름은 A부터 차례대로 알파벳 대문자로 매겨지며,항상 A가 루트 노드가 된다.
// 자식 노드가 없는 경우에는 .으로 표현한다.

// 출력
// 첫째 줄에 전위 순회,
// 둘째 줄에 중위 순회,
// 셋째 줄에 후위 순회한 결과를 출력한다.
// 각 줄에 N개의 알파벳을 공백 없이 출력하면 된다.
import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static char[][] arr;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new char[26][3];
        StringTokenizer st;

        //그래프 채우기
        for(int i=0; i<N; i++){
            // char c = (char)(i+65);
            st = new StringTokenizer(br.readLine());

            char parent=st.nextToken().charAt(0);
            char left=st.nextToken().charAt(0);
            char right=st.nextToken().charAt(0);

            int index = parent - 'A';
            arr[index][0]=parent;
            arr[index][1]=left;
            arr[index][2]=right;
        }

        // for(int i=0; i<N; i++){
        //     System.out.println(Arrays.toString(arr[i]));
        // }

        
        preOrder(0);
        sb.append('\n');
        inOrder(0);
        sb.append('\n');
        postOrder(0);
        sb.append('\n');

        System.out.println(sb);
    }
    //전위순회
    static void preOrder(int index){
        sb.append(arr[index][0]);
        
        if(arr[index][1]!='.'){
            int nextIndex = arr[index][1]-65;
            preOrder(nextIndex);
        }
        //오른쪽
        if(arr[index][2]!='.'){
            int nextIndex = arr[index][2]-65;
            preOrder(nextIndex);
        }
    }
    //중위순회
    static void inOrder(int index){      
        //왼쪽
        if(arr[index][1]!='.'){
            int nextIndex = arr[index][1]-65;
            inOrder(nextIndex);
        }
        sb.append(arr[index][0]);
        if(arr[index][2]!='.'){
            int nextIndex = arr[index][2]-65;
            inOrder(nextIndex);
        }
        
    }

    static void postOrder(int index){      
        //왼쪽
        if(arr[index][1]!='.'){
            int nextIndex = arr[index][1]-65;
            postOrder(nextIndex);
        }
        if(arr[index][2]!='.'){
            int nextIndex = arr[index][2]-65;
            postOrder(nextIndex);
        }
        sb.append(arr[index][0]);
        
    }

}

























