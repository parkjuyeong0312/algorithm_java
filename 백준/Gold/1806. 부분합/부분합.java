import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
//슬라이딩 윈도우 방식을 써야될 거 같다.
//뭔가 근데 길이가 정해진게 없잖아.

//5000만번 연산이 가능함.
//N은 100 000, 만약 슬라이딩 윈도우 크기를 늘려가면서, 모두 탐색해본다고 해보자.
//그렇게 되면, N(N-1)/2, 즉 N^2의 복잡도가 된다.->100억 -> 터진다.

//그럼 다른 알고리즘을 떠올려야된다는 것인데. 뭐가 있을까?
//투포인터로 해보자.
//left<=right인 범위에서만 반복된다.
//합이 S보다 크거나 같다면, left+1
//합이 S보다 작다면, right+1

//각 연산별로 length = left-right+1로 계산한다.
//그리고 최솟값을 갱신한다.

//이렇게 되면, 최소 길이를 맞출 수 있다.

//시간복잡도는 어떻게되는가? 
//최악의 경우를 생각하면, right는 n-2번 이동할 수 있고
//left도 n-1번 이동할 수 있다.
//곱하는 느낌이 아니라 2n의 복잡도가 나온다.

//해보자!



class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int left =0;
        int right = 0;
        int sum = arr[0];
        int min = Integer.MAX_VALUE;
        
        while(left<=right){
            // System.out.print("left : "+left);
            // System.out.print(" right : "+right);
            // if(sum>=S) System.out.print("***");
            // System.out.print(" length : "+(right-left+1));
            // System.out.println(" sum : "+sum);
            
        
            //N이 10보다 크다. 
            if(sum>=S){//sum이 만약 S보다 크다면,왼쪽을 한칸 줄인다.
                min=Math.min(right-left+1,min); // 맨 처음 때문에 함 확인을 해야된다. 
                //줄어든다.
                sum-=arr[left];
                left+=1;
            }else{//sum이 S보다 작다면, 오른쪽을 한칸 늘린다.
                //늘린다
                right+=1;
                if(right==N) break;
                sum+=arr[right];
            }
        }

        if(min == Integer.MAX_VALUE){
            System.out.println(0);
        }else{
            System.out.println(min);
        }
    }
}






















