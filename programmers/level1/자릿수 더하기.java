public class Solution {
    public int solution(int n) {
        char[] charArray = String.valueOf(n).toCharArray();
        int sum = 0;
        for (int e : charArray) {
            sum += Character.digit(e,10);
        }
        return sum;
    }
}