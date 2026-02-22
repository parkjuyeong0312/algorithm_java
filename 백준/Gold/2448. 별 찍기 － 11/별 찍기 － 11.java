
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int height,width;
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        height=Integer.parseInt(br.readLine());
        width = height/3-1+height/3*5;

        arr= new char[height+1][width+1];
        for(int i=1; i<=height; i++){
            Arrays.fill(arr[i], ' ');
        }

        func(height, width, height,width);
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=height; i++){
            for(int j=1; j<=width; j++){
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
    static void func(int x, int y, int height,int width){
        if(height==3) {
            for(int i=y; i>y-5;i--){
                arr[x][i]='*';
            }
            arr[x-1][y-1]='*';
            arr[x-1][y-3]='*';
            arr[x-2][y-2]='*';
            return;
        }

        func(x,y,height/2,width/2);
        //12,23에서 6, 12
        func(x,y-width/2-1,height/2,width/2);
        func(x-height/2,y-width/2+width/4,height/2,width/2);
    }
}
