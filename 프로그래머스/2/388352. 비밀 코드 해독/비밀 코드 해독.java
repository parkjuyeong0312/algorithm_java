class Solution {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        int m = ans.length;
        //q에 대한 답이 ans에 있음.
        //1. 가설을 세운다.
        //2. 가설을 세운 값과 q값을 비교해보고, match를 한다.
        //3. 해당 match값과 ans를 비교하고 다르다면 break,/ 같다면 pass한다.
        boolean[][] isPresentInQ =  new boolean[m][n+1];
        
        for(int i=0; i<m; i++){
            for(int num : q[i]){
                isPresentInQ[i][num]=true;
            }
        }
        
        for(int a=1; a<=n-4; a++){
            for(int b=a+1; b<=n-3; b++){
                for(int c=b+1; c<=n-2; c++){
                    for(int d=c+1; d<=n-1;d++){
                        for(int e=d+1; e<=n;e++){
                            int[] currentComb = {a,b,c,d,e};
                            
                            boolean isAvailable = true;
                            
                            for(int i=0; i<m; i++){
                                int matchCount = 0;
                                for(int num : currentComb){
                                    if(isPresentInQ[i][num]) matchCount++;
                                }
                                if(matchCount!=ans[i]){
                                    isAvailable = false;
                                    break;
                                }
                            }
                            
                            if(isAvailable) answer++;
                            
                        }
                    }
                }
            }
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        return answer;
    }
}