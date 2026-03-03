//시뮬레이션 문제인거같다.

//1. 확산
//- 확산은 배열을 넘겨주는 방식으로 개선해야될거같다.
//2500의 연산 * 1000번 -> 2 500 000 ㄱㅊ음.

//확산 -> 이동 순으로 진행되어야한다.
//이동 후에 배열을 뱉고, 그 다음에 또 함수를 진행해야한다.

//확산은 어떻게 할 것인가?
//1. 같은 크기의 temp 그래프를 생성한다.
//2. 그리고, 그 그래프에, 공식을 적용해서, 확산을 시킨다.
//3. 그다음에 이동하기 로직을 수행한다.



//2. 이동하기
//정화기는 첫번째 열로부터 2칸이니까 무조건 세로방향이다.
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int R,C,T;
    static int[][] arr;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int highX,lowX;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new int[R][C];


        //입력
        boolean airCleanerDetected = false;
        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                int unit = Integer.parseInt(st.nextToken());
                if(unit == -1){
                    if(!airCleanerDetected){
                        airCleanerDetected = true;
                        highX = i;
                        lowX = i+1;
                    }
                }
                arr[i][j] = unit;
            }
        }

//
        while(T-->0){
            arr = diffusion(arr);
            arr = cleaning(arr);
        }
//
//        for(int i=0; i<R; i++){
//            System.out.println(Arrays.toString(arr[i]));
//        }
        int ans =0;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                ans+=arr[i][j];
            }
        }

        System.out.println(ans+2);

    }
    static int[][] diffusion(int[][] arr){
        //이걸 그대로 배낄것인가?
        //그럴필요있는가?
        //ㄴㄴ
        int[][] temp = new int[R][C];

        for(int i=0; i<R; i++) {
            for (int j = 0; j < C; j++) {

                if (arr[i][j] == 0) continue;
                if (arr[i][j] == -1) {
                    temp[i][j] = -1;
                    continue;
                }
                //만약 숫자가 있다면~
                int origin = arr[i][j];
                int nextDust = origin / 5;

//                if (nextDust==0) continue;

                //nextDust가 0보다 클때, 퍼졌을때
                //방향이 얼마나 퍼졌는지 확인해야한다.
                //인접한 방향에 공기청정기가 있거나, 칸이 없으면 그 방향으로는 확산이 일어나지 않는다.
                int diffusionCount = 0;
                ArrayList<int[]> canDiffusion = new ArrayList<>();


                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx < 0 || nx >= R || ny < 0 || ny >= C) continue;
                    if (arr[nx][ny] == -1) continue;

                    canDiffusion.add(new int[]{nx, ny});

                    diffusionCount += 1;
                }
                //Ar,c - ⌊Ar,c/5⌋×(확산된 방향의 개수)
                temp[i][j] += arr[i][j] - nextDust * diffusionCount;

                for (int[] pos : canDiffusion) {
                    int x = pos[0];
                    int y = pos[1];

                    temp[x][y] += nextDust;
                }
            }
        }

        return temp;

    }

    static int[][] cleaning(int[][] arr){
        int[][] temp = new int[R][C];

        //high
        //왼쪽 위->아래
        for(int i=highX-1; i>=0; i--){
            temp[i+1][0]=arr[i][0];
        }

        //오른쪽위 -> 왼쪽위
        for(int j=1; j<C; j++){
            temp[0][j-1]=arr[0][j];
        }

        //오른쪽아래 -> 오른쪽 위
        for(int i = 1; i<=highX; i++){
            temp[i-1][C-1]=arr[i][C-1];
        }

        //왼쪽 아래 -> 오른쪽 아래
        for(int j = C-2; j>=0; j--){
            temp[highX][j+1]=arr[highX][j];
        }

        temp[highX][0]=-1;
        temp[highX][1]=0;

        for(int i=1; i<highX; i++){
            for(int j=1; j<C-1; j++){
                temp[i][j]=arr[i][j];
            }
        }


        // 아래~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        for(int i=lowX; i<=R-2; i++){
            temp[i][0]=arr[i+1][0];
        }

        //오른쪽 아래-> 왼쪽 아래
        for(int j = 0; j<=C-2; j++){
            temp[R-1][j]=arr[R-1][j+1];
        }

        //오른쪽 위->오른쪽 아래
        //temp
        for(int i = R-1; i>=lowX+1; i--){
            temp[i][C-1]=arr[i-1][C-1];
        }

        //왼쪽 위 -> 오른쪽 위
        for(int j = C-1; j>=1; j--){
            temp[lowX][j]=arr[lowX][j-1];
        }

        temp[lowX][0]=-1;
        temp[lowX][1]=0;

        for(int i=lowX+1; i<R-1; i++){
            for(int j=1; j<C-1; j++){
                temp[i][j]=arr[i][j];
            }
        }

        return temp;
    }
}
