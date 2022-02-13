class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        if(arr1[0].length != arr2.length){
            int[][] temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }
        int[][] answer = new int[arr1.length][arr2[0].length];
        for(int i = 0;i < arr1.length;i++){
            for(int j = 0;j < arr2[0].length;j++){
                int sum = 0;
                for (int k = 0; k < arr2.length; k++) {
                    sum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }
}