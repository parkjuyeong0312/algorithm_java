package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//문제
//알파벳 소문자로만 이루어진 단어 S가 주어진다. 각 알파벳이 단어에 몇 개가 포함되어 있는지 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 단어 S가 주어진다. 단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.
//
//출력
//단어에 포함되어 있는 a의 개수, b의 개수, …, z의 개수를 공백으로 구분해서 출력한다.
//
//예제 입력
//baekjoon
//예제 출력
//        1 1 0 0 1 0 0 0 0 1 1 0 0 1 2 0 0 0 0 0 0 0 0 0 0 0
public class boj10808 {
    public static void main(String[] args) throws IOException {
        int[] alphabet = new int[26];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] words = br.readLine().toCharArray();

        for(char word : words){
            int index = word -'a';
            alphabet[index]+=1;
        }

        for(int alpha : alphabet){
            System.out.print(alpha+" ");
        }
    }
}
