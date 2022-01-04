import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {

        Stack<Integer> basket = new Stack<Integer>();
        int answer = 0;

        for(int move : moves){
            for(int[] row : board){
                if(row[move - 1] != 0){
                    if(basket.size() == 0 || basket.peek() != row[move-1]){
                        basket.push(row[move - 1]);
                    }
                    else {
                        basket.pop();
                        answer += 2;
                    }
                    row[move - 1] = 0;
                    break;
                }
            }
        }

        return answer;
    }
}