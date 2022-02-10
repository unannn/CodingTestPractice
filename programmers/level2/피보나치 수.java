class Solution {
    
    public int solution(int n) {
        return fibonacci(n);
    }
    
    private int fibonacci(int number){
        int[] fibs = new int[number + 1];
        fibs[1] = 1;
        for(int i = 2;i <= number;i++){
            fibs[i] = (fibs[i - 1] % 1234567 + fibs[i - 2] % 1234567) % 1234567;
        }
        return fibs[number];
    }
}