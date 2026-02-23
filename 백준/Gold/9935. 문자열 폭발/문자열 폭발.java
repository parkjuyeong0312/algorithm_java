
//시간제한 2초
//문자열길이는 1,000,000
//제곱의 복잡도가 나오면 터짐!10억이 나오기때문에
//

//투포인터로 하는걸까?
//1. 일반적인 반복탐색 -> n^2 -> 초과

//하나씩 지우면서 돌기? 이런방식이 안된다는거임.
//첫글자 비교형식으로,,
//ArrayIndex에 index추가

//로직
//1,2,a,b라고 했을때,
//1을 만난다. -> 체크로직을 실행하자.
//그 다음 index가 2라면, 계속 진행하는거지.
//그니까 처음 폭파문자와 같은 문자를 만나게되면, 이제 계속 확인하면서 들어가는거지.
//근데 만약 그 다음에 폭파문자 아닌 값이 나와버려.
//그러면 뭔지랄을해도, 어짜피 폭파를 안하게된다.
//그러면 해당 index에 대해서, 값을 0으로 return하자

//문자열의 각 자리를 보면, 기본적으로 0이고, 폭파가되면 1로 하자.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//그다음에 문자열출력을할때에는 0이 된 부분만 출력하자.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String boom = br.readLine();

        StringBuilder sb= new StringBuilder();

        int boomLen = boom.length();

        for(int i=0; i<str.length(); i++){
            sb.append(str.charAt(i)); //일단 문자 하나를 넣는다.

            if(sb.length()>=boomLen) {
                boolean isBoom = true;

                for (int j = 0; j < boomLen; j++) {
                    if (sb.charAt(sb.length() - boomLen + j) != boom.charAt(j)) {
                        isBoom = false;
                        break;
                    }
                }
                if (isBoom) {
                    sb.delete(sb.length() - boomLen, sb.length());
                }
            }

        }
        if(sb.length()==0){
            System.out.println("FRULA");
        }else{
            System.out.println(sb);
        }


    }
}
