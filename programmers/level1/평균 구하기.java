import java.util.Arrays;

class Solution {
    public double solution(int[] arr) {
        return Arrays.stream(arr).sum() / (double)arr.length;
    }
}