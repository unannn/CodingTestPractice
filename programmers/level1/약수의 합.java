class Solution {
    public int solution(int n) {
        int sum = 0;
        double sqrtN = Math.sqrt(n);
        for(int i = 1; i <= sqrtN;i++){
            if(n % i == 0){
                sum += i;
                if(n / i > sqrtN){
                    sum += n / i;
                }
            }
        }
        return sum;
    }
}