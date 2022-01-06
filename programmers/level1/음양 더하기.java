class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int index = 0; index < absolutes.length;index++){
            answer += absolutes[index]*(signs[index] ? 1 : -1);
        }
        return answer;
    }
}