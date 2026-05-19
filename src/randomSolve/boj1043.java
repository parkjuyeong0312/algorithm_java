package randomSolve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj1043 {
    static int N,M;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int noticeNum = Integer.parseInt(st.nextToken());

        HashSet<Integer> trueSet = new HashSet<>();
        HashSet<Integer> explodeSet = new HashSet<>();



        while(noticeNum-- >0){
            trueSet.add(Integer.parseInt(st.nextToken()));
        }

        int ans=0;

        while(M-- >0){
            st = new StringTokenizer(br.readLine());
            int partyPeople = Integer.parseInt(st.nextToken());
            boolean isNoticed=false;
            ArrayList<Integer> tempList = new ArrayList<>();
            while(partyPeople-- >0){
                int num = Integer.parseInt(st.nextToken());
                if(trueSet.contains(num)) {//진실을 알고 있는 사람이 파티에 포함되어있는가?
                    isNoticed = true;
                }else{
                    tempList.add(num);
                }
            }
            if(!isNoticed){//과장된 사실을 말할 수 있음.
                ans++;
                //과장된 사실을 알게된 쪽을 추가해야됨.
                explodeSet.addAll(tempList);
            }else{//진실을 말해야됨
                for(Integer num : tempList){
                    if(explodeSet.contains(num)){

                    }
                }
            }
        }
        System.out.println(ans);
    }
}
