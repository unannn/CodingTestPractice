class Solution {
    public int solution(int n) {
        int number = 0;
        for(int i = 1; i <= n / 2;i++){
            int sum = 0;
            for(int j = i; sum < n;j++){
                sum += j;
                if(sum == n){
                    number++;
                }
            }
        }
        return number+1;
    }
}