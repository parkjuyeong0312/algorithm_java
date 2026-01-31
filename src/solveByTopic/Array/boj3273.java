package array;
//문제
//n개의 서로 다른 양의 정수 a1, a2, ..., an으로 이루어진 수열이 있다. ai의 값은 1보다 크거나 같고, 1000000보다 작거나 같은 자연수이다.
// 자연수 x가 주어졌을 때, ai + aj = x (1 ≤ i < j ≤ n)을 만족하는 (ai, aj)쌍의 수를 구하는 프로그램을 작성하시오.
//
//        입력
//첫째 줄에 수열의 크기 n이 주어진다. 다음 줄에는 수열에 포함되는 수가 주어진다. 셋째 줄에는 x가 주어진다. (1 ≤ n ≤ 100000, 1 ≤ x ≤ 2000000)
//
//출력
//문제의 조건을 만족하는 쌍의 개수를 출력한다.
//
//예제 입력
//        9
//        5 12 7 10 9 1 2 3 11
//        13
//예제 출력
//        3
//

//생각나는 방법으로는, for문을 두개를 돌려서, i,j로 하나씩 돌려가는거다.
//시간복잡도로는, x는 중요하지않고, n은 10만정도니까, for를 두번 돌리면 n^2,10,000,000,000 =>  100억 시간초과됨
//정렬을 하면 좀 쉬워질까? 정렬은 시간복잡도가 어느정도이지? => 최악이 NlogN이다.
//for 문을 중첩해서 돌리면 문제가 되니까, for문을 각각 2번 돌리면 괜찮지않을까?
//n=10만정도니까
//첫번째 for문에서는 x값을 뺀다. -8 -1 -6 -3 -4 -12 -11 -10 -2 이런느낌으로
//그 다음에는 원래 있던 배열 값을 더하게 되면, 근데 이렇게 되면 이것도 결국, n번의 원소에 대해 n개의 배열을 검색하는거니까 이것도 n^2이다.
//투포인터? 그런방식으로 풀어야되는건가?

//투포인터방식
//정렬을 하지 않고, 투포인터방식으로 밀어붙히면 모든 경우의 수를 확인할 수 없다.
// 정렬을 하면 달라지는가? => ㄴㄴ 그래도 확인못함.

//투포인터 방식으로..
//정렬 : 1 2 3 5 11 12


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());
        String[] charArray = br.readLine().split(" ");
        int target = Integer.parseInt(br.readLine());
        int [] numArray = new int[length];
        //숫자변환 O(n)
        for(int i =0;i<length;i++){
            numArray[i]= Integer.parseInt(charArray[i]);
        }

        Arrays.sort(numArray);

        int count = 0;
        int left = 0;
        int right = length-1;
        int sum = 0;

        while(left<right){
            sum=numArray[left]+numArray[right];
            if(sum==target){
                count++;
                left++;
                right--;
            }else if(sum<target){
                left++;
            }else{
                right--;
            }

        }
        System.out.println(count);
    }
}

