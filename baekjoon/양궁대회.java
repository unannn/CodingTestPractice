import java.util.*;

class Solution {
    
    private static int max; 
    private static int limit;
    private static int[] answer;
    
    public int[] solution(int n, int[] info) {
        max = -1;
        limit = 0;
        for(int i = 0; i <= 10; i++){
            if(info[i] > 0){
                limit += 10 - i;   
            }
        }

        answer = new int[1];
        answer[0] = -1;
        
        comb(info, new int[11], n, 0, 0);

        return answer;
    }
    
    private void comb(int[] info, int[] arr, int n, int depth, int start){
        if(depth == n){
            int lion = 0;
            int apeach = 0;
            for(int i = 0; i <= 10; i++){
                if(info[i] < arr[i]){
                    lion += 10 - i;
                } else if(info[i] > 0){
                    apeach += 10 - i;
                }
            }
            if(lion >= apeach && lion - apeach >= max){
                max = lion - apeach;
                answer = Arrays.copyOf(arr, 11);
            }
            return;
        }
        for(int i = start; i < arr.length; i++){
            arr[i]++;
            comb(info, arr, n, depth + 1, i);
            arr[i]--;
        }
    }
}
