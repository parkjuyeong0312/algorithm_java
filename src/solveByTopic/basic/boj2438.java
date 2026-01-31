package solveByTopic.basic;

import java.util.Scanner;

//����
//ù° �ٿ��� �� 1��, ��° �ٿ��� �� 2��, N��° �ٿ��� �� N���� ��� ����
//
//�Է�
//ù° �ٿ� N(1 �� N �� 100)�� �־�����.
//
//���
//ù° �ٺ��� N��° �ٱ��� ���ʴ�� ���� ����Ѵ�.
public class boj2438 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for(int i = 0 ; i<N; i++){
            for(int j =0; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
