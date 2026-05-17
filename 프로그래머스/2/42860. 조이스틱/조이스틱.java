import java.util.*;
import java.io.*;

//선택 알고리즘 : 그리디

// 가정
// <상,하>
// 위,아래로 이동하여 글자를 맞추는 것은 한번의 연속시도로 끝내는게 조작횟수의 최소이다.
// 위아래 이동은 더 가까운 경로를 택해야 한다.
// 상/하의 경우 계산을 통해 더 가까운쪽으로 이동하고, 그 값을 계산해서 count에 더한다.

    
// <좌 우>
// 현위치에서 가장 가까운 지점으로 이동하는것이 가장 빠르다.
// 완전탐색으로 구현한다.

// 구현
// 1. 문자열에 대해서 숫자로 치환한다. A->0 , B->1 
// 2. 그리고 그 값을 배열에 넣는다.
//     visited 배열을 선언한다.
//     A의 경우 visited = true처리를 한다.
//     A를 제외한 수의 경우 targetCount 값 변수를 선언해서, 목표치에 될때까지 반복한다. targetCount==0일 시에 종료한다.
// 2-1. count값을 선언하여 조작할때마다 더한다.
// 3. 현위치 시점으로 좌우를 탐색하는 BFS를 구현한다.

//     BFS는 좌표 값을 index 값을 뱉는다.
//     BFS는 좌표가 오버됐을때에는 0으로 이동한다. nx = index%size 와 같은 형식으로 구현한다.(11/10-> 1)
//     이동 값에 대하여, 좌표를 뱉고, 그 이후에는 count값을 그만큼올린다.
// 4. 해당 위치에 도착하면, 상하를 계산한다.
//     만약 A인데 10으로 가야된다고 하면, 기존 값과, 알파벳 총 개수 (26개) - 10로 계산하고 해당값을 count에 더한다.





class Solution {
    static int size;
    static int updown = 0;        
        
    public int solution(String name) {
        
        size = name.length();
        //[상하]
        for(int i=0; i<size; i++){
            int unit = name.charAt(i)-'A';
            updown+=Math.min(unit,26-unit);
        }
        
        //[좌우]
        //오른쪽으로 끝까지 가는 경우
        int move = size -1;
        //오른쪽으로 i번까지 갔다.
        for(int i=0; i<size; i++){
            int next = i+1;
            //다음 처리할 글자는 i번이다.
            while(next<size && name.charAt(next)=='A'){
                next++;
            }
            
            int rightThenLeft = i*2+(size-next);
            int leftThenRight = (size-next)*2 + i;
            
            move = Math.min(move, Math.min(rightThenLeft, leftThenRight));
        }
        
        return move+updown;
    }        
}