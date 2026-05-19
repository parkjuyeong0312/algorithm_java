package randomSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1991 {
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new char[N][3];
        StringTokenizer st;

        //그래프 채우기
        for(int i=0; i<N; i++){
            // char c = (char)(i+65);
            st = new StringTokenizer(br.readLine());
            arr[i][0]=st.nextToken().charAt(0);
            arr[i][1]=st.nextToken().charAt(0);
            arr[i][2]=st.nextToken().charAt(0);
        }

        // for(int i=0; i<N; i++){
        //     System.out.println(Arrays.toString(arr[i]));
        // }

        preOrder(0);
        System.out.println();
        // inOrder(0);
        // System.out.println();
        // postOrder(0);

    }
    //전위순회
    static void preOrder(int index){
        System.out.print(arr[index][0]);

        if(arr[index][1]=='.'&&arr[index][2]=='.') return;

        //왼쪽
        if(arr[index][1]!='.'){
            int nextIndex = arr[index][1]-65;
            preOrder(nextIndex);
        }
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
        System.out.print(arr[index][0]);
        if(arr[index][2]!='.'){
            int nextIndex = arr[index][2]-65;
            inOrder(nextIndex);
        }

    }

    //     //후위순회
    // static void preOrder(int index){
    //     System.out.print(arr[index][0]);

    //     if(arr[index][1]=='.'&&arr[index][2]=='.') return;

    //     //왼쪽
    //     if(arr[index][1]!='.'){
    //         int nextIndex = arr[index][1]-65;
    //         preOrder(nextIndex);
    //     }
    //     if(arr[index][2]!='.'){
    //         int nextIndex = arr[index][2]-65;
    //         preOrder(nextIndex);
    //     }

    // }

}
