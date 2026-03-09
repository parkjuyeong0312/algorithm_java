import java.util.*;
import java.lang.*;
import java.io.*;

// 세계적인 호텔인 형택 호텔의 사장인 김형택은 이번에 수입을 조금 늘리기 위해서 홍보를 하려고 한다.
// 형택이가 홍보를 할 수 있는 도시가 주어지고, 각 도시별로 홍보하는데 드는 비용과, 그 때 몇 명의 호텔 고객이 늘어나는지에 대한 정보가 있다.
// 예를 들어, “어떤 도시에서 9원을 들여서 홍보하면 3명의 고객이 늘어난다.”와 같은 정보이다.
//이때, 이러한 정보에 나타난 돈에 정수배 만큼을 투자할 수 있다.
//즉, 9원을 들여서 3명의 고객, 18원을 들여서 6명의 고객, 27원을 들여서 9명의 고객을 늘어나게 할 수 있지만,
//3원을 들여서 홍보해서 1명의 고객, 12원을 들여서 4명의 고객을 늘어나게 할 수는 없다.
// 각 도시에는 무한 명의 잠재적인 고객이 있다. 
//이때, 호텔의 고객을 적어도 C명 늘이기 위해 형택이가 투자해야 하는 돈의 최솟값을 구하는 프로그램을 작성하시오.

// 입력
// 첫째 줄에 C와 형택이가 홍보할 수 있는 도시의 개수 N이 주어진다.
//C는 1,000보다 작거나 같은 자연수이고, N은 20보다 작거나 같은 자연수이다.
//둘째 줄부터 N개의 줄에는 각 도시에서 홍보할 때 대는 비용과 그 비용으로 얻을 수 있는 고객의 수가 주어진다.
//이 값은 100보다 작거나 같은 자연수이다.

//dp로 푸는 문제이고, 배낭문제의 변형이다.
//


// The main method must be in a class named "Main".
class Main {
    static int MAX_VALUE = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int target = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        ArrayList<int[]> cities = new ArrayList<>();

        //배낭문제를 이해해야함 ㅠㅠ 
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());

            cities.add(new int[]{cost,customer});
        }
        //한번에 진행되는 고객의 수와, 비용은 100이하다
        int[] dp = new int[target+100]; //따라서, 타겟-1 + 100을 하면 최댓값이 타겟+99이다.

        Arrays.fill(dp,MAX_VALUE);
        
        dp[0] = 0;

        //먼저 배수대로 채워놔야될까?
        //아니면 하나의 포지션을 정해놓고, 거기서 하나씩 실행해봐야되는걸까?
        //그냥 i번째 테이블이니까, i까지 쭉쭉 가는건가? ㄴㄴ -> 되는 경우의수를 다 봐야되는거임.
        //그리고 target~target+99까지의 최솟값을 구하면 됨.

        //그럼 i=0~target+99까지?

        //ㅇㅇ 그렇게해야될거같은데

        //dp[i] = i명의 고객을 확보하기 위한 비용의 최솟값

        for(int i=1; i<target+100; i++){
            for(int[] city : cities){
                int cost = city[0];
                int customer = city[1];
                if(i-customer<0) continue; //최적화 가능하지만 패스
                dp[i]=Math.min(dp[i],dp[i-customer]+cost);
            }
        }

        int ans = MAX_VALUE;
        for(int i=target; i<target+100; i++){
            ans=Math.min(ans,dp[i]);
        }

        System.out.println(ans);
        
    }
}





















