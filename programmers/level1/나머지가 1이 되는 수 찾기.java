class Solution {
    public int solution(int n) {
        int i = 2;
        while(i < n){
            if(n % i == 1) break;
            i++;
        }
        return i;
    }
}