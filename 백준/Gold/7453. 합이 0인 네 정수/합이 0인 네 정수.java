import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".

//<문제 조건>
//배열의 크기는 n , 4000
//배열의 정수 절댓값은 2^28,-> 어느정도 크기인지 감이 잘 안온다.
    //long이 8바이트, 1바이트에 4비트니까, 32비트까지 범위임.
    //그니까, long으로 선언한다고 생각하는게 합리적임.

//"합이 0이 되는 쌍의 개수를 출력한다."

//<알고리즘 선택해보기>
//배열의 크기는 4000, 만약 여기서,하나씩 브루트 포스로 고른다고해도
//4000*4000*4000*4000, -> 12초(12억)을 훨씬 능가한다.
//브루트포스는 절대 안됨.

//1. 정렬
// 우선 뭐 순서대로 골라야할 필요는 없다보니, 배열별로, 정렬을 해도 좋을 것 같다.
// 입력받을때 아무래도, 배열 종류별로 입력받는게 좋겠지

//2. 그리디
//하나의 탐욕적인 선택으로, 뭔가 결과가 나올 것 같지는 않다.

//3. dp?
//첫번째 원소에 대해, 뒤에 다른 원소를 고른다고 해도, .. 
//ㄴㄴ 아님.

//4. 배열을 하나로 합친다면?

//정렬, 이분탐색, 포인터를 사용해서 풀어보자.
//

//<문제분석>
// - 같은 원소가 중복되어 배열에 존재할 수 있다. -> set으로 관리해야할까?

//[4개의 원소가 합쳐서 0이 된다.]
//[2개씩 쪼개자]
// AB CD의 합을 이중포문으로 하면 16 000 000 -> 1600만정도의복잡도,*2 => 3200만
// 그리고 이 AB = -CD인지 찾으면 된다.
//각각의 크기는 1600만에서, CD에 대해, 이진탐색 결과를 내보내면,
//logN의 복잡도가 나오게 된다. 그렇다면, 1600만*log(1600만)이므로, 그다지 큰 수는 아니게된다.
//따라서 시간복잡도는 패스!






class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][4];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] AB = new int[N * N];
        int[] CD = new int[N * N];

        int idx = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                AB[idx] = arr[i][0] + arr[j][1];
                CD[idx] = arr[i][2] + arr[j][3];
                idx++;
            }
         }

        //이진탐색을 해야하므로, 정렬
        Arrays.sort(CD);

        long ans = 0;
        for (int key : AB) {
            int upper = upperBound(CD, -key);
            int lower = lowerBound(CD, -key);
            ans += (upper - lower);
        }

        System.out.println(ans);
    }


    static int upperBound(int[] arr, int find){
        int left =0; 
        int right = arr.length;

        while(left<right){
            int mid = (left+right)/2;
            if(arr[mid]<=find){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    static int lowerBound(int[] arr, int find){
        int left =0; 
        int right = arr.length;

        while(left<right){
            int mid = (left+right)/2;
            if(arr[mid]<find){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }
    
}

































