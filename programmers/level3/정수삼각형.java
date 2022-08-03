class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][];
        
        int floorSize = triangle.length - 1;
        dp[floorSize] = new int[triangle[floorSize].length];
        for(int i = 0; i < triangle[floorSize].length; i++){
            dp[floorSize][i] += triangle[floorSize][i];
        }

        for(int i = triangle.length - 2 ; i >= 0; i--){
            dp[i] = new int[triangle[i].length];
            for(int j = 0; j < triangle[i].length; j++){
                dp[i][j] = triangle[i][j] + Math.max(dp[i+1][j], dp[i+1][j+1]); 
            }
        }
        return dp[0][0];
    }
}
