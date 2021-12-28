class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int matchNumber = 0;
        int unknownNumber = 0;
            
        for(int l : lottos){
            if(l == 0) {
                ++unknownNumber;
                continue;
            }
            
            if(include(l,win_nums)){
                ++matchNumber;
            }
        }
        
        answer[1] = 7 - matchNumber;
        if(answer[1] > 6) answer[1] = 6;
        
        answer[0] = answer[1] - unknownNumber;
        if(answer[0] < 1) answer[0] = 1;
        
        return answer;
    }
    
    private boolean include(int lottoNumber,int[] win_nums){
        for(int winNumber:win_nums){
            if(lottoNumber == winNumber) return true;
        }
        
        return false;
    }
}