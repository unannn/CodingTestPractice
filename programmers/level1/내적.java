class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for(int index = 0;index < a.length;index++){
            answer += a[index] * b[index];
        }
        return answer;
    }
}