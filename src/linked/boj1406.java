package linked;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

// 예제 입력 1 
// abcd
// 3
// P x
// L
// P y
// 예제 출력 1 
// abcdyx
// 예제 입력 2 
// abc
// 9
// L
// L
// L
// L
// L
// P x
// L
// B
// P y
// 예제 출력 2 
// yxabc
// 예제 입력 3 
// dmih
// 11
// B
// B
// P x
// L
// B
// B
// B
// P y
// D
// D
// P z
public class boj1406 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<Character> list = new LinkedList<>();
        char[] initChars = br.readLine().toCharArray();

        for(char ch : initChars){
            list.add(ch);
        }

        ListIterator<Character> cursor = list.listIterator();
        System.out.println(cursor.next());


        for (Character element : list) {
            cursor.next();
        }


        int N = Integer.parseInt(br.readLine());

        for(int i =0; i<N;i++){
            char[] chList = br.readLine().toCharArray();

            if(chList[0]=='L'){
                if(cursor.hasPrevious()){
                    cursor.previous();
                }
            }else if(chList[0]=='D'){
                if(cursor.hasNext()){
                    cursor.next();
                }
            }else if(chList[0]=='B'){
                if(cursor.hasPrevious()){
                    cursor.previous();
                    cursor.remove();
                }
            }else{
                cursor.add(chList[1]);
            }
        }
        StringBuilder sb =new StringBuilder();
        for(char ch : list){
            sb.append(ch);
        }

        System.out.println(sb);

    }
}
