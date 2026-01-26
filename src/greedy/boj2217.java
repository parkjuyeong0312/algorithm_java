package greedy;

//문제
//N(1 ≤ N ≤ 100,000)개의 로프가 있다. 이 로프를 이용하여 이런 저런 물체를 들어올릴 수 있다.
//각각의 로프는 그 굵기나 길이가 다르기 때문에 들 수 있는 물체의 중량이 서로 다를 수도 있다.
//하지만 여러 개의 로프를 병렬로 연결하면 각각의 로프에 걸리는 중량을 나눌 수 있다.
//k개의 로프를 사용하여 중량이 w인 물체를 들어올릴 때, 각각의 로프에는 모두 고르게 w/k 만큼의 중량이 걸리게 된다.
//각 로프들에 대한 정보가 주어졌을 때,이 로프들을 이용하여 들어올릴 수 있는 물체의 최대 중량을 구해내는 프로그램을 작성하시오.
//모든 로프를 사용해야 할 필요는 없으며, 임의로 몇 개의 로프를 골라서 사용해도 된다.
//
//입력
//첫째 줄에 정수 N이 주어진다. 다음 N개의 줄에는 각 로프가 버틸 수 있는 최대 중량이 주어진다. 이 값은 10,000을 넘지 않는 자연수이다.
//
//출력
//첫째 줄에 답을 출력한다.
//
//예제 입력
//        2
//        10
//        15
//예제 출력
//        20


//물체의 최대 중량을 구해야함.
//임의의 로프를 골라서 사용할 수 있음.
//가장 낮은걸 타겟팅해서 해야될 것 같음.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//정렬된 무게의 로프에서,
//순차적으로 진행하며,
//낮은 중량의 로프 * k >=이전까지 최대 중량이라면 갱신하고 아니면 멈춘다.
public class boj2217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] lopes = new Integer[N];


        for(int i=0; i<N; i++){
            lopes[i]=Integer.parseInt(br.readLine());
        }


        Arrays.sort(lopes,(a,b)->{
            return b - a;
        });
//        System.out.println(Arrays.toString(lopes));

        int k=1;
        int ans=lopes[0];

        for(int i=1; i<N; i++){
            k+=1;
            if(lopes[i]*k>=ans){
                ans=lopes[i]*k;
            }
        }

        System.out.println(ans);

    }
}
