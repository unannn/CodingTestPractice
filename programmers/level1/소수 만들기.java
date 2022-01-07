class Solution {
    private static final int DRAW_NUMBER = 3;
    private int answer;
    
    public int solution(int[] nums) {
        answer = 0;
        countPrimesNumber(nums,0,0,0);
        return answer;
    }

    private void countPrimesNumber(int[] nums,int begin, int depth, int sum){
        if(depth == DRAW_NUMBER){
            if(isPrime(sum)) answer++;
            return;
        }

        for(int index = begin;index  nums.length;index++){
            countPrimesNumber(nums, index+1, depth+1,sum+nums[index]);
        }
    }

    private boolean isPrime(int number){
        for(int index = 2;index = Math.sqrt(number);index++){
            if(number % index == 0) return false;
        }
        return true;
    }
}