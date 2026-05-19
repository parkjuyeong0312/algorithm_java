//전위 순회 한 결과가 출력된다.
//전위 순회한 결과의 원리를 토대로, 그래프를 생성해야한다.
// 전위순회에서 불러주는 스타일대로 그래프를 생성하고, 그다음에 후위순회로 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;



public class boj5639 {
    static class Node {
        int value;
        Node left,right;

        Node(int value) {
            this.value = value;
        }

        void insert(int n){
            if(n<this.value){
                if(this.left == null) this.left= new Node(n);
                else this.left.insert(n);
            }else{
                if(this.right==null) this.right = new Node(n);
                else this.right.insert(n);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        if(input==null || input.isEmpty()) return;

        Node root = new Node(Integer.parseInt(input));

        while(true){
            input = br.readLine();
            if(input==null||input.isEmpty()) break;
            root.insert(Integer.parseInt(input));
        }

        postOrder(root);

    }
    static void postOrder(Node node){
        if(node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }
}
