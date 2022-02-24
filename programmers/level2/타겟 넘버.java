class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, 1, numbers[0], target) + dfs(numbers, 1, -1 * numbers[0], target);
    }
    
    private int dfs(int[] numbers, int level, int sum, int target){
        if(level == numbers.length){
            if(sum == target){
                return 1;
            } else {
                return 0;
            }
        }else{
            return dfs(numbers, level + 1, sum + numbers[level], target) + dfs(numbers, level + 1, sum - numbers[level], target);
        }
    }
}