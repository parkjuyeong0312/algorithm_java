//백트래킹?

//<시간복잡도 계산>
//2^20 = (2^10)^2 = 1000^2 = 1000000의 복잡도. 해볼만함.

// 구현
// 백트래킹으로 구현
// 1. int size = numbers.length();
// 2. 백트래킹 로직

// //맨처음호출할때, dfs(0,0)
// void dfs(int dept, int sum){
//     //1. dept==size이면,
//         //2. if(sum==target) count ++;
//         //return;
//     //3. 분기해서 계산
//     //dfs(dept+1,sum+numbers[depth])
//     //dfs(dept+1,sum-numbers[depth])
// }
    
    
import java.util.*;
import java.io.*;

class Solution {
    static int size;
    static int targetz;
    static int count=0;
    static int[] numbers;
    public int solution(int[] numbersA, int targetA) {
        
        numbers=numbersA;
        size = numbersA.length;
        targetz = targetA;
        
        dfs(0,0);
        
        return count;
    }
    static void dfs(int depth, int sum){
        if(depth==size){
            if(sum==targetz) count++;
            return;
        }

        dfs(depth+1,sum+numbers[depth]);
        dfs(depth+1,sum-numbers[depth]);
    }
}