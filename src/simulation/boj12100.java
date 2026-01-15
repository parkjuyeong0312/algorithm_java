package simulation;
//
//2048 게임은 4×4 크기의 보드에서 혼자 즐기는 재미있는 게임이다. 이 링크를 누르면 게임을 해볼 수 있다.
//이 게임에서 한 번의 이동은 보드 위에 있는 전체 블록을 상하좌우 네 방향 중 하나로 이동시키는 것이다.
//이때, 같은 값을 갖는 두 블록이 충돌하면 두 블록은 하나로 합쳐지게 된다.
//한 번의 이동에서 이미 합쳐진 블록은 또 다른 블록과 다시 합쳐질 수 없다.
//(실제 게임에서는 이동을 한 번 할 때마다 블록이 추가되지만, 이 문제에서 블록이 추가되는 경우는 없다)
//
//마지막으로, 똑같은 수가 세 개가 있는 경우에는 이동하려고 하는 쪽의 칸이 먼저 합쳐진다
//예를 들어, 위로 이동시키는 경우에는 위쪽에 있는 블록이 먼저 합쳐지게 된다. <그림 14>의 경우에 위로 이동하면 <그림 15>를 만든다.
//
//이 문제에서 다루는 2048 게임은 보드의 크기가 N×N 이다.
//보드의 크기와 보드판의 블록 상태가 주어졌을 때, 최대 5번 이동해서 만들 수 있는 가장 큰 블록의 값을 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 보드의 크기 N (1 ≤ N ≤ 20)이 주어진다. 둘째 줄부터 N개의 줄에는 게임판의 초기 상태가 주어진다.
//0은 빈 칸을 나타내며, 이외의 값은 모두 블록을 나타낸다.
//블록에 쓰여 있는 수는 2보다 크거나 같고, 1024보다 작거나 같은 2의 제곱꼴이다. 블록은 적어도 하나 주어진다.
//
//출력
//최대 5번 이동시켜서 얻을 수 있는 가장 큰 블록을 출력한다.
//
//예제 입력
//        3
//        2 2 2
//        4 4 4
//        8 8 8
//예제 출력
//        16

//시간복잡도 계산
//제한시간 1초 : 1억
//N:20
//이동 최대 5번
//상하좌우 4번
//그래프 초기화 N*N = 40 -> 백트래킹 방식이 아님.
//40(기본 초기화)+40(초기화)*4(상하좌우)*(1+16+64+256+1024) < 1억
//

//

//백트래킹 문제
//상,하,좌,우 에 대한 함수를 만들자.
//

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj12100 {
    static int N;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int[][] graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int unit = Integer.parseInt(st.nextToken());
                graph[i][j] = unit;

                if (unit > max) {
                    max = unit;
                }

            }
        }

        func(graph, 0);

        System.out.println(max);
    }
    //max값 갱신 : 합치면서? 아니면 나중에 한번에?
    //상,하,좌,우 갱신할때 확인하기

    //func(temp,dept)
    //if(dept == 5)
    //return;
    //int[][] temp = new int[N][N]

    //up(graph)
    //func(temp,dept+1)
    //down()
    //left()
    //right()

    static void func(int[][] graph, int dept) {
        if (dept == 5) {
            return;
        }
        left(graph, dept);
        right(graph,dept);
        down(graph,dept);
        up(graph,dept);

    }


    static void left(int[][] graph, int dept) {
        int[][] temp = new int[N][N];

        for (int i = 0; i < N; i++) {
            temp[i] = Arrays.copyOf(graph[i], N);
        }

        for (int line = 0; line < N; line++) {

            int idx = 0;
            for (int m = 1; m < N; m++) {

                if (temp[line][m] == 0) continue;

                if (temp[line][m] != temp[line][idx]) {//달라
                    while (idx < m && temp[line][idx] != 0) {
                        idx += 1;
                    }
                    if (idx == m) continue;
                    if (temp[line][idx] == 0) {
                        temp[line][idx] = temp[line][m];
                        temp[line][m] = 0;
                    }
                } else {
                    int merge = temp[line][m] * 2;
                    temp[line][idx] = merge;
                    temp[line][m] = 0;
                    idx += 1;
                    if (merge > max) max = merge;
                }
            }
        }

        func(temp, dept + 1);
    }

    static void right(int[][] graph, int dept) {
        int[][] temp = new int[N][N];

        for (int i = 0; i < N; i++) {
            temp[i] = Arrays.copyOf(graph[i], N);
        }

        for (int line = 0; line < N; line++) {

            int idx = N-1;
            for (int m = N-2; m>=0; m--) {

                if (temp[line][m] == 0) continue;

                if (temp[line][m] != temp[line][idx]) {//달라
                    while (idx > m && temp[line][idx] != 0) {
                        idx -= 1;
                    }
                    if (idx == m) continue;
                    if (temp[line][idx] == 0) {
                        temp[line][idx] = temp[line][m];
                        temp[line][m] = 0;
                    }
                } else {
                    int merge = temp[line][m] * 2;
                    temp[line][idx] = merge;
                    temp[line][m] = 0;
                    idx -= 1;
                    if (merge > max) max = merge;
                }
            }
        }

        func(temp, dept + 1);
    }

    static void down(int[][] graph, int dept) {
        int[][] temp = new int[N][N];

        for (int i = 0; i < N; i++) {
            temp[i] = Arrays.copyOf(graph[i], N);
        }

        for (int line = N-1; line>=0; line--) {

            int idx = N-1;
            for (int m = N-2; m>=0; m--) {

                if (temp[m][line] == 0) continue;

                if (temp[m][line] != temp[idx][line]) {//달라
                    while (idx > m && temp[idx][line] != 0) {
                        idx -= 1;
                    }
                    if (idx == m) continue;
                    if (temp[idx][line] == 0) {
                        temp[idx][line] = temp[m][line];
                        temp[m][line] = 0;
                    }
                } else {
                    int merge = temp[m][line] * 2;
                    temp[idx][line] = merge;
                    temp[m][line] = 0;
                    idx -= 1;
                    if (merge > max) max = merge;
                }
            }
        }

        func(temp, dept + 1);
    }

    static void up(int[][] graph, int dept) {
        int[][] temp = new int[N][N];

        for (int i = 0; i < N; i++) {
            temp[i] = Arrays.copyOf(graph[i], N);
        }

        for (int line = 0; line<N; line++) {
            int idx = 0;
            for (int m = 1; m<N; m++) {

                if (temp[m][line] == 0) continue;

                if (temp[m][line] != temp[idx][line]) {//달라
                    while (idx < m && temp[idx][line] != 0) {
                        idx += 1;
                    }
                    if (idx == m) continue;
                    if (temp[idx][line] == 0) {
                        temp[idx][line] = temp[m][line];
                        temp[m][line] = 0;
                    }
                } else {
                    int merge = temp[m][line] * 2;
                    temp[idx][line] = merge;
                    temp[m][line] = 0;
                    idx += 1;
                    if (merge > max) max = merge;
                }
            }
        }

        func(temp, dept + 1);
    }


}