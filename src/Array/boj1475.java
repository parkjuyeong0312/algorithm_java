package Array;
//문제
//다솜이는 은진이의 옆집에 새로 이사왔다. 다솜이는 자기 방 번호를 예쁜 플라스틱 숫자로 문에 붙이려고 한다.
//다솜이의 옆집에서는 플라스틱 숫자를 한 세트로 판다. 한 세트에는 0번부터 9번까지 숫자가 하나씩 들어있다. 다솜이의 방 번호가 주어졌을 때, 필요한 세트의 개수의 최솟값을 출력하시오. (6은 9를 뒤집어서 이용할 수 있고, 9는 6을 뒤집어서 이용할 수 있다.)
//입력
//첫째 줄에 다솜이의 방 번호 N이 주어진다. N은 1,000,000보다 작거나 같은 자연수이다.
//출력
//첫째 줄에 필요한 세트의 개수를 출력한다.
//예제 입력
//        9999
//예제 출력
//        2

//예제 입력
//        122
//예제 출력
//        2

//예제 입력
//        12635
//예제 출력
//        1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//예제 입력
//        888888
//예제 출력
//        6
public class boj1475 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] set = new int[10];

        char[] nums = br.readLine().toCharArray();
        for(char num : nums){
            set[num-'0']++;
        }
        set[6]=(set[6]+set[9]+1)/2;
        set[9]=0;

        int max = 0;

        for(int i=0;i<10;i++){
            if(max < set[i]) max =set[i];
        }

        System.out.print(max);

    }
}
