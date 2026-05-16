// 문제상황
// - 종이에는 숫자가 적혀있다.
// - 종이 조각을 붙여 소수를 몇개 만들 수 있을까?

// numbers 문자열의 숫자로 소수를 만들자.

// 제한조건
// - 1<=numbers<=7 인 문자열
// - numbers숫자는 0~9로 이루어져있음
// => 총 7개의 카드가 있는 numbers의문자열이다.
    
// 문제풀이
// 1. 소수 판별 알고리즘이 필요하다.
// 2. 소수 판별 알고리즘의 시간복잡도를 계산해보아야한다.
// 3. 만약 모든 카드에 대해 완전탐색을한다고하면, 2^7에다가, 경우의 수 7!이니까 대충 계산해보아도 128*10000? 이라고 해도 약간 넉넉할거같은느낌?

// 완전탐색으로 풀면 될 거 같다.

// (1) 나열을 어떻게 중복없이 처리할 것인가?
//<숫자로 변경하기>
// 문자열로 받기 때문에, 해당 값을 우선 숫자로 변경할 필요가 있다.

//백트래킹으로 가야될듯?
//근데 트리를 어떻게 구성해야하지?
//재귀형식으로 돌아?
//visited이런식으로해서
//그리고 되돌아갈때에는 다시 true형식으로 바꾸고..
//근데 포함안할필요는 없는거잖아
//어짜피 숫자로 계산을 하는거면, 상관없을거같음.

//DFS설계법
//1. 우선 문자열을 숫자로 다 바꾼다.
//2. 선언해야될거는, 해당 배열 길이만큼의 visited 배열
//3. dept만큼의 탐색을 한다. 
//4. 그리고 그 값을 숫자로 바꿔서 prime을 판단해보고, count값을 올리낟.


// (2) 소수를 어떻게 판별할것인가?
// - 제곱근까지의 수까지만, 나눠서 확인해본다.
// - 에라토네스의 체에 포함되는지 확인해본다.

import java.util.*;

class Solution {
    static int numbersSize;
    static int[] numbersArray;
    static HashSet<Integer> set = new HashSet<>();
    static boolean[] visited;
    
    public int solution(String numbers) {
        int answer = 0;
        // System.out.println(isPrime(7));
        numbersSize = numbers.length();
        numbersArray = new int[numbersSize];
        visited = new boolean[numbersSize];
        
        for(int i=0; i<numbersSize; i++){
            //17 -> [1,7]
            numbersArray[i] = numbers.charAt(i)-'0';
        }
        
        // System.out.println(Arrays.toString(numbersArray));
        
        backTracking(1,0,0);
        System.out.println(set);
        
        answer = set.size();
        
        return answer;
    }
    
    //포함을 안시키는 경우도 따져야되는데..
    void backTracking(int dept,int result, int count){
        if(dept > numbersSize){
            if(isPrime(result)){
                set.add(result);
            }
            return;
        }
        int temp = result;
        
        for(int i=0; i<numbersSize; i++){
            if(visited[i]) continue;
            
            //포함을 안시키는 경우
            visited[i]=true;
            backTracking(dept+1,result,count);
            visited[i]=false;
            
            
            //포함을 시키는 경우
            int unit = numbersArray[i];
        
            result+=Math.pow(10,count)*unit;

            visited[i] = true;
            backTracking(dept+1, result,count+1);
            result = temp;
            visited[i] = false;
        }
        return;
    }
    
    
    
    //소수판별 매서드
    boolean isPrime(int num){
        //1 또는 0 은 소수가 아님.
        if(num <= 1){
            return false;
        }
        
        //2부터 시작해서, 제곱근 이하의 범위까지만 수행한다.
        for(int i=2; i<=Math.sqrt(num); i++){
            //수를 i로 나눴을 때 자기 자신 이외에 나누어 떨어진다면 소수임.
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    
}
